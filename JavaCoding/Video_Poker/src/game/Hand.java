package game;

class Hand {
	Card [] player_hand;
	Deck deck;
	
	Hand(){
		Deck deck= new Deck();
		Card[] player_hand= new Card[5];
	}
	
	public void Hold(String hold){
		
	}
	
	public void giveHand(){
		int pos=0;
		for (pos=0;pos<5;pos++){
			player_hand[pos]= deck.getCardFromDeck(pos);
		}
	}

}
