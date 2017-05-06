package game;

public interface Verify10_7 extends Verify{
	static int FourAces(Card[] deck ){
		return 0;
	}
	static int Four24(Card[] deck ){
		return 0;
	}
	
	static int Four5K(Card[] deck ){
		return 0;
	}
	
	static int InsideStraight(Card[] deck ){
		return 0;
	}
	
	static int OutsideStraight(Card[] deck ){
		return 0;
	}

	static int StraightFlush1(Card[] deck ){
		return 0;
	}
	
	static int StraightFlush2(Card[] deck ){
		return 0;
	}
	
	static int StraightFlush3(Card[] deck ){
		return 0;
	}
	
	//Returns how many Aces are needed to fulfill
	// ThreeAces and the positions of the first 3 Aces
	static RetVerify ThreeAces(Card[] deck ){
		int Aces_needed=3, aux[]= new int[3];
		
		for(int i=0;i<4;i++){
			if((deck[i].getValue()%13)==12){
				if(Aces_needed>0){
					aux[3-Aces_needed]=i+1;
					Aces_needed--;
				}
			}
		}
		RetVerify Ret= new RetVerify(3-Aces_needed);
		if(Aces_needed!=3)
			Ret.setPos(aux);
		Ret.n_ret=Aces_needed;
		return Ret;
	}
	
	//Returns the position of the Card or -1
	//if the Card is not on the deck
	static int CardRank(Card[] deck, int value_of_card){
		//if(value_of _card<0||value_of _card>51)
		for(int i=0; i<4;i++){
			if((deck[i].getValue()%13)==value_of_card%13)
				return i;
		}
		return -1;
	}
	
	//Receives a RetVerify with n_ret equals to the number//
	// of cards that should be analyzed and returns true  //
	// if cards are suited and false otherwise			  //
	static boolean Suited(RetVerify CardsToVerify ){
		if(CardsToVerify.n_ret<1)
			return false;
		if(CardsToVerify.n_ret==1)
			return true;
		for(int i=1; i<CardsToVerify.n_ret;i++){
			if((CardsToVerify.getPosRet(i)/13)!=(CardsToVerify.getPosRet(0)/13))
				return false;
		}
		return true;
	}
}
