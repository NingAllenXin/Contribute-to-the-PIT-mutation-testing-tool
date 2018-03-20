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

public enum AOR8 implements MethodMutatorFactory {

  AOR_MUTATOR8;

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

class AOR8MethodVisitor extends AbstractInsnMutator {

  AOR8MethodVisitor(final MethodMutatorFactory factory,
                   final MethodInfo methodInfo, final MutationContext context,
                   final MethodVisitor writer) {
    super(factory, methodInfo, context, writer);
  }

  private static final Map<Integer, ZeroOperandMutation> MUTATIONS = new HashMap<Integer, ZeroOperandMutation>();

  static {
    //Ints
   
     MUTATIONS.put(Opcodes.IADD, new InsnSubstitution(Opcodes.ISHL,
            "Replaced integer addition with shift left (AOR)"));
    
     MUTATIONS.put(Opcodes.ISUB, new InsnSubstitution(Opcodes.ISHL,
            "Replaced integer subtraction with shift left (AOR)"));
    
     MUTATIONS.put(Opcodes.IMUL, new InsnSubstitution(Opcodes.ISHL,
            "Replaced integer multiplication with shift left (AOR)"));
   
     MUTATIONS.put(Opcodes.IDIV, new InsnSubstitution(Opcodes.ISHL,
            "Replaced integer division with shift left (AOR)"));
    
     MUTATIONS.put(Opcodes.IREM, new InsnSubstitution(Opcodes.ISHL,
            "Replaced integer modulus with shift left (AOR)"));
    
     MUTATIONS.put(Opcodes.IAND, new InsnSubstitution(Opcodes.ISHL,
            "Replaced integer modulus with shift left (AOR)"));
    
     MUTATIONS.put(Opcodes.IOR, new InsnSubstitution(Opcodes.ISHL,
            "Replaced integer modulus with shift left (AOR)"));
    
     MUTATIONS.put(Opcodes.IXOR, new InsnSubstitution(Opcodes.ISHL,
            "Replaced integer modulus with shift left (AOR)"));
    
     MUTATIONS.put(Opcodes.ISHL, new InsnSubstitution(Opcodes.IXOR,
            "Replaced integer modulus with shift left (AOR)"));
   
     MUTATIONS.put(Opcodes.ISHR, new InsnSubstitution(Opcodes.IXOR,
            "Replaced integer modulus with shift left (AOR)"));
    
     MUTATIONS.put(Opcodes.IUSHR, new InsnSubstitution(Opcodes.IXOR,
            "Replaced integer modulus with shift left (AOR)"));


  }

  @Override
  protected Map<Integer, ZeroOperandMutation> getMutations() {
    return MUTATIONS;
  }

}
