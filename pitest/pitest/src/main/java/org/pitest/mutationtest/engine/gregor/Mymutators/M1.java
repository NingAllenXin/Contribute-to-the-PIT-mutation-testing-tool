package org.pitest.mutationtest.engine.gregor.Mymutators;

import org.objectweb.asm.MethodVisitor; 
import org.objectweb.asm.Opcodes;
import org.pitest.mutationtest.engine.MutationIdentifier;
import org.pitest.mutationtest.engine.gregor.MethodInfo;
import org.pitest.mutationtest.engine.gregor.MethodMutatorFactory;
import org.pitest.mutationtest.engine.gregor.MutationContext;
import org.objectweb.asm.Label;
import org.objectweb.asm.Type;
public enum M1 implements MethodMutatorFactory {
    M1;

    @Override
    public MethodVisitor create(MutationContext context, MethodInfo methodInfo, MethodVisitor methodVisitor) {
        // TODO Auto-generated method stub
        return new M1DereferenceVisitor(this, context, methodVisitor);
    }

    @Override
    public String getGloballyUniqueId() {
        return this.getClass().getName() + "_" + getName();        
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return name();
    }

}

class M1DereferenceVisitor extends MethodVisitor {
    private final MethodMutatorFactory factory;
    private final MutationContext      context;
    
    M1DereferenceVisitor (final MethodMutatorFactory factory,
            final MutationContext context,
            final MethodVisitor delegateMethodVisitor) {
          super(Opcodes.ASM6, delegateMethodVisitor);
          this.context = context;
          this.factory = factory;
        }
    @Override
    public void visitFieldInsn(int opcode, String owner, String name, String desc) {
        final MutationIdentifier mutationId = this.context.registerMutation(this.factory,owner + "checked by_getfield_M1");
        if (opcode == Opcodes.GETFIELD) {
            Label dosuper = new Label();
            Label skipsuper = new Label();
            super.visitInsn(Opcodes.DUP);
            super.visitJumpInsn(Opcodes.IFNONNULL, dosuper);
            super.visitInsn(Opcodes.POP);
            condition(desc);     //load on stack
            super.visitJumpInsn(Opcodes.GOTO, skipsuper);
            super.visitLabel(dosuper);
            super.visitFieldInsn(opcode, owner, name, desc);
            super.visitLabel(skipsuper);
           }  else if (opcode == Opcodes.PUTFIELD) {
              if (Type.getType(desc).getSize() == 1) {   //for int float
                Label dosuper = new Label();
                Label skipsuper = new Label();
                super.visitInsn(Opcodes.DUP2);
                super.visitInsn(Opcodes.POP);
                super.visitJumpInsn(Opcodes.IFNONNULL, dosuper);
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
              super.visitInsn(Opcodes.DUP_X2);
              super.visitJumpInsn(Opcodes.IFNONNULL, dosuper);
              super.visitInsn(Opcodes.POP);
              super.visitInsn(Opcodes.POP2);
              super.visitJumpInsn(Opcodes.GOTO, skipsuper);
              super.visitLabel(dosuper);
//              super.visitInsn(Opcodes.DUP_X2);
//              super.visitInsn(Opcodes.POP);
              super.visitFieldInsn(opcode, owner, name, desc);
              super.visitLabel(skipsuper);
            }
        } else {
            super.visitFieldInsn(opcode, owner, name, desc);
        }
             
     }
    
        public void condition(String desc) {
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
    
   
}
