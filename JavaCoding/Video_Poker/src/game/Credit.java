package game;

class Credit {
	private int initial_credit;
	private int actual_credit;
	int prev_bet=5;
	
	Credit(int credit){
		setInitial_credit(credit);
		setActual_credit(credit);
	}

	public int getInitial_credit() {
		return initial_credit;
	}

	public void setInitial_credit(int initial_credit) {
		this.initial_credit = initial_credit;
	}

	public int getActual_credit() {
		return actual_credit;
	}

	public void setActual_credit(int actual_credit) {
		this.actual_credit = actual_credit;
	}
	
}
