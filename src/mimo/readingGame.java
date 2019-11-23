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
				"Karl: Hall� Emma.\n" + 
				"Emma: Vad �r ditt favoritdjur?\n" + 
				"Karl: Jag gillar katter och hundar.\n" + 
				"Emma: Vad gillar du mest?\n" + 
				"Karl: Katter.\n" + 
				"Emma: Jag gillar hundar mer. De �r sn�lla och bra v�nner.\n" + 
				"Karl: Katter �r b�ttre.");
		
		books.add("Har du h�rt om talspr�ket �alla heter Glenn i G�teborg?�\n" + 
				"Talspr�ket kommer fr�n �ret 1982. 1982 fanns det fyra olika fotbollsspelare i ett lag fr�n G�teborg, alla hette Glenn. \nSom ett sk�mt b�rjade folk s�ga �alla heter Glenn i G�teborg� och sk�mtet blev k�nt �ver hela Sverige.\n�ven om det har g�tt v�ldigt l�nge s� kan man fortfarande h�ra folk s�ga detta talspr�k.");
		
		books.add("Carlos: Vet du hur s�kert Sverige �r?\n" + 
				"Mimamed: Hur s�kert �r Sverige?\n" + 
				"Carlos: Sverige �r s� s�kert att du kan l�mna din v�ska i timmar p� en uteservering utan att n�gon t�nker p� att stj�la den.\n" + 
				"Mimamed: Det ska jag pr�va!\n\n" +  
				"*N�gra dagar senare*\n\n" + 
				"Mimamed: Min v�ska �r borta!\n" + 
				"Carlos: Du vet v�l att det jag sade inte alltid �r sant?\n" + 
				"Mimamed: �h. Faktiskt stal ingen min v�ska\n" + 
				"Carlos: Men vad h�nde d�?\n" + 
				"Mimamed: Jag tappade den n�r jag vandrade p� en kulle.\n" + 
				"Carlos: Hur?\n" + 
				"Mimamed: Jag tappade v�skan.\n" + 
				"Carlos: Bra jobbat�");
		
		books.add("Varf�r fusk �r d�ligt f�r dig sj�lv och dem runt om dig.\n\n" +
				"F�r det f�rsta: fusk leder till att folk som inte borde klara n�got klarar det. Om du fuskar kan det leda till att du f�rst�r mindre och mindre. I slut�ndan kan du inte hantera enkla uppgifter utan hj�lp av fusk.\n\n>" +
				"F�r det andra: t�nk p� dem som f�rs�ker. Vilken moral och etik kan du anv�nda f�r att f�rsvara att du fuskar ist�llet f�r att du studerar och g�r ditt b�sta?\n" + 
				"\"Jag har inte tillr�ckligt med tid just nu\" �r inte en l�mplig urs�kt. G�r ditt b�sta, alla f�r en andra chans.\n\n" +
				"F�r det tredje: du p�verkar andras framtid. Om du forts�tter fuska kan det leda till bra resultat p� ett papper men det kan ocks� leda till d�liga resultat utanf�r det pappret. \nDe som skulle ha f�tt b�ttre resultat �n dig om du inte fuskade f�r nu l�gre resultat. Dessa resultat p�verkar andra. De som �r l�mpligare f�r vissa saker blir inte valda utan du blir vald.\n\n" + 
				"F�r det sista: du kan inte fuska p� ditt jobb.");
		
		books.add("Kalle: Tjena Pelle! Jag har precis f�tt chansen att vinna en fullst�ndigt gratis ny mobil!\n" + 
				"Pelle: Wow, vart har du f�tt det erbjudandet?\n" + 
				"Kalle: Jag fick ett mail om att jag kunde vinna en ny mobil om jag gjorde en snabb enk�t p� n�tet.\n" + 
				"Pelle: Har du gjort den �nnu?<br>" + 
				"Kalle: Ja, de ville ocks� att jag skulle betala en liten summa f�r att f� mobilen skickad hit�t.\n" + 
				"Pelle: Hur mycket?\n" + 
				"Kalle: Bara 200 amerikanska dollar.\n" + 
				"Pelle: ...Vet du hur m�nga kronor det �r?\n" + 
				"Kalle: Runt 180 s�klart!\n" + 
				"Pelle: Multiplicera det d�r med 10 och sedan f�r du ett verkligare pris.\n" + 
				"Kalle: Oj� D� skulle jag kanske inte ha gjort det.\n" + 
				"Kalle: Men vet du vad?\n" + 
				"Pelle: Vad�?\n" + 
				"Kalle: Jag tog ett snabbl�n tidigare f�r att ha lite pengar �ver och de pengarna kan jag anv�nda f�r att betala f�r mobilen. Inga problem!\n" + 
				"Pelle: Du vet v�l hur h�ga r�ntor de s�tter p� s�dana l�n?\n" + 
				"Kalle: Inga problem, jag kan �nd� s�lja mobilen om det beh�vs.\n" + 
				"Pelle: Haha, vilka ska skicka mobilen till dig d�?\n" + 
				"Kalle: Ett f�retag som heter Free Sweden Telefon\n" + 
				"Pelle: Bra jobbat. Du har inte bara gett din privata information till f�rs�ljare online, du har inte bara r�knat fel och satt dig sj�lv i skuld� Du har ocks� blivit bedragen. Ge upp.");
		
		this.add(lessonButton);
		this.add(flashcardButton);
		this.add(readingButton);
		this.add(menyButton);
		this.add(textArea);
		this.add(test);
		
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