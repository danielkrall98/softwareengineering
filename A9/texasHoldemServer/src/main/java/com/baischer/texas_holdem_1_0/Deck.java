package com.baischer.texas_holdem_1_0;

import java.util.ArrayList;
import java.util.Random;
/**
 * Deck represents the Texas Hold'em poker card deck, consisting of 52 cards
 */
public class Deck {
	private ArrayList<Card> pokerCards; // initialized with the 52 poker cards in both constructors 
										//   by means of createPokerCards()
	private ArrayList<Integer> alreadyDrawnIndices;
	public Deck() {
		createPokerCards();
		reset();
	}
	/**
	 * @param alreadyDrawnInd is the list of the indices (integer numbers from 0..51)  <br>
	 *      of the cards that were already drawn from the deck
	 */
	public Deck(ArrayList<Integer> alreadyDrawnInd) {
		createPokerCards();
		alreadyDrawnIndices= (ArrayList<Integer>) (alreadyDrawnInd.clone());
	}
	/**
	 * initializes the Deck object with all 52 poker cards
	 */
	private void createPokerCards() {
		pokerCards= new ArrayList<Card>();
		for (Suit s : Suit.values()) {
			for (Rank r: Rank.values()) {
				pokerCards.add(new Card(s, r));
			}
		}		
	}
	/**
	 * resets the drawn index list to an empty list  <br>
	 *    note that the 52 cards do not need to be created again
	 */
	public void reset() {
		alreadyDrawnIndices= new ArrayList<Integer>();
	}
	/**
	 * draw cards from the deck
	 * @param noOfCards specifies the number of cards that should be drawn
	 * @return the drawn cards are returned in an array list;  <br>
	 *     if not all 'noOfCards' could be drawn (because there were not enough cards  <br>
	 *     left on the deck) those which could be drawn are returned
	 */
	public ArrayList<Card> draw(int noOfCards) {
		ArrayList<Card> drawnCards= new ArrayList<Card>();
		for (int i= 0; i < noOfCards; i++) {
			if (alreadyDrawnIndices.size() >= 52) { // no more cards available
				return drawnCards;       // either the empty list of cards or those that could still be drawn
			}
			Random randNo = new Random(System.currentTimeMillis());
			int index = randNo.nextInt(52);  // index is a random number between 0 and 51
			while (alreadyDrawnIndices.contains(index)) {
				index = randNo.nextInt(52);
			}
			drawnCards.add(pokerCards.get(index));
			alreadyDrawnIndices.add(index);
		}
		return drawnCards;
	}
	public ArrayList<Integer> getAlreadyDrawnIndices() {
		return alreadyDrawnIndices;
	}
	/**
	 * mark cards as already drawn
	 * @param cards: the cards that should be marked as already drawn
	 */
	public void addToAlreadyDrawnCards(ArrayList<Card> cards) {
		for(Card c : cards) {
			alreadyDrawnIndices.add(findIndexForCard(c));
		}
	}
	/**
	 * @param c: any card object
	 * @return returns the index (0..51) of card 'c' in the deck
	 */
	public int findIndexForCard(Card c) {
		for(int i = 0; i < 52; i++) {
			if(pokerCards.get(i).equals(c)) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * @param c checks whether a card 'c' was already drawn or  <br>
	 *     still available in the deck
	 * @return returns true if card 'c' was already drawn
	 */
	public boolean isAlreadyDrawn(Card c) {
		for (Integer i: alreadyDrawnIndices) {
			if (findIndexForCard(c) == i.intValue()) {
				return true;
			}
		}
		return false;
	}
}
