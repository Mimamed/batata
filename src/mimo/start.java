package mimo;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//82601895623013 <- plz do not steal
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class start //mimamed kolla igenom ditt skit fore du forstor allting, noob  //Jag tror mer det ar jag som glommer pulla da och da och darfor forstor saker
{
	static boolean synligaKnappar = false;
	static boolean[] tabKnapparnaPa = {true, true, true};
	static int[] ljusGra = {200, 200, 200};
	static double widthSize = Toolkit.getDefaultToolkit().getScreenSize().getWidth()/1366, heightSize = Toolkit.getDefaultToolkit().getScreenSize().getHeight()/768;
	static URL[] filer = { start.class.getResource("/Bilder/startMenu.jpg"), start.class.getResource("/Bilder/tabMenu.jpg"), start.class.getResource("/Bilder/flashcardMenu.jpg"), start.class.getResource("/Bilder/flashcardGame.jpg"), start.class.getResource("/Bilder/readingMenu.jpg"), start.class.getResource("/Bilder/flashcardList.jpg"), start.class.getResource("/Bilder/readingGame.jpg"), start.class.getResource("/Bilder/settings.jpg"), start.class.getResource("/Bilder/lessonMenu.jpg"), start.class.getResource("/Bilder/lessonGameBasics.jpg"), start.class.getResource("/Bilder/lessonGame.jpg"), start.class.getResource("/Bilder/lessonGameDefiniteForms.jpg"), start.class.getResource("/Bilder/lessonGamePhrases.jpg")};
	static URL[] filerColorBlindMode = {start.class.getResource("/BilderCB/startMenuCB.jpg"), start.class.getResource("/BilderCB/tabMenuCB.jpg"), start.class.getResource("/BilderCB/flashcardMenuCB.jpg"), start.class.getResource("/BilderCB/flashcardGameCB.jpg"), start.class.getResource("/BilderCB/readingMenuCB.jpg"), start.class.getResource("/BilderCB/flashcardListCB.jpg"), start.class.getResource("/BilderCB/readingGameCB.jpg"), start.class.getResource("/BilderCB/settingsCB.jpg"), start.class.getResource("/BilderCB/lessonMenuCB.jpg")};
	static Formatter filskapare;
	static List<ArrayList<String>> wordList = new ArrayList<ArrayList<String>>();
	static int antalrader = 5;
	final static String vagen = "C:\\Users\\Public\\Downloads\\wordList.txt";//lel
	static int radnummer = -antalrader;
	static String[] defaultWordList = {":substantiv;", "Jag=I<0><0><0>;", "Du=You (singular)<Du �r en man><0><0>;", "Han=He<0><0><0>;", "Hon=She<0><0><0>;", "Det=It, That<Gillar du det?><0><0>;", "Den=It, That<Det �r en katt><0><0>;", "Vi=We<0><0><0>;", "Ni=You (plural)<Ni �r kockar><0><0>;", "De=They<0><0><0>;", "�l=Beer<0><0><0>;", "�pple=Apple<0><0><0>;", "Vatten=Water<0><0><0>;", "Kvinna=Woman<0><0><0>;", "Man=Man<0><0><0>;", "Pojke=Boy<0><0><0>;", "Flicka=Girl<0><0><0>;", "Korv=Sausage<0><0><0>;", "Vin=Wine<0><0><0>;", "K�tt=Meat<0><0><0>;", "Br�d=Bread<0><0><0>;", "P�ron=Pear<0><0><0>;", "Gr�nsak=Vegetable<0><0><0>;", "Dryck=Drink<Vilken dryck vill du ha?><0><0>;", "Mj�lk=Milk<0><0><0>;", "Kaffe=Coffee<0><0><0>;", "Te=Tea<0><0><0>;", "Alkohol=Alcohol<0><0><0>;", "Sm�r=Butter<0><0><0>;", "Skinka=Ham<0><0><0>;", "Barn=Child<0><0><0>;", "Hus=House<0><0><0>;", "Sverige=Sweden<0><0><0>;", "Europa=Europe<0><0><0>;", "Amerika=America<0><0><0>;", "Asien=Asia<0><0><0>;", "Mat=Food<0><0><0>;", "Kopp=Cup<En kopp kaffe, tack><0><0>;", "Glas=Glass<0><0><0>;", "Katt=Cat<0><0><0>;", "Hund=Dog<0><0><0>;", "Ko=Cow<0><0><0>;", "Gris=Pig<0><0><0>;", "F�gel=Bird<0><0><0>;", "Bonde=Farmer<0><0><0>;", "Orm=Snake<0><0><0>;", "Djur=Animal<0><0><0>;", "F�r=Sheep<0><0><0>;", "Lejon=Lion<0><0><0>;", "Mus=Mouse<0><0><0>;", "Gr�s=Grass<Gr�s �r gr�nt><0><0>;", "Skola=School<0><0><0>;", "Aff�r=Store, shop<0><0><0>;", "Bok=Book<0><0><0>;", "Svenska=Swedish language<0><0><0>;", "Arabiska=Arabic language<0><0><0>;", "Engelska=English language<0><0><0>;", "TV=TV<TVn �r gammal><0><0>;", "Vad=What<0><0><0>;", "Arbete=Work, job<0><0><0>;", "F�rg=Color<0><0><0>;", "Musik=Music<0><0><0>;", "Fisk=Fish<0><0><0>;", "Denna=This<Detta �r inte bra><0><0>;", "Den h�r=This, this one<Det h�r gr�set �r gr�nt><0><0>;", "Den d�r=That, that one<Det d�r huset �r litet><0><0>;", "Vem=Who<Vem �r d�r?><0><0>;", "Kl�der=Clothes<0><0><0>;", "Sko=Shoe<0><0><0>;", "Pengar=Money<0><0><0>;", "�ga=Eye<0><0><0>;", "Huvud=Head<Hunden har ett h�rt huvud><0><0>;", "Hand=Hand<0><0><0>;", "�ra=Ear<0><0><0>;", "Fot=Foot<0><0><0>;", "H�r=Hair<0><0><0>;", "Arm=Arm<0><0><0>;", "Ben=Leg, bone<0><0><0>;", "Mun=Mouth<0><0><0>;", "Tidning=Newspaper<0><0><0>;", "Inget=Nothing<Allt eller inget><0><0>;", ":verb;", "Vara=To be<Vi �r h�r><0><0>;", "�ta=To eat<0><0><0>;", "Dricka=To drink<0><0><0>;", "Gilla=To like<0><0><0>;", "Komma fr�n=To come from<Jag kommer fr�n Sverige><0><0>;", "Laga=To cook<De lagar pasta><0><0>;", "Laga=To fix<Hon lagade min cykel><0><0>;", "G�=To go, to walk<Jag g�r till aff�ren><0><0>;", "H�ra=To hear<0><0><0>;", "Se=To see<0><0><0>;", "Skriva=To write<Skriver ni en bok?><0><0>;", "L�sa=To read<Jag l�ser tidningen><0><0>;", "Tala=To speak, to talk<Talar du engelska?><0><0>;", "Hata=To hate<0><0><0>;", "�lska=To love<Jag �lskar dig><0><0>;", "Kolla=To watch, to look<De kollar p� tv><0><0>;", "Finnas=To exist, there be<Det finns ingen sn� h�r><0><0>;", "G�ra=To do, to make<Vad g�r du?><0><0>;", "Lyssna=To listen<Lyssna p� mig><0><0>;", "Heta=To be named, to be called<Jag heter Karl><0><0>;", "Ge=To give<Ge oss pengarna!><0><0>;", "Komma=To come<Han kommer hem><0><0>;", "Ha=To have<Jag har en stor katt><0><0>;", "G�ra ont=To hurt<Min t� g�r ont><0><0>;", "Klia=To itch<Deras h�r kliar><0><0>;", "S�ga=To say<0><0><0>;", "Sluta=To stop<Sluta springa><0><0>;", "Springa=To run<0><0><0>;", "Veta=To know<0><0><0>;", "Kunna=To be able to, to know, can<Kan djur l�sa?><0><0>;", "Ta=To take<0><0><0>;", "Beh�va=To need<0><0><0>;", ":describer;", "Stor=Big<0><0><0>;", "God=Well tasting<Maten �r god><0><0>;", "God=Good (not evil)<0><0><0>;", "Hemma=At home<Jag �r hemma �lskling><0><0>;", "Bra=Good, well, fine<Ge mig en bra gaffel><0><0>;", "Svart=Black<0><0><0>;", "Vit=White<0><0><0>;", "Gr�n=Green<0><0><0>;", "R�d=Red<0><0><0>;", "V�ldigt=Very<V�ldigt bra><0><0>;", "Fin=Pretty<Ditt hus �r fint><0><0>;", "F�rdig=Done, ready<Vi �r f�rdiga f�r skolan><0><0>;", "Liten=Small, little<Sm� skor, liten sko><0><0>;", "Lite=A little, a bit<Vi talar lite svenska><0><0>;", "Vilken=Which<Vilken musik gillar du?><0><0>;", "Annan=Other<Har ni n�gra andra f�rger?><0><0>;", "Bl�=Blue<0><0><0>;", "M�nga=Many, a lot<Ni har m�nga kl�der><0><0>;", "D�lig=Bad<0><0><0>;", "All=All<Alla m�nniskor �r djur><0><0>;", "N�gon=Some, somebody, any<Har ni n�got te?><0><0>;", "Snabb=Quick, fast<0><0><0>;", "L�ngsam=Slow<0><0><0>;", "Smart=Smart<0><0><0>;", "Dum=Dumb, stupid<0><0><0>;", "Ingen=No, none, no one<0><0><0>;", ":function;", "Inte=Not<Inte roligt, skrattade inte><0><0>;", "Och=And<Vi och de><0><0>;", "Ja=Yes<0><0><0>;", "Nej=No<0><0><0>;", "Jo=Yes (against no)<Jo, det �r m�jligt><0><0>;", "Hej d�=Goodbye<0><0><0>;", "V�lkommen=Welcome<V�lkommen till Stockholm><0><0>;", "Godmorgon=Good morning<0><0><0>;", "Goddag=Good day<0><0><0>;", "Godkv�ll=Good evening<0><0><0>;", "Godnatt=Good night<0><0><0>;", "Tack=Thank you, Thanks<Tack f�r maten><0><0>;", "Sn�lla=Please<Sn�lla g� inte dit><0><0>;", "F�rl�t=Sorry<F�rl�t f�r att jag l�mnade><0><0>;", "Urs�kta (mig)=Excuse me<Urs�kta, har du en t�ndare?><0><0>;", "Nu=Now<0><0><0>;", "Var=Where<0><0><0>;", "H�r=Here<0><0><0>;", "Varf�r=Why<0><0><0>;", "Hur=How<0><0><0>;", "Vart=Where to<Vart g�r ni?><0><0>;", "N�r=When<0><0><0>;", "Med=With<0><0><0>;", "En/Ett=One<0><0><0>;", "Tv�=Two<0><0><0>;", "Tre=Three<0><0><0>;", "Fyra=Four<0><0><0>;", "Fem=Five<0><0><0>;", "Sex=Six<0><0><0>;", "Sju=Seven<0><0><0>;", "�tta=Eight<0><0><0>;", "Nio=Nine<0><0><0>;", "Tio=Ten<0><0><0>;", "I=In<Han �r i duschen><0><0>;", "Idag=Today<0><0><0>;", "Ig�r=Yesterday<0><0><0>;", "Imorgon=Tomorrow<0><0><0>;", "Men=But<0><0><0>;", "D�r=There<0><0><0>;", "Till=To<0><0><0>;", "Hit=Hither, (towards) here<Kom hit nu!><0><0>;", "Dit=Thither, (towards) there<0><0><0>;", "Eller=Or<R�tt eller gr�nt><0><0>;", "Aldrig=Never<Mohammed f�r aldrig sin l�t><0><0>;", "Kanske=Maybe<0><0><0>;", "D�rf�r=Because<0><0><0>;", ":meningar;", "-"};
	static List<String> textList = new ArrayList<String>();
	static Timer timer = new Timer(1000, new TidRaknaren());
	static JFrame fonster = new JFrame("Mimo");
	static startMeny meny = new startMeny();
	static tabMeny spelSidan = new tabMeny();//2-
	static JPanel gamlaPanelen = new JPanel();
	static spelFlashkort flashkort = new spelFlashkort();//4-
	static flashcardsGame flashkortspelen = new flashcardsGame();//5.
	static flashcardsWordList fkOrdlista = new flashcardsWordList();//6
	static readingMenu readingMenyn = new readingMenu();//7
	static readingGame readingSpel = new readingGame();//8
	static settingsMenu installningar = new settingsMenu();//9
	static lessonTree lektionTrad = new lessonTree();//10
	static lBasicsOne lektionGrunder = new lBasicsOne();//11
	static lBasicsOneL1 lektionGrunderL1 = new lBasicsOneL1();//12
	static lBasicsOneL2 lektionGrunderL2 = new lBasicsOneL2();//13
	static lDefiniteForm lektionBestamdForm = new lDefiniteForm();//14
	static lDefiniteFormL1 lektionBestamdFormL1 = new lDefiniteFormL1();//15
	static lDefiniteFormL2 lektionBestamdFormL2 = new lDefiniteFormL2();//16
	static lPhrases lektionFraser = new lPhrases();//17
	static lPhrasesL1 lektionFraserL1 = new lPhrasesL1();//18
	static lPhrasesL2 lektionFraserL2 = new lPhrasesL2();//19
	
	public static void main(String[] Args)
	{
		//forsok skapa fil for lektioner!
		//satt vardena pa 0, sedan ska de adderas efter varje gang programmet stangs
		/*----------------Fixar Textfil-------------------*/
		try
		{
			File fil = new File("C:\\Users\\Public\\Downloads\\wordList.txt");
			System.out.println("\nfinnns = " + fil.exists());
			if (!fil.exists())
			{
				filskapare = new Formatter(vagen);
				
				for(int i = 0; i < defaultWordList.length; i++)
				{
					filskapare.format(defaultWordList[i] + "\n");
				}
				
				filskapare.close();
			}
			lasFiler(fil);
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		/*----------------Fixar fonstren/paneler-------------------*/
		fonster.setUndecorated(true);
		fonster.setVisible(true);
		fonster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fonster.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
		fonster.add(meny);
		gamlaPanelen = meny;
		
		fonster.invalidate();
		fonster.validate();
		fonster.repaint();
		
		//System.out.print(widthSize);

		System.out.print("\n test: " + wordList.get(0).get(0));
		//flashkortspelen.flashcardWriteWord();
		
	}
	
	//Metod som byter ut panelen i fonstret
	public static void Byta(JPanel panel)
	{
		fonster.remove(gamlaPanelen);
		fonster.add(panel);
		gamlaPanelen = panel;
		fonster.validate();
		fonster.repaint();
	}
	
	public static void lasFiler(File fil) throws FileNotFoundException
	{
		
		Scanner fillasare = new Scanner(fil);
		wordList.clear();
		wordList.add(new ArrayList<String>());
		
		
		while(fillasare.hasNext())
		{
			textList.add(fillasare.nextLine());
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

		checkaLista();
		System.out.println("llllllllllllllllll" + (start.wordList.size() - (1 + antalrader)) + " ..... " + wordList.get(0).size());
		System.out.println("kkkk: " + (start.radnummer/5) + " rad: " + (radnummer + 5) + " variabelns l�ngd: " + wordList.size());
		fkOrdlista.labelFixare(false);
		timer.start();
		
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
	
	public static void spararFiler()
	{
		List<String> listan = new ArrayList<String>();
		int x = 0;
		
		
		try {
			
			for (int i = 0; i < wordList.get(0).size(); i++)
			{
				listan.add(":" + wordList.get(0).get(i) + ";");
				x++;
				for (int u = 0; u < wordList.get((i + 1) * antalrader - 4).size(); u++)
				{
					listan.add(wordList.get((i + 1) * antalrader - 4).get(u) + "=" + wordList.get((i + 1) * antalrader - 3).get(u) + "<" + wordList.get((i + 1) * antalrader - 2).get(u) + "><" + wordList.get((i + 1) * antalrader - 1).get(u) + "><" + wordList.get((i + 1) * antalrader).get(u) + ">" + ";");
					x++;
				}
			}
			
			listan.add("-");
			
			checkaLista();
			
			Formatter spararen = new Formatter(vagen);
			for(int i = 0; i < listan.size(); i++)
			{
				spararen.format(listan.get(i) + "\n");
			}
			spararen.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void uppdaterarTabsen()
	{
		spelSidan.lessonButton.setEnabled(tabKnapparnaPa[0]);
		spelSidan.flashcardButton.setEnabled(tabKnapparnaPa[1]);
		spelSidan.readingButton.setEnabled(tabKnapparnaPa[2]);

		flashkort.lessonButton.setEnabled(tabKnapparnaPa[0]);
		flashkort.flashcardButton.setEnabled(tabKnapparnaPa[1]);
		flashkort.readingButton.setEnabled(tabKnapparnaPa[2]);

		flashkortspelen.lessonButton.setEnabled(tabKnapparnaPa[0]);
		flashkortspelen.flashcardButton.setEnabled(tabKnapparnaPa[1]);
		flashkortspelen.readingButton.setEnabled(tabKnapparnaPa[2]);

		fkOrdlista.lessonButton.setEnabled(tabKnapparnaPa[0]);
		fkOrdlista.flashcardButton.setEnabled(tabKnapparnaPa[1]);
		fkOrdlista.readingButton.setEnabled(tabKnapparnaPa[2]);

		readingMenyn.lessonButton.setEnabled(tabKnapparnaPa[0]);
		readingMenyn.flashcardButton.setEnabled(tabKnapparnaPa[1]);
		readingMenyn.readingButton.setEnabled(tabKnapparnaPa[2]);

		readingSpel.lessonButton.setEnabled(tabKnapparnaPa[0]);
		readingSpel.flashcardButton.setEnabled(tabKnapparnaPa[1]);
		readingSpel.readingButton.setEnabled(tabKnapparnaPa[2]);

		installningar.lessonButton.setEnabled(tabKnapparnaPa[0]);
		installningar.flashcardButton.setEnabled(tabKnapparnaPa[1]);
		installningar.readingButton.setEnabled(tabKnapparnaPa[2]);

		lektionTrad.lessonButton.setEnabled(tabKnapparnaPa[0]);
		lektionTrad.flashcardButton.setEnabled(tabKnapparnaPa[1]);
		lektionTrad.readingButton.setEnabled(tabKnapparnaPa[2]);

		lektionGrunder.lessonButton.setEnabled(tabKnapparnaPa[0]);
		lektionGrunder.flashcardButton.setEnabled(tabKnapparnaPa[1]);
		lektionGrunder.readingButton.setEnabled(tabKnapparnaPa[2]);

		lektionGrunderL1.lessonButton.setEnabled(tabKnapparnaPa[0]);
		lektionGrunderL1.flashcardButton.setEnabled(tabKnapparnaPa[1]);
		lektionGrunderL1.readingButton.setEnabled(tabKnapparnaPa[2]);

		lektionGrunderL2.lessonButton.setEnabled(tabKnapparnaPa[0]);
		lektionGrunderL2.flashcardButton.setEnabled(tabKnapparnaPa[1]);
		lektionGrunderL2.readingButton.setEnabled(tabKnapparnaPa[2]);

		lektionBestamdForm.lessonButton.setEnabled(tabKnapparnaPa[0]);
		lektionBestamdForm.flashcardButton.setEnabled(tabKnapparnaPa[1]);
		lektionBestamdForm.readingButton.setEnabled(tabKnapparnaPa[2]);

		lektionBestamdFormL1.lessonButton.setEnabled(tabKnapparnaPa[0]);
		lektionBestamdFormL1.flashcardButton.setEnabled(tabKnapparnaPa[1]);
		lektionBestamdFormL1.readingButton.setEnabled(tabKnapparnaPa[2]);

		lektionBestamdFormL2.lessonButton.setEnabled(tabKnapparnaPa[0]);
		lektionBestamdFormL2.flashcardButton.setEnabled(tabKnapparnaPa[1]);
		lektionBestamdFormL2.readingButton.setEnabled(tabKnapparnaPa[2]);

		lektionFraser.lessonButton.setEnabled(tabKnapparnaPa[0]);
		lektionFraser.flashcardButton.setEnabled(tabKnapparnaPa[1]);
		lektionFraser.readingButton.setEnabled(tabKnapparnaPa[2]);

		lektionFraserL1.lessonButton.setEnabled(tabKnapparnaPa[0]);
		lektionFraserL1.flashcardButton.setEnabled(tabKnapparnaPa[1]);
		lektionFraserL1.readingButton.setEnabled(tabKnapparnaPa[2]);

		lektionFraserL2.lessonButton.setEnabled(tabKnapparnaPa[0]);
		lektionFraserL2.flashcardButton.setEnabled(tabKnapparnaPa[1]);
		lektionFraserL2.readingButton.setEnabled(tabKnapparnaPa[2]);

	}
	
	static void raknarTiden() throws Exception
	{
		
		if (new File("C:\\Users\\Public\\Downloads\\TimeCounter.txt").exists())
		{
			Scanner lasaren = new Scanner(new File("C:\\Users\\Public\\Downloads\\TimeCounter.txt"));
			String tempText = Integer.toString((lasaren.nextInt() + 1));
			Formatter skrivaren = new Formatter("C:\\Users\\Public\\Downloads\\TimeCounter.txt");
			skrivaren.format(tempText);
			skrivaren.close();
		}
		else
		{
			Formatter skrivaren = new Formatter("C:\\Users\\Public\\Downloads\\TimeCounter.txt");
			skrivaren.format("1");
			skrivaren.close();
		}
		
	}
	
	
	static class TidRaknaren implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0) 
		{
			try
			{
				raknarTiden();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
		}
		
	}
	
}