[reslink]: https://github.com/sweng-plus/a7-res-sew22-s1086240_s1054335/actions/runs/3747357174
[worklink]: https://github.com/sweng-plus/a7-res-sew22-s1086240_s1054335/actions/workflows/classroom.yml
[![Points badge](.github/badges/points.svg)][reslink] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; [Go to testing workflow][worklink]

# Software Engineering Assignment
----------------------------------------------

[General rules](generalRules.md)


# Decorator and Singleton Design Pattern
----------------------------------------------------
Implement a small framework for reading and writing encoded text.

Write two implementations of the interface `Translator`:
- MorseTranslator, that provides decoding of the Morse code to letters [a-z]. Assume that letters in the Morse code are separated by one space and words are separated by the character '|' (with no spaces around it). See also [3,4].
- ROT13Translator, which provides ROT13 encoding. Only characters representing letters in the Latin alphabet should be encoded, with their case preserved. All other characters remain unchanged.

Implement the interface `MREncoding` by using the Decorator design pattern on existing classes from the `java.io` package. Use also your implementations of the Translator interface. 
For example, a file containing the Morse code ``.... . .-.. .-.. ---|-.. .- -..`` will be read as ``hello dad``, and the string ``Why me?`` should be written in ROT13 as ``Jul zr?``.

Can you spot other implementations of the Decorator pattern in the `java.io` package?

Moreover, use the Singleton design pattern to enforce the rule that all reader objects returned by the implementation of `MREncoding` employ the same MorseTranslator object, and all writer objects employ the same ROT13Translator object.

The Decorator and Singleton design patterns can be found in [1]. For an overview of the ``java.io`` package, see [2]. Make sure that each one of your two decorator classes decorates an existing Java class from the ``java.io`` package. Note: the assignment is about CHARACTER streams.


Be prepared for questions: UML, pros/cons, requirements, ...

Bonus: Provide an efficient implementation of the Translator (avoid excessive use of string comparisons). 

[1] Design Patterns. Elements of Reusable Object-Oriented Software; Gamma et al.  
[2] https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/io/package-summary.html  
[3] https://en.wikipedia.org/wiki/Morse_code  
[4] https://raw.githubusercontent.com/jvcleave/example-ofFile-MorseCode/master/bin/data/morse.csv  

------------------------------------------
### _Evaluation_

* The Reader part (`MorseTranslator` and implementations of the Reader methods in `MREncoding`) weights 60%.

* The Writer part (`ROT13Translator` and implementations of the Writer methods in `MREncoding`) weights 40%.
