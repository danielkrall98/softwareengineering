package com.baischer.texas_holdem_1_0;
/**
 *  Card represents one of the 52 poker cards in Texas Hold'em
 */
public class Card {
	private Suit suit;
	private Rank rank;
	private boolean isCorrectlyInitialized; // see constructor comment below
	private String cardAsShortString="";    // two-character description, e.g., "CT" for Club-Ten, 
											//    see constructor comment about 'cardDesc' below
	public Card(Suit s, Rank r) {
		suit= s;
		rank= r;
		isCorrectlyInitialized= true;
	}
	/** 
	 * @param cardDesc describes a card as string with two characters: <br>
	 * suit: C/D/H/S <br>
	 *       with C/D/H/S for Club/Diamond/Heart/Spade <br> <br>
	 * rank: 2/3/4/5/6/7/8/9/T/J/Q/K/A <br>
	 *       with T/J/Q/K/A for Ten/Jack/Queen/King/Ace <br> <br>
	 * example: "ST" = SPADE-TEN <br>
	 * If cardDesc is not correct (e.g., "DX"), the method isCorrectlyInitialized() returns false,  <br>
	 * but the card is still a valid poker card with the default values HEART-ACE <br>
	 */
	public Card(String cardDesc) {  // short cut for card descriptor
		//   eg, "D2"= DIAMOND-TWO
		//   "HA"= HEART-ACE
		//   "ST"= SPADE-TEN
		//   "CK"= CLUB-KING
		cardDesc = cardDesc.toUpperCase();  // just in case it was specified in lower-case letters
		if (cardDesc.length() != 2) {
			System.out.println("wrong card description, need a 2-character string");
			isCorrectlyInitialized= false;
			suit= Suit.HEART;
			rank= Rank.ACE;
			return;
		}
		isCorrectlyInitialized= true;
		switch (cardDesc.charAt(0)) {
			case 'C': suit= Suit.CLUB; break;
			case 'D': suit= Suit.DIAMOND; break;
			case 'H': suit= Suit.HEART; break;
			case 'S': suit= Suit.SPADE; break;
			default:
				System.out.println("wrong character for Suit: " + cardDesc.charAt(0));
				isCorrectlyInitialized= false;
				suit= Suit.HEART;
		}
		switch (cardDesc.charAt(1)) {
			case '2': rank= Rank.TWO; break;
			case '3': rank= Rank.THREE; break;
			case '4': rank= Rank.FOUR; break;
			case '5': rank= Rank.FIVE; break;
			case '6': rank= Rank.SIX; break;
			case '7': rank= Rank.SEVEN; break;
			case '8': rank= Rank.EIGHT; break;
			case '9': rank= Rank.NINE; break;
			case 'T': rank= Rank.TEN; break;
			case 'J': rank= Rank.JACK; break;
			case 'Q': rank= Rank.QUEEN; break;
			case 'K': rank= Rank.KING; break;
			case 'A': rank= Rank.ACE; break;
			default:
				System.out.println("wrong character for Rank: " + cardDesc.charAt(1));
				isCorrectlyInitialized= false;
				rank= Rank.ACE;
		}
		if (isCorrectlyInitialized) {
			cardAsShortString= cardDesc;
		}
	}
	public String toString() {
		return "    " + suit + "-" + rank;
	}
	public Suit getSuit() {
		return suit;
	}
	public Rank getRank() {
		return rank;
	}
	/**
	 * If the parameter 'cardDesc' passed to the constructor is not correct (e.g., "DX"),  <br>
	 * the method isCorrectlyInitialized() returns false,  <br>
	 * but the card is still a valid poker card with the default values HEART-ACE <br>

	 * @return whether the Card object was correctly initialized in the constructor
	 */
	public boolean isCorrectlyInitialized() { 
		return isCorrectlyInitialized; 
	}
	public String getCardAsShortString() {
		if (!cardAsShortString.isEmpty())
			return cardAsShortString;
		String cAsShortString="";
		switch (suit) {
			case CLUB: cAsShortString += "C"; break;
			case DIAMOND: cAsShortString += "D"; break;
			case HEART: cAsShortString += "H"; break;
			case SPADE: cAsShortString += "S"; break;
		}
		switch (rank) {
			case TWO: cAsShortString += "2"; break;
			case THREE: cAsShortString += "3"; break;
			case FOUR: cAsShortString += "4"; break;
			case FIVE: cAsShortString += "5"; break;
			case SIX: cAsShortString += "6"; break;
			case SEVEN: cAsShortString += "7"; break;
			case EIGHT: cAsShortString += "8"; break;
			case NINE: cAsShortString += "9"; break;
			case TEN: cAsShortString += "T"; break;
			case JACK: cAsShortString += "J"; break;
			case QUEEN: cAsShortString += "Q"; break;
			case KING: cAsShortString += "K"; break;
			case ACE: cAsShortString += "A"; break;
		}
		cardAsShortString= cAsShortString;
		return cAsShortString;
	}
	/**
	 *  two cards are equal if their suit and rank are the same
	 * @param otherCard the card with which this one is compared
	 * @return whether this card and the other one are equal or not
	 */
	public boolean equals(Card otherCard){
		return this.suit == otherCard.suit && this.rank == otherCard.rank;
	}
}
