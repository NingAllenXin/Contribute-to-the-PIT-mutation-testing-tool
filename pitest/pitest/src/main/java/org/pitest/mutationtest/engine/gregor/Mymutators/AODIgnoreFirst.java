package org.pitest.mutationtest.engine.gregor.Mymutators;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.pitest.mutationtest.engine.gregor.MethodInfo;
import org.pitest.mutationtest.engine.gregor.MethodMutatorFactory;
import org.pitest.mutationtest.engine.gregor.MutationContext;

public class AODIgnoreFirst implements MethodMutatorFactory {
    

    @Override
    public MethodVisitor create(MutationContext context, MethodInfo methodInfo, MethodVisitor methodVisitor) {
        // TODO Auto-generated method stub
        return null;
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

    public final class AODigFirVisitor extends MethodVisitor {
        
        private final String               description;
        private final MutationContext      context;
        private final MethodMutatorFactory factory;
        
        AODigFirVisitor(final MethodMutatorFactory factory,
                final MutationContext context,
                final MethodVisitor delegateMethodVisitor, String description) {
              super(Opcodes.ASM6, delegateMethodVisitor);
              this.context = context;
              this.factory = factory;
              this.description = description;
            }
        
       @Override
       public void visitInsn(int bytecode) {
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
               super.visitInsn(Opcodes.SWAP);
               super.visitInsn(Opcodes.POP);
           }
           if ((bytecode == Opcodes.DADD) 
             || (bytecode == Opcodes.DSUB)
             || (bytecode == Opcodes.DMUL)
             || (bytecode == Opcodes.DDIV)
             || (bytecode == Opcodes.DREM)
             || (bytecode == Opcodes.LADD)
             || (bytecode == Opcodes.LSUB)
             || (bytecode == Opcodes.LMUL)
             || (bytecode == Opcodes.LDIV)
             || (bytecode == Opcodes.LREM)) {
                 super.visitInsn(Opcodes.DUP2_X2);
                 super.visitInsn(Opcodes.POP2);
                 super.visitInsn(Opcodes.POP2);
               
           } else {
               super.visitInsn(bytecode);
               }
           }
   

    }
}
