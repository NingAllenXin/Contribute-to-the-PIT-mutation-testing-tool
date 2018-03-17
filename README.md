# CS6367
Contribute to the PIT mutation testing tool to implement more mutation operators.

The description of the original set of mutation operators implemented in PIT is available at: http://pitest.org/quickstart/mutators/. However, it does not include some traditional mutation operators. You need to first understand the ASM 
bytecode engineering framework, the JavaAgent on-the-fly code instrumentation, and the Maven build system (recommended for 
running PIT); then augment the PIT tool to implement the following mutation operators, and evaluate the augmented PIT tool on 5 real-world 
projects from GitHub (with >1000 lines of code and > 50 tests): 

a. AOD: Replaces an arithmetic expression by each one of the operand, 

b. ROR: Replaces the relational operators with each of the other ones. It applies every replacement

c. AOR: Replaces an arithmetic expression by each of the other ones
