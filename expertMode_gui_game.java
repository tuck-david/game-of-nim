

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.math.*;

public class expertMode_gui_game extends JFrame {
	static int[] comp_turn = new int[2]; //array storing the ExpertAI moves
	static int max_int = 3;
	static int stones_inpile = (int)(Math.random() * 15 + 15);
	static JLabel stones_reamining_label = new JLabel("The stones remaining are " + stones_inpile, JLabel.CENTER);
	static JLabel cpu_stones_taken_label = new JLabel("The CPU took " + comp_turn[0] + " stones", JLabel.CENTER);
	JButton takeOne = new JButton("Take one stone");
	JButton takeTwo = new JButton("Take two stones");
	JButton takeThree = new JButton("Take three stones");
	static int cpu_turns_counter = 0;
	
	boolean cpu_winB = false;
	boolean user_winB = false;
	static int cpu_stones_taken;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					expertMode_gui_game frame = new expertMode_gui_game();
					frame.setVisible(true);
					//put 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public expertMode_gui_game() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 600);
		setLayout(new BorderLayout(0, 0));
		setTitle("Game of Nim - Expert Mode");
		add(stones_reamining_label, BorderLayout.PAGE_START);
		
		add(takeOne, BorderLayout.LINE_START);
		
		add(takeTwo, BorderLayout.CENTER);
		
		add(takeThree, BorderLayout.LINE_END);
		
		add(cpu_stones_taken_label, BorderLayout.PAGE_END);
		
		stone_1taken stone_1taken = new stone_1taken();
		takeOne.addActionListener(stone_1taken);
		
		stone_2taken stone_2taken = new stone_2taken();
		takeTwo.addActionListener(stone_2taken);

		stone_3taken stone_3taken = new stone_3taken();
		takeThree.addActionListener(stone_3taken);
		if (cpu_turns_counter < 1) { //check if it is the first move for the CPU, if it is the first move different calculation will be done to produce a winning move
	        computer_turn(stones_inpile); //method providing the 1st move for the CPU
	        stones_inpile = stones_inpile - comp_turn[0]; //subtracting the CPU's move from the pile of stones
			stones_reamining_label.setText("The stones remaining are " + stones_inpile + ".");
			cpu_stones_taken_label.setText("The CPU took " + comp_turn[0] + " stones.");

	    }
		
	}
	public class stone_1taken implements ActionListener {
		public void actionPerformed(ActionEvent stone_1taken) {
    			int userinput_stones = 1;
			stones_inpile = stones_inpile-1;
			stones_reamining_label.setText("The stones remaining are " + stones_inpile);
			if (stones_inpile == 1) {
    				JOptionPane.showMessageDialog(null, "Congrajulations you have won!", "Game Ended - You have won!", JOptionPane.INFORMATION_MESSAGE);	       
				System.exit(0);
			}

		    computer_turn2(userinput_stones); //running method to calculate 2nd move or greater for the CPU
		    stones_inpile = stones_inpile - comp_turn[1]; //subtracting the CPU's move from the pile of stones
		    stones_reamining_label.setText("The stones remaining are " + stones_inpile + ".");
			cpu_stones_taken_label.setText("The CPU took " + comp_turn[1] + " stones.");
			
			cpu_turns_counter++;
		//CPU's turn
		if (stones_inpile == 1) {
			JOptionPane.showMessageDialog(null, "Sorry you have lost.", "Game Ended - You have lost.", JOptionPane.INFORMATION_MESSAGE);	       
			System.exit(0);
		}

		}
	}
	
	public class stone_2taken implements ActionListener {
		public void actionPerformed(ActionEvent stone_2taken) {
			//CPU's turn
			if (stones_inpile - 2 == 0) {
				JOptionPane.showMessageDialog(null, "Sorry you have lost since you took the last stone.", "Game Ended - You have lost.", JOptionPane.INFORMATION_MESSAGE);	       
			}
			else if (stones_inpile - 2 <= 0) {
				JOptionPane.showMessageDialog(null, "Not valid input.", "Error", JOptionPane.ERROR_MESSAGE);	       
			}
			stones_inpile = stones_inpile-2;
			stones_reamining_label.setText("The stones remaining are " + stones_inpile);
			if (stones_inpile == 1) {
    				JOptionPane.showMessageDialog(null, "Congrajulations you have won!", "Game Ended - You have won!", JOptionPane.INFORMATION_MESSAGE);	       
				System.exit(0);
			}
			

	    		int userinput_stones = 2;
		    computer_turn2(userinput_stones); //running method to calculate 2nd move or greater for the CPU
		    stones_inpile = stones_inpile - comp_turn[1]; //subtracting the CPU's move from the pile of stones
		    stones_reamining_label.setText("The stones remaining are " + stones_inpile + ".");
			cpu_stones_taken_label.setText("The CPU took " + comp_turn[1] + " stones.");
			cpu_turns_counter++;
			if (stones_inpile == 1) {
				JOptionPane.showMessageDialog(null, "Sorry you have lost.", "Game Ended - You have lost.", JOptionPane.INFORMATION_MESSAGE);	       
				System.exit(0);
			}
		
		}
	}
	
	public class stone_3taken implements ActionListener {
		public void actionPerformed(ActionEvent stone_3taken) {	
			cpu_turns_counter++;
			//CPU's turn
			if (stones_inpile == 1) {
				JOptionPane.showMessageDialog(null, "Sorry you have lost.", "Game Ended - You have lost.", JOptionPane.INFORMATION_MESSAGE);	       
				System.exit(0);
			}
			
			if (stones_inpile - 3 == 0) {
				JOptionPane.showMessageDialog(null, "Sorry you have lost since you took the last stone.", "Game Ended - You have lost.", JOptionPane.INFORMATION_MESSAGE);	       
			}
			else if (stones_inpile - 3 <= 0) {
				JOptionPane.showMessageDialog(null, "Not valid input.", "Error", JOptionPane.ERROR_MESSAGE);	       
			}
			stones_inpile = stones_inpile-3;
			stones_reamining_label.setText("The stones remaining are " + stones_inpile);
			if (stones_inpile == 1) {
    				JOptionPane.showMessageDialog(null, "Congrajulations you have won!", "Game Ended - You have won!", JOptionPane.INFORMATION_MESSAGE);	       
				System.exit(0);
			}

	    		int userinput_stones = 3;
		    computer_turn2(userinput_stones); //running method to calculate 2nd move or greater for the CPU
		    stones_inpile = stones_inpile - comp_turn[1]; //subtracting the CPU's move from the pile of stones
		    stones_reamining_label.setText("The stones remaining are " + stones_inpile + ".");
			cpu_stones_taken_label.setText("The CPU took " + comp_turn[1] + " stones.");
			cpu_turns_counter++;
			//CPU's turn
			if (stones_inpile == 1) {
				JOptionPane.showMessageDialog(null, "Sorry you have lost.", "Game Ended - You have lost.", JOptionPane.INFORMATION_MESSAGE);	       
				System.exit(0);
			}

		}
	}
	public static int computer_turn(int size_of_heap) {
		 
		 int size_of_heap_adjusted_misere = size_of_heap-1; 
		 
		 comp_turn[0] = size_of_heap_adjusted_misere%(max_int+1);

		 if (comp_turn[0] == 0) {	 
			 comp_turn[0] = (int)(Math.random() * 3 + 1);;
		 }
		 
		 return comp_turn[0];
	 }
	 
	 public static int computer_turn2(int userinput_stones) {
		 comp_turn[1] = (max_int + 1) - userinput_stones;
		 
		 return comp_turn[1];
	 }

}
	
	