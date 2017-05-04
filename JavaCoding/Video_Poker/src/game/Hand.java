package game;

public class Hand {
	Card [] player_hand;
	Deck deck;
	
	public Hand(){
		deck = new Deck();
		player_hand = new Card[5];
	}
	
	public void Hold(String hold){
		
	}
	
	public void giveHand(){
		int pos=0;
		deck.shuffle();
		for (pos=0;pos<5;pos++){
			player_hand[pos]= deck.getCardFromDeck(pos);
		}
	}
	
	public void printHand(){
		int i=0;
		for(i=0; i<5;i++){
			System.out.print(player_hand[i]+" ");
		}
	}

}
