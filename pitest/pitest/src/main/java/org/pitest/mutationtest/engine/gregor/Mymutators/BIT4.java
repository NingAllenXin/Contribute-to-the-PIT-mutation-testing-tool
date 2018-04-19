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

public enum BIT4 implements MethodMutatorFactory {

  BIT4;

  @Override
  public MethodVisitor create(final MutationContext context,
                              final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
    return new BITMethodVisitor4(this, methodInfo, context, methodVisitor);
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

class BITMethodVisitor4 extends AbstractInsnMutator {

  BITMethodVisitor4(final MethodMutatorFactory factory,
                    final MethodInfo methodInfo, final MutationContext context,
                    final MethodVisitor writer) {
    super(factory, methodInfo, context, writer);
  }

  private static final Map<Integer, ZeroOperandMutation> MUTATIONS = new HashMap<Integer, ZeroOperandMutation>();

  static {
    //Ints

    MUTATIONS.put(Opcodes.IAND, new InsnSubstitution(Opcodes.ISHR,

           "Replaced bitwise AND with OR (BIT)"));

  

    MUTATIONS.put(Opcodes.IOR, new InsnSubstitution(Opcodes.ISHR,

           "Replaced bitwise OR with AND (BIT)"));




    MUTATIONS.put(Opcodes.IXOR, new InsnSubstitution(Opcodes.ISHR,

           "Replaced bitwise OR with AND (BIT)"));




    MUTATIONS.put(Opcodes.ISHL, new InsnSubstitution(Opcodes.ISHR,

           "Replaced bitwise OR with AND (BIT)"));




    MUTATIONS.put(Opcodes.ISHR, new InsnSubstitution(Opcodes.ISHL,

           "Replaced bitwise OR with AND (BIT)"));




    MUTATIONS.put(Opcodes.IUSHR, new InsnSubstitution(Opcodes.ISHL,

           "Replaced bitwise OR with AND (BIT)"));




    //Longs

    MUTATIONS.put(Opcodes.LAND, new InsnSubstitution(Opcodes.LSHR,

            "Replaced bitwise AND with OR (BIT)"));




    MUTATIONS.put(Opcodes.LOR, new InsnSubstitution(Opcodes.LSHR,

            "Replaced bitwise OR with AND (BIT)"));




    MUTATIONS.put(Opcodes.LXOR, new InsnSubstitution(Opcodes.LSHR,

            "Replaced bitwise OR with AND (BIT)"));




    MUTATIONS.put(Opcodes.LSHL, new InsnSubstitution(Opcodes.LSHR,

            "Replaced bitwise OR with AND (BIT)"));   




    MUTATIONS.put(Opcodes.LSHR, new InsnSubstitution(Opcodes.LSHL,

            "Replaced bitwise OR with AND (BIT)")); 




    MUTATIONS.put(Opcodes.LUSHR, new InsnSubstitution(Opcodes.LSHL,

            "Replaced bitwise OR with AND (BIT)"));



  }

  @Override
  protected Map<Integer, ZeroOperandMutation> getMutations() {
    return MUTATIONS;
  }

}

ne.gregor.InsnSubstitution;
import org.pitest.mutationtest.engine.gregor.MethodInfo;
import org.pitest.mutationtest.engine.gregor.MethodMutatorFactory;
import org.pitest.mutationtest.engine.gregor.MutationContext;
import org.pitest.mutationtest.engine.gregor.ZeroOperandMutation; 
import java.util.HashMap;
import java.util.Map;

public enum OBBN4 implements MethodMutatorFactory {

  OBBN4;

  @Override
  public MethodVisitor create(final MutationContext context,
                              final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
    return new OBBNMethodVisitor4(this, methodInfo, context, methodVisitor);
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

class OBBNMethodVisitor4 extends AbstractInsnMutator {

  OBBNMethodVisitor4(final MethodMutatorFactory factory,
                    final MethodInfo methodInfo, final MutationContext context,
                    final MethodVisitor writer) {
    super(factory, methodInfo, context, writer);
  }

  private static final Map<Integer, ZeroOperandMutation> MUTATIONS = new HashMap<Integer, ZeroOperandMutation>();

  static {
    //Ints

    MUTATIONS.put(Opcodes.IAND, new InsnSubstitution(Opcodes.ISHR,

           "Replaced bitwise AND with OR (AOR)"));

  

    MUTATIONS.put(Opcodes.IOR, new InsnSubstitution(Opcodes.ISHR,

           "Replaced bitwise OR with AND (AOR)"));




    MUTATIONS.put(Opcodes.IXOR, new InsnSubstitution(Opcodes.ISHR,

           "Replaced bitwise OR with AND (AOR)"));




    MUTATIONS.put(Opcodes.ISHL, new InsnSubstitution(Opcodes.ISHR,

           "Replaced bitwise OR with AND (AOR)"));




    MUTATIONS.put(Opcodes.ISHR, new InsnSubstitution(Opcodes.ISHL,

           "Replaced bitwise OR with AND (AOR)"));




    MUTATIONS.put(Opcodes.IUSHR, new InsnSubstitution(Opcodes.ISHL,

           "Replaced bitwise OR with AND (AOR)"));




    //Longs

    MUTATIONS.put(Opcodes.LAND, new InsnSubstitution(Opcodes.LSHR,

            "Replaced bitwise AND with OR (OBBN)"));




    MUTATIONS.put(Opcodes.LOR, new InsnSubstitution(Opcodes.LSHR,

            "Replaced bitwise OR with AND (OBBN)"));




    MUTATIONS.put(Opcodes.LXOR, new InsnSubstitution(Opcodes.LSHR,

            "Replaced bitwise OR with AND (OBBN)"));




    MUTATIONS.put(Opcodes.LSHL, new InsnSubstitution(Opcodes.LSHR,

            "Replaced bitwise OR with AND (OBBN)"));   




    MUTATIONS.put(Opcodes.LSHR, new InsnSubstitution(Opcodes.LSHL,

            "Replaced bitwise OR with AND (OBBN)")); 




    MUTATIONS.put(Opcodes.LUSHR, new InsnSubstitution(Opcodes.LSHL,

            "Replaced bitwise OR with AND (OBBN)"));



  }

  @Override
  protected Map<Integer, ZeroOperandMutation> getMutations() {
    return MUTATIONS;
  }

}
