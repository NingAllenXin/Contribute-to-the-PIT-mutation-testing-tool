package org.pitest.mutationtest.engine.gregor.Mymutators;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.pitest.mutationtest.engine.MutationIdentifier;
import org.pitest.mutationtest.engine.gregor.MethodInfo;
import org.pitest.mutationtest.engine.gregor.MethodMutatorFactory;
import org.pitest.mutationtest.engine.gregor.MutationContext;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

/*
 * M4 mutator i.e. replace a local variable by another local variable at random
 */

public enum M4 implements MethodMutatorFactory {
    M4;

    @Override
    public MethodVisitor create(final MutationContext context, final MethodInfo methodInfo,
            final MethodVisitor methodVisitor) {
        return new M4visitor(this, context, methodVisitor);
    }

    @Override
    public String getGloballyUniqueId() {
        return this.getClass().getName();
    }

    @Override
    public String getName() {
        return name();
    }
}

class M4visitor extends MethodVisitor {
    private final MethodMutatorFactory factory;
    private final MutationContext context;
    List<Integer> variableIndex = new ArrayList<Integer>();
    List<String> variableType = new ArrayList<String>();
    int idxForRep;

    M4visitor(final MethodMutatorFactory factory, final MutationContext context,
            final MethodVisitor delegateMethodVisitor) {
        super(Opcodes.ASM6, delegateMethodVisitor);
        this.factory = factory;
        this.context = context;
    }

    @Override
    public void visitVarInsn(final int opcode, final int var) {
        if (opcode == Opcodes.ILOAD || opcode == Opcodes.DLOAD || opcode == Opcodes.LLOAD || opcode == Opcodes.FLOAD || opcode == Opcodes.ALOAD) { 
            if (variableIndex.contains(var)) {
                int index = variableIndex.indexOf(var); 
                Random random = new Random();
                idxForRep = random.nextInt(variableIndex.size()); 
                int numberOfVariable = 0; // calculate the number of variables in the same type
                for (int i = 0; i < variableType.size(); i++) {
                    if (variableType.get(i).equals(variableType.get(index))) {
                        numberOfVariable++;
                    }
                }
                if (numberOfVariable > 1) {
                    while (!(variableType.get(idxForRep).equals(variableType.get(index))) || idxForRep == index) {
                        idxForRep = random.nextInt(variableIndex.size()); 
                    }
                }
                final MutationIdentifier newId = this.context.registerMutation(this.factory, "Variable of type" + variableType.get(index) + "has been changed to different local variable with same type");
                if (this.context.shouldMutate(newId)) {
                    super.visitVarInsn(opcode, variableIndex.get(idxForRep)); 
                } else {
                    super.visitVarInsn(opcode, var);
                }
            } else {
                super.visitVarInsn(opcode, var);
            }
        } else if (opcode == Opcodes.ISTORE || opcode == Opcodes.DSTORE || opcode == Opcodes.LSTORE || opcode == Opcodes.FSTORE || opcode == Opcodes.ASTORE) {
            if (!(variableIndex.contains(var))) {
                variableIndex.add(var);
                switch (opcode) {
                case Opcodes.ISTORE:
                    variableType.add("Integer");
                    break;
                case Opcodes.DSTORE:
                    variableType.add("Double");
                    break;
                case Opcodes.LSTORE:
                    variableType.add("Long");
                    break;
                case Opcodes.FSTORE:
                    variableType.add("Float");
                    break;
                case Opcodes.ASTORE:
                    variableType.add("Object");
                    break;
                }
            } else {
            }
            super.visitVarInsn(opcode, var);
        } else {
            super.visitVarInsn(opcode, var);
        }
    }
}
