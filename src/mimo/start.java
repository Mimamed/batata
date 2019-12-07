package mimo;

import java.awt.Toolkit;
//82601895623013 ingen vill se din lilla spend for nend kod
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class start 
{
	static boolean synligaKnappar = false;
	static int[] ljusGr� = {200, 200, 200};
	static double widthSize = Toolkit.getDefaultToolkit().getScreenSize().getWidth()/1366, heightSize = Toolkit.getDefaultToolkit().getScreenSize().getHeight()/768;
	static URL[] filer = { start.class.getResource("/Bilder/startMenu.jpg"), start.class.getResource("/Bilder/tabMenu.jpg"), start.class.getResource("/Bilder/flashcardMenu.jpg"), start.class.getResource("/Bilder/flashcardGame.jpg"), start.class.getResource("/Bilder/readingMenu.jpg"), start.class.getResource("/Bilder/flashcardList.jpg"), start.class.getResource("/Bilder/readingGame.jpg"), start.class.getResource("/Bilder/settings.jpg"), start.class.getResource("/Bilder/lessonMenu.jpg")};
	static Formatter filskapare;
	static List<ArrayList<String>> wordList = new ArrayList<ArrayList<String>>();
	static int radnummer = -5;
	static String[] defaultWordList = {":substantiv;", "Jag=I<0><0><0>;", "Du=You (singular)<Du �r en man><0><0>;", "Han=He<0><0><0>;", "Hon=She<0><0><0>;", "Det=It, That<0><0><0>;", "Den=It, That<0><0><0>;", "Vi=We<0><0><0>;", "Ni=You (plural)<Ni �r kockar><0><0>;", "De=They<0><0><0>;", "�l=Beer<0><0><0>;", "�pple=Apple<0><0><0>;", "Vatten=Water<0><0><0>;", "Kvinna=Woman<0><0><0>;", "Man=Man<0><0><0>;", "Pojke=Boy<0><0><0>;", "Flicka=Girl<0><0><0>;", "Korv=Sausage<0><0><0>;", "Vin=Wine<0><0><0>;", "K�tt=Meat<0><0><0>;", "Br�d=Bread<0><0><0>;", "P�ron=Pear<0><0><0>;", "Gr�nsak=Vegetable<0><0><0>;", "Dryck=Drink<Vilken dryck vill du ha?><0><0>;", "Mj�lk=Milk<0><0><0>;", "Kaffe=Coffee<0><0><0>;", "Te=Tea<0><0><0>;", "Alkohol=Alcohol<0><0><0>;", ":verb;", "Vara=To be<Vi �r h�r><0><0>;", "�ta=To eat<0><0><0>;", "Dricka=To drink<0><0><0>;", "Gilla=To like<0><0><0>;", "Komma fr�n=To come from<Jag kommer fr�n Sverige><0><0>;", "Laga=To cook<De lagar pasta><0><0>;", "Laga=To fix<Hon lagade min cykel><0><0>;", "G�=To go, to walk<Jag g�r till aff�ren><0><0>;", "H�ra=To hear<0><0><0>;", "Se=To see<0><0><0>;", "Skriva=To write<Skriver ni en bok?><0><0>;", "L�sa=To read<Jag l�ser tidningen><0><0>;", "Tala=To speak, to talk<Talar du engelska?><0><0>;", "Hata=To hate<0><0><0>;", "�lska=To love<Jag �lskar dig><0><0>;", "Kolla=To watch, to look<De kollar p� tv><0><0>;", "Finnas=To exist, there be<Det finns ingen sn� h�r><0><0>;", "G�ra=To do, to make<Vad g�r du?><0><0>;", "Lyssna=To listen<Lyssna p� mig><0><0>;", "Heta=To be named, to be called<Jag heter Karl><0><0>;", "Ge=To give<Ge oss pengarna!><0><0>;", "Komma=To come<Han kommer hem><0><0>;", "Ha=To have<Jag har en stor katt><0><0>;", "G�ra ont=To hurt<Min t� g�r ont><0><0>;", ":describer;", "Stor=Big<0><0><0>;", "God=Well tasting<Maten �r god><0><0>;", "God=Good (not evil)<0><0><0>;", "Hemma=At home<Jag �r hemma �lskling><0><0>;", "Bra=Good, well, fine<Ge mig en bra gaffel><0><0>;", "Svart=Black<0><0><0>;", "Vit=White<0><0><0>;", "Gr�n=Green<0><0><0>;", "R�d=Red<0><0><0>;", "V�ldigt=Very<V�ldigt bra><0><0>;", "Fin=Pretty<Ditt hus �r fint><0><0>;", "F�rdig=Done, ready<Vi �r f�rdiga f�r skolan><0><0>;", "Liten=Small, little<Sm� skor, liten sko><0><0>;", "Lite=A little, a bit<Vi talar lite svenska><0><0>;", "Vilken=Which<Vilken musik gillar du?><0><0>;", "Annan=Other<Har ni n�gra andra f�rger?><0><0>;", "Bl�=Blue<0><0><0>;", "M�nga=Many, a lot<Ni har m�nga kl�der><0><0>;", ":function;", "Inte=Not<Inte roligt, skrattade inte><0><0>;", "Och=And<Vi och de><0><0>;", "Ja=Yes<0><0><0>;", "Nej=No<0><0><0>;", "Jo=Yes (against no)<Jo, det �r m�jligt><0><0>;", "Hej d�=Goodbye<0><0><0>;", "V�lkommen=Welcome<V�lkommen till Stockholm><0><0>;", "Godmorgon=Good morning<0><0><0>;", "Goddag=Good day<0><0><0>;", "Godkv�ll=Good evening<0><0><0>;", "Godnatt=Good night<0><0><0>;", "Tack=Thank you, Thanks<Tack f�r maten><0><0>;", "Sn�lla=Please<Sn�lla g� inte dit><0><0>;", "F�rl�t=Sorry<F�rl�t f�r att jag l�mnade><0><0>;", "Urs�kta (mig)=Excuse me<Urs�kta, har du en t�ndare?><0><0>;", "Nu=Now<0><0><0>;", "Var=Where<0><0><0>;", "H�r=Here<0><0><0>;", "Varf�r=Why<0><0><0>;", "Hur=How<0><0><0>;", "Vart=Where to<Vart g�r ni?><0><0>;", "N�r=When<0><0><0>;", "Med=With<0><0><0>;", "En/Ett=One<0><0><0>;", "Tv�=Two<0><0><0>;", "Tre=Three<0><0><0>;", "Fyra=Four<0><0><0>;", "Fem=Five<0><0><0>;", ":meningar;", "-"};
	static List<String> textList = new ArrayList<String>();
	static JFrame f�nster = new JFrame("Mimo");
	static startMeny meny = new startMeny();
	static tabMeny spelSidan = new tabMeny();
	static JPanel gamlaPanelen = new JPanel();
	static spelFlashkort flashkort = new spelFlashkort();
	static flashcardsGame flashkortspelen = new flashcardsGame();
	static flashcardsWordList fkOrdlista = new flashcardsWordList();
	static readingMenu readingMenyn = new readingMenu();
	static readingGame readingSpel = new readingGame();
	static settingsMenu inst�llningar = new settingsMenu();
	static lessonTree lektionTr�d = new lessonTree();
	
	
	public static void main(String[] Args)
	{
		/*----------------Fixar Textfil-------------------*/
		try
		{
			File fil = new File("C:\\Users\\Public\\Downloads\\wordList.txt");
			System.out.println("\nfinnns = " + fil.exists());
			if (!fil.exists())
			{
				filskapare = new Formatter("C:\\Users\\Public\\Downloads\\wordList.txt");
				
				for(int i = 0; i < defaultWordList.length; i++)
				{
					filskapare.format(defaultWordList[i] + "\n");
				}
				
				filskapare.close();
			}
			l�sFiler(fil);
			checkaLista();
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		/*----------------Fixar f�nstren/paneler-------------------*/
		f�nster.setUndecorated(true);
		f�nster.setVisible(true);
		f�nster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f�nster.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
		f�nster.add(meny);
		gamlaPanelen = meny;
		
		f�nster.invalidate();
		f�nster.validate();
		f�nster.repaint();
		
		//System.out.print(widthSize);

		System.out.print("\n test: " + wordList.get(0).get(0));
		flashkortspelen.flashcardWriteWord();
		
	}
	
	//Metod som byter ut panelen i f�nstret
	public static void Byta(JPanel panel)
	{
		f�nster.remove(gamlaPanelen);
		f�nster.add(panel);
		gamlaPanelen = panel;
		f�nster.validate();
		f�nster.repaint();
	}
	
	public static void l�sFiler(File fil) throws FileNotFoundException
	{
		
		Scanner fill�sare = new Scanner(fil);
		wordList.clear();
		wordList.add(new ArrayList<String>());
		
		
		while(fill�sare.hasNext())
		{
			textList.add(fill�sare.nextLine());
		}
		
		if (textList.get(0).indexOf(":") != -1)
		{
			for(int i = 0; i < textList.size(); i++)
			{
				
				if(textList.get(i).indexOf("-") != -1)
				{
					break;
				}
				
				int slut = textList.get(i).indexOf(";");
				
				if (textList.get(i).indexOf(":") != -1)
				{
					System.out.println("\n en kategori! : " + i + " ordet :" + textList.get(i));
					int start = textList.get(i).indexOf(":") + 1;
					wordList.get(0).add(textList.get(i).substring(start, slut));
					wordList.add(new ArrayList<String>());
					wordList.add(new ArrayList<String>());
					wordList.add(new ArrayList<String>());
					wordList.add(new ArrayList<String>());
					wordList.add(new ArrayList<String>());
					radnummer+=5;
				}else//-
				{
					int mitten = textList.get(i).indexOf("=");
					wordList.get(radnummer + 1).add(textList.get(i).substring(0, mitten));
					wordList.get(radnummer + 2).add(textList.get(i).substring(mitten + 1, textList.get(i).indexOf("<")));
					wordList.get(radnummer + 3).add(textList.get(i).substring(textList.get(i).indexOf("<") + 1, textList.get(i).indexOf(">")));
					wordList.get(radnummer + 4).add(textList.get(i).substring(textList.get(i).indexOf("<", textList.get(i).indexOf(">") + 1) + 1, textList.get(i).indexOf(">", textList.get(i).indexOf(">") + 1)));
					wordList.get(radnummer + 5).add(textList.get(i).substring(textList.get(i).indexOf("<", textList.get(i).indexOf(">", textList.get(i).indexOf(">") + 1) + 1) + 1, textList.get(i).indexOf(">", textList.get(i).indexOf(">", textList.get(i).indexOf(">") + 1) + 1))); //f�r tre siffror
					System.out.println("\nen ord klar");
				}
				
			}
		}
		
		
	}
	
	public static void checkaLista()
	{
		for (int i = 0; i < wordList.size(); i++)
		{
			for (int u = 0; u < wordList.get(i).size(); u++)
			{
				System.out.print("\n Rad: " + i + " ordnummer: " + u + " ord: " + wordList.get(i).get(u));
			}
		}
		
		System.out.print("\n-------------Texten----------------\n");
		for(int o = 0; o < textList.size(); o++)
		{
			System.out.print("\n " + o + " " + textList.get(o));
		}
		
	}

}