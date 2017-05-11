package game;

import java.util.Random;

public class Deck {

	Card [] Deck52;
	
	
	Deck(){
		Deck52 = new Card [52];
		final char[] ranks={'2','3','4','5','6','7','8','9','T','J','Q','K','A'};
		final char[] suits={'D','S','C','H'};
		for(int j=0;j<4;j++){
			for(int i=0; i<13; i++){	
				Deck52[i+(j*13)]=new Card(suits[j],ranks[i],i+(j*13));	
			}
		}
	}
	
	public Deck(String[] cardsaux){ // não quero que seja public;
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
	
	void shuffle(int from){
		int index;
		Card  temp;
		Random random = new Random();
		for(int i =51; i>=from;i--){
			index = random.nextInt(i+1-from)+from;
			temp = Deck52[index];
			Deck52[index]= Deck52[i];
			Deck52[i]=temp;
		}
	}
	
	public void printDeck(int from){ //não quero que seja public
			if((from>=0)&&(from<Deck52.length)){
				for(int i=from; i<Deck52.length;i++){
					System.out.print(Deck52[i]+" ");
				}
				System.out.println();
			}else{
				System.out.println("Not a valid position of the Deck");
			}
		}
	
	Card getCardFromDeck(int pos){
		if(Deck52.length<pos){
			System.out.println("Deck does not have the required position");
			return(null);
		}else{
			Card card=Deck52[pos];
			return (new Card(card.getSuit(), card.getRank(), card.getValue()));
		}
	}
	
	Card[] GiveNewCards(int n_cards){
		Card[] newcards= new Card[5];
		for(int i=5; i<5+n_cards; i++){
			newcards[i-5]= this.Deck52[i];
		}
		return newcards;	
	}
	
	Card[] GiveNewCards(int n_cards, int cardcount){
		Card[] newcards= new Card[5];
		if (this.Deck52.length<cardcount){
			System.out.println("The provided card file does not have enough cards.");
			System.exit(0);
		}
		for(int i=cardcount; i<cardcount+n_cards; i++){
			newcards[i-cardcount]= this.Deck52[i];
			for(int j=cardcount-1; j>cardcount-6; j--){
				if(newcards[i-cardcount].getValue()==Deck52[j].getValue()){
					System.out.println("This card has already been played in this play. Please check your Card file.");
					System.exit(0);
				}
			}
		}
		return newcards;
	}
	public boolean checkEnoughCards(int cardcount, int n_cards){
		if(Deck52.length>=cardcount+(n_cards)){
			return(true);
		}else{
			return(false);
		}
	}
	
}
