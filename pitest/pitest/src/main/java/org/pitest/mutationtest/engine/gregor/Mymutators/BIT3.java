package org.pitest.mutationtest.engine.gregor.Mymutators;

import org.objectweb.asm.MethodVisitor; 
import org.objectweb.asm.Opcodes;
import org.pitest.mutationtest.engine.gregor.AbstractInsnMutator;
import org.pitest.mutationtest.engine.gregor.InsnSubstitution;
import org.pitest.mutationtest.engine.gregor.MethodInfo;
import org.pitest.mutationtest.engine.gregor.MethodMutatorFactory;
import org.pitest.mutationtest.engine.gregor.MutationContext;
import org.pitest.mutationtest.engine.gregor.ZeroOperandMutation; 
import java.util.HashMap;
import java.util.Map;

public enum BIT3 implements MethodMutatorFactory {

  BIT3;

  @Override
  public MethodVisitor create(final MutationContext context,
                              final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
    return new BITMethodVisitor3(this, methodInfo, context, methodVisitor);
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

class BITMethodVisitor3 extends AbstractInsnMutator {

  BITMethodVisitor3(final MethodMutatorFactory factory,
                    final MethodInfo methodInfo, final MutationContext context,
                    final MethodVisitor writer) {
    super(factory, methodInfo, context, writer);
  }

  private static final Map<Integer, ZeroOperandMutation> MUTATIONS = new HashMap<Integer, ZeroOperandMutation>();

  static {
    //Ints

    MUTATIONS.put(Opcodes.IAND, new InsnSubstitution(Opcodes.ISHL,

           "Replaced bitwise AND with OR (BIT)"));

  

    MUTATIONS.put(Opcodes.IOR, new InsnSubstitution(Opcodes.ISHL,

           "Replaced bitwise OR with AND (BIT)"));




    MUTATIONS.put(Opcodes.IXOR, new InsnSubstitution(Opcodes.ISHL,

           "Replaced bitwise OR with AND (BIT)"));




    MUTATIONS.put(Opcodes.ISHL, new InsnSubstitution(Opcodes.IXOR,

           "Replaced bitwise OR with AND (BIT)"));




    MUTATIONS.put(Opcodes.ISHR, new InsnSubstitution(Opcodes.IXOR,

           "Replaced bitwise OR with AND (BIT)"));




    MUTATIONS.put(Opcodes.IUSHR, new InsnSubstitution(Opcodes.IXOR,

           "Replaced bitwise OR with AND (BIT)"));




    //Longs

    MUTATIONS.put(Opcodes.LAND, new InsnSubstitution(Opcodes.LSHL,

            "Replaced bitwise AND with OR (BIT)"));




    MUTATIONS.put(Opcodes.LOR, new InsnSubstitution(Opcodes.LSHL,

            "Replaced bitwise OR with AND (BIT)"));




    MUTATIONS.put(Opcodes.LXOR, new InsnSubstitution(Opcodes.LSHL,

            "Replaced bitwise OR with AND (BIT)"));




    MUTATIONS.put(Opcodes.LSHL, new InsnSubstitution(Opcodes.LXOR,

            "Replaced bitwise OR with AND (BIT)"));   




    MUTATIONS.put(Opcodes.LSHR, new InsnSubstitution(Opcodes.LXOR,

            "Replaced bitwise OR with AND (BIT)")); 




    MUTATIONS.put(Opcodes.LUSHR, new InsnSubstitution(Opcodes.LXOR,

            "Replaced bitwise OR with AND (BIT)"));



  }

  @Override
  protected Map<Integer, ZeroOperandMutation> getMutations() {
    return MUTATIONS;
  }

}

