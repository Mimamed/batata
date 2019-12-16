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

public class lDefiniteFormL1 extends JPanel {
	static BufferedImage bakgrund;
	static JButton lessonButton = new JButton(), flashcardButton = new JButton(), readingButton = new JButton(), menyButton = new JButton(), answerButton = new JButton();
	static JTextArea textArea = new JTextArea(), answersFraction = new JTextArea();
	static JTextField answerField = new JTextField();
	static List<SentenceList> lessonSentences = new ArrayList();
	static ArrayList<String> possibleTranslations = new ArrayList<String>();
	public static int whichSentence;
	static Random randomNumber = new Random();
	static int sentenceNumber;
	static int sentencesLeft = 0;
	static boolean lDefiniteFormL1Done = false;
	static int sentencesCorrect = 0;
	
	lDefiniteFormL1()
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
		possibleTranslations.add("The boy is not drinking beer");
		
		this.add(lessonButton);
		this.add(flashcardButton);
		this.add(readingButton);
		this.add(menyButton);
		this.add(textArea);
		this.add(answerField);
		this.add(answerButton);
		this.add(answersFraction);
		
		//s�tter upp knapparna
		
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
		
		answersFraction.setBounds((int) Math.round(980 * start.widthSize), (int) Math.round(500 * start.heightSize), (int) Math.round(100 * start.widthSize), (int) Math.round(100 * start.heightSize));
		answersFraction.setFont(new Font("comic sans ms", Font.BOLD, 50));
		answersFraction.setLineWrap(true);
		answersFraction.setWrapStyleWord(true);
		answersFraction.setOpaque(false);
		answersFraction.setForeground(Color.BLACK);
		answersFraction.setEditable(false);
		answersFraction.setText(sentencesCorrect + "/7");
	}
	
	public static void setupSentences()
	{
		if (lDefiniteFormL1Done == false)
		{
			//DETTA KAN BLI MYCKET B�TTRE
			SentenceList sentenceInfo = new SentenceList("Flickan �ter �pplet", "The girl is eating the apple", 0, 0, false);
			lessonSentences.add(sentenceInfo);
			sentenceInfo = new SentenceList("Mannen �r inte en pojke", "The man is not a boy", 0, 0, false);
			lessonSentences.add(sentenceInfo);
			sentenceInfo = new SentenceList("Kvinnan och mannen", "The woman and the man", 0, 0, false);
			lessonSentences.add(sentenceInfo);
			sentenceInfo = new SentenceList("Pojken dricker inte �l", "The boy does not drink beer", 0, 0, false);
			lessonSentences.add(sentenceInfo);
			sentenceInfo = new SentenceList("Jag �r flickan och du �r pojken", "I am the girl and you are the boy", 0, 0, false);
			lessonSentences.add(sentenceInfo);
			sentenceInfo = new SentenceList("Mannen �r en man", "The man is a man", 0, 0, false);
			lessonSentences.add(sentenceInfo);
			sentenceInfo = new SentenceList("Vattnet �r inte �l", "The water is not beer", 0, 0, false);
			lessonSentences.add(sentenceInfo);
		}
		else
		{
			//F�RSTA MENINGEN
			SentenceList sentenceInfo = new SentenceList("Flickan �ter �pplet", "The girl is eating the apple", 0, 0, false);
			for (int i = 0; i < lessonSentences.size(); i++)
	        {
	            if (lessonSentences.get(i).getSentence().equals("Flickan �ter �pplet"))
	            {
	                System.out.println("funnen!");
	                sentenceInfo = new SentenceList("Flickan �ter �pplet", "The girl is eating the apple", lessonSentences.get(i).getPoints(), lessonSentences.get(i).getTries(), false);
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
	            if (lessonSentences.get(i).getSentence().equals("Mannen �r inte en pojke"))
	            {
	                System.out.println("funnen!");
	                sentenceInfo = new SentenceList("Mannen �r inte en pojke", "The man is not a boy", lessonSentences.get(i).getPoints(), lessonSentences.get(i).getTries(), false);
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
	            if (lessonSentences.get(i).getSentence().equals("Kvinnan och mannen"))
	            {
	                System.out.println("funnen!");
	                sentenceInfo = new SentenceList("Kvinnan och mannen", "The woman and the man", lessonSentences.get(i).getPoints(), lessonSentences.get(i).getTries(), false);
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
	            if (lessonSentences.get(i).getSentence().equals("Pojken dricker inte �l"))
	            {
	                System.out.println("funnen!");
	                sentenceInfo = new SentenceList("Pojken dricker inte �l", "The boy doesn't drink beer", lessonSentences.get(i).getPoints(), lessonSentences.get(i).getTries(), false);
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
	            if (lessonSentences.get(i).getSentence().equals("Jag �r flickan och du �r pojken"))
	            {
	                System.out.println("funnen!");
	                sentenceInfo = new SentenceList("Jag �r flickan och du �r pojken", "I am the girl and you are the boy", lessonSentences.get(i).getPoints(), lessonSentences.get(i).getTries(), false);
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
	            if (lessonSentences.get(i).getSentence().equals("Mannen �r en man"))
	            {
	                System.out.println("funnen!");
	                sentenceInfo = new SentenceList("Mannen �r en man", "The man is a man", lessonSentences.get(i).getPoints(), lessonSentences.get(i).getTries(), false);
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
	            if (lessonSentences.get(i).getSentence().equals("Vattnet �r inte �l"))
	            {
	                System.out.println("funnen!");
	                sentenceInfo = new SentenceList("Vattnet �r inte �l", "The water is not beer", lessonSentences.get(i).getPoints(), lessonSentences.get(i).getTries(), false);
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
	
	public static void l1RandomSentence()
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
			Meddelande som s�ger att man har gjort klart lektionen
			Sparar informationen fr�n dessa
			 */
			sentencesCorrect = 0;
			answersFraction.setText(sentencesCorrect + "/7");
			lDefiniteFormL1Done = true;
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
	/*
	static class lessonButton implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			start.Byta(start.lektionTr�d);
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
				//l�gger till ny mening med nya v�rden, +100 po�ng
				SentenceList sentenceInfo = new SentenceList(lessonSentences.get(sentenceNumber).getSentence(), lessonSentences.get(sentenceNumber).getTranslation(), (lessonSentences.get(sentenceNumber).getPoints() + 100), (lessonSentences.get(sentenceNumber).getTries() + 1), lessonSentences.get(sentenceNumber).getCorrectAnswer());
				lessonSentences.add(sentenceInfo);
				//tar bort gammal mening med gamla v�rden
				lessonSentences.remove(sentenceNumber);
				//skriver ut den senaste meningens f�rs�k + po�ng
				System.out.println("F�RS�K, PO�NG: " + (lessonSentences.get(lessonSentences.size() - 1)).getTries() + ", " + (lessonSentences.get(lessonSentences.size() - 1)).getPoints());
				//�terst�ller textf�lt
				answerField.setText(null);
				//ny mening
				l1RandomSentence();
			}
			else if (lessonSentences.get(sentenceNumber).getSentence().equals("Pojken dricker inte �l") && answerField.getText().equalsIgnoreCase(possibleTranslations.get(0)))
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
				//ny mening
				l1RandomSentence();
			}
			else
			{
				//l�gger till ett f�rs�k i meningen
				lessonSentences.get(sentenceNumber).setTries(lessonSentences.get(sentenceNumber).getTries() + 1);
				//skriver ut den senaste meningens f�rs�k + po�ng
				System.out.println("F�RS�K, PO�NG: " + lessonSentences.get(sentenceNumber).getTries() + ", " + lessonSentences.get(sentenceNumber).getPoints());
				//�terst�ller textf�lt
				answerField.setText(null);
				//ny mening
				l1RandomSentence();
			}
		}
	}
}
