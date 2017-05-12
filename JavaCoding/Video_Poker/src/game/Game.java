package game;

import stats.Credit;
import stats.Statistics;
import strategy.PayTable107;
import strategy.Strategy107;

public abstract class Game{
	protected Credit credit;
	protected Hand hand;
	protected Statistics stat;
	protected PayTable107 paytable;
	protected int runs;
	protected String stratResult=""; 
	
	public Game(int credit){
		if (credit<=0){
			System.out.println("Your credit is non-positive. You cannot play!");
			System.exit(0);
		}
		this.credit= new Credit(credit);
		this.hand= new Hand();
		this.runs=0;
		this.stat= new Statistics();
		this.paytable = new PayTable107();
	}
	
	public Game(int credit, String[] cardsaux){
		this.credit= new Credit(credit);
		this.hand= new Hand(cardsaux);
		this.runs=0;
		this.stat= new Statistics();
		this.paytable = new PayTable107();
	}
	
	String parseProcess1(String cmd1){
		String cmd1aux=cmd1.trim();
		String cmdaux[] = cmd1aux.split("\\s+");
		//System.out.println(cmdaux.length);
		
		if(cmdaux.length<=0){
			return(cmd1aux);
		}
		if (cmdaux.length>2){
			for (int i=0; i<cmdaux.length;i++){
				if (i==0){
					cmd1aux= cmdaux[0];
				}else{
					cmd1aux= cmd1aux + " " + cmdaux[i];
				}
			}
			return(cmd1aux);
		}
		
		if((cmdaux.length==1)){
			switch(cmdaux[0]){
			case "b":
				cmd1aux="b";
				return(cmd1aux);
			case "d":
				cmd1aux="d";
				return(cmd1aux);
			case "$":
				cmd1aux="$";
				return(cmd1aux);
			case "s":
				cmd1aux="s";
				return(cmd1aux);
			case "q":
				cmd1aux="q";
				return(cmd1aux);
			default:
				return(cmd1aux);
			}
		}
	
		
		if((cmdaux.length==2)){
			//System.out.println("Tamanho é igual a 2.");
			if(cmdaux[0].equals("b")){
				//System.out.println("Primeiro caracter é igual a b");
				switch(cmdaux[1]){
				case "1":
					cmd1aux="b 1";
					return(cmd1aux);
				case "2":
					cmd1aux="b 2";
					return(cmd1aux);
				case "3":
					cmd1aux="b 3";
					return(cmd1aux);
				case "4":
					cmd1aux="b 4";
					return(cmd1aux);
				case "5":
					cmd1aux="b 5";
					return(cmd1aux);
				default:
					cmd1aux= cmdaux[0];
					cmd1aux= cmd1aux+ " " + cmdaux[1];
					return(cmd1aux);
				}
			}
		}
		return(cmd1aux);
	}
	
	static String parseAdvice(String advice){
		String[] adviceaux = advice.split("\\s+");
		String adv;
		
		if(adviceaux.length==1){
			return("player should discard everything");
		}
		
		if(adviceaux.length==2){
			adv=("player should hold card " + adviceaux[1] + ".");
			return(adv);
		}
		
		if(adviceaux.length==3){
			adv="player should hold cards " + adviceaux[1] + " and " + adviceaux[2] + ".";
			return adv;
		}
		
		if(adviceaux.length==4){
			adv="player should hold cards " + adviceaux[1] + ", " + adviceaux[2] + " and " + adviceaux[3] +".";
			return(adv);
		}
		
		if(adviceaux.length==5){
			adv="player should hold cards " + adviceaux[1] + ", " + adviceaux[2] + ", " + adviceaux[3] +" and " + adviceaux[4] +".";
			return(adv);
		}
		
		if(adviceaux.length==6){
			adv="player should hold cards 1, 2, 3, 4 and 5";
			return(adv);
		}
		return(null);
		
	}
	
	static String parseProcess3(String cmd3){
		cmd3= cmd3.trim();
		String cmdaux[] = cmd3.split("\\s+");
		
		if(cmdaux.length<1||cmdaux.length>6){
			return(cmd3);
		}
		
		if(cmdaux.length==1){		
			switch(cmdaux[0]){
			case "h":
				cmd3="h";
				return(cmd3);
			case "$":
				cmd3="$";
				return(cmd3);
			case "a":
				cmd3="a";
				return(cmd3);
			case "s":
				cmd3="s";
				return(cmd3);
			default:
				return(cmd3);
			}
		}
		
		if((cmdaux.length>1)&&(cmdaux.length<=6)){
			for (int i=0; i<cmdaux.length;i++){
				if (i==0){
					cmd3= cmdaux[0];
				}else{
					cmd3= cmd3 + " " + cmdaux[i];
				}
			}
			return(cmd3);
		}
		return(cmd3);
	}
		
