package game;

public interface Verify {
	//Return positions and number of cards greater 
	//or equal to Jacks
	static RetVerify JacksorBetter(Card[] deck ) {
		int flag=0, aux[]=new int[4];
		for(int i=0; i<5;i++){
			if(((deck[i].value+1)%13)<=4){
				aux[flag]=i+1;
				flag++;
			}
		}
		RetVerify Ret= new RetVerify(flag);
		for(int i=0;i<flag; i++){
			Ret.setPos(aux);
		}
		return Ret;
	}
	
	//Returns the positions of pair(s) and the number
	//of cards to fulfill Two pairs
	static RetVerify TwoPair(Card[] deck ) {
		int aux[]= new int[4], flag=0,flag2=0;
		for(int i=0; i<5;i++){
			flag2=0;
			if(i<1&&flag>0){
				for(int k=0;k<flag;k++){
					if(i==(aux[k]-1)){
						flag2=1;
						break;
					}	
				}
			}
			if(flag2==1)
				continue;
			
			for(int j=0; j<i;j++){
				if(j!=i){
					if(((deck[j].value)%13)==((deck[i].value)%13)){
						aux[flag]=j+1;
						flag++;
						aux[flag]=i+1;
						flag++;
					}
				}
			}
		}
		RetVerify Ret= new RetVerify(flag);
		Ret.setPos(aux);
		if(flag==0)
			Ret.n_ret=3;
		if(flag==2)
			Ret.n_ret=1;
		if(flag==4)
			Ret.n_ret=0;
		return Ret;
	}
	//Returns the positions of pair(s) and the number
	//of cards to fulfill ThreeOfaKind
	static RetVerify ThreeOfaKind(Card[] deck ) {
		int aux[]= new int[5], flag=0, n_cards_left=0;
		for(int i=0; i<5;i++){
			flag=0;
			for(int j=0; j<i;j++){
				if(((deck[j].value)%13)==((deck[i].value)%13)){
					flag++;
					if(n_cards_left<flag){
						n_cards_left=flag;
						aux[n_cards_left]=j+1;
						aux[0]=i+1;
					}
				}
			}
		}
		if(n_cards_left==4)
			n_cards_left--;
		RetVerify Ret= new RetVerify(2 -n_cards_left);
		Ret.setPos(aux);
		return Ret;
	}
	//Returns the positions of pair(s) and the number
	//of cards to fulfill FourOfaKind
	static RetVerify FourOfaKind(Card[] deck ) {
		int aux[]= new int[5], flag=0, n_cards_left=0;
		for(int i=0; i<5;i++){
			flag=0;
			for(int j=0; j<i;j++){
				if(((deck[j].value)%13)==((deck[i].value)%13)){
					flag++;
					if(n_cards_left<flag){
						n_cards_left=flag;
						aux[n_cards_left]=j+1;
						aux[0]=i+1;
					}
				}
			}
		}
		RetVerify Ret= new RetVerify(3 -n_cards_left);
		Ret.setPos(aux);
		return Ret;
	}
	
	//Returns the positions of a straight and the number
	//of cards to fulfill a straigth
	static RetVerify Straight(Card[] deck ) {
		int[] straight={0,1,2,3,4}; 
		int aux2[]= new int [5];
		int flag=0,n_cards_left=0, flag2=0,flag3=0;
		int aux[]=new int[5];
		int hold[]=new int[5];
		for(int i=0; i<9;i++){
			flag=0; flag3=0;
			for(int j=0; j<=4;j++){
				flag2=1;
				for(int v=0; v<=4;v++){
					if(straight[v]==((deck[j].value)%13)){
						aux[flag3]=j;
						flag3++;
						if(j==0){
							flag++;
							aux2[0]=j+1;
							n_cards_left=Math.max(n_cards_left, flag);
							if(i==0)
								hold[0]=j;
						}else{
							for(int k=0; k<=j;k++){
								if(((deck[k].value)%13)!=((deck[j].value)%13))
									flag2++;
							}
							if(flag2!=0&&flag2>n_cards_left){
								n_cards_left=Math.max(n_cards_left, flag2);
								for(int y=0;y<n_cards_left;y++){
									hold[y]=aux[y];	
								}
							}
						}
					}
				}
			}
			straight[0]++; straight[1]++; straight[2]++;
			straight[3]++;straight[4]++;
			if(n_cards_left==5)
				break;
		}
		RetVerify Ret= new RetVerify(n_cards_left);
		Ret.setPos(hold);
		Ret.n_ret=5-n_cards_left;
		return Ret;
	}
	
	static int Flush(Card[] deck ) {
		int flag=1,n_cards_left=1, already_verified=0, flag2=0;
		int[]aux=new int[4];
		for(int i=0;i<4;i++){
			flag=1;flag2=0;
			for(int k=0;k < already_verified;k++){
				if(i==aux[k]){
					flag2=1;
					break;
				}
			}
			if(flag2==1){
				continue;
			}
			for(int j=0;j<4;j++){
				if(((deck[i].value)/13)==((deck[j].value)/13)){
					if(i!=j){
						flag++;
						n_cards_left=Math.max(flag,n_cards_left);
						aux[already_verified]=j;
						already_verified++;
					}
				}
			}
		}
		
		
		return (5-n_cards_left);
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
