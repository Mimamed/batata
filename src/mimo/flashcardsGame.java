package mimo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
import mimo.spelFlashkort.readingButtonAct;
import mimo.spelFlashkort.menyButtonAct;
import mimo.spelFlashkort.knapp5;
import mimo.tabMeny.button;
import mimo.tabMeny.menyButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class flashcardsGame extends JPanel {
	
	static BufferedImage pic;
	static JButton lessonButton = new JButton(), flashcardButton = new JButton(), readingButton = new JButton(), menyButton = new JButton(), answerButton = new JButton(), exampleButton = new JButton(), noButton = new JButton(), yesButton = new JButton(), returnButton = new JButton();
	static JLabel word = new JLabel(), meaning = new JLabel(), example = new JLabel();
	static int wordNumber = 0;
	static int categoryNumber = 1;
	static boolean slumpaIgen; //bara en test f�r en error sak
	static Random randomNumber = new Random();
	static int stringToInt;
	static int timesAnswered = 0;
	static String exampleText;
	static List<String> ordBanLista = new ArrayList<String>();
	flashcardsGame() {
		try
		{
			pic = ImageIO.read(start.filer[3]);
		}catch (Exception e)
		{
			System.out.print("fel men uppladning4");
		}
		
		this.setLayout(null);
		
		//S�tter in alla componenter
		this.add(lessonButton);
		this.add(flashcardButton);
		this.add(readingButton);
		this.add(menyButton);
		this.add(exampleButton);
		this.add(answerButton);
		this.add(word);
		this.add(example);
		this.add(meaning);
		this.add(noButton);
		this.add(yesButton);
		this.add(returnButton);
		
		//Fixar kanpparna nedan
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
		
		word.setBounds((int) Math.round(535 * start.widthSize), (int) Math.round(200 * start.heightSize), (int) Math.round(293 * start.widthSize), (int) Math.round(106 * start.heightSize));
		word.setHorizontalAlignment(SwingConstants.CENTER);
		word.setVerticalAlignment(SwingConstants.CENTER);
		word.setFont(new Font("comic sans ms", Font.BOLD, 30));
		word.setText("test");
		
		answerButton.setBounds((int) Math.round(537 * start.widthSize), (int) Math.round(305 * start.heightSize), (int) Math.round(294 * start.widthSize), (int) Math.round(106 * start.heightSize));
		answerButton.addActionListener(new answerButtonAct());
		answerButton.setContentAreaFilled(start.synligaKnappar);
		answerButton.setFocusPainted(start.synligaKnappar);
		answerButton.setForeground(new Color(140, 198, 58));
		answerButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		answerButton.setText("Show meaning");
		
		exampleButton.setBounds((int) Math.round(535 * start.widthSize), (int) Math.round(443 * start.heightSize), (int) Math.round(293 * start.widthSize), (int) Math.round(106 * start.heightSize));
		exampleButton.addActionListener(new exampleButtonAct());
		exampleButton.setContentAreaFilled(start.synligaKnappar);
		exampleButton.setFocusPainted(start.synligaKnappar);
		exampleButton.setForeground(new Color(140, 198, 58));
		exampleButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		exampleButton.setText("Show example");
		
		noButton.setBounds((int) Math.round(649 * start.widthSize), (int) Math.round(625 * start.heightSize), (int) Math.round(257 * start.widthSize), (int) Math.round(85 * start.heightSize));
		noButton.addActionListener(new noButtonAct());
		noButton.setContentAreaFilled(start.synligaKnappar);
		noButton.setFocusPainted(start.synligaKnappar);
		noButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		noButton.setText("No");
		
		yesButton.setBounds((int) Math.round(907 * start.widthSize), (int) Math.round(625 * start.heightSize), (int) Math.round(257 * start.widthSize), (int) Math.round(85 * start.heightSize));
		yesButton.addActionListener(new yesButtonAct());
		yesButton.setContentAreaFilled(start.synligaKnappar);
		yesButton.setFocusPainted(start.synligaKnappar);
		yesButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		yesButton.setText("Yes");
		
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
			start.Byta(start.lektionTrad);
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
	
	static class answerButtonAct implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			exampleText = start.wordList.get(categoryNumber + 1).get(wordNumber);
			if(exampleText.length() > 15)
			{
				answerButton.setFont(new Font("comic sans ms", Font.BOLD, 20));
			}
			else if(exampleText.length() > 20)
			{
				answerButton.setFont(new Font("comic sans ms", Font.BOLD, 17));
			}
			else if(exampleText.length() > 25)
			{
				answerButton.setFont(new Font("comic sans ms", Font.BOLD, 14));
			}
			answerButton.setText(exampleText);
		}
	}
	
	static class exampleButtonAct implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			exampleButton.setFont(new Font("comic sans ms", Font.BOLD, 20));
			if (start.wordList.get(categoryNumber + 2).get(wordNumber).equals("0"))
			{
				exampleButton.setText("No example available");
			}
			else
			{
				exampleText = start.wordList.get(categoryNumber + 2).get(wordNumber);
				if(exampleText.length() > 20)
				{
					exampleButton.setFont(new Font("comic sans ms", Font.BOLD, 17));
				}
				exampleButton.setText(exampleText);
			}
		}
	}
	
	public static void flashcardWriteWord()
	{
		//TAR ORD FRAN LISTAN OCH SATTER DET I "WORD"
		word.setText(start.wordList.get(categoryNumber).get(wordNumber));
		ordBanLista.add(start.wordList.get(categoryNumber).get(wordNumber));
		//get(y).get(x), y och x ska vara slumpade
	}
	
	static class noButtonAct implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//lagger till 1+ till raknare
			timesAnswered = Integer.parseInt(start.fkOrdlista.tempList.get(categoryNumber + 4).get(wordNumber)) + 1;
			start.fkOrdlista.tempList.get(categoryNumber + 4).set(wordNumber, Integer.toString(timesAnswered));
			
			//antal poang
			System.out.println(start.fkOrdlista.tempList.get(categoryNumber + 3).get(wordNumber));
			System.out.println(start.fkOrdlista.tempList.get(categoryNumber).get(wordNumber) + ": inga extra po�ng");
			//antal svar
			System.out.println(start.fkOrdlista.tempList.get(categoryNumber + 4).get(wordNumber));
			System.out.println(start.fkOrdlista.tempList.get(categoryNumber).get(wordNumber) + ": 1+");
			
			slumpaIgen = false;
			while(slumpaIgen == false)
			{
				slumpaIgen = true;
				slumpaOrd();
			}
			
		}
	}
	
	public static int antalOrd()
	{
		int antalOrd = 0;

		for (int i = 0; i < (start.fkOrdlista.tempList.size()-1)/(start.antalrader)/*raknar kategorier*/; i++)
		{
			//raknar ord i varje kategori
			antalOrd += start.fkOrdlista.tempList.get(i * start.antalrader + 1).size(); //beraknar antal ord +1
			//System.out.println("--------------" + start.fkOrdlista.tempList.get(i * start.antalrader + 1).size()); //Skriver ut hur manga ord som har lagts till
		}
		return antalOrd;
	}
	
	public static void slumpaOrd()
	{

		boolean listanSlut = false;  //anvandaren har sett alla orden eller ej
		
		
		System.out.println("m�ngd!!!: " + antalOrd() + " m�ngd2!! " + ordBanLista.size());//���������������������������������
		
		if (ordBanLista.size() == (antalOrd() ))//kollaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
		{
			
			word.setText("WordList has depleted, insert new words or try again next sesson");

			answerButton.setText("No meaning");
			exampleButton.setText("No example");
			exampleButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
			answerButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
			
			answerButton.setEnabled(false);
			exampleButton.setEnabled(false);
			listanSlut = true;
			start.tabKnapparnaPa[1] = false;
			start.uppdaterarTabsen();
			start.Byta(start.meny);
		}
		else
		{
			//slumpar forst category     //aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
			switch (randomNumber.nextInt(4))
			{
			case 0:
				categoryNumber = 1;
				break;
			case 1:
				categoryNumber = 6;
				break;
			case 2:
				categoryNumber = 11;
				break;
			case 3:
				categoryNumber = 16;
				break;
			}
			//System.out.println("NUK");ooooooooooooooooooooooooooooooooooooooooooooooooooooooo
			//sedan word //aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
			wordNumber = randomNumber.nextInt(start.fkOrdlista.tempList.get(categoryNumber).size());
			for(int i = 0; i < ordBanLista.size(); i++)//loopa igenom alla ord i bannade ord listan och kolla om nagon av dem ar samma som den utslumpade orden
			{
				//System.out.println("NU");ooooooooooooooooooooooooooooooooooooooooooooooooooooooo
				if(start.fkOrdlista.tempList.get(categoryNumber).get(wordNumber).equals(ordBanLista.get(i)))
				{
					//System.out.println("NUM");ooooooooooooooooooooooooooooooooooooooooooooooooooooooo
					//System.out.print("?????????????");ooooooooooooooooooooooooooooooooooooooooooooooooooooooo
					slumpaIgen = false;
				}
			}
			
		}

		if (!listanSlut)
		{
			
			//tander knapparna
			answerButton.setEnabled(true);
			exampleButton.setEnabled(true);
			
			
			//aterst�ller utseende
			answerButton.setText("Show meaning");
			exampleButton.setText("Show example");
			exampleButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
			answerButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
			flashcardWriteWord();
			

			//kollar alla bannade orden
			for(int i = 0; i < ordBanLista.size(); i++)
			{
				System.out.print("ord " + i + ": " + ordBanLista.get(i) + " ___ ");
			}
			System.out.println("\n");
			
		}
	}
	
	static class yesButtonAct implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{	
			//lagger till 100 poang till ordet
			stringToInt = Integer.parseInt(start.fkOrdlista.tempList.get(categoryNumber + 3).get(wordNumber)) + 100;
			start.fkOrdlista.tempList.get(categoryNumber + 3).set(wordNumber, Integer.toString(stringToInt));
			//lagger till 1+ till raknare
			timesAnswered = Integer.parseInt(start.fkOrdlista.tempList.get(categoryNumber + 4).get(wordNumber)) + 1;
			start.fkOrdlista.tempList.get(categoryNumber + 4).set(wordNumber, Integer.toString(timesAnswered));
			
			//antal poang
			System.out.println(start.fkOrdlista.tempList.get(categoryNumber + 3).get(wordNumber));
			System.out.println(start.fkOrdlista.tempList.get(categoryNumber).get(wordNumber) + ": 100 extra po�ng");
			//antal svar
			System.out.println(start.fkOrdlista.tempList.get(categoryNumber + 4).get(wordNumber));
			System.out.println(start.fkOrdlista.tempList.get(categoryNumber).get(wordNumber) + ": 1+");

			slumpaIgen = false;
			while(slumpaIgen == false)
			{
				slumpaIgen = true;
				slumpaOrd();
			}
			
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
/*
Exception in thread "AWT-EventQueue-0" java.lang.StackOverflowError
at java.base/java.nio.CharBuffer.position(Unknown Source)
at java.base/sun.nio.cs.SingleByte.withResult(Unknown Source)
at java.base/sun.nio.cs.SingleByte.access$000(Unknown Source)
at java.base/sun.nio.cs.SingleByte$Encoder.encodeArrayLoop(Unknown Source)
at java.base/sun.nio.cs.SingleByte$Encoder.encodeLoop(Unknown Source)
at java.base/java.nio.charset.CharsetEncoder.encode(Unknown Source)
at java.base/sun.nio.cs.StreamEncoder.implWrite(Unknown Source)
at java.base/sun.nio.cs.StreamEncoder.implWrite(Unknown Source)
at java.base/sun.nio.cs.StreamEncoder.write(Unknown Source)
at java.base/java.io.OutputStreamWriter.write(Unknown Source)
at java.base/java.io.BufferedWriter.flushBuffer(Unknown Source)
at java.base/java.io.PrintStream.write(Unknown Source)
at java.base/java.io.PrintStream.print(Unknown Source)
at java.base/java.io.PrintStream.println(Unknown Source)
*/