package mimo;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
import mimo.flashcardsGame.returnButtonAct;
import mimo.spelFlashkort.menyButtonAct;
import mimo.tabMeny.button;
import mimo.tabMeny.menyButton;

import java.util.List;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class flashcardsWordList extends JPanel {
	static int antalOrd;
	static BufferedImage pic;
	static JButton lessonButton = new JButton(), flashcardButton = new JButton(), readingButton = new JButton(), menyButton = new JButton(), addButton = new JButton("Add"), saveButton = new JButton("Save"), downButton = new JButton("v"), upButton = new JButton("^"), returnButton = new JButton();
	JButton[] removeButton = new JButton[6], changeButton = new JButton[6];
	static JTextField ordFältetet = new JTextField(), översättningsFällten = new JTextField();
	static JLabel[][] labelList = new JLabel[2][6];
	
	flashcardsWordList() 
	{
		JButton test = new JButton();
		this.add(test);
		test.setBounds((int) Math.round(199.8 * start.widthSize), (int) Math.round((235 + 79.5 * 1) * start.heightSize), (int) Math.round(364 * start.widthSize), (int) Math.round(78 * start.heightSize));
		
		try
		{
			pic = ImageIO.read(start.filer[5]);
		}catch (Exception e)
		{
			System.out.print("fel men uppladning5");
		}
		
		
		//Initierar och adderar in remove och change knapperna(för att de är arrays)** la till labelList
		for(int i = 0; i < removeButton.length; i++)
		{
			
			removeButton[i] = new JButton("Remove");
			changeButton[i] = new JButton("Change");
			labelList[0][i] = new JLabel();
			labelList[1][i] = new JLabel();
			labelList[0][i].setFont(new Font("comic sans ms", Font.BOLD, 30));
			labelList[1][i].setFont(new Font("comic sans ms", Font.BOLD, 30));
			this.add(labelList[0][i]);
			this.add(labelList[1][i]);
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
		this.add(returnButton);
		
		//Fixar kanpparna nedan DE SKITER TILL SIG
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
		menyButton.addActionListener(new menyButton());
		menyButton.setContentAreaFilled(start.synligaKnappar);
		menyButton.setBorderPainted(start.synligaKnappar);
		menyButton.setFocusPainted(start.synligaKnappar);
		
		addButton.setBounds((int) Math.round(936 * start.widthSize), (int) Math.round(155 * start.heightSize), (int) Math.round(114 * start.widthSize), (int) Math.round(78 * start.heightSize));
		addButton.setFocusPainted(start.synligaKnappar);
		addButton.setFont(new Font("comic sans ms", Font.BOLD, 20));
		addButton.setBackground(new Color(start.ljusGrå[0], start.ljusGrå[1], start.ljusGrå[2]));
		
		saveButton.setBounds((int) Math.round(1050 * start.widthSize), (int) Math.round(155 * start.heightSize), (int) Math.round(114 * start.widthSize), (int) Math.round(78 * start.heightSize));
		saveButton.setBackground(new Color(start.ljusGrå[0], start.ljusGrå[1], start.ljusGrå[2]));
		saveButton.setFocusPainted(start.synligaKnappar);
		saveButton.setFont(new Font("comic sans ms", Font.BOLD, 20));
		
		downButton.setBounds((int) Math.round(1166 * start.widthSize), (int) Math.round(633 * start.heightSize), (int) Math.round(78 * start.widthSize), (int) Math.round(78 * start.heightSize));
		downButton.setBackground(new Color(start.ljusGrå[0], start.ljusGrå[1], start.ljusGrå[2]));
		downButton.setFocusPainted(start.synligaKnappar);
		downButton.setFont(new Font("comic sans ms", Font.BOLD, 20));
		
		returnButton.setBounds((int) Math.round(110 * start.widthSize), (int) Math.round(350 * start.heightSize), (int) Math.round(80 * start.widthSize), (int) Math.round(80 * start.heightSize));
		returnButton.addActionListener(new returnButtonAct());
		returnButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		returnButton.setText("<");
		
		try {
		    Image img = ImageIO.read(getClass().getResource("/Bilder/greenArrowUp.png"));
		    downButton.setIcon(new ImageIcon(img));
		  } catch (Exception e) {
		    System.out.println(e);
		  }
		
		upButton.setBounds((int) Math.round(1166 * start.widthSize), (int) Math.round(155 * start.heightSize), (int) Math.round(78 * start.widthSize), (int) Math.round(78 * start.heightSize));
		upButton.setBackground(new Color(start.ljusGrå[0], start.ljusGrå[1], start.ljusGrå[2]));
		upButton.setFocusPainted(start.synligaKnappar);
		upButton.setFont(new Font("comic sans ms", Font.BOLD, 20));
		try {
		    Image img = ImageIO.read(getClass().getResource("/Bilder/greenArrowDown.png"));
		    upButton.setIcon(new ImageIcon(img));
		  } catch (Exception e) {
		    System.out.println(e);
		  }
		
		//sätter in array knapparna
		for(int i = 0; i < removeButton.length; i++)
		{
			labelList[0][i].setBounds((int) Math.round(577.8 * start.widthSize), (int) Math.round((235 + 79.5 * i) * start.heightSize), (int) Math.round(364 * start.widthSize), (int) Math.round(78 * start.heightSize));
			labelList[1][i].setBounds((int) Math.round(209.8 * start.widthSize), (int) Math.round((235 + 79.5 * i) * start.heightSize), (int) Math.round(364 * start.widthSize), (int) Math.round(78 * start.heightSize));
			
			removeButton[i].setBounds((int) Math.round(935.8 * start.widthSize), (int) Math.round((235 + 79.5 * i) * start.heightSize), (int) Math.round(114 * start.widthSize), (int) Math.round(78 * start.heightSize));
			removeButton[i].setBackground(new Color(start.ljusGrå[0], start.ljusGrå[1], start.ljusGrå[2]));
			removeButton[i].setFocusPainted(start.synligaKnappar);
			removeButton[i].setFont(new Font("comic sans ms", Font.BOLD, 20));
			
			
			changeButton[i].setBounds((int) Math.round(1050 * start.widthSize), (int) Math.round((235 + 79.5 * i) * start.heightSize), (int) Math.round(114.2 * start.widthSize), (int) Math.round(78 * start.heightSize));
			changeButton[i].setBackground(new Color(start.ljusGrå[0], start.ljusGrå[1], start.ljusGrå[2]));
			changeButton[i].setFocusPainted(start.synligaKnappar);
			changeButton[i].setFont(new Font("comic sans ms", Font.BOLD, 20));
		}
		
		
		//Fixar Text Fältena
		this.add(ordFältetet);
		ordFältetet.setBounds((int) Math.round(200 * start.widthSize), (int) Math.round(155 * start.heightSize), (int) Math.round(366 * start.widthSize), (int) Math.round(78 * start.heightSize));
		ordFältetet.setEditable(true);
		ordFältetet.setFont(new Font("comic sans ms", Font.BOLD, 30));
		ordFältetet.setHorizontalAlignment(WIDTH/2);
		ordFältetet.setBorder(null);
		ordFältetet.setBackground(new Color(77, 77, 77));//kkk
		
		this.add(översättningsFällten);
		översättningsFällten.setBounds((int) Math.round(568 * start.widthSize), (int) Math.round(155 * start.heightSize), (int) Math.round(366 * start.widthSize), (int) Math.round(78 * start.heightSize));
		översättningsFällten.setBorder(null);
		översättningsFällten.setBackground(new Color(77, 77, 77));
		översättningsFällten.setHorizontalAlignment(WIDTH/2);
		översättningsFällten.setFont(new Font("comic sans ms", Font.BOLD, 30));
		
		
		//Fixar nu Labels
		//labelFixare();
		}
	
	public static void labelFixare()
	{
		//går igenom varje kategori
		for (int i = 0; i < (start.wordList.size()-1)/(start.antalrader)/*räknar kategorier*/; i++)
		{
			//räknar ord i varje kategori
			antalOrd += start.wordList.get(i * start.antalrader + 1).size(); //beräknar antal ord +1
			System.out.println("--------------" + start.wordList.get(i * start.antalrader + 1).size()); //Skriver ut hur många ord som har lagts till
		}
		
		if (antalOrd < labelList[0].length)
		{
			for (int i = 0; i < antalOrd;)
			{
				for (int u = 0; u < ((start.radnummer + start.antalrader)/start.antalrader); u++)
				{
					for (int y = 0; y < start.wordList.get(u * start.antalrader + 1).size(); y++)
					{
						labelList[0][i].setText(start.wordList.get(u * start.antalrader + 1).get(y));
						labelList[1][i].setText(start.wordList.get(u * start.antalrader + 2).get(y));
						i++;
					}
					
				}
				//labelList[0][i].setText(start.wordList.get(i * start.antalrader).get(i));
			}
		}
		else//kanske användbar information om man behöver hantera de övriga
		{
			System.out.print("Fel här?");
			for (int i = 0; i < antalOrd && i < (labelList[0].length);) // i < antalOrd bara för säkerhets skull
			{
				for (int u = 0; u < ((start.radnummer + start.antalrader)/start.antalrader); u++)
				{
					for (int y = 0; y < start.wordList.get(u * start.antalrader + 1).size(); y++)
					{
						if(i > 5)
						{
							y = start.wordList.get(u * start.antalrader + 1).size() + 1;
							u = ((start.radnummer + start.antalrader)/start.antalrader) + 1;
							i = (labelList[0].length) + 1;
							break;
							
						}
						System.out.print("Fel här?");
						labelList[0][i].setText(start.wordList.get(u * start.antalrader + 1).get(y));
						labelList[1][i].setText(start.wordList.get(u * start.antalrader + 2).get(y));
						i++;
					}
					
				}
				//labelList[0][i].setText(start.wordList.get(i * start.antalrader).get(i));
			}
		}
		
		
		
		System.out.println("antal ord: " + antalOrd);
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
	
	static class returnButtonAct implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{	
			start.Byta(start.flashkort);
		}
	}
}
