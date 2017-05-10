package game;

import java.util.Arrays;

public abstract class  Verify {
	
	//Return positions and number of cards greater 
	//or equal to Jacks
	static RetVerify HighCard(Hand hand ) {
		int flag=0, aux[]=new int[4];
		for(int i=0; i<5;i++){
			if(hand.getPlayerCardValue(i)%13>=9){
				aux[flag]=i+1;
				flag++;
			}
		}
		RetVerify Ret= new RetVerify(flag);
		Ret.setPos(aux);
		Ret.setNRet(flag);
		
		return Ret;
	}
	
	//Returns the positions of pair(s) and the number
	//of cards to fulfill Two pairs
	static RetVerify TwoPair(Hand hand ) {
		int aux[]= new int[4], flag=0,flag2=0;
		for(int i=1; i<5;i++){
			flag2=0;
			
			for(int j=0; j<i;j++){
				if(i>1&&flag>0){
					for(int k=0;k<flag;k++){
						if(i==(aux[k]-1)||(hand.getPlayerCardValue(i)%13==hand.getPlayerCardValue(aux[k]-1)%13) ){
							flag2=1;
							break;
						}	
					}
				}
				if(flag2==1)
					continue;
				
				if(hand.getPlayerCardValue(j)%13==hand.getPlayerCardValue(i)%13){
					aux[flag]=j+1;
					flag++;
					aux[flag]=i+1;
					flag++;
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
	
	//Returns the positions of the cards that fulfill ThreeOfaKindand
	// the number and 1 if its verified and 0 otherwise
	static RetVerify ThreeOfaKind(Hand hand ) {
		int aux[]= new int[3], flag=0, threeOfAKind=0;
		RetVerify Ret;
		for(int i=0; i<3;i++){
			flag=0;
			for(int j=i+1; j<=4;j++){
				if(hand.getPlayerCardValue(j)%13==hand.getPlayerCardValue(i)%13){
					if(flag==1){
						flag++;
						aux[flag]=j+1;
						threeOfAKind=1;
						continue;
						
					}
					if(flag==2){
						Ret= new RetVerify(0);
						Ret.setNRet(0);
						return Ret;
					}
					if(flag==0){
					aux[flag]=i+1;
					flag++;
					aux[flag]=j+1;
					}
				}
			}
			if(threeOfAKind==1){
				Ret= new RetVerify(3);
				Ret.setPos(aux);
				Ret.setNRet(1);
				return Ret;
			}
		}
		Ret= new RetVerify(0);
		Ret.setNRet(0);
		return Ret;
	}
	
	//Returns the positions of the cards that fulfill FourOfaKind
	// the number and 1 if its verified and 0 otherwise
	static RetVerify FourOfaKind(Hand hand ) {
		int aux[]= new int[4], flag=0;
		for(int i=0; i<2;i++){
			flag=0;
			aux[flag]=i+1;
			for(int j=i+1; j<=4;j++){
				if(hand.getPlayerCardValue(j)%13==hand.getPlayerCardValue(i)%13){
					if(flag==2){
						flag++;
						aux[flag]=j+1;
						RetVerify Ret= new RetVerify(4);
						Ret.setPos(aux);
						Ret.setNRet(1);
						return Ret;
					}
					flag++;
					aux[flag]=j+1;
				}
			}
		}
		RetVerify Ret= new RetVerify(0);
		Ret.setNRet(0);
		return Ret;
	}
	
	//Returns the positions of a straight and the number
	//of cards to fulfill a straight
	static RetVerify Straight(Hand deck ) {
		int[] straight={0,1,2,3,4}; 
		int flag=0,flag3=0, flag2=0;
		int aux[]=new int[5];
		int hold[]=new int[5];
		for(int i=0; i<=9;i++){
			flag3=0;
			for(int j=0; j<=4;j++){
				for(int v=0; v<=4;v++){
					if(straight[v]==((deck.getPlayerCardValue(j))%13)){
						if(flag3>=1){
							flag2=0;
							for(int k=0;k<flag3;k++){
								if(((deck.getPlayerCardValue(aux[k]-1))%13)==((deck.getPlayerCardValue(j))%13)){
									flag2=1;
									break;
								}
							}
							if(flag2!=1){
								aux[flag3]=j+1;
								flag3++;
							}	
						}else{
							aux[flag3]=j+1;
							flag3++;
						}
						if(flag3>flag){
							for(int f=0;f<flag3;f++){
								hold[f]=aux[f];
							}
							flag=flag3;
						}
						break;
					}
				}
			}
			if(i==8){//To verify low ace straight
				straight[0]=12; straight[1]=0; straight[2]=1;
				straight[3]=2;straight[4]=3;
			}else{
				straight[0]++; straight[1]++; straight[2]++;
				straight[3]++;straight[4]++;
			}
			
			if(flag==5)
				break;
		}
		RetVerify Ret= new RetVerify(flag);
		Ret.setPos(hold);
		Ret.setNRet(5-flag);
		return Ret;
	}
	
	//Returns the positions of the cards with more equal suits and the number
	//of cards needed to fulfill a Flush
	static RetVerify Flush(Hand hand ) {
		int flag=0, alreadyVerified=0, flag2=0;
		int[]aux=new int[5];
		int[]hold=new int[5];
		for(int i=0;i<4;i++){
			flag=0;flag2=0;
			for(int k=0;k < alreadyVerified;k++){
				if(i==aux[k]-1||(hand.getPlayerCardValue(i)/13==hand.getPlayerCardValue(aux[k]-1)/13)){
					flag2=1;
					break;
				}
			}
			if(flag2==1){
				continue;
			}
			aux[flag]=i+1;
			for(int j=i+1;j<=4;j++){
				if(hand.getPlayerCardValue(i)/13==hand.getPlayerCardValue(j)/13){
					flag++;
					aux[flag]=j+1;
					
					if(flag>alreadyVerified){
						alreadyVerified=flag;
						hold[0]=i+1;
						hold[alreadyVerified]=j+1;
					}
				}
			}
		}
		RetVerify Ret= new RetVerify(alreadyVerified+1);
		Ret.setPos(hold);
		Ret.setNRet(4-alreadyVerified);
		
		return Ret;
	}
	
	//Returns true if the is a FullHouse and
	//false otherwise
	static boolean FullHouse(Hand hand ) {
		int [] aux= new int [4];
		int flag1=0,flag2=0, pair=0,three=0,ncycles=1;
		for(int i=0; i<4;i++){
			for(int k=0;k<flag1;k++){
				if(aux[k]==i||(hand.getPlayerCardValue(i)%13==hand.getPlayerCardValue(aux[k])%13)){
					flag2=1;
					break;
				}
			}
			if(flag2==1)
				continue;
			ncycles=1;
			for(int j=i+1; j<=4;j++){
				if(hand.getPlayerCardValue(i)%13==hand.getPlayerCardValue(j)%13){
					aux[flag1]=j;
					flag1++;
					ncycles++;
				}
			}
			if(ncycles==2)
				pair++;
			if(ncycles==3)
				three++;
			if(three==1&&pair==1)
				return true;
		}
		return false;
	}
	
	//Returns number of cards to straight flush to hold
	//and their positions
	static RetVerify StraightFlush(Hand hand){
		
		int sortedHand5[]=new int [5];
		int sortedHand4[]=new int [4], sortedHand3[]=new int [3];
		int nCards[]=new int []{0,0,0,0};
		int flag=0, isAce=0;
		int aux[];
		int valueOfCard[][]= new int [4][5];
		//Get cards for each suit
		for(int i=0;i<=4;i++){
			if(hand.getPlayerCardValue(i)/13==0){//diamonds
				valueOfCard[0][nCards[0]]=hand.getPlayerCardValue(i)%13;
				nCards[0]++;
			}
			if(hand.getPlayerCardValue(i)/13==1){//spades
				valueOfCard[1][nCards[1]]=hand.getPlayerCardValue(i);
				nCards[1]++;
			}
			if(hand.getPlayerCardValue(i)/13==2){//clubs
				valueOfCard[2][nCards[2]]=hand.getPlayerCardValue(i);
				nCards[2]++;
			}
			if(hand.getPlayerCardValue(i)/13==3){//hearts
				valueOfCard[3][nCards[3]]=hand.getPlayerCardValue(i);
				nCards[3]++;
			}
		}
		
		//
	
		for(int j=0; j<=3; j++){
			if(nCards[j]==5){
				for(int k=0; k<nCards[j];k++)
					sortedHand5[k]=valueOfCard[j][k];
	
				Arrays.sort(sortedHand5);
				if((sortedHand5[4]%13==12)&&((sortedHand5[4])-(sortedHand5[3]))==9){
					isAce=1;
				}
				if((sortedHand5[4]-sortedHand5[0])==4||isAce==1){
					RetVerify Ret = new RetVerify(5);
					Ret.setNRet(5);
					aux=new int[]{1,2,3,4,5};
					Ret.setPos(aux);
					return Ret;
				}else{
					if((aux=split(sortedHand5, hand))!=null){
						RetVerify Ret = new RetVerify(aux.length);
						Ret.setNRet(aux.length);
						Ret.setPos(aux);
						return Ret;
					}
				}
			}else if(nCards[j]==4){
				for(int k=0; k<nCards[j];k++)
					sortedHand4[k]=valueOfCard[j][k];
				
				Arrays.sort(sortedHand4);
				if((sortedHand4[3]%13==12)&&((sortedHand4[3])-(sortedHand4[2]))>=9){
					isAce=1;
				}
				if(((sortedHand4[3]-sortedHand4[0])<=4)||isAce==1){
					RetVerify Ret = new RetVerify(4);
					Ret.setNRet(4);
					aux=new int[4];
					for(int k=0; k<=4; k++){	
						for(int f=0;f<4;f++){
							if(hand.getPlayerCardValue(k)==sortedHand4[f]){	
								aux[flag]=k+1;
								flag++;
							}
						}	
					}
					Ret.setPos(aux);
					return Ret;
				}else{
					if((aux=split(sortedHand4, hand))!=null){
						RetVerify Ret = new RetVerify(aux.length);
						Ret.setNRet(aux.length);
						Ret.setPos(aux);
						return Ret;
					}
				}
	
			}else if(nCards[j]==3){
				for(int k=0; k<nCards[j];k++)
					sortedHand3[k]=valueOfCard[j][k];
	
				Arrays.sort(sortedHand3);
				if((sortedHand4[2]%13==12)&&((sortedHand4[2])-(sortedHand4[1]))>=9){
					isAce=1;
				}
				if((sortedHand3[2]-sortedHand3[0])<=4||isAce==1){
					RetVerify Ret = new RetVerify(3);
					Ret.setNRet(3);
					aux=new int[3];
					for(int k=0; k<=4; k++){	
						for(int f=0;f<3;f++){
							if(hand.getPlayerCardValue(k)==sortedHand3[f]){	
								aux[flag]=k+1;
								flag++;
							}
						}	
					}
					Ret.setPos(aux);
					return Ret;
				}else{
					if((aux=split(sortedHand3, hand))!=null){
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
	static RetVerify RoyalFlush(Hand hand ) {
		int diamonds=0,clubs=0,hearts=0, spades=0;
		int posDiamonds[]=new int [5],posSpades[]=new int [5],posClubs[]=new int [5],posHearts[]=new int [5];
		for(int i=0; i<=4; i++){
			if(hand.getPlayerCardValue(i)==12||hand.getPlayerCardValue(i)==11||hand.getPlayerCardValue(i)==10||hand.getPlayerCardValue(i)==9||hand.getPlayerCardValue(i)==8 ){
				posDiamonds[diamonds]=i+1;
				diamonds++;
			}
			if(hand.getPlayerCardValue(i)==25||hand.getPlayerCardValue(i)==24||hand.getPlayerCardValue(i)==23||hand.getPlayerCardValue(i)==22||hand.getPlayerCardValue(i)==21 ){
				posSpades[spades]=i+1;
				spades++;
			}
			if(hand.getPlayerCardValue(i)==38||hand.getPlayerCardValue(i)==37||hand.getPlayerCardValue(i)==36||hand.getPlayerCardValue(i)==35||hand.getPlayerCardValue(i)==34 ){
				posClubs[clubs]=i+1;
				clubs++;
			}
			if(hand.getPlayerCardValue(i)==51||hand.getPlayerCardValue(i)==50||hand.getPlayerCardValue(i)==49||hand.getPlayerCardValue(i)==48||hand.getPlayerCardValue(i)==47 ){
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
	
	//Returns the number of High pairs and their position
	static RetVerify HighPair(Hand hand){
		int pos[]=new int[4], finalPos[]= new int[4];
		int highcards=0, highpairs=0, flag=0;
		
		for(int i=0; i<=4;i++){
			if(hand.getPlayerCardValue(i)%13>8){
				highcards=0;
				for(int k=0;k<highpairs;k++){
					if(finalPos[k]-1==i||(hand.getPlayerCardValue(i)%13)==(hand.getPlayerCardValue(finalPos[k]-1)%13))
						flag=2;
				}
				if(flag==2)
					continue;
				for(int j=i+1; j<=4; j++){
					if((hand.getPlayerCardValue(i)%13)==(hand.getPlayerCardValue(j)%13)){
						if(highcards==0)
							pos[highcards]=i+1;
						highcards++;
						pos[highcards]=j+1;
					}	
				}
				if(highcards==1){
					finalPos[highpairs]=i+1;
					highpairs++;
					finalPos[highpairs]=pos[highcards];
					highpairs++;
				}	
			}		
		}
		RetVerify Ret= new RetVerify(highpairs);
		Ret.setNRet(highpairs/2);
		Ret.setPos(finalPos);
		return Ret;
	}
	
	//Returns the number of Low pairs and their position
	static RetVerify LowPair(Hand hand){
		int pos[]=new int[4], finalPos[]= new int[4];
		int lowcards=0, lowpairs=0, flag=0;
		
		for(int i=0; i<=4;i++){
			if(hand.getPlayerCardValue(i)%13<=8){
				lowcards=0;
				for(int k=0;k<lowpairs;k++){
					if(finalPos[k]-1==i||(hand.getPlayerCardValue(i)%13)==(hand.getPlayerCardValue(finalPos[k]-1)%13))
						flag=2;
				}
				if(flag==2)
					continue;
				for(int j=i+1; j<=4; j++){
					if((hand.getPlayerCardValue(i)%13)==(hand.getPlayerCardValue(j)%13)){
						if(lowcards==0)
							pos[lowcards]=i+1;
						lowcards++;
						pos[lowcards]=j+1;
					}	
				}
				if(lowcards==1){
					finalPos[lowpairs]=i+1;
					lowpairs++;
					finalPos[lowpairs]=pos[lowcards];
					lowpairs++;
				}	
			}		
		}
		RetVerify Ret= new RetVerify(lowpairs);
		Ret.setNRet(lowpairs/2);
		Ret.setPos(finalPos);
		return Ret;
	}
	
	//Should be private
	private static int [] split(int[] vec, Hand hand){
		int size=vec.length-1, flag2=0,flag1=0, flagLeft=0, flagRight=0;
		int aux[]= new int[size];
		int []leftaux= new int[size];
		int []rightaux= new int[size];
		int []splitedAux= new int[size-1];
		
			
		if(size>2){
			//FOR ACE LOW
			if((hand.getPlayerCardValue(size)%13==12)&&((hand.getPlayerCardValue(size)%13)-(hand.getPlayerCardValue(size-2)%13))>=9){
				for(int i=0;i<size-1;i++){
					leftaux[i]=vec[i];
				}
				leftaux[size-1]=vec[size];
				for(int k=0; k<=4; k++){	
					for(int f=0;f<size;f++){
						if(hand.getPlayerCardValue(k)==leftaux[f]){	
							aux[flag1]=k+1;
							flag1++;
						}
					}	
				}
				return aux;
			}//FOR ACE LOW
			
			for(int i=0; i<size; i++){
				leftaux[i]=vec[i];
				rightaux[i]=vec[i+1];
			}
			if((leftaux[size-1]-leftaux[0])<=4){
				for(int k=0; k<=4; k++){	
					for(int f=0;f<size;f++){
						if(hand.getPlayerCardValue(k)==leftaux[f]){	
							aux[flag1]=k+1;
							flag1++;
						}
					}	
				}
				flagLeft=1;
			}
			if((rightaux[size-1]-rightaux[0])<=4){
				for(int k=0; k<=4; k++){	
					for(int f=0;f<size;f++){
						if(hand.getPlayerCardValue(k)==rightaux[f]){	
							aux[flag2]=k+1;
							flag2++;
						}
					}	
				}
				flagRight=1;
			}
			if(flagLeft==1||flagRight==1)
				return aux;
			
			if((splitedAux=split(rightaux,hand))!=null)
				return splitedAux;
			if((splitedAux=split(leftaux,hand))!=null)
				return splitedAux;
			return null;
		}
		return null;
	}
		
}
