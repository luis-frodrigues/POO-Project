package game;

class Card {
	char suits;
	char rank;
	int value;
	Card(char suit, char ranks, int values){
		suits = suit;
		rank=ranks;
		value=values;
	}
	@Override
	public String toString() {
		return  ""+suits+rank+"";
	}
}
