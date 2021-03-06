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

import java.util.ArrayList;
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
	static JButton[] removeButton = new JButton[6], changeButton = new JButton[6];
	static JTextField ordFaltetet = new JTextField(), oversattningsFallten = new JTextField();
	static JLabel[][] labelList = new JLabel[2][6];
	static List<ArrayList<String>> tempList = start.wordList;
	
	flashcardsWordList() 
	{
		
		try
		{
			pic = ImageIO.read(start.filer[5]);
		}catch (Exception e)
		{
			System.out.print("fel men uppladning5");
		}
		
		
		//Initierar och adderar in remove och change knapperna(f�r att de �r arrays)** la till labelList
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
		addButton.setBackground(new Color(start.ljusGra[0], start.ljusGra[1], start.ljusGra[2]));
		
		saveButton.setBounds((int) Math.round(1050 * start.widthSize), (int) Math.round(155 * start.heightSize), (int) Math.round(114 * start.widthSize), (int) Math.round(78 * start.heightSize));
		saveButton.setBackground(new Color(start.ljusGra[0], start.ljusGra[1], start.ljusGra[2]));
		saveButton.setFocusPainted(start.synligaKnappar);
		saveButton.setFont(new Font("comic sans ms", Font.BOLD, 20));
		saveButton.setEnabled(false);
		
		downButton.setBounds((int) Math.round(1166 * start.widthSize), (int) Math.round(633 * start.heightSize), (int) Math.round(78 * start.widthSize), (int) Math.round(78 * start.heightSize));
		downButton.setBackground(new Color(start.ljusGra[0], start.ljusGra[1], start.ljusGra[2]));
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
		upButton.setBackground(new Color(start.ljusGra[0], start.ljusGra[1], start.ljusGra[2]));
		upButton.setFocusPainted(start.synligaKnappar);
		upButton.setFont(new Font("comic sans ms", Font.BOLD, 20));
		try {
		    Image img = ImageIO.read(getClass().getResource("/Bilder/greenArrowDown.png"));
		    upButton.setIcon(new ImageIcon(img));
		  } catch (Exception e) {
		    System.out.println(e);
		  }
		
		//s�tter in array knapparna
		for(int i = 0; i < removeButton.length; i++)
		{
			labelList[0][i].setBounds((int) Math.round(577.8 * start.widthSize), (int) Math.round((235 + 79.5 * i) * start.heightSize), (int) Math.round(364 * start.widthSize), (int) Math.round(78 * start.heightSize));
			labelList[1][i].setBounds((int) Math.round(209.8 * start.widthSize), (int) Math.round((235 + 79.5 * i) * start.heightSize), (int) Math.round(364 * start.widthSize), (int) Math.round(78 * start.heightSize));
			
			removeButton[i].setBounds((int) Math.round(935.8 * start.widthSize), (int) Math.round((235 + 79.5 * i) * start.heightSize), (int) Math.round(114 * start.widthSize), (int) Math.round(78 * start.heightSize));
			removeButton[i].setBackground(new Color(start.ljusGra[0], start.ljusGra[1], start.ljusGra[2]));
			removeButton[i].setFocusPainted(start.synligaKnappar);
			removeButton[i].setFont(new Font("comic sans ms", Font.BOLD, 20));
			removeButton[i].addActionListener(new removeKnapp());
			
			
			changeButton[i].setBounds((int) Math.round(1050 * start.widthSize), (int) Math.round((235 + 79.5 * i) * start.heightSize), (int) Math.round(114.2 * start.widthSize), (int) Math.round(78 * start.heightSize));
			changeButton[i].setBackground(new Color(start.ljusGra[0], start.ljusGra[1], start.ljusGra[2]));
			changeButton[i].setFocusPainted(start.synligaKnappar);
			changeButton[i].setFont(new Font("comic sans ms", Font.BOLD, 20));
		}
		
		
		//Fixar Textf�lten
		this.add(ordFaltetet);
		ordFaltetet.setBounds((int) Math.round(200 * start.widthSize), (int) Math.round(155 * start.heightSize), (int) Math.round(366 * start.widthSize), (int) Math.round(78 * start.heightSize));
		ordFaltetet.setEditable(true);
		ordFaltetet.setFont(new Font("comic sans ms", Font.BOLD, 30));
		ordFaltetet.setHorizontalAlignment(WIDTH/2);
		ordFaltetet.setBorder(null);
		ordFaltetet.setBackground(new Color(77, 77, 77));//k
		
		this.add(oversattningsFallten);
		oversattningsFallten.setBounds((int) Math.round(568 * start.widthSize), (int) Math.round(155 * start.heightSize), (int) Math.round(366 * start.widthSize), (int) Math.round(78 * start.heightSize));
		oversattningsFallten.setBorder(null);
		oversattningsFallten.setBackground(new Color(77, 77, 77));
		oversattningsFallten.setHorizontalAlignment(WIDTH/2);
		oversattningsFallten.setFont(new Font("comic sans ms", Font.BOLD, 30));
		
		
		//Fixar nu Labels
		//labelFixare();
		}
	
	public static void labelFixare(boolean ordP�fyllning)
	{
		//g�r igenom varje kategori
		if (!ordP�fyllning)
		{
			for (int i = 0; i < (tempList.size()-1)/(start.antalrader)/*r�knar kategorier*/; i++)
			{
				//r�knar ord i varje kategori
				antalOrd += tempList.get(i * start.antalrader + 1).size(); //ber�knar antal ord +1
				System.out.println("--------------" + tempList.get(i * start.antalrader + 1).size()); //Skriver ut hur m�nga ord som har lagts till
			}
			antalOrd--;
		}
		
		
		//System.out.print("Fel h�r?");
		
		for (int i = 0; i <= antalOrd && i < labelList[0].length;) // i < antalOrd bara f�r s�kerhets skull
		{
			System.out.print("kokokokokkokokokook");
			for (int u = 0; u < ((start.radnummer + start.antalrader)/start.antalrader); u++)
			{
				for (int y = 0; y < tempList.get(u * start.antalrader + 1).size(); y++)
				{
					System.out.println("kommer den ens hit? i= " + i);
					if(i > 5)
					{
						
						y = tempList.get(u * start.antalrader + 1).size() + 1;
						u = ((start.radnummer + start.antalrader)/start.antalrader) + 1;
						i = (labelList[0].length) + 1;
						break;
						
					}
					else if (i == antalOrd)
					{
						System.out.println("det handeeeeeeeeeeeer");
						if (antalOrd < labelList[0].length)
						{
							System.out.print("hhhhhhhh" + antalOrd + "kkkk " + labelList[0].length);
							for (int z = antalOrd; z < labelList[0].length; z++)
							{
								System.out.println("tar booooooooooooort");
								labelList[0][z].setText(null);
								labelList[1][z].setText(null);
								
							}
						}
						
						y = tempList.get(u * start.antalrader + 1).size() + 1;
						u = ((start.radnummer + start.antalrader)/start.antalrader) + 1;
						i = (labelList[0].length) + 1;
						break;
						
					}
					System.out.print("Fel h�r?");
					labelList[0][i].setText(tempList.get(u * start.antalrader + 1).get(y));
					labelList[1][i].setText(tempList.get(u * start.antalrader + 2).get(y));
					i++;
				}
				
			}
			
			
			//labelList[0][i].setText(start.wordList.get(i * start.antalrader).get(i));
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
	
	public static class removeKnapp implements ActionListener
	{

		public void actionPerformed(ActionEvent arg0) 
		{
			for (int i = 0; i < removeButton.length; i++)
			{
				if (arg0.getSource() == removeButton[i])
				{
					
					
					for (int u = 0; u < ((start.radnummer + start.antalrader)/start.antalrader); u++)
					{
						for (int y = 0; y < tempList.get(u * start.antalrader + 1).size(); y++)
						{
							if(labelList[0][i].getText().equals(tempList.get(u * start.antalrader + 1).get(y)))
							{

								//System.out.print("Fel har?");
								tempList.get(u * start.antalrader + 1).remove(y);
								tempList.get(u * start.antalrader + 2).remove(y);
								tempList.get(u * start.antalrader + 3).remove(y);
								tempList.get(u * start.antalrader + 4).remove(y);
								tempList.get(u * start.antalrader + 5).remove(y);
								antalOrd--;
								

								labelFixare(true);
								
								y = tempList.get(u * start.antalrader + 1).size() + 1;
								u = ((start.radnummer + start.antalrader)/start.antalrader) + 1;
								i = (labelList[0].length) + 1;
								
								break;
								
							}
						}
						
					}
					
					
					break;
				}
			}
		}
		
	}
	
}
