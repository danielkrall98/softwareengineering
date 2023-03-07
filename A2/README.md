[reslink]: https://github.com/sweng-plus/a2-res-sew22-s1086240_s1054335/actions/runs/3304650858
[worklink]: https://github.com/sweng-plus/a2-res-sew22-s1086240_s1054335/actions/workflows/classroom.yml
[![Points badge](.github/badges/points.svg)][reslink] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; [Go to testing workflow][worklink]

# Software Engineering Assignment
----------------------------------------------------

### _Preamble_

* Begin your work by carefully reading the text below as well as the starter code in `src/main/java`, including the comments therein.
* You are expected to:
    * Add code to classes and methods in the starter code, in particular everything marked with `TODO`, and more.
	* Change/add implementation to starter methods. In particular, change dummy return values.
* You may add to starter classes: new attributes and methods, inheritance (super- or subclasses), and inner classes (if really needed).
* You may add your own packages and classes but only in the root package of the assignment:
	* The root package is the one containing the starter code, and corresponds to the  folder provided in `src/main/java`
	* Every new class file must start with a package declaration
* Regarding the starter code, please make sure **not** to:
	* rename the root package
    * rename classes and their access modifiers 
    * change method signatures
    * modify the contents of the `.github` folder and `pom.xml` file.
    * modify existing test classes (if any) in the folder src/test/java.
* Java version: 14
* **Important: if at least one of the above rules is not satisfied, one or all tests may fail and points may be lost!**
* It is normal at the beginning to have compiler errors in the test code, or otherwise failed tests, since the starter code does not satisfy requirements of the assignment.  


# Calculator
----------------------------------------------------

Implement a calculator starting from the provided skeleton classes.

a) Stacks <br>
Write two different implementations for the given interface of a stack (LIFO) (`GenericStack.java`)

One implementation shall be based on an array with constant size (e.g., `class ArrayStack`); the other shall be based on a linked list (e.g., `class ListStack`). 
Both classes shall implement the generic interface above and should also use generics.

The stack classes must *NOT* rely on the Java Collections Framework!
Implement them yourself according to the documentation in the provided starter code.

b) Calculator <br>
Use your stacks to implement a calculator (supporting the operations '+', '-', '*', '/').
The calculator shall work with both types of stacks (and any other implementation of the stack interface) without any modification.

The calculator shall support input in the two formats *postfix* and *infix*.

----------------------------------------------------
