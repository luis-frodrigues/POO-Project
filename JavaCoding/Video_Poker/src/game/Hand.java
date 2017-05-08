package game;

public class Hand {

	Card [] player_hand;
	Deck deck;
	
	public Hand(){
		deck = new Deck();
		player_hand = new Card[5];
	}
	
	public void Hold(String hold){
		String[] temp;
		int n_holds;
		Card[] newcards;
		temp=hold.split(" ");
		if(temp.length>6 ||temp.length==0){
			System.out.println("TO MANY ARGUMENTS");
		}else{
			n_holds=temp.length-1;
			deck.shuffle(0);
			int []aux = new int[n_holds];
			//Check Valid Inputs
			for(int i=0; i<n_holds;i++){
				if(temp[i+1].length()!=1){
					System.out.println("INVALID FORMAT IN HOLD ARGUMENS");
					return;
				}
				if(Character.getNumericValue((temp[i+1].charAt(0)))<1||Character.getNumericValue((temp[i+1].charAt(0)))>5){
					System.out.println("INVALID FORMAT IN HOLD ARGUMENS");
					return;
				}
				//Compare if 2 digits are equal//
				aux[i]=Integer.parseInt(temp[i+1]);
				for(int j=0;j<i;j++){
					if(aux[j]==aux[i]){
						System.out.println("REPEATED CARDS TO HOLD!");
						return;
					}
				}
			}//
			switch (n_holds) {
			case 0: 
				newcards=deck.GiveNewCards(5);
				player_hand=newcards;
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
			case 5: 
				break;
			default: 
				System.out.println("invalid number of holds");
				break;
			}
		}
	}
	
	//INSERT THE HOLDED CARDS IN A NEW DECK WITH THE NEW CARDS NEEDED
	//START TO REPLACE FROM THE END OF NEW DECK, WICH DONT HAVE YET n_holds CARDS
	private void replace(Card[] newcards, String[] temp, int n_holds){
		int vec[]= new int[n_holds];
		for(int i=0; i<n_holds; i++){
			vec[i]=Integer.parseInt(temp[i+1])-1;
			newcards[4-i]=this.player_hand[Integer.parseInt(temp[i+1])-1];
		}
		for(int i=0;i<n_holds;i++){
			player_hand[vec[i]]=newcards[vec[i]];
			newcards[vec[i]]=newcards[4-i];
			newcards[4-i]=player_hand[vec[i]];
			
		}
		this.player_hand= newcards;
	}	
	
	public void giveHand(){
		int pos=0;
		deck.shuffle(6);
		for (pos=0;pos<5;pos++){
			player_hand[pos]= deck.getCardFromDeck(pos);
		}
	}
	
	public void printHand(){
		int i=0;
		for(i=0; i<5;i++){
			System.out.print(player_hand[i]+" ");	
		}
		System.out.println();
	}

}
