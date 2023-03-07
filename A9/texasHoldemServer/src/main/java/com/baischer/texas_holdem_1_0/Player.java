package com.baischer.texas_holdem_1_0;

import java.util.ArrayList;
import java.util.Collections;
/**
 *  A player has two secret cards (in a so-called player pocket) and 
 *  combines them with the cards in the public talon (with 3/4/5 cards) 
 *  to find the hand with the highest value out of all hands that 
 *  can be generated from the talon + player pocket cards.
 *  Note that a hand consists always of 5 cards. 
 */
public class Player {
	private ArrayList<Card> talon;
	private ArrayList<Card> playerPocket;
	private ArrayList<Card> allCards; // all cards which are in talon + playerPocket
	private ArrayList<Hand> allHands; // all hands that can be generated from 'allCards'
	/**
	 *   sample object instantiations:   <br>
	 *   		new Player("HK HQ HJ HT D3", "HA C6");  <br>
	 *   			talon with 5 cards: "HK HQ HJ HT D3" <br>
	 *   			player pocket with 2 cards: "HA C6", <br>
	 *   			thus, 21 hands can be generated from talon + player pocket cards <br>
	 *   			its hand value is ROYALFLUSH in this example <br> <br>
	 *   		new Player("D6 H6 S5", "H9 C6") <br>
	 *   			talon with 3 cards: "D6 H6 S5" <br>
	 *   			player pocket with 2 cards: "H9 C6", <br>
	 *   			thus, only one hand can be generated from talon + player pocket cards <br>
	 *   			its hand value is THREEOFAKIND in this example <br>
	 * @param talonStr talon cards as string
	 * @param playerPocketStr player pocket cards as string
	 */
	public Player(String talonStr, String playerPocketStr) {
		talon= Util.stringToCards(talonStr);
		playerPocket= Util.stringToCards(playerPocketStr);
		initCardLists();
	}
	/**
	 * analogous to the other constructor with the difference that the cards of  <br>
	 * the talon and player pocket are already passed as array lists instead of strings
	 * @param tCards talon cards as array list of card objects
	 * @param ppCards player pocket cards as array list of card objects
	 */
	public Player(ArrayList<Card> tCards, ArrayList<Card> ppCards) {
		talon= tCards;
		playerPocket= ppCards;
		initCardLists();
	}
	private void initCardLists() {
		if(talon.size() > 5){
			System.out.println("ERROR: talon contains > 5 cards!");
		}
		if(playerPocket.size() > 2){
			System.out.println("ERROR: player pocket contains > 2 cards!");
		}
		allCards= new ArrayList<Card>();
		for (Card c: playerPocket) {
			allCards.add(c);
		}
		for (Card c: talon) {
			allCards.add(c);
		}
		if (allCards.size() < 5) {
			System.out.println("ERROR: player with overall less than 5 cards => hands cannot be generated");
			return;
		}	
	}
	public boolean canGenerateHands() {
		return (allCards.size() >= 5);
	}
	/**
	 * sets (= replaces) the talon cards by the Card array list 'tCards'
	 * @param tCards talon cards as array list of Card objects
	 */
	public void setTalon(ArrayList<Card> tCards) {
		talon= tCards;
		initCardLists();
	}
	/**
	 * sets (= replaces) the talon cards as specified in String 'tCards'
	 * @param tCards talon cards as string
	 */
	public void setTalon(String tCards) {
		talon= Util.stringToCards(tCards);
		initCardLists();
	}
	/**
	 * adds the cards in the Card array list 'addtlCards' to the talon cards
	 * @param addtlCards as array list of Card objects
	 */
	public void addCardsToTalon(ArrayList<Card> addtlCards) {
		talon.addAll(addtlCards);
		initCardLists();		
	}
	/**
	 * adds the cards as specified in String 'addtlCards' to the talon cards
	 * @param addtlCards as string
	 */
	public void addCardsToTalon(String addtlCards) {
		talon.addAll(Util.stringToCards(addtlCards));
		initCardLists();		
	}
	/**
	 * sets (= replaces) the player pocket cards by the Card array list 'ppCards'
	 * @param ppCards player pocket cards as array list of Card objects
	 */
	public void setPlayerPocket(ArrayList<Card> ppCards) {
		playerPocket= ppCards;
		initCardLists();
	}
	/**
	 * sets (= replaces) the player pocket cards as specified in String 'ppCards'
	 * @param ppCards player pocket cards as string
	 */
	public void setPlayerPocket(String ppCards) {
		playerPocket= Util.stringToCards(ppCards);
		initCardLists();
	}
	/**
	 * adds the cards in the Card array list 'addtlCards' to the player pocket cards
	 * @param addtlCards as array list of Card objects
	 */
	public void addCardsToPlayerPocket(ArrayList<Card> addtlCards) {
		playerPocket.addAll(addtlCards);
		initCardLists();		
	}
	/**
	 * adds the cards as specified in String 'addtlCards' to the player pocket cards
	 * @param addtlCards as string
	 */
	public void addCardsToPlayerPocket(String addtlCards) {
		playerPocket.addAll(Util.stringToCards(addtlCards));
		initCardLists();		
	}
	/**
	 * @return the hand with the highest value out of all possible hands 
	 *    that can be formed with the talon + pocket cards
	 */
	public Hand getHighestHand() {
	    if (!canGenerateHands()) {
	        return null;
        }
		allHands= generateAllCombinations(allCards, 5);
		Collections.sort(allHands, Collections.reverseOrder());
		return allHands.get(0);
	}
	/**
	 * this method is mainly for testing: <br>
	 * 	5 cards in the talon + 2 cards in the pocket cards, thus 21 hands <br>
	 * 	4 cards in the talon + 2 cards in the pocket cards, thus 6 hands <br>
	 * 	3 cards in the talon + 2 cards in the pocket cards, thus 1 hand <br>
	 * @return all hands that can be formed with the talon + pocket cards
	 */
	public ArrayList<Hand> getAllHands() {
		return allHands;
	}
	// the source code and comments of the following method generateAllCombinations() are 
	//    with minimal adaptations, such as the use of ArrayList<Hand>, from
	//    http://hmkcode.com/calculate-find-all-possible-combinations-of-an-array-using-java/
	private ArrayList<Hand> generateAllCombinations(ArrayList<Card> elements, int K){
		allHands= new ArrayList<Hand>();
		// get the length of the array
		// e.g. for {'A','B','C','D'} => N = 4
		int N = elements.size();
		if(K > N){
			System.out.println("Invalid input, K > N");
			return allHands;
		}
		// calculate the possible combinations c(N,K)  e.g., c(4,2)

		// get the combination by index
		// e.g. 01 --> AB , 23 --> CD
		int combination[] = new int[K];

		// position of current index
		//  if (r = 1)              r*
		//  index ==>        0   |   1   |   2
		//  element ==>      A   |   B   |   C
		int r = 0;
		int index = 0;
		while(r >= 0) {
			// possible indexes for 1st position "r=0" are "0,1,2" --> "A,B,C"
			// possible indexes for 2nd position "r=1" are "1,2,3" --> "B,C,D"

			// for r = 0 ==> index < (4+ (0 - 2)) = 2
			if(index <= (N + (r - K))) {
				combination[r] = index;
				// if we are at the last position 'print' and increase the index
				if(r == K-1) {
					//do something with the combination e.g. add to list or print
					Hand hand= new Hand();
					for (int i= 0; i < K; i++) {
						hand.addCard(allCards.get(combination[i]));
					}
					hand.getHandVal();
					allHands.add(hand);

					index++;
				}
				else {
					// select index for next position
					index = combination[r]+1;
					r++;
				}
			}
			else {
				r--;
				if(r > 0)
					index = combination[r]+1;
				else
					index = combination[0]+1;
			}
		}
		return allHands;
	}
}