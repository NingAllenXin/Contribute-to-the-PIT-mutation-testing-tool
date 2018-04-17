package org.pitest.mutationtest.engine.gregor.Mymutators;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.pitest.mutationtest.engine.MutationIdentifier;
import org.pitest.mutationtest.engine.gregor.MethodInfo;
import org.pitest.mutationtest.engine.gregor.MethodMutatorFactory;
import org.pitest.mutationtest.engine.gregor.MutationContext;

public class MinusBeforeLoad implements MethodMutatorFactory {

    @Override
    public MethodVisitor create(MutationContext context, MethodInfo methodInfo, MethodVisitor methodVisitor) {
        return new MinusBeforeLoadVisitor(this, context, methodVisitor);
    }

    @Override
    public String getGloballyUniqueId() {
        // TODO Auto-generated method stub
        return this.getClass().getName();
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return toString();
    }

}
class MinusBeforeLoadVisitor extends MethodVisitor {
    
    private final MethodMutatorFactory factory;
    private final MutationContext      context;
    
    MinusBeforeLoadVisitor (final MethodMutatorFactory factory,
            final MutationContext context,
            final MethodVisitor delegateMethodVisitor) {
          super(Opcodes.ASM6, delegateMethodVisitor);
          this.context = context;
          this.factory = factory;
        }
    @Override
    public void visitVarInsn(final int opcode, final int var) {
        if (opcode == Opcodes.ILOAD) {
            final MutationIdentifier mutationId = this.context.registerMutation(this.factory,
                    "changed to --I");
            super.visitVarInsn(opcode,var);
            this.mv.visitInsn(Opcodes.ICONST_1);
            this.mv.visitInsn(Opcodes.ISUB);
            this.mv.visitVarInsn(Opcodes.ISTORE,var);
            super.visitVarInsn(opcode,var);
        } else if (opcode == Opcodes.DLOAD) {
            final MutationIdentifier mutationId = this.context.registerMutation(this.factory,
                    "changed to --D");
            super.visitVarInsn(opcode,var);
            this.mv.visitInsn(Opcodes.DCONST_1);
            this.mv.visitInsn(Opcodes.DSUB);
            this.mv.visitVarInsn(Opcodes.DSTORE,var);
            super.visitVarInsn(opcode,var);
        } else if (opcode == Opcodes.FLOAD) {
            final MutationIdentifier mutationId = this.context.registerMutation(this.factory,
                    "changed to --F");
            super.visitVarInsn(opcode,var);
            this.mv.visitInsn(Opcodes.FCONST_1);
            this.mv.visitInsn(Opcodes.FSUB);
            this.mv.visitVarInsn(Opcodes.FSTORE,var);
            super.visitVarInsn(opcode,var);
        } else if (opcode == Opcodes.LLOAD) {
            final MutationIdentifier mutationId = this.context.registerMutation(this.factory,
                    "changed to --L");
            super.visitVarInsn(opcode,var);
            this.mv.visitInsn(Opcodes.LCONST_1);
            this.mv.visitInsn(Opcodes.LSUB);
            this.mv.visitVarInsn(Opcodes.LSTORE, var);
            super.visitVarInsn(opcode,var);
        } else {
            super.visitVarInsn(opcode, var);
        }
    }
    }


