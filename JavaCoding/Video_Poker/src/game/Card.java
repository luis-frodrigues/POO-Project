package game;

class Card {
	char suits;
	char rank;
	int value;
	Card(char suit, char ranks, int values){
		suits = suit;
		rank= ranks;
		value= values;
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
