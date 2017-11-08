/*
 * programmer: Yannis, David, Andrew, Rohan
 * Date: Nov 7, 2017
 * Description: Game of Nim for ICS3U, Unit 3, group assignment
 */
import java.util.Scanner;

class GameofNim {

 public static void main(String[] args) {
  Scanner input = new Scanner(System.in);
  System.out.println("Welcome to the game of nim, please enter your name and we will explain the rules");
  String name_user_1 = input.nextLine();
  System.out.println("Here are the rules," + name_user_1
    + ". The game starts with 15-30 stones. The first player will be able to pick up 1-3 stones. The second player will do the same. Eventually, there will be only one stone left, and the player to pick the last one up will lose. Enter any thing to continue.");
  input.nextLine();
  System.out.println(
    "Would you like to play against AI or against a friend locally? Press 1 for against beginner AI, 2 for expert AI, or 3 to play against a friend.");
  int playmode;
  playmode = input.nextInt();
  int num_of_stone;
  int stone_left;
  num_of_stone = (int) (Math.random() * 15 + 15); // generate random number from 15-30
  stone_left = num_of_stone;
  int counter = 0;
  int stone_took;

  if (playmode == 1) // against beginner AI
  {
   System.out.println("Welcome to the beginner AI mode. We have " + num_of_stone + " this turn. The AI went first.");
   System.out.println("");//add a space for better user experience
   while (stone_left >= 1) {
    if (stone_left < 4) {
     stone_took = stone_left - 1; // if there are only 3 or less left
    } else {
     stone_took = (int) (Math.random() * 3 + 1); // random number from 1-3
    }
    stone_left -=stone_took;;
    if (stone_left <= 1) {
     System.out.println("Congratulation, you win the game!");
     break; // exit the loop
    }
    System.out.println("The AI took " + stone_took + " The number of the stones left are "
      + stone_left);
    System.out.println("");//add a space for better user experience
    System.out.println("Now it is your turn. Please input the number of stone you want to take (1-3)");
    stone_took = input.nextInt();
    while (stone_took >3 ||(stone_took <1 )
    {
    System.out.println("The input is invalid. You can only input from 1 to 3. Try again!");
    stone_took = input.nextInt();
    }
    stone_left -=stone_took;
    if (stone_left < 1) {
     System.out.println("Sorry, since you took the last stone, you lost this game");
     break;
    }
    System.out.println("You took " + stone_took + " The number of the stones left are " + stone_left);
    System.out.println("");//add a space for better user experience
   }

  }
 }
}
