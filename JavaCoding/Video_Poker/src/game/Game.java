package game;

public abstract class Game{
	Credit credit;
	
	public Game(int credit){
		this.credit= new Credit(credit);
		
	}
	
	public void init(){
		
		String cmd1="ABC";
		String[] cmdaux;
		int i=0;
		boolean isInteger=true;
		//Assume-se que receber� no m�ximo dois caracteres;
		cmd1=Process1();
		
		while((cmd1!="b")&&(cmd1!="b 1")&&(cmd1!="b 2")&&(cmd1!="b 3")&&(cmd1!="b 4")&&(cmd1!="b 5")&&(cmd1!="q")&&(cmd1!="$")&&(cmd1!="s")){
			if(cmd1.length()<=1){
				System.out.println(cmd1 +": illegal command1"); // caso em que � apenas 1 caracter e n�o corresponde a $,b ou q
			}
			else{
				if((cmd1.charAt(1)==' ')&&(cmd1.length()>2)){ //se o segundo caracter n�o for 1 espa�o = illegal command (n�o existem comandos com mais q 1 char)
					cmdaux=cmd1.split(" ");
					if (cmdaux.length<3){ //n�o existem comandos com 3 strings
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
			case "s":
				//mambos
			break;
			case "$":
				System.out.println("player's credit is "+credit.getActual_credit());//mambos
			break;
			case "q":
				System.exit(0);//leave game;
			break;
			default:
				System.out.println("Error: Command entry is wrong.");// Optional
		      // Statements
		}
		
	}
		
	
	public abstract String Process1();
	public abstract String Process2();
	public abstract String Process3();
	
}
