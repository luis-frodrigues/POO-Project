package stuff;

public class Stuff {
		static char mode = '\0';
		static int credit, bet, nbdeals;
		static String cmdFile, cardFile;
		
		public static char getModeS() {
			return mode;
		}
		public static int getCreditS() {
			return credit;
		}
		public static int getBetS() {
			return bet;
		}
		public static int getNbdealsS() {
			return nbdeals;
		}
		public static String getCmdFileS() {
			return cmdFile;
		}
		public static String getCardFileS() {
			return cardFile;
		}

	static void printUsage(){
		System.out.println("Usage:");
		System.out.println("->To play Interactive mode: " + "Main -i <credit>");
		System.out.println("->To play Debug mode: " + "Main -d <credit> <cmd-file> <card-file>");
		System.out.println("->To play Simulation mode: " + "Main -s <credit> <bet> <nbdeals>");
		System.out.println();
	}
	
	static void checkmode(String[] args){
		
		if(args[0].equals("-i")){
			mode='i';
			if(args.length==2){
			    try {
					credit = Integer.parseInt(args[1]);
					System.out.println("Interactive mode: " + Integer.toString(credit) + " credits selected");
			    } catch (NumberFormatException e) {
					printUsage();
			        System.err.println("Argument '" + args[1] + "' must be an integer.");
					System.exit(1);
			    }				
			}else{
				System.out.println("Error: wrong number of arguments for interactive mode");
				printUsage();
				System.exit(1);
			}
		}else if(args[0].equals("-d")){
			mode='d';
			
			if(args.length==4){
			   	try {
					credit = Integer.parseInt(args[1]);
					System.out.println("Debug mode: " + Integer.toString(credit) + " credits selected");
			    } catch (NumberFormatException e) {
					printUsage();
			        System.err.println("Argument '" + args[1] + "' must be an integer.");
					System.exit(1);
			    }		
				cmdFile = args[2];
				cardFile = args[3];
				System.out.println("cmd-file selected: " + cmdFile);
				System.out.println("card-file selected: " + cardFile);
			}else{
				System.out.println("Error: wrong number of arguments for debug mode");
				printUsage();
				System.exit(1);
			}
		}else if(args[0].equals("-s")){
			mode='s';
			
			if(args.length==4){
			   	try {
					credit = Integer.parseInt(args[1]);
					bet = Integer.parseInt(args[2]);
					nbdeals = Integer.parseInt(args[3]);
					if(bet>=1 && bet<=5){
					System.out.println("Simulation mode: " + Integer.toString(credit) + " credits, " + Integer.toString(bet) + " bet, " + Integer.toString(nbdeals) + " nbdeals selected");
					}else{
						System.out.println("bet: amount must be between 1 and 5");
						printUsage();
						System.exit(1);
					}
				} catch (NumberFormatException e) {
					printUsage();
			    	System.err.println("Arguments '" + args[1] + "', '" + args[2] + "' and '" + args[3] + "' must all be integers.");
					System.exit(1);
			    }					
			}else{
				System.out.println("Error: wrong number of arguments for simulation mode");
				printUsage();
				System.exit(1);
			}
		}else if(args[0].equals("-g")){
			
			mode='g';
			if(args.length==1){
				System.out.println("Graphical interface mode selected ");
			}else{
				System.out.println("Error: wrong arguments for graphical interface mode");
				printUsage();
				System.exit(1);
			}
		}else{
			System.out.println("Error: selected mode " + args[0] + " unknown");
			printUsage();
			System.exit(1);
		}
	}
}