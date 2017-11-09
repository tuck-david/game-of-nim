/*
 * 
 * Programmers: Yannis, David, Andrew, Rohan
 * Date: Nov 7, 2017
 * Description: Game of Nim (Misere) for ICS3U, Unit 3, group assignment
 * 
 */
import java.util.Scanner;
import java.math.*;

class game_of_nim_full {
	
	//defining global variables
	static int max_int = 3; //allows us to change how many tokens can be take each turn
	static int[] comp_turn = new int[2]; //array storing the ExpertAI moves
	static boolean unbeatable_mode = true;
	//static int stones = (int) (Math.random() * 15 + 15); //make comments, make methods for easier code, make program more effecient, look to use the same global variables for similar functions

    public static void main(String[] args) {
	    Scanner input = new Scanner(System.in); //defining scanner class, for user input
	    	    
	    System.out.println("Welcome to the game of nim, please enter your name."); //initial user greeting
	    String name_user_1 = input.nextLine(); //asking user for name, give a more personalized experience
	    System.out.println("Welcome to the game of nim, " + name_user_1 + 
	    		". How to play: The game starts with 15-30 stones in a pile. \nThe first player will be able to take away 1-3 stones from the pile. The second player will do the same. "
	    		+ "\nEventually, there will be only one stone left, and the player to pick up the last stone will lose. \nPress enter to continue."); //explaining rules of the game
	    input.nextLine(); //asking user to enter any value to continue
	    
	    System.out.println("Which mode would like to play? \nPress 1: To play against the beginner AI \nPress 2: To play against the expert AI \nPress 3: To play against a friend."); //game has 3 modes
	    String playmode = input.nextLine(); //getting user input for which game mode they would like to play
	  
	    while (!playmode.equals("1") & !playmode.equals("2") & !playmode.equals("3")) { //checking whether the user has entered a valid input 	
	        System.out.println("The input is invalid. You can only input from 1 to 3. Try again!");
	        playmode = input.nextLine(); //getting user to re-input invalid response until response is valid
	    }
  
		int num_of_stone = (int) (Math.random() * 15 + 15); // generate random number from 15-30
		int stone_left;
		stone_left = num_of_stone;
		
		int stone_taken;
		
		if (playmode.equals ("1")) {// against beginner AI
		System.out.println("You have selected the beginner AI mode. There are currently " + num_of_stone + " in the pile. The CPU will go first.");
		System.out.println("");//add a space for better user experience
		while (stone_left >= 1) {
			
		    if (stone_left < 4) {
		    	    stone_taken = stone_left - 1; // if there are only 3 or less left
		    } else {
		    	    stone_taken = (int) (Math.random() * 3 + 1); // random number from 1-3
		    }
		    
		    stone_left -= stone_taken;;
		    if (stone_left <= 1) {
		       	System.out.println("Congratulation, you win the game!");
			    System.out.println("The computer took " + stone_taken + " stones.");
		        break;
		    }
		    
		    System.out.println("The computer took " + stone_taken + " stones. The number of the stones remaining are: " + stone_left);
		    System.out.println("");//add a space for better user experience
		    System.out.println("Now it is your turn. Please input the number of stone you want to take (1-3)");
		    stone_taken = input.nextInt();
		    
		    while (stone_taken > 3 || stone_taken < 1 || stone_taken > stone_left) {
		        System.out.println("The input is invalid. You can only input from 1 to 3. Try again!");
		        stone_taken = input.nextInt();
		    }
		    if (stone_left <= 3 && stone_left - stone_taken <= 0) {
				System.out.println("You have lost since you took the last stone.");
				break;
			}
		    stone_left -= stone_taken;
		    
		    if (stone_left < 1) {
		    	    System.out.println("Sorry, since you took the last stone, you lost this game");
		        break; // exit the loop
		    }
		    
		    System.out.println("");//add a space for better user experience
		    }

    }

		if (playmode.equals ("2")) {// against expert AI
			int stones = 0;
			
			if (unbeatable_mode == false) {
				stones = (int)(Math.random() * 15 + 15); //getting random integer for the amount of stones 
			} else {
				stones = (int)(Math.random() * 15 + 15); //getting random integer for the amount of stones 
				while (stones == 17 || stones == 21 || stones == 25 || stones == 29) {
					stones = (int)(Math.random() * 15 + 15); //getting random integer for the amount of stones which is not 17,21,25, or 29. 
				}
			}
				  //make int stones a global variable, and make it the same in everybidies code
			int turns_conuter = 0; //counter checking how turns the CPU has taken, this information helps the code determine who is the winner of the game
			int userinput_stones = 0; //variable 
			boolean cpu_win = false; //who wins the game
			boolean user_win = false; 
					 
			while (stones >= 1) {
						 
			    turns_conuter++; //incrementing 1 to CPU turns counter 
			    System.out.println("Currently they are " + stones + " in the pile. The CPU will go now."); //printing number of turns
					 
			    if (turns_conuter <= 1) { //check if it is the first move for the CPU, if it is the first move different calculation will be done to produce a winning move
						 
			        computer_turn(stones); //method providing the 1st move for the CPU
					stones = stones - comp_turn[0]; //subtracting the CPU's move from the pile of stones
					System.out.println("The CPU took " + comp_turn[0] + " stones. There are " + stones + " left in the pile. " + "Now it is your turn, please take 1, 2, or 3 stones.");  //printing this for user's knowledge   
			    } else { //if it is CPU's 2 move or higher then execute this code
						 
				    computer_turn2(userinput_stones); //running method to calculate 2nd move or greater for the CPU
					stones = stones - comp_turn[1]; //subtracting the CPU's move from the pile of stones
				    System.out.println("The CPU took " + comp_turn[1] + " stones. There are " + stones + " left in the pile. " + "Now it is your turn, please take 1, 2, or 3 stones.");
			    }
			    //Checking if the game already ended
			    if (stones <= 1) {
			    	    cpu_win = true;
			        break;
			    }
			    
				userinput_stones = input.nextInt(); //getting user input for amount of stones they would like to take
				
				while (userinput_stones > max_int || userinput_stones <= 0 || userinput_stones > stones) { //checking if user input is valid
				    System.out.println("That is not a valid input, you can only take 1,2,3 stones from the pile. You cannot take 0 stones from the pile.Please input again: ");
					userinput_stones = input.nextInt();
				}
				if (stones <= 3 && stones - userinput_stones <= 0) {
					System.out.println("You have lost since you took the last stone.");
					break;
				}
					 
			    stones = stones - userinput_stones; //subtracting user input from the pile of stones
			    if (stones <= 1) { //checking if the game has ended
			    	    user_win = true;
				    break;
				}
				     
			}
		 

	        if (cpu_win == true) {
	        	    System.out.println(stones + " stone left in the pot. ");
	    	        System.out.print("The expert CPU has won, try again next time.");
	        } else if (user_win == true) {
        	        System.out.println(stones + " stone left in the pot. ");
	    	        System.out.print("Congratulations, you have beat the expert CPU. You are a legend.");
	        }
	 	 
    }
  
			if (playmode.equals ("3")) { //playing with 2 users locally
			    int stones = (int)(Math.random() * 15 + 15); //generating random number of stones
			    
			    System.out.println("You have selected the 2 player mode. Please enter the names of Player 1 and then Player 2: ");
			    String user_name_1 = input.nextLine();
			    String user_name_2 = input.nextLine();
			    
			    System.out.println(user_name_1 + " will go first, then " + user_name_2 + " will go.");
			    boolean user1Win = false; //who wins the game
		        boolean user2Win = false; 
	  
			while(stones >= 1) {
							  
				System.out.println("There are currently " + stones + " stones in the pile. " + user_name_1 +", choose how many you would like to take. (Minimum = 1 Maximum = 3)");
				int user_1_input = input.nextInt();
				
				while (user_1_input > 3 || user_1_input <= 0 || user_1_input > stones) {
				System.out.println("That is not a valid input, you can only take 1,2,3 stones from the pile. You cannot take 0 stones from the pile. Please input again: ");
				user_1_input = input.nextInt();
				}
				if (stones <= 3 && stones - user_1_input <= 0) {
					System.out.println(user_name_1 + " you lost since you took the last stone. Congratulations, " + user_name_2 + " you have won!");
					break;
				}
				stones = stones - user_1_input;
				  
				if (stones <= 1) {
					user1Win = true;
					break;
				}
				  
				System.out.println("There are currently " + stones + " stones in the pile. " + user_name_2 +", choose how many you would like to take. (Minimum = 1 Maximum = 3)");
				int user_2_input = input.nextInt();
				
				while (user_2_input > 3 || user_2_input <= 0 || user_2_input > stones) {
					System.out.println("That is not a valid input, you can only take 1,2,3 stones from the pile. You cannot take 0 stones from the pile. Please input again: ");
					user_2_input = input.nextInt();
				}
				if (stones <= 3 && stones - user_1_input <= 0) {
					System.out.println(user_name_1 + " you lost since you took the last stone. Congratulations, " + user_name_2 + " you have won!");
					break;
				}
				stones = stones - user_2_input;
				
				if (stones <= 1) {
					user2Win = true;
					break;
				    }
		        }
	  
			    if (user1Win == true) {
				    System.out.println("There are " + stones + " stones in the pot.");
			 	    System.out.println("Congratulations, " + user_name_1 + " you have beat " + user_name_2 + ".");
			    } else if (user2Win == true) {
				    System.out.println("There are " + stones + " stones in the pot.");
			 	    System.out.println("Congratulations, " + user_name_2 + " you have beat " + user_name_1 + ".");
			    }
	
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
