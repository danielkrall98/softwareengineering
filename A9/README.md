# Software Engineering Assignment
----------------------------------------------

Dart/Flutter (Texas Hold'em Poker UI)
--------------------------------------------

Implement a Dart/Flutter [1] GUI for a (Texas-Hold'em [2]) Poker App as described below.

## Prerequisites: Hand values

Determining the correct hand value is an essential aspect in a Texas Hold'em poker game. The game is played with 52 cards, 13 of each of the 4 suits. 

Java enum-types for representing the cards:
```java
public enum Suit { // in German:
	CLUB,		   // Kreuz
	DIAMOND,	   // Karo
	HEART,	       // Herz
	SPADE		   // Pik
}
public enum Rank {
	TWO,
	THREE,
	FOUR,
	FIVE,
	SIX,
	SEVEN,
	EIGHT,
	NINE,
	TEN,
	JACK,
	QUEEN,
	KING,
	ACE
}
```

A card can be uniquely identified by its color and value (rank). We use two characters for this: the first character is the color (Suit) with the possible values C/D/H/S. The second character is the value (rank) with the possible values 2/3/4/5/6/7/8/9/T/J/Q/K/A.

![Cards](/images/1cards.PNG)

A hand consists of 5 cards. The above hand is specified as a string as follows: "S6 C6 CT DT DK".

According to Texas Hold'em rules, there are the following ratings of a hand in ascending order:

```java
public enum HandVal {
	HIGHCARD,
	ONEPAIR,
	TWOPAIRS,
	THREEOFAKIND,
	STRAIGHT,
	FLUSH,
	FULLHOUSE,
	POKER,
	STRAIGHTFLUSH,
	ROYALFLUSH,
	NOTVALID
}
```

The above example of a hand has 2 pairs (TWOPAIRS): tens and sixes.

## Tasks

Implement the following **three tasks**, to (1) assess a hand, (2) compare two hands, (3) display the probability of winning **in one single application**. 

In case you implemented the programming assignment for the lecture, you may use it as the backend of your application.
Those who didn't implement it may provide random values instead (mock-up).

**Deliverables:**
- For each task: a PNG or JPEG file showing a screenshot of your widget: `Task1.png`, `Task2.png`, `Task3.png` (in the base directory)
- The source code of your application

**Note: There is no testing code provided. Chose a proper directory structure for your project.**



### Task 1

Implement a widget where the 5 cards of a hand are specified as a string with two characters. 
The following screenshot shows an example of how this could be designed using 5 input text fields one below the other. The first two cards belong to the player ("pocket cards"), the remaining three cards are "board cards" (also called "community cards"). 

![Assess](/images/2assess.PNG)

After entering the 5 card abbreviations, the "Assess Hand" button can be activated and the result (THREEOFAKIND) is displayed. For those who do not implement the special task of the lecture, a randomly chosen hand assessment can be displayed as a mockup, e.g. with a "?" at the end of the string.

### Task 2
Implement the following widget to compare two hands (analogous to task 1, use your service from the lecture or just do a mock-up).

![Draw](/images/3draw.PNG)

When the "Draw Hands Randomly" button is activated, 5 cards are drawn for each of the two hands. In case you implemented the service, the cards are drawn until the selected hand values are obtained (i.e., a naive approach), and the better hand is marked as winning. Otherwise, display a random (but valid) hand and randomly select one hand as the winner.

Use proper icons for the cards.

### Task 3

Allow the input of 2 pocket cards and 0/3/4/5 board (community) cards (suit and value shall be selectable via pop-up menus) as basis for a Monte-Carlo-Simulation for determining the winning probability. Display the calculated winning probability in percent (or show a random number in case you didn't implement the service).

Example for Pocket Cards:

![Packet](/images/4pocket.PNG)

After clicking the "-", the corresponding pop-up menus will be opened.

![PopUp](/images/5popup.PNG)



[1] https://flutter.dev/

[2] https://en.wikipedia.org/wiki/Texas_hold_%27em

