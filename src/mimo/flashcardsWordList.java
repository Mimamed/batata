package mimo;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
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
	static JButton lessonButton = new JButton(), flashcardButton = new JButton(), readingButton = new JButton(), menyButton = new JButton(), addButton = new JButton("Add"), saveButton = new JButton("Save"), downButton = new JButton("v"), upButton = new JButton("^");
	JButton[] removeButton = new JButton[6], changeButton = new JButton[6];
	static JTextField ordF�ltetet = new JTextField(), �vers�ttningsF�llten = new JTextField();
	static JLabel[][] labelList = new JLabel[9][9];
	
	flashcardsWordList() 
	{
		try
		{
			pic = ImageIO.read(start.filer[5]);
		}catch (Exception e)
		{
			System.out.print("fel men uppladning5");
		}
		
		//Initierar och adderar in remove och change knapperna(f�r att de �r arrays)
		for(int i = 0; i < removeButton.length; i++)
		{
			removeButton[i] = new JButton("Remove");
			changeButton[i] = new JButton("Change");
			this.add(removeButton[i]);
			this.add(changeButton[i]);
		}
		
		
		this.setLayout(null);
		
		this.add(lessonButton);
		this.add(flashcardButton);
		this.add(readingButton);
		this.add(menyButton);
		this.add(addButton);
		this.add(saveButton);
		this.add(downButton);
		this.add(upButton);
		
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
		
		addButton.setBounds((int) Math.round(936 * start.widthSize), (int) Math.round(155 * start.heightSize), (int) Math.round(114 * start.widthSize), (int) Math.round(78 * start.heightSize));
		addButton.setFocusPainted(start.synligaKnappar);
		addButton.setFont(new Font("comic sans ms", Font.BOLD, 20));
		addButton.setBackground(new Color(start.ljusGr�[0], start.ljusGr�[1], start.ljusGr�[2]));
		
		saveButton.setBounds((int) Math.round(1050 * start.widthSize), (int) Math.round(155 * start.heightSize), (int) Math.round(114 * start.widthSize), (int) Math.round(78 * start.heightSize));
		saveButton.setBackground(new Color(start.ljusGr�[0], start.ljusGr�[1], start.ljusGr�[2]));
		saveButton.setFocusPainted(start.synligaKnappar);
		saveButton.setFont(new Font("comic sans ms", Font.BOLD, 20));
		
		downButton.setBounds((int) Math.round(1166 * start.widthSize), (int) Math.round(630 * start.heightSize), (int) Math.round(78 * start.widthSize), (int) Math.round(78 * start.heightSize));
		downButton.setBackground(new Color(start.ljusGr�[0], start.ljusGr�[1], start.ljusGr�[2]));
		downButton.setFocusPainted(start.synligaKnappar);
		downButton.setFont(new Font("comic sans ms", Font.BOLD, 20));
		
		
		upButton.setBounds((int) Math.round(1166 * start.widthSize), (int) Math.round(155 * start.heightSize), (int) Math.round(78 * start.widthSize), (int) Math.round(78 * start.heightSize));
		upButton.setBackground(new Color(start.ljusGr�[0], start.ljusGr�[1], start.ljusGr�[2]));
		upButton.setFocusPainted(start.synligaKnappar);
		upButton.setFont(new Font("comic sans ms", Font.BOLD, 20));
		
		
		
		//s�tter in array knapparna
		for(int i = 0; i < removeButton.length; i++)
		{
			removeButton[i].setBounds((int) Math.round(936 * start.widthSize), (int) Math.round((235 + 79 * i) * start.heightSize), (int) Math.round(114 * start.widthSize), (int) Math.round(78 * start.heightSize));
			removeButton[i].setBackground(new Color(start.ljusGr�[0], start.ljusGr�[1], start.ljusGr�[2]));
			removeButton[i].setFocusPainted(start.synligaKnappar);
			removeButton[i].setFont(new Font("comic sans ms", Font.BOLD, 20));
			
			
			changeButton[i].setBounds((int) Math.round(1050 * start.widthSize), (int) Math.round((235 + 79 * i) * start.heightSize), (int) Math.round(114 * start.widthSize), (int) Math.round(78 * start.heightSize));
			changeButton[i].setBackground(new Color(start.ljusGr�[0], start.ljusGr�[1], start.ljusGr�[2]));
			changeButton[i].setFocusPainted(start.synligaKnappar);
			changeButton[i].setFont(new Font("comic sans ms", Font.BOLD, 20));
		}
		
		
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
