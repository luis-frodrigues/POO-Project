package game;

class Statistics {

	private int[] stats = new int[] {0,0,0,0,0,0,0,0,0,0,0};
	
	void printstatistics (Credit credit){
		
		int sum = 0, actualCredit, inicialCredit;
		float gain;
		
		System.out.println();
		System.out.println("Hand               Nb   ");
		System.out.println("________________________");
		System.out.println("Jacks or Better    " + stats[0] + "   ");
		System.out.println("Two Pair           " + stats[1] + "   ");
		System.out.println("Three of a Kind    " + stats[2] + "   ");
		System.out.println("Straight           " + stats[3] + "   ");
		System.out.println("Flush              " + stats[4] + "   ");
		System.out.println("Full House         " + stats[5] + "   ");
		System.out.println("Four of a Kind     " + stats[6] + "   ");
		System.out.println("Straight Flush     " + stats[7] + "   ");
		System.out.println("Royal Flush        " + stats[8] + "   ");
		System.out.println("Other              " + stats[9] + "   ");
		System.out.println("________________________");
		for(int i=0; i<=9; i++)
			sum = sum + stats[i];
		System.out.println("Total              " + sum + "   ");
		System.out.println("________________________");
		
		actualCredit=credit.getActual_credit();
		inicialCredit=credit.getInitial_credit();
		gain = (float) actualCredit/inicialCredit;
		gain = gain*100;
		System.out.print("Credit      " + actualCredit + "(");
		System.out.printf("%.2f", gain);
		System.out.println("%)");
	}
	
	void upJacksorBetter(){
		stats[0]++;
	}
	void upTwoPair(){
		stats[1]++;
	}
	void upThreeofaKind(){
		stats[2]++;
	}
	void upStraight(){
		stats[3]++;
	}
	void upFlush(){
		stats[4]++;
	}
	void upFullHouse(){
		stats[5]++;
	}
	void upFourofaKind(){
		stats[6]++;
	}
	void upStraightFlush(){
		stats[7]++;
	}
	void upRoyalFlush(){
		stats[8]++;
	}
	void upOther(){
		stats[9]++;
	}
	
}
