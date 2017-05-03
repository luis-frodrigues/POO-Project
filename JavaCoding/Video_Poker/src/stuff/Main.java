package stuff;

public class Main {

	public static void main(String[] args) {

		init(args);
		System.out.println("The end!");

	}
	
	private static void init(String[] args){
		
		if(args.length < 1){
			System.out.println("Error: No arguments received");
			printUsage();
			System.exit(1);
		}else{
			System.out.print("Arguments received: ");
			for	(int i=0; i<args.length; i++)
				System.out.print(args[i] + " ");
			System.out.println();
			final char mode = checkmode(args[0]);
			System.out.println("Selected mode: " + mode);
			
		}
		
	}
	private static void printUsage(){
		System.out.println("Usage:");
		System.out.println("->To play Interactive mode: " + "Main -i <credit>");
		System.out.println("->To play Debug mode: " + "Main -d <credit> <cmd-file> <card-file>");
		System.out.println("->To play Simulation mode: " + "Main -s <credit> <bet> <nbdeals>");
		System.out.println();
	}
	
	private static char checkmode(String mode){
		char result = '0';
		
		if(mode.equals("-i")){
			result='i';
		}else if(mode.equals("-d")){
			result='d';
		}else if(mode.equals("-s")){
			result='s';
		}else{
			System.out.println("Error: selected mode " + mode + " inexistent");
			printUsage();
			System.exit(1);
		}
		return result;

	}
	

}
