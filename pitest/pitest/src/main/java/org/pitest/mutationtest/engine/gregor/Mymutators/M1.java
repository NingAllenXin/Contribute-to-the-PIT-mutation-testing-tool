package org.pitest.mutationtest.engine.gregor.Mymutators;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.pitest.mutationtest.engine.MutationIdentifier;
import org.pitest.mutationtest.engine.gregor.MethodInfo;
import org.pitest.mutationtest.engine.gregor.MethodMutatorFactory;
import org.pitest.mutationtest.engine.gregor.MutationContext;
import org.objectweb.asm.Label;
import org.objectweb.asm.Type;
public class M1 implements MethodMutatorFactory {
   // M1_Dereference_mutator;

    @Override
    public MethodVisitor create(MutationContext context, MethodInfo methodInfo, MethodVisitor methodVisitor) {
        // TODO Auto-generated method stub
        int empty = 0;
        return new M1DereferenceVisitor(empty, methodVisitor, context);
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

class M1DereferenceVisitor extends MethodVisitor {
    private final MutationContext      context;
    
    M1DereferenceVisitor(int api, MethodVisitor mv, MutationContext context) {
        super(Opcodes.ASM6, mv);
        this.context = context;
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void visitFieldInsn(int opcode, String owner, String name, String desc) {
        if (opcode == Opcodes.GETFIELD) {
            Label dosuper = new Label();
            Label skipsuper = new Label();
            super.visitInsn(Opcodes.DUP); 
            super.visitJumpInsn(Opcodes.IFNONNULL, dosuper);
            final MutationIdentifier mutationId = this.context.registerMutation(new M1(),owner + "is null_getfield_M1");
            condition(desc);     //load on stack
            super.visitJumpInsn(Opcodes.GOTO, skipsuper);
            super.visitLabel(dosuper);
            super.visitFieldInsn(opcode, owner, name, desc);
            super.visitLabel(skipsuper);
           }
        if (opcode == Opcodes.PUTFIELD) {
            if (Type.getType(desc).getSize() == 1) {   //for int float
                Label dosuper = new Label();
                Label skipsuper = new Label();
                super.visitInsn(Opcodes.DUP2);
                super.visitInsn(Opcodes.POP);
                super.visitJumpInsn(Opcodes.IFNONNULL, dosuper);
                final MutationIdentifier mutationId = this.context.registerMutation(new M1(),owner + "is null_putfield_size1_M1");
                super.visitInsn(Opcodes.POP2);
                super.visitJumpInsn(Opcodes.GOTO, skipsuper);
                super.visitLabel(dosuper);
                super.visitFieldInsn(opcode, owner, name, desc);
                super.visitLabel(skipsuper);
                
            } else {  //for double and long
                Label dosuper = new Label();
                Label skipsuper = new Label();
                super.visitInsn(Opcodes.DUP2_X1);
                super.visitInsn(Opcodes.POP2);
                super.visitInsn(Opcodes.DUP);
                super.visitJumpInsn(Opcodes.IFNONNULL, dosuper);
                final MutationIdentifier mutationId = this.context.registerMutation(new M1(),owner + "is null_putfield_size2_M1");
                super.visitInsn(Opcodes.POP);
                super.visitInsn(Opcodes.POP2);
                super.visitJumpInsn(Opcodes.GOTO, skipsuper);
                super.visitLabel(dosuper);
                super.visitInsn(Opcodes.DUP_X2);
                super.visitInsn(Opcodes.POP);
                super.visitFieldInsn(opcode, owner, name, desc);
                super.visitLabel(skipsuper);
            }
            
        }
             
     }
    
        public void condition(String desc) {
            if (desc.equals("I") || desc.equals("Z") || desc.equals("C") || desc.equals("B") || desc.equals("S")) {
                super.visitInsn(Opcodes.ICONST_0);
            }
           
        if (desc.equals("D")) {
                super.visitInsn(Opcodes.DCONST_0);
            } 
        if (desc.equals("F")) {
            super.visitInsn(Opcodes.FCONST_0);
            } 
        if (desc.equals("J")) {   //long
            super.visitInsn(Opcodes.LCONST_0); 
               
        } else { //string or other
            super.visitInsn(Opcodes.ACONST_NULL);
        }
        }
    
   
}
