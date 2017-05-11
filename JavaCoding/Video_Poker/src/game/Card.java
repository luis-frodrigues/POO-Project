package game;
public class Card {

	char suits;
	char rank;
	int value;
	
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (rank != other.rank)
			return false;
		if (suits != other.suits)
			return false;
		if (value != other.value)
			return false;
		return true;
	}
	
	public char getSuit(){
		return (this.suits);
	}
	
	public char getRank(){
		return (this.rank);
	}
	
	public int getValue(){
		return(value);
	}
	@Override
	public String toString() {
		return  ""+rank+suits+"";
	}

}
