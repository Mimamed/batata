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

/*
BEHÖVER: SÄTT ATT SVARA
 */

public class lBasicsOneL1 extends JPanel {
	static BufferedImage bakgrund;
	static JButton lessonButton = new JButton(), flashcardButton = new JButton(), readingButton = new JButton(), menyButton = new JButton(), answerButton = new JButton();
	static JTextArea textArea = new JTextArea();
	static List<SentenceList> lessonSentences = new ArrayList();
	public static int whichSentence;
	static Random randomNumber = new Random();
	static int sentenceNumber;
	static int sentencesLeft = 0;
	static boolean lBasicsOneL1Done = false;
	
	lBasicsOneL1 ()
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
		
		this.add(lessonButton);
		this.add(flashcardButton);
		this.add(readingButton);
		this.add(menyButton);
		this.add(textArea);
		this.add(answerButton);
		
		//sätter upp knapparna
		
		lessonButton.setBounds((int) Math.round(127 * start.widthSize), (int) Math.round(12 * start.heightSize), (int) Math.round(371 * start.widthSize), (int) Math.round(76 * start.heightSize));
		lessonButton.addActionListener(new lessonButton());
		lessonButton.setContentAreaFilled(start.synligaKnappar);
		lessonButton.setBorderPainted(start.synligaKnappar);
		lessonButton.setFocusPainted(start.synligaKnappar);
		lessonButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		lessonButton.setText("Lessons");

		flashcardButton.setBounds((int) Math.round(499 * start.widthSize), (int) Math.round(12 * start.heightSize), (int) Math.round(370 * start.widthSize), (int) Math.round(76 * start.heightSize));
		flashcardButton.addActionListener(new flashcardButton());
		flashcardButton.setContentAreaFilled(start.synligaKnappar);
		flashcardButton.setBorderPainted(start.synligaKnappar);
		flashcardButton.setFocusPainted(start.synligaKnappar);
		flashcardButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		flashcardButton.setText("Flashcards");
		
		readingButton.setBounds((int) Math.round(870 * start.widthSize), (int) Math.round(12 * start.heightSize), (int) Math.round(370 * start.widthSize), (int) Math.round(76 * start.heightSize));
		readingButton.addActionListener(new readingButton());
		readingButton.setContentAreaFilled(start.synligaKnappar);
		readingButton.setBorderPainted(start.synligaKnappar);
		readingButton.setFocusPainted(start.synligaKnappar);
		readingButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		readingButton.setText("Reading");
		
		menyButton.setBounds((int) Math.round(10 * start.widthSize), (int) Math.round(10 * start.heightSize), (int) Math.round(80 * start.widthSize), (int) Math.round(80 * start.heightSize));
		menyButton.addActionListener(new menyButton());
		menyButton.setContentAreaFilled(start.synligaKnappar);
		menyButton.setBorderPainted(start.synligaKnappar);
		menyButton.setFocusPainted(start.synligaKnappar);
		
		textArea.setBounds((int) Math.round(200 * start.widthSize), (int) Math.round(155 * start.heightSize), (int) Math.round(965 * start.widthSize), (int) Math.round(500 * start.heightSize));
		textArea.setFont(new Font("comic sans ms", Font.BOLD, 30));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setOpaque(false);
		textArea.setForeground(Color.BLACK);
		textArea.setEditable(false);
		textArea.setText("Test");
		
