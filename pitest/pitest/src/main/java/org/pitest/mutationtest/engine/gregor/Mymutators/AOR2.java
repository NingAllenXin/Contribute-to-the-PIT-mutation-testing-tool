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

public enum AOR implements MethodMutatorFactory {

  AOR_MUTATOR2;

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

class AORMethodVisitor extends AbstractInsnMutator {

  AORMethodVisitor(final MethodMutatorFactory factory,
                   final MethodInfo methodInfo, final MutationContext context,
                   final MethodVisitor writer) {
    super(factory, methodInfo, context, writer);
  }

  private static final Map<Integer, ZeroOperandMutation> MUTATIONS = new HashMap<Integer, ZeroOperandMutation>();

  static {
    //Ints
    MUTATIONS.put(Opcodes.IADD, new InsnSubstitution(Opcodes.IMUL,
            "Replaced integer addition with multiplication (AOR)"));
    MUTATIONS.put(Opcodes.ISUB, new InsnSubstitution(Opcodes.IMUL,
            "Replaced integer subtraction with multiplication (AOR)"));
    MUTATIONS.put(Opcodes.IMUL, new InsnSubstitution(Opcodes.ISUB,
            "Replaced integer multiplication with subtraction (AOR)"));
    MUTATIONS.put(Opcodes.IDIV, new InsnSubstitution(Opcodes.ISUB,
            "Replaced integer division with subtraction (AOR)"));
    MUTATIONS.put(Opcodes.IREM, new InsnSubstitution(Opcodes.ISUB,
            "Replaced integer modulus with subtraction (AOR)"));
    MUTATIONS.put(Opcodes.IAND, new InsnSubstitution(Opcodes.ISUB,
            "Replaced integer modulus with subtraction (AOR)"));
    MUTATIONS.put(Opcodes.IOR, new InsnSubstitution(Opcodes.ISUB,
            "Replaced integer modulus with subtraction (AOR)"));
    MUTATIONS.put(Opcodes.IXOR, new InsnSubstitution(Opcodes.ISUB,
            "Replaced integer modulus with subtraction (AOR)"));
    MUTATIONS.put(Opcodes.ISHL, new InsnSubstitution(Opcodes.ISUB,
            "Replaced integer modulus with subtraction (AOR)"));
    MUTATIONS.put(Opcodes.ISHR, new InsnSubstitution(Opcodes.ISUB,
            "Replaced integer modulus with subtraction (AOR)"));

    //Longs
    MUTATIONS.put(Opcodes.LADD, new InsnSubstitution(Opcodes.LMUL,
            "Replaced long addition with multiplication (AOR)"));
    MUTATIONS.put(Opcodes.LSUB, new InsnSubstitution(Opcodes.LMUL,
            "Replaced long subtraction with multiplication (AOR)"));
    MUTATIONS.put(Opcodes.LMUL, new InsnSubstitution(Opcodes.LSUB,
            "Replaced long multiplication with subtraction (AOR)"));
    MUTATIONS.put(Opcodes.LDIV, new InsnSubstitution(Opcodes.LSUB,
            "Replaced long division with subtraction (AOR)"));
    MUTATIONS.put(Opcodes.LREM, new InsnSubstitution(Opcodes.LSUB,
            "Replaced long modulus with subtraction (AOR)"));

    // Floats
    MUTATIONS.put(Opcodes.FADD, new InsnSubstitution(Opcodes.FMUL,
            "Replaced float addition with multiplication (AOR)"));
    MUTATIONS.put(Opcodes.FSUB, new InsnSubstitution(Opcodes.FMUL,
            "Replaced float subtraction with multiplication (AOR)"));
   
    MUTATIONS.put(Opcodes.FMUL, new InsnSubstitution(Opcodes.FSUB,
            "Replaced float multiplication with subtraction (AOR)"));
 
    MUTATIONS.put(Opcodes.FDIV, new InsnSubstitution(Opcodes.FSUB,
            "Replaced float division with subtraction (AOR)"));
   
    MUTATIONS.put(Opcodes.FREM, new InsnSubstitution(Opcodes.FSUB,
            "Replaced float modulus with subtraction (AOR)"));
 


    // Doubles
    
    MUTATIONS.put(Opcodes.DADD, new InsnSubstitution(Opcodes.DMUL,
            "Replaced double addition with multiplication (AOR)"));
    
    MUTATIONS.put(Opcodes.DSUB, new InsnSubstitution(Opcodes.DMUL,
            "Replaced double subtraction with multiplication (AOR)"));
    
    MUTATIONS.put(Opcodes.DMUL, new InsnSubstitution(Opcodes.DSUB,
            "Replaced double multiplication with subtraction (AOR)"));
    
    MUTATIONS.put(Opcodes.DDIV, new InsnSubstitution(Opcodes.DSUB,
            "Replaced double division with subtraction (AOR)"));
  
    MUTATIONS.put(Opcodes.DREM, new InsnSubstitution(Opcodes.DSUB,
            "Replaced double modulus with subtraction (AOR)"));
  


  }

  @Override
  protected Map<Integer, ZeroOperandMutation> getMutations() {
    return MUTATIONS;
  }

}
