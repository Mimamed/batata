package mimo;
//DETTA �R BARA F�R SJ�LVASTE KODEN, INTE F�NSTRET

import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import mimo.tabMeny.lessonButton;
import mimo.tabMeny.flashcardButton;
import mimo.tabMeny.readingButton;
import mimo.tabMeny.button;
import mimo.tabMeny.menyButton;

import java.util.List;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class spelFlashkort extends JPanel {
	//SKAPA LISTA, DATUM | ORD | �VERS�TTNING | SV�RIGHET
	static Scanner scan = new Scanner(System.in);
	static List<WordListClass> words = new ArrayList<WordListClass>();
	static BufferedImage pic;
	static JButton lessonButton = new JButton(), flashcardButton = new JButton(), readingButton = new JButton(), menyButton = new JButton(), wordlistButton = new JButton(), practiseButton = new JButton();
	
	
	spelFlashkort() 
	{
		
		try
		{
			pic = ImageIO.read(start.filer[2]);
		}catch (Exception e)
		{
			System.out.print("fel men uppladning2");
		}
		
		this.setLayout(null);
		
		//addar grejer
		
		this.add(lessonButton);
		this.add(flashcardButton);
		this.add(readingButton);
		this.add(menyButton);
		this.add(practiseButton);
		this.add(wordlistButton);
		
		//s�tter upp knapparna
		
		lessonButton.setBounds((int) Math.round(127 * start.widthSize), (int) Math.round(12 * start.heightSize), (int) Math.round(371 * start.widthSize), (int) Math.round(76 * start.heightSize));
		lessonButton.addActionListener(new knapp1());
		lessonButton.setContentAreaFilled(start.synligaKnappar);
		lessonButton.setBorderPainted(start.synligaKnappar);
		lessonButton.setFocusPainted(start.synligaKnappar);
		lessonButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		lessonButton.setText("Lessons");
		
		//SKA HA R�D BAKGRUND, LISTA UT SENARE.
		flashcardButton.setBounds((int) Math.round(499 * start.widthSize), (int) Math.round(12 * start.heightSize), (int) Math.round(370 * start.widthSize), (int) Math.round(76 * start.heightSize));
		flashcardButton.addActionListener(new knapp2());
		flashcardButton.setContentAreaFilled(start.synligaKnappar);
		flashcardButton.setBorderPainted(start.synligaKnappar);
		flashcardButton.setFocusPainted(start.synligaKnappar);
		flashcardButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		flashcardButton.setText("Flashcards");
		
		readingButton.setBounds((int) Math.round(870 * start.widthSize), (int) Math.round(12 * start.heightSize), (int) Math.round(370 * start.widthSize), (int) Math.round(76 * start.heightSize));
		readingButton.addActionListener(new knapp3());
		readingButton.setContentAreaFilled(start.synligaKnappar);
		readingButton.setBorderPainted(start.synligaKnappar);
		readingButton.setFocusPainted(start.synligaKnappar);
		readingButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		readingButton.setText("Reading");
		
		menyButton.setBounds((int) Math.round(10 * start.widthSize), (int) Math.round(10 * start.heightSize), (int) Math.round(80 * start.widthSize), (int) Math.round(80 * start.heightSize));
		menyButton.addActionListener(new knapp4());
		menyButton.setContentAreaFilled(start.synligaKnappar);
		menyButton.setBorderPainted(start.synligaKnappar);
		menyButton.setFocusPainted(start.synligaKnappar);
		
		practiseButton.setBounds((int) Math.round(360 * start.widthSize), (int) Math.round(531 * start.heightSize), (int) Math.round(294 * start.widthSize), (int) Math.round(107 * start.heightSize));
		practiseButton.addActionListener(new knapp5());
		practiseButton.setContentAreaFilled(start.synligaKnappar);
		practiseButton.setFocusPainted(start.synligaKnappar);
		practiseButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		practiseButton.setText("Practice");
		
		wordlistButton.setBounds((int) Math.round(710 * start.widthSize), (int) Math.round(531 * start.heightSize), (int) Math.round(295 * start.widthSize), (int) Math.round(107 * start.heightSize));
		wordlistButton.addActionListener(new knapp6());
		wordlistButton.setContentAreaFilled(start.synligaKnappar);
		wordlistButton.setFocusPainted(start.synligaKnappar);
		wordlistButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		wordlistButton.setText("Word list");
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
				start.Byta(start.flashkortspelen);
			}
		}
		
		static class knapp6 implements ActionListener
		{
			
			public void actionPerformed(ActionEvent e)
			{
				start.Byta(start.fkOrdlista);
			}
		}
}