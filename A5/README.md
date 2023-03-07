# Software Engineering Assignment
----------------------------------------------

[General rules](generalRules.md)

Unit testing with JUnit, code coverage
----------------------------------------------------

### Task 1 (40 %)
1.  What is test driven development (TDD), unit testing?
1.  Get familiar with JUnit 5 (www.junit.org); (use version 5, which is based on Java annotations).
1.  Test your stack implementations from the Calculator assignment.
	* Extend your stack implementation by a getSize() method, also make sure to throw appropriate exceptions when you perform a pop() on an empty stack, for example. Take this opportunity to improve your stack implementations as discussed in class.
   	* Write JUnit tests to test all your stacks. Use the special features for testing for expected exceptions in JUnit. Make sure that all your public and (package-) protected methods get tested. Note: Test classes should be in the same package as the classes of the stacks, etc.
    * Note: You have two stack classes, but you must not duplicate your test code in order to test both stacks! Find out a suitable strategy for testing both stacks without duplicating code (there are Junit features for this).

### Task 2 (30 %)
1.	Test your CalcMain class from the Calculator assignment..
    * Write several tests for the RPN calculator.
    * Write also tests to check the behavior on invalid input.

### Task 3 (30 %)
1. Try to have your whole code of the Calculator assignment covered by unit tests.
1. Find and try a code coverage analysis tool (e.g. Eclipse plug-in).
1. Analyze the coverage of your code and improve your tests if necessary.
1. Make a screenshot of the coverage analysis tool that documents your efforts and submit the image in a file named coverage.jpg or coverage.png.

**Required submissions (git):**
* in src/main/java/calc : the .java file(s) for the stacks and the calculator
* in src/test/java/calc : the .java file(s) for the junit-test classes
* in the base directory: the coverage screenshot file, named coverage.jpg or coverage.png

**Make sure that your tests can be run from the base directory with the command**
```
mvn clean test
```

### Notes
This assignment does not have automatic checking (no automatic points). 

**Only in case you haven't implemented the Calculator assignment:**
You may instead apply the above tasks to the Bank assignment. In this case, Task 1 refers to the two account types and Task 2 applies to the Bank class. Task 3 must  cover also the Customer classes.
