package com.stenSax;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays; 

public class StenSax {

	//Array med alla möjliga val
	static String[] choices = {"sten", "sax", "påse"};

	//Array som håller spelarnas namn
	static String[] Players = {"Player1", "Player2"};
	//variablar som användaren skriver in
	static String Player1Input = "";
	static String Player2Input = "";
	
	//Val som görs t.ex sten, sax, påse
	static String Player1Choice;
	static String Player2Choice;
	
	//Score för båda spelarena
	static int Player1Score;
	static int Player2Score;
	static Scanner reader = new Scanner(System.in);  // Reading from System.in
	
	
	//Funktionen körs när PVP mode är enabled och gör så att varje spelare kan skriva in sitt namn
	public static void getPlayerNamesFromInput()
	{
		System.out.println("Player1 name: ");
		Player1Input = reader.nextLine();
		System.out.println("Player2 name: ");
		Player2Input = reader.nextLine();
		if (!Player1Input.equals(""))
			Players[0] = Player1Input;
		if (!Player2Input.equals(""))
			Players[1] = Player2Input;
	}
	
	//if satser som ger score beroende på conditions.
	public static void GetRoundWinner()
	{
		if (Player1Choice.equals("sten") && Player2Choice.equals("sax"))
			Player1Score++;
		if (Player1Choice.equals("sax") && Player2Choice.equals("sten"))
			Player2Score++;
		if (Player1Choice.equals("sax") && Player2Choice.equals("påse"))
			Player1Score++;
		if (Player1Choice.equals("påse") && Player2Choice.equals("sax"))
			Player2Score++;
		if (Player1Choice.equals("påse") && Player2Choice.equals("sten"))
			Player1Score++;
		if (Player1Choice.equals("sten") && Player2Choice.equals("påse"))
			Player2Score++;
		if (Player1Choice.equals("sten") && Player2Choice.equals("sten"))
		{
			Player1Score++;
			Player2Score++;
		}
		if (Player1Choice.equals("sax") && Player2Choice.equals("sax"))
		{
			Player1Score++;
			Player2Score++;
		}
		if (Player1Choice.equals("påse") && Player2Choice.equals("påse"))
		{
			Player1Score++;
			Player2Score++;
		}
		System.out.println(Players[0] + ": " + Player1Score + " " + Players[1] + ": " + Player2Score);
	}
	
	//Hämta input från användare1(alltid spelare)
	public static void GetPlayer1ChoiceInput() throws InterruptedException {
		System.out.println(Players[0] + " enter a value sten, sax, påse or 1, 2, 3 for their respective values ");
		Player1Choice = reader.nextLine();
		//Om variabeln finns i vår array då är det en valid command t.ex sten, sax eller påse
		boolean containsChoice = Arrays.asList(choices).contains(Player1Choice);
		if (!containsChoice)
		{
			//Om den inte finns så kollar vi om det är ett nummer istället
			int PlayerChoiceInt = Integer.parseInt(Player1Choice);
			if (PlayerChoiceInt >= choices.length)
			{
				System.out.println("You have entered an invalid choice please retry");
				TimeUnit.SECONDS.sleep(3);
			}
			else
			{
				//Hämta sten / sax / påse med hjälp av index
				Player1Choice = choices[PlayerChoiceInt];
			}
				
		}
	}
	
	//Val för spelare2 som kan bland annat vara Ai ( denna funktionen används ej för Ai)
	public static void GetPlayer2ChoiceInput() throws InterruptedException {
		System.out.println(Players[1] + " enter a value sten, sax, påse or 1, 2, 3 for their respective values ");
		Player2Choice = reader.nextLine();
		boolean containsChoice = Arrays.asList(choices).contains(Player2Choice);
		if (!containsChoice)
		{
			int PlayerChoiceInt = Integer.parseInt(Player2Choice);
			if (PlayerChoiceInt >= choices.length)
			{
				System.out.println("You have entered an invalid choice please retry");
				TimeUnit.SECONDS.sleep(3);
			}
			else
			{
				Player2Choice = choices[PlayerChoiceInt];
				
			}
		}
	}
	public static void StartGame() throws InterruptedException
	{
		//Random spelare som börjar varje ny match
		int startingPlayer = ThreadLocalRandom.current().nextInt(0, 2);
		while (Player1Score < 3 && Player2Score < 3)
		{
			if (startingPlayer == 0)
			{
				GetPlayer1ChoiceInput();
				GetPlayer2ChoiceInput();
				startingPlayer = 1;
				GetRoundWinner();
				continue;
			}
			
			if (startingPlayer == 1)
			{
				GetPlayer2ChoiceInput();
				GetPlayer1ChoiceInput();
				startingPlayer = 0;
				GetRoundWinner();
				continue;
			}
			
			
		}
		System.out.println("We have a winner!");
		System.out.println(Players[0] + " " + Player1Score);
		System.out.println(Players[1] + " " + Player2Score);
		
	}
	
	//Random choice från arrayen (choices) med hjälp av random integers)
	public static void MakeAiChoice() {
		Player2Choice = choices[ThreadLocalRandom.current().nextInt(0, choices.length - 1)];
		System.out.println("Ai chooses: " + Player2Choice);
	}
	
	//Samma som start game, men MakeAiChoice() används istället för att en användare ska ge valen
	public static void StartAiGame() throws InterruptedException {
		int startingPlayer = ThreadLocalRandom.current().nextInt(0, 2);
		while (Player1Score < 3 && Player2Score < 3)
		{
			if (startingPlayer == 0)
			{
				GetPlayer1ChoiceInput();
				MakeAiChoice();
				startingPlayer = 1;
				GetRoundWinner();
				continue;
			}
			
			if (startingPlayer == 1)
			{
				MakeAiChoice();
				GetPlayer1ChoiceInput();
				startingPlayer = 0;
				GetRoundWinner();
				continue;
			}
			
			
		}
		System.out.println("We have a winner!");
		System.out.println(Players[0] + " " + Player1Score);
		System.out.println("StenSax Ai " + Player2Score);
	}
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Welcome to StenSax Java, best of 3 is the winner, follow the instructions to start playing!");
		System.out.println("Enter 0 for Ai and 1 for PVP!");
		int gamemode = Integer.parseInt(reader.nextLine());
		if (gamemode == 0)
		{
			System.out.println("Player1 name: ");
			Player1Input = reader.nextLine();
			if (!Player1Input.equals(""))
				Players[0] = Player1Input;
			StartAiGame();
		}
		if (gamemode == 1)
		{
			getPlayerNamesFromInput();
			System.out.println("Welcome " + Players[0] + " and " + Players[1]);
			StartGame();
		}
		
		
		
		
	}
}