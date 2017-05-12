package strategy;
import java.util.Arrays;

import game.Hand;

/**
 * This class have package visibility and therefore
 * it can't be used outside the package. It is specific
 * of double bonus 10/7 video poker. Does verifications
 * on the hand types associated with this game variation.
 * @author Luís Rodrigues
 * @author Eduardo Crespo
 * @author Eurico Lopes
 */
class Verify107 extends Verify{
	
	/**
	 * Verifies if the hand has 4 Aces.
	 * @param hand
	 * @return Returns true if the Hand has
	 *  four Aces and false otherwise.
	 */
	static boolean FourAces(Hand hand ){
		int nAces=0;
		for(int i=0; i<=4;i++){
			if(hand.getPlayerCardValue(i)%13==12)
				nAces++;
		}
		if(nAces==4)
			return true;
		return false;
	}
	
	//
	/**
	 * Verifies if the hand has four of a kind
	 * where the rank must be between 2 and 4 inclusively. 
	 * @param hand
	 * @return Returns true if the hand has a Poker of 
	 * values from 2 to 4 and false otherwise.
	 */
	static boolean Four24(Hand hand ){
		int value1=hand.getPlayerCardValue(0)%13;
		int value2=hand.getPlayerCardValue(1)%13;
		int nEqualCards=1;
		if(value1>2&&value2>2)
			return false;
		for(int i=0; i<2; i++){
			nEqualCards=1;
			for(int j=i+1; j<=4;j++){
				if((hand.getPlayerCardValue(i)%13==hand.getPlayerCardValue(j)%13)&&(hand.getPlayerCardValue(i)%13)<=2)
					nEqualCards++;
			}
			if(nEqualCards==4)
				return true;
		}
		return false;
	}
	
	/**
	 * Verifies if the hand has four of a kind
	 * where the rank must be between 5 and K inclusively.
	 * @param hand
	 * @return Returns true if the hand has a Poker of 
	 * values from 5 to K and false otherwise.
	 */
	static boolean Four5K(Hand hand ){
		int value1=hand.getPlayerCardValue(0)%13;
		int value2=hand.getPlayerCardValue(1)%13;
		int nEqualCards=1;
		if((value1<3||value1==12)&&(value2<3||value2==12))
			return false;
		for(int i=0; i<2; i++){
			nEqualCards=1;
			for(int j=i+1; j<=4;j++){
				if((hand.getPlayerCardValue(i)%13==hand.getPlayerCardValue(j)%13)&&(hand.getPlayerCardValue(i)%13)>2&&(hand.getPlayerCardValue(i)%13)!=12)
					nEqualCards++;
			}
			if(nEqualCards==4)
				return true;
		}
		return false;
	}
	
	/**
	 * Verifies if the Hand contains a Inside Straight.
	 * @param hand
	 * @return If false returns nRet=0 and otherwise returns
	 * nRet=1
	 */
	static RetVerify InsideStraight(Hand hand ){
		RetVerify Ret=Verify.Straight(hand);
		int maxValue=0,minValue=12, Ace=0, LowAce=0,HighAce=0;
		if(Ret.getnRet()!=1){
			Ret.setNRet(0);
			Ret.setPos(null);
			return Ret;
		}
		//Gets Max and Min value of Cards that must be hold
		//to get a Straight 
		for(int k=0; k<=3;k++){
			minValue=Math.min((hand.getPlayerCardValue(Ret.getPosRet(k)-1)%13) , minValue);
			maxValue=Math.max((hand.getPlayerCardValue(Ret.getPosRet(k)-1)%13) , maxValue);
		}
		//If straight contains an Ace
		for(int i=0;i<4;i++){
			if(maxValue==12)
				Ace=1;
		}
		if(Ace==1){
			for(int i=0;i<4;i++){
				if((hand.getPlayerCardValue(Ret.getPosRet(i)-1)%13==9)||(hand.getPlayerCardValue(Ret.getPosRet(i)-1)%13==10)||(hand.getPlayerCardValue(Ret.getPosRet(i)-1)%13==11)||(hand.getPlayerCardValue(Ret.getPosRet(i)-1)%13==8))	
					HighAce++;
				if((hand.getPlayerCardValue(Ret.getPosRet(i)-1)%13==0)||(hand.getPlayerCardValue(Ret.getPosRet(i)-1)%13==1)||(hand.getPlayerCardValue(Ret.getPosRet(i)-1)%13==2)||(hand.getPlayerCardValue(Ret.getPosRet(i)-1)%13==3))	
					LowAce++;
			}
			if(HighAce==3||LowAce==3)
				return Ret;
			Ret.setNRet(0);
			Ret.setPos(null);
			return Ret;
		}//If straight contains an Ace
		
		if((maxValue-minValue)==4){
			return Ret;
		}
		
		Ret.setNRet(0);
		Ret.setPos(null);
		return Ret;
	}
	
