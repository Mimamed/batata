package mimo;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import mimo.tabMeny.lessonButton;
import mimo.tabMeny.flashcardButton;
import mimo.tabMeny.readingButton;
import mimo.spelFlashkort.knapp1;
import mimo.spelFlashkort.knapp2;
import mimo.spelFlashkort.knapp3;
import mimo.spelFlashkort.knapp4;
import mimo.tabMeny.button;
import mimo.tabMeny.menyButton;

import java.util.List;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class readingMenu extends JPanel
{
	static JButton lessonButton = new JButton(), flashcardButton = new JButton(), readingButton = new JButton(), menyButton = new JButton(), wordlistButton = new JButton(), practiseButton = new JButton();
	static BufferedImage pic;
	
	readingMenu() 
	{
		try
		{
			pic = ImageIO.read(start.filer[4]);
		}catch (Exception e)
		{
			System.out.print("fel men uppladning");
		}
		
		this.setLayout(null);
		
		//addar grejer
		
		this.add(flashcardButton);
		this.add(readingButton);
		this.add(menyButton);
		this.add(practiseButton);
		this.add(wordlistButton);
		
		//s�tter upp knapparna
		
		lessonButton.setBounds((int) Math.round(127 * start.widthSize), (int) Math.round(12 * start.heightSize), (int) Math.round(278 * start.widthSize), (int) Math.round(76 * start.heightSize));
		lessonButton.addActionListener(new knapp1());
		lessonButton.setContentAreaFilled(start.synligaKnappar);
		lessonButton.setBorderPainted(start.synligaKnappar);
		lessonButton.setFocusPainted(start.synligaKnappar);
		lessonButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		lessonButton.setText("Lessons");
		
		//SKA HA R�D BAKGRUND, LISTA UT SENARE.
		flashcardButton.setBounds((int) Math.round(406 * start.widthSize), (int) Math.round(12 * start.heightSize), (int) Math.round(278 * start.widthSize), (int) Math.round(76 * start.heightSize));
		flashcardButton.addActionListener(new knapp2());
		flashcardButton.setContentAreaFilled(start.synligaKnappar);
		flashcardButton.setBorderPainted(start.synligaKnappar);
		flashcardButton.setFocusPainted(start.synligaKnappar);
		flashcardButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		flashcardButton.setText("Flashcards");
		
		readingButton.setBounds((int) Math.round(685 * start.widthSize), (int) Math.round(12 * start.heightSize), (int) Math.round(278 * start.widthSize), (int) Math.round(76 * start.heightSize));
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
				
			}
		}
}