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
	static JButton lessonButton = new JButton(), flashcardButton = new JButton(), readingButton = new JButton(), menyButton = new JButton(), answerButton = new JButton(), exampleButton = new JButton(), zeroButton = new JButton(), oneButton = new JButton(), twoButton = new JButton(), threeButton = new JButton(), fourButton = new JButton(), fiveButton = new JButton();
	static JLabel word = new JLabel(), meaning = new JLabel(), example = new JLabel();
	static int wordNumber = 0;
	static int categoryNumber = 1;
	static Random randomNumber = new Random();
	
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
		this.add(zeroButton);
		this.add(oneButton);
		this.add(twoButton);
		this.add(threeButton);
		this.add(fourButton);
		this.add(fiveButton);
		
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
		
		zeroButton.setBounds((int) Math.round(649 * start.widthSize), (int) Math.round(625 * start.heightSize), (int) Math.round(85 * start.widthSize), (int) Math.round(85 * start.heightSize));
		zeroButton.addActionListener(new zeroButtonAct());
		zeroButton.setContentAreaFilled(start.synligaKnappar);
		zeroButton.setFocusPainted(start.synligaKnappar);
		zeroButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		zeroButton.setText("0");
		
		oneButton.setBounds((int) Math.round(735 * start.widthSize), (int) Math.round(625 * start.heightSize), (int) Math.round(85 * start.widthSize), (int) Math.round(85 * start.heightSize));
		oneButton.addActionListener(new oneButtonAct());
		oneButton.setContentAreaFilled(start.synligaKnappar);
		oneButton.setFocusPainted(start.synligaKnappar);
		oneButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		oneButton.setText("1");
		
		twoButton.setBounds((int) Math.round(821 * start.widthSize), (int) Math.round(625 * start.heightSize), (int) Math.round(85 * start.widthSize), (int) Math.round(85 * start.heightSize));
		twoButton.addActionListener(new twoButtonAct());
		twoButton.setContentAreaFilled(start.synligaKnappar);
		twoButton.setFocusPainted(start.synligaKnappar);
		twoButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		twoButton.setText("2");
		
		threeButton.setBounds((int) Math.round(907 * start.widthSize), (int) Math.round(625 * start.heightSize), (int) Math.round(85 * start.widthSize), (int) Math.round(85 * start.heightSize));
		threeButton.addActionListener(new threeButtonAct());
		threeButton.setContentAreaFilled(start.synligaKnappar);
		threeButton.setFocusPainted(start.synligaKnappar);
		threeButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		threeButton.setText("3");
		
		fourButton.setBounds((int) Math.round(993 * start.widthSize), (int) Math.round(625 * start.heightSize), (int) Math.round(85 * start.widthSize), (int) Math.round(85 * start.heightSize));
		fourButton.addActionListener(new fourButtonAct());
		fourButton.setContentAreaFilled(start.synligaKnappar);
		fourButton.setFocusPainted(start.synligaKnappar);
		fourButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		fourButton.setText("4");
		
		fiveButton.setBounds((int) Math.round(1079 * start.widthSize), (int) Math.round(625 * start.heightSize), (int) Math.round(85 * start.widthSize), (int) Math.round(85 * start.heightSize));
		fiveButton.addActionListener(new fiveButtonAct());
		fiveButton.setContentAreaFilled(start.synligaKnappar);
		fiveButton.setFocusPainted(start.synligaKnappar);
		fiveButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		fiveButton.setText("5");
		
	}
	
	public static void flashcardWriteWord()
	{
		//TAR ORD FRÅN LISTAN OCH SÄTTER DET I "WORD"
		word.setText(start.wordList.get(categoryNumber).get(wordNumber));
		//get(y).get(x), y och x ska vara slumpade
	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(pic, 0, 0, this.getWidth(), this.getHeight(), null);
	}
	
	static class lessonButtonAct implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
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
			exampleButton.setText("Fepoj är en bra pojke");
		}
	}
	
	static class zeroButtonAct implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//start.wordList.get(categoryNumber + 2).get(wordNumber).set(0);
			wordNumber = randomNumber.nextInt(2);
			if(randomNumber.nextInt(2) == 0)
			{
				categoryNumber = 1;
			}
			else
			{
				categoryNumber = 4;
			}
			answerButton.setText("Show meaning");
			exampleButton.setText("Show example");
			flashcardWriteWord();
		}
	}
	
	static class oneButtonAct implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//start.wordList.get(categoryNumber + 2).get(wordNumber).set(1);
			wordNumber = randomNumber.nextInt(2);
			if(randomNumber.nextInt(2) == 0)
			{
				categoryNumber = 1;
			}
			else
			{
				categoryNumber = 4;
			}
			answerButton.setText("Show meaning");
			exampleButton.setText("Show example");
			flashcardWriteWord();
		}
	}
	
	static class twoButtonAct implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//start.wordList.get(categoryNumber + 2).get(wordNumber).set(2);
			wordNumber = randomNumber.nextInt(2);
			if(randomNumber.nextInt(2) == 0)
			{
				categoryNumber = 1;
			}
			else
			{
				categoryNumber = 4;
			}
			answerButton.setText("Show meaning");
			exampleButton.setText("Show example");
			flashcardWriteWord();
		}
	}
	
	static class threeButtonAct implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//start.wordList.get(categoryNumber + 2).get(wordNumber).set(3);
			wordNumber = randomNumber.nextInt(2);
			if(randomNumber.nextInt(2) == 0)
			{
				categoryNumber = 1;
			}
			else
			{
				categoryNumber = 4;
			}
			answerButton.setText("Show meaning");
			exampleButton.setText("Show example");
			flashcardWriteWord();
		}
	}
	
	static class fourButtonAct implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//start.wordList.get(categoryNumber + 2).get(wordNumber).set(4);
			wordNumber = randomNumber.nextInt(2);
			if(randomNumber.nextInt(2) == 0)
			{
				categoryNumber = 1;
			}
			else
			{
				categoryNumber = 4;
			}
			answerButton.setText("Show meaning");
			exampleButton.setText("Show example");
			flashcardWriteWord();
		}
	}
	
	static class fiveButtonAct implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//start.wordList.get(categoryNumber + 2).get(wordNumber).set(5);
			wordNumber = randomNumber.nextInt(2);
			if(randomNumber.nextInt(2) == 0)
			{
				categoryNumber = 1;
			}
			else
			{
				categoryNumber = 4;
			}
			answerButton.setText("Show meaning");
			exampleButton.setText("Show example");
			flashcardWriteWord();
		}
	}
}