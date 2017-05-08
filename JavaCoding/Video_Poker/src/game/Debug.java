package game;
//import java.io.*;

public class Debug extends Game {

	int cmdcount=0;
	int cardcount=0;
	
	String[] cmdaux;
	String[] cardsaux;
	
	public Debug(int credit, String[] cmdaux, String[] cardsaux) {
		super(credit, cardsaux);
		this.cmdaux=cmdaux;
		this.cardsaux=cardsaux;
	}

	public String Process1() {
		
		if (cmdaux.length==cmdcount){
			System.out.println("We have ran out of commands.");
			return("q");
		}
		String cmd1=cmdaux[cmdcount];
		cmdcount++;
		if ((cmdaux[cmdcount-1].charAt(0)==('b'))&&(cmdaux.length>cmdcount)){
			if((cmdaux[cmdcount].charAt(0))>='0'&&(cmdaux[cmdcount].charAt(0)<='9')){
				cmd1=cmdaux[cmdcount-1]+" "+cmdaux[cmdcount];
				cmdcount++;
			}
		}
		return cmd1;
	}
	public String Process2() {
		
		if (cmdaux.length==cmdcount){
			System.out.println("We have ran out of commands.");
			return("q");
		}
		String cmd2=cmdaux[cmdcount];
		
		cmdcount++;
		
		return cmd2;
	}
	
	public String Process3() {
		int i=0;
		if (cmdaux.length==cmdcount){
			System.out.println("We have ran out of commands.");
			return("q");
		}
		
		String cmd3=cmdaux[cmdcount];
		cmdcount++;
		
		if ((cmdaux[cmdcount-1].charAt(0)==('h'))&&(cmdaux.length>cmdcount)){
			while(cmdaux.length>cmdcount && i<5){
				if((cmdaux[cmdcount].charAt(0))<'0'||(cmdaux[cmdcount].charAt(0)>'9')){
					break; //this guarantees that everything that is put on the cmd after 'h' starts with an integer
				}else{
					cmd3= cmd3 + " " + cmdaux[cmdcount];
					cmdcount++;
					i++; // this is supposed to guarantee that no more than 5 cmds are read
				}
			}
		}
		return (cmd3);
	}
	
	public void getHand(){
		hand.giveHand(cmdaux, cardcount);
		cardcount=cardcount+5;
	}
	
	public void holdPlay(String cmd3){
		cardcount= cardcount + hand.Hold(cmd3, cardcount);
	}

}
