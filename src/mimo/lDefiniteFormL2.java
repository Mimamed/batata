package mimo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class lDefiniteFormL2 extends JPanel {
	static BufferedImage bakgrund;
	static JButton lessonButton = new JButton(), flashcardButton = new JButton(), readingButton = new JButton(), menyButton = new JButton(), answerButton = new JButton();
	static JTextArea textArea = new JTextArea();
	static JTextField answerField = new JTextField(), correctAnswerField = new JTextField(), answersFraction = new JTextField();
	static List<SentenceList> lessonSentences = new ArrayList();
	static ArrayList<String> possibleTranslations = new ArrayList<String>();
	public static int whichSentence;
	static Random randomNumber = new Random();
	static int sentenceNumber;
	static int sentencesLeft = 0;
	static boolean lDefiniteFormL2Done = false;
	static int sentencesCorrect = 0;
	
	lDefiniteFormL2()
	{
		try
		{
			bakgrund = ImageIO.read(start.filer[10]);
		}catch(Exception e)
		{
			System.out.print("fel men uppladning0");
		}
		
		this.setLayout(null);
		
		//addar grejer
		
		setupSentences();
		possibleTranslations.add("I am home");
		possibleTranslations.add("We are home");
		
		this.add(lessonButton);
		this.add(flashcardButton);
		this.add(readingButton);
		this.add(menyButton);
		this.add(textArea);
		this.add(answerField);
		this.add(answerButton);
		this.add(correctAnswerField);
		this.add(answersFraction);
		
		//sätter upp knapparna
		
		lessonButton.setBounds((int) Math.round(127 * start.widthSize), (int) Math.round(12 * start.heightSize), (int) Math.round(371 * start.widthSize), (int) Math.round(76 * start.heightSize));
		//lessonButton.addActionListener(new lessonButton());
		lessonButton.setContentAreaFilled(start.synligaKnappar);
		lessonButton.setBorderPainted(start.synligaKnappar);
		lessonButton.setFocusPainted(start.synligaKnappar);
		lessonButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		lessonButton.setText("Lessons");

		flashcardButton.setBounds((int) Math.round(499 * start.widthSize), (int) Math.round(12 * start.heightSize), (int) Math.round(370 * start.widthSize), (int) Math.round(76 * start.heightSize));
		//flashcardButton.addActionListener(new flashcardButton());
		flashcardButton.setContentAreaFilled(start.synligaKnappar);
		flashcardButton.setBorderPainted(start.synligaKnappar);
		flashcardButton.setFocusPainted(start.synligaKnappar);
		flashcardButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		flashcardButton.setText("Flashcards");
		
		readingButton.setBounds((int) Math.round(870 * start.widthSize), (int) Math.round(12 * start.heightSize), (int) Math.round(370 * start.widthSize), (int) Math.round(76 * start.heightSize));
		//readingButton.addActionListener(new readingButton());
		readingButton.setContentAreaFilled(start.synligaKnappar);
		readingButton.setBorderPainted(start.synligaKnappar);
		readingButton.setFocusPainted(start.synligaKnappar);
		readingButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		readingButton.setText("Reading");
		
		menyButton.setBounds((int) Math.round(10 * start.widthSize), (int) Math.round(10 * start.heightSize), (int) Math.round(80 * start.widthSize), (int) Math.round(80 * start.heightSize));
		//menyButton.addActionListener(new menyButton());
		menyButton.setContentAreaFilled(start.synligaKnappar);
		menyButton.setBorderPainted(start.synligaKnappar);
		menyButton.setFocusPainted(start.synligaKnappar);
		
		textArea.setBounds((int) Math.round(205 * start.widthSize), (int) Math.round(155 * start.heightSize), (int) Math.round(965 * start.widthSize), (int) Math.round(300 * start.heightSize));
		textArea.setFont(new Font("comic sans ms", Font.BOLD, 30));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setOpaque(false);
		textArea.setForeground(Color.BLACK);
		textArea.setEditable(false);
		textArea.setText("Test");
		
		answerField.setBounds((int) Math.round(200 * start.widthSize), (int) Math.round(603 * start.heightSize), (int) Math.round(700 * start.widthSize), (int) Math.round(107 * start.heightSize));
		answerField.setEditable(true);
		answerField.setFont(new Font("comic sans ms", Font.BOLD, 30));
		answerField.setHorizontalAlignment(WIDTH/2);
		answerField.setBorder(null);
		answerField.setBackground(new Color(77, 77, 77));
		
		answerButton.setBounds((int) Math.round(900 * start.widthSize), (int) Math.round(603 * start.heightSize), (int) Math.round(264 * start.widthSize), (int) Math.round(107 * start.heightSize));
		answerButton.addActionListener(new answerButtonAct());
		answerButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		answerButton.setText("Answer");
		
		correctAnswerField.setBounds((int) Math.round(200 * start.widthSize), (int) Math.round(233 * start.heightSize), (int) Math.round(964 * start.widthSize), (int) Math.round(369 * start.heightSize));
		correctAnswerField.setFont(new Font("comic sans ms", Font.BOLD, 30));
		correctAnswerField.setEditable(false);
		correctAnswerField.setOpaque(false);
		correctAnswerField.setBorder(null);
		
		answersFraction.setBounds((int) Math.round(1064 * start.widthSize), (int) Math.round(155 * start.heightSize), (int) Math.round(100 * start.widthSize), (int) Math.round(77 * start.heightSize));
		answersFraction.setFont(new Font("comic sans ms", Font.BOLD, 40));
		answersFraction.setEditable(false);
		answersFraction.setBorder(null);
		answersFraction.setHorizontalAlignment(WIDTH/2);
		answersFraction.setText(sentencesCorrect + "/7");
		answersFraction.setBackground(new Color(255, 0, 255));
	}
	
	public static void setupSentences()
	{
		if (lDefiniteFormL2Done == false)
		{
			//DETTA KAN BLI MYCKET BÄTTRE
			SentenceList sentenceInfo = new SentenceList("Jag är hemma", "I am at home", 0, 0, false);
			lessonSentences.add(sentenceInfo);
			sentenceInfo = new SentenceList("Ett barn", "A child", 0, 0, false);
			lessonSentences.add(sentenceInfo);
			sentenceInfo = new SentenceList("Barnet är en pojke", "The child is a boy", 0, 0, false);
			lessonSentences.add(sentenceInfo);
			sentenceInfo = new SentenceList("Vi är hemma", "We are at home", 0, 0, false);
			lessonSentences.add(sentenceInfo);
			sentenceInfo = new SentenceList("Ett hus", "A house", 0, 0, false);
			lessonSentences.add(sentenceInfo);
			sentenceInfo = new SentenceList("Huset är stort", "The house is big", 0, 0, false);
			lessonSentences.add(sentenceInfo);
			sentenceInfo = new SentenceList("Äpplet är litet", "The apple is small", 0, 0, false);
			lessonSentences.add(sentenceInfo);
		}
		else
		{
			//FÖRSTA MENINGEN
			SentenceList sentenceInfo = new SentenceList("Jag är hemma", "I am at home", 0, 0, false);
			for (int i = 0; i < lessonSentences.size(); i++)
	        {
	            if (lessonSentences.get(i).getSentence().equals("Jag är hemma"))
	            {
	                System.out.println("funnen!");
	                sentenceInfo = new SentenceList("Jag är hemma", "I am at home", lessonSentences.get(i).getPoints(), lessonSentences.get(i).getTries(), false);
	                lessonSentences.add(sentenceInfo);
	                lessonSentences.remove(i);
	                break;
	            }
	            else if ((i + 1) == lessonSentences.size())
	            {
	                System.out.println("Kunde inte hitta");
	            }
	        }
			
			//ANDRA MENINGEN
			for (int i = 0; i < lessonSentences.size(); i++)
	        {
	            if (lessonSentences.get(i).getSentence().equals("Ett barn"))
	            {
	                System.out.println("funnen!");
	                sentenceInfo = new SentenceList("Ett barn", "A child", lessonSentences.get(i).getPoints(), lessonSentences.get(i).getTries(), false);
	                lessonSentences.add(sentenceInfo);
	                lessonSentences.remove(i);
	                break;
	            }
	            else if ((i + 1) == lessonSentences.size())
	            {
	                System.out.println("Kunde inte hitta");
	            }
	        }
			
			//TREDJE MENINGEN
			for (int i = 0; i < lessonSentences.size(); i++)
	        {
	            if (lessonSentences.get(i).getSentence().equals("Barnet är en pojke"))
	            {
	                System.out.println("funnen!");
	                sentenceInfo = new SentenceList("Barnet är en pojke", "The child is a boy", lessonSentences.get(i).getPoints(), lessonSentences.get(i).getTries(), false);
	                lessonSentences.add(sentenceInfo);
	                lessonSentences.remove(i);
	                break;
	            }
	            else if ((i + 1) == lessonSentences.size())
	            {
	                System.out.println("Kunde inte hitta");
	            }
	        }
			
			//FJÄRDE MENINGEN
			for (int i = 0; i < lessonSentences.size(); i++)
	        {
	            if (lessonSentences.get(i).getSentence().equals("Vi är hemma"))
	            {
	                System.out.println("funnen!");
	                sentenceInfo = new SentenceList("Vi är hemma", "We are at home", lessonSentences.get(i).getPoints(), lessonSentences.get(i).getTries(), false);
	                lessonSentences.add(sentenceInfo);
	                lessonSentences.remove(i);
	                break;
	            }
	            else if ((i + 1) == lessonSentences.size())
	            {
	                System.out.println("Kunde inte hitta");
	            }
	        }
			
			//FEMTE MENINGEN
			for (int i = 0; i < lessonSentences.size(); i++)
	        {
	            if (lessonSentences.get(i).getSentence().equals("Ett hus"))
	            {
	                System.out.println("funnen!");
	                sentenceInfo = new SentenceList("Ett hus", "A house", lessonSentences.get(i).getPoints(), lessonSentences.get(i).getTries(), false);
	                lessonSentences.add(sentenceInfo);
	                lessonSentences.remove(i);
	                break;
	            }
	            else if ((i + 1) == lessonSentences.size())
	            {
	                System.out.println("Kunde inte hitta");
	            }
	        }
			
			//SJÄTTE MENINGEN
			for (int i = 0; i < lessonSentences.size(); i++)
	        {
	            if (lessonSentences.get(i).getSentence().equals("Huset är stort"))
	            {
	                System.out.println("funnen!");
	                sentenceInfo = new SentenceList("Huset är stort", "The house is big", lessonSentences.get(i).getPoints(), lessonSentences.get(i).getTries(), false);
	                lessonSentences.add(sentenceInfo);
	                lessonSentences.remove(i);
	                break;
	            }
	            else if ((i + 1) == lessonSentences.size())
	            {
	                System.out.println("Kunde inte hitta");
	            }
	        }
			
			//SJUNDE MENINGEN
			for (int i = 0; i < lessonSentences.size(); i++)
	        {
	            if (lessonSentences.get(i).getSentence().equals("Äpplet är litet"))
	            {
	                System.out.println("funnen!");
	                sentenceInfo = new SentenceList("Äpplet är litet", "The apple is small", lessonSentences.get(i).getPoints(), lessonSentences.get(i).getTries(), false);
	                lessonSentences.add(sentenceInfo);
	                lessonSentences.remove(i);
	                break;
	            }
	            else if ((i + 1) == lessonSentences.size())
	            {
	                System.out.println("Kunde inte hitta");
	            }
	        }
		}
	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(bakgrund, 0, 0, this.getWidth(), this.getHeight(), null);
	}
	
	public static void l2RandomSentence()
	{
		//kollar antal meningar kvar
		for (int i = 0; i < lessonSentences.size(); i++)
		{
			System.out.println(lessonSentences.get(i).getSentence() + lessonSentences.get(i).getCorrectAnswer());
			if (lessonSentences.get(i).getCorrectAnswer() == false)
			{
				sentencesLeft ++;
			}
		}
		sentencesCorrect = 7 - sentencesLeft;
		answersFraction.setText(sentencesCorrect + "/7");
		
		System.out.println("sentencesLeft: " + sentencesLeft);
		if (sentencesLeft == 0)
		{
			/*
			Meddelande som säger att man har gjort klart lektionen
			Sparar informationen från dessa
			 */
			sentencesCorrect = 0;
			answersFraction.setText(sentencesCorrect + "/7");
			correctAnswerField.setText(null);
			lDefiniteFormL2Done = true;
			System.out.println("TESTTEST");
			setupSentences();
			start.Byta(start.lektionTräd);
		}
		else
		{
			//ny mening
			sentenceNumber = randomNumber.nextInt(sentencesLeft);
			//återställer
			sentencesLeft = 0;
			//sätter ny mening
			System.out.println(lessonSentences.get(sentenceNumber).getSentence() + lessonSentences.get(sentenceNumber).getCorrectAnswer());
			textArea.setText("Translate into English: " + lessonSentences.get(sentenceNumber).getSentence());
		}
	}
	/*
	static class lessonButton implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			start.Byta(start.lektionTräd);
		}
	}
	
	static class flashcardButton implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			start.Byta(start.flashkort);
		}
	}
	
	static class readingButton implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			start.Byta(start.readingMenyn);
		}
	}
	
	static class menyButton implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			start.Byta(start.meny);
		}
	}
	*/
	static class answerButtonAct implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			if (answerField.getText().equalsIgnoreCase(lessonSentences.get(sentenceNumber).getTranslation()))
			{
				lessonSentences.get(sentenceNumber).setCorrectAnswer(true);
				//lägger till ny mening med nya värden, +100 poäng
				SentenceList sentenceInfo = new SentenceList(lessonSentences.get(sentenceNumber).getSentence(), lessonSentences.get(sentenceNumber).getTranslation(), (lessonSentences.get(sentenceNumber).getPoints() + 100), (lessonSentences.get(sentenceNumber).getTries() + 1), lessonSentences.get(sentenceNumber).getCorrectAnswer());
				lessonSentences.add(sentenceInfo);
				//tar bort gammal mening med gamla värden
				lessonSentences.remove(sentenceNumber);
				//skriver ut den senaste meningens försök + poäng
				System.out.println("FÖRSÖK, POÄNG: " + (lessonSentences.get(lessonSentences.size() - 1)).getTries() + ", " + (lessonSentences.get(lessonSentences.size() - 1)).getPoints());
				//återställer textfält
				answerField.setText(null);
				//visar svar
				correctAnswerField.setText("Correct!");
				//ny mening
				l2RandomSentence();
			}
			else if (lessonSentences.get(sentenceNumber).getSentence().equals("Jag är hemma") && answerField.getText().equalsIgnoreCase(possibleTranslations.get(0)))
			{
				lessonSentences.get(sentenceNumber).setCorrectAnswer(true);
				//lägger till ny mening med nya värden, +100 poäng
				SentenceList sentenceInfo = new SentenceList(lessonSentences.get(sentenceNumber).getSentence(), lessonSentences.get(sentenceNumber).getTranslation(), (lessonSentences.get(sentenceNumber).getPoints() + 100), (lessonSentences.get(sentenceNumber).getTries() + 1), lessonSentences.get(sentenceNumber).getCorrectAnswer());
				lessonSentences.add(sentenceInfo);
				//visar svar
				correctAnswerField.setText("Correct! Also correct: '" + lessonSentences.get(sentenceNumber).getTranslation() + "'");
				//tar bort gammal mening med gamla värden
				lessonSentences.remove(sentenceNumber);
				//skriver ut den senaste meningens försök + poäng
				System.out.println("FÖRSÖK, POÄNG: " + (lessonSentences.get(lessonSentences.size() - 1)).getTries() + ", " + (lessonSentences.get(lessonSentences.size() - 1)).getPoints());
				//återställer textfält
				answerField.setText(null);
				//ny mening
				l2RandomSentence();
			}
			else if (lessonSentences.get(sentenceNumber).getSentence().equals("Vi är hemma") && answerField.getText().equalsIgnoreCase(possibleTranslations.get(1)))
			{
				lessonSentences.get(sentenceNumber).setCorrectAnswer(true);
				//lägger till ny mening med nya värden, +100 poäng
				SentenceList sentenceInfo = new SentenceList(lessonSentences.get(sentenceNumber).getSentence(), lessonSentences.get(sentenceNumber).getTranslation(), (lessonSentences.get(sentenceNumber).getPoints() + 100), (lessonSentences.get(sentenceNumber).getTries() + 1), lessonSentences.get(sentenceNumber).getCorrectAnswer());
				lessonSentences.add(sentenceInfo);
				//visar svar
				correctAnswerField.setText("Correct! Also correct: '" + lessonSentences.get(sentenceNumber).getTranslation() + "'");
				//tar bort gammal mening med gamla värden
				lessonSentences.remove(sentenceNumber);
				//skriver ut den senaste meningens försök + poäng
				System.out.println("FÖRSÖK, POÄNG: " + (lessonSentences.get(lessonSentences.size() - 1)).getTries() + ", " + (lessonSentences.get(lessonSentences.size() - 1)).getPoints());
				//återställer textfält
				answerField.setText(null);
				//ny mening
				l2RandomSentence();
			}
			else
			{
				//lägger till ett försök i meningen
				lessonSentences.get(sentenceNumber).setTries(lessonSentences.get(sentenceNumber).getTries() + 1);
				//skriver ut den senaste meningens försök + poäng
				System.out.println("FÖRSÖK, POÄNG: " + lessonSentences.get(sentenceNumber).getTries() + ", " + lessonSentences.get(sentenceNumber).getPoints());
				//återställer textfält
				answerField.setText(null);
				//visar svar
				correctAnswerField.setText("Wrong! '" + lessonSentences.get(sentenceNumber).getSentence() + "' means '" + lessonSentences.get(sentenceNumber).getTranslation() + "'");
				//ny mening
				l2RandomSentence();
			}
		}
	}
}