		answerButton.setBounds((int) Math.round(900 * start.widthSize), (int) Math.round(600 * start.heightSize), (int) Math.round(295 * start.widthSize), (int) Math.round(107 * start.heightSize));
		answerButton.addActionListener(new answerButtonAct());
		answerButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		answerButton.setText("Answer");
		
	}
	
	public static void setupSentences()
	{
		if (lBasicsOneL1Done == false)
		{
			//DETTA KAN BLI MYCKET BÄTTRE
			SentenceList sentenceInfo = new SentenceList("Jag är en man", "I am a man", 0, 0, false);
			lessonSentences.add(sentenceInfo);
			sentenceInfo = new SentenceList("Du är en flicka", "You are a girl", 0, 0, false);
			lessonSentences.add(sentenceInfo);
			sentenceInfo = new SentenceList("Han är en pojke", "He is a boy", 0, 0, false);
			lessonSentences.add(sentenceInfo);
			sentenceInfo = new SentenceList("Hon är en kvinna", "She is a woman", 0, 0, false);
			lessonSentences.add(sentenceInfo);
			sentenceInfo = new SentenceList("Jag är en kvinna", "I am a woman", 0, 0, false);
			lessonSentences.add(sentenceInfo);
			sentenceInfo = new SentenceList("Du är en pojke", "You are a boy", 0, 0, false);
			lessonSentences.add(sentenceInfo);
			sentenceInfo = new SentenceList("Han är en man", "He is a man", 0, 0, false);
			lessonSentences.add(sentenceInfo);
			sentenceInfo = new SentenceList("Hon är en flicka", "She is a girl", 0, 0, false);
			lessonSentences.add(sentenceInfo);
		}
		else
		{
			//FÖRSTA MENINGEN
			SentenceList sentenceInfo = new SentenceList("Jag är en man", "I am a man", 0, 0, false);
			for (int i = 0; i < lessonSentences.size(); i++)
	        {
	            if (lessonSentences.get(i).equals(sentenceInfo))
	            {
	                System.out.println("funnen!");
	                sentenceInfo = new SentenceList("Jag är en man", "I am a man", lessonSentences.get(i).getPoints(), lessonSentences.get(i).getTries(), false);
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
			sentenceInfo = new SentenceList("Du är en flicka", "You are a girl", 0, 0, false);
			for (int i = 0; i < lessonSentences.size(); i++)
	        {
	            if (lessonSentences.get(i).equals(sentenceInfo))
	            {
	                System.out.println("funnen!");
	                sentenceInfo = new SentenceList("Du är en flicka", "You are a girl", lessonSentences.get(i).getPoints(), lessonSentences.get(i).getTries(), false);
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
			sentenceInfo = new SentenceList("Han är en pojke", "He is a boy", 0, 0, false);
			for (int i = 0; i < lessonSentences.size(); i++)
	        {
	            if (lessonSentences.get(i).equals(sentenceInfo))
	            {
	                System.out.println("funnen!");
	                sentenceInfo = new SentenceList("Han är en pojke", "He is a boy", lessonSentences.get(i).getPoints(), lessonSentences.get(i).getTries(), false);
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
			sentenceInfo = new SentenceList("Hon är en kvinna", "She is a woman", 0, 0, false);
			for (int i = 0; i < lessonSentences.size(); i++)
	        {
	            if (lessonSentences.get(i).equals(sentenceInfo))
	            {
	                System.out.println("funnen!");
	                sentenceInfo = new SentenceList("Hon är en kvinna", "She is a woman", lessonSentences.get(i).getPoints(), lessonSentences.get(i).getTries(), false);
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
			sentenceInfo = new SentenceList("Jag är en kvinna", "I am a woman", 0, 0, false);
			for (int i = 0; i < lessonSentences.size(); i++)
	        {
	            if (lessonSentences.get(i).equals(sentenceInfo))
	            {
	                System.out.println("funnen!");
	                sentenceInfo = new SentenceList("Jag är en kvinna", "I am a woman", lessonSentences.get(i).getPoints(), lessonSentences.get(i).getTries(), false);
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
			sentenceInfo = new SentenceList("Du är en pojke", "You are a boy", 0, 0, false);
			for (int i = 0; i < lessonSentences.size(); i++)
	        {
	            if (lessonSentences.get(i).equals(sentenceInfo))
	            {
	                System.out.println("funnen!");
	                sentenceInfo = new SentenceList("Du är en pojke", "You are a boy", lessonSentences.get(i).getPoints(), lessonSentences.get(i).getTries(), false);
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
			sentenceInfo = new SentenceList("Han är en man", "He is a man", 0, 0, false);
			for (int i = 0; i < lessonSentences.size(); i++)
	        {
	            if (lessonSentences.get(i).equals(sentenceInfo))
	            {
	                System.out.println("funnen!");
	                sentenceInfo = new SentenceList("Han är en man", "He is a man", lessonSentences.get(i).getPoints(), lessonSentences.get(i).getTries(), false);
	                lessonSentences.add(sentenceInfo);
	                lessonSentences.remove(i);
	                break;
	            }
	            else if ((i + 1) == lessonSentences.size())
	            {
	                System.out.println("Kunde inte hitta");
	            }
	        }
			
			//ÅTTONDE MENINGEN
			sentenceInfo = new SentenceList("Hon är en flicka", "She is a girl", 0, 0, false);
			for (int i = 0; i < lessonSentences.size(); i++)
	        {
	            if (lessonSentences.get(i).equals(sentenceInfo))
	            {
	                System.out.println("funnen!");
	                sentenceInfo = new SentenceList("Hon är en flicka", "She is a girl", lessonSentences.get(i).getPoints(), lessonSentences.get(i).getTries(), false);
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
			if (lessonSentences.get(i).getCorrectAnswer() == false)
			{
				sentencesLeft ++;
			}
		}
		
		if (sentencesLeft == 0)
		{
			/*
			Meddelande som säger att man har gjort klart lektionen
			Sparar informationen från dessa
			 */
			lBasicsOneL1Done = true;
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
			textArea.setText("Translate into English: " + lessonSentences.get(sentenceNumber).getSentence());
		}
	}
	
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
	
	static class answerButtonAct implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			/*
			if (lessonSentences.get(sentenceNumber).getTranslation() = lessonSentences.get(sentenceNumber)getSentence())
			då correctAnswer = true
			då poäng 100++;
			 */
			lessonSentences.get(sentenceNumber).setCorrectAnswer(true);
			//lägger till ny mening med nya värden
			SentenceList sentenceInfo = new SentenceList(lessonSentences.get(sentenceNumber).getSentence(), lessonSentences.get(sentenceNumber).getTranslation(), lessonSentences.get(sentenceNumber).getPoints(), lessonSentences.get(sentenceNumber).getTries() + 1, lessonSentences.get(sentenceNumber).getCorrectAnswer());
			lessonSentences.add(sentenceInfo);
			//tar bort gammal mening med gamla värden
			lessonSentences.remove(sentenceNumber);
			//skriver upp den senaste meningens försök
			System.out.println("FÖRSÖK" + (lessonSentences.get(lessonSentences.size() - 1)).getTries());
			l1RandomSentence();
		}
	}
}

class SentenceList
{
	private String sentence;
    private String translation;
    private int points;
    private int tries;
    private boolean correctAnswer;
    
    public SentenceList(String sentence, String translation, int points, int tries, boolean correctAnswer)
    {
    	this.sentence = sentence;
    	this.translation = translation;
    	this.points = points;
    	this.tries = tries;
    	this.correctAnswer = correctAnswer;
    }
    
    public void setPoints(int points)
    {
    	this.points = points;
    }
    public void setTries(int tries)
    {
    	this.tries = tries;
    }
    public void setCorrectAnswer(boolean correctAnswer)
    {
    	this.correctAnswer = correctAnswer;
    }
    
    public String getSentence() { return sentence; }
    public String getTranslation() { return translation; }
    public int getPoints() { return points; }
    public int getTries() { return tries; }
    public boolean getCorrectAnswer() { return correctAnswer; }
}