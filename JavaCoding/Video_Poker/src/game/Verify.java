package game;

import java.util.Arrays;

public interface Verify {
	
	//Return positions and number of cards greater 
	//or equal to Jacks
	static RetVerify HighCard(Card[] deck ) {
		int flag=0, aux[]=new int[4];
		for(int i=0; i<5;i++){
			if(((deck[i].getValue()+1)%13)<=4){
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
					if(((deck[j].getValue())%13)==((deck[i].getValue())%13)){
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
			Ret.setNRet(3);
		if(flag==2)
			Ret.setNRet(1);
		if(flag==4)
			Ret.setNRet(0);
		return Ret;
	}
	
	//Returns the positions of pair(s) and the number
	//of cards to fulfill ThreeOfaKind
	static RetVerify ThreeOfaKind(Card[] deck ) {
		int aux[]= new int[5], flag=0, n_cards_left=0;
		for(int i=0; i<5;i++){
			flag=0;
			for(int j=0; j<i;j++){
				if(((deck[j].getValue())%13)==((deck[i].getValue())%13)){
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
				if(((deck[j].getValue())%13)==((deck[i].getValue())%13)){
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
	//of cards to fulfill a straight
	static RetVerify Straight(Card[] deck ) {
		int[] straight={0,1,2,3,4}; 
		int flag=0,n_cards_left=0, flag2=0,flag3=0;
		int aux[]=new int[5];
		int hold[]=new int[5];
		for(int i=0; i<9;i++){
			flag=0; flag3=0;
			for(int j=0; j<=4;j++){
				flag2=1;
				for(int v=0; v<=4;v++){
					if(straight[v]==((deck[j].getValue())%13)){
						aux[flag3]=j+1;
						flag3++;
						if(j==0){
							flag++;
							n_cards_left=Math.max(n_cards_left, flag);
							if(i==0)
								hold[0]=j;
						}else{
							for(int k=0; k<=j;k++){
								if(((deck[k].getValue())%13)!=((deck[j].getValue())%13))
									flag2++;
							}
							if(flag2!=0&&flag2>=n_cards_left){//Se não der tirar o '='
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
		Ret.setNRet(5-n_cards_left);
		return Ret;
	}
	
	//Returns the positions of the cards with more equal suits and the number
	//of cards needed to fulfill a Flush
	static RetVerify Flush(Card[] deck ) {
		int flag=1,n_cards_left=1, already_verified=0, flag2=0;
		int[]aux=new int[4];
		int[]hold=new int[4];
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
				if(((deck[i].getValue())/13)==((deck[j].getValue())/13)){
					if(i!=j){
						flag++;
						aux[already_verified]=j;
						already_verified++;
						if(n_cards_left>flag){
							n_cards_left=flag;
							hold[0]=i+1;
							hold[n_cards_left]=j+1;
						}
					}
				}
			}
		}
		RetVerify Ret= new RetVerify(n_cards_left);
		Ret.setPos(hold);
		Ret.setNRet(5-n_cards_left);
		
		
		return Ret;
	}
	
	//Returns true if the is a FullHouse and
	//false otherwise
	static boolean FullHouse(Card[] deck ) {
		int [] aux= new int [4];
		int flag1=0,flag2=0, pair=0,three=0,ncycles=1;
		for(int i=0; i<4;i++){
			for(int k=0;k<flag1;k++){
				if(aux[k]==i){
					flag2=1;
					break;
				}
			}
			if(flag2==1)
				continue;
			ncycles=1;
			for(int j=i+1; j<4;j++){
				if((deck[i].getValue())%13==(deck[j].getValue())%13){
					aux[flag1]=j;
					flag1++;
					ncycles++;
				}
			}
			if(ncycles==2)
				pair++;
			if(ncycles==3)
				three++;
		}
		if(three==1&&pair==1)
			return true;
		return false;
	}
	
	//Returns number of cards to straight flush to hold
	//and their positions
	static RetVerify StraightFlush(Card[] deck){
		
		int sortedHand5[]=new int [5];
		int sortedHand4[]=new int [4], sortedHand3[]=new int [3];
		int nCards[]=new int []{0,0,0,0};
		int flag=0, isAce=0;
		int aux[];
		int valueOfCard[][]= new int [4][5];
		//Get cards for each suit
		for(int i=0;i<=4;i++){
			if(deck[i].getValue()/13==0){//diamonds
				valueOfCard[0][nCards[0]]=deck[i].getValue();
				nCards[0]++;
			}
			if(deck[i].getValue()/13==1){//spades
				valueOfCard[1][nCards[1]]=deck[i].getValue();
				nCards[1]++;
			}
			if(deck[i].getValue()/13==2){//clubs
				valueOfCard[2][nCards[2]]=deck[i].getValue();
				nCards[2]++;
			}
			if(deck[i].getValue()/13==3){//hearts
				valueOfCard[3][nCards[3]]=deck[i].getValue();
				nCards[3]++;
			}
		}
		
		//
	
		for(int j=0; j<=3; j++){
			if(nCards[j]==5){
				for(int k=0; k<=nCards[j];k++)
					sortedHand5[k]=valueOfCard[j][k];
	
				Arrays.sort(sortedHand5);
				if((sortedHand4[3]%13==12)&&((sortedHand4[3])-(sortedHand4[0]))>=9){
					isAce=1;
				}
				if((sortedHand5[4]-sortedHand5[0])==4||isAce==1){
					RetVerify Ret = new RetVerify(5);
					Ret.setNRet(5);
					aux=new int[]{1,2,3,4,5};
					Ret.setPos(aux);
					return Ret;
				}else{
					if((aux=split(sortedHand5, deck))!=null){
						RetVerify Ret = new RetVerify(aux.length);
						Ret.setNRet(aux.length);
						Ret.setPos(aux);
						return Ret;
					}
				}
			}else if(nCards[j]==4){
				for(int k=0; k<=nCards[j];k++)
					sortedHand4[k]=valueOfCard[j][k];
				
				Arrays.sort(sortedHand4);
				if((sortedHand4[3]%13==12)&&((sortedHand4[3])-(sortedHand4[0]))>=9){
					isAce=1;
				}
				if(((sortedHand4[3]-sortedHand4[0])<=4)||isAce==1){
					RetVerify Ret = new RetVerify(4);
					Ret.setNRet(4);
					aux=new int[4];
					for(int k=0; k<=4; k++){	
						for(int f=0;f<4;f++){
							if(deck[k].getValue()==sortedHand4[f]){	
								aux[flag]=k+1;
								flag++;
							}
						}	
					}
					Ret.setPos(aux);
					return Ret;
				}else{
					if((aux=split(sortedHand4, deck))!=null){
						RetVerify Ret = new RetVerify(aux.length);
						Ret.setNRet(aux.length);
						Ret.setPos(aux);
						return Ret;
					}
				}
	
			}else if(nCards[j]==3){
				for(int k=0; k<=nCards[j];k++)
					sortedHand3[k]=valueOfCard[j][k];
	
				Arrays.sort(sortedHand3);
				if((sortedHand4[3]%13==12)&&((sortedHand4[3])-(sortedHand4[0]))>=9){
					isAce=1;
				}
				if((sortedHand3[2]-sortedHand3[0])<=4||isAce==1){
					RetVerify Ret = new RetVerify(3);
					Ret.setNRet(3);
					aux=new int[3];
					for(int k=0; k<=4; k++){	
						for(int f=0;f<3;f++){
							if(deck[k].getValue()==sortedHand3[f]){	
								aux[flag]=k+1;
								flag++;
							}
						}	
					}
					Ret.setPos(aux);
					return Ret;
				}else{
					if((aux=split(sortedHand3, deck))!=null){
						RetVerify Ret = new RetVerify(aux.length);
						Ret.setNRet(aux.length);
						Ret.setPos(aux);
						return Ret;
					}
				}
			}
		}
		RetVerify Ret = new RetVerify(0);
		Ret.setNRet(0);
		return Ret;
	}
	
	//Return number of cards to a RoyalFlush
	//and the cards to hold
	static RetVerify RoyalFlush(Card[] deck ) {
		int diamonds=0,clubs=0,hearts=0, spades=0;
		int posDiamonds[]=new int [5],posSpades[]=new int [5],posClubs[]=new int [5],posHearts[]=new int [5];
		for(int i=0; i<4; i++){
			if(deck[i].getValue()==12||deck[i].getValue()==11||deck[i].getValue()==10||deck[i].getValue()==9||deck[i].getValue()==8 ){
				posDiamonds[diamonds]=i+1;
				diamonds++;
			}
			if(deck[i].getValue()==25||deck[i].getValue()==24||deck[i].getValue()==23||deck[i].getValue()==22||deck[i].getValue()==21 ){
				posSpades[spades]=i+1;
				spades++;
			}
			if(deck[i].getValue()==38||deck[i].getValue()==37||deck[i].getValue()==36||deck[i].getValue()==35||deck[i].getValue()==34 ){
				posClubs[clubs]=i+1;
				clubs++;
			}
			if(deck[i].getValue()==51||deck[i].getValue()==50||deck[i].getValue()==49||deck[i].getValue()==48||deck[i].getValue()==47 ){
				posHearts[hearts]=i+1;
				hearts++;
			}
		}
		if(diamonds>=spades&&diamonds>=clubs&&diamonds>=hearts){
			if(diamonds==0){
				RetVerify Ret= new RetVerify(diamonds);
				Ret.setNRet(5-diamonds);
				return Ret;
			}
				
			RetVerify Ret= new RetVerify(diamonds);
			Ret.setPos(posDiamonds);
			Ret.setNRet(5-diamonds);
			return Ret;
		}else if(spades>=diamonds&&spades>=clubs&&spades>=hearts){
			RetVerify Ret= new RetVerify(spades);
			Ret.setPos(posSpades);
			Ret.setNRet(5-spades);
			return Ret;
		}else if(clubs>=spades&&clubs>=diamonds&&clubs>=hearts){
			RetVerify Ret= new RetVerify(clubs);
			Ret.setPos(posClubs);
			Ret.setNRet(5-clubs);
			return Ret;
		}else if(hearts>=diamonds&&hearts>=hearts&&hearts>=diamonds){
			RetVerify Ret= new RetVerify(hearts);
			Ret.setPos(posHearts);
			Ret.setNRet(5-hearts);
			return Ret;
		}
		return null;
	}
	
	//Returns 1 if there is only 1 high pair and
	// return 0 otherwise
	static RetVerify JacksOrBetter(Card[] deck){
		int pos[]=new int[5], finalPos[]= new int[2];
		int highcards=0, result=0;
		RetVerify Ret= new RetVerify(2);
		Ret.setNRet(0);
		for(int i=0; i<4;i++){
			if(deck[i].getValue()%13>8){
				pos[highcards]=i;
				highcards++;
				if(highcards>1){			
					for(int j=(highcards-1); j>=0; j--){
						if((deck[i].getValue()%13)==(deck[pos[j]].getValue()%13)&&(j!=i)){
							if(result==2)
								return Ret;
							finalPos[result]=pos[j]+1;
							result++;
							finalPos[result]=pos[i]+1;
							result++;	
						}	
					}
				}
			}	
		}
		if(highcards==0)
			return Ret;
		Ret.setNRet(1);
		Ret.setPos(finalPos);
		return Ret;
	}
	
	//Should be private
	static int [] split(int[] vec, Card[] deck){
		int size=vec.length-1, flag=0, flagLeft=0, flagRight=0;
		int aux[]= new int[size];
		int []leftaux= new int[size];
		int []rightaux= new int[size];
		int []splitedAux= new int[size-1];
	
		if(size>2){
			for(int i=0; i<=size; i++){
				leftaux[i]=vec[i];
				rightaux[i]=vec[i+1];
			}
			if((leftaux[size]-leftaux[0])<=4){
				for(int k=0; k<=4; k++){	
					for(int f=0;f<size;f++){
						if(deck[k].getValue()==leftaux[f]){	
							aux[flag]=k+1;
							flag++;
						}
					}	
				}
				flagLeft=1;
			}
			if((rightaux[size]-rightaux[0])<=4){
				for(int k=0; k<=4; k++){	
					for(int f=0;f<size;f++){
						if(deck[k].getValue()==rightaux[f]){	
							aux[flag]=k+1;
							flag++;
						}
					}	
				}
				flagRight=1;
			}
			if(flagLeft==1||flagRight==1)
				return aux;
			
			if((splitedAux=split(rightaux,deck))!=null)
				return splitedAux;
			if((splitedAux=split(leftaux,deck))!=null)
				return splitedAux;
			return null;
		}
		return null;
	}
		
}
