import java.util.Scanner;
import java.math.*;

public class expertAI3 {
	
	//defining global variables
	 static int max_int = 3;
	 static int[] comp_turn = new int[2];

 public static void main(String args[]) {
	 
	 int stones = (int)(Math.random() * 14 + 15);

	 Scanner scanner = new Scanner(System.in); 
	 
	 System.out.println("Welcome to the game of nim, please enter your name and we will explain the rules");
	 String name_user_1 = scanner.nextLine();
	 System.out.println("Here are the rules, " + name_user_1 + ". The rules are...");
	 int cpu_turns_conuter = 0;
	 int user_turns_counter = 0;
	 int userinput_stones = 0;
	 
	 while (stones >= 1) {
		 
	     cpu_turns_conuter++;
	     System.out.println("Currently they are " + stones + " in the pile. The CPU will go now.");
	 
	     if (cpu_turns_conuter <= 1) {
		 
	         computer_turn(stones);
	         stones = stones - comp_turn[0];
	         System.out.println("The CPU took " + comp_turn[0] + " stones. There are " + stones + " left in the pile. " + "Now it is your turn, please take 1, 2, or 3 stones.");     
	     } 
	 
	     else {
		 
		     computer_turn2(userinput_stones);
		     stones = stones - comp_turn[1];
		     System.out.println("The CPU took " + comp_turn[1] + " stones. There are " + stones + " left in the pile. " + "Now it is your turn, please take 1, 2, or 3 stones.");
	     }
	     //Checking if the game already ended
	     if (stones <= 1) {
		     break;
	     }
	     user_turns_counter++;
	     userinput_stones = scanner.nextInt();
	     while (userinput_stones > max_int || userinput_stones <= 0) {
		     System.out.println("That is not a valid input, you can only take 1,2,3 stones from the pile. You cannot take 0 stones from the pile.Please input again: ");
		     userinput_stones = scanner.nextInt();
	     }
	 
	     stones = stones - userinput_stones;
	     if (stones <= 1) {
		     break;
	     }
     
	 }
	 

     if (user_turns_counter >= cpu_turns_conuter) { 
    	     System.out.println("There are " + stones + " stones in the pot.");
    	     System.out.println("Congratulations, you have beat the expert CPU. You are a legend.");
    	     
    	 } 
     else if (user_turns_counter < cpu_turns_conuter) {
	     System.out.println("There are " + stones + " stones in the pot.");
    	     System.out.println("The expert CPU has won, try again next time.");
    	     
     }
 
 
 }
 
 public static int computer_turn(int size_of_heap) {
	 
	 int size_of_heap_adjusted_misere = size_of_heap-1;
	 
	 comp_turn[0] = size_of_heap_adjusted_misere%(max_int+1);
	 
	 if (comp_turn[0] == 0) {
		 
		 comp_turn[0] = (int)(Math.random() * 2 + 1);;
	 }
	 
	 return comp_turn[0];
 }
 
 public static int computer_turn2(int userinput_stones) {
	 
	 comp_turn[1] = (max_int + 1) - userinput_stones;
	 
	 return comp_turn[1];
 }
 
 

}