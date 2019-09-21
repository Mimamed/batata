package mimo;
//DETTA ÄR BARA FÖR SJÄLVASTE KODEN, INTE FÖNSTRET

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
	//SKAPA LISTA, DATUM | ORD | ÖVERSÄTTNING | SVÅRIGHET
	static Scanner scan = new Scanner(System.in);
	static List<WordListClass> words = new ArrayList<WordListClass>();
	static BufferedImage pic;
	static JButton lessonButton = new JButton(), flashcardButton = new JButton(), readingButton = new JButton(), listeningButton = new JButton(), menyButton = new JButton(), practiceButton = new JButton(), wordListButton = new JButton();
	
	spelFlashkort() 
	{
		
		try
		{
			pic = ImageIO.read(start.filer[2]);
		}catch (Exception e)
		{
			System.out.print("fel men uppladning");
		}
		
		this.setLayout(null);
		
		//addar grejer
		
		this.add(lessonButton);
		this.add(flashcardButton);
		this.add(readingButton);
		this.add(listeningButton);
		this.add(menyButton);
		this.add(practiceButton);
		this.add(wordListButton);
		
		//sätter upp knapparna
		
		lessonButton.setBounds((int) Math.round(127 * start.widthSize), (int) Math.round(12 * start.heightSize), (int) Math.round(278 * start.widthSize), (int) Math.round(76 * start.heightSize));
		lessonButton.addActionListener(new knapp1());
		lessonButton.setContentAreaFilled(false);
		lessonButton.setBorderPainted(false);
		lessonButton.setFocusPainted(false);
		lessonButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		lessonButton.setText("Lessons");
		
		//SKA HA RÖD BAKGRUND, LISTA UT SENARE.
		flashcardButton.setBounds((int) Math.round(406 * start.widthSize), (int) Math.round(12 * start.heightSize), (int) Math.round(278 * start.widthSize), (int) Math.round(76 * start.heightSize));
		flashcardButton.addActionListener(new knapp2());
		flashcardButton.setContentAreaFilled(false);
		flashcardButton.setBorderPainted(false);
		flashcardButton.setFocusPainted(false);
		flashcardButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		flashcardButton.setText("Flashcards");
		
		readingButton.setBounds((int) Math.round(685 * start.widthSize), (int) Math.round(12 * start.heightSize), (int) Math.round(278 * start.widthSize), (int) Math.round(76 * start.heightSize));
		readingButton.addActionListener(new knapp3());
		readingButton.setContentAreaFilled(false);
		readingButton.setBorderPainted(false);
		readingButton.setFocusPainted(false);
		readingButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		readingButton.setText("Reading");
		
		listeningButton.setBounds((int) Math.round(963 * start.widthSize), (int) Math.round(12 * start.heightSize), (int) Math.round(278 * start.widthSize), (int) Math.round(76 * start.heightSize));
		listeningButton.addActionListener(new knapp4());
		listeningButton.setContentAreaFilled(false);
		listeningButton.setBorderPainted(false);
		listeningButton.setFocusPainted(false);
		listeningButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		listeningButton.setText("Listening");
		
		menyButton.setBounds((int) Math.round(10 * start.widthSize), (int) Math.round(10 * start.heightSize), (int) Math.round(80 * start.widthSize), (int) Math.round(80 * start.heightSize));
		menyButton.addActionListener(new knapp5());
		menyButton.setContentAreaFilled(false);
		menyButton.setBorderPainted(false);
		menyButton.setFocusPainted(false);
		
		practiceButton.setBounds((int) Math.round(360 * start.widthSize), (int) Math.round(531 * start.heightSize), (int) Math.round(294 * start.widthSize), (int) Math.round(107 * start.heightSize));
		practiceButton.addActionListener(new knapp6());
		practiceButton.setContentAreaFilled(true);
		practiceButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		practiceButton.setText("Practice");
		
		wordListButton.setBounds((int) Math.round(710 * start.widthSize), (int) Math.round(531 * start.heightSize), (int) Math.round(294 * start.widthSize), (int) Math.round(107 * start.heightSize));
		wordListButton.addActionListener(new knapp6());
		wordListButton.setContentAreaFilled(true);
		wordListButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		wordListButton.setText("Word list");
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
				
			}
		}

		static class knapp4 implements ActionListener
		{
			
			public void actionPerformed(ActionEvent e)
			{
			}
		}

		static class knapp5 implements ActionListener
		{
			
			public void actionPerformed(ActionEvent e)
			{
				start.Byta(start.meny);
			}
		}
		
		static class knapp6 implements ActionListener
		{
			
			public void actionPerformed(ActionEvent e)
			{
			}
		}
		
		static class knapp7 implements ActionListener
		{
			
			public void actionPerformed(ActionEvent e)
			{
			}
		}
}