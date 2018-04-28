package org.pitest.mutationtest.engine.gregor.Mymutators;

import java.io.IOException; 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.pitest.mutationtest.engine.gregor.MethodInfo;
import org.pitest.mutationtest.engine.gregor.MethodMutatorFactory;
import org.pitest.mutationtest.engine.gregor.MutationContext;


public class M2 implements MethodMutatorFactory {

    int methodindex;
    @Override
    public MethodVisitor create(MutationContext context, MethodInfo methodInfo, MethodVisitor methodVisitor) {
        // TODO Auto-generated method stub
        int empty = 0;
        return new M2SubsituteMethodVisitor(empty, methodVisitor, context,methodindex);
    }
    M2(int methodindex) {
        this.methodindex = methodindex;
    }
    @Override
    public String getGloballyUniqueId() {
        // TODO Auto-generated method stub
        return null;
    }
    public static Iterable<MethodMutatorFactory> makeMutators() {
        final List<MethodMutatorFactory> variations = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            variations.add(new M2(i));
        }
        return variations;
    }
    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }

}
class Methods {
    String owner;
    ArrayList<MethodInfo> methodinfo = new ArrayList<>();
}
class M2SubsituteClassVisitor extends ClassVisitor {   //to get all methods

    String name;
    Methods classmethods = new Methods();
    
       M2SubsituteClassVisitor(String name) {
           super(Opcodes.ASM6);
           this.name = name;
        // TODO Auto-generated constructor stub
    }
//       M2SubsituteClassVisitor() {
//           // TODO Auto-generated constructor stub
//           super(a);
//       }
    
       
//     M2SubsituteClassVisitor(int arg0) {
//        super(arg0);
//    }
     
     
     @Override
     public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
             classmethods.owner = name;
             classmethods.methodinfo.add(new MethodInfo().withAccess(access).withMethodName(
                     
                     name).withMethodDescriptor(desc)); //override to get all methods
            //classmethods.methodinfo.add(new MethodInfo(new ClassInfo(0, 0, "", "", "", new String[0]),access,name,desc);

             return null;
     }
    
}
class M2SubsituteMethodVisitor extends MethodVisitor {
    private final MutationContext      context;
    Set<Methods> mset = new HashSet<>();
    int methodindex;
    
    M2SubsituteMethodVisitor(int api, MethodVisitor mv, MutationContext context,int index) {
        super(Opcodes.ASM6, mv);
        this.context = context;
        this.methodindex = index;
    }
    
