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

public enum AOR7 implements MethodMutatorFactory {

  AOR_MUTATOR7;

  @Override
  public MethodVisitor create(final MutationContext context,
                              final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
    return new AORMethodVisitor(this, methodInfo, context, methodVisitor);
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

class AOR7MethodVisitor extends AbstractInsnMutator {

  AOR7MethodVisitor(final MethodMutatorFactory factory,
                   final MethodInfo methodInfo, final MutationContext context,
                   final MethodVisitor writer) {
    super(factory, methodInfo, context, writer);
  }

  private static final Map<Integer, ZeroOperandMutation> MUTATIONS = new HashMap<Integer, ZeroOperandMutation>();

  static {
    //Ints
    
    MUTATIONS.put(Opcodes.IADD, new InsnSubstitution(Opcodes.IXOR,
            "Replaced integer addition with xor (AOR)"));
   
    MUTATIONS.put(Opcodes.ISUB, new InsnSubstitution(Opcodes.IXOR,
            "Replaced integer subtraction with xor (AOR)"));
   
    MUTATIONS.put(Opcodes.IMUL, new InsnSubstitution(Opcodes.IXOR,
            "Replaced integer multiplication with xor (AOR)"));
    
    MUTATIONS.put(Opcodes.IDIV, new InsnSubstitution(Opcodes.IXOR,
            "Replaced integer division with xor (AOR)"));
   
    MUTATIONS.put(Opcodes.IREM, new InsnSubstitution(Opcodes.IXOR,
            "Replaced integer modulus with xor (AOR)"));
  
    MUTATIONS.put(Opcodes.IAND, new InsnSubstitution(Opcodes.IXOR,
            "Replaced integer modulus with xor (AOR)"));
    
    MUTATIONS.put(Opcodes.IOR, new InsnSubstitution(Opcodes.IXOR,
            "Replaced integer modulus with xor (AOR)"));
   
    MUTATIONS.put(Opcodes.IXOR, new InsnSubstitution(Opcodes.IOR,
            "Replaced integer modulus with xor (AOR)"));
    
    MUTATIONS.put(Opcodes.ISHL, new InsnSubstitution(Opcodes.IOR,
            "Replaced integer modulus with xor (AOR)"));
    
    MUTATIONS.put(Opcodes.ISHR, new InsnSubstitution(Opcodes.IOR,
            "Replaced integer modulus with xor (AOR)"));
    
    MUTATIONS.put(Opcodes.IUSHR, new InsnSubstitution(Opcodes.IOR,
            "Replaced integer modulus with xor (AOR)"));


  }

  @Override
  protected Map<Integer, ZeroOperandMutation> getMutations() {
    return MUTATIONS;
  }

}
