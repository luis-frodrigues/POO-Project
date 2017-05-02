package game;

import java.util.Random;

class Deck {
	Card [] Deck52;
	final char[] ranks={'2','3','4','5','6','7','8','9','T','J','Q','K','A'};
	final char[] suits={'D','S','C','H'};
	
	Deck(){
		Deck52 = new Card [52];
		for(int j=0;j<4;j++){
			for(int i=0; i<13; i++){	
				Deck52[i+(j*13)]=new Card(suits[i],ranks[j-1],j+2);
			}
		}
		
	}
	
	void shuffle(int from){
		int index;
		Card  temp;
		Random random = new Random();
		for(int i =51; i>0;i--){
			index = random.nextInt(i+1-from)+from;
			temp = Deck52[index];
			Deck52[index]= Deck52[i];
			Deck52[i]=temp;
		}
	}
	
}
