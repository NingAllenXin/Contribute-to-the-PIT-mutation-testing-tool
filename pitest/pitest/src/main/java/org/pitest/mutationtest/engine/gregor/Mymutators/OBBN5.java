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

public enum OBBN5 implements MethodMutatorFactory {

  OBBN5;

  @Override
  public MethodVisitor create(final MutationContext context,
                              final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
    return new OBBNMethodVisitor5(this, methodInfo, context, methodVisitor);
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

class OBBNMethodVisitor5 extends AbstractInsnMutator {

  OBBNMethodVisitor5(final MethodMutatorFactory factory,
                    final MethodInfo methodInfo, final MutationContext context,
                    final MethodVisitor writer) {
    super(factory, methodInfo, context, writer);
  }

  private static final Map<Integer, ZeroOperandMutation> MUTATIONS = new HashMap<Integer, ZeroOperandMutation>();

  static {
    //Ints
MUTATIONS.put(Opcodes.IAND, new InsnSubstitution(Opcodes.IUSHR,

           "Replaced bitwise AND with OR (AOR)"));

  

    MUTATIONS.put(Opcodes.IOR, new InsnSubstitution(Opcodes.IUSHR,

           "Replaced bitwise OR with AND (AOR)"));




    MUTATIONS.put(Opcodes.IXOR, new InsnSubstitution(Opcodes.IUSHR,

           "Replaced bitwise OR with AND (AOR)"));




    MUTATIONS.put(Opcodes.ISHL, new InsnSubstitution(Opcodes.IUSHR,

           "Replaced bitwise OR with AND (AOR)"));




    MUTATIONS.put(Opcodes.ISHR, new InsnSubstitution(Opcodes.IUSHR,

           "Replaced bitwise OR with AND (AOR)"));




    MUTATIONS.put(Opcodes.IUSHR, new InsnSubstitution(Opcodes.ISHR,

           "Replaced bitwise OR with AND (AOR)"));




    //Longs

    MUTATIONS.put(Opcodes.LAND, new InsnSubstitution(Opcodes.LUSHR,

            "Replaced bitwise AND with OR (OBBN)"));




    MUTATIONS.put(Opcodes.LOR, new InsnSubstitution(Opcodes.LUSHR,

            "Replaced bitwise OR with AND (OBBN)"));




    MUTATIONS.put(Opcodes.LXOR, new InsnSubstitution(Opcodes.LUSHR,

            "Replaced bitwise OR with AND (OBBN)"));




    MUTATIONS.put(Opcodes.LSHL, new InsnSubstitution(Opcodes.LUSHR,

            "Replaced bitwise OR with AND (OBBN)"));   




    MUTATIONS.put(Opcodes.LSHR, new InsnSubstitution(Opcodes.LUSHR,

            "Replaced bitwise OR with AND (OBBN)")); 




    MUTATIONS.put(Opcodes.LUSHR, new InsnSubstitution(Opcodes.LSHR,

            "Replaced bitwise OR with AND (OBBN)"));




  }

  @Override
  protected Map<Integer, ZeroOperandMutation> getMutations() {
    return MUTATIONS;
  }

}
