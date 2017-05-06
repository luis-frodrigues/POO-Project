package game;

public interface Verify10_7 extends Verify{
	static int FourAces(Card[] deck ){
		return 0;
	}
	static int Four2_4(Card[] deck ){
		return 0;
	}
	
	static int Four5_K(Card[] deck ){
		return 0;
	}
	
	//Returns the position of the Card or -1
	//if Card is not on the deck
	static int Card(Card[] deck, int value_of_card){
		//if(value_of _card<0||value_of _card>51)
		for(int i=0; i<4;i++){
			if((deck[i].getValue()%13)==value_of_card%13)
				return i;
		}
		return -1;
	}
}
