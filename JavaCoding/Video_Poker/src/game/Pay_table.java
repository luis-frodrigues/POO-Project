package game;

abstract class  Pay_table {
	public int max_credits=5;
	int Royal_Flush=250;
	int Straight_Flush=50;
	int Four_5_K=160;
	int Four_2_4=80;
	int Full_House=50;
	int Flush=10;
	int Straight=7;
	int Three_of_a_Kind=5;
	int TwoPair=3;
	int JacksorBetter;
	int Table [][];
	
	Pay_table(){
		Table = new int [10][5];
	}
	
	Pay_table(int max_credit){
		Table = new int [10][max_credit];
		max_credits=max_credit;
	}
	
	
	int check_payout(int credit, int priority ){
		return Table[priority][credit];
	}
	
}
