package finallogin;
import java.util.Scanner;

public class finallogin {

	static int password_tries = 0;
	static String password = "hello123";
	static String passwordinput;
	public static void main(String[] args) {
			while (passwordinput != password)
			{
				if (password_tries >= 3)
					break;
				
				Scanner reader = new Scanner(System.in);  // Reading from System.in
				System.out.println("Enter the password to continue: ");
				passwordinput = reader.nextLine();
				System.out.println(passwordinput);
				if (passwordinput.equals(password))
				{
					System.out.println("Password correct, welcome!");
					break;
				}
				else {
					System.out.println("Password incorrect, please try again");
					password_tries++;
					continue;
				}
			}
			System.out.println("Thanks for using my software!");

	}

}
