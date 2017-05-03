package game;

public abstract class Game{
	Credit credit;
	
	public Game(int credit){
		this.credit= new Credit(credit);
	}
	
	static boolean verifyHold(String cmd3){
		String[] cmdaux;
		
		if (cmd3.length()==0){
			return(false);
		}else{
			if (cmd3.charAt(0)!='h'){
				return(false);
			}else{
				if ((cmd3.charAt(1)==' ')&&(cmd3.length()<3)){
					cmdaux=cmd3.split(" ");
				
				}
			}
			return(false);
		}
	}
	
	public void init(){
		
		String cmd1="ABC";
		String cmd2="ABC";
		String cmd3="ABC";
		String[] cmdaux;
		int i=0;
		boolean isInteger=true;
		//Assume-se que receberá no máximo dois caracteres;
		cmd1=Process1();
		
		while((cmd1!="b")&&(cmd1!="b 1")&&(cmd1!="b 2")&&(cmd1!="b 3")&&(cmd1!="b 4")&&(cmd1!="b 5")){
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
			default:
				if(cmd1.length()<=1){
					System.out.println(cmd1 +": illegal command1"); // caso em que é apenas 1 caracter e não corresponde a $,b ou q
				}
				else{
					if((cmd1.charAt(1)==' ')&&(cmd1.length()>2)){ //se o segundo caracter não for 1 espaço = illegal command (não existem comandos com mais q 1 char)
						cmdaux=cmd1.split(" ");
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
								}else{
									System.out.println(cmd1 +": illegal command2");
								}
							}else{
								System.out.println(cmd1 +": illegal command3");
							}
						}else{
							System.out.println(cmd1 +": illegal command4");
						}
					}else{
					System.out.println(cmd1 +": illegal command5");
					}
				}
			}
			cmd1=Process1();
		}
		
		switch(cmd1) {
			case "b":
				credit.bet();
			break;
			case "b 1":
				credit.bet(1);
			break;
			case "b 2":
				credit.bet(2);
			break;
			case "b 3":
				credit.bet(3);
			break;
			case "b 4":
				credit.bet(4);
			break;
			case "b 5":
				credit.bet(5);
			break;
			default:
				System.out.println("Error: Command entry is wrong.");// Optional
		}
		
		cmd2=Process2();
		
		while(cmd2!="d"){
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
				/*
						Statements que distribuem as cartas.
				  */
				 
			break;
			default:
				System.out.println("Erro fatal");
		}
		
		cmd3= Process3();
		
		while(!(verifyHold(cmd3))){
			
		}
		
		
	}
		
	
	public abstract String Process1();
	public abstract String Process2();
	public abstract String Process3();
	
}
