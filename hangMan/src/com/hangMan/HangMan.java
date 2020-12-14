package com.hangMan;

import java.util.Scanner;
import java.util.Random;
import java.lang.*;

public class HangMan {
	//Max antal gissningar (funkar bara dock med 7 atm pga bilden som ritas..)
	private static int maxGuessCount = 7;
	//Nuvarande antal gissningar
	private static int guessCount = 0;
	//Ordet som ska gissas
	private static String wordToGuess = "test";
	//Skapar ny variabel och ersätter ordet i "wordtoguess" med *
	private static String wordAsterisk = new String(new char[wordToGuess.length()]).replace("\0", "*");
	
	//Funktionen kollar bokstav / hela ordet och gör actions som t.ex incrementa guesscount.
	//Funktionen returnerar även true om ordet har gissats
	public static boolean checkWord(String guessedword)
	{
		//Om det är hela ordet och inte bara en bokstav
		if (guessedword.length() >= 2)
		{
			//Kolla om ordet användaren gissa på matchar ordet vi har lagt in.
			if (guessedword.equals(wordToGuess))
			{
				System.out.println("Correct! You win! The word was " + wordToGuess);
				//returnera true / avsluta programmet
				return true;
			}
		}
		//om ordet är endast en bokstav
		else
		{
				//temp variabel som vi arbetar med endast i denna funktionen
				String temp = "";
				for (int i = 0; i < wordToGuess.length(); i++) {
					//om bokstaven vi skrev in hittas någonstans i ordet som ska gissas
				if (wordToGuess.charAt(i) == guessedword.charAt(0)) {
					//lägg till bokstaven i vår temp variabel
					temp += guessedword.charAt(0);
				} 	
				//om indexen inte är en * / redan gissats
				else if (wordAsterisk.charAt(i) != '*') {
				temp += wordToGuess.charAt(i);
				} else {
				temp += "*";
				}
			}

			//om ordet fortfarande inte gissats
			if (wordAsterisk.equals(temp)) {
				guessCount++;
				Hang();
			} else {
				wordAsterisk = temp;
			}
			//alla * har ersätts med bokstaver och ordet är nu färdigt
			if (wordAsterisk.equals(wordToGuess)) {
				System.out.println("Correct! You win! The word was " + wordToGuess);
			}
		}
		//alla våra gissningar är över därför returnerar vi true och programmet avslutas.
		if (guessCount >= maxGuessCount)
			return true;
		return false;
	}
			
			
	public static void displayHangManMenu() {
		System.out.printf("- Game status: Guesses: %d | Remaining: %d\n", guessCount, (maxGuessCount - guessCount));
		System.out.printf("- Guess any letter in the word: %s\n", wordAsterisk);
		System.out.println("- Enter char to guess char");
		System.out.println("- Enter word to guess word");
		System.out.println("- [3] Choose word to guess: ");
		
	}
	
	//Funktion som använder guessCount för att rita ut hänggubben.
	public static void Hang()
	{
		switch(guessCount)
		{
			case 1:
				System.out.println("/|\\");
				break;
		  case 2:
			  	System.out.println(" |");
		    	System.out.println("/|\\");
		    	break;
		  case 3:
			  System.out.println(" |");
			  System.out.println(" |");
			  System.out.println("/|\\");
			  break;
		  case 4:
			  System.out.println(" |");
			  System.out.println(" |");
			  System.out.println(" |");
			  System.out.println("/|\\");
			  break;
		  case 5:
			  System.out.println(" |");
			  System.out.println(" |");
			  System.out.println(" |");
			  System.out.println(" |");
			  System.out.println("/|\\");
			  break;
		  case 6:
			  System.out.println("  ____");
			  System.out.println(" |");
			  System.out.println(" |");
			  System.out.println(" |");
			  System.out.println(" |");
			  System.out.println("/|\\");
			  break;
		  case 7:
			  System.out.println("  ____");
			  System.out.println(" |    |");
			  System.out.println(" |    o");
			  System.out.println(" |   /|\\");
			  System.out.println(" |   /\\");
			  System.out.println("/|\\");
			  System.out.println("GAME OVER! ordet va " + wordToGuess);
			  break;
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		//Så länge våra gissningar inte är över 7 och ordet fortfarande inte gissats
		while (guessCount <= maxGuessCount && wordAsterisk.contains("*"))
		{
			//rita main menu
			displayHangManMenu();
			String guess = sc.next();
			//Menyval 3 för att byta ordet / välja ord
			if (guess.equals("3"))
			{
				System.out.println("Enter new word");
				String newWord = sc.next();
				wordToGuess = newWord;
				wordAsterisk = new String(new char[wordToGuess.length()]).replace("\0", "*");
				System.out.printf("Word set to %s\n", newWord);
				continue;
			}
			
			//om funktionen returnerar true så har användaren gissat färdigt
			if (checkWord(guess))
				break;
		}
		sc.close();

	}

}
