package stuff;

public class Main {

	public static void main(String[] args) {
		
		if(args.length < 1){
			System.out.println("Error: No arguments received");
			Stuff.printUsage();
			System.exit(1);
		}else{
			System.out.print("Arguments received: ");
			for	(int i=0; i<args.length; i++)
				System.out.print(args[i] + " ");
			System.out.println();
			final char mode = Stuff.checkmode(args[0]);
			System.out.println("Selected mode: " + mode);
			Stuff.getArgs(args);
			
		}

		System.out.println("The end!");
	}
	

	

}
