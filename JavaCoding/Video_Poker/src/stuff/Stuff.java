package stuff;

public class Stuff {
	
	static void printUsage(){
		System.out.println("Usage:");
		System.out.println("->To play Interactive mode: " + "Main -i <credit>");
		System.out.println("->To play Debug mode: " + "Main -d <credit> <cmd-file> <card-file>");
		System.out.println("->To play Simulation mode: " + "Main -s <credit> <bet> <nbdeals>");
		System.out.println();
	}
	
	static char checkmode(String mode){
		char result = '\0';
		
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
	static void getArgs(String[] args){
		
	}
}
