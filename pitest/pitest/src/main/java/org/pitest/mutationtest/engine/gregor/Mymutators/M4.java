package org.pitest.mutationtest.engine.gregor.mutators.Mymutators;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.pitest.mutationtest.engine.MutationIdentifier;
import org.pitest.mutationtest.engine.gregor.MethodInfo;
import org.pitest.mutationtest.engine.gregor.MethodMutatorFactory;
import org.pitest.mutationtest.engine.gregor.MutationContext;
import java.util.Random;
import java.util.ArrayList;

/*
 * M4 mutator i.e. replace a local variable by another local variable at random
 */

public enum M4 implements MethodMutatorFactory {
    M4;

    @Override
    public MethodVisitor create(final MutationContext context, final MethodInfo methodInfo,
            final MethodVisitor methodVisitor) {
        return new RandomVarReplacement1(this, context, methodVisitor);
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

class M4 extends MethodVisitor {
    private final MethodMutatorFactory factory;
    private final MutationContext context;
    List<Integer> variableIndex = new ArrayList<Integer>();
    List<String> variableType = new ArrayList<String>();
    int idxForRep;

    M4(final MethodMutatorFactory factory, final MutationContext context,
            final MethodVisitor delegateMethodVisitor) {
        super(Opcodes.ASM6, delegateMethodVisitor);
        this.factory = factory;
        this.context = context;
    }

    @Override
    public void visitVarInsn(final int opcode, final int var) {
        if (opcode == Opcodes.ILOAD || opcode == Opcodes.LLOAD || opcode == Opcodes.FLOAD || opcode == Opcodes.DLOAD
                || opcode == Opcodes.ALOAD) { // if load detected and a replacment for this variable has been chosen
            if (variableIndex.contains(var)) {
                int index = variableIndex.indexOf(var); // get index of the variable in our saved variable list

                Random random = new Random();
                idxForRep = random.nextInt(variableIndex.size()); // generate random index for replacment of variable

                int numberOfVariable = 0; // calculate the number of variables in the same type
                for (int i = 0; i < variableType.size(); i++) {
                    if (variableType.get(i).equals(variableType.get(index))) {
                        numberOfVariable++;
                    }
                }

                if (numberOfVariable > 1) {
                    while (!(variableType.get(idxForRep).equals(variableType.get(index))) || idxForRep == index)
                    // if random selection is the
                    // current variable OR selected
                    // one does not match type
                    {
                        idxForRep = random.nextInt(variableIndex.size()); // select a new variable at random
                    }
                }

                final MutationIdentifier newId = this.context.registerMutation(this.factory,
                        "Replaced " + variableType.get(index) + " with " + variableType.get(idxForRep));
                if (this.context.shouldMutate(newId)) {
                    super.visitVarInsn(opcode, variableIndex.get(idxForRep)); // find index of replacment var in our list, and use
                                                                 // that index to find index of the replacment variable
                                                                 // in localvar table
                } else {
                    super.visitVarInsn(opcode, var);
                }
            } else {
                super.visitVarInsn(opcode, var);
            }
        } else if (opcode == Opcodes.ISTORE || opcode == Opcodes.LSTORE || opcode == Opcodes.FSTORE
                || opcode == Opcodes.DSTORE || opcode == Opcodes.ASTORE) {
            if (!(variableIndex.contains(var))) {
                variableIndex.add(var);
                switch (opcode) {
                case Opcodes.ISTORE:
                    variableType.add("Integer");
                    break;
                case Opcodes.DSTORE:
                    variableType.add("Double");
                    break;
                case Opcodes.FSTORE:
                    variableType.add("Float");
                    break;
                case Opcodes.LSTORE:
                    variableType.add("Long");
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
