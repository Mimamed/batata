package mimo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class spelMenu extends JPanel
{
	
	static BufferedImage bakgrund;
	static JButton lessonButton = new JButton(), flashcardButton = new JButton(), readingButton = new JButton(), Button = new JButton(), menyButton = new JButton();
	
	
	spelMenu()
	{
		try
		{
			bakgrund = ImageIO.read(start.filer[1]);
		}catch(Exception e)
		{
			System.out.print("fel men uppladning");
		}
		
		this.setLayout(null);
		
		//addar grejer
		
		this.add(lessonButton);
		this.add(flashcardButton);
		this.add(readingButton);
		this.add(Button);
		this.add(menyButton);
		
		//sätter upp knapparna
		
		lessonButton.setBounds((int) Math.round(127 * start.widthSize), (int) Math.round(12 * start.heightSize), (int) Math.round(278 * start.widthSize), (int) Math.round(76 * start.heightSize));
		lessonButton.addActionListener(new knapp1());
		lessonButton.setContentAreaFilled(false);
		lessonButton.setBorderPainted(false);
		lessonButton.setFocusPainted(false);
		lessonButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		lessonButton.setText("Lessons");

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
		
		Button.setBounds((int) Math.round(963 * start.widthSize), (int) Math.round(12 * start.heightSize), (int) Math.round(278 * start.widthSize), (int) Math.round(76 * start.heightSize));
		Button.addActionListener(new knapp4());
		Button.setContentAreaFilled(false);
		Button.setBorderPainted(false);
		Button.setFocusPainted(false);
		Button.setFont(new Font("comic sans ms", Font.BOLD, 30));
		Button.setText("???");
		
		menyButton.setBounds((int) Math.round(10 * start.widthSize), (int) Math.round(10 * start.heightSize), (int) Math.round(80 * start.widthSize), (int) Math.round(80 * start.heightSize));
		menyButton.addActionListener(new knapp5());
		menyButton.setContentAreaFilled(false);
		menyButton.setBorderPainted(false);
		menyButton.setFocusPainted(false);
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(bakgrund, 0, 0, this.getWidth(), this.getHeight(), null);
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
}
