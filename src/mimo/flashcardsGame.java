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
import mimo.tabMeny.button;
import mimo.tabMeny.menyButton;

import java.util.List;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class flashcardsGame extends JPanel {
	
	//TAR ORD FRÅN LISTAN OCH FÖRBREDER DET FÖR "WORD"
	/* fungerar inte
	try {
		Scanner insertWord = new Scanner(new File("C:\\Users\\Public\\Downloads\\wordList.txt"));
	} catch (FileNotFoundException e) {
	} */
	
	//static List<WordListClass> words = new ArrayList<WordListClass>();
	
	//static List<String>[] allText = {new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>()};
	static BufferedImage pic;
	static JButton lessonButton = new JButton(), flashcardButton = new JButton(), readingButton = new JButton(), menyButton = new JButton(), answerButton = new JButton(), exampleButton = new JButton();
	static JLabel word = new JLabel(), meaning = new JLabel(), example = new JLabel();
	
	
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
		
		//Fixar kanpparna nedan
		lessonButton.setBounds((int) Math.round(127 * start.widthSize), (int) Math.round(12 * start.heightSize), (int) Math.round(371 * start.widthSize), (int) Math.round(76 * start.heightSize));
		lessonButton.addActionListener(new knapp1());
		lessonButton.setContentAreaFilled(false);
		lessonButton.setBorderPainted(false);
		lessonButton.setFocusPainted(false);
		lessonButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		lessonButton.setText("Lessons");
		
		//SKA HA RÖD BAKGRUND, LISTA UT SENARE.
		flashcardButton.setBounds((int) Math.round(499 * start.widthSize), (int) Math.round(12 * start.heightSize), (int) Math.round(370 * start.widthSize), (int) Math.round(76 * start.heightSize));
		flashcardButton.addActionListener(new knapp2());
		flashcardButton.setContentAreaFilled(false);
		flashcardButton.setBorderPainted(false);
		flashcardButton.setFocusPainted(false);
		flashcardButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		flashcardButton.setText("Flashcards");
		
		readingButton.setBounds((int) Math.round(870 * start.widthSize), (int) Math.round(12 * start.heightSize), (int) Math.round(370 * start.widthSize), (int) Math.round(76 * start.heightSize));
		readingButton.addActionListener(new knapp3());
		readingButton.setContentAreaFilled(false);
		readingButton.setBorderPainted(false);
		readingButton.setFocusPainted(false);
		readingButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		readingButton.setText("Reading");
		
		menyButton.setBounds((int) Math.round(10 * start.widthSize), (int) Math.round(10 * start.heightSize), (int) Math.round(80 * start.widthSize), (int) Math.round(80 * start.heightSize));
		menyButton.addActionListener(new knapp4());
		menyButton.setContentAreaFilled(false);
		menyButton.setBorderPainted(false);
		menyButton.setFocusPainted(false);
		
		//TAR ORD FRÅN LISTAN OCH SÄTTER DET I "WORD"
		//fixa V
		word.setBounds((int) Math.round(535 * start.widthSize), (int) Math.round(200 * start.heightSize), (int) Math.round(293 * start.widthSize), (int) Math.round(106 * start.heightSize));
		word.setFont(new Font("comic sans ms", Font.BOLD, 30));
		//fixa V
		word.setText("WORD");
		
		exampleButton.setBounds((int) Math.round(535 * start.widthSize), (int) Math.round(443 * start.heightSize), (int) Math.round(293 * start.widthSize), (int) Math.round(106 * start.heightSize));
		exampleButton.addActionListener(new knapp5());
		exampleButton.setContentAreaFilled(start.synligaKnappar);
		exampleButton.setFocusPainted(start.synligaKnappar);
		exampleButton.setForeground(new Color(140, 198, 58));
		exampleButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		exampleButton.setText("Show example");
		
		answerButton.setBounds((int) Math.round(537 * start.widthSize), (int) Math.round(305 * start.heightSize), (int) Math.round(294 * start.widthSize), (int) Math.round(106 * start.heightSize));
		answerButton.addActionListener(new knapp6());
		answerButton.setContentAreaFilled(start.synligaKnappar);
		answerButton.setFocusPainted(start.synligaKnappar);
		answerButton.setForeground(new Color(140, 198, 58));
		answerButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		answerButton.setText("Show meaning");
	}
	public void paintComponent(Graphics g)
	{
		g.drawImage(pic, 0, 0, this.getWidth(), this.getHeight(), null);
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
			start.Byta(start.readingMenyn);
		}
	}

	static class knapp4 implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			start.Byta(start.meny);
		}
	}
	
	static class knapp5 implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			
		}
	}

	static class knapp6 implements ActionListener
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
		//System.out.println("3. Set how well you remember the word from 0 - 5 \n0: no memory at all | 5: remember clearly");
		
			//words.get(INDEXET).setDifficulty(noll till fem);
		//System.out.println("No words to practice, come back later \n");
	}
}