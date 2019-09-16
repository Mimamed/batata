package mimo;
//DETTA ÄR BARA FÖR SJÄLVASTE KODEN, INTE FÖNSTRET

import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import mimo.spelMenu.knapp1;
import mimo.spelMenu.knapp2;
import mimo.spelMenu.knapp3;
import mimo.spelMenu.knapp4;
import mimo.spelMenu.knapp5;

import java.util.List;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class spelFlashkort extends JPanel {
	//SKAPA LISTA, DATUM | ORD | ÖVERSÄTTNING | SVÅRIGHET
	static Scanner scan = new Scanner(System.in);
	static List<WordListClass> words = new ArrayList<WordListClass>();
	static BufferedImage pic;
	static JButton lessonButton = new JButton(), flashcardButton = new JButton(), readingButton = new JButton(), Button = new JButton(), menyButton = new JButton();
	
	
	spelFlashkort() 
	{
		
		try
		{
			pic = ImageIO.read(start.filer[2]);
		}catch (Exception e)
		{
			System.out.print("fel men uppladning");
		}
		
		this.setLayout(null);
		
		//addar grejer
		
		this.add(lessonButton);
		this.add(flashcardButton);
		this.add(readingButton);
		this.add(Button);
		this.add(menyButton);
		
		//sätter upp knapparna
		
		lessonButton.setBounds((int) Math.round(127 * start.widthSize), (int) Math.round(12 * start.heightSize), (int) Math.round(278 * start.widthSize), (int) Math.round(76 * start.heightSize));
		lessonButton.addActionListener(new knapp1());
		lessonButton.setContentAreaFilled(false);
		lessonButton.setBorderPainted(false);
		lessonButton.setFocusPainted(false);
		lessonButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		lessonButton.setText("Lessons");
		
		//SKA HA RÖD BAKGRUND, LISTA UT SENARE.
		flashcardButton.setBounds((int) Math.round(406 * start.widthSize), (int) Math.round(12 * start.heightSize), (int) Math.round(278 * start.widthSize), (int) Math.round(76 * start.heightSize));
		flashcardButton.addActionListener(new knapp2());
		flashcardButton.setContentAreaFilled(false);
		flashcardButton.setBorderPainted(false);
		flashcardButton.setFocusPainted(false);
		flashcardButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		flashcardButton.setText("Flashcards");
		
		readingButton.setBounds((int) Math.round(685 * start.widthSize), (int) Math.round(12 * start.heightSize), (int) Math.round(278 * start.widthSize), (int) Math.round(76 * start.heightSize));
		readingButton.addActionListener(new knapp3());
		readingButton.setContentAreaFilled(false);
		readingButton.setBorderPainted(false);
		readingButton.setFocusPainted(false);
		readingButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		readingButton.setText("Reading");
		
		Button.setBounds((int) Math.round(963 * start.widthSize), (int) Math.round(12 * start.heightSize), (int) Math.round(278 * start.widthSize), (int) Math.round(76 * start.heightSize));
		Button.addActionListener(new knapp4());
		Button.setContentAreaFilled(false);
		Button.setBorderPainted(false);
		Button.setFocusPainted(false);
		Button.setFont(new Font("comic sans ms", Font.BOLD, 30));
		Button.setText("???");
		
		menyButton.setBounds((int) Math.round(10 * start.widthSize), (int) Math.round(10 * start.heightSize), (int) Math.round(80 * start.widthSize), (int) Math.round(80 * start.heightSize));
		menyButton.addActionListener(new knapp5());
		menyButton.setContentAreaFilled(false);
		menyButton.setBorderPainted(false);
		menyButton.setFocusPainted(false);
		
		/*
		boolean menuLoop = true;
		WordListClass word = new WordListClass("Du", "You (singular)", 3);
		words.add(words.size(), word);
		
		//startmeny
		while(menuLoop) {//loopen ska ersättas med riktiga knappar och actionlisteners men även paneler!
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
		*/
	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(pic, 0, 0, this.getWidth(), this.getHeight(), null);
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
		
		static class knapp1 implements ActionListener
		{
			
			public void actionPerformed(ActionEvent e)
			{
			}
		}
		
		static class knapp2 implements ActionListener
		{
			
			public void actionPerformed(ActionEvent e)
			{
				start.Byta(start.flashkort);
			}
		}
		
		static class knapp3 implements ActionListener
		{
			
			public void actionPerformed(ActionEvent e)
			{
				
			}
		}

		static class knapp4 implements ActionListener
		{
			
			public void actionPerformed(ActionEvent e)
			{
			}
		}

		static class knapp5 implements ActionListener
		{
			
			public void actionPerformed(ActionEvent e)
			{
				start.Byta(start.meny);
			}
		}
		
		public static void playFlashcards() {
		/*
		algoritm
		kollar främst efter svårighetsgrad
		
		*/
		//Random rand = new Random();
		//en variabel som ser till att index, osv är alla = rand.nextInt(words.length)
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
			//man skriver in nummer 0-5
			//words.get(INDEXET).setDifficulty(noll till fem);
			
			//om man skriver in annat, bör loopas tills rätt nummer eller avbrytning
			System.out.println("No. \nIt shall remain [ORIGINAL NUMBER]");
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