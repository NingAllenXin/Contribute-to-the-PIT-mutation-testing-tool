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
    MUTATIONS.put(Opcodes.IADD, new InsnSubstitution(Opcodes.IMUL,
            "Replaced integer addition with multiplication (AOR)"));
    MUTATIONS.put(Opcodes.IADD, new InsnSubstitution(Opcodes.IDIV,
            "Replaced integer addition with division (AOR)"));
    MUTATIONS.put(Opcodes.IADD, new InsnSubstitution(Opcodes.IREM,
            "Replaced integer addition with modulus (AOR)"));
    MUTATIONS.put(Opcodes.IADD, new InsnSubstitution(Opcodes.IAND,
            "Replaced integer addition with and (AOR)"));
    MUTATIONS.put(Opcodes.IADD, new InsnSubstitution(Opcodes.IOR,
            "Replaced integer addition with or (AOR)"));
    MUTATIONS.put(Opcodes.IADD, new InsnSubstitution(Opcodes.IXOR,
            "Replaced integer addition with xor (AOR)"));
    MUTATIONS.put(Opcodes.ISUB, new InsnSubstitution(Opcodes.IADD,
            "Replaced integer subtraction with addition (AOR)"));
    MUTATIONS.put(Opcodes.ISUB, new InsnSubstitution(Opcodes.IMUL,
            "Replaced integer subtraction with multiplication (AOR)"));
    MUTATIONS.put(Opcodes.ISUB, new InsnSubstitution(Opcodes.IDIV,
            "Replaced integer subtraction with division (AOR)"));
    MUTATIONS.put(Opcodes.ISUB, new InsnSubstitution(Opcodes.IREM,
            "Replaced integer subtraction with modulus (AOR)"));
    MUTATIONS.put(Opcodes.IMUL, new InsnSubstitution(Opcodes.IADD,
            "Replaced integer multiplication with addition (AOR)"));
    MUTATIONS.put(Opcodes.IMUL, new InsnSubstitution(Opcodes.ISUB,
            "Replaced integer multiplication with subtraction (AOR)"));
    MUTATIONS.put(Opcodes.IMUL, new InsnSubstitution(Opcodes.IDIV,
            "Replaced integer multiplication with division (AOR)"));
    MUTATIONS.put(Opcodes.IMUL, new InsnSubstitution(Opcodes.IREM,
            "Replaced integer multiplication with modulus (AOR)"));
    MUTATIONS.put(Opcodes.IDIV, new InsnSubstitution(Opcodes.IADD,
            "Replaced integer division with addition (AOR)"));
    MUTATIONS.put(Opcodes.IDIV, new InsnSubstitution(Opcodes.ISUB,
            "Replaced integer division with subtraction (AOR)"));
    MUTATIONS.put(Opcodes.IDIV, new InsnSubstitution(Opcodes.IMUL,
            "Replaced integer division with multiplication (AOR)"));
    MUTATIONS.put(Opcodes.IDIV, new InsnSubstitution(Opcodes.IREM,
            "Replaced integer division with modulus (AOR)"));
    MUTATIONS.put(Opcodes.IREM, new InsnSubstitution(Opcodes.IADD,
            "Replaced integer modulus with addition (AOR)"));
    MUTATIONS.put(Opcodes.IREM, new InsnSubstitution(Opcodes.ISUB,
            "Replaced integer modulus with subtraction (AOR)"));
    MUTATIONS.put(Opcodes.IREM, new InsnSubstitution(Opcodes.IMUL,
            "Replaced integer modulus with multiplication (AOR)"));
    MUTATIONS.put(Opcodes.IREM, new InsnSubstitution(Opcodes.IDIV,
            "Replaced integer modulus with division (AOR)"));

    //Longs
    MUTATIONS.put(Opcodes.LADD, new InsnSubstitution(Opcodes.LSUB,
            "Replaced long addition with subtraction (AOR)"));
    MUTATIONS.put(Opcodes.LADD, new InsnSubstitution(Opcodes.LMUL,
            "Replaced long addition with multiplication (AOR)"));
    MUTATIONS.put(Opcodes.LADD, new InsnSubstitution(Opcodes.LDIV,
            "Replaced long addition with division (AOR)"));
    MUTATIONS.put(Opcodes.LADD, new InsnSubstitution(Opcodes.LREM,
            "Replaced long addition with modulus (AOR)"));
    MUTATIONS.put(Opcodes.LSUB, new InsnSubstitution(Opcodes.LADD,
            "Replaced long subtraction with addition (AOR)"));
    MUTATIONS.put(Opcodes.LSUB, new InsnSubstitution(Opcodes.LMUL,
            "Replaced long subtraction with multiplication (AOR)"));
    MUTATIONS.put(Opcodes.LSUB, new InsnSubstitution(Opcodes.LDIV,
            "Replaced long subtraction with division (AOR)"));
    MUTATIONS.put(Opcodes.LSUB, new InsnSubstitution(Opcodes.LREM,
            "Replaced long subtraction with modulus (AOR)"));
    MUTATIONS.put(Opcodes.LMUL, new InsnSubstitution(Opcodes.LADD,
            "Replaced long multiplication with addition (AOR)"));
    MUTATIONS.put(Opcodes.LMUL, new InsnSubstitution(Opcodes.LSUB,
            "Replaced long multiplication with subtraction (AOR)"));
    MUTATIONS.put(Opcodes.LMUL, new InsnSubstitution(Opcodes.LDIV,
            "Replaced long multiplication with division (AOR)"));
    MUTATIONS.put(Opcodes.LMUL, new InsnSubstitution(Opcodes.LREM,
            "Replaced long multiplication with modulus (AOR)"));
    MUTATIONS.put(Opcodes.LDIV, new InsnSubstitution(Opcodes.LADD,
            "Replaced long division with addition (AOR)"));
    MUTATIONS.put(Opcodes.LDIV, new InsnSubstitution(Opcodes.LSUB,
            "Replaced long division with subtraction (AOR)"));
    MUTATIONS.put(Opcodes.LDIV, new InsnSubstitution(Opcodes.LMUL,
            "Replaced long division with multiplication (AOR)"));
    MUTATIONS.put(Opcodes.LDIV, new InsnSubstitution(Opcodes.LREM,
            "Replaced long division with modulus (AOR)"));
    MUTATIONS.put(Opcodes.LREM, new InsnSubstitution(Opcodes.LADD,
            "Replaced long modulus with addition (AOR)"));
    MUTATIONS.put(Opcodes.LREM, new InsnSubstitution(Opcodes.LSUB,
            "Replaced long modulus with subtraction (AOR)"));
    MUTATIONS.put(Opcodes.LREM, new InsnSubstitution(Opcodes.LMUL,
            "Replaced long modulus with multiplication (AOR)"));
    MUTATIONS.put(Opcodes.LREM, new InsnSubstitution(Opcodes.LDIV,
            "Replaced long modulus with division (AOR)"));

    // Floats
    MUTATIONS.put(Opcodes.FADD, new InsnSubstitution(Opcodes.FSUB,
            "Replaced float addition with subtraction (AOR)"));
    MUTATIONS.put(Opcodes.FADD, new InsnSubstitution(Opcodes.FMUL,
            "Replaced float addition with multiplication (AOR)"));
    MUTATIONS.put(Opcodes.FADD, new InsnSubstitution(Opcodes.FDIV,
            "Replaced float addition with division (AOR)"));
    MUTATIONS.put(Opcodes.FADD, new InsnSubstitution(Opcodes.FREM,
            "Replaced float addition with modulus (AOR)"));
    MUTATIONS.put(Opcodes.FSUB, new InsnSubstitution(Opcodes.FADD,
            "Replaced float subtraction with addition (AOR)"));
    MUTATIONS.put(Opcodes.FSUB, new InsnSubstitution(Opcodes.FMUL,
            "Replaced float subtraction with multiplication (AOR)"));
    MUTATIONS.put(Opcodes.FSUB, new InsnSubstitution(Opcodes.FDIV,
            "Replaced float subtraction with division (AOR)"));
    MUTATIONS.put(Opcodes.FSUB, new InsnSubstitution(Opcodes.FREM,
            "Replaced float subtraction with modulus (AOR)"));
    MUTATIONS.put(Opcodes.FMUL, new InsnSubstitution(Opcodes.FADD,
            "Replaced float multiplication with addition (AOR)"));
    MUTATIONS.put(Opcodes.FMUL, new InsnSubstitution(Opcodes.FSUB,
            "Replaced float multiplication with subtraction (AOR)"));
    MUTATIONS.put(Opcodes.FMUL, new InsnSubstitution(Opcodes.FDIV,
            "Replaced float multiplication with division (AOR)"));
    MUTATIONS.put(Opcodes.FMUL, new InsnSubstitution(Opcodes.FREM,
            "Replaced float multiplication with modulus (AOR)"));
    MUTATIONS.put(Opcodes.FDIV, new InsnSubstitution(Opcodes.FADD,
            "Replaced float division with addition (AOR)"));
    MUTATIONS.put(Opcodes.FDIV, new InsnSubstitution(Opcodes.FSUB,
            "Replaced float division with subtraction (AOR)"));
    MUTATIONS.put(Opcodes.FDIV, new InsnSubstitution(Opcodes.FMUL,
            "Replaced float division with multiplication (AOR)"));
    MUTATIONS.put(Opcodes.FDIV, new InsnSubstitution(Opcodes.FREM,
            "Replaced float division with modulus (AOR)"));
    MUTATIONS.put(Opcodes.FREM, new InsnSubstitution(Opcodes.FADD,
            "Replaced float modulus with addition (AOR)"));
    MUTATIONS.put(Opcodes.FREM, new InsnSubstitution(Opcodes.FSUB,
            "Replaced float modulus with subtraction (AOR)"));
    MUTATIONS.put(Opcodes.FREM, new InsnSubstitution(Opcodes.FMUL,
            "Replaced float modulus with multiplication (AOR)"));
    MUTATIONS.put(Opcodes.FREM, new InsnSubstitution(Opcodes.FDIV,
            "Replaced float modulus with division (AOR)"));


    // Doubles
    MUTATIONS.put(Opcodes.DADD, new InsnSubstitution(Opcodes.DSUB,
            "Replaced double addition with subtraction (AOR)"));
    MUTATIONS.put(Opcodes.DADD, new InsnSubstitution(Opcodes.DMUL,
            "Replaced double addition with multiplication (AOR)"));
    MUTATIONS.put(Opcodes.DADD, new InsnSubstitution(Opcodes.DDIV,
            "Replaced double addition with division (AOR)"));
    MUTATIONS.put(Opcodes.DADD, new InsnSubstitution(Opcodes.DREM,
            "Replaced double addition with modulus (AOR)"));
    MUTATIONS.put(Opcodes.DSUB, new InsnSubstitution(Opcodes.DADD,
            "Replaced double subtraction with addition (AOR)"));
    MUTATIONS.put(Opcodes.DSUB, new InsnSubstitution(Opcodes.DMUL,
            "Replaced double subtraction with multiplication (AOR)"));
    MUTATIONS.put(Opcodes.DSUB, new InsnSubstitution(Opcodes.DDIV,
            "Replaced double subtraction with division (AOR)"));
    MUTATIONS.put(Opcodes.DSUB, new InsnSubstitution(Opcodes.DREM,
            "Replaced double subtraction with modulus (AOR)"));
    MUTATIONS.put(Opcodes.DMUL, new InsnSubstitution(Opcodes.DADD,
            "Replaced double multiplication with addition (AOR)"));
    MUTATIONS.put(Opcodes.DMUL, new InsnSubstitution(Opcodes.DSUB,
            "Replaced double multiplication with subtraction (AOR)"));
    MUTATIONS.put(Opcodes.DMUL, new InsnSubstitution(Opcodes.DDIV,
            "Replaced double multiplication with division (AOR)"));
    MUTATIONS.put(Opcodes.DMUL, new InsnSubstitution(Opcodes.DREM,
            "Replaced double multiplication with modulus (AOR)"));
    MUTATIONS.put(Opcodes.DDIV, new InsnSubstitution(Opcodes.DADD,
            "Replaced double division with addition (AOR)"));
    MUTATIONS.put(Opcodes.DDIV, new InsnSubstitution(Opcodes.DSUB,
            "Replaced double division with subtraction (AOR)"));
    MUTATIONS.put(Opcodes.DDIV, new InsnSubstitution(Opcodes.DMUL,
            "Replaced double division with multiplication (AOR)"));
    MUTATIONS.put(Opcodes.DDIV, new InsnSubstitution(Opcodes.DREM,
            "Replaced double division with modulus (AOR)"));
    MUTATIONS.put(Opcodes.DREM, new InsnSubstitution(Opcodes.DADD,
            "Replaced double modulus with addition (AOR)"));
    MUTATIONS.put(Opcodes.DREM, new InsnSubstitution(Opcodes.DSUB,
            "Replaced double modulus with subtraction (AOR)"));
    MUTATIONS.put(Opcodes.DREM, new InsnSubstitution(Opcodes.DMUL,
            "Replaced double modulus with multiplication (AOR)"));
    MUTATIONS.put(Opcodes.DREM, new InsnSubstitution(Opcodes.DDIV,
            "Replaced double modulus with division (AOR)"));


  }

  @Override
  protected Map<Integer, ZeroOperandMutation> getMutations() {
    return MUTATIONS;
  }

}
