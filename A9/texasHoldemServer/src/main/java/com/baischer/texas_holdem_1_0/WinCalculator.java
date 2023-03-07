package com.baischer.texas_holdem_1_0;
import java.util.ArrayList;
/**
 *  With a WinCalculator instance you can assess the chance of winning 
 *  depending on your pocket cards, the cards in the public talon and the number of opponents. 
 */
public class WinCalculator {
	private ArrayList<Integer> alreadyDrawnIndices;
	private ArrayList<Card> playerPocket;
	private ArrayList<Card> talon;
	private int numberOfOpponents;
/**
 * calculates the probability of winning by means of the Monte Carlo method: the unknown cards 
 * (of other players and of the talon) are drawn randomly numerous times so that the 
 * law of large numbers allows an approximation of the probability that the particular player wins
 * @param talonCards: the cards in the talon (might be an empty set)
 * @param plPocketCards: the player pocket cards (2 cards)
 * @param deck: the deck from which the talon and player pocket cards were drawn
 * @param noOfOpponents: the number of opponents
 */
	public WinCalculator(ArrayList<Card> talonCards, ArrayList<Card> plPocketCards, Deck deck, int noOfOpponents) {
		alreadyDrawnIndices = deck.getAlreadyDrawnIndices();
		playerPocket= plPocketCards;
		talon = talonCards;
		numberOfOpponents= noOfOpponents;
	}
	/**
	 * the assumption here is here that the talon and player pocket cards are drawn from a new Deck 
	 * @param talonCards: see in the other constructor above, but specified as string
	 * @param plPocketCards: see in the other constructor above, but specified as string
	 * @param noOfOpponents: see in the other constructor above
	 */
	public WinCalculator(String talonCards, String plPocketCards, int noOfOpponents) {
		Deck deck= new Deck();
		deck.addToAlreadyDrawnCards(talon= Util.stringToCards(talonCards));
		deck.addToAlreadyDrawnCards(playerPocket= Util.stringToCards(plPocketCards));
		alreadyDrawnIndices = deck.getAlreadyDrawnIndices();
		numberOfOpponents= noOfOpponents;
	}
	/**
	 * 
	 * @param noOfSimulations: the number of times that the unknown cards 
	 * (of other players and of the talon) are drawn randomly 
	 * @return the probability expressed in percent that the player 
	 * wins (with the known pocket cards and the known talon cards specified in the constructor)
	 */
	public double calcProbabilityForWinning(int noOfSimulations) {
		int handsWon = 0;
		for(int i = 0; i < noOfSimulations; i++) {
			Deck deck= new Deck(alreadyDrawnIndices);
			ArrayList<Card> tempTalon = (ArrayList<Card>)talon.clone();
			tempTalon.addAll(deck.draw(5 - talon.size()));
			Player me = new Player(tempTalon, playerPocket);
			Hand myHighestHand = me.getHighestHand();
			boolean iWin = true;
			for(int j = 0; j < numberOfOpponents; j++) {
				ArrayList<Card> opponentPocket = deck.draw(2);
				Player opponent = new Player(tempTalon, opponentPocket);
				if(myHighestHand.compareTo(opponent.getHighestHand()) < 0) {
					iWin = false;
					break;  // leave inner for-loop
				}
			}
			if(iWin) {
				handsWon++;
			}
		}
		return (100.0 * handsWon)/noOfSimulations;
	}
}