package game;

class Strategy {
	public static void CheckResult(Hand hand, Credit credit, PayTable107 paytable, Statistics statistics){
		if(Verify107.TwoPair(hand).getnRet()==0){
			credit.updateActualCredit(paytable.check_payout("Two Pair", credit.getPrevBet())); 
			statistics.upTwoPair();
			System.out.println("Player wins with a TWO PAIRS and his credit is "+credit.getActualCredit());
			
		}else if(Verify107.HighPair(hand).getnRet()==1){
			credit.updateActualCredit(paytable.check_payout("Jacks or Better", credit.getPrevBet())); 
			statistics.upJacksorBetter();
			System.out.println("Player wins with a JACKS OR BETTER and his credit is "+credit.getActualCredit());
			
		}else if(Verify107.ThreeOfaKind(hand).getnRet()==1){
			credit.updateActualCredit(paytable.check_payout("Three of a Kind", credit.getPrevBet())); 
			statistics.upThreeofaKind();
			System.out.println("Player wins with a THREE OF A KIND and his credit is "+credit.getActualCredit());
			
		}else if(Verify107.FullHouse(hand)){
			credit.updateActualCredit(paytable.check_payout("Full House", credit.getPrevBet())); 
			statistics.upFullHouse();
			System.out.println("Player wins with a FULL HOUSE and his credit is "+credit.getActualCredit());
			
		}else if(Verify107.Four5K(hand)){
			credit.updateActualCredit(paytable.check_payout("Four 5-K", credit.getPrevBet())); 
			statistics.upFourofaKind();
			System.out.println("Player wins with a FOUR OF A KIND and his credit is "+credit.getActualCredit());
			
		}else if(Verify107.Four24(hand)){
			credit.updateActualCredit(paytable.check_payout("Four 2-4", credit.getPrevBet())); 
			statistics.upFourofaKind();
			System.out.println("Player wins with a FOUR OF A KIND and his credit is "+credit.getActualCredit());
			
		}else if(Verify107.FourAces(hand)){
			credit.updateActualCredit(paytable.check_payout("Four Aces", credit.getPrevBet())); 
			statistics.upFourofaKind();
			System.out.println("Player wins with a FOUR OF A KIND and his credit is "+credit.getActualCredit());
			
		}else if(Verify107.RoyalFlush(hand).getnRet()==0){
			credit.updateActualCredit(paytable.check_payout("Royal Flush", credit.getPrevBet())); 
			statistics.upRoyalFlush();
			System.out.println("Player wins with a ROYAL FLUSH and his credit is "+credit.getActualCredit());
			
		}else if(Verify107.StraightFlush(hand).getnRet()==5){
			credit.updateActualCredit(paytable.check_payout("Straight Flush", credit.getPrevBet())); 
			statistics.upStraightFlush();
			System.out.println("Player wins with a STRAIGHT FLUSH and his credit is "+credit.getActualCredit());
			
		}else if(Verify107.Straight(hand).getnRet()==0){	
			credit.updateActualCredit(paytable.check_payout("Straight", credit.getPrevBet())); 
			statistics.upStraight();
			System.out.println("Player wins with a STRAIGHT and his credit is "+credit.getActualCredit());
			
		}else if(Verify107.Flush(hand).getnRet()==0){
			credit.updateActualCredit(paytable.check_payout("Flush", credit.getPrevBet())); 
			statistics.upFlush();
			System.out.println("Player wins with a FLUSH and his credit is "+credit.getActualCredit());
			
		}else{
			System.out.println("Player loses and his credit is "+credit.getActualCredit());
			
		}
	}
	public static String Advice(Hand hand){
		String Advice;
		RetVerify Ret;
		int vec[]=new int[4];
		if(Verify107.RoyalFlush(hand).getnRet()==0){//Royal Flush
			Advice="h 1 2 3 4 5";
			return Advice;
			
		}else if((Ret=Verify107.FourOfaKind(hand)).getnRet()==1){//Four of a Kind
			return Strategy.StringfyAdvice(Ret, 4);
			
		}else if((Ret=Verify107.StraightFlush(hand)).getnRet()==5){//Straight Flush
			return "h 1 2 3 4 5";
			
		}else if((Ret=Verify107.RoyalFlush(hand)).getnRet()==1){// 4 to Royal Flush
			return Strategy.StringfyAdvice(Ret, 4);
			
		}else if((Ret=Verify107.ThreeAces(hand)).getnRet()==0){//3 Aces
			return Strategy.StringfyAdvice(Ret, 3);
			
		}else if(Verify107.FullHouse(hand)){// Full House
			Advice="h 1 2 3 4 5";
			return Advice;
			
		}else if((Ret=Verify107.Straight(hand)).getnRet()==0){//Straight 
			Advice="h 1 2 3 4 5";
			return Advice;
			
		}else if((Ret=Verify107.Flush(hand)).getnRet()==0){//Flush
			Advice="h 1 2 3 4 5";
			return Advice;
			
		}else if(((Ret=Verify107.ThreeOfaKind(hand)).getnRet()==1)&&(Verify107.ThreeAces(hand).getnRet()!=0)){//Three of a Kind (no Aces)
			return Strategy.StringfyAdvice(Ret, 3);
			
		}else if((Ret=Verify107.StraightFlush(hand)).getnRet()==1){// 4 to Straight Flush
			return Strategy.StringfyAdvice(Ret, 4);
			
		}else if((Ret=Verify107.TwoPair(hand)).getnRet()==0){//Two Pairs
			return Strategy.StringfyAdvice(Ret, 4);
			
		}else if((Ret=Verify107.HighPair(hand)).getnRet()==1){//High Pair
			return Strategy.StringfyAdvice(Ret, 2);
			
		}else if((Ret=Verify107.Flush(hand)).getnRet()==1){//4 to Flush
			return Strategy.StringfyAdvice(Ret, 4);
			
		}else if((Ret=Verify107.RoyalFlush(hand)).getnRet()==2){// 3 to Royal Flush
			return Strategy.StringfyAdvice(Ret, 3);
			
		}else if((Ret=Verify107.OutsideStraight(hand)).getnRet()==1){// 4 to Outside Straight
			return Strategy.StringfyAdvice(Ret, 4);
			
		}else if((Ret=Verify107.LowPair(hand)).getnRet()==1){//Low Pair
			return Strategy.StringfyAdvice(Ret, 2);
			
		}else if((vec[0]=Verify107.CardRank(hand, 12))!=-1&&(vec[1]=Verify107.CardRank(hand, 11))!=-1&&
				(vec[2]=Verify107.CardRank(hand, 10))!=-1&&(vec[3]=Verify107.CardRank(hand, 9))!=-1){//AKQJ unsuited
			Ret=new RetVerify(4);
			Ret.setPos(vec);Ret.setNRet(4);
			if(!(Verify107.Suited(Ret, hand)))
				return Strategy.StringfyAdvice(Ret, 4);
		} 
		if((Ret=Verify107.StraightFlush1(hand)).getnRet()==1){// 3 to Straight Flush type 1
			return Strategy.StringfyAdvice(Ret, 3);
			
		}else if(((Ret=Verify107.InsideStraight(hand)).getnRet()==1)&&(Verify107.HighCardInNCards(Ret, hand, 4)==3)){//4 to inside straight with 3highcards
			return Strategy.StringfyAdvice(Ret, 4);
			
		}else if((vec[0]=Verify107.CardRank(hand, 10))!=-1&&(vec[1]=Verify107.CardRank(hand, 9))!=-1){//QJ suited
			Ret=new RetVerify(2);
			Ret.setPos(vec);Ret.setNRet(2);
			if((Verify107.Suited(Ret, hand)))
				return Strategy.StringfyAdvice(Ret, 2);
		}
		if(((Ret=Verify107.Flush(hand)).getnRet()==2)&&(Verify107.HighCardInNCards(Ret, hand, 3)==2)){//3 to a Flush with 2 High Cards
			return Strategy.StringfyAdvice(Ret, 3);
			
		}else if((Ret=Verify107.HighCard(hand)).getnRet()==2&&(Verify107.Suited(Ret, hand))){//2 suited High Cards
			return Strategy.StringfyAdvice(Ret, 2);
			
		}else if(((Ret=Verify107.InsideStraight(hand)).getnRet()==1)&&(Verify107.HighCardInNCards(Ret, hand, 4)==2)){//4 to inside straight with 2highcards
			return Strategy.StringfyAdvice(Ret, 4);
			
		}else if((Ret=Verify107.StraightFlush2(hand)).getnRet()==1){//3 to a straight flush type 2
			return Strategy.StringfyAdvice(Ret, 3);
			
		}else if(((Ret=Verify107.InsideStraight(hand)).getnRet()==1)&&(Verify107.HighCardInNCards(Ret, hand, 4)==1)){//4 to inside straight with 1highcards
			return Strategy.StringfyAdvice(Ret, 4);
			
		}else if((vec[0]=Verify107.CardRank(hand, 11))!=-1&&(vec[1]=Verify107.CardRank(hand, 10))!=-1&&
				(vec[2]=Verify107.CardRank(hand, 9))!=-1){//KQJ unsuited
			Ret=new RetVerify(3);
			Ret.setPos(vec);Ret.setNRet(3);
			if(!(Verify107.Suited(Ret, hand)))
				return Strategy.StringfyAdvice(Ret, 3);
		}
		if((vec[0]=Verify107.CardRank(hand, 9))!=-1&&(vec[1]=Verify107.CardRank(hand, 8))!=-1){//JT suited
			Ret=new RetVerify(2);
			Ret.setPos(vec);Ret.setNRet(2);
			if((Verify107.Suited(Ret, hand)))
				return Strategy.StringfyAdvice(Ret, 2);
		} 
		if((vec[0]=Verify107.CardRank(hand, 10))!=-1&&(vec[1]=Verify107.CardRank(hand, 9))!=-1){//QJ unsuited
			Ret=new RetVerify(2);
			Ret.setPos(vec);Ret.setNRet(2);
			if(!(Verify107.Suited(Ret, hand)))
				return Strategy.StringfyAdvice(Ret, 2);
		}
		if(((Ret=Verify107.Flush(hand)).getnRet()==2)&&(Verify107.HighCardInNCards(Ret, hand, 3)==1)){//3 to Flush with 1 High Card
			return Strategy.StringfyAdvice(Ret, 3);
			
		}else if((vec[0]=Verify107.CardRank(hand, 10))!=-1&&(vec[1]=Verify107.CardRank(hand, 8))!=-1){//QT suited
			Ret=new RetVerify(2);
			Ret.setPos(vec);Ret.setNRet(2);
			if((Verify107.Suited(Ret, hand)))
				return Strategy.StringfyAdvice(Ret, 2);
		}
		if((Ret=Verify107.StraightFlush3(hand)).getnRet()==1){//3 to straight flush type 3
			return Strategy.StringfyAdvice(Ret, 3);
			
		}else if((vec[0]=Verify107.CardRank(hand, 11))!=-1&&(vec[1]=Verify107.CardRank(hand, 10))!=-1){//KQ unsuited
			Ret=new RetVerify(2);
			Ret.setPos(vec);Ret.setNRet(2);
			if(!(Verify107.Suited(Ret, hand)))
				return Strategy.StringfyAdvice(Ret, 2);
		}
		if((vec[0]=Verify107.CardRank(hand, 11))!=-1&&(vec[1]=Verify107.CardRank(hand, 9))!=-1){//KJ unsuited
			Ret=new RetVerify(2);
			Ret.setPos(vec);Ret.setNRet(2);
			if(!(Verify107.Suited(Ret, hand)))
				return Strategy.StringfyAdvice(Ret, 2);
		}
		if((vec[0]=Verify107.CardRank(hand, 12))!=-1){//one Ace
			Ret=new RetVerify(1);
			Ret.setPos(vec);Ret.setNRet(1);
			return Strategy.StringfyAdvice(Ret, 1);
			
		}else if((vec[0]=Verify107.CardRank(hand, 11))!=-1&&(vec[1]=Verify107.CardRank(hand, 8))!=-1){//KT suited
			Ret=new RetVerify(2);
			Ret.setPos(vec);Ret.setNRet(2);
			if((Verify107.Suited(Ret, hand)))
				return Strategy.StringfyAdvice(Ret, 2);
		}
		if((vec[0]=Verify107.CardRank(hand, 11))!=-1){	//one King
			Ret=new RetVerify(1);
			Ret.setPos(vec);Ret.setNRet(1);
			return Strategy.StringfyAdvice(Ret, 1);
			
		}else if((vec[0]=Verify107.CardRank(hand, 10))!=-1){//one Queen
			Ret=new RetVerify(1);
			Ret.setPos(vec);Ret.setNRet(1);
			return Strategy.StringfyAdvice(Ret, 1);
			
		}else if((vec[0]=Verify107.CardRank(hand, 9))!=-1){//one Jack
			Ret=new RetVerify(1);
			Ret.setPos(vec);Ret.setNRet(1);
			return Strategy.StringfyAdvice(Ret, 1);
			
		}else if(((Ret=Verify107.InsideStraight(hand)).getnRet()==1)&&(Verify107.HighCardInNCards(Ret, hand, 4)==0)){//4 to inside straight with 0 highcards
			return Strategy.StringfyAdvice(Ret, 4);
		
		}else if(((Ret=Verify107.Flush(hand)).getnRet()==2)&&(Verify107.HighCardInNCards(Ret, hand, 3)==0)){//3 to flush with 0 highcards
			return Strategy.StringfyAdvice(Ret, 3);
		}else{
			return "h";
		}
	}

	private static String StringfyAdvice(RetVerify Ret, int nHolds){
		String Advice="h";
		for(int i=0; i<nHolds; i++){
			Advice=Advice+" "+Integer.toString(Ret.getPosRet(i));
		}
		return Advice;
	}
}
