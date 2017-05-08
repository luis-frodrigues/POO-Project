package game;

import java.io.*;

public class Interactive extends Game{

	public Interactive(int credit) {
		super(credit);
		// TODO Auto-generated constructor stub
	}
	
	public String Process1(){
		boolean Error=true;
		String cmd2="";
		
		do{
			try{
					InputStreamReader kboard = new InputStreamReader(System.in);
					BufferedReader buffer = new BufferedReader(kboard);
					cmd2 = buffer.readLine(); // take a string as input from keyboard
					Error=false;
					
			}
			catch(Exception e){
				System.out.println("Introduce a valid command.");
			}
		}while(Error);
		
		return cmd2;
	}
	public String Process2() throws IOException {
		boolean Error=true;
		String cmd1="";
		
		do{
			try{
					InputStreamReader kboard = new InputStreamReader(System.in);
					BufferedReader buffer = new BufferedReader(kboard);
					cmd1 = buffer.readLine(); // take a string as input from keyboard
					Error=false;
					
			}
			catch(Exception e){
				System.out.println("Introduce a valid command.");
			}
		}while(Error);
		
		return cmd1;
	}
	public String Process3() throws IOException {
		boolean Error=true;
		String cmd3="";
		
		do{
			try{
					InputStreamReader kboard = new InputStreamReader(System.in);
					BufferedReader buffer = new BufferedReader(kboard);
					cmd3 = buffer.readLine(); // take a string as input from keyboard
					Error=false;
					
			}
			catch(Exception e){
				System.out.println("Introduce a valid command.");
			}
		}while(Error);
		
		return cmd3;
	}
	
	public void getHand(){
		hand.giveHand();
	}
	
	public void holdPlay(String cmd3){
		hand.Hold(cmd3);
	}

}