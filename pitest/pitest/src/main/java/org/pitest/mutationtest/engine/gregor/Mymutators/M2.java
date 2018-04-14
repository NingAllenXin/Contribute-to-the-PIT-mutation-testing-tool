package org.pitest.mutationtest.engine.gregor.Mymutators;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.pitest.mutationtest.engine.gregor.MethodInfo;
import org.pitest.mutationtest.engine.gregor.MethodMutatorFactory;
import org.pitest.mutationtest.engine.gregor.MutationContext;


public class M2 implements MethodMutatorFactory {

    @Override
    public MethodVisitor create(MutationContext context, MethodInfo methodInfo, MethodVisitor methodVisitor) {
        // TODO Auto-generated method stub
        int empty = 0;
        return new M2SubsituteMethodVisitor(empty, methodVisitor, context);
    }

    @Override
    public String getGloballyUniqueId() {
        // TODO Auto-generated method stub
        return null;
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

       Methods classmethods = new Methods();
       
     M2SubsituteClassVisitor(int arg0) {
        super(arg0);
    }
     
     
     @Override
     public MethodVisitor visitMethod(int access, String name, String desc,
             String signature, String[] exceptions) {
             classmethods.owner = name;
             classmethods.methodinfo.add(new MethodInfo().withAccess(access).withMethodName(name).withMethodDescriptor(desc)); //override to get all methods
            //classmethods.methodinfo.add(new MethodInfo(new ClassInfo(0, 0, "", "", "", new String[0]),access,name,desc);

             return null;
     }
    
}
class M2SubsituteMethodVisitor extends MethodVisitor {
    private final MutationContext      context;
    Set<Methods> mset = new HashSet<>();
    
    M2SubsituteMethodVisitor(int api, MethodVisitor mv, MutationContext context) {
        super(Opcodes.ASM6, mv);
        this.context = context;
    }
    public void loadallmethods() {
        
    }
    public void findOverLoad(String owner, String name, String desc) {    //get all methods of an specific object according to the name
        if (mset.isEmpty()) {
            
        } else {   //return overload method
            ArrayList<MethodInfo> miSelectedList = new ArrayList<>();
            MethodInfo usingMethod = new MethodInfo();
            for (Methods m:mset) {
                //first find the using method
                if (m.owner.equals(owner)) {
                    usingMethod = findusingmethod(owner,name,desc,m.methodinfo);
                }
            }
            //check org.objectweb.asm.Type  
            //Returns the Java types corresponding to the argument types of the given method descriptor.
            Type [] typeofusingMehod = Type.getArgumentTypes(desc); //↑
            
            for (Methods m:mset) {
                //find override one according to using one
                if (m.owner.equals(owner)) {
                    for (MethodInfo mi : m.methodinfo) {
                        Type [] typeofoverload = Type.getArgumentTypes(mi.getMethodDescriptor());
                        if (mi.getName().equals(usingMethod.getName())
                               && mi.getReturnType().equals(usingMethod.getReturnType())
                               && typeofusingMehod.length != typeofoverload.length
                               && checktype(typeofusingMehod,typeofoverload)) {
                            miSelectedList.add(mi);
                        }
                    }
                }
            }
            
        }
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