package game;

public abstract class Game{
	Player kinhas;
	
	Game(int credit){
		kinhas= new Player(credit);
	}
	
	public void init(){
		
		String cmd1="ABC";
		String[] cmdaux;
		int i=0;
		boolean isInteger=true;
		//Assume-se que receberá no máximo dois caracteres;
		cmd1=Process1();
		
		while((cmd1!="b")&&(cmd1!="b 1")&&(cmd1!="b 2")&&(cmd1!="b 3")&&(cmd1!="b 4")&&(cmd1!="b 5")&&(cmd1!="q")&&(cmd1!="$")&&(cmd1!="s")){
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
			cmd1=Process1();
		}
	}
	
	public abstract String Process1();
	
}
