package game;

import strategy.Strategy107;

public class Simulation extends Game{
	int nbdeals;
	int betAmount;
	
	public Simulation(int credit, int nbdeals, int betAmount) {
		super(credit);
		if(nbdeals<=0){
			System.out.println("Number of deals equals or is less than zero.");
			System.exit(0);
		}
		if (!((betAmount==1)||(betAmount==2)||(betAmount==3)||(betAmount==4)||(betAmount==5))){
			System.out.println("b: illegal amount");
			System.exit(0);
		}
		if(betAmount>credit){
			System.out.println("Your bet amount is higher than the credit you have.");
			System.exit(0);
		}
		this.nbdeals=nbdeals;
		this.betAmount=betAmount;
	}

	public String Process1(){
		if(runs==nbdeals){
			stat.printstatistics(credit);
			return("q");
		}
		if(runs==0){
			String cmd1= ("b "+betAmount);
			System.out.println(cmd1);
			return("b "+betAmount);
		}
		if(credit.getActualCredit()<betAmount){
			System.out.println("Your bet amount is higher than the credit you have.");
			stat.printstatistics(credit);
			return("q");
		}
		
		return("d");
	}
	
	public String Process2() {
		return ("d");
	}
	public String Process3() {
		return(Strategy107.Advice(hand));
	}
	
	public void getHand(){
		hand.giveHand();
	}
	public void holdPlay(String cmd3){
		hand.Hold(cmd3);
	}

}
