import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.math.*;

public class easyMode_gui_game extends JFrame {
	static int[] comp_turn = new int[2]; //array storing the ExpertAI moves
	static int max_int = 3;
	static int stones_inpile = (int)(Math.random() * 15 + 15);
	JLabel stones_reamining_label = new JLabel("The stones remaining are " + stones_inpile, JLabel.CENTER);
	JLabel cpu_stones_taken_label = new JLabel("The CPU took " + comp_turn[0] + " stones", JLabel.CENTER);
	JButton takeOne = new JButton("Take one stone");
	JButton takeTwo = new JButton("Take two stones");
	JButton takeThree = new JButton("Take three stones");
	
	boolean cpu_winB = false;
	boolean user_winB = false;
	static int cpu_stones_taken;
	static int cpu_turns_counter = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					easyMode_gui_game frame = new easyMode_gui_game();
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
	public easyMode_gui_game() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 600);
		setLayout(new BorderLayout(0, 0));
		setTitle("Game of Nim - Easy Mode");
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

		if (cpu_turns_counter < 1) {
			cpu_stones_taken = (int)(Math.random() * 3 + 1);
			//CPU's turn
			if (stones_inpile == 5) {
				cpu_stones_taken = 3; 
	        } else if (stones_inpile == 4) {
	        		cpu_stones_taken = 3;
	        } else if (stones_inpile == 3) {
        			cpu_stones_taken = 2;
	        } else if (stones_inpile == 2) {
        		    cpu_stones_taken = 1;
	        }
			
			stones_inpile = stones_inpile - cpu_stones_taken;
			stones_reamining_label.setText("The stones remaining are " + stones_inpile + ".");
			cpu_stones_taken_label.setText("The CPU took " + cpu_stones_taken + " stones.");
			cpu_turns_counter++;
		}
		
	}
	public class stone_1taken implements ActionListener {
		public void actionPerformed(ActionEvent stone_1taken) {
			stones_inpile = stones_inpile-1;
			stones_reamining_label.setText("The stones remaining are " + stones_inpile);
			if (stones_inpile == 1) {
    				JOptionPane.showMessageDialog(null, "Congrajulations you have won!", "Game Ended - You have won!", JOptionPane.INFORMATION_MESSAGE);	       
				System.exit(0);
			}
			
			cpu_stones_taken = (int)(Math.random() * 3 + 1);
			//CPU's turn
			if (stones_inpile == 5) {
				cpu_stones_taken = 3; 
	        } else if (stones_inpile == 4) {
	        		cpu_stones_taken = 3;
	        } else if (stones_inpile == 3) {
        			cpu_stones_taken = 2;
	        } else if (stones_inpile == 2) {
        		    cpu_stones_taken = 1;
	        }
			
			stones_inpile = stones_inpile - cpu_stones_taken;
			stones_reamining_label.setText("The stones remaining are " + stones_inpile + ".");
			cpu_stones_taken_label.setText("The CPU took " + cpu_stones_taken + " stones.");
			if (stones_inpile == 1) {
				JOptionPane.showMessageDialog(null, "Sorry you have lost.", "Game Ended - You have lost.", JOptionPane.INFORMATION_MESSAGE);	       
				System.exit(0);
			}

		}
	}
	
	public class stone_2taken implements ActionListener {
		public void actionPerformed(ActionEvent stone_2taken) {
			if (stones_inpile - 2 == 0) {
				JOptionPane.showMessageDialog(null, "Sorry you have lost since you took the last stone.", "Game Ended - You have lost.", JOptionPane.INFORMATION_MESSAGE);	       
			}
			else if (stones_inpile - 2 < 0) {
				JOptionPane.showMessageDialog(null, "Not valid input.", "Game Ended - You have lost.", JOptionPane.INFORMATION_MESSAGE);	       
			}
			stones_inpile = stones_inpile-2;
			stones_reamining_label.setText("The stones remaining are " + stones_inpile);
			if (stones_inpile == 1) {
				JOptionPane.showMessageDialog(null, "Congrajulations you have won!", "Game Ended - You have won!", JOptionPane.INFORMATION_MESSAGE);	       
			    System.exit(0);
		    }
			
			cpu_stones_taken = (int)(Math.random() * 3 + 1);
			//CPU's turn
			if (stones_inpile == 5) {
				cpu_stones_taken = 3; 
	        } else if (stones_inpile == 4) {
	        		cpu_stones_taken = 3;
	        } else if (stones_inpile == 3) {
        			cpu_stones_taken = 2;
	        } else if (stones_inpile == 2) {
        		    cpu_stones_taken = 1;
	        }
			
			stones_inpile = stones_inpile - cpu_stones_taken;
			stones_reamining_label.setText("The stones remaining are " + stones_inpile + ".");
			cpu_stones_taken_label.setText("The CPU took " + cpu_stones_taken + " stones.");
			if (stones_inpile == 1) {
				JOptionPane.showMessageDialog(null, "Sorry you have lost.", "Game Ended - You have lost.", JOptionPane.INFORMATION_MESSAGE);	       
				System.exit(0);
			}
		}
	}
	
	public class stone_3taken implements ActionListener {
		public void actionPerformed(ActionEvent stone_3taken) {	
			if (stones_inpile - 3 == 0) {
				JOptionPane.showMessageDialog(null, "Sorry you have lost since you took the last stone.", "Game Ended - You have lost.", JOptionPane.INFORMATION_MESSAGE);	       
			}
			else if (stones_inpile - 3 <= 0) {
				JOptionPane.showMessageDialog(null, "Not valid input.", "Game Ended - You have lost.", JOptionPane.INFORMATION_MESSAGE);	       
			}
			stones_inpile = stones_inpile-3;
			stones_reamining_label.setText("The stones remaining are " + stones_inpile);
			if (stones_inpile == 1) {
				JOptionPane.showMessageDialog(null, "Congrajulations you have won!", "Game Ended - You have won!", JOptionPane.INFORMATION_MESSAGE);	       
			    System.exit(0);
		    }
			
			cpu_stones_taken = (int)(Math.random() * 3 + 1);
			//CPU's turn
			if (stones_inpile == 5) {
				cpu_stones_taken = 3; 
	        } else if (stones_inpile == 4) {
	        		cpu_stones_taken = 3;
	        } else if (stones_inpile == 3) {
        			cpu_stones_taken = 2;
	        } else if (stones_inpile == 2) {
        		    cpu_stones_taken = 1;
	        }
			
			stones_inpile = stones_inpile - cpu_stones_taken;
			stones_reamining_label.setText("The stones remaining are " + stones_inpile + ".");
			cpu_stones_taken_label.setText("The CPU took " + cpu_stones_taken + " stones.");
			if (stones_inpile == 1) {
				JOptionPane.showMessageDialog(null, "Sorry you have lost.", "Game Ended - You have lost.", JOptionPane.INFORMATION_MESSAGE);	       
				System.exit(0);
			}
			
			
		}
	}
	
	
	
	
	
}
	
	