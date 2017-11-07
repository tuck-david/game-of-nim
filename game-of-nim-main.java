import java.util.Scanner;
import java.util.Random;
class game-of-nim-main {
 public static void main(String[] args) {
   Scanner input = new Scanner(System.in);
   Random r = new Random();
System.out.println("Welcome to the game of nim, please enter your name and we will explain the rules");
String name_user_1 = input.nextLine();
System.out.println("Here are the rules," + name_user_1 + ". The rules are...");
System.out.println("Do you want to play against computer our against a second player"); 
