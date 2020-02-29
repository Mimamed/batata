package mimo;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class lPhrases extends JPanel {
	static BufferedImage bakgrund;
	static JButton lessonButton = new JButton(), flashcardButton = new JButton(), readingButton = new JButton(), menyButton = new JButton(), startL1Button = new JButton(), startL2Button = new JButton();
	
	lPhrases()
	{
		try
		{
			bakgrund = ImageIO.read(start.filer[12]);
		}catch(Exception e)
		{
			System.out.print("fel men uppladning");
		}
		
		this.setLayout(null);
		
		//addar grejer
		
		this.add(lessonButton);
		this.add(flashcardButton);
		this.add(readingButton);
		this.add(menyButton);
		this.add(startL1Button);
		this.add(startL2Button);
		
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
		
		startL1Button.setBounds((int) Math.round(652 * start.widthSize), (int) Math.round(241 * start.heightSize), (int) Math.round(87 * start.widthSize), (int) Math.round(56 * start.heightSize));
		startL1Button.addActionListener(new startL1ButtonAct());
		startL1Button.setContentAreaFilled(start.synligaKnappar);
		startL1Button.setBorderPainted(start.synligaKnappar);
		startL1Button.setFocusPainted(start.synligaKnappar);
		startL1Button.setFont(new Font("comic sans ms", Font.BOLD, 20));
		startL1Button.setText("Start");
		
		startL2Button.setBounds((int) Math.round(652 * start.widthSize), (int) Math.round(430 * start.heightSize), (int) Math.round(87 * start.widthSize), (int) Math.round(56 * start.heightSize));
		startL2Button.addActionListener(new startL2ButtonAct());
		startL2Button.setContentAreaFilled(start.synligaKnappar);
		startL2Button.setBorderPainted(start.synligaKnappar);
		startL2Button.setFocusPainted(start.synligaKnappar);
		startL2Button.setFont(new Font("comic sans ms", Font.BOLD, 20));
		startL2Button.setText("Start");
	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(bakgrund, 0, 0, this.getWidth(), this.getHeight(), null);
	}
	
	static class lessonButton implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			start.Byta(start.lektionTrad);
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
	
	static class startL1ButtonAct implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			lPhrasesL1.l1RandomSentence();
			start.Byta(start.lektionFraserL1);
		}
	}
	
	static class startL2ButtonAct implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			lPhrasesL2.l2RandomSentence();
			start.Byta(start.lektionFraserL2);
		}
	}
}
