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

public enum AOR4 implements MethodMutatorFactory {

  AOR_MUTATOR4;

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

class AOR4MethodVisitor extends AbstractInsnMutator {

  AOR4MethodVisitor(final MethodMutatorFactory factory,
                   final MethodInfo methodInfo, final MutationContext context,
                   final MethodVisitor writer) {
    super(factory, methodInfo, context, writer);
  }

  private static final Map<Integer, ZeroOperandMutation> MUTATIONS = new HashMap<Integer, ZeroOperandMutation>();

  static {
    //Ints
   
    MUTATIONS.put(Opcodes.IADD, new InsnSubstitution(Opcodes.IREM,
            "Replaced integer addition with modulus (AOR)"));
   
    MUTATIONS.put(Opcodes.ISUB, new InsnSubstitution(Opcodes.IREM,
            "Replaced integer subtraction with modulus (AOR)"));
   
    MUTATIONS.put(Opcodes.IMUL, new InsnSubstitution(Opcodes.IREM,
            "Replaced integer multiplication with modulus (AOR)"));
   
    MUTATIONS.put(Opcodes.IDIV, new InsnSubstitution(Opcodes.IREM,
            "Replaced integer division with modulus (AOR)"));
 
    MUTATIONS.put(Opcodes.IREM, new InsnSubstitution(Opcodes.IDIV,
            "Replaced integer modulus with division (AOR)"));
    
    MUTATIONS.put(Opcodes.IAND, new InsnSubstitution(Opcodes.IDIV,
            "Replaced integer modulus with division (AOR)"));
   
    MUTATIONS.put(Opcodes.IOR, new InsnSubstitution(Opcodes.IDIV,
            "Replaced integer modulus with division (AOR)"));
   
    MUTATIONS.put(Opcodes.IXOR, new InsnSubstitution(Opcodes.IDIV,
            "Replaced integer modulus with division (AOR)"));
    
    MUTATIONS.put(Opcodes.ISHL, new InsnSubstitution(Opcodes.IDIV,
            "Replaced integer modulus with division (AOR)"));
   
    MUTATIONS.put(Opcodes.ISHR, new InsnSubstitution(Opcodes.IDIV,
            "Replaced integer modulus with division (AOR)"));
   
    MUTATIONS.put(Opcodes.IUSHR, new InsnSubstitution(Opcodes.IDIV,
            "Replaced integer modulus with division (AOR)"));

    //Longs
   
    MUTATIONS.put(Opcodes.LADD, new InsnSubstitution(Opcodes.LREM,
            "Replaced long addition with modulus (AOR)"));
   
    MUTATIONS.put(Opcodes.LSUB, new InsnSubstitution(Opcodes.LREM,
            "Replaced long subtraction with modulus (AOR)"));
    
    MUTATIONS.put(Opcodes.LMUL, new InsnSubstitution(Opcodes.LREM,
            "Replaced long multiplication with modulus (AOR)"));
   
    MUTATIONS.put(Opcodes.LDIV, new InsnSubstitution(Opcodes.LREM,
            "Replaced long division with modulus (AOR)"));
 
    MUTATIONS.put(Opcodes.LREM, new InsnSubstitution(Opcodes.LDIV,
            "Replaced long modulus with division (AOR)"));

    // Floats
   
    MUTATIONS.put(Opcodes.FADD, new InsnSubstitution(Opcodes.FREM,
            "Replaced float addition with modulus (AOR)"));
    
    MUTATIONS.put(Opcodes.FSUB, new InsnSubstitution(Opcodes.FREM,
            "Replaced float subtraction with modulus (AOR)"));
    
    MUTATIONS.put(Opcodes.FMUL, new InsnSubstitution(Opcodes.FREM,
            "Replaced float multiplication with modulus (AOR)"));
    
    MUTATIONS.put(Opcodes.FDIV, new InsnSubstitution(Opcodes.FREM,
            "Replaced float division with modulus (AOR)"));
    
    MUTATIONS.put(Opcodes.FREM, new InsnSubstitution(Opcodes.FDIV,
            "Replaced float modulus with division (AOR)"));


    // Doubles
    
    MUTATIONS.put(Opcodes.DADD, new InsnSubstitution(Opcodes.DREM,
            "Replaced double addition with modulus (AOR)"));
    
    MUTATIONS.put(Opcodes.DSUB, new InsnSubstitution(Opcodes.DREM,
            "Replaced double subtraction with modulus (AOR)"));
   
    MUTATIONS.put(Opcodes.DMUL, new InsnSubstitution(Opcodes.DREM,
            "Replaced double multiplication with modulus (AOR)"));
   
    MUTATIONS.put(Opcodes.DDIV, new InsnSubstitution(Opcodes.DREM,
            "Replaced double division with modulus (AOR)"));
    
    MUTATIONS.put(Opcodes.DREM, new InsnSubstitution(Opcodes.DDIV,
            "Replaced double modulus with division (AOR)"));


  }

  @Override
  protected Map<Integer, ZeroOperandMutation> getMutations() {
    return MUTATIONS;
  }

}
