import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.math.*;

/*
 * 
 * Programmers: Yannis, David, Andrew, Rohan
 * Date: Nov 7, 2017
 * Description: Game of Nim (Misere) for ICS3U, Unit 3, group assignment
 * 
 */
public class gui extends JFrame implements ActionListener {
 JPanel pan1 = new JPanel();
 JButton pVp = new JButton("Player vs Player?");
 JButton pVEc = new JButton("Player vs Expert Computer?");
 JButton pVBc = new JButton("Player vs Beginner Computer?");

 JButton takeOne = new JButton("Take one stone");
 JButton takeTwo = new JButton("Take two stones");
 JButton takeThree = new JButton("Take three stones");
 JButton quit = new JButton("QUIT");
 JLabel welcome = new JLabel("Welcome to the game of nim, please enter your name.");
 JLabel rules = new JLabel(
   "Welcome to the game of nim, "
     //+ name_user_1
     + ". How to play: The game starts with 15-30 stones in a pile. \nThe first player will be able to take away 1-3 stones from the pile. The second player will do the same. "
     + "\nEventually, there will be only one stone left, and the player to pick up the last stone will lose. \nPress enter to continue.");
 JLabel askmode = new JLabel("what mode");
 boolean setUp = true;
 String playmode;

 public gui() {
  setTitle("Game of Nim");
  setSize(800, 500);
  setVisible(true);

 setLayout(new BorderLayout());

  if (setUp == true) {
   add(pVp,BorderLayout.LINE_START);
   add(pVEc,BorderLayout.CENTER);
   add(pVBc,BorderLayout.LINE_END);
   setVisible(true);
  } else if (setUp == false) {
   add(takeOne);
   add(takeTwo);
   add(takeThree);
   setVisible(true);
  }

  quit.addActionListener(this);
  takeOne.addActionListener(this);
  takeTwo.addActionListener(this);
  takeThree.addActionListener(this);
  pVp.addActionListener(this);
  pVEc.addActionListener(this);
  pVBc.addActionListener(this);

 }

 public static void main(String[] args) {
  gui frame1 = new gui();

  
 }

 public void actionPerformed(ActionEvent event) {
  String command = event.getActionCommand();
  if (command.equals("QUIT")) {
   System.out.println("quit button pressed");
  }
  if (command.equals("Take one stone")) {
   System.out.println("take one button pressed");
  }
  if (command.equals("Take two stones")) {
   System.out.println("take two button pressed");
  }
  if (command.equals("Take three stones")) {
   System.out.println("take three button pressed");

  }
  if (command.equals("Player vs Player?")) {
   System.out.println("Player vs Player? button pressed");
   setUp = false;
   //playmode=("3");
  }
  if (command.equals("Player vs Expert Computer?")) {
   System.out.println("Player vs Expert Computer? button pressed");
   setUp = false;
   //playmode=("2");
  }
  if (command.equals("Player vs Beginner Computer?")) {
   System.out.println("Player vs Beginner Computer? button pressed");
   setUp = false;
   //playmode=("1");
  }
 }
}
