package game;

public interface Verify {
	
	abstract int JacksorBetter(Card[] deck );
	abstract int TwoPair(Card[] deck );
	abstract int ThreeOfaKind(Card[] deck );
	abstract int FourOfaKind(Card[] deck );
	abstract int Straight(Card[] deck );
	abstract int Flush(Card[] deck );
	abstract int FullHouse(Card[] deck );
	abstract int StarightFlush(Card[] deck );
	abstract int RoyalFlush(Card[] deck );
}
