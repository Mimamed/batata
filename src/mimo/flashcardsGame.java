package mimo;

import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import mimo.tabMeny.lessonButton;
import mimo.tabMeny.flashcardButton;
import mimo.tabMeny.readingButton;
import mimo.spelFlashkort.lessonButtonAct;
import mimo.spelFlashkort.flashcardButtonAct;
import mimo.spelFlashkort.readingButtonAct;
import mimo.spelFlashkort.menyButtonAct;
import mimo.spelFlashkort.knapp5;
import mimo.tabMeny.button;
import mimo.tabMeny.menyButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class flashcardsGame extends JPanel {
	
	static BufferedImage pic;
	static JButton lessonButton = new JButton(), flashcardButton = new JButton(), readingButton = new JButton(), menyButton = new JButton(), answerButton = new JButton(), exampleButton = new JButton(), noButton = new JButton(), yesButton = new JButton(), returnButton = new JButton();
	static JLabel word = new JLabel(), meaning = new JLabel(), example = new JLabel();
	static int wordNumber = 0;
	static int categoryNumber = 1;
	//BEHÖVER: hur många försök
	static Random randomNumber = new Random();
	static int stringToInt;
	static int timesAnswered = 0;
	
	flashcardsGame() {
		try
		{
			pic = ImageIO.read(start.filer[3]);
		}catch (Exception e)
		{
			System.out.print("fel men uppladning4");
		}
		
		this.setLayout(null);
		
		//Sätter in alla componenter
		this.add(lessonButton);
		this.add(flashcardButton);
		this.add(readingButton);
		this.add(menyButton);
		this.add(exampleButton);
		this.add(answerButton);
		this.add(word);
		this.add(example);
		this.add(meaning);
		this.add(noButton);
		this.add(yesButton);
		this.add(returnButton);
		
		//Fixar kanpparna nedan
		lessonButton.setBounds((int) Math.round(127 * start.widthSize), (int) Math.round(12 * start.heightSize), (int) Math.round(371 * start.widthSize), (int) Math.round(76 * start.heightSize));
		lessonButton.addActionListener(new lessonButtonAct());
		lessonButton.setContentAreaFilled(start.synligaKnappar);
		lessonButton.setBorderPainted(start.synligaKnappar);
		lessonButton.setFocusPainted(start.synligaKnappar);
		lessonButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		lessonButton.setText("Lessons");
		
		flashcardButton.setBounds((int) Math.round(499 * start.widthSize), (int) Math.round(12 * start.heightSize), (int) Math.round(370 * start.widthSize), (int) Math.round(76 * start.heightSize));
		flashcardButton.addActionListener(new flashcardButtonAct());
		flashcardButton.setContentAreaFilled(start.synligaKnappar);
		flashcardButton.setBorderPainted(start.synligaKnappar);
		flashcardButton.setFocusPainted(start.synligaKnappar);
		flashcardButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		flashcardButton.setText("Flashcards");
		
		readingButton.setBounds((int) Math.round(870 * start.widthSize), (int) Math.round(12 * start.heightSize), (int) Math.round(370 * start.widthSize), (int) Math.round(76 * start.heightSize));
		readingButton.addActionListener(new readingButtonAct());
		readingButton.setContentAreaFilled(start.synligaKnappar);
		readingButton.setBorderPainted(start.synligaKnappar);
		readingButton.setFocusPainted(start.synligaKnappar);
		readingButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		readingButton.setText("Reading");
		
		menyButton.setBounds((int) Math.round(10 * start.widthSize), (int) Math.round(10 * start.heightSize), (int) Math.round(80 * start.widthSize), (int) Math.round(80 * start.heightSize));
		menyButton.addActionListener(new menyButtonAct());
		menyButton.setContentAreaFilled(start.synligaKnappar);
		menyButton.setBorderPainted(start.synligaKnappar);
		menyButton.setFocusPainted(start.synligaKnappar);
		
		word.setBounds((int) Math.round(535 * start.widthSize), (int) Math.round(200 * start.heightSize), (int) Math.round(293 * start.widthSize), (int) Math.round(106 * start.heightSize));
		word.setHorizontalAlignment(SwingConstants.CENTER);
		word.setVerticalAlignment(SwingConstants.CENTER);
		word.setFont(new Font("comic sans ms", Font.BOLD, 30));
		word.setText("test");
		
		answerButton.setBounds((int) Math.round(537 * start.widthSize), (int) Math.round(305 * start.heightSize), (int) Math.round(294 * start.widthSize), (int) Math.round(106 * start.heightSize));
		answerButton.addActionListener(new answerButtonAct());
		answerButton.setContentAreaFilled(start.synligaKnappar);
		answerButton.setFocusPainted(start.synligaKnappar);
		answerButton.setForeground(new Color(140, 198, 58));
		answerButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		answerButton.setText("Show meaning");
		
		exampleButton.setBounds((int) Math.round(535 * start.widthSize), (int) Math.round(443 * start.heightSize), (int) Math.round(293 * start.widthSize), (int) Math.round(106 * start.heightSize));
		exampleButton.addActionListener(new exampleButtonAct());
		exampleButton.setContentAreaFilled(start.synligaKnappar);
		exampleButton.setFocusPainted(start.synligaKnappar);
		exampleButton.setForeground(new Color(140, 198, 58));
		exampleButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		exampleButton.setText("Show example");
		
		noButton.setBounds((int) Math.round(649 * start.widthSize), (int) Math.round(625 * start.heightSize), (int) Math.round(257 * start.widthSize), (int) Math.round(85 * start.heightSize));
		noButton.addActionListener(new noButtonAct());
		noButton.setContentAreaFilled(start.synligaKnappar);
		noButton.setFocusPainted(start.synligaKnappar);
		noButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		noButton.setText("No");
		
		yesButton.setBounds((int) Math.round(907 * start.widthSize), (int) Math.round(625 * start.heightSize), (int) Math.round(257 * start.widthSize), (int) Math.round(85 * start.heightSize));
		yesButton.addActionListener(new yesButtonAct());
		yesButton.setContentAreaFilled(start.synligaKnappar);
		yesButton.setFocusPainted(start.synligaKnappar);
		yesButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		yesButton.setText("Yes");
		
		returnButton.setBounds((int) Math.round(110 * start.widthSize), (int) Math.round(350 * start.heightSize), (int) Math.round(80 * start.widthSize), (int) Math.round(80 * start.heightSize));
		returnButton.addActionListener(new returnButtonAct());
		returnButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		returnButton.setText("<");
	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(pic, 0, 0, this.getWidth(), this.getHeight(), null);
	}
	
	static class lessonButtonAct implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			start.Byta(start.lektionTräd);
		}
	}
	
	static class flashcardButtonAct implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			start.Byta(start.flashkort);
		}
	}
	
	static class readingButtonAct implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			start.Byta(start.readingMenyn);
		}
	}

	static class menyButtonAct implements ActionListener
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
			answerButton.setText(start.wordList.get(categoryNumber + 1).get(wordNumber));
		}
	}
	
	static class exampleButtonAct implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			exampleButton.setFont(new Font("comic sans ms", Font.BOLD, 20));
			if (start.wordList.get(categoryNumber + 2).get(wordNumber).equals("0"))
			{
				exampleButton.setText("No example available");
			}
			else
			{
				exampleButton.setText(start.wordList.get(categoryNumber + 2).get(wordNumber));
			}
		}
	}
	
	public static void flashcardWriteWord()
	{
		//TAR ORD FRÅN LISTAN OCH SÄTTER DET I "WORD"
		word.setText(start.wordList.get(categoryNumber).get(wordNumber));
		//get(y).get(x), y och x ska vara slumpade
	}
	
	static class noButtonAct implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//lägger till 1+ till räknare
			timesAnswered = Integer.parseInt(start.fkOrdlista.tempList.get(categoryNumber + 4).get(wordNumber)) + 1;
			start.fkOrdlista.tempList.get(categoryNumber + 4).set(wordNumber, Integer.toString(timesAnswered));
			
			//antal poäng
			System.out.println(start.fkOrdlista.tempList.get(categoryNumber + 3).get(wordNumber));
			System.out.println(start.fkOrdlista.tempList.get(categoryNumber).get(wordNumber) + ": inga extra poäng");
			//antal svar
			System.out.println(start.fkOrdlista.tempList.get(categoryNumber + 4).get(wordNumber));
			System.out.println(start.fkOrdlista.tempList.get(categoryNumber).get(wordNumber) + ": 1+");
			
			//slumpar först category
			switch (randomNumber.nextInt(4))
			{
			case 0:
				categoryNumber = 1;
				break;
			case 1:
				categoryNumber = 6;
				break;
			case 2:
				categoryNumber = 11;
				break;
			case 3:
				categoryNumber = 16;
				break;
			}
			//sedan word
			wordNumber = randomNumber.nextInt(start.fkOrdlista.tempList.get(categoryNumber).size());
			
			//återställer utseende
			answerButton.setText("Show meaning");
			exampleButton.setText("Show example");
			exampleButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
			flashcardWriteWord();
		}
	}
	
	static class yesButtonAct implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{	
			//lägger till 100 poäng till ordet
			stringToInt = Integer.parseInt(start.fkOrdlista.tempList.get(categoryNumber + 3).get(wordNumber)) + 100;
			start.fkOrdlista.tempList.get(categoryNumber + 3).set(wordNumber, Integer.toString(stringToInt));
			//lägger till 1+ till räknare
			timesAnswered = Integer.parseInt(start.fkOrdlista.tempList.get(categoryNumber + 4).get(wordNumber)) + 1;
			start.fkOrdlista.tempList.get(categoryNumber + 4).set(wordNumber, Integer.toString(timesAnswered));
			
			//antal poäng
			System.out.println(start.fkOrdlista.tempList.get(categoryNumber + 3).get(wordNumber));
			System.out.println(start.fkOrdlista.tempList.get(categoryNumber).get(wordNumber) + ": 100 extra poäng");
			//antal svar
			System.out.println(start.fkOrdlista.tempList.get(categoryNumber + 4).get(wordNumber));
			System.out.println(start.fkOrdlista.tempList.get(categoryNumber).get(wordNumber) + ": 1+");
			
			//slumpar först category
			switch (randomNumber.nextInt(4))
			{
			case 0:
				categoryNumber = 1;
				break;
			case 1:
				categoryNumber = 6;
				break;
			case 2:
				categoryNumber = 11;
				break;
			case 3:
				categoryNumber = 16;
				break;
			}
			//sedan word
			wordNumber = randomNumber.nextInt(start.fkOrdlista.tempList.get(categoryNumber).size());
			
			//återställer utseende 
			answerButton.setText("Show meaning");
			exampleButton.setText("Show example");
			exampleButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
			flashcardWriteWord();
		}
	}
	
	static class returnButtonAct implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{	
			start.Byta(start.flashkort);
		}
	}
}