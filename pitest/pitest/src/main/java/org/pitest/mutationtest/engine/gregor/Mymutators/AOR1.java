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

public enum AOR1 implements MethodMutatorFactory {

  AOR_MUTATOR;

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
    MUTATIONS.put(Opcodes.IADD, new InsnSubstitution(Opcodes.ISUB,
            "Replaced integer addition with subtraction (AOR)"));
    
    MUTATIONS.put(Opcodes.ISUB, new InsnSubstitution(Opcodes.IADD,
            "Replaced integer subtraction with addition (AOR)"));
    
    MUTATIONS.put(Opcodes.IMUL, new InsnSubstitution(Opcodes.IADD,
            "Replaced integer multiplication with addition (AOR)"));
    
    MUTATIONS.put(Opcodes.IDIV, new InsnSubstitution(Opcodes.IADD,
            "Replaced integer division with addition (AOR)"));
    
    MUTATIONS.put(Opcodes.IREM, new InsnSubstitution(Opcodes.IADD,
            "Replaced integer modulus with addition (AOR)"));
    
//    MUTATIONS.put(Opcodes.IAND, new InsnSubstitution(Opcodes.IADD,
//            "Replaced integer modulus with addition (AOR)"));
//    
//    MUTATIONS.put(Opcodes.IOR, new InsnSubstitution(Opcodes.IADD,
//            "Replaced integer modulus with addition (AOR)"));
//    
//    MUTATIONS.put(Opcodes.IXOR, new InsnSubstitution(Opcodes.IADD,
//            "Replaced integer modulus with addition (AOR)"));
//   
//    MUTATIONS.put(Opcodes.ISHL, new InsnSubstitution(Opcodes.IADD,
//            "Replaced integer modulus with addition (AOR)"));
//    
//    MUTATIONS.put(Opcodes.ISHR, new InsnSubstitution(Opcodes.IADD,
//            "Replaced integer modulus with addition (AOR)"));
//    
//    MUTATIONS.put(Opcodes.IUSHR, new InsnSubstitution(Opcodes.IADD,
//            "Replaced integer modulus with addition (AOR)"));
   

    //Longs
    MUTATIONS.put(Opcodes.LADD, new InsnSubstitution(Opcodes.LSUB,
            "Replaced long addition with subtraction (AOR)"));
    
    MUTATIONS.put(Opcodes.LSUB, new InsnSubstitution(Opcodes.LADD,
            "Replaced long subtraction with addition (AOR)"));
    
    MUTATIONS.put(Opcodes.LMUL, new InsnSubstitution(Opcodes.LADD,
            "Replaced long multiplication with addition (AOR)"));
    
    MUTATIONS.put(Opcodes.LDIV, new InsnSubstitution(Opcodes.LADD,
            "Replaced long division with addition (AOR)"));
 
    MUTATIONS.put(Opcodes.LREM, new InsnSubstitution(Opcodes.LADD,
            "Replaced long modulus with addition (AOR)"));
    

    // Floats
    MUTATIONS.put(Opcodes.FADD, new InsnSubstitution(Opcodes.FSUB,
            "Replaced float addition with subtraction (AOR)"));
   
    MUTATIONS.put(Opcodes.FSUB, new InsnSubstitution(Opcodes.FADD,
            "Replaced float subtraction with addition (AOR)"));
    
    MUTATIONS.put(Opcodes.FMUL, new InsnSubstitution(Opcodes.FADD,
            "Replaced float multiplication with addition (AOR)"));
   
    MUTATIONS.put(Opcodes.FDIV, new InsnSubstitution(Opcodes.FADD,
            "Replaced float division with addition (AOR)"));

    MUTATIONS.put(Opcodes.FREM, new InsnSubstitution(Opcodes.FADD,
            "Replaced float modulus with addition (AOR)"));
   


    // Doubles
    MUTATIONS.put(Opcodes.DADD, new InsnSubstitution(Opcodes.DSUB,
            "Replaced double addition with subtraction (AOR)"));
   
    MUTATIONS.put(Opcodes.DSUB, new InsnSubstitution(Opcodes.DADD,
            "Replaced double subtraction with addition (AOR)"));
    
    MUTATIONS.put(Opcodes.DMUL, new InsnSubstitution(Opcodes.DADD,
            "Replaced double multiplication with addition (AOR)"));
   
    MUTATIONS.put(Opcodes.DDIV, new InsnSubstitution(Opcodes.DADD,
            "Replaced double division with addition (AOR)"));
    
    MUTATIONS.put(Opcodes.DREM, new InsnSubstitution(Opcodes.DADD,
            "Replaced double modulus with addition (AOR)"));


  }

  @Override
  protected Map<Integer, ZeroOperandMutation> getMutations() {
    return MUTATIONS;
  }

}
