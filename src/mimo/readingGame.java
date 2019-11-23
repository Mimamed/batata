package mimo;
//BARA EN BILD JUST NU
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import mimo.tabMeny.lessonButton;
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
	static JButton lessonButton = new JButton(), flashcardButton = new JButton(), readingButton = new JButton(), menyButton = new JButton(), test = new JButton();
	static JTextArea textArea = new JTextArea();
	static List<String> books = new ArrayList();
	
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
				"Karl: Hallå Emma.\n" + 
				"Emma: Vad är ditt favoritdjur?\n" + 
				"Karl: Jag gillar katter och hundar.\n" + 
				"Emma: Vad gillar du mest?\n" + 
				"Karl: Katter.\n" + 
				"Emma: Jag gillar hundar mer. De är snälla och bra vänner.\n" + 
				"Karl: Katter är bättre.");
		
		books.add("Har du hört om talspråket “alla heter Glenn i Göteborg?”\n" + 
				"Talspråket kommer från året 1982. 1982 fanns det fyra olika fotbollsspelare i ett lag från Göteborg, alla hette Glenn. \nSom ett skämt började folk säga “alla heter Glenn i Göteborg” och skämtet blev känt över hela Sverige.\nÄven om det har gått väldigt länge så kan man fortfarande höra folk säga detta talspråk.");
		
		books.add("Carlos: Vet du hur säkert Sverige är?\n" + 
				"Mimamed: Hur säkert är Sverige?\n" + 
				"Carlos: Sverige är så säkert att du kan lämna din väska i timmar på en uteservering utan att någon tänker på att stjäla den.\n" + 
				"Mimamed: Det ska jag pröva!\n\n" +  
				"*Några dagar senare*\n\n" + 
				"Mimamed: Min väska är borta!\n" + 
				"Carlos: Du vet väl att det jag sade inte alltid är sant?\n" + 
				"Mimamed: Åh. Faktiskt stal ingen min väska\n" + 
				"Carlos: Men vad hände då?\n" + 
				"Mimamed: Jag tappade den när jag vandrade på en kulle.\n" + 
				"Carlos: Hur?\n" + 
				"Mimamed: Jag tappade väskan.\n" + 
				"Carlos: Bra jobbat…");
		
		books.add("Varför fusk är dåligt för dig själv och dem runt om dig.\n\n" +
				"För det första: fusk leder till att folk som inte borde klara något klarar det. Om du fuskar kan det leda till att du förstår mindre och mindre. I slutändan kan du inte hantera enkla uppgifter utan hjälp av fusk.\n\n>" +
				"För det andra: tänk på dem som försöker. Vilken moral och etik kan du använda för att försvara att du fuskar istället för att du studerar och gör ditt bästa?\n" + 
				"\"Jag har inte tillräckligt med tid just nu\" är inte en lämplig ursäkt. Gör ditt bästa, alla får en andra chans.\n\n" +
				"För det tredje: du påverkar andras framtid. Om du fortsätter fuska kan det leda till bra resultat på ett papper men det kan också leda till dåliga resultat utanför det pappret. \nDe som skulle ha fått bättre resultat än dig om du inte fuskade får nu lägre resultat. Dessa resultat påverkar andra. De som är lämpligare för vissa saker blir inte valda utan du blir vald.\n\n" + 
				"För det sista: du kan inte fuska på ditt jobb.");
		
		books.add("Kalle: Tjena Pelle! Jag har precis fått chansen att vinna en fullständigt gratis ny mobil!\n" + 
				"Pelle: Wow, vart har du fått det erbjudandet?\n" + 
				"Kalle: Jag fick ett mail om att jag kunde vinna en ny mobil om jag gjorde en snabb enkät på nätet.\n" + 
				"Pelle: Har du gjort den ännu?<br>" + 
				"Kalle: Ja, de ville också att jag skulle betala en liten summa för att få mobilen skickad hitåt.\n" + 
				"Pelle: Hur mycket?\n" + 
				"Kalle: Bara 200 amerikanska dollar.\n" + 
				"Pelle: ...Vet du hur många kronor det är?\n" + 
				"Kalle: Runt 180 såklart!\n" + 
				"Pelle: Multiplicera det där med 10 och sedan får du ett verkligare pris.\n" + 
				"Kalle: Oj… Då skulle jag kanske inte ha gjort det.\n" + 
				"Kalle: Men vet du vad?\n" + 
				"Pelle: Vadå?\n" + 
				"Kalle: Jag tog ett snabblån tidigare för att ha lite pengar över och de pengarna kan jag använda för att betala för mobilen. Inga problem!\n" + 
				"Pelle: Du vet väl hur höga räntor de sätter på sådana lån?\n" + 
				"Kalle: Inga problem, jag kan ändå sälja mobilen om det behövs.\n" + 
				"Pelle: Haha, vilka ska skicka mobilen till dig då?\n" + 
				"Kalle: Ett företag som heter Free Sweden Telefon\n" + 
				"Pelle: Bra jobbat. Du har inte bara gett din privata information till försäljare online, du har inte bara räknat fel och satt dig själv i skuld… Du har också blivit bedragen. Ge upp.");
		
		this.add(lessonButton);
		this.add(flashcardButton);
		this.add(readingButton);
		this.add(menyButton);
		this.add(textArea);
		this.add(test);
		
		//sätter upp knapparna
		
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
	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(pic, 0, 0, this.getWidth(), this.getHeight(), null);
	}
	
	static class lessonButton implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			
		}
	}
	
	static class flashcardButton implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			start.Byta(start.flashkort);
		}
	}
	
	static class readingButton implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			start.Byta(start.readingMenyn);
		}
	}

	static class menyButton implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			start.Byta(start.meny);
		}
	}
}