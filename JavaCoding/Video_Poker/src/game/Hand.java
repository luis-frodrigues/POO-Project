package game;

public class Hand {

	Card [] playerHand;
	Deck deck;
	
	public Hand(){
		deck = new Deck();
		playerHand = new Card[5];
	}
	
	public Hand(String[] cardsaux){
		deck = new Deck(cardsaux);
		playerHand = new Card[5];
		deck.printDeck(0);
	}
	
	public void Hold(String hold){
		String[] temp;
		int n_holds;
		Card[] newcards;
		temp=hold.split(" ");
		if(temp.length>6 ||temp.length==0){
			System.out.println("TOO MANY ARGUMENTS");
		}else{
			n_holds=temp.length-1;
			deck.shuffle(5);

			//Check Valid Inputs
			for(int i=0; i<n_holds;i++){
				if(Character.getNumericValue((temp[i+1].charAt(0)))<1||Character.getNumericValue((temp[i+1].charAt(0)))>5){
					System.out.println("INVALID FORMAT IN HOLD ARGUMENS");
					return;
				}
			}//
			switch (n_holds) {
			case 0: 
				newcards=deck.GiveNewCards(5);
				playerHand=newcards;
				break;
			case 1: 
				newcards=deck.GiveNewCards(4);
				replace(newcards, temp, n_holds);
				break;
			case 2: 
				newcards=deck.GiveNewCards(3);
				replace(newcards, temp, n_holds);
				break;
			case 3: 
				newcards=deck.GiveNewCards(2);
				replace(newcards, temp, n_holds);
				break;
			case 4: 
				newcards=deck.GiveNewCards(1);
				replace(newcards, temp, n_holds);
				break;
			case 5: //Case where you re not supposed to take any card away
				break;
			default: 
				System.out.println("invalid number of holds");
				break;
			}
		}
	}
	
	public int Hold(String hold, int cardcount){
		String[] temp;
		int n_holds;
		Card[] newcards;
		temp=hold.split(" ");
		if(temp.length>6 ||temp.length==0){
			System.out.println("TOO MANY ARGUMENTS");
			return (-1);
		}else{
			n_holds=temp.length-1;

			//Check Valid Inputs
			for(int i=0; i<n_holds;i++){
				if(Character.getNumericValue((temp[i+1].charAt(0)))<1||Character.getNumericValue((temp[i+1].charAt(0)))>5){
					System.out.println("INVALID FORMAT IN HOLD ARGUMENTS");
					return (-1);
				}
			}//
			switch (n_holds) {
			case 0:
				if (!deck.checkEnoughCards(cardcount, 5)){
					System.out.println("The provided card file does not have enough cards to discard everything. Please check your card file.");
					System.exit(0);
				}
				newcards=deck.GiveNewCards(5, cardcount);
				playerHand=newcards;
				
				if(repeat()){ //it checks if there are repeated cards in the Deck
					System.out.println("There are repeated cards in your hand. Please check your card file.");
					System.exit(0);
				}
				break;
			case 1:
				if (!deck.checkEnoughCards(cardcount, 4)){
					System.out.println("The provided card file does not have enough cards to hold 1 card. Please check your card file.");
					System.exit(0);
				}
				newcards=deck.GiveNewCards(4, cardcount);
				replace(newcards, temp, n_holds);
				if(repeat()){ //it checks if there are repeated cards in the Deck
					System.out.println("There are repeated cards in your hand. Please check your card file.");
					System.exit(0);
				}
				break;
			case 2:
				if (!deck.checkEnoughCards(cardcount, 3)){
					System.out.println("The provided card file does not have enough cards to hold 2 cards. Please check your card file.");
					System.exit(0);
				}
				newcards=deck.GiveNewCards(3, cardcount);
				replace(newcards, temp, n_holds);
				if(repeat()){ //it checks if there are repeated cards in the Deck
					System.out.println("There are repeated cards in your hand. Please check your card file.");
					System.exit(0);
				}
				break;
			case 3:
				if (!deck.checkEnoughCards(cardcount, 2)){
					System.out.println("The provided card file does not have enough cards to hold 3 cards. Please check your card file.");
					System.exit(0);
				}
				newcards=deck.GiveNewCards(2, cardcount);
				replace(newcards, temp, n_holds);
				if(repeat()){ //it checks if there are repeated cards in the Deck
					System.out.println("There are repeated cards in your hand. Please check your card file.");
					System.exit(0);
				}
				break;
			case 4:
				if (!deck.checkEnoughCards(cardcount, 1)){
					System.out.println("The provided card file does not have enough cards to hold 4 cards. Please check your card file.");
					System.exit(0);
				}
				newcards=deck.GiveNewCards(1, cardcount);
				replace(newcards, temp, n_holds);
				if(repeat()){ //it checks if there are repeated cards in the Deck
					System.out.println("There are repeated cards in your hand. Please check your card file.");
					System.exit(0);
				}
				break;
			case 5: //Case where you re not supposed to take any card away
				break;
			default: 
				System.out.println("invalid number of holds");
				break;
			}
		}
		return(5-n_holds);
	}
	//INSERT THE HOLDED CARDS IN A NEW DECK WITH THE NEW CARDS NEEDED
	//START TO REPLACE FROM THE END OF NEW DECK, WHICH DONT HAVE YET n_holds CARDS
	private void replace(Card[] newcards, String[] temp, int n_holds){
		int vec[]= new int[5];
		int j=0;
		int z=0;
			for (int i=0; i<5; i++){
				vec[i]=0;
			}
			for (int i=0; i<n_holds; i++){
				vec[Integer.parseInt(temp[i+1])-1]=1; //no vec[i] ficam a 1 as posiçoes a manter e a 0 as que vao mudar
				}
			
			while(j<5){
				if(vec[j]==0){
					playerHand[j]=newcards[z];
					z++;
				}
				j++;
			}
	}	
	
	public void giveHand(){
		int pos=0;
		deck.shuffle(pos);
		for (pos=0;pos<5;pos++){
			playerHand[pos]= deck.getCardFromDeck(pos);
		}
	}
	
	public void giveHand(String[] cmdaux, int cardcount){
		int pos=0;
		
		if (!deck.checkEnoughCards(cardcount, 5)){
			System.out.println("The provided card file does not have enough cards to get 5 new cards. Please check your card file.");
			System.exit(0);
		}
		
		for(pos=cardcount;pos<cardcount+5;pos++){
			playerHand[pos-cardcount]= deck.getCardFromDeck(pos);
			if (playerHand[pos-cardcount]==null){
				System.exit(0);
			}
		}
		if(repeat()){ //it checks if there are repeated cards in the Deck
			System.out.println("There are repeated cards in your hand. Please check your card file.");
			System.exit(0);
		}
	}
		
	public void printHand(){
		int i=0;
		System.out.print("player's hand ");
		for(i=0; i<5;i++){
			System.out.print(playerHand[i]+" ");	
		}
		System.out.println();
	}
	
	private boolean repeat(){
		int i=0, j=0;
		
		for(i=0; i<playerHand.length-1; i++){
			for(j=i+1; j<playerHand.length; j++){
				if(playerHand[i].value==playerHand[j].value){
					return(true);
				}
			}
		}
		return(false);
	}
	public int getPlayerCardValue(int position) {
		if(position>=0&&position<5)
			return playerHand[position].getValue();
		return -1;
	}
}
