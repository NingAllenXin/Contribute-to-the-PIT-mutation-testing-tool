package org.pitest.mutationtest.engine.gregor.Mymutators;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.pitest.mutationtest.engine.MutationIdentifier;
import org.pitest.mutationtest.engine.gregor.MethodInfo;
import org.pitest.mutationtest.engine.gregor.MethodMutatorFactory;
import org.pitest.mutationtest.engine.gregor.MutationContext;

public class AODIgnoreFirst implements MethodMutatorFactory {
    

    @Override
    public MethodVisitor create(MutationContext context, MethodInfo methodInfo, MethodVisitor methodVisitor) {
        // TODO Auto-generated method stub
        return new AODigFirVisitor(this, context, methodVisitor);
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

    public final class AODigFirVisitor extends MethodVisitor {
        
        private final MutationContext      context;
        private final MethodMutatorFactory factory;
        
        AODigFirVisitor(final MethodMutatorFactory factory,
                final MutationContext context,
                final MethodVisitor delegateMethodVisitor) {
              super(Opcodes.ASM6, delegateMethodVisitor);
              this.context = context;
              this.factory = factory;
            }
        
       @Override
       public void visitInsn(final int bytecode) {
           if ((bytecode == Opcodes.IADD) 
             || (bytecode == Opcodes.ISUB)
             || (bytecode == Opcodes.IMUL)
             || (bytecode == Opcodes.IDIV)
             || (bytecode == Opcodes.IREM)
             || (bytecode == Opcodes.FADD)
             || (bytecode == Opcodes.FSUB)
             || (bytecode == Opcodes.FMUL)
             || (bytecode == Opcodes.FDIV)
             || (bytecode == Opcodes.FREM)) {
               final MutationIdentifier mutationId = this.context.registerMutation(new AODIgnoreFirst(),
                       "Keep second operand with SWAP");
               super.visitInsn(Opcodes.SWAP);
               super.visitInsn(Opcodes.POP);
           
           } else if ((bytecode == Opcodes.DADD) 
             || (bytecode == Opcodes.DSUB)
             || (bytecode == Opcodes.DMUL)
             || (bytecode == Opcodes.DDIV)
             || (bytecode == Opcodes.DREM)
             || (bytecode == Opcodes.LADD)
             || (bytecode == Opcodes.LSUB)
             || (bytecode == Opcodes.LMUL)
             || (bytecode == Opcodes.LDIV)
             || (bytecode == Opcodes.LREM)) {
               final MutationIdentifier mutationId = this.context.registerMutation(new AODIgnoreFirst(),
                       "Keep second operand with DUP2_X2");
                 super.visitInsn(Opcodes.DUP2_X2);
                 super.visitInsn(Opcodes.POP2);
                 super.visitInsn(Opcodes.POP2);
               
           } else {
               super.visitInsn(bytecode);
               }
           }
           

    }
}
