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

import mimo.lPhrasesL1.answerButtonAct;

public class lPhrasesL2 extends JPanel {
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
	static boolean lPhrasesL2Done = false;
	static int sentencesCorrect = 0;
	static String text;
	
	lPhrasesL2()
	{
		try
		{
			bakgrund = ImageIO.read(start.filer[10]);
		}catch(Exception e)
		{
			System.out.print("fel men uppladning");
		}
		
		this.setLayout(null);
		
		//addar grejer
		
		setupSentences();
		possibleTranslations.add("Thanks for the food");
		
		this.add(lessonButton);
		this.add(flashcardButton);
		this.add(readingButton);
		this.add(menyButton);
		this.add(textArea);
		this.add(answerField);
		this.add(answerButton);
		this.add(correctAnswerField);
		this.add(answersFraction);
		
		//s�tter upp knapparna
		
		lessonButton.setBounds((int) Math.round(127 * start.widthSize), (int) Math.round(12 * start.heightSize), (int) Math.round(371 * start.widthSize), (int) Math.round(76 * start.heightSize));
		lessonButton.setContentAreaFilled(start.synligaKnappar);
		lessonButton.setBorderPainted(start.synligaKnappar);
		lessonButton.setFocusPainted(start.synligaKnappar);
		lessonButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		lessonButton.setText("Lessons");

		flashcardButton.setBounds((int) Math.round(499 * start.widthSize), (int) Math.round(12 * start.heightSize), (int) Math.round(370 * start.widthSize), (int) Math.round(76 * start.heightSize));
		flashcardButton.setContentAreaFilled(start.synligaKnappar);
		flashcardButton.setBorderPainted(start.synligaKnappar);
		flashcardButton.setFocusPainted(start.synligaKnappar);
		flashcardButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		flashcardButton.setText("Flashcards");
		
		readingButton.setBounds((int) Math.round(870 * start.widthSize), (int) Math.round(12 * start.heightSize), (int) Math.round(370 * start.widthSize), (int) Math.round(76 * start.heightSize));
		readingButton.setContentAreaFilled(start.synligaKnappar);
		readingButton.setBorderPainted(start.synligaKnappar);
		readingButton.setFocusPainted(start.synligaKnappar);
		readingButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		readingButton.setText("Reading");
		
		menyButton.setBounds((int) Math.round(10 * start.widthSize), (int) Math.round(10 * start.heightSize), (int) Math.round(80 * start.widthSize), (int) Math.round(80 * start.heightSize));
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
		answersFraction.setText(sentencesCorrect + "/8");
		answersFraction.setBackground(new Color(255, 0, 255));
	}
	
	public static void setupSentences()
	{
		if (lPhrasesL2Done == false)
		{
			//DETTA KAN BLI MYCKET B�TTRE
			SentenceList sentenceInfo = new SentenceList("V�lkommen", "Welcome", 0, 0, false);
			lessonSentences.add(sentenceInfo);
			sentenceInfo = new SentenceList("Godmorgon och v�lkommen", "Good morning and welcome", 0, 0, false);
			lessonSentences.add(sentenceInfo);
			sentenceInfo = new SentenceList("Tack f�r maten", "Thank you for the food", 0, 0, false);
			lessonSentences.add(sentenceInfo);
			sentenceInfo = new SentenceList("Sn�lla", "Please", 0, 0, false);
			lessonSentences.add(sentenceInfo);
			sentenceInfo = new SentenceList("Sn�lla �t", "Please eat", 0, 0, false);
			lessonSentences.add(sentenceInfo);
			sentenceInfo = new SentenceList("Goddag", "Good day", 0, 0, false);
			lessonSentences.add(sentenceInfo);
			sentenceInfo = new SentenceList("Sn�lla drick", "Please drink", 0, 0, false);
			lessonSentences.add(sentenceInfo);
			sentenceInfo = new SentenceList("Godnatt", "Good night", 0, 0, false);
			lessonSentences.add(sentenceInfo);
		}
		else
		{
			//F�RSTA MENINGEN
			SentenceList sentenceInfo = new SentenceList("V�lkommen", "Welcome", 0, 0, false);
			for (int i = 0; i < lessonSentences.size(); i++)
	        {
	            if (lessonSentences.get(i).getSentence().equals("V�lkommen"))
	            {
	                System.out.println("funnen!");
	                sentenceInfo = new SentenceList("V�lkommen", "Welcome", lessonSentences.get(i).getPoints(), lessonSentences.get(i).getTries(), false);
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
	            if (lessonSentences.get(i).getSentence().equals("Godmorgon och v�lkommen"))
	            {
	                System.out.println("funnen!");
	                sentenceInfo = new SentenceList("Godmorgon och v�lkommen", "Good morning and welcome", lessonSentences.get(i).getPoints(), lessonSentences.get(i).getTries(), false);
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
	            if (lessonSentences.get(i).getSentence().equals("Tack f�r maten"))
	            {
	                System.out.println("funnen!");
	                sentenceInfo = new SentenceList("Tack f�r maten", "Thank you for the food", lessonSentences.get(i).getPoints(), lessonSentences.get(i).getTries(), false);
	                lessonSentences.add(sentenceInfo);
	                lessonSentences.remove(i);
	                break;
	            }
	            else if ((i + 1) == lessonSentences.size())
	            {
	                System.out.println("Kunde inte hitta");
	            }
	        }
			
			//FJ�RDE MENINGEN
			for (int i = 0; i < lessonSentences.size(); i++)
	        {
	            if (lessonSentences.get(i).getSentence().equals("Sn�lla"))
	            {
	                System.out.println("funnen!");
	                sentenceInfo = new SentenceList("Sn�lla", "Please", lessonSentences.get(i).getPoints(), lessonSentences.get(i).getTries(), false);
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
	            if (lessonSentences.get(i).getSentence().equals("Sn�lla �t"))
	            {
	                System.out.println("funnen!");
	                sentenceInfo = new SentenceList("Sn�lla �t", "Please eat", lessonSentences.get(i).getPoints(), lessonSentences.get(i).getTries(), false);
	                lessonSentences.add(sentenceInfo);
	                lessonSentences.remove(i);
	                break;
	            }
	            else if ((i + 1) == lessonSentences.size())
	            {
	                System.out.println("Kunde inte hitta");
	            }
	        }
			
			//SJ�TTE MENINGEN
			for (int i = 0; i < lessonSentences.size(); i++)
	        {
	            if (lessonSentences.get(i).getSentence().equals("Goddag"))
	            {
	                System.out.println("funnen!");
	                sentenceInfo = new SentenceList("Goddag", "Good day", lessonSentences.get(i).getPoints(), lessonSentences.get(i).getTries(), false);
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
	            if (lessonSentences.get(i).getSentence().equals("Sn�lla drick"))
	            {
	                System.out.println("funnen!");
	                sentenceInfo = new SentenceList("Sn�lla drick", "Please drink", lessonSentences.get(i).getPoints(), lessonSentences.get(i).getTries(), false);
	                lessonSentences.add(sentenceInfo);
	                lessonSentences.remove(i);
	                break;
	            }
	            else if ((i + 1) == lessonSentences.size())
	            {
	                System.out.println("Kunde inte hitta");
	            }
	        }
			
			//�TTONDE MENINGEN
			for (int i = 0; i < lessonSentences.size(); i++)
	        {
	            if (lessonSentences.get(i).getSentence().equals("Godnatt"))
	            {
	                System.out.println("funnen!");
	                sentenceInfo = new SentenceList("Godnatt", "Good night", lessonSentences.get(i).getPoints(), lessonSentences.get(i).getTries(), false);
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
		sentencesCorrect = 8 - sentencesLeft;
		answersFraction.setText(sentencesCorrect + "/8");
		
		System.out.println("sentencesLeft: " + sentencesLeft);
		if (sentencesLeft == 0)
		{
			/*
			Meddelande som s�ger att man har gjort klart lektionen
			Sparar informationen fr�n dessa
			 */
			sentencesCorrect = 0;
			answersFraction.setText(sentencesCorrect + "/8");
			correctAnswerField.setText(null);
			lPhrasesL2Done = true;
			System.out.println("TESTTEST");
			setupSentences();
			start.Byta(start.lektionTr�d);
		}
		else
		{
			//ny mening
			sentenceNumber = randomNumber.nextInt(sentencesLeft);
			//�terst�ller
			sentencesLeft = 0;
			//s�tter ny mening
			System.out.println(lessonSentences.get(sentenceNumber).getSentence() + lessonSentences.get(sentenceNumber).getCorrectAnswer());
			textArea.setText("Translate into English: " + lessonSentences.get(sentenceNumber).getSentence());
		}
	}
	
	static class answerButtonAct implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (answerField.getText().equalsIgnoreCase(lessonSentences.get(sentenceNumber).getTranslation()))
			{
				lessonSentences.get(sentenceNumber).setCorrectAnswer(true);
				//l�gger till ny mening med nya v�rden, +100 po�ng
				SentenceList sentenceInfo = new SentenceList(lessonSentences.get(sentenceNumber).getSentence(), lessonSentences.get(sentenceNumber).getTranslation(), (lessonSentences.get(sentenceNumber).getPoints() + 100), (lessonSentences.get(sentenceNumber).getTries() + 1), lessonSentences.get(sentenceNumber).getCorrectAnswer());
				lessonSentences.add(sentenceInfo);
				//tar bort gammal mening med gamla v�rden
				lessonSentences.remove(sentenceNumber);
				//skriver ut den senaste meningens f�rs�k + po�ng
				System.out.println("F�RS�K, PO�NG: " + (lessonSentences.get(lessonSentences.size() - 1)).getTries() + ", " + (lessonSentences.get(lessonSentences.size() - 1)).getPoints());
				//�terst�ller textf�lt
				answerField.setText(null);
				//visar svar
				correctAnswerField.setText("Correct!");
				//ny mening
				l2RandomSentence();
			}
			else if (lessonSentences.get(sentenceNumber).getSentence().equals("Tack f�r maten") && answerField.getText().equalsIgnoreCase(possibleTranslations.get(0)))
			{
				lessonSentences.get(sentenceNumber).setCorrectAnswer(true);
				//l�gger till ny mening med nya v�rden, +100 po�ng
				SentenceList sentenceInfo = new SentenceList(lessonSentences.get(sentenceNumber).getSentence(), lessonSentences.get(sentenceNumber).getTranslation(), (lessonSentences.get(sentenceNumber).getPoints() + 100), (lessonSentences.get(sentenceNumber).getTries() + 1), lessonSentences.get(sentenceNumber).getCorrectAnswer());
				lessonSentences.add(sentenceInfo);
				//visar svar
				correctAnswerField.setText("Correct! Also correct: '" + lessonSentences.get(sentenceNumber).getTranslation() + "'");
				//tar bort gammal mening med gamla v�rden
				lessonSentences.remove(sentenceNumber);
				//skriver ut den senaste meningens f�rs�k + po�ng
				System.out.println("F�RS�K, PO�NG: " + (lessonSentences.get(lessonSentences.size() - 1)).getTries() + ", " + (lessonSentences.get(lessonSentences.size() - 1)).getPoints());
				//�terst�ller textf�lt
				answerField.setText(null);
				//ny mening
				l2RandomSentence();
			}
			else
			{
				//l�gger till ett f�rs�k i meningen
				lessonSentences.get(sentenceNumber).setTries(lessonSentences.get(sentenceNumber).getTries() + 1);
				//skriver ut den senaste meningens f�rs�k + po�ng
				System.out.println("F�RS�K, PO�NG: " + lessonSentences.get(sentenceNumber).getTries() + ", " + lessonSentences.get(sentenceNumber).getPoints());
				//�terst�ller textf�lt
				answerField.setText(null);
				//visar svar
				text = "Wrong! '" + lessonSentences.get(sentenceNumber).getSentence() + "' means '" + lessonSentences.get(sentenceNumber).getTranslation() + "'";
				if (text.length() > 61)
				{
					correctAnswerField.setFont(new Font("comic sans ms", Font.BOLD, 23));
				}
				else
				{
					correctAnswerField.setFont(new Font("comic sans ms", Font.BOLD, 30));
				}
				correctAnswerField.setText(text);
				//ny mening
				l2RandomSentence();
			}
		}
	}
}
