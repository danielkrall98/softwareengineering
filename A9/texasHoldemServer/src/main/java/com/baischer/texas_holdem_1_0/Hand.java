package com.baischer.texas_holdem_1_0;
import java.util.ArrayList;

/**
 *  A hand of cards always must contain 5 cards before its value (e.g., POKER, ONEPAIR) can be determined.
 *  By implementing the Java interface Comparable, two hands can be compared. The simple case is that the
 *  hand values are different. The hand with the higher value wins.
 *  In case both hands have the same hand value, the comparison takes the particular Texas Hold'em rules 
 *  into account. For example, if two hands have the value ONEPAIR, the rank of the 
 *  cards that form the pair in each hand is compared first, then in up to three steps the ranks of the 
 *  other three cards from the highest to the lowest rank. 
 *  Only if all ranks are equal the hand values are equal. Otherwise a card rank in one of the hands breaks 
 *  the tie.
 */
public class Hand implements Comparable<Hand> {
	private int cardsCalculator[][]= new int[5][14];
	private HandVal handVal= HandVal.NOTVALID;
	protected ArrayList<Integer> tieBreakers;  // Rank values of cards in the hand
	/**
	 * create an empty hand (no cards yet); 5 cards need to be added with method addCard()  <br>
	 * before the hand value can be determined by means of getHandVal(),  <br>
	 * or before the hand can be compared to another hand with 5 cards
	 */
	public Hand() {
		resetCardsCalculator(); // => all array values reset to 0
	}
	/**
	 * 
	 * @param cardsAsString describes a hand with a string that contains  <br>
	 * 5 two-character specifications of cards separated by a blank <br>
	 * example: "D6 H6 S5 H9 C6" <br> <br>
	 * 
	 * string with two characters specifying a card: <br>
	 * suit: C/D/H/S <br>
	 *       with C/D/H/S for Club/Diamond/Heart/Spade <br> <br>
	 * rank: 2/3/4/5/6/7/8/9/T/J/Q/K/A <br>
	 *       with T/J/Q/K/A for Ten/Jack/Queen/King/Ace <br>
	 * example: "D6" = DIAMOND-SIX <br>
	 */
	public Hand(String cardsAsString) {
		ArrayList<Card> cards= Util.stringToCards(cardsAsString);
		if (cards.size() != 5) {
			System.out.println("5 cards expected => wrong number of cards specified!!");
			return;
		}
		resetCardsCalculator(); // => all array values reset to 0
		for (Card card: cards) {
			addCard(card);
		}
		calcColAndRowSums();
	}
	/**
	 * @param card: the card object to be added to the hand
	 */
	public void addCard(Card card) {
		cardsCalculator[card.getSuit().ordinal()]
			           [card.getRank().ordinal()]++;
	}
	/**
	 * @return the current number of cards in the hand <br>
	 * can be used for checking whether the hand contains already 5 cards
	 */
	public int getNoOfCards() {
		calcColAndRowSums();
		// sum up column sums in row 4
		int noOfCards= 0;
		for (int col= 0; col < 13; col++) {
			noOfCards= noOfCards + cardsCalculator[4][col];
		}
		return noOfCards;
	}
	/**
	 * @return the value of the hand: 
	 * HIGHCARD/ONEPAIR/TWOPAIRS/THREEOFAKIND/STRAIGHT/FLUSH/ <br>
	 * FULLHOUSE/POKER/STRAIGHTFLUSH/ROYALFLUSH/NOTVALID
	 */
	public HandVal getHandVal() {
		if (handVal != HandVal.NOTVALID) {
			return handVal;
		}
		if (getNoOfCards() != 5) {  // getNoOfCards() also (re)calculates the column and row sums
			System.out.println("The hand does not have 5 cards as expected! => no valid hand value can be returned!");
			return HandVal.NOTVALID;
		}
		tieBreakers= new ArrayList<Integer>();
		handVal= assessHand();
		return handVal;
	}
	private void resetCardsCalculator() {
		// initialize the 2-dimensional array with zeros
		for (int row= 0; row < 5; row= row + 1) {
			for (int col= 0; col < 14; col= col + 1) {
				cardsCalculator[row][col]= 0;
			}
		}
	}
	private void calcColAndRowSums() {
		// calculate column sums
		int cSum= 0;
		for (int col= 0; col < 13; col++) {
			for (int row= 0; row < 4; row++) {
				cSum= cSum + cardsCalculator[row][col];
			}
			cardsCalculator[4][col]= cSum;
			cSum= 0;
		}
		// calculate row sums
		int rSum= 0;
		for (int row= 0; row < 4; row++) {
			for (int col= 0; col < 13; col++) {
				rSum= rSum + cardsCalculator[row][col];
			}
			cardsCalculator[row][13]= rSum;
			rSum= 0;
		}
	}
	private void printCardsCalculator() {
		for (int row= 0; row < 5; row++) {
			for (int col= 0; col < 13; col++) {
				System.out.print(cardsCalculator[row][col]); System.out.print("  ");
			}
			System.out.println();
		}
	}
	private int findMaxRankValOfColSumFromHighToLow(int colSum) { // finds first column in cardsCalculator from right to left whose sum is 'colSum'
		for (int col= 12; col >= 0; col--) {
			if (cardsCalculator[4][col] == colSum) {
				return col;
			}
		}
		return -1;
	}
	private int findMinRankValOfColSumFromLowToHigh(int colSum) { // finds first column in cardsCalculator from left to right whose sum is 'colSum'
		for (int col= 0; col < 14 ; col++) {
			if (cardsCalculator[4][col] == colSum) {
				return col;
			}
		}
		return -1;
	}
	private void addRankValsOfColSumFromHighToLowToTieBreakers(int colSum){ // finds all columns in cardsCalculator from right to left whose sum is 'colSum' and 
																		   //    adds these column-indices (= ranks) to the tieBreakers list
		for (int col = 12; col >= 0; col--){
			if(cardsCalculator[4][col] == colSum){
				tieBreakers.add(col);
			}
		}
	}
	private HandVal assessHand() {
		tieBreakers.clear();
		if (isStraight() && isFlush() && cardsCalculator[4][12] == 1 && cardsCalculator[4][0] != 1)
			return HandVal.ROYALFLUSH;
		if (isStraight() && isFlush()){
			int low = findMinRankValOfColSumFromLowToHigh(1);
			int high = findMaxRankValOfColSumFromHighToLow(1);
			if(high == 12 && low == 0) {
				tieBreakers.add(3);
			} else {
				tieBreakers.add(high);
			}
			return HandVal.STRAIGHTFLUSH;
		}
		if (isPoker()) {
			addRankValsOfColSumFromHighToLowToTieBreakers(4);
			addRankValsOfColSumFromHighToLowToTieBreakers(1);
			return HandVal.POKER;
		}
		if (isFullHouse()){
			addRankValsOfColSumFromHighToLowToTieBreakers(3);
			addRankValsOfColSumFromHighToLowToTieBreakers(2);
			return HandVal.FULLHOUSE;
		}
		if (isFlush()){
			addRankValsOfColSumFromHighToLowToTieBreakers(1);
			return HandVal.FLUSH;
		}
		if (isStraight()){
			int low = findMinRankValOfColSumFromLowToHigh(1);
			int high = findMinRankValOfColSumFromLowToHigh(1);
			if(high == 12 && low == 0){
				tieBreakers.add(3);
			} else{
				tieBreakers.add(high);
			}
			return HandVal.STRAIGHT;
		}
		if (isThreeOfAKind()){
			addRankValsOfColSumFromHighToLowToTieBreakers(3);
			addRankValsOfColSumFromHighToLowToTieBreakers(1);
			return HandVal.THREEOFAKIND;
		}
		if (isTwoPairs()){
			addRankValsOfColSumFromHighToLowToTieBreakers(2);
			addRankValsOfColSumFromHighToLowToTieBreakers(1);
			return HandVal.TWOPAIRS;
		}
		if (isOnePair()){
			addRankValsOfColSumFromHighToLowToTieBreakers(2);
			addRankValsOfColSumFromHighToLowToTieBreakers(1);
			return HandVal.ONEPAIR;
		}
		if (isHighCard()){
			addRankValsOfColSumFromHighToLowToTieBreakers(1);
			return HandVal.HIGHCARD;
		}
		return HandVal.NOTVALID;
	}
	private boolean isStraight() {
		String sumOfColsStr="";
		sumOfColsStr+= new Integer(cardsCalculator[4][12]).toString();  //no of aces as first digit in the string
		for (int col= 0; col < 13; col++) {
			sumOfColsStr+= new Integer(cardsCalculator[4][col]).toString();
		}
		// 'sumOfColsStr' is the bottom ∑ line of handCalculator as string,
		//       with the number of aces as first and last digit
		return sumOfColsStr.contains("11111");
	}
	private boolean isFlush() {
		for (int row= 0; row < 4; row++) {
			if (cardsCalculator[row][13] == 5) {
				return true;
			}
		}
		return false;
	}
	private boolean isPoker() {
		for (int col= 0; col < 14; col++) {
			if (cardsCalculator[4][col] == 4) {
				return true;
			}
		}
		return false;
	}
	private boolean isFullHouse() {
		return isThreeOfAKind() && isOnePair();
	}
	private boolean isThreeOfAKind() {
		for (int col= 0; col < 14; col++) {
			if (cardsCalculator[4][col] == 3) {
				return true;
			}
		}
		return false;
	}
	private boolean isTwoPairs() {
		boolean isTwoPairs= (noOfPairs() == 2);
		return  isTwoPairs;
	}
	private boolean isOnePair() {
		boolean isOnePair= (noOfPairs() == 1);
		return  isOnePair;
	}
	private int noOfPairs() {
		int noOfPairs= 0;
		for (int col= 0; col < 14; col++) {
			if (cardsCalculator[4][col] == 2) {
				noOfPairs++;   // noOfPairs= noOfPairs + 1;
			}
		}
		return noOfPairs;
	}
	private boolean isHighCard() {
		boolean moreFound= false;
		for (int col= 0; col < 14; col++) {
			if (cardsCalculator[4][col] > 1)
				moreFound= true;
		}
		return !moreFound;   // not (!) more than ones (1s) found
	}
	/**
	 * The simple case is that the hand values of the two hands are different. The hand with the higher value wins. <br> <br>
	 *  In case both hands have the same hand value, the comparison takes the particular Texas Hold'em rules 
	 *  into account. For example, if two hands have the value ONEPAIR, the rank of the 
	 *  cards that form the pair in each hand is compared first, then in up to three steps the ranks of the 
	 *  other three cards from the highest to the lowest rank. 
	 *  Only if all ranks are equal the hand values are equal. Otherwise a card rank in one of the hands breaks 
	 *  the tie.
	 */
	@Override
	public int compareTo(Hand otherHand) { 	// 0 if equal, -1 if I'm < otherHand,
											// 1 if I'm > otherHand
		if (this.getHandVal().ordinal() > otherHand.getHandVal().ordinal()) {
			return 1;
		}
		if (this.getHandVal().ordinal() < otherHand.getHandVal().ordinal()) {
			return -1;
		}
		if (this.getHandVal().ordinal() == otherHand.getHandVal().ordinal()) {
			if (this.tieBreakers.size() != otherHand.tieBreakers.size()) {
				System.out.println("ERROR in compareTo: tieBreakers lists have to be the same length");
				System.out.println(this);
				System.out.println(this.getHandVal());
				System.out.println(this.tieBreakers);
				System.out.println(otherHand);
				System.out.println(otherHand.getHandVal());
				System.out.println(otherHand.tieBreakers);
				return 0;
			}
			for (int i= 0; i < this.tieBreakers.size(); i++) {
				// System.out.println("compareto..." + tieBreakers.get(i) + "   "+otherHand.tieBreakers.get(i) );
				if (tieBreakers.get(i) > otherHand.tieBreakers.get(i))
					return 1;
				if (tieBreakers.get(i) < otherHand.tieBreakers.get(i))
					return -1;
			}
		}
		return 0;
	}
	/**
	 * lists the cards currently in the hand <br>
	 * example: <br>
	 *         CLUB-SIX <br>
	 *         DIAMOND-SIX <br>
	 *         HEART-SIX <br>
	 *         HEART-EIGHT <br>
	 *         SPADE-SIX <br>
	 */
	public String toString() {
		String result="";
		for (int row= 0; row < 4; row++) {
			for (int col= 0; col < 13; col++) {
				if (cardsCalculator[row][col] == 1) {
					Card card= new Card(Suit.values()[row], Rank.values()[col]);
					result += "    "+ card + "\n";
				}
			}
		}
		return result;
	}
}