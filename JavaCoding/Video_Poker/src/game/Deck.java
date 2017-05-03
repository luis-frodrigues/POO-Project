package game;

import java.util.Random;

class Deck {
	Card [] Deck52;
	
	Deck(){
		final char[] ranks={'2','3','4','5','6','7','8','9','T','J','Q','K','A'};
		final char[] suits={'D','S','C','H'};
		int j=0, i=0;
		Deck52 = new Card [52];
		for(j=0;j<4;j++){
			for(i=0; i<13; i++){
				Deck52[i+(j*13)]=new Card(suits[j],ranks[i],i+(j*13));	
			}
		}
		
	}
	
	void shuffle(){
		int index;
		Card  temp;
		Random random = new Random();
		for(int i =51; i>0;i--){
			index = random.nextInt(i);
			temp = Deck52[index];
			Deck52[index]= Deck52[i];
			Deck52[i]=temp;
		}
	}
	
	public void printDeck(int from){
		if((from>=0)&&(from<=51)){
			for(int i=from; i<=51;i++){
				System.out.println(Deck52[i]);
			}
		}else{
			System.out.println("Not a valid position of the Deck");
		}
	}
	
	Card getCardFromDeck(int pos){
		return ( Deck52[pos] );
	}
	
}
