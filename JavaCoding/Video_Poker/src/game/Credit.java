package game;

public class Credit {
	private int initialCredit;
	private int actualCredit;
	int prevBet=5;
	
	public Credit(int credit){
		setInitialCredit(credit);
		setActualCredit(credit);
	}

	public int getInitialCredit() {
		return initialCredit;
	}

	public void setInitialCredit(int initialCredit) {
		this.initialCredit = initialCredit;
	}

	public int getActualCredit(){
		return actualCredit;
	}
	
	public int getPrevBet(){
		return prevBet;
	}
	
	public void updateActualCredit(int payout){
		this.actualCredit += payout;
	}
	public void setActualCredit(int actualCredit) {
		this.actualCredit = actualCredit;
	}
	
	public void bet(){
		bet(this.prevBet);
	}
	
	public void bet(int credit){
		this.actualCredit=this.actualCredit-credit;
		this.prevBet=credit;
	}
	
}
