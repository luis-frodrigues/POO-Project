package game;

import java.io.IOException;

public abstract class Game{
	Credit credit;
	Hand hand;
	int runs;
	
	public Game(int credit){
		this.credit= new Credit(credit);
		this.hand= new Hand();
		this.runs=0;
	}
	
	public Game(int credit, String[] cardsaux){
		this.credit= new Credit(credit);
		this.hand= new Hand(cardsaux);
		this.runs=0;
	}
	
	static boolean validBet(String cmd1){
		String cmdaux[];
		boolean isInteger=true;
		int i=0;
		
		if(cmd1.length()<=1){
			System.out.println(cmd1 +": illegal command1"); // caso em que é apenas 1 caracter e não corresponde a $,b ou q
			return(false);
		}
		else{
			if((cmd1.charAt(1)==' ')&&(cmd1.length()>2)){ //se o segundo caracter não for 1 espaço = illegal command (não existem comandos com mais q 1 char)
				cmdaux=cmd1.split(" ");
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
								System.out.println("b: illegal amount");
								return(true);
							}else{
								System.out.println(cmd1 +": illegal command2");
								return(false);
							}
						}else{
							System.out.println(cmd1 +": illegal command3");
							return(false);
						}
					}else{
						System.out.println(cmd1 +": illegal command4");
						return(false);
					}
				}else{
					System.out.println(cmd1 +": illegal command5");
					return(false);
				}
			}else{
			System.out.println(cmd1 +": illegal command5");
			return(false);
			}
		}
	}
	
	static boolean validHold(String cmd3){
		String[] cmdaux;
		int i=0;
		int j=0;
		
		if (cmd3.length()==0){
			System.out.println("Erro1;");
			return(false);
		}else{
			if (cmd3.charAt(0)!='h'){
				System.out.println("Erro2;");
				return(false);
			}else{
				if((cmd3.length()>1)){
					if ((cmd3.length()>2)&&(cmd3.charAt(1)==' ')){
						cmdaux=cmd3.split(" ");
						if((cmd3.charAt(2)==' ')||(cmdaux.length>6)){
							System.out.println("Erro3;");
							return(false);
						}else{
							for(i=0; i<cmdaux.length; i++){
								if(cmdaux[i].length()!=1){
									System.out.println("Erro4;");
									return(false);
								}
							}
							for(i=1; i<cmdaux.length; i++){
								if((cmdaux[i].charAt(0)<'1')||(cmdaux[i].charAt(0)>'5')){
									System.out.println("Erro5;");
									return (false);
								}
							}
							if (cmdaux.length==2){
								return(true);
							}
							for(i=1; i<cmdaux.length-1; i++){
								for(j=i+1; j<cmdaux.length; j++){
									if(cmdaux[i].charAt(0)==cmdaux[j].charAt(0)){
										System.out.println("Erro6;");
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
	
	public void init() throws IOException{
		String cmd1;
		String cmd2;
		String cmd3;
		

		while(true){
			cmd1=Process1();		//Assume-se que receberá no máximo dois caracteres;
			
			while(!(cmd1.equals("b"))&&!(cmd1.equals("b 1"))&&!(cmd1.equals("b 2"))&&!(cmd1.equals("b 3"))&&!(cmd1.equals("b 3"))&&!(cmd1.equals("b 5"))){
				switch(cmd1){
				case "s":
					//Apresenta estatísticas
				break;
				case "$":
					System.out.println("player's credit is "+credit.getActual_credit());//Apresenta o crédito atual
				break;
				case "q":
					System.exit(0);//Sai do jogo;
				break;
				case "d":
					if(runs==0){
						System.out.println(cmd1 +": illegal command");
					}
				break;
				default:
					if(!validBet(cmd1)){ //para verificar que comando enviar: illegal command ou illegal amount
						System.out.println(cmd1 +": illegal command");
					}else{
						System.out.println("b: illegal amount");
					}
				}
				if ((cmd1.equals("d"))&&(runs>0)){
					break;
				}
				cmd1=Process1();
			}
			
			switch(cmd1) {
				case "b":
					credit.bet();
					System.out.println("Player is betting "+credit.prev_bet);
				break;
				case "b 1":
					credit.bet(1);
					System.out.println("Player is betting "+credit.prev_bet);
				break;
				case "b 2":
					credit.bet(2);
					System.out.println("Player is betting "+credit.prev_bet);
				break;
				case "b 3":
					credit.bet(3);
					System.out.println("Player is betting "+credit.prev_bet);
				break;
				case "b 4":
					credit.bet(4);
					System.out.println("Player is betting "+credit.prev_bet);
				break;
				case "b 5":
					credit.bet(5);
					System.out.println("Player is betting "+credit.prev_bet);
				break;
				case "d":
					credit.bet();
					getHand();
					hand.printHand();
				break;
				default:
					System.out.println("Error: Command entry is wrong.");// Optional
			}
			
			if(!((runs>0)&&(cmd1.equals("d")))){
				cmd2=Process2();
				
				while(!cmd2.equals("d")){
					switch(cmd2){
					case "$":
						System.out.println("player's credit is "+credit.getActual_credit());//mambos
					break;
					case "q":
						System.exit(0);//leave game;
					break;
					default:
						System.out.println(cmd2+": illegal command");
						
					}
					cmd2=Process2();
				}
				
				switch(cmd2) {
					case "d":
						getHand();
						hand.printHand();
					break;
					default:
						System.out.println("Erro fatal");
				}
			}
				
				cmd3= Process3();
				
				while(!(validHold(cmd3))){ //enquanto não for nenhum
					switch(cmd3){
					case "$":
						System.out.println("player's credit is "+credit.getActual_credit());//mambos
					break;
					case "q":
						System.exit(0);//leave game;
					break;
					case "a":
						System.out.println("Isto deveria imprimir o advise.");// Fazer o advice
					break;
					case "s":
						System.out.println("Isto deveria imprimir as estatísticas.");// Estatisticas
					break;
					default:
						System.out.println(cmd3+": illegal command");
					}
					cmd3=Process3();
				}
			
			
			
			
			holdPlay(cmd3);
			hand.printHand();
			
			if (credit.getActual_credit()<=0){
				System.out.println("Player has 0 credit. Game Over.");
				System.exit(0);
			}
			runs++;
		}	
	}
		
	public abstract void getHand();	
	public abstract void holdPlay(String cmd3);
	public abstract String Process1() throws IOException;
	public abstract String Process2() throws IOException;
	public abstract String Process3() throws IOException;
	
}
