package stuff;

import game.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.CountDownLatch;

public class Main{

	private static JFrame frame;
	private static JTextField textField;
	private static JPanel panel;
	private static int credit;
	private static GraphicalInterface gI;
	private static CountDownLatch latch;
	
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
			if(Stuff.getModeS()=='g'){
				

				frame = new JFrame();
				
				
				frame.setBounds(0, 0, 550, 300);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				panel = new JPanel();
				panel.setBackground(new Color(0, 128, 128));
				frame.getContentPane().add(panel, BorderLayout.CENTER);
				panel.setLayout(null);
				
				JLabel label = new JLabel();
				label.setText("Welcome! Choose credit and press Enter :D");
				label.setForeground(new Color(255, 255, 255));
				label.setFont(new Font("Tahoma", Font.BOLD, 20));
				label.setBounds(40, 100, 546, 26);
				panel.add(label);
				label.setVisible(true);
				textField = new JTextField();
				textField.setBounds(40, 156, 146, 26);
				panel.add(textField);
				textField.setVisible(true);
				frame.setVisible(true);
				textField.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent evt){
					    String input = textField.getText();
					    
					    try {
					    	int intInput = Integer.parseInt(input);
					    	credit = intInput;
							System.out.println("Graphical mode: " + credit + " credits selected");
					    } catch (NumberFormatException e) {
					        System.err.println("Invalid Credits");
							System.exit(1);
					    }	
					    if(credit>0){
						textField.removeActionListener(this);
						textField.setVisible(false);
						panel.remove(textField);
						frame.getContentPane().removeAll();
						frame.repaint();
						latch.countDown();
					    }else{
					    	label.setText("Please insert a positive Integer");
					    }
					}
				});
				while(credit<=0){
					latch = new CountDownLatch(1);
					try {
						latch.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				gI = new GraphicalInterface(credit, frame);
				gI.init();					
			}

		}


}
