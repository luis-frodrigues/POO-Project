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
	
	void printDeck(int from){
			if((from>=0)&&(from<=51)){
				for(int i=from; i<=51;i++){
					System.out.print(Deck52[i]+" ");
				}
				System.out.println();
			}else{
				System.out.println("Not a valid position of the Deck");
			}
		}
	Card getCardFromDeck(int pos){
		Card card=Deck52[pos];
		return (new Card(card.getSuit(), card.getRank(), card.getValue()));
	}
	Card[] GiveNewCards(int n_cards){
		Card[] newcards= new Card[5];
		for(int i=5; i<5+n_cards; i++){
			newcards[i-5]= this.Deck52[i];
		}
		return newcards;	
	}
}
