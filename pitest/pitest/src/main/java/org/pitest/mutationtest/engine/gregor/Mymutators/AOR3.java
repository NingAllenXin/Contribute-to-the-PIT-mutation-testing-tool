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

public enum AOR3 implements MethodMutatorFactory {

  AOR_MUTATOR3;

  @Override
  public MethodVisitor create(final MutationContext context,
                              final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
    return new AOR3MethodVisitor(this, methodInfo, context, methodVisitor);
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

class AOR3MethodVisitor extends AbstractInsnMutator {

  AOR3MethodVisitor(final MethodMutatorFactory factory,
                   final MethodInfo methodInfo, final MutationContext context,
                   final MethodVisitor writer) {
    super(factory, methodInfo, context, writer);
  }

  private static final Map<Integer, ZeroOperandMutation> MUTATIONS = new HashMap<Integer, ZeroOperandMutation>();

  static {
    //Ints
    
    MUTATIONS.put(Opcodes.IADD, new InsnSubstitution(Opcodes.IDIV,
            "Replaced integer addition with division (AOR)"));
    
    MUTATIONS.put(Opcodes.ISUB, new InsnSubstitution(Opcodes.IDIV,
            "Replaced integer subtraction with division (AOR)"));
    
    MUTATIONS.put(Opcodes.IMUL, new InsnSubstitution(Opcodes.IDIV,
            "Replaced integer multiplication with division (AOR)"));
    
    MUTATIONS.put(Opcodes.IDIV, new InsnSubstitution(Opcodes.IMUL,
            "Replaced integer division with multiplication (AOR)"));
    
    MUTATIONS.put(Opcodes.IREM, new InsnSubstitution(Opcodes.IMUL,
            "Replaced integer modulus with multiplication (AOR)"));
    
    MUTATIONS.put(Opcodes.IAND, new InsnSubstitution(Opcodes.IMUL,
            "Replaced integer modulus with multiplication (AOR)"));
    
    MUTATIONS.put(Opcodes.IOR, new InsnSubstitution(Opcodes.IMUL,
            "Replaced integer modulus with multiplication (AOR)"));
    
    MUTATIONS.put(Opcodes.IXOR, new InsnSubstitution(Opcodes.IMUL,
            "Replaced integer modulus with multiplication (AOR)"));
    
    MUTATIONS.put(Opcodes.ISHL, new InsnSubstitution(Opcodes.IMUL,
            "Replaced integer modulus with multiplication (AOR)"));
    
    MUTATIONS.put(Opcodes.ISHR, new InsnSubstitution(Opcodes.IMUL,
            "Replaced integer modulus with multiplication (AOR)"));
    
    MUTATIONS.put(Opcodes.IUSHR, new InsnSubstitution(Opcodes.IMUL,
            "Replaced integer modulus with multiplication (AOR)"));
    

    //Longs

    MUTATIONS.put(Opcodes.LADD, new InsnSubstitution(Opcodes.LDIV,
            "Replaced long addition with division (AOR)"));
  
    MUTATIONS.put(Opcodes.LSUB, new InsnSubstitution(Opcodes.LDIV,
            "Replaced long subtraction with division (AOR)"));
    
    MUTATIONS.put(Opcodes.LMUL, new InsnSubstitution(Opcodes.LDIV,
            "Replaced long multiplication with division (AOR)"));
   
    MUTATIONS.put(Opcodes.LDIV, new InsnSubstitution(Opcodes.LMUL,
            "Replaced long division with multiplication (AOR)"));
    
    MUTATIONS.put(Opcodes.LREM, new InsnSubstitution(Opcodes.LMUL,
            "Replaced long modulus with multiplication (AOR)"));
    

    // Floats
    
    MUTATIONS.put(Opcodes.FADD, new InsnSubstitution(Opcodes.FDIV,
            "Replaced float addition with division (AOR)"));
    
    MUTATIONS.put(Opcodes.FSUB, new InsnSubstitution(Opcodes.FDIV,
            "Replaced float subtraction with division (AOR)"));
    
    MUTATIONS.put(Opcodes.FMUL, new InsnSubstitution(Opcodes.FDIV,
            "Replaced float multiplication with division (AOR)"));
    
    MUTATIONS.put(Opcodes.FDIV, new InsnSubstitution(Opcodes.FMUL,
            "Replaced float division with multiplication (AOR)"));
   
    MUTATIONS.put(Opcodes.FREM, new InsnSubstitution(Opcodes.FMUL,
            "Replaced float modulus with multiplication (AOR)"));


    // Doubles
    
    MUTATIONS.put(Opcodes.DADD, new InsnSubstitution(Opcodes.DDIV,
            "Replaced double addition with division (AOR)"));
    
    MUTATIONS.put(Opcodes.DSUB, new InsnSubstitution(Opcodes.DDIV,
            "Replaced double subtraction with division (AOR)"));
    
    MUTATIONS.put(Opcodes.DMUL, new InsnSubstitution(Opcodes.DDIV,
            "Replaced double multiplication with division (AOR)"));
    
    MUTATIONS.put(Opcodes.DDIV, new InsnSubstitution(Opcodes.DMUL,
            "Replaced double division with multiplication (AOR)"));
   
    MUTATIONS.put(Opcodes.DREM, new InsnSubstitution(Opcodes.DMUL,
            "Replaced double modulus with multiplication (AOR)"));
 
  }

  @Override
  protected Map<Integer, ZeroOperandMutation> getMutations() {
    return MUTATIONS;
  }

}
