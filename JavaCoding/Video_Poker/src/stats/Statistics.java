package stats;

/**
 * This class is public and stores the statistics 
 * of the differents hand types in a video poker.
 * The fields are private but can be acessed from
 * the given methods. It is useless to extend the 
 * class since the fieds are private.
 * @author Luís Rodrigues
 * @author Eduardo Crespo
 * @author Eurico Lopes
 */
public class Statistics {

	private int[] stats = new int[] {0,0,0,0,0,0,0,0,0,0,0};
	
	/**
	 * Gets the statistics of the game.
	 * @return Returns an array with the number of times
	 * that an handtype has happened. According to the 
	 * following enumeration: {JacksorBetter,TwoPair,
	 * ThreeofaKind, Straight, Flush, FullHouse, FourofaKind, 
	 * StraightFlush, RoyalFlush, Other}, it corresponds the
	 * index of the returned array.
	 */
	public int[] getStats() {
		return stats;
	}
	/**
	 * It prints out the statistics of the game.
	 * @param credit
	 * The credit is used to know the initial credit
	 * and the actual credit:
	 * 
	 */
	public void printstatistics (Credit credit){ 
		
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
	/**
	 *increments the statistics of JacksorBetter 
	 */
	public void upJacksorBetter(){
		stats[0]++;
	}
	/**
	 * increments the statistics of TwoPair
	 */
	public void upTwoPair(){
		stats[1]++;
	}
	/**
	 * increments the statistics of ThreeofaKind
	 */
	public void upThreeofaKind(){
		stats[2]++;
	}
	/**
	 * increments the statistics of Straight
	 */
	public void upStraight(){
		stats[3]++;
	}
	/**
	 * increments the statistics of Flush 
	 */
	public void upFlush(){
		stats[4]++;
	}
	/**
	 * increments the statistics of FullHouse
	 */
	public void upFullHouse(){
		stats[5]++;
	}
	/**
	 * increments the statistics of FourofaKind
	 */
	public void upFourofaKind(){
		stats[6]++;
	}
	/**
	 * increments the statistics of StraightFlush
	 */
	public void upStraightFlush(){
		stats[7]++;
	}
	/**
	 * increments the statistics of RoyalFlush
	 */
	public void upRoyalFlush(){
		stats[8]++;
	}
	/**
	 * increments the statistics of Other
	 */
	public void upOther(){
		stats[9]++;
	}
	
}
