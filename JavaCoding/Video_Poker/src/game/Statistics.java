package game;

class Statistics {

	private int[] stats = new int[] {0,0,0,0,0,0,0,0,0,0,0};
	
	void printstatistics (Credit credit){ //print out the statistics table
		
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
		
		actualCredit=credit.getActualCredit();
		inicialCredit=credit.getInitialCredit();
		gain = (float) actualCredit/inicialCredit;
		gain = gain*100;
		System.out.print("Credit      " + actualCredit + "(");
		System.out.printf("%.2f", gain);
		System.out.println("%)");
	}
	
	public void upJacksorBetter(){
		stats[0]++;
	}
	public void upTwoPair(){
		stats[1]++;
	}
	public void upThreeofaKind(){
		stats[2]++;
	}
	public void upStraight(){
		stats[3]++;
	}
	public void upFlush(){
		stats[4]++;
	}
	public void upFullHouse(){
		stats[5]++;
	}
	public void upFourofaKind(){
		stats[6]++;
	}
	public void upStraightFlush(){
		stats[7]++;
	}
	public void upRoyalFlush(){
		stats[8]++;
	}
	public void upOther(){
		stats[9]++;
	}
	
}
