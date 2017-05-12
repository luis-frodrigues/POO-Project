package game;
public class Card {

	private char suits;
	private char rank;
	private int value;
	
	Card(char suit, char ranks, int values){
		suits = suit;
		rank= ranks;
		value= values;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rank;
		result = prime * result + suits;
		result = prime * result + value;
		return result;
	}

	/**Set the value of card.
	 * @param value Value of card
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/** 
	 * The object is equal if the value of card is 
	 * the same.
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (value != other.value)
			return false;
		return true;
	}
	
	/**
	 * @return Returns the suit of the card
	 */
	public char getSuit(){
		return (this.suits);
	}
	
	/**
	 * @return Returns the rank of the card
	 */
	public char getRank(){
		return (this.rank);
	}
	
	/**
	 * @return Returns the value of the card
	 */
	public int getValue(){
		return(value);
	}
	@Override
	public String toString() {
		return  ""+rank+suits+"";
	}

}
