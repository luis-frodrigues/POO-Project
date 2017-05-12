package game;

import java.util.Random;

public class Deck {

	protected Card [] Deck52;
	protected Deck(){
		Deck52 = new Card [52];
		final char[] ranks={'2','3','4','5','6','7','8','9','T','J','Q','K','A'};
		final char[] suits={'D','S','C','H'};
		for(int j=0;j<4;j++){
			for(int i=0; i<13; i++){	
				Deck52[i+(j*13)]=new Card(suits[j],ranks[i],i+(j*13));	
			}
		}
	}
	
	/**
	* Receives a string with cards and creates a deck with
	* those cards. Only cards in valid format are inserted 
	* on the deck. Format valid of the suits is "D" or "C" 
	* or "H" or "D".Format valid of the Ranks is "2" or "3"
	* or "4" or "5"or "6" or "7" or "8" or "9" or "T" or 
	* "J" or "Q" or "K" or "A". Also the format of the card 
	*  is Rank+Suit => "2S". 
	* @param cardsaux
	*/
	Deck(String[] cardsaux){ // protected
		boolean Error;
		Deck52 = new Card[cardsaux.length];
		final char[] ranks={'2','3','4','5','6','7','8','9','T','J','Q','K','A'};
		final char[] suits={'D','S','C','H'};
		
		for(int i=0; i<cardsaux.length; i++){
			Error=true;
			for (int j=0;j<ranks.length;j++){
				if(cardsaux[i].charAt(0)==(ranks[j])){
					Error=false;
					for(int z=0; z<suits.length; z++){
						if(cardsaux[i].charAt(1)==(suits[z])){
							Error=false;
							Deck52[i]= new Card(suits[z], ranks[j],j+(z*13));
						}
					}
				}
			}
			if (Error){
				System.out.println("There is an invalid card in your card file. Please go check it.");
				System.exit(1);
			}
		}
	}
	
	/**
	 * Shuffles the deck from the "int from" position.
	 * @param from
	 */
	protected void shuffle(int from){
		int index;
		Card  temp;
		Random random = new Random();
		for(int i =(Deck52.length-1); i>=from;i--){
			index = random.nextInt(i+1-from)+from;
			temp = Deck52[index];
			Deck52[index]= Deck52[i];
			Deck52[i]=temp;
		}
	}
	
	/**
	 * Prints the deck from a certain position "from"
	 * @param from
	 */
	public void printDeck(int from){
		if((from>=0)&&(from<Deck52.length)){
			for(int i=from; i<Deck52.length;i++){
				System.out.print(Deck52[i]+" ");
			}
			System.out.println();
		}else{
			System.out.println("Not a valid position of the Deck");
		}
	}
	
	/**
	 * Gives the card in the position "pos" of the deck.
	 * @param pos
	 * @return Returns the card in the position "pos"
	 * of the deck.
	 */
	public Card getCardFromDeck(int pos){
		if(Deck52.length<pos){
			System.out.println("Deck does not have the required position");
			return(null);
		}else{
			Card card=Deck52[pos];
			return (new Card(card.getSuit(), card.getRank(), card.getValue()));
		}
	}
	
	/**
	 * Gives "nCards" from the 5th position of the
	 * the deck  
	 * @param n_cards
	 * @return
	 */
	public Card[] GiveNewCards(int n_cards){
		Card[] newcards= new Card[5];
		for(int i=5; i<5+n_cards; i++){
			newcards[i-5]= this.Deck52[i];
		}
		return newcards;	
	}
	
	/**
	 * Gives new number of Cards(nCards) from the position
	 * cardcount of the deck. 
	 * @param nCards
	 * @param cardcount
	 * @return Returns an array of size nCards in which 
	 * are inserted th
	 * e Cards after the position cardcount
	 * of the deck. 
	 */
	public Card[] GiveNewCards(int nCards, int cardcount){
		Card[] newcards= new Card[nCards];
		if (this.Deck52.length<cardcount+nCards){
			System.out.println("The provided card file does not have enough cards.");
			System.exit(0);
		}
		for(int i=cardcount; i<cardcount+nCards; i++){
			newcards[i-cardcount]= this.Deck52[i];
			for(int j=cardcount-1; j>=0; j--){
				if(newcards[i-cardcount].getValue()==Deck52[j].getValue()){
					System.out.println("This card has already been played in this play. Please check your Card file.");
					System.exit(0);
				}
			}
		}
		return newcards;
	}
	
	/**
	 * Checks if that are enough cards for the corresponding 
	 * comand
	 * @param cardcount
	 * @param n_cards
	 * @return
	 */
	protected boolean checkEnoughCards(int cardcount, int n_cards){
		if(Deck52.length>=cardcount+(n_cards)){
			return(true);
		}else{
			return(false);
		}
	}
	
}
