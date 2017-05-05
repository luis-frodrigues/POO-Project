package game;

public interface Verify {
	
	static int JacksorBetter(Card[] deck ) {
		for(int i=0; i<5;i++){
			if(((deck[i].value+1)%13)<=4){
				return 0;
			}
		}
		return 1;
	}
	
	static int TwoPair(Card[] deck ) {
		int aux[]= new int[5];
		for(int i=0; i<5;i++){
			aux[i]=deck[i].value;
			for(int j=0; j<i;j++){
				if((aux[j]%13)==(aux[i]%13)){
					return 0;
				}
			}
		}
		return 1;
	}
	
	static int ThreeOfaKind(Card[] deck ) {
		int aux[]= new int[5], flag=0, n_cards_left=0;
		for(int i=0; i<5;i++){
			flag=0;
			aux[i]=deck[i].value;
			for(int j=0; j<i;j++){
				if((aux[j]%13)==(aux[i]%13)){
					flag++;
					n_cards_left=Math.max(flag,n_cards_left);
					if(flag>=3){
						return 0;
					}
				}
			}
		}
		return (3 -n_cards_left);
	}
	
	static int FourOfaKind(Card[] deck ) {
		int aux[]= new int[5], flag=0, n_cards_left=0;
		for(int i=0; i<5;i++){
			flag=0;
			aux[i]=deck[i].value;
			for(int j=0; j<i;j++){
				if((aux[j]%13)==(aux[i]%13)){
					flag++;
					n_cards_left=Math.max(flag,n_cards_left);
					if(flag==4){
						return 0;
					}
				}
			}
		}
		return (4 -n_cards_left);
	}
	static int Straight(Card[] deck ) {
		int[] straight={0,1,2,3,4}; 
		int flag=0,n_cards_left=0, flag2=0;
		for(int i=0; i<9;i++){
			flag=0; flag2=0;
			int aux[]={-1,-1,-1,-1,-1};
			for(int j=0; j<=4;j++){
				for(int v=0; v<=4;v++){
					if(straight[v]==((deck[j].value)%13)){
						aux[j]=v;
						if(j==0){
							flag++;
							n_cards_left=Math.max(n_cards_left, flag);
						}
						for(int k=0; k<j;k++){
							if(aux[k]==aux[j])
								flag2=1;
						}
						if(flag2==0){
							flag++;
							n_cards_left=Math.max(n_cards_left, flag);
						}
					}
				}
			}
		}
		return (5-n_cards_left);
	}
	static int Flush(Card[] deck ) {
		return 0;
	}
	static int FullHouse(Card[] deck ) {
		return 0;
	}
	static int StarightFlush(Card[] deck ) {
		return 0;
	}
	static int RoyalFlush(Card[] deck ) {
		return 0;
	}
}
