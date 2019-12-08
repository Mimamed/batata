package mimo;

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
import mimo.spelFlashkort.readingButtonAct;//jj
import mimo.spelFlashkort.menyButtonAct;
import mimo.tabMeny.button;
import mimo.tabMeny.menyButton;
//-jaf dum
import java.util.List;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class readingMenu extends JPanel
{
	static boolean alreadyRead1, alreadyRead2, alreadyRead3, alreadyRead4, alreadyRead5 = false;
	
	static JButton lessonButton = new JButton(), flashcardButton = new JButton(), readingButton = new JButton(), menyButton = new JButton(), title1Button = new JButton(), title2Button = new JButton(), title3Button = new JButton(), title4Button = new JButton(), title5Button = new JButton(), title6Button = new JButton(), readOrNot1 = new JButton(), readOrNot2 = new JButton(), readOrNot3 = new JButton(), readOrNot4 = new JButton(), readOrNot5 = new JButton(), readOrNot6 = new JButton();
	static JLabel titleText = new JLabel(), readOrNotText = new JLabel(), difficulty1Text = new JLabel(), difficulty2Text = new JLabel(), difficulty3Text = new JLabel(), difficulty4Text = new JLabel(), difficulty5Text = new JLabel(), difficulty6Text = new JLabel();
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
		this.add(lessonButton);
		this.add(flashcardButton);
		this.add(readingButton);
		this.add(menyButton);
		this.add(titleText);
		this.add(title1Button);
		this.add(title2Button);
		this.add(title3Button);
		this.add(title4Button);
		this.add(title5Button);
		this.add(title6Button);
		this.add(readOrNotText);
		this.add(readOrNot1);
		this.add(readOrNot2);
		this.add(readOrNot3);
		this.add(readOrNot4);
		this.add(readOrNot5);
		this.add(readOrNot6);
		this.add(difficulty1Text);
		this.add(difficulty2Text);
		this.add(difficulty3Text);
		this.add(difficulty4Text);
		this.add(difficulty5Text);
		this.add(difficulty6Text);
		
		//sätter upp knapparna
		
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
		
		titleText.setBounds((int) Math.round(199 * start.widthSize), (int) Math.round(154 * start.heightSize), (int) Math.round(330 * start.widthSize), (int) Math.round(79 * start.heightSize));
		titleText.setAlignmentX(CENTER_ALIGNMENT);
		titleText.setAlignmentY(CENTER_ALIGNMENT);
		titleText.setHorizontalAlignment(JLabel.CENTER);
		titleText.setVerticalAlignment(JLabel.CENTER);
		titleText.setFont(new Font("comic sans ms", Font.BOLD, 30));
		titleText.setText("Title");
		
		title1Button.setBounds((int) Math.round(199 * start.widthSize), (int) Math.round(234 * start.heightSize), (int) Math.round(330 * start.widthSize), (int) Math.round(79 * start.heightSize));
		title1Button.addActionListener(new title1ButtonAct());
		title1Button.setAlignmentX(CENTER_ALIGNMENT);
		title1Button.setAlignmentY(CENTER_ALIGNMENT);
		title1Button.setHorizontalAlignment(JLabel.CENTER);
		title1Button.setVerticalAlignment(JLabel.CENTER);
		title1Button.setContentAreaFilled(start.synligaKnappar);
		title1Button.setBorderPainted(start.synligaKnappar);
		title1Button.setFocusPainted(start.synligaKnappar);
		title1Button.setFont(new Font("comic sans ms", Font.BOLD, 30));
		title1Button.setText("Favorite animal");
		
		title2Button.setBounds((int) Math.round(199 * start.widthSize), (int) Math.round(313.5 * start.heightSize), (int) Math.round(330 * start.widthSize), (int) Math.round(79 * start.heightSize));
		title2Button.addActionListener(new title2ButtonAct());
		title2Button.setAlignmentX(CENTER_ALIGNMENT);
		title2Button.setAlignmentY(CENTER_ALIGNMENT);
		title2Button.setHorizontalAlignment(JLabel.CENTER);
		title2Button.setVerticalAlignment(JLabel.CENTER);
		title2Button.setContentAreaFilled(start.synligaKnappar);
		title2Button.setBorderPainted(start.synligaKnappar);
		title2Button.setFocusPainted(start.synligaKnappar);
		title2Button.setFont(new Font("comic sans ms", Font.BOLD, 30));
		title2Button.setText("Glenn in Gothenburg");
		
		title3Button.setBounds((int) Math.round(199 * start.widthSize), (int) Math.round(393 * start.heightSize), (int) Math.round(330 * start.widthSize), (int) Math.round(79 * start.heightSize));
		title3Button.addActionListener(new title3ButtonAct());
		title3Button.setAlignmentX(CENTER_ALIGNMENT);
		title3Button.setAlignmentY(CENTER_ALIGNMENT);
		title3Button.setHorizontalAlignment(JLabel.CENTER);
		title3Button.setVerticalAlignment(JLabel.CENTER);
		title3Button.setContentAreaFilled(start.synligaKnappar);
		title3Button.setBorderPainted(start.synligaKnappar);
		title3Button.setFocusPainted(start.synligaKnappar);
		title3Button.setFont(new Font("comic sans ms", Font.BOLD, 30));
		title3Button.setText("Well done..");
		
		title4Button.setBounds((int) Math.round(199 * start.widthSize), (int) Math.round(473 * start.heightSize), (int) Math.round(330 * start.widthSize), (int) Math.round(79 * start.heightSize));
		title4Button.addActionListener(new title4ButtonAct());
		title4Button.setAlignmentX(CENTER_ALIGNMENT);
		title4Button.setAlignmentY(CENTER_ALIGNMENT);
		title4Button.setHorizontalAlignment(JLabel.CENTER);
		title4Button.setVerticalAlignment(JLabel.CENTER);
		title4Button.setContentAreaFilled(start.synligaKnappar);
		title4Button.setBorderPainted(start.synligaKnappar);
		title4Button.setFocusPainted(start.synligaKnappar);
		title4Button.setFont(new Font("comic sans ms", Font.BOLD, 30));
		title4Button.setText("Cheating");
		
		title5Button.setBounds((int) Math.round(199 * start.widthSize), (int) Math.round(552.5 * start.heightSize), (int) Math.round(330 * start.widthSize), (int) Math.round(79 * start.heightSize));
		title5Button.addActionListener(new title5ButtonAct());
		title5Button.setAlignmentX(CENTER_ALIGNMENT);
		title5Button.setAlignmentY(CENTER_ALIGNMENT);
		title5Button.setHorizontalAlignment(JLabel.CENTER);
		title5Button.setVerticalAlignment(JLabel.CENTER);
		title5Button.setContentAreaFilled(start.synligaKnappar);
		title5Button.setBorderPainted(start.synligaKnappar);
		title5Button.setFocusPainted(start.synligaKnappar);
		title5Button.setFont(new Font("comic sans ms", Font.BOLD, 30));
		title5Button.setText("Give up");
		
		readOrNotText.setBounds((int) Math.round(1012 * start.widthSize), (int) Math.round(154 * start.heightSize), (int) Math.round(153 * start.widthSize), (int) Math.round(79 * start.heightSize));
		readOrNotText.setAlignmentX(CENTER_ALIGNMENT);
		readOrNotText.setAlignmentY(CENTER_ALIGNMENT);
		readOrNotText.setHorizontalAlignment(JLabel.CENTER);
		readOrNotText.setVerticalAlignment(JLabel.CENTER);
		readOrNotText.setFont(new Font("comic sans ms", Font.BOLD, 30));
		readOrNotText.setText("Mark as read");
		
		readOrNot1.setBounds((int) Math.round(1012 * start.widthSize), (int) Math.round(234 * start.heightSize), (int) Math.round(153 * start.widthSize), (int) Math.round(79 * start.heightSize));
		readOrNot1.setAlignmentX(CENTER_ALIGNMENT);
		readOrNot1.setAlignmentY(CENTER_ALIGNMENT);
		readOrNot1.setHorizontalAlignment(JLabel.CENTER);
		readOrNot1.setVerticalAlignment(JLabel.CENTER);
		readOrNot1.setFont(new Font("comic sans ms", Font.BOLD, 30));
		readOrNot1.setText("read?");
		readOrNot1.addActionListener(new readOrNot1Act());
		
		readOrNot2.setBounds((int) Math.round(1012 * start.widthSize), (int) Math.round(313.5 * start.heightSize), (int) Math.round(153 * start.widthSize), (int) Math.round(79 * start.heightSize));
		readOrNot2.setAlignmentX(CENTER_ALIGNMENT);
		readOrNot2.setAlignmentY(CENTER_ALIGNMENT);
		readOrNot2.setHorizontalAlignment(JLabel.CENTER);
		readOrNot2.setVerticalAlignment(JLabel.CENTER);
		readOrNot2.setFont(new Font("comic sans ms", Font.BOLD, 30));
		readOrNot2.setText("read?");
		readOrNot2.addActionListener(new readOrNot2Act());

		readOrNot3.setBounds((int) Math.round(1012 * start.widthSize), (int) Math.round(393 * start.heightSize), (int) Math.round(153 * start.widthSize), (int) Math.round(79 * start.heightSize));
		readOrNot3.setAlignmentX(CENTER_ALIGNMENT);
		readOrNot3.setAlignmentY(CENTER_ALIGNMENT);
		readOrNot3.setHorizontalAlignment(JLabel.CENTER);
		readOrNot3.setVerticalAlignment(JLabel.CENTER);
		readOrNot3.setFont(new Font("comic sans ms", Font.BOLD, 30));
		readOrNot3.setText("read?");
		readOrNot3.addActionListener(new readOrNot3Act());
		
		readOrNot4.setBounds((int) Math.round(1012 * start.widthSize), (int) Math.round(473 * start.heightSize), (int) Math.round(153 * start.widthSize), (int) Math.round(79 * start.heightSize));
		readOrNot4.setAlignmentX(CENTER_ALIGNMENT);
		readOrNot4.setAlignmentY(CENTER_ALIGNMENT);
		readOrNot4.setHorizontalAlignment(JLabel.CENTER);
		readOrNot4.setVerticalAlignment(JLabel.CENTER);
		readOrNot4.setFont(new Font("comic sans ms", Font.BOLD, 30));
		readOrNot4.setText("read?");
		readOrNot4.addActionListener(new readOrNot4Act());
		
		readOrNot5.setBounds((int) Math.round(1012 * start.widthSize), (int) Math.round(552.5 * start.heightSize), (int) Math.round(153 * start.widthSize), (int) Math.round(79 * start.heightSize));
		readOrNot5.setAlignmentX(CENTER_ALIGNMENT);
		readOrNot5.setAlignmentY(CENTER_ALIGNMENT);
		readOrNot5.setHorizontalAlignment(JLabel.CENTER);
		readOrNot5.setVerticalAlignment(JLabel.CENTER);
		readOrNot5.setFont(new Font("comic sans ms", Font.BOLD, 30));
		readOrNot5.setText("read?");
		readOrNot5.addActionListener(new readOrNot5Act());
		
		difficulty1Text.setBounds((int) Math.round(529 * start.widthSize), (int) Math.round(154 * start.heightSize), (int) Math.round(153 * start.widthSize), (int) Math.round(79 * start.heightSize));
		difficulty1Text.setAlignmentX(CENTER_ALIGNMENT);
		difficulty1Text.setAlignmentY(CENTER_ALIGNMENT);
		difficulty1Text.setHorizontalAlignment(JLabel.CENTER);
		difficulty1Text.setVerticalAlignment(JLabel.CENTER);
		difficulty1Text.setFont(new Font("comic sans ms", Font.BOLD, 30));
		difficulty1Text.setText("Difficulty");
		
		difficulty2Text.setBounds((int) Math.round(529 * start.widthSize), (int) Math.round(234 * start.heightSize), (int) Math.round(153 * start.widthSize), (int) Math.round(79 * start.heightSize));
		difficulty2Text.setAlignmentX(CENTER_ALIGNMENT);
		difficulty2Text.setAlignmentY(CENTER_ALIGNMENT);
		difficulty2Text.setHorizontalAlignment(JLabel.CENTER);
		difficulty2Text.setVerticalAlignment(JLabel.CENTER);
		difficulty2Text.setFont(new Font("comic sans ms", Font.BOLD, 30));
		difficulty2Text.setText("Beginner");
		
		difficulty3Text.setBounds((int) Math.round(529 * start.widthSize), (int) Math.round(313.5 * start.heightSize), (int) Math.round(153 * start.widthSize), (int) Math.round(79 * start.heightSize));
		difficulty3Text.setAlignmentX(CENTER_ALIGNMENT);
		difficulty3Text.setAlignmentY(CENTER_ALIGNMENT);
		difficulty3Text.setHorizontalAlignment(JLabel.CENTER);
		difficulty3Text.setVerticalAlignment(JLabel.CENTER);
		difficulty3Text.setFont(new Font("comic sans ms", Font.BOLD, 30));
		difficulty3Text.setText("Beginner");
		
		difficulty4Text.setBounds((int) Math.round(529 * start.widthSize), (int) Math.round(393 * start.heightSize), (int) Math.round(153 * start.widthSize), (int) Math.round(79 * start.heightSize));
		difficulty4Text.setAlignmentX(CENTER_ALIGNMENT);
		difficulty4Text.setAlignmentY(CENTER_ALIGNMENT);
		difficulty4Text.setHorizontalAlignment(JLabel.CENTER);
		difficulty4Text.setVerticalAlignment(JLabel.CENTER);
		difficulty4Text.setFont(new Font("comic sans ms", Font.BOLD, 30));
		difficulty4Text.setText("Intermediate");
		
		difficulty5Text.setBounds((int) Math.round(529 * start.widthSize), (int) Math.round(473 * start.heightSize), (int) Math.round(153 * start.widthSize), (int) Math.round(79 * start.heightSize));
		difficulty5Text.setAlignmentX(CENTER_ALIGNMENT);
		difficulty5Text.setAlignmentY(CENTER_ALIGNMENT);
		difficulty5Text.setHorizontalAlignment(JLabel.CENTER);
		difficulty5Text.setVerticalAlignment(JLabel.CENTER);
		difficulty5Text.setFont(new Font("comic sans ms", Font.BOLD, 30));
		difficulty5Text.setText("Professional");
		
		difficulty6Text.setBounds((int) Math.round(529 * start.widthSize), (int) Math.round(552.5 * start.heightSize), (int) Math.round(153 * start.widthSize), (int) Math.round(79 * start.heightSize));
		difficulty6Text.setAlignmentX(CENTER_ALIGNMENT);
		difficulty6Text.setAlignmentY(CENTER_ALIGNMENT);
		difficulty6Text.setHorizontalAlignment(JLabel.CENTER);
		difficulty6Text.setVerticalAlignment(JLabel.CENTER);
		difficulty6Text.setFont(new Font("comic sans ms", Font.BOLD, 30));
		difficulty6Text.setText("Professional");
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
		
		}
	}

	static class menyButtonAct implements ActionListener
	{
	
		public void actionPerformed(ActionEvent e)
		{
			start.Byta(start.meny);
		}
	}
	
	static class title1ButtonAct implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			readingGame.textArea.setText(readingGame.books.get(0));
			start.Byta(start.readingSpel);
			readingGame.whichBook = 0;
		}
	}
	
	static class title2ButtonAct implements ActionListener
	{
	
		public void actionPerformed(ActionEvent e)
		{
			readingGame.textArea.setText(readingGame.books.get(1));
			start.Byta(start.readingSpel);
			readingGame.whichBook = 1;
		}
	}
	
	static class title3ButtonAct implements ActionListener
	{
	
		public void actionPerformed(ActionEvent e)
		{
			readingGame.textArea.setText(readingGame.books.get(2));
			start.Byta(start.readingSpel);
			readingGame.whichBook = 2;
		}
	}
	
	static class title4ButtonAct implements ActionListener
	{
	
		public void actionPerformed(ActionEvent e)
		{
			readingGame.textArea.setText(readingGame.books.get(3));
			start.Byta(start.readingSpel);
			readingGame.whichBook = 3;
		}
	}
	
	static class title5ButtonAct implements ActionListener
	{
	
		public void actionPerformed(ActionEvent e)
		{
			readingGame.textArea.setText(readingGame.books.get(4));
			start.Byta(start.readingSpel);
			readingGame.whichBook = 4;
		}
	}
	
	static class readOrNot1Act implements ActionListener
	{
	
		public void actionPerformed(ActionEvent e)
		{
			if(alreadyRead1)
			{
				readOrNot1.setBackground(null);
				readOrNot1.setText("read?");
				alreadyRead1 = false;
			}
			else
			{
				readOrNot1.setBackground(new java.awt.Color(140,198,63));
				readOrNot1.setText("read");
				alreadyRead1 = true;
			}
		}
	}
	
	static class readOrNot2Act implements ActionListener
	{
	
		public void actionPerformed(ActionEvent e)
		{
			if(alreadyRead2)
			{
				readOrNot2.setBackground(null);
				readOrNot2.setText("read?");
				alreadyRead2 = false;
			}
			else
			{
				readOrNot2.setBackground(new java.awt.Color(140,198,63));
				readOrNot2.setText("read");
				alreadyRead2 = true;
			}
		}
	}

	static class readOrNot3Act implements ActionListener
	{
	
		public void actionPerformed(ActionEvent e)
		{
			if(alreadyRead3)
			{
				readOrNot3.setBackground(null);
				readOrNot3.setText("read?");
				alreadyRead3 = false;
			}
			else
			{
				readOrNot3.setBackground(new java.awt.Color(140,198,63));
				readOrNot3.setText("read");
				alreadyRead3 = true;
			}
		}
	}

	static class readOrNot4Act implements ActionListener
	{
	
		public void actionPerformed(ActionEvent e)
		{
			if(alreadyRead4)
			{
				readOrNot4.setBackground(null);
				readOrNot4.setText("read?");
				alreadyRead4 = false;
			}
			else
			{
				readOrNot4.setBackground(new java.awt.Color(140,198,63));
				readOrNot4.setText("read");
				alreadyRead4 = true;
			}
		}
	}

	static class readOrNot5Act implements ActionListener
	{
	
		public void actionPerformed(ActionEvent e)
		{
			if(alreadyRead5)
			{
				readOrNot5.setBackground(null);
				readOrNot5.setText("read?");
				alreadyRead5 = false;
			}
			else
			{
				readOrNot5.setBackground(new java.awt.Color(140,198,63));
				readOrNot5.setText("read");
				alreadyRead5 = true;
			}
		}
	}
}
