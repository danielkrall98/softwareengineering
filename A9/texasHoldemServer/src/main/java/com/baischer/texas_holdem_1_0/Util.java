package com.baischer.texas_holdem_1_0;

import java.util.ArrayList;
/**
 * A utility class used in Hand, Player and WinCalculator to convert a string that specifies poker cards to a list of cards. 
 * Util is declared as 'final' class so that no subclass can be defined.
 */
final public class Util {		// no subclass can be defined for a 'final' class
	/**
	 * 
	 * @param cardsAsString: a string that contains  <br>
	 * any number of two-character specifications of cards separated by a blank; <br>
	 * in practice, the number is 2 (e.g., for pocket cards) or 5 (e.g., for a hand) <br>
	 * example: "D6 H6 S5 H9 C6" <br> <br>
	 * 
	 * string with two characters specifying a card: <br>
	 * suit: C/D/H/S <br>
	 *       with C/D/H/S for Club/Diamond/Heart/Spade <br> <br>
	 * rank: 2/3/4/5/6/7/8/9/T/J/Q/K/A <br>
	 *       with T/J/Q/K/A for Ten/Jack/Queen/King/Ace <br>
	 * example: "D6" = DIAMOND-SIX <br> 
	 * @return The list of Card objects corresponding to 'cardsAsString' passed as input parameter.
	 */
	public static ArrayList<Card> stringToCards(String cardsAsString) {  // protected: only to be used in this package; 
																			//    static: no instance creation (new) of Util required
																			//            instead simply call Util.stringToCards("...")
		String cardsDescriptions[]= cardsAsString.split(" ");  	// the parameter of split() is the delimiter, in this case: blank 
		   														// => "HA HK HQ HJ HT" is split into "HA" "HK" "HQ" "HJ" "HT"
		ArrayList<Card> resultingCards= new ArrayList<Card>();
		for (int i= 0; i < cardsDescriptions.length; i= i + 1)	{
			resultingCards.add(new Card(cardsDescriptions[i]));
		}
		return resultingCards;
	}
}
