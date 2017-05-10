package game;

class Strategy {
	public void CheckResult(Hand hand, Credit credit, PayTable107 paytable, Statistics statistics){
		if(Verify107.HighPair(hand).getnRet()==1){
			credit.updateActualCredit(paytable.check_payout("Jacks or Better", credit.prev_bet)); 
			statistics.upJacksorBetter();
			System.out.println("Player wins with a JACKS OR BETTER and his credit is "+credit.getActual_credit());
			
		}else if(Verify107.TwoPair(hand).getnRet()==0){
			credit.updateActualCredit(paytable.check_payout("Two Pair", credit.prev_bet)); 
			statistics.upTwoPair();
			System.out.println("Player wins with a TWO PAIRS and his credit is "+credit.getActual_credit());
			
		}else if(Verify107.ThreeOfaKind(hand).getnRet()==1){
			credit.updateActualCredit(paytable.check_payout("Three of a Kind", credit.prev_bet)); 
			statistics.upThreeofaKind();
			System.out.println("Player wins with a THREE OF A KIND and his credit is "+credit.getActual_credit());
			
		}else if(Verify107.FullHouse(hand)){
			credit.updateActualCredit(paytable.check_payout("Full House", credit.prev_bet)); 
			statistics.upFullHouse();
			System.out.println("Player wins with a FULL HOUSE and his credit is "+credit.getActual_credit());
			
		}else if(Verify107.Four5K(hand)){
			credit.updateActualCredit(paytable.check_payout("Four 5-K", credit.prev_bet)); 
			statistics.upFourofaKind();
			System.out.println("Player wins with a FOUR OF A KIND and his credit is "+credit.getActual_credit());
			
		}else if(Verify107.Four24(hand)){
			credit.updateActualCredit(paytable.check_payout("Four 2-4", credit.prev_bet)); 
			statistics.upFourofaKind();
			System.out.println("Payer wins with a FOUR OF A KIND and his credit is "+credit.getActual_credit());
			
		}else if(Verify107.FourAces(hand)){
			credit.updateActualCredit(paytable.check_payout("Four Aces", credit.prev_bet)); 
			statistics.upFourofaKind();
			System.out.println("Payer wins with a FOUR OF A KIND and his credit is "+credit.getActual_credit());
			
		}else if(Verify107.RoyalFlush(hand).getnRet()==0){
			credit.updateActualCredit(paytable.check_payout("Royal Flush", credit.prev_bet)); 
			statistics.upRoyalFlush();
			System.out.println("Payer wins with a ROYAL FLUSH and his credit is "+credit.getActual_credit());
			
		}else if(Verify107.StraightFlush(hand).getnRet()==5){
			credit.updateActualCredit(paytable.check_payout("Straight Flush", credit.prev_bet)); 
			statistics.upStraightFlush();
			System.out.println("Payer wins with a STRAIGHT FLUSH and his credit is "+credit.getActual_credit());
			
		}else if(Verify107.Straight(hand).getnRet()==0){	
			credit.updateActualCredit(paytable.check_payout("Straight", credit.prev_bet)); 
			statistics.upStraight();
			System.out.println("Payer wins with a STRAIGHT and his credit is "+credit.getActual_credit());
			
		}else if(Verify107.Flush(hand).getnRet()==0){
			credit.updateActualCredit(paytable.check_payout("Flush", credit.prev_bet)); 
			statistics.upFlush();
			System.out.println("Payer wins with a FLUSH and his credit is "+credit.getActual_credit());
			
		}else{
			System.out.println("Payer loses and his credit is "+credit.getActual_credit());
		}
	}
	public void Advice(Hand hand, Credit credit, PayTable107 paytable, Statistics statistics){
		
	}
}
