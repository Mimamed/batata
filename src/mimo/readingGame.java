package mimo;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import mimo.tabMeny.lessonButton;
import mimo.flashcardsGame.returnButtonAct;
import mimo.tabMeny.flashcardButton;
import mimo.tabMeny.readingButton;
import mimo.tabMeny.menyButton;

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class readingGame extends JPanel {
	static BufferedImage pic;
	static JButton lessonButton = new JButton(), flashcardButton = new JButton(), readingButton = new JButton(), menyButton = new JButton(), translate = new JButton(), returnButton = new JButton();
	static JTextArea textArea = new JTextArea();
	static List<String> books = new ArrayList(), booksTranslated = new ArrayList();
	public static int whichBook;
	static boolean translateClicked = false;
	
	readingGame() {
		try
		{
			pic = ImageIO.read(start.filer[6]);
		}catch (Exception e)
		{
			System.out.print("fel men uppladning");
		}
		
		this.setLayout(null);
		
		//addar grejer
		
		books.add("Emma: Hej Karl.\n" + 
				"Karl: Hall� Emma.\n" + 
				"Emma: Vad �r ditt favoritdjur?\n" + 
				"Karl: Jag gillar katter och hundar.\n" + 
				"Emma: Vad gillar du mest?\n" + 
				"Karl: Katter.\n" + 
				"Emma: Jag gillar hundar mer. De �r sn�lla och bra v�nner.\n" + 
				"Karl: Katter �r b�ttre.");
		
		books.add("Har du h�rt om talspr�ket �alla heter Glenn i G�teborg?�\n" + 
				"Talspr�ket kommer fr�n �ret 1982. 1982 fanns det fyra olika fotbollsspelare i ett lag fr�n G�teborg, alla hette Glenn. \n" +
				"Som ett sk�mt b�rjade folk s�ga �alla heter Glenn i G�teborg� och sk�mtet blev k�nt �ver hela Sverige.\n" +
				"�ven om det har g�tt v�ldigt l�nge s� kan man fortfarande h�ra folk s�ga detta talspr�k.");
		
		books.add("Carlos: Vet du hur s�kert Sverige �r?\n" + 
				"Mimamed: Hur s�kert �r Sverige?\n" + 
				"Carlos: Sverige �r s� s�kert att du kan l�mna din v�ska i timmar p� en uteservering utan att n�gon t�nker p� att stj�la den.\n" + 
				"Mimamed: Det ska jag pr�va!\n\n" +  
				"*N�gra dagar senare*\n\n" + 
				"Mimamed: Min v�ska �r borta!\n" + 
				"Carlos: Du vet v�l att det jag s�ger inte alltid �r sant?\n" + 
				"Mimamed: �h. Faktiskt stal ingen min v�ska\n" + 
				"Carlos: Men vad h�nde d�?\n" + 
				"Mimamed: Jag tappade den n�r jag vandrade p� en kulle.\n" + 
				"Carlos: Hur?\n" + 
				"Mimamed: Jag tappade v�skan.\n" + 
				"Carlos: Bra jobbat�");
		
		books.add("Varf�r fusk �r d�ligt f�r dig sj�lv och dem runt om dig.\n\n" +
				"F�r det f�rsta, fusk leder till att folk som inte borde klara n�got klarar det. Om du fuskar kan det leda till att du f�rst�r mindre och mindre. I slut�ndan kommer du inte kunna hantera enkla uppgifter utan hj�lp av fusk.\n\n" +
				"F�r det andra, t�nk p� dem som f�rs�ker. Vilken moral och/eller etik kan du anv�nda f�r att f�rsvara att du fuskar ist�llet f�r att du studerar och g�r ditt b�sta?\n" + 
				"\"Jag har inte tillr�ckligt med tid just nu\" �r inte en l�mplig urs�kt. G�r ditt b�sta, alla f�r en andra chans.\n\n" +
				"F�r det tredje, du p�verkar andras framtid. Om du forts�tter fuska kan det leda till bra resultat p� ett papper men det kan ocks� leda till d�liga resultat utanf�r det pappret. \n" +
				"De som skulle ha f�tt b�ttre resultat �n dig, om du inte fuskade, blir nu valda efter dig. Dessa resultat p�verkar andra. De som �r l�mpligare f�r vissa saker blir inte valda utan du blir vald.\n\n" + 
				"F�r det sista, du kan inte fuska p� ditt jobb.");
		
		books.add("Kalle: Tjena Pelle! Jag har precis f�tt chansen att vinna en fullst�ndigt gratis ny mobil!\n" + 
				"Pelle: Wow, vart har du f�tt det erbjudandet fr�n?\n" + 
				"Kalle: Jag fick ett mail om att jag kunde vinna en ny mobil om jag gjorde en snabb enk�t p� n�tet.\n" + 
				"Pelle: Har du gjort den �nnu?<br>" + 
				"Kalle: Ja, de ville ocks� att jag skulle betala en liten summa pengar f�r att f� mobilen skickad hit�t.\n" + 
				"Pelle: Hur mycket?\n" + 
				"Kalle: Bara 200 amerikanska dollar.\n" + 
				"Pelle: ...Vet du hur m�nga kronor det �r?\n" + 
				"Kalle: Runt 180 s�klart!\n" + 
				"Pelle: Multiplicera det d�r med 10 och sedan f�r du ett verkligare pris.\n" + 
				"Kalle: Oj� D� skulle jag kanske inte ha gjort det.\n" + 
				"Kalle: Men, vet du vad?\n" + 
				"Pelle: Vad�?\n" + 
				"Kalle: Jag tog ett snabbl�n tidigare f�r att ha lite pengar �ver och de pengarna kan jag anv�nda f�r att betala f�r mobilen. Inga problem!\n" + 
				"Pelle: Du vet v�l hur h�ga r�ntor de s�tter p� s�dana l�n?\n" + 
				"Kalle: Inga problem, jag kan �nd� s�lja mobilen om det beh�vs.\n" + 
				"Pelle: Haha, vilka ska skicka mobilen till dig d�?\n" + 
				"Kalle: Ett f�retag som heter 'Free Sweden Telefon'.\n" + 
				"Pelle: Bra jobbat. Du har inte bara gett din privata information till f�rs�ljare online, du har inte bara r�knat fel och satt dig sj�lv i skuld� Du har ocks� blivit bedragen. Ge upp.");
		
		booksTranslated.add("Emma: Hi Karl.\n" +
				"Karl: Hello Emma.\n" +
				"Emma: What is your favorite animal?\n" +
				"Karl: I like cats and dogs.\n" +
				"Emma: What do you like the most?\n" +
				"Karl: Cats." +
				"Emma: I like dogs more. They are kind and good friends.\n" +
				"Karl: Cats are better.");
		
		booksTranslated.add("Have you heard about the saying �everyone is called Glenn in Gothenburg? \n" +
				"The saying comes from the year 1982. In 1982, there were four different football players in a team from Gothenburg, all of them named Glenn. \n" +
				"As a joke, people started saying \"everyone is called Glenn in Gothenburg\" and the joke became known throughout Sweden. \n" +
				"Even though it has been a very long time, you can still hear people say this saying.");
		
		booksTranslated.add("Carlos: Do you know how safe Sweden is? \n" +
				"Mimamed: How safe is Sweden? \n" +
				"Carlos: Sweden is so safe that you can leave your bag for hours at an outdoor restaurant without anyone thinking of stealing it. \n" +
				"Mimamed: I'll try that! \n\n" + 
				"*A few days later* \n\n" +
				"Mimamed: My bag is gone! \n" +
				"Carlos: You do know that what I say is not always true? \n" +
				"Mimamed: Oh. In fact, no one stole my bag. \n" +
				"Carlos: But what happened then? \n" +
				"Mimamed: I dropped it while I was wandering on a hill. \n" +
				"Carlos: How? \n" +
				"Mimamed: I dropped the bag. \n" +
				"Carlos: Good job�");
		
		booksTranslated.add("Why cheating is bad for you and those around you. \n\n" +
				"First of all: cheating leads to people who should not do be able to do something being able to do that thing. If you cheat, it can lead to you understanding less and less. In the end, you won\'t be able to handle simple tasks without the help of cheating. \n\n" +
				"Secondly, think of those who are trying. What morality and/or ethics can you use to justify cheating instead of studying and doing your best? \n\"I don't have enough time right now\" is not an appropriate excuse. Do your best, everyone gets a second chance. \n\n" +
				"Thirdly, you  are affecting other people's future. If you continue cheating it can lead to good results on a piece of paper, but it can also lead to poor results outside of that piece of paper. \nThose who should have gotten better results than you, if you did not cheat, are now getting lower results. These results affect others. Those who are more suitable for certain things are not chosen but you are chosen. \n\n" +
				"Lastly, you can't cheat during your job.");
		
		booksTranslated.add("Kalle: Hi Pelle! I just got the chance to win a completely free new phone!\r\n" + 
				"Pelle: Wow, where have you gotten that offer from?\r\n" + 
				"Kalle: I got an email saying that I could win a new phone if I did a quick survey online.\r\n" + 
				"Pelle: Have you done it yet?\r\n" + 
				"Kalle: Yes, they also wanted me to pay a small sum of money to get the phone sent here.\r\n" + 
				"Pelle: How much?\r\n" + 
				"Kalle: Only 200 american dollars.\r\n" + 
				"Pelle: ... Do you know how much that is in kronor?\r\n" + 
				"Kalle: Around 180 of course!\r\n" + 
				"Pelle: Multiply that by 10 and then you get a more realistic price.\r\n" + 
				"Kalle: Oops... Maybe I shouldn't have done that then.\r\n" + 
				"Kalle: But, you know what?\r\n" + 
				"Pelle: What?\r\n" + 
				"Kalle: I took a instant loan earlier in order to have some money over and I can use that money to pay for the phone. No problem!\r\n" + 
				"Pelle: You do know how high the interest rates are that they put on such loans, right?\r\n" + 
				"Kalle: No problem, I can still sell the phone if that's needed.\r\n" + 
				"Pelle: Haha, who are going to send you the phone then?\r\n" + 
				"Kalle: A company called 'Free Sweden Telefon'.\r\n" + 
				"Pelle: Good job. You have not only given your private information to online vendors, you have not only miscalculated and put yourself in debt� You have also gotten swindled. Give up.");
		
		this.add(lessonButton);
		this.add(flashcardButton);
		this.add(readingButton);
		this.add(menyButton);
		this.add(textArea);
		this.add(translate);
		this.add(returnButton);
		
		//s�tter upp knapparna
		
		lessonButton.setBounds((int) Math.round(127 * start.widthSize), (int) Math.round(12 * start.heightSize), (int) Math.round(371 * start.widthSize), (int) Math.round(76 * start.heightSize));
		lessonButton.addActionListener(new lessonButton());
		lessonButton.setContentAreaFilled(start.synligaKnappar);
		lessonButton.setBorderPainted(start.synligaKnappar);
		lessonButton.setFocusPainted(start.synligaKnappar);
		lessonButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		lessonButton.setText("Lessons");

		flashcardButton.setBounds((int) Math.round(499 * start.widthSize), (int) Math.round(12 * start.heightSize), (int) Math.round(370 * start.widthSize), (int) Math.round(76 * start.heightSize));
		flashcardButton.addActionListener(new flashcardButton());
		flashcardButton.setContentAreaFilled(start.synligaKnappar);
		flashcardButton.setBorderPainted(start.synligaKnappar);
		flashcardButton.setFocusPainted(start.synligaKnappar);
		flashcardButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		flashcardButton.setText("Flashcards");
		
		readingButton.setBounds((int) Math.round(870 * start.widthSize), (int) Math.round(12 * start.heightSize), (int) Math.round(370 * start.widthSize), (int) Math.round(76 * start.heightSize));
		readingButton.addActionListener(new readingButton());
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
		
		textArea.setBounds((int) Math.round(200 * start.widthSize), (int) Math.round(155 * start.heightSize), (int) Math.round(965 * start.widthSize), (int) Math.round(500 * start.heightSize));
		textArea.setFont(new Font("comic sans ms", Font.BOLD, 22));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setOpaque(false);
		textArea.setForeground(Color.BLACK);
		textArea.setEditable(false);
		
		translate.setBounds((int) Math.round(1004 * start.widthSize), (int) Math.round(665 * start.heightSize), (int) Math.round(156 * start.widthSize), (int) Math.round(34 * start.heightSize));
		translate.setAlignmentX(CENTER_ALIGNMENT);
		translate.setAlignmentY(CENTER_ALIGNMENT);
		translate.setHorizontalAlignment(JLabel.CENTER);
		translate.setVerticalAlignment(JLabel.CENTER);
		translate.setBorderPainted(start.synligaKnappar);
		translate.setFocusPainted(start.synligaKnappar);
		translate.setContentAreaFilled(start.synligaKnappar);
		translate.setFont(new Font("comic sans ms", Font.BOLD, 30));
		translate.setText("Translate");
		translate.addActionListener(new translateButton());
		
		returnButton.setBounds((int) Math.round(110 * start.widthSize), (int) Math.round(350 * start.heightSize), (int) Math.round(80 * start.widthSize), (int) Math.round(80 * start.heightSize));
		returnButton.addActionListener(new returnButtonAct());
		returnButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		returnButton.setText("<");
	}
	
	public static void translateText (int whichBook) {
		switch(whichBook)
		{
		case 0:
			textArea.setText(booksTranslated.get(0));
			break;
			
		case 1:
			textArea.setText(booksTranslated.get(1));
			break;
			
		case 2:
			textArea.setText(booksTranslated.get(2));
			break;
			
		case 3:
			textArea.setText(booksTranslated.get(3));
			break;
			
		case 4:
			textArea.setText(booksTranslated.get(4));
			break;
		}
	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(pic, 0, 0, this.getWidth(), this.getHeight(), null);
	}
	
	static class lessonButton implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			translateClicked = false;
			start.Byta(start.lektionTr�d);
		}
	}
	
	static class flashcardButton implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			translateClicked = false;
			start.Byta(start.flashkort);
		}
	}
	
	static class readingButton implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			translateClicked = false;
			start.Byta(start.readingMenyn);
		}
	}

	static class menyButton implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			translateClicked = false;
			start.Byta(start.meny);
		}
	}
	
	static class translateButton implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			if(translateClicked)
			{
				switch(whichBook)
				{
				case 0:
					textArea.setText(books.get(0));
					break;
					
				case 1:
					textArea.setText(books.get(1));
					break;
					
				case 2:
					textArea.setText(books.get(2));
					break;
					
				case 3:
					textArea.setText(books.get(3));
					break;
					
				case 4:
					textArea.setText(books.get(4));
					break;
				}
				translateClicked = false;
			}
			else
			{
				translateText(whichBook);
				translateClicked = true;
			}
		}
	}
	
	static class returnButtonAct implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{	
			translateClicked = false;
			start.Byta(start.readingMenyn);
		}
	}
}