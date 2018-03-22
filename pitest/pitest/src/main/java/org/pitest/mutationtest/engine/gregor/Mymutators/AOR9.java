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

public enum AOR9 implements MethodMutatorFactory {

  AOR_MUTATOR9;

  @Override
  public MethodVisitor create(final MutationContext context,
                              final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
    return new AOR9MethodVisitor(this, methodInfo, context, methodVisitor);
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

class AOR9MethodVisitor extends AbstractInsnMutator {

  AOR9MethodVisitor(final MethodMutatorFactory factory,
                   final MethodInfo methodInfo, final MutationContext context,
                   final MethodVisitor writer) {
    super(factory, methodInfo, context, writer);
  }

  private static final Map<Integer, ZeroOperandMutation> MUTATIONS = new HashMap<Integer, ZeroOperandMutation>();

  static {
    //Ints
    
    MUTATIONS.put(Opcodes.IADD, new InsnSubstitution(Opcodes.ISHR,
            "Replaced integer subtraction with arithmetic shift right (AOR)"));
    
    MUTATIONS.put(Opcodes.ISUB, new InsnSubstitution(Opcodes.ISHR,
            "Replaced integer subtraction with arithmetic shift right (AOR)"));
    
    MUTATIONS.put(Opcodes.IMUL, new InsnSubstitution(Opcodes.ISHR,
            "Replaced integer multiplication with arithmetic shift right (AOR)"));
    
    MUTATIONS.put(Opcodes.IDIV, new InsnSubstitution(Opcodes.ISHR,
            "Replaced integer division with arithmetic shift right (AOR)"));
    
    MUTATIONS.put(Opcodes.IREM, new InsnSubstitution(Opcodes.ISHR,
            "Replaced integer modulus with arithmetic shift right (AOR)"));
    
    MUTATIONS.put(Opcodes.IAND, new InsnSubstitution(Opcodes.ISHR,
            "Replaced integer modulus with arithmetic shift right (AOR)"));
    
    MUTATIONS.put(Opcodes.IOR, new InsnSubstitution(Opcodes.ISHR,
            "Replaced integer modulus with arithmetic shift right (AOR)"));
    
    MUTATIONS.put(Opcodes.IXOR, new InsnSubstitution(Opcodes.ISHR,
            "Replaced integer modulus with arithmetic shift right (AOR)"));
    
    MUTATIONS.put(Opcodes.ISHL, new InsnSubstitution(Opcodes.ISHR,
            "Replaced integer modulus with arithmetic shift right (AOR)"));

    MUTATIONS.put(Opcodes.ISHR, new InsnSubstitution(Opcodes.ISHL,
            "Replaced integer modulus with arithmetic shift right (AOR)"));
   
    MUTATIONS.put(Opcodes.IUSHR, new InsnSubstitution(Opcodes.ISHL,
            "Replaced integer modulus with arithmetic shift right (AOR)"));


  }

  @Override
  protected Map<Integer, ZeroOperandMutation> getMutations() {
    return MUTATIONS;
  }

}
