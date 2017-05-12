package strategy;

public class PayTable107 extends PayTable{

	/**
	 * This is a public class which creates a PayTable
	 * for the variant double bonus 10/7 of video poker.
	 * Although the table is created in the game, we allow
	 * the users to use our Table to create their own game.
	 * @author Luís Rodrigues
	 * @author Eduardo Crespo
	 * @author Eurico Lopes
	 */
	public PayTable107() {
		super(11, 5);
		String[] HandTypes= new String[11];
		
		HandTypes[0]="Royal Flush";		HandTypes[1]="Straight Flush";	
		HandTypes[2]="Four Aces";		HandTypes[3]="Four 2-4";		
		HandTypes[4]="Four 5-K";		HandTypes[5]="Full House";
		HandTypes[6]="Flush";	   	 	HandTypes[7]="Straight";
		HandTypes[8]="Three of a Kind";	HandTypes[9]="Two Pair";
		HandTypes[10]="Jacks or Better";
		int[] credit={250, 50, 160, 80, 50, 10, 7, 5, 3, 1, 1};
		
		for(int i=0; i<11;i++){
			for(int j=1;j<=5;j++){
				intsertValue(HandTypes[i],j,credit[i]*j);
			}
		}

		removeValue(HandTypes[0],5);
		intsertValue(HandTypes[0],5,4000);
		
	}

}