	static boolean validBet(String cmd1){
		String cmdaux[];
		boolean isInteger=true;
		int i=0;
		
		if(cmd1.length()<=1){
			//System.out.println(cmd1 +": illegal command1"); // caso em que é apenas 1 caracter e não corresponde a $,b ou q
			return(false);
		}
		else{
			if((cmd1.charAt(1)==' ')&&(cmd1.length()>2)){ //se o segundo caracter não for 1 espaço = illegal command (não existem comandos com mais q 1 char)
				cmdaux=cmd1.split("\\s+");
				for(int j=0; j<cmdaux.length;j++){
					cmdaux[j].trim();
					//System.out.println(cmdaux[j]);
				}
				if(cmd1.charAt(2)!=' '){
					if (cmdaux.length<3){ //não existem comandos com 3 strings
						if(cmdaux[0].charAt(0)=='b'){
							while(i<cmdaux[1].length()&&(isInteger)){
								if((cmdaux[1].charAt(i)<'0')||(cmdaux[1].charAt(i)>'9')){ //
									isInteger=false;
								}
								i++;
							}
							if(isInteger){// falta o caso de numeros negativos e floats: "b 1.2323"
								//System.out.println("b: illegal amount");
								return(true);
							}else{
								//System.out.println(cmd1 +": illegal command2");
								return(false);
							}
						}else{
							//System.out.println(cmd1 +": illegal command3");
							return(false);
						}
					}else{
						//System.out.println(cmd1 +": illegal command4");
						return(false);
					}
				}else{
					//System.out.println(cmd1 +": illegal command5");
					return(false);
				}
			}else{
			//System.out.println(cmd1 +": illegal command5");
			return(false);
			}
		}
	}
	
	static boolean validHold(String cmd3){
		String[] cmdaux;
		int i=0;
		int j=0;
		
		if (cmd3.length()==0){
			//System.out.println("Erro1;");
			return(false);
		}else{
			if (cmd3.charAt(0)!='h'){
				//System.out.println("Erro2;");
				return(false);
			}else{
				if((cmd3.length()>1)){
					if ((cmd3.length()>2)&&(cmd3.charAt(1)==' ')){
						cmdaux=cmd3.split(" ");
						if((cmd3.charAt(2)==' ')||(cmdaux.length>6)){
							//System.out.println("Erro3;");
							return(false);
						}else{
							for(i=0; i<cmdaux.length; i++){
								if(cmdaux[i].length()!=1){
									//System.out.println("Erro4;");
									return(false);
								}
							}
							for(i=1; i<cmdaux.length; i++){
								if((cmdaux[i].charAt(0)<'1')||(cmdaux[i].charAt(0)>'5')){
									//System.out.println("Erro5;");
									return (false);
								}
							}
							if (cmdaux.length==2){
								return(true);
							}
							for(i=1; i<cmdaux.length-1; i++){
								for(j=i+1; j<cmdaux.length; j++){
									if(cmdaux[i].charAt(0)==cmdaux[j].charAt(0)){
										//System.out.println("Erro6;");
										return(false);
									}
								}
							}
							
						}
					}else{
						return(false);
					}
				}
			}
		}
		return(true);
	}
	
