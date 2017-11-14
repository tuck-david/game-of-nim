import java.math.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;
import java.awt.*;

public class GuiFinalNim extends JFrame {
	
	Font titleFont = new Font("Helvetica", Font.PLAIN, 15);
	static String name_user_1;
	JButton pVp = new JButton("Player vs Player?");
	JButton pVEc = new JButton("Player vs Expert Computer?");
	JButton pVBc = new JButton("Player vs Beginner Computer?");
	JButton quit = new JButton("QUIT");
	JTextField welcome = new JTextField(
			"Enter your name here.", 30);
	JLabel rules = new JLabel(
			"Welcome to the Game of Nim, "
					// explain rules of game and greet user
					+ ". How to play: The game starts with 15-30 stones in a pile. \nThe first player will be able to take away 1-3 stones from the pile. The second player will do the same. "
					+ "\nEventually, there will be only one stone left, and the player to pick up the last stone will lose. \nPress enter to continue.");
	JLabel askmode = new JLabel("Welcome to the Game of Nim! Enter your name in the textbox below and pick which mode you would like to play.", JLabel.CENTER);
	static int max_int = 3; //allows us to change how many tokens can be take each turn
	static GuiFinalNim gui = new GuiFinalNim();

	
	public GuiFinalNim() {
		
		setLayout(new BorderLayout());
		welcome.setFont(titleFont);
		askmode.setFont(titleFont);
		add(welcome, BorderLayout.PAGE_END);
		add(pVBc, BorderLayout.LINE_START);
		add(pVEc, BorderLayout.CENTER);
		add(pVp, BorderLayout.LINE_END);
		add(askmode, BorderLayout.PAGE_START);

		easy_button_event e = new easy_button_event();
		pVBc.addActionListener(e); //beginner mode 
		
		//expert mode
		expert_button_event expert_mode_button_check = new expert_button_event();
		pVEc.addActionListener(expert_mode_button_check);
		
		player_vs_player_event p_v_p = new player_vs_player_event();
		pVp.addActionListener(p_v_p);
		
	}
	public class easy_button_event implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			easyMode_gui_game easyMode_gui_game = new easyMode_gui_game();
			name_user_1 = welcome.getText();
			if (name_user_1.equals("Enter your name here.")) {
				JOptionPane.showMessageDialog(null, "Please enter a name first.", "Error", JOptionPane.ERROR_MESSAGE);
		    } else if (name_user_1.equals("")) {
        			JOptionPane.showMessageDialog(null, "Please enter a name first.", "Error", JOptionPane.ERROR_MESSAGE);	       
			} else if (!name_user_1.equals("")) {
				JOptionPane.showMessageDialog(null, "Welcome to the game of nim, " + name_user_1 + ". How to play: The game starts with 15-30 stones in a pile. \nThe first player will be able to take away 1-3 stones from the pile. The second player will do the same. " + "\nEventually, there will be only one stone left, and the player to pick up the last stone will lose. The CPU will go first.", "How to play the game/rules", JOptionPane.INFORMATION_MESSAGE);
				easyMode_gui_game.setVisible(true);
				gui.setVisible(false);
			}
		}
	}
	
	public class expert_button_event implements ActionListener {
		public void actionPerformed(ActionEvent expert_mode_button_check) {
			expertMode_gui_game expertMode_gui_game = new expertMode_gui_game();
			name_user_1 = welcome.getText();
			if (name_user_1.equals("Enter your name here.")) {
				JOptionPane.showMessageDialog(null, "Please enter a name first.", "Error", JOptionPane.ERROR_MESSAGE);
		    } else if (name_user_1.equals("")) {
        			JOptionPane.showMessageDialog(null, "Please enter a name first.", "Error", JOptionPane.ERROR_MESSAGE);	       
			} else if (!name_user_1.equals("")) {
				JOptionPane.showMessageDialog(null, "Welcome to the game of nim, " + name_user_1 + ". How to play: The game starts with 15-30 stones in a pile. \nThe first player will be able to take away 1-3 stones from the pile. The second player will do the same. " + "\nEventually, there will be only one stone left, and the player to pick up the last stone will lose. The CPU will go first.", "How to play the game/rules", JOptionPane.INFORMATION_MESSAGE);
				expertMode_gui_game.setVisible(true);
				gui.setVisible(false);
			}
		}
	}
	public class player_vs_player_event implements ActionListener {
		public void actionPerformed(ActionEvent p_v_p) {
			two_playerMode_gui_game two_playerMode_gui_game = new two_playerMode_gui_game();
				two_playerMode_gui_game.setVisible(true);
				gui.setVisible(false);			
		
	}
}
	
	
			
	public static void main(String args[]) {
		gui.setSize(750,600);
		gui.setTitle("Game of Nim");
		gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
		gui.setVisible(true);
		
	}
}
