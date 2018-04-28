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

public enum BIT1 implements MethodMutatorFactory {

  BIT1;

  @Override
  public MethodVisitor create(final MutationContext context,
                              final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
    return new BITMethodVisitor1(this, methodInfo, context, methodVisitor);
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

class BITMethodVisitor1 extends AbstractInsnMutator {

  BITMethodVisitor1(final MethodMutatorFactory factory,
                    final MethodInfo methodInfo, final MutationContext context,
                    final MethodVisitor writer) {
    super(factory, methodInfo, context, writer);
  }

  private static final Map<Integer, ZeroOperandMutation> MUTATIONS = new HashMap<Integer, ZeroOperandMutation>();

  static {
    //Ints
    MUTATIONS.put(Opcodes.IAND, new InsnSubstitution(Opcodes.IOR,
           "Replaced bitwise AND with OR (BIT)"));
  
    MUTATIONS.put(Opcodes.IOR, new InsnSubstitution(Opcodes.IAND,
           "Replaced bitwise OR with AND (BIT)"));
  
    MUTATIONS.put(Opcodes.IXOR, new InsnSubstitution(Opcodes.IAND,
           "Replaced bitwise XOR with AND (BIT)"));
   
    MUTATIONS.put(Opcodes.ISHL, new InsnSubstitution(Opcodes.IAND,
           "Replaced bitwise SHL with AND (BIT)"));
  
    MUTATIONS.put(Opcodes.ISHR, new InsnSubstitution(Opcodes.IAND,
           "Replaced bitwise SHR with AND (BIT)"));
  
    MUTATIONS.put(Opcodes.IUSHR, new InsnSubstitution(Opcodes.IAND,
           "Replaced bitwise USHR with AND (BIT)"));


    //Longs
    MUTATIONS.put(Opcodes.LAND, new InsnSubstitution(Opcodes.LOR,
            "Replaced bitwise AND with OR (BIT)"));
    
    MUTATIONS.put(Opcodes.LOR, new InsnSubstitution(Opcodes.LAND,
            "Replaced bitwise OR with AND (BIT)"));
    
    MUTATIONS.put(Opcodes.LXOR, new InsnSubstitution(Opcodes.LAND,
            "Replaced bitwise XOR with AND (BIT)"));
    
    MUTATIONS.put(Opcodes.LSHL, new InsnSubstitution(Opcodes.LAND,
            "Replaced bitwise SHL with AND (BIT)"));
    
    MUTATIONS.put(Opcodes.LSHR, new InsnSubstitution(Opcodes.LAND,
            "Replaced bitwise SHR with AND (BIT)"));
    
    MUTATIONS.put(Opcodes.LUSHR, new InsnSubstitution(Opcodes.LAND,
            "Replaced bitwise USHR with AND (BIT)"));


  }

  @Override
  protected Map<Integer, ZeroOperandMutation> getMutations() {
    return MUTATIONS;
  }

}
