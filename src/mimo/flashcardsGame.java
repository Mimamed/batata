package mimo;

import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mimo.tabMeny.lessonButton;
import mimo.tabMeny.flashcardButton;
import mimo.tabMeny.readingButton;
import mimo.spelFlashkort.knapp1;
import mimo.spelFlashkort.knapp2;
import mimo.spelFlashkort.knapp3;
import mimo.spelFlashkort.knapp4;
import mimo.spelFlashkort.knapp5;
import mimo.spelFlashkort.knapp7;
import mimo.tabMeny.button;
import mimo.tabMeny.menyButton;

import java.util.List;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class flashcardsGame extends JPanel {
	static Scanner scan = new Scanner(System.in);
	static List<WordListClass> words = new ArrayList<WordListClass>();
	
//static List<String>[] allText = {new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>()};
	static BufferedImage pic;
	static JButton lessonButton = new JButton(), flashcardButton = new JButton(), readingButton = new JButton(), listeningButton = new JButton(), menyButton = new JButton(), answerButton = new JButton(), exampleButton = new JButton();
	static JLabel word = new JLabel(), meaning = new JLabel(), example = new JLabel();
	
	flashcardsGame() {
		try
		{
			pic = ImageIO.read(start.filer[3]);
		}catch (Exception e)
		{
			System.out.print("fel men uppladning");
		}
		
		this.setLayout(null);
		
		//Sätter in alla componenter
		this.add(lessonButton);
		this.add(flashcardButton);
		this.add(readingButton);
		this.add(listeningButton);
		this.add(menyButton);
		this.add(exampleButton);
		this.add(answerButton);
		this.add(word);
		this.add(example);
		this.add(meaning);
		
		//Fixar kanpparna nedan
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
		
		listeningButton.setBounds((int) Math.round(963 * start.widthSize), (int) Math.round(12 * start.heightSize), (int) Math.round(278 * start.widthSize), (int) Math.round(76 * start.heightSize));
		listeningButton.addActionListener(new knapp4());
		listeningButton.setContentAreaFilled(false);
		listeningButton.setBorderPainted(false);
		listeningButton.setFocusPainted(false);
		listeningButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		listeningButton.setText("Listening");
		
		menyButton.setBounds((int) Math.round(10 * start.widthSize), (int) Math.round(10 * start.heightSize), (int) Math.round(80 * start.widthSize), (int) Math.round(80 * start.heightSize));
		menyButton.addActionListener(new knapp5());
		menyButton.setContentAreaFilled(false);
		menyButton.setBorderPainted(false);
		menyButton.setFocusPainted(false);
		
		exampleButton.setBounds((int) Math.round(537 * start.widthSize), (int) Math.round(385 * start.heightSize), (int) Math.round(293 * start.widthSize), (int) Math.round(105 * start.heightSize));
		exampleButton.addActionListener(new knapp6());
		exampleButton.setContentAreaFilled(start.synligaKnappar);
		exampleButton.setFocusPainted(start.synligaKnappar);
		exampleButton.setForeground(new Color(140, 198, 58));
		exampleButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		exampleButton.setText("Show example");
		
		answerButton.setBounds((int) Math.round(537 * start.widthSize), (int) Math.round(247 * start.heightSize), (int) Math.round(294 * start.widthSize), (int) Math.round(105 * start.heightSize));
		answerButton.addActionListener(new knapp7());
		answerButton.setContentAreaFilled(start.synligaKnappar);
		answerButton.setFocusPainted(start.synligaKnappar);
		answerButton.setForeground(new Color(140, 198, 58));
		answerButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		answerButton.setText("Show meaning");
		
		
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
	
	static class knapp6 implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
		}
	}

	static class knapp7 implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
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
