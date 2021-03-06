package game;

public class PayTable107 extends PayTable{

	PayTable107() {
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
		
		//To print pay table uncomment the next lines:
		/*
			System.out.println("           Paytable ");
			for(int i=0; i<11;i++){
				System.out.print(HandTypes[i] + "--> ");
				for(int j=1;j<=5;j++){
					int k = print_paytable(HandTypes[i],j);
					System.out.print(k + " ");
				}
				System.out.println();
			}
		*/
	}

}
