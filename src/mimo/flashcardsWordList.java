package mimo;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mimo.tabMeny.lessonButton;
import mimo.tabMeny.flashcardButton;
import mimo.tabMeny.readingButton;
import mimo.flashcardsGame.lessonButtonAct;
import mimo.flashcardsGame.flashcardButtonAct;
import mimo.flashcardsGame.readingButtonAct;
import mimo.spelFlashkort.menyButtonAct;
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

public class flashcardsWordList extends JPanel {
	static BufferedImage pic;
	static JButton lessonButton = new JButton(), flashcardButton = new JButton(), readingButton = new JButton(), menyButton = new JButton(), addButton = new JButton();
	static JTextField ordF�ltetet = new JTextField(), �vers�ttningsF�llten = new JTextField();
	
	flashcardsWordList() 
	{
		try
		{
			pic = ImageIO.read(start.filer[5]);
		}catch (Exception e)
		{
			System.out.print("fel men uppladning5");
		}
		
		this.setLayout(null);
		
		this.add(lessonButton);
		this.add(flashcardButton);
		this.add(readingButton);
		this.add(menyButton);
		
		//Fixar kanpparna nedan DE SKITER TILL SIG
		lessonButton.setBounds((int) Math.round(127 * start.widthSize), (int) Math.round(12 * start.heightSize), (int) Math.round(371 * start.widthSize), (int) Math.round(76 * start.heightSize));
		lessonButton.addActionListener(new lessonButtonAct());
		lessonButton.setContentAreaFilled(start.synligaKnappar);
		lessonButton.setBorderPainted(start.synligaKnappar);
		lessonButton.setFocusPainted(start.synligaKnappar);
		lessonButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		lessonButton.setText("Lessons");
		
		//SKA HA R�D BAKGRUND, LISTA UT SENARE.
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
		menyButton.addActionListener(new menyButton());
		menyButton.setContentAreaFilled(start.synligaKnappar);
		menyButton.setBorderPainted(start.synligaKnappar);
		menyButton.setFocusPainted(start.synligaKnappar);
		
		
		
		//Fixar Text F�ltena
		this.add(ordF�ltetet);
		ordF�ltetet.setBounds((int) Math.round(200 * start.widthSize), (int) Math.round(155 * start.heightSize), (int) Math.round(366 * start.widthSize), (int) Math.round(78 * start.heightSize));
		ordF�ltetet.setEditable(true);
		ordF�ltetet.setFont(new Font("comic sans ms", Font.BOLD, 30));
		ordF�ltetet.setHorizontalAlignment(WIDTH/2);
		ordF�ltetet.setBorder(null);
		ordF�ltetet.setBackground(new Color(77, 77, 77));//kkk
		
		this.add(�vers�ttningsF�llten);
		�vers�ttningsF�llten.setBounds((int) Math.round(568 * start.widthSize), (int) Math.round(155 * start.heightSize), (int) Math.round(366 * start.widthSize), (int) Math.round(78 * start.heightSize));
		�vers�ttningsF�llten.setBorder(null);
		�vers�ttningsF�llten.setBackground(new Color(77, 77, 77));
		�vers�ttningsF�llten.setHorizontalAlignment(WIDTH/2);
		�vers�ttningsF�llten.setFont(new Font("comic sans ms", Font.BOLD, 30));
		//�vers�ttnings
		}
		
	public void paintComponent(Graphics g)
	{
		g.drawImage(pic, 0, 0, this.getWidth(), this.getHeight(), null);
	}
	
	static class menyButton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			start.Byta(start.meny);
		}
	}
}