	public void init(){
		String cmd1;
		String cmd2;
		String cmd3;
		

		while(true){
			cmd1=Process1();		//Assume-se que receberá no máximo dois caracteres;
			String cmd1aux=parseProcess1(cmd1);
			
			while(!((cmd1aux.equals("b"))&&(credit.getActualCredit()>=credit.getPrevBet()))&&!((cmd1aux.equals("b 1"))&&(credit.getActualCredit()>=1))&&!((cmd1aux.equals("b 2"))&&(credit.getActualCredit()>=2))&&!((cmd1aux.equals("b 3"))&&(credit.getActualCredit()>=3))&&!((cmd1aux.equals("b 4"))&&(credit.getActualCredit()>=4))&&!((cmd1aux.equals("b 5"))&&(credit.getActualCredit()>=5))){
				switch(cmd1aux){
				case "s":
					stat.printstatistics(credit);
				break;
				case "$":
					System.out.println("player's credit is "+credit.getActualCredit());//Apresenta o crédito atual
				break;
				case "q":
					stat.printstatistics(credit);
					System.exit(0);//Sai do jogo;
				break;
				case "d":
					if(runs==0){
						System.out.println(cmd1 +": illegal command");
					}
				break;
				case "b":
					System.out.println("Player is trying to bet "+credit.getPrevBet()+". Player's credit is "+ credit.getActualCredit()+".");
				break;
				case "b 1":
					System.out.println("Player is trying to bet 1. Player's credit is "+ credit.getActualCredit()+".");
				break;
				case "b 2":
					System.out.println("Player is trying to bet 2. Player's credit is "+ credit.getActualCredit()+".");
				break;
				case "b 3":
					System.out.println("Player is trying to bet 3. Player's credit is "+ credit.getActualCredit()+".");
				break;
				case "b 4":
					System.out.println("Player is trying to bet 4. Player's credit is "+ credit.getActualCredit()+".");
				break;
				case "b 5":
					System.out.println("Player is trying to bet 5. Player's credit is "+ credit.getActualCredit()+".");
				break;
				default:
					if(!validBet(cmd1aux)){ //para verificar que comando enviar: illegal command ou illegal amount
						System.out.println(cmd1 +": illegal command");
					}else{
						System.out.println("b: illegal amount");
					}
				}
				if ((cmd1aux.equals("d"))&&(runs>0)){
					if((credit.getActualCredit()>=credit.getPrevBet())){
						break;
					}else{
						System.out.println("Player is trying to bet "+credit.getPrevBet()+". Player's credit is "+ credit.getActualCredit()+".");
					}
				}
				cmd1=Process1();
				cmd1aux=parseProcess1(cmd1);
			}
			
			switch(cmd1aux) {
				case "b":
					credit.bet();
					if(credit.getActualCredit()<0){
						System.out.println("Your credit is negative. Game Over!");
						System.exit(0);
					}
					System.out.println("Player is betting "+credit.getPrevBet());
				break;
				case "b 1":
					credit.bet(1);
					if(credit.getActualCredit()<0){
						System.out.println("Your credit is negative. Game Over!");
						System.exit(0);
					}
					System.out.println("Player is betting "+credit.getPrevBet());
				break;
				case "b 2":
					credit.bet(2);
					if(credit.getActualCredit()<0){
						System.out.println("Your credit is negative. Game Over!");
						System.exit(0);
					}
					System.out.println("Player is betting "+credit.getPrevBet());
				break;
				case "b 3":
					credit.bet(3);
					if(credit.getActualCredit()<0){
						System.out.println("Your credit is negative. Game Over!");
						System.exit(0);
					}
					System.out.println("Player is betting "+credit.getPrevBet());
				break;
				case "b 4":
					credit.bet(4);
					if(credit.getActualCredit()<0){
						System.out.println("Your credit is negative. Game Over!");
						System.exit(0);
					}
					System.out.println("Player is betting "+credit.getPrevBet());
				break;
				case "b 5":
					credit.bet(5);
					if(credit.getActualCredit()<0){
						System.out.println("Your credit is negative. Game Over!");
						System.exit(0);
					}
					System.out.println("Player is betting "+credit.getPrevBet());
				break;
				case "d":
					credit.bet();
					if(credit.getActualCredit()<0){
						System.out.println("Your credit is negative. Game Over!");
						System.exit(0);
					}
					getHand();
					hand.printHand();
				break;
				default:
					System.out.println("Error: Command entry is wrong.");// Optional
			}
			
			if(!((runs>0)&&(cmd1aux.equals("d")))){
				cmd2=Process2();
				String cmd2aux=cmd2.trim(); //Aqui todas as strings terão length=1. Isto significa que basta fazer trim e se o comando for o correto ficamos apenas com um caracter que será o correto.
				
				while(!cmd2aux.equals("d")){
					switch(cmd2aux){
					case "$":
						System.out.println("player's credit is "+credit.getActualCredit());//mambos
					break;
					case "s":
						stat.printstatistics(credit);
					break;
					default:
						System.out.println(cmd2+": illegal command");
						
					}
					cmd2=Process2();
					cmd2aux=cmd2.trim();
				}
				
				switch(cmd2aux) {
					case "d":
						getHand();
						hand.printHand();
					break;
					default:
						System.out.println("Fatal Error");
				}
			}
				
				cmd3= Process3();
				String cmd3aux= parseProcess3(cmd3);
				
				while(!(validHold(cmd3aux))){ //enquanto não for nenhum
					switch(cmd3aux){
					case "$":
						System.out.println("player's credit is "+credit.getActualCredit());//mambos
					break;
					case "a":
						String advice=Strategy107.Advice(hand);// Fazer o advice
						System.out.println(parseAdvice(advice));
					break;
					case "s":
						stat.printstatistics(credit);// Estatisticas
					break;
					default:
						System.out.println(cmd3+": illegal command");
					}
					cmd3=Process3();
					cmd3aux= parseProcess3(cmd3);
				}			
			
			holdPlay(cmd3aux);
			hand.printHand();
			
			stratResult=Strategy107.CheckResult(hand, credit, paytable, stat);
			
			if (credit.getActualCredit()<=0){
				System.out.println("Player does not have credits to play. Game Over!");
				System.exit(0);
			}
			runs++;
		}	
	}
		
	public abstract void getHand();	
	public abstract void holdPlay(String cmd3);
	public abstract String Process1();
	public abstract String Process2();
	public abstract String Process3();
	
}
