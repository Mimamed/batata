package mimo;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import mimo.tabMeny.lessonButton;
import mimo.tabMeny.flashcardButton;
import mimo.tabMeny.readingButton;
import mimo.tabMeny.button;
import mimo.tabMeny.menyButton;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class spelFlashkort extends JPanel {
	static BufferedImage pic;
	static JButton lessonButton = new JButton(), flashcardButton = new JButton(), readingButton = new JButton(), menyButton = new JButton(), wordlistButton = new JButton(), practiseButton = new JButton();
	
	
	spelFlashkort() 
	{
		try
		{
			pic = ImageIO.read(start.filer[2]);
		} catch (Exception e)
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
		
		//sätter upp knapparna
		lessonButton.setBounds((int) Math.round(127 * start.widthSize), (int) Math.round(12 * start.heightSize), (int) Math.round(371 * start.widthSize), (int) Math.round(76 * start.heightSize));
		lessonButton.addActionListener(new lessonButtonAct());
		lessonButton.setContentAreaFilled(start.synligaKnappar);
		lessonButton.setBorderPainted(start.synligaKnappar);
		lessonButton.setFocusPainted(start.synligaKnappar);
		lessonButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		lessonButton.setText("Lessons");
		
		//SKA HA RÖD BAKGRUND, LISTA UT SENARE.
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
		
		static class knapp5 implements ActionListener
		{
			
			public void actionPerformed(ActionEvent e)
			{
				start.Byta(start.flashkortspelen);
				flashcardsGame.answerButton.setText("Show meaning");
				flashcardsGame.exampleButton.setText("Show example");
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