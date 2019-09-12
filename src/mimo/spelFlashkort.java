package mimo;
//DETTA ÄR BARA FÖR SJÄLVASTE KODEN, INTE FÖNSTRET

import java.util.Scanner;

import javax.swing.JPanel;

import java.util.List;
import java.util.ArrayList;

public class spelFlashkort extends JPanel {
	//SKAPA LISTA, DATUM | ORD | SVÅRIGHET
	static Scanner scan = new Scanner(System.in);
	static List<WordListClass> words = new ArrayList<WordListClass>();
	
	
	spelFlashkort() {
		boolean menuLoop = true;
		WordListClass word = new WordListClass("Du", "You (singular)", 3);
		words.add(words.size(), word);
		
		//startmeny
		while(menuLoop) {
			showMenu();
			String answer = scan.next();
			
			switch(answer) {
				case "1":
				playFlashcards();
				break;
			
				case "2":
				showWordList();
				break;
				
				case "3":
				System.out.println("Leaving flashcards, byebye.");
				menuLoop = false;
				break;
				
				default:
				System.out.println("Enter a single integer from 1 to 3.");
				break;
			}
		}
	}
	
	public static void showMenu() {
		System.out.println("Welcome to the flashcard section");
		System.out.println("You have 'x' words left that need practice");
		System.out.println("1. Start practice");
		System.out.println("2. Wordlist");
		System.out.println("3. Quit");
	}
	
	public static void showWordList() {
		if (words.size() == 0) {
            System.out.println("No words saved, save some dude.");
            System.out.println("---");
        }
		else {
            for (int i = 0; i < words.size(); i++) {
                System.out.println("Word " + (i + 1) + ":");
                System.out.println("Word: " + words.get(i).getTerm());
                System.out.println("Translation: " + words.get(i).getTranslation());
                System.out.println("Difficulty: " + words.get(i).getDifficulty() + "/5");
                System.out.println("Time saved: oops...");
                System.out.println("---");
            }
        }
	}
	public static void playFlashcards() {
		/*
		algoritm
		kollar främst efter svårighetsgrad
		
		*/
		System.out.println("Word: " + words.get(0).getTerm());
		System.out.println("1. Show translation");
		System.out.println("2. Show example");
		System.out.println("3. Set how well you remember the word from 0 - 5 \n0: no memory at all | 5: remember clearly");
		
		String answer = scan.next();
		switch(answer) {
			case "1":
			System.out.println("Translation: " + words.get(0).getTranslation());
			break;
			
			case "2":
			System.out.println("NO EXAMPLES AVAILABLE");
			break;
			
			case "3":
			System.out.println("No. \nIt shall remain 0");
			break;
			
			default:
			System.out.println("Enter a single integer from 1 to 3.");
			break;
		}
		
		
		//if (wordNeedPractice) {
		System.out.println("No words to practice, come back later \n");
		//}
	}
}

class WordListClass {
	/* private X date; */
	private String term;
	private String translation;
	private int difficulty;
	
	public WordListClass(/*X date,*/ String term, String translation, int difficulty) {
		//this.date = date;
		this.term = term;
		this.translation = translation;
		this.difficulty = difficulty;
	}
	
	/*public void setDate(X date) {
		this.date = date;
	}*/
	
	public void setTerm(String term) {
		this.term = term;
	}
	
	public void setTranslation(String translation) {
		this.translation = translation;
	}
	
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	
	//public X getDate() { return date; }
	
	public String getTerm() { return term; }
	
	public String getTranslation() { return translation; }
	
	public int getDifficulty() { return difficulty; }
}
