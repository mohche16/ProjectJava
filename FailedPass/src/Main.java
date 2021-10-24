import java.util.Scanner;

public class Main {
	 public static void main(String []args) {
		 Scanner reader = new Scanner(System.in);  // Reading from System.in
		 int numGuesses = 0;
		 while (true)
		 {
			 System.out.println("Enter password to enter: \n");
			 String password = reader.next(); // Scans the next token of the input as an int.
			 numGuesses++;
			 //once finished
			 if (password.equals("mcnugget"))
			 {
				 System.out.println("Congratulations you have guessed the password");
				 break;
			 }
			 if (numGuesses == 3)  {
				 System.out.println("You have failed guessing the password, try restarting the app and retry!");
				 break;
			 }
			 System.out.println("Wrong password!");
		 }
	   }
	 
}
