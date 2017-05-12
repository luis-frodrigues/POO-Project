package stats;

public class Credit {
	private int initialCredit;
	private int actualCredit;
	private int prevBet=5;
	
	public Credit(int credit){
		setInitialCredit(credit);
		setActualCredit(credit);
	}

	/**
	 * Provide the initial credit.
	 * @return Returns the initial credit.
	 */
	public int getInitialCredit() {
		return initialCredit;
	}

	/**
	 * Sets the initial credit.
	 * @param initialCredit
	 */
	public void setInitialCredit(int initialCredit) {
		this.initialCredit = initialCredit;
	}

	/**
	 * Provide the actual credit.
	 * @return Returns the actual credit.
	 */
	public int getActualCredit(){
		return actualCredit;
	}
	
	/**
	 * Provide the previous bet done.
	 * @return Returns the previous bet done.
	 */
	public int getPrevBet(){
		return prevBet;
	}
	
	/**
	 * Updates the value of the actual credit
	 * by suming it with the payout.
	 * @param payout
	 */
	public void updateActualCredit(int payout){
		this.actualCredit += payout;
	}
	
	/**
	 * Sets the the actual credit with the value
	 * of the parameter actualCredit.
	 * @param actualCredit
	 */
	public void setActualCredit(int actualCredit) {
		this.actualCredit = actualCredit;
	}
	
	/**
	 * Use the value of the previous bet to make a new
	 *  the bet and subtracts it that value to the actual
	 *   credit.
	 */
	public void bet(){
		bet(this.prevBet);
	}
	
	/**
	 * Use the value of the parameter credit to make a new
	 * the bet and subtracts it that value to the actual
	 * credit.
	 * @param credit
	 */
	public void bet(int credit){
		this.actualCredit=this.actualCredit-credit;
		this.prevBet=credit;
	}
	
}