    @Override
    public void visitMethodInsn(int opcode, String owner, String name, 
            String desc, boolean itf) {
        ArrayList<MethodInfo> overloaded = findOverLoad(owner, name, desc);
        if (overloaded.size() <= methodindex) {
            super.visitMethodInsn(opcode, owner, name, desc, itf);
        } else {
            String newDesc = overloaded.get(methodindex).getMethodDescriptor();    //loaded first one        can be random!!!!!!!!!!!
                //mutateOverloadedMethodInsn(opcode, owner, name, desc, itf,newDesc);
        }
    }
    
    
    public void invokewithchangedinput(int opcode, String owner, String name, String olddesc, boolean itf, String newdesc) {
        Type[] oldType = Type.getArgumentTypes(olddesc);
        Type[] newType = Type.getArgumentTypes(newdesc);
        if (oldType.length < newType.length) {
            Type[]t1 = Arrays.copyOfRange(newType, oldType.length, newType.length);
            for (int i = 0;i < t1.length; i++) {
                String desc = t1[i].getDescriptor();
                    if (desc.equals("I") || desc.equals("Z") || desc.equals("C") || desc.equals("B") || desc.equals("S")) {
                        super.visitInsn(Opcodes.ICONST_0);
                    }  else if (desc.equals("D")) {
                        super.visitInsn(Opcodes.DCONST_0);
                    } else if (desc.equals("F")) {
                    super.visitInsn(Opcodes.FCONST_0);
                    } else if (desc.equals("J")) {   //long
                    super.visitInsn(Opcodes.LCONST_0); 
                } else { //string or other
                    super.visitInsn(Opcodes.ACONST_NULL);
                }
            }
        } else {
            Type[]t2 = Arrays.copyOfRange(oldType, newType.length, oldType.length);
            for (int i = t2.length - 1; i >= 0; i--) {
                if (t2[i].getSize() == 1) {
                    super.visitInsn(Opcodes.POP);
                } else {
                    super.visitInsn(Opcodes.POP2);
                }
            }  
        }
        super.visitMethodInsn(opcode, owner, name, newdesc, itf);
        
    }
    
    
//    public void loadallmethods() {
//        
//    }
    public ArrayList<MethodInfo> findOverLoad(String owner, String name, String desc) {    //get all methods of an specific object according to the name
        if (mset.isEmpty()) {
            ClassReader cr;
            try {
                cr = new ClassReader(owner);
                M2SubsituteClassVisitor cv = new M2SubsituteClassVisitor(name); //incomplete
                cr.accept(cv, 0);
                if (!mset.contains(owner)) {
                    if (mset.size() > 200) {   //flush memory
                        mset.clear();
                    }
                    Methods t = new Methods();
                    t = cv.classmethods;
                    mset.add(t);
                }
                //find using one==
                MethodInfo usingMethod = new MethodInfo();
                for (Methods m:mset) {
                    //1.first find the using method
                    if (m.owner.equals(owner)) {
                        usingMethod = findusingmethod(owner,name,desc,m.methodinfo);
                    }
                }
                //==
                return findloadmethodsofusingone(owner,name,desc,cv.classmethods.methodinfo, usingMethod);
               //imcomplete    add method accoriding to cv
                 
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {   //return overload method
            ArrayList<MethodInfo> miSelectedList = new ArrayList<>();
            MethodInfo usingMethod = new MethodInfo();
            for (Methods m:mset) {
                //1.first find the using method
                if (m.owner.equals(owner)) {
                    usingMethod = findusingmethod(owner,name,desc,m.methodinfo);
                }
            }
//notation 111111
            for (Methods m:mset) {
              //2.secondly find override one according to using one'name
                if (m.owner.equals(owner)) {
            miSelectedList = findloadmethodsofusingone(owner,name,desc,m.methodinfo,usingMethod);
                }
            }
            return miSelectedList;
        }
        return null;
    }
    //find override according to method name
    public ArrayList<MethodInfo> findloadmethodsofusingone(String owner, String name, String desc, ArrayList<MethodInfo> overload, MethodInfo usingMethod) {
        ArrayList<MethodInfo> returnmethods = new ArrayList<>();
      //check org.objectweb.asm.Type  
        //Returns the Java types corresponding to the argument types of the given method descriptor.
        Type [] typeofusingMehod = Type.getArgumentTypes(desc); //↑
                for (MethodInfo mi : overload) {
                    Type [] typeofoverload = Type.getArgumentTypes(mi.getMethodDescriptor());
                    if (mi.getName().equals(usingMethod.getName())
                           && mi.getReturnType().equals(usingMethod.getReturnType())
                           && typeofusingMehod.length != typeofoverload.length
                           && checktype(typeofusingMehod,typeofoverload)) {
                        returnmethods.add(mi);
                    }
                }
        return returnmethods;
    }
    //completed
    public MethodInfo findusingmethod(String owner, String name, String desc,ArrayList<MethodInfo> currentownerMethods) {
        MethodInfo mi = null;
        //check pitest/pitest/src/main/java/org/pitest/mutationtest/engine/gregor/MethodInfo.java
        for (MethodInfo temp:currentownerMethods) {
            //getMethodDescriptor, not description!
            if (temp.getMethodDescriptor().equals(desc) && temp.getName().equals(name)) {
                mi = temp;
                return mi;
            }
        }
        return mi;
    }
    //check type temperarily not needed
    public boolean checktype(Type[] using,Type[] ol) {
        return true;
    }
}




/*           111111111111 //check org.objectweb.asm.Type  
//Returns the Java types corresponding to the argument types of the given method descriptor.
//Type [] typeofusingMehod = Type.getArgumentTypes(desc); //↑
//
//for (Methods m:mset) {
//    //find override one according to using one
//    if (m.owner.equals(owner)) {
//        for (MethodInfo mi : m.methodinfo) {
//            Type [] typeofoverload = Type.getArgumentTypes(mi.getMethodDescriptor());
//            if (mi.getName().equals(usingMethod.getName())
//                   && mi.getReturnType().equals(usingMethod.getReturnType())
//                   && typeofusingMehod.length != typeofoverload.length
//                   && checktype(typeofusingMehod,typeofoverload)) {
//                miSelectedList.add(mi);
//            }
//        }
//    }
//}
*/