package mimo;
//DETTA ÄR BARA FÖR SJÄLVASTE KODEN, INTE FÖNSTRET

import java.util.Scanner;

public class spelFlashkort {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String args[]) {
		boolean menyLoop = true;
		
		//startmeny
		while(menyLoop) {
			System.out.println("Welcome to the flashcard section");
			System.out.println("You have 'x' words left that need practice");
			System.out.println("1. Start practice");
			System.out.println("2. Wordlist");
			System.out.println("3. Quit");
			String svar = scan.next();
			
			switch(svar) {
				case "1":
				System.out.println("No words to practice, come back later");
				break;
			
				case "2":
				System.out.println("No words saved, save some dude.");
				break;
				
				case "3":
				System.out.println("Leaving flashcards, byebye.");
				menyLoop = false;
				break;
				
				default:
				System.out.println("Enter a single integer from 1 to 3.");
				break;
			}
		}
	}
}
