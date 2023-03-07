[reslink]: https://github.com/sweng-plus/a1-res-sew22-s1086240_s1054335/actions/runs/3487253546
[worklink]: https://github.com/sweng-plus/a1-res-sew22-s1086240_s1054335/actions/workflows/classroom.yml
[![Points badge](.github/badges/points.svg)][reslink] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; [Go to testing workflow][worklink]

# Software Engineering Assignment 1 WS 2022
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


# Date Formatter
----------------------------------------------------

Develop a date formatter program according to the comments in the starter code and the definitions in the file Datumsformat.pdf .

----------------------------------------------------
## Important note
The example in the javadoc comments for the method `DateMain.transformDates` contains a mistake. The correct version is provided below.

```java 
	/**
	 * Reformats multiple dates from file. Creates new file with the results.
	 * 
	 * @param inputFile : name of existing file with three strings per line: source format,date,target format
	 * @param outputFile: name of new file with the transformed dates
	 * 		- for a valid input, the corresponding line has the format: target format,date
	 * 		- for an invalid input, the corresponding output line should consist of the word INVALID
	 * 		- a valid input is defined exactly as the one for the method formatDate
	 * @return true if operation successful, false if output file already exists or if file access operations did not succeed 
	 * 
	 * Examples of input lines:
	 * 
	 * A/4,10/03/2022,B-4b
	 * C-4,17/12/2000,A/2
	 * B-2b,22- 8- 5,B-2
	 * A/4b, 2/29/2099,C/2
	 * C.4,03.10.2022,A/4b
	 *
	 * 
	 * The corresponding output lines:
	 * 
	 * B-4b,2022-10- 3
	 * INVALID
	 * B-2,22-08-05
	 * 29/02/99
	 * A/4b,10/ 3/2022
	 * 
	 */
	public static boolean transformDates(String inputFile, String outputFile) {
		return false;
	}
```

----------------------------------------------------

## How to run tests locally

In you local repo, run first

>mvn dependency:unpack

This will download two files (in the root folder): `Inputs.txt` and `ExpectedOutputs.txt`
Then run

>mvn clean test

Your method `DateMain.transformDates` will be called with arguments `("Inputs.txt", "ActualOutputs.txt")`. The corresponding test simply compares the expected and actual outputs.

If you test your method locally with your own files (which is recommended), you should use filenames different than the ones above, otherwise your files might get overwritten during testing.

----------------------------------------------------
