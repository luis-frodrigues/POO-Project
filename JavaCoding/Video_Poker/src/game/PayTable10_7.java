package game;

public class PayTable10_7 extends Pay_table{

	PayTable10_7(int max_pay_types, int max_credits) {
		super(max_pay_types, max_credits);
		String[] HandTypes= new String[11];
		
		HandTypes[0]="Royal Flush";		HandTypes[1]="Straight Flush";	
		HandTypes[2]="Four Aces";		HandTypes[3]="Four 2-4";		
		HandTypes[4]="Four 5-K";		HandTypes[5]="Full House";
		HandTypes[6]="Flush";	   	 	HandTypes[7]="Straight";
		HandTypes[8]="Three of a kind";	HandTypes[9]="Two Pair";
		HandTypes[10]="Jacks or Better";
		int[] credit={250, 50, 160,80, 50, 10, 7, 5, 3, 1, 1};
		
		for(int i=0; i<12;i++){
			for(int j=1;j<=5;j++){
				intsertValue(HandTypes[i],j,credit[j*(i+1)]);
			}
		}
		removeValue(HandTypes[0],5);
		intsertValue(HandTypes[0],5,4000);
	}

}
