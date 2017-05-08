package game;

public class Verify10_7 extends Verify{
	//Returns true if 4 Aces and 
	//false otherwise
	static boolean FourAces(Hand hand ){
		int nAces=0;
		for(int i=0; i<4;i++){
			if(hand.getPlayerCardValue(i)%13==12)
				nAces++;
		}
		if(nAces==4)
			return true;
		return false;
	}
	
	//Returns true if Poker of value from 2 to 4  
	//and false otherwise
	static boolean Four24(Hand hand ){
		int value=hand.getPlayerCardValue(0)%13;
		int nEqualCards=1;
		if(!(value>=0&&value<=2))
			return false;
		for(int i=1; i<4; i++){
			if(hand.getPlayerCardValue(0)%13==value)
				nEqualCards++;
		}
		if(nEqualCards==4)
			return true;
		return false;
	}
	
	//Returns true if Poker of value from 5 to King  
	//and false otherwise
	static boolean Four5K(Hand hand ){
		int value=hand.getPlayerCardValue(0)%13;
		int nEqualCards=1;
		if(!(value>=3&&value<=11))
			return false;
		for(int i=1; i<4; i++){
			if(hand.getPlayerCardValue(0)%13==value)
				nEqualCards++;
		}
		if(nEqualCards==4)
			return true;
		return false;
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
		Ret.setNRet(Aces_needed);
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
		if(CardsToVerify.getnRet()<1)
			return false;
		if(CardsToVerify.getnRet()==1)
			return true;
		for(int i=1; i<CardsToVerify.getnRet();i++){
			if((CardsToVerify.getPosRet(i)/13)!=(CardsToVerify.getPosRet(0)/13))
				return false;
		}
		return true;
	}
}
