package mimo;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import mimo.tabMeny.lessonButton;
import mimo.tabMeny.flashcardButton;
import mimo.tabMeny.readingButton;
import mimo.spelFlashkort.lessonButtonAct;
import mimo.flashcardsGame.returnButtonAct;
import mimo.spelFlashkort.flashcardButtonAct;
import mimo.spelFlashkort.readingButtonAct;
import mimo.spelFlashkort.menyButtonAct;
import mimo.tabMeny.button;
import mimo.tabMeny.menyButton;

import java.util.List;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.net.URI;

public class settingsMenu extends JPanel {
	static JButton lessonButton = new JButton(), flashcardButton = new JButton(), readingButton = new JButton(), menyButton = new JButton(), wordlistButton = new JButton(), practiseButton = new JButton(), donationButton = new JButton(), colorBlindModeButtonON = new JButton(), colorBlindModeButtonOFF = new JButton(), returnButton = new JButton();
	static JLabel colorBlindModeText = new JLabel();
	static BufferedImage pic;
	
	settingsMenu() {
		try
		{
			pic = ImageIO.read(start.filer[7]);
		} catch (Exception e)
		{
			System.out.print("fel men uppladning7");
		}
		
		this.setLayout(null);
		
		//addar grejer
		this.add(lessonButton);
		this.add(flashcardButton);
		this.add(readingButton);
		this.add(menyButton);
		this.add(practiseButton);
		this.add(wordlistButton);
		this.add(donationButton);
		this.add(colorBlindModeText);
		this.add(colorBlindModeButtonON);
		this.add(colorBlindModeButtonOFF);
		this.add(returnButton);
		
		//satter upp knapparna
		
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
		menyButton.addActionListener(new knapp4());
		menyButton.setContentAreaFilled(start.synligaKnappar);
		menyButton.setBorderPainted(start.synligaKnappar);
		menyButton.setFocusPainted(start.synligaKnappar);
		
		donationButton.setBounds((int) Math.round(499 * start.widthSize), (int) Math.round(574.5 * start.heightSize), (int) Math.round(370 * start.widthSize), (int) Math.round(77 * start.heightSize));
		donationButton.setContentAreaFilled(start.synligaKnappar);
		donationButton.setBorderPainted(start.synligaKnappar);
		donationButton.setFocusPainted(start.synligaKnappar);
		donationButton.addActionListener(new donationActionListener());
		donationButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		donationButton.setText("Donate");
		
		colorBlindModeText.setBounds((int) Math.round(499 * start.widthSize), (int) Math.round(455 * start.heightSize), (int) Math.round(272 * start.widthSize), (int) Math.round(77 * start.heightSize));
		colorBlindModeText.setAlignmentX(CENTER_ALIGNMENT);
		colorBlindModeText.setAlignmentY(CENTER_ALIGNMENT);
		colorBlindModeText.setHorizontalAlignment(JLabel.CENTER);
		colorBlindModeText.setVerticalAlignment(JLabel.CENTER);
		colorBlindModeText.setFont(new Font("comic sans ms", Font.BOLD, 30));
		colorBlindModeText.setText("Color blind mode");
		
		colorBlindModeButtonON.setBounds((int) Math.round(771 * start.widthSize), (int) Math.round(455 * start.heightSize), (int) Math.round(49 * start.widthSize), (int) Math.round(77 * start.heightSize));
		colorBlindModeButtonON.setFont(new Font("comic sans ms", Font.BOLD, 15));
		colorBlindModeButtonON.setText("On");
		colorBlindModeButtonON.addActionListener(new colorBlindModeONActionListener());
		
		colorBlindModeButtonOFF.setBounds((int) Math.round(820 * start.widthSize), (int) Math.round(455 * start.heightSize), (int) Math.round(48.5 * start.widthSize), (int) Math.round(77 * start.heightSize));
		colorBlindModeButtonOFF.setFont(new Font("comic sans ms", Font.BOLD, 15));
		colorBlindModeButtonOFF.setText("Off");
		colorBlindModeButtonOFF.addActionListener(new colorBlindModeOFFActionListener());
		
		returnButton.setBounds((int) Math.round(110 * start.widthSize), (int) Math.round(350 * start.heightSize), (int) Math.round(80 * start.widthSize), (int) Math.round(80 * start.heightSize));
		returnButton.addActionListener(new returnButtonAct());
		returnButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		returnButton.setText("<");
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
	
	static class donationActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try {
			Desktop d = Desktop.getDesktop();
			d.browse(new URI("https://www.patreon.com/Mimo_Official/creators"));
			}
			catch(Exception z){
				z.printStackTrace();
			}
		}
	}
	
	static class colorBlindModeONActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			/*try {
			flashcardsGame.pic = ImageIO.read(start.filerColorBlindMode[3]);
			flashcardsWordList.pic = ImageIO.read(start.filerColorBlindMode[5]);
			lessonTree.bakgrund = ImageIO.read(start.filerColorBlindMode[8]);
			readingGame.pic = ImageIO.read(start.filerColorBlindMode[6]);
			readingMenu.pic = ImageIO.read(start.filerColorBlindMode[4]);
			spelFlashkort.pic = ImageIO.read(start.filerColorBlindMode[2]);
			startMeny.pic = ImageIO.read(start.filerColorBlindMode[0]);
			tabMeny.bakgrund = ImageIO.read(start.filerColorBlindMode[1]);
			}
			catch(Exception l) {
				l.printStackTrace();
			}*/
		}
	}
	
	static class colorBlindModeOFFActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try {
			flashcardsGame.pic = ImageIO.read(start.filer[3]);
			flashcardsWordList.pic = ImageIO.read(start.filer[5]);
			lessonTree.bakgrund = ImageIO.read(start.filer[8]);
			readingGame.pic = ImageIO.read(start.filer[6]);
			readingMenu.pic = ImageIO.read(start.filer[4]);
			spelFlashkort.pic = ImageIO.read(start.filer[2]);
			startMeny.pic = ImageIO.read(start.filer[0]);
			tabMeny.bakgrund = ImageIO.read(start.filer[1]);
			}
			catch(Exception o) {
				o.printStackTrace();
			}
		}
	}
	
	static class returnButtonAct implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{	
			start.Byta(start.meny);
		}
	}
}
