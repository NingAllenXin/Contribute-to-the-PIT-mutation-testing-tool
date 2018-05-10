# CS6367
Contribute to the PIT mutation testing tool to implement more mutation operators.

The description of the original set of mutation operators implemented in PIT is available at: http://pitest.org/quickstart/mutators/

However, it does not include some traditional mutation operators. You need to first understand the ASM 
bytecode engineering framework, the JavaAgent on-the-fly code instrumentation, and the Maven build system (recommended for running PIT); then augment the PIT tool to implement the following mutation operators, and evaluate the augmented PIT tool on 5 real-world 
projects from GitHub (with >1000 lines of code and > 50 tests): 

a. AOD: Replaces an arithmetic expression by each one of the operand, 

b. ROR: Replaces the relational operators with each of the other ones. It applies every replacement

c. AOR: Replaces an arithmetic expression by each of the other ones

Further augment the PIT mutation testing tool [4] with more code- fixing rules (can be treated as mutators) to automatically fix real-world program bugs from Defects4J 

a. M1: For each field dereference, such as o.f, add a conditional checker to perform the field dereference only when o!=null.

d. M4: In each expression e, the operator replaces each variable occurring in the expression by another variable with a compatible type.