	/**
	 * Verifies if the Hand contains a Outside Straight.
	 * @param hand
	 * @return If false returns nRet=0 and otherwise returns
	 * nRet=1
	 */
	static RetVerify OutsideStraight(Hand hand ){
		RetVerify Ret=Verify.Straight(hand);
		int maxValue=0,minValue=12, Ace=0, LowAce=0,HighAce=0;
		if(Ret.getnRet()!=1){
			Ret.setNRet(0);
			Ret.setPos(null);
			return Ret;
		}
		//Gets Max and Min value of Cards that must be hold
		//to get a Straight 
		for(int k=0; k<=3;k++){
			minValue=Math.min((hand.getPlayerCardValue(Ret.getPosRet(k)-1)%13) , minValue);
			maxValue=Math.max((hand.getPlayerCardValue(Ret.getPosRet(k)-1)%13) , maxValue);
		}
		//If straight contains an Ace
		for(int i=0;i<4;i++){
			if(maxValue==12)
				Ace=1;
		}
		if(Ace==1){
			for(int i=0;i<4;i++){
				if((hand.getPlayerCardValue(Ret.getPosRet(i)-1)%13==9)||(hand.getPlayerCardValue(Ret.getPosRet(i)-1)%13==10)||(hand.getPlayerCardValue(Ret.getPosRet(i)-1)%13==11)||(hand.getPlayerCardValue(Ret.getPosRet(i)-1)%13==8))	
					HighAce++;
				if((hand.getPlayerCardValue(Ret.getPosRet(i)-1)%13==0)||(hand.getPlayerCardValue(Ret.getPosRet(i)-1)%13==1)||(hand.getPlayerCardValue(Ret.getPosRet(i)-1)%13==2)||(hand.getPlayerCardValue(Ret.getPosRet(i)-1)%13==3))	
					LowAce++;
			}
			if(HighAce==3||LowAce==3){
				Ret.setNRet(0);
				Ret.setPos(null);
				return Ret;
			}
			return Ret;
		}//If straight contains an Ace

		if((maxValue-minValue)==4){
			Ret.setNRet(0);
			Ret.setPos(null);
			return Ret;
		}
		
		return Ret;
	}

	/**
	 * Verifies if the Hand contains a StraightFlush1 and
	 * gives the positions of the cards if it contains.
	 * @param hand
	 * @return Returns 0 if it's not StraightFlush1 and 1 
	 * if it is, with positions of cards to hold.
	 */
	static RetVerify StraightFlush1(Hand hand ){
		RetVerify Ret= Verify.StraightFlush(hand);
		int nGaps=0, Verify234=0,VerifyA23=0 , nHighCards=0;
		int Ace=0, AceLow=0;
		if(Ret.getnRet()!=3){
			Ret.setNRet(0);
			Ret.setPos(null);
			return Ret;
		}
			
		nGaps=Verify107.NumberOfGaps(Ret, hand);
		if(nGaps==0){
			for(int i=0;i<3;i++){
				if(hand.getPlayerCardValue(Ret.getPosRet(i)-1)%13==0||hand.getPlayerCardValue(Ret.getPosRet(i)-1)%13==1||hand.getPlayerCardValue(Ret.getPosRet(i)-1)%13==2)
					Verify234++;
				if(hand.getPlayerCardValue(Ret.getPosRet(i)-1)%13==0||hand.getPlayerCardValue(Ret.getPosRet(i)-1)%13==1||hand.getPlayerCardValue(Ret.getPosRet(i)-1)%13==12)
					VerifyA23++;
			}
			if(Verify234==3||VerifyA23==3){
				Ret.setNRet(0);
				Ret.setPos(null);
				return Ret;
			}
			Ret.setNRet(1);
			return Ret;
		}else if(nGaps==1){
			//Number of HighCards
			nHighCards=Verify107.HighCard(Ret, hand);
			if(nHighCards<1){
				Ret.setNRet(0);
				Ret.setPos(null);
				return Ret;
			}//Number of HighCards
			
			//Verify if AceLow
			for(int k=0;k<3;k++){
				if(hand.getPlayerCardValue(Ret.getPosRet(k)-1)%13==12)
					Ace=1;
				if(hand.getPlayerCardValue(Ret.getPosRet(k)-1)%13==0||hand.getPlayerCardValue(Ret.getPosRet(k)-1)%13==1||hand.getPlayerCardValue(Ret.getPosRet(k)-1)%13==2)
					AceLow++;
			}
			if(Ace==1&&AceLow==2){
				Ret.setNRet(0);
				Ret.setPos(null);
				return Ret;
			}//Verify if AceLow
			Ret.setNRet(1);
			return Ret;
		}else if(nGaps==2){
			//Number of HighCards
			nHighCards=Verify107.HighCard(Ret, hand);
			if(nHighCards<2){
				Ret.setNRet(0);
				Ret.setPos(null);
				return Ret;
			}//Number of HighCards
			Ret.setNRet(1);
			return Ret;
		}
		
		Ret.setNRet(0);
		Ret.setPos(null);
		return Ret;
	}

	/**
	 * * Verifies if the Hand contains a StraightFlush2 and
	 * gives the positions of the cards if it contains.
	 * @param hand
	 * @return Returns 0 if it's not StraightFlush2 and 1 
	 * if it is, with positions of cards to hold.
	 */
	static RetVerify StraightFlush2(Hand hand ){
		RetVerify Ret= Verify.StraightFlush(hand);
		int nGaps=0, Verify234=0,VerifyA23=0 , nHighCards=0;
		int Ace=0, AceLow=0;
		if(Ret.getnRet()!=3){
			Ret.setNRet(0);
			Ret.setPos(null);
			return Ret;
		}
			
		nGaps=Verify107.NumberOfGaps(Ret, hand);
		if(nGaps==0){
			for(int i=0;i<3;i++){
				if(hand.getPlayerCardValue(Ret.getPosRet(i)-1)%13==0||hand.getPlayerCardValue(Ret.getPosRet(i)-1)%13==1||hand.getPlayerCardValue(Ret.getPosRet(i)-1)%13==2)
					Verify234++;
				if(hand.getPlayerCardValue(Ret.getPosRet(i)-1)%13==0||hand.getPlayerCardValue(Ret.getPosRet(i)-1)%13==1||hand.getPlayerCardValue(Ret.getPosRet(i)-1)%13==12)
					VerifyA23++;
			}
			if(Verify234==3||VerifyA23==3){
				Ret.setNRet(1);
				return Ret;
			}
			Ret.setNRet(0);
			Ret.setPos(null);
			return Ret;
		}else if(nGaps==1){
			//Verify if AceLow
			for(int k=0;k<3;k++){
				if(hand.getPlayerCardValue(Ret.getPosRet(k)-1)%13==12)
					Ace=1;
				if(hand.getPlayerCardValue(Ret.getPosRet(k)-1)%13==0||hand.getPlayerCardValue(Ret.getPosRet(k)-1)%13==1||hand.getPlayerCardValue(Ret.getPosRet(k)-1)%13==2)
					AceLow++;
			}
			if(Ace==1&&AceLow==2){
				Ret.setNRet(1);
				return Ret;
			}//Verify if AceLow
			
			//Number of HighCards
			nHighCards=Verify107.HighCard(Ret, hand);
			if(nHighCards>=1){
				Ret.setNRet(0);
				Ret.setPos(null);
				return Ret;
			}//Number of HighCards
			
			Ret.setNRet(1);
			return Ret;
		}else if(nGaps==2){
			//Number of HighCards
			nHighCards=Verify107.HighCard(Ret, hand);
			if(nHighCards!=1){
				Ret.setNRet(0);
				Ret.setPos(null);
				return Ret;
			}//Number of HighCards
			Ret.setNRet(1);
			return Ret;
		}
		
		Ret.setNRet(0);
		Ret.setPos(null);
		return Ret;
	}
	
	/**
	 * Verifies if the Hand contains a StraightFlush3 and
	 * gives the positions of the cards if it contains.
	 * @param hand
	 * @return Returns 0 if it's not StraightFlush3 and 1 
	 * if it is, with positions of cards to hold.
	 */
	static RetVerify StraightFlush3(Hand hand ){
		RetVerify Ret =Verify.StraightFlush(hand);
		int nGaps=0, nHighCards=0;
		if(Ret.getnRet()!=3){
			Ret.setNRet(0);
			Ret.setPos(null);
			return Ret;
		}
		nGaps=Verify107.NumberOfGaps(Ret, hand);
		if(nGaps==2){
			nHighCards=Verify107.HighCard(Ret, hand);
			if(nHighCards==0){
				Ret.setNRet(1);
				return Ret;
			}
			Ret.setNRet(0);
			Ret.setPos(null);
			return Ret;
		}
		
		Ret.setNRet(0);
		Ret.setPos(null);
		return Ret;
	}
	
	/**
	 * Verifies how many Aces are needed to fulfill
	 * ThreeAces and gives the positions of the firsts Aces
	 * inthe Hand.
	 * @param hand
	 * @return Returns how many Aces are needed to fulfill
	 * ThreeAces and the positions of the first 3 Aces
	 */
	static RetVerify ThreeAces(Hand hand ){
		int Aces_needed=3, aux[]= new int[3];
		
		for(int i=0;i<=4;i++){
			if(hand.getPlayerCardValue(i)%13==12){
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
	

	/**
	 * Gives the position of the first Card with the same Rank as
	 * the correspondent Rank of card with the value that is given 
	 * in the parameter 'value'. 
	 * @param hand
	 * @param value_of_card
	 * @return Returns the position of the first Card with the same Rank as
	 * the correspondent Rank of card with the value that is given 
	 * in the parameter 'value'. Returns -1 if there is not card with
	 *  taht rank on the deck -1 if there is no card with that rank 
	 *  on the deck.
	 */
	static int CardRank(Hand hand, int value){
		if(value<0||value>51)
			return -1;
		for(int i=0; i<=4;i++){
			if(hand.getPlayerCardValue(i)%13==value%13)
				return i+1;
		}
		return -1;
	}
	
	/**
	 * Verifies if cards are suited. The RetVerify parameter contains
	 * the positions of the cards that gonna be evaluated and the 
	 * Hand contains the cards. The number of cards that gonna be
	 * checked must be in the atribute nRet from RetVerify. 
	 * @param CardsToVerify Contains nRet equals to the number of 
	 * cards that should be analyzed and their positions in the hand.
	 * @param hand
	 * @return Returns true if cards are suited and false otherwise			  
	 */
	static boolean Suited(RetVerify CardsToVerify, Hand hand ){
		if(CardsToVerify.getnRet()<1)
			return false;
		if(CardsToVerify.getnRet()==1)
			return true;
		for(int i=1; i<CardsToVerify.getnRet();i++){
			if((hand.getPlayerCardValue(CardsToVerify.getPosRet(i)-1)/13)!=(hand.getPlayerCardValue(CardsToVerify.getPosRet(0)-1)/13))
				return false;
		}
		return true;
	}
	
	/**
	 * Checks the number of gaps for a given set of cards. The 
	 * information of the set of cards is in the RetVerify 'Ret',
	 * where the positions of the cards are in PosRet field.
	 * @param Ret Contains the positions of the cards in the hand.
	 * @param hand
	 * @return Returns the number of gaps for straight flushes.
	 */
	private static int NumberOfGaps(RetVerify Ret, Hand hand){
		int vec[]= new int[3], Ace=0, AceLow=0, nGaps=0;
		for(int i=0;i<3;i++){
			vec[i]=hand.getPlayerCardValue(Ret.getPosRet(i)-1);
			if(vec[i]%13==12)
				Ace=1;
			if(vec[i]%13==0||vec[i]%13==1||vec[i]%13==2||vec[i]%13==3)
				AceLow++;
		}
		Arrays.sort(vec);
		//If AceLow
		if(Ace==1&&AceLow==2){
			nGaps=vec[0]%13;
			nGaps+=(vec[1]%13)-nGaps-1;
			return nGaps;
		}//If AceLow
		
		for(int j=2;j>0; j--){
			nGaps+=(vec[j]%13)-(vec[j-1]%13)-1;
		}
		return nGaps;
	}

	/**
	 * Checks the number of high cards for a given set of cards. The 
	 * information of the set of cards is in the RetVerify 'Ret',
	 * where the positions of the cards are in PosRet field.
	 * @param Ret Contains the positions of the cards.
	 * @param hand
	 * @return Returns the number of highCards for the different
	 * types of straight flush
	 */
	private static int HighCard(RetVerify Ret, Hand hand ) {
		int flag=0;
		for(int i=0; i<3;i++){
			if(hand.getPlayerCardValue(Ret.getPosRet(i)-1)%13>=9)
				flag++;
		}
		return flag;
	}
	
	/**
	 * Gives the number of High Cards for a given set of cards. The 
	 * information of the set of cards is in the RetVerify 'Ret',
	 * where the positions of the cards are in PosRet field. The 
	 * number of cards to check is the value of 'nCards'.
	 * @param Ret Contains the positions of the cards in the hand.
	 * @param hand
	 * @param nCards Number of cards to check.
	 * @return Returns the number of highCards in 'nCards'.
	 */
	static int HighCardInNCards(RetVerify Ret, Hand hand, int nCards ) {
		int flag=0;
		for(int i=0; i<nCards;i++){
			if(hand.getPlayerCardValue(Ret.getPosRet(i)-1)%13>=9)
				flag++;
		}
		return flag;
	}
}
