package game;

import strategy.Strategy107;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import java.util.concurrent.CountDownLatch;


public class GraphicalInterface extends Game {

	private JFrame frame;
	private JPanel panel;
	private JButton betButton, dealButton, holdButton, adviceButton, creditButton, statsButton;
	private JLabel creditlbl, advicelbl;
	private JComboBox<String> comboBox;
	private JRadioButton [] holdx = new JRadioButton[5];
	private JTextArea statistics;
	private CountDownLatch latch, latch2, latch3;
	private boolean active1, active2, active3;
	private int [] localHand=new int[5];
    private String [] file = new String[52];
	private JLabel [] card = new JLabel[5];
    
	String cmd1="", cmd2="", cmd3="", bet="";
	
	public GraphicalInterface(int credit, JFrame frame) {
		
		super(credit);
		this.frame = frame;
		initialize();


	}
	
	private void initialize() {
		//frame = new JFrame();
		frame.setBounds(0, 0, 1000, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();

		panel.setBackground(new Color(0, 128, 128));

		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		betButton = new JButton("Bet");
		betButton.setBounds(100, 399, 115, 29);
		panel.add(betButton);
		
		dealButton = new JButton("Deal");
		dealButton.setBounds(250, 399, 115, 29);
		panel.add(dealButton);
		
		adviceButton = new JButton("Advice");
		adviceButton.setBounds(400, 399, 115, 29);
		panel.add(adviceButton);
		
		holdButton = new JButton("Hold");
		holdButton.setBounds(550, 399, 115, 29);
		panel.add(holdButton);

		creditButton = new JButton("Credit");
		creditButton.setBounds(750, 429, 115, 29);
		panel.add(creditButton);
		
		statsButton = new JButton("Statistics");
		statsButton.setBounds(750, 399, 115, 29);
		panel.add(statsButton);
		
		statistics = new JTextArea();
		statistics.setRows(17);
		statistics.setRows(35);
		statistics.setBackground(new Color(0, 128, 128));
		statistics.setBounds(750, 90, 200, 280);
		statistics.setForeground(new Color(255, 255, 255));
		statistics.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(statistics);
		
		comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel<>(new String[] {"1", "2", "3", "4", "5"}));
		comboBox.setBounds(100, 429, 115, 29);
		panel.add(comboBox);
		
		holdx[0] = new JRadioButton("hold 1");
		holdx[1] = new JRadioButton("hold 2");
		holdx[2] = new JRadioButton("hold 3");
		holdx[3] = new JRadioButton("hold 4");
		holdx[4] = new JRadioButton("hold 5");
		int xpos=100;
		for(int i=0; i<=4; i++){
			holdx[i].setBounds(xpos, 300, 73, 29);
			panel.add(holdx[i]);
			xpos=xpos+100;
		}
		
		JLabel lblVideoPoker = new JLabel("Video Poker 10/7");
		lblVideoPoker.setForeground(new Color(255, 255, 255));
		lblVideoPoker.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblVideoPoker.setBounds(357, 16, 288, 57);
		panel.add(lblVideoPoker);
		
		creditlbl = new JLabel();
		creditlbl.setText("Actual Credit:  "+ credit.getActualCredit());
		creditlbl.setForeground(new Color(255, 255, 255));
		creditlbl.setFont(new Font("Tahoma", Font.BOLD, 20));
		creditlbl.setBounds(100, 75, 288, 50);
		panel.add(creditlbl);
		
		advicelbl = new JLabel();
		advicelbl.setText("");
		advicelbl.setForeground(new Color(255, 255, 255));
		advicelbl.setFont(new Font("Tahoma", Font.BOLD, 20));
		advicelbl.setBounds(100, 105, 640, 50);
		panel.add(advicelbl);
		
		String suits = "dsch";
        String faces = "23456789tjqka";
        int position=0;
        for (int suit=0; suit < suits.length(); suit++) {
        	for (int face=0; face < faces.length(); face++) {
        		file[position]=new StringBuilder().append(faces.charAt(face)).append(suits.charAt(suit)).toString();
        		position++;
        	}
        }
        xpos=100;
		for(int i=0; i<5;i++){
			card[i] = new JLabel();
			String imagePath = "C:/Users/Luís/Documents/git/POO-Project/JavaCoding/Video_Poker/src/cartas" + "doge" + ".gif";
			card[i].setIcon(new ImageIcon(imagePath));
			card[i].setBounds(xpos, 200, 73, 97);
			panel.add(card[i]);
			xpos=xpos+100;
		}

		
		frame.setVisible(true);
		
		betButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				System.out.println("bet clicked");
				//betButton.removeActionListener(this);
				if(active1){
					bet = String.valueOf(comboBox.getSelectedItem());
					cmd1 = new StringBuilder().append("b ").append(bet).toString();
					printStandardCards();
					latch.countDown();
				}
			}
		});
		creditButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				System.out.println("credit clicked");
				if(active1){
					cmd1="$";
					creditlbl.setText("Actual Credit:  "+ credit.getActualCredit());
					latch.countDown();
				}
				if(active2){
					cmd2="$";
					creditlbl.setText("Actual Credit:  "+ credit.getActualCredit());
					latch2.countDown();
				}
				if(active3){
					cmd3="$";
					creditlbl.setText("Actual Credit:  "+ credit.getActualCredit());
					latch3.countDown();
				}

			}
		});
		statsButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				System.out.println("stats clicked");
				if(active1){	
					cmd1="s";
					printStats();
					latch.countDown();
				}
				if(active2){
					cmd2="s";
					printStats();
					latch2.countDown();
				}
				if(active3){
					cmd3="s";
					printStats();
					latch3.countDown();
				}				
				
			}
		});
		dealButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				System.out.println("deal clicked");
				if(active1){
					cmd1="d";
					latch.countDown();
				}
				if(active2){
					cmd2="d";
					latch2.countDown();
				}
			}
		});
		holdButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				System.out.println("hold clicked");
				if(active3){
					cmd3 = "h";
					for(int i=0;i<=4;i++){
						if(holdx[i].isSelected()){
							cmd3 = new StringBuilder().append(cmd3).append(" ").append(i+1).toString();
							holdx[i].setSelected(false);
						}
					}
					System.out.println("hold:->" + cmd3);
					latch3.countDown();
				}

			}
		});
		adviceButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				System.out.println("advice clicked");
				if(active3){
					cmd3="a";
					String adviceString=parseAdvice(Strategy107.Advice(hand));
					advicelbl.setText(adviceString);
					latch3.countDown();
				}

			}
		});
		
		
	}
	
	public void getHand(){
		hand.giveHand();
		for(int i=0; i<5;i++){
			localHand[i]=hand.getPlayerCardValue(i);
		}
		printCardsToPanel(localHand);
	}
	
	public void holdPlay(String cmd3){
		hand.Hold(cmd3);
		for(int i=0; i<5;i++){
			localHand[i]=hand.getPlayerCardValue(i);
		}
		printCardsToPanel(localHand);
	}
	
	public String Process1(){
		cmd1="";
		active1=true;
		printStats();
		advicelbl.setText(stratResult);
		
		latch = new CountDownLatch(1);
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		active1 = false;
		advicelbl.setText("");
		
		return cmd1;			

	}
	public String Process2(){
		cmd2="";
		active2=true;
		printStats();
		latch2 = new CountDownLatch(1);
		try {
			latch2.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		active2=false;
		//advicelbl.setText("");
		return cmd2;
	}
	public String Process3(){
		cmd3="";
		active3=true;
		printStats();
		latch3 = new CountDownLatch(1);
		try {
			latch3.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		active3=false;
		return cmd3;		
	}
	
	public void printCardsToPanel(int [] localHand){
		int x = 100;

		for(int i=0; i<5;i++){
			panel.remove(card[i]);
		}
		for(int i=0; i<5;i++){
			System.out.println("localHand["+i+"]: "+localHand[i]);
			card[i] = new JLabel();
			String imagePath = "C:/Users/Luís/Documents/git/POO-Project/JavaCoding/Video_Poker/src/cartas" + file[localHand[i]]+ ".gif";
			card[i].setIcon(new ImageIcon(imagePath));
			card[i].setBounds(x, 200, 73, 97);
			panel.add(card[i]);
			x=x+100;
		}
		panel.validate();
		panel.repaint();
		frame.setVisible(true);
		
	}
	public void printStandardCards(){
		int xpos=100;
		for(int i=0; i<5;i++){
			panel.remove(card[i]);
		}
		for(int i=0; i<5;i++){
			card[i] = new JLabel();
			String imagePath = "C:/Users/Luís/Documents/git/POO-Project/JavaCoding/Video_Poker/src/cartas" + "doge" + ".gif";
			card[i].setIcon(new ImageIcon(imagePath));
			card[i].setBounds(xpos, 200, 73, 97);
			panel.add(card[i]);
			xpos=xpos+100;
		}
		panel.validate();
		panel.repaint();
		frame.setVisible(true);
	}
	public void printStats(){
		int [] stats = new int[10];
		int sum = 0, actualCredit, inicialCredit;
		float gain;
		
		stats=stat.getStats();
		statistics.setText("");
		statistics.setText("Hand               Nb   " + "\n");
		statistics.append("______________________" + "\n");
		statistics.append("Jacks or Better    " + stats[0] + "   " + "\n");
		statistics.append("Two Pair               " + stats[1] + "   " + "\n");
		statistics.append("Three of a Kind    " + stats[2] + "   " + "\n");
		statistics.append("Straight                " + stats[3] + "   " + "\n");
		statistics.append("Flush                     " + stats[4] + "   " + "\n");
		statistics.append("Full House            " + stats[5] + "   " + "\n");
		statistics.append("Four of a Kind      " + stats[6] + "   " + "\n");
		statistics.append("Straight Flush      " + stats[7] + "   " + "\n");
		statistics.append("Royal Flush           " + stats[8] + "   " + "\n");
		statistics.append("Other                    " + stats[9] + "   " + "\n");
		statistics.append("______________________" + "\n");
		for(int i=0; i<=9; i++)
			sum = sum + stats[i];
		statistics.append("Total                    " + sum + "   "  + "\n");
		statistics.append("______________________"  + "\n");
		
		actualCredit=credit.getActualCredit();
		inicialCredit=credit.getInitialCredit();
		gain = (float) actualCredit/inicialCredit;
		gain = gain*100;
		statistics.append("Credit        " + actualCredit + "(");
		String gain2 = String.format("%.2f", gain);
		statistics.append(gain2);
		statistics.append("%)");
		
		creditlbl.setText("Actual Credit:  "+ credit.getActualCredit());
	}
	

}
