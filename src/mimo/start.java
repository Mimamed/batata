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
	static int[] ljusGrå = {200, 200, 200};
	static double widthSize = Toolkit.getDefaultToolkit().getScreenSize().getWidth()/1366, heightSize = Toolkit.getDefaultToolkit().getScreenSize().getHeight()/768;
	static URL[] filer = { start.class.getResource("/Bilder/startMenu.jpg"), start.class.getResource("/Bilder/tabMenu.jpg"), start.class.getResource("/Bilder/flashcardMenu.jpg"), start.class.getResource("/Bilder/flashcardGame.jpg"), start.class.getResource("/Bilder/readingMenu.jpg"), start.class.getResource("/Bilder/flashcardList.jpg"), start.class.getResource("/Bilder/readingGame.jpg"), start.class.getResource("/Bilder/settings.jpg"), start.class.getResource("/Bilder/lessonMenu.jpg")};
	static Formatter filskapare;
	static List<ArrayList<String>> wordList = new ArrayList<ArrayList<String>>();
	static int radnummer = -5;
	static String[] defaultWordList = {":substantiv;", "Jag=I<0><0><0>;", "Du=You (singular)<Du är en man><0><0>;", "Han=He<0><0><0>;", "Hon=She<0><0><0>;", "Det=It, That<0><0><0>;", "Den=It, That<0><0><0>;", "Vi=We<0><0><0>;", "Ni=You (plural)<Ni är kockar><0><0>;", "De=They<0><0><0>;", "Öl=Beer<0><0><0>;", "Äpple=Apple<0><0><0>;", "Vatten=Water<0><0><0>;", "Kvinna=Woman<0><0><0>;", "Man=Man<0><0><0>;", "Pojke=Boy<0><0><0>;", "Flicka=Girl<0><0><0>;", "Korv=Sausage<0><0><0>;", "Vin=Wine<0><0><0>;", "Kött=Meat<0><0><0>;", "Bröd=Bread<0><0><0>;", "Päron=Pear<0><0><0>;", "Grönsak=Vegetable<0><0><0>;", "Dryck=Drink<Vilken dryck vill du ha?><0><0>;", "Mjölk=Milk<0><0><0>;", "Kaffe=Coffee<0><0><0>;", "Te=Tea<0><0><0>;", "Alkohol=Alcohol<0><0><0>;", ":verb;", "Vara=To be<Vi är här><0><0>;", "Äta=To eat<0><0><0>;", "Dricka=To drink<0><0><0>;", "Gilla=To like<0><0><0>;", "Komma från=To come from<Jag kommer från Sverige><0><0>;", "Laga=To cook<De lagar pasta><0><0>;", "Laga=To fix<Hon lagade min cykel><0><0>;", "Gå=To go, to walk<Jag går till affären><0><0>;", "Höra=To hear<0><0><0>;", "Se=To see<0><0><0>;", "Skriva=To write<Skriver ni en bok?><0><0>;", "Läsa=To read<Jag läser tidningen><0><0>;", "Tala=To speak, to talk<Talar du engelska?><0><0>;", "Hata=To hate<0><0><0>;", "Älska=To love<Jag älskar dig><0><0>;", "Kolla=To watch, to look<De kollar på tv><0><0>;", "Finnas=To exist, there be<Det finns ingen snö här><0><0>;", "Göra=To do, to make<Vad gör du?><0><0>;", "Lyssna=To listen<Lyssna på mig><0><0>;", "Heta=To be named, to be called<Jag heter Karl><0><0>;", "Ge=To give<Ge oss pengarna!><0><0>;", "Komma=To come<Han kommer hem><0><0>;", "Ha=To have<Jag har en stor katt><0><0>;", "Göra ont=To hurt<Min tå gör ont><0><0>;", ":describer;", "Stor=Big<0><0><0>;", "God=Well tasting<Maten är god><0><0>;", "God=Good (not evil)<0><0><0>;", "Hemma=At home<Jag är hemma älskling><0><0>;", "Bra=Good, well, fine<Ge mig en bra gaffel><0><0>;", "Svart=Black<0><0><0>;", "Vit=White<0><0><0>;", "Grön=Green<0><0><0>;", "Röd=Red<0><0><0>;", "Väldigt=Very<Väldigt bra><0><0>;", "Fin=Pretty<Ditt hus är fint><0><0>;", "Färdig=Done, ready<Vi är färdiga för skolan><0><0>;", "Liten=Small, little<Små skor, liten sko><0><0>;", "Lite=A little, a bit<Vi talar lite svenska><0><0>;", "Vilken=Which<Vilken musik gillar du?><0><0>;", "Annan=Other<Har ni några andra färger?><0><0>;", "Blå=Blue<0><0><0>;", "Många=Many, a lot<Ni har många kläder><0><0>;", ":function;", "Inte=Not<Inte roligt, skrattade inte><0><0>;", "Och=And<Vi och de><0><0>;", "Ja=Yes<0><0><0>;", "Nej=No<0><0><0>;", "Jo=Yes (against no)<Jo, det är möjligt><0><0>;", "Hej då=Goodbye<0><0><0>;", "Välkommen=Welcome<Välkommen till Stockholm><0><0>;", "Godmorgon=Good morning<0><0><0>;", "Goddag=Good day<0><0><0>;", "Godkväll=Good evening<0><0><0>;", "Godnatt=Good night<0><0><0>;", "Tack=Thank you, Thanks<Tack för maten><0><0>;", "Snälla=Please<Snälla gå inte dit><0><0>;", "Förlåt=Sorry<Förlåt för att jag lämnade><0><0>;", "Ursäkta (mig)=Excuse me<Ursäkta, har du en tändare?><0><0>;", "Nu=Now<0><0><0>;", "Var=Where<0><0><0>;", "Här=Here<0><0><0>;", "Varför=Why<0><0><0>;", "Hur=How<0><0><0>;", "Vart=Where to<Vart går ni?><0><0>;", "När=When<0><0><0>;", "Med=With<0><0><0>;", "En/Ett=One<0><0><0>;", "Två=Two<0><0><0>;", "Tre=Three<0><0><0>;", "Fyra=Four<0><0><0>;", "Fem=Five<0><0><0>;", ":meningar;", "-"};
	static List<String> textList = new ArrayList<String>();
	static JFrame fönster = new JFrame("Mimo");
	static startMeny meny = new startMeny();
	static tabMeny spelSidan = new tabMeny();
	static JPanel gamlaPanelen = new JPanel();
	static spelFlashkort flashkort = new spelFlashkort();
	static flashcardsGame flashkortspelen = new flashcardsGame();
	static flashcardsWordList fkOrdlista = new flashcardsWordList();
	static readingMenu readingMenyn = new readingMenu();
	static readingGame readingSpel = new readingGame();
	static settingsMenu inställningar = new settingsMenu();
	static lessonTree lektionTräd = new lessonTree();
	
	
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
			läsFiler(fil);
			checkaLista();
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		/*----------------Fixar fönstren/paneler-------------------*/
		fönster.setUndecorated(true);
		fönster.setVisible(true);
		fönster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fönster.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
		fönster.add(meny);
		gamlaPanelen = meny;
		
		fönster.invalidate();
		fönster.validate();
		fönster.repaint();
		
		//System.out.print(widthSize);

		System.out.print("\n test: " + wordList.get(0).get(0));
		flashkortspelen.flashcardWriteWord();
		
	}
	
	//Metod som byter ut panelen i fönstret
	public static void Byta(JPanel panel)
	{
		fönster.remove(gamlaPanelen);
		fönster.add(panel);
		gamlaPanelen = panel;
		fönster.validate();
		fönster.repaint();
	}
	
	public static void läsFiler(File fil) throws FileNotFoundException
	{
		
		Scanner filläsare = new Scanner(fil);
		wordList.clear();
		wordList.add(new ArrayList<String>());
		
		
		while(filläsare.hasNext())
		{
			textList.add(filläsare.nextLine());
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
					wordList.get(radnummer + 5).add(textList.get(i).substring(textList.get(i).indexOf("<", textList.get(i).indexOf(">", textList.get(i).indexOf(">") + 1) + 1) + 1, textList.get(i).indexOf(">", textList.get(i).indexOf(">", textList.get(i).indexOf(">") + 1) + 1))); //för tre siffror
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