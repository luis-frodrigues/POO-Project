package stuff;

import game.*;

public class Main {

	public static void main(String[] args){
		
			if(args.length < 1){
				System.out.println("Error: No arguments received");
				Stuff.printUsage();
				System.exit(1);
			}else{
				System.out.print("Arguments received: ");
				for	(int i=0; i<args.length; i++)
					System.out.print(args[i] + " ");
				System.out.println();
				Stuff.checkmode(args);
			}
			
			if(Stuff.getModeS()=='i'){
				Interactive interactive = new Interactive(Stuff.getCreditS());
				interactive.init();
				System.exit(0);
			}
			if(Stuff.getModeS()=='d'){
				String cmdfile=Debug.Readfile(Stuff.getCmdFileS());
				String cardfile=Debug.Readfile(Stuff.getCardFileS());
				String[] cmdaux=cmdfile.split(" ");
				String[] cardsaux=cardfile.split(" ");
				Debug debug = new Debug(Stuff.getCreditS(), cmdaux, cardsaux);
				debug.init();
			}
			if(Stuff.getModeS()=='s'){
				Simulation simulation = new Simulation(Stuff.getCreditS(), Stuff.getNbdealsS(), Stuff.getBetS());
				simulation.init();
			}
		}


}
