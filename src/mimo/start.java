package mimo;

import java.awt.Toolkit;
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
	static double widthSize = Toolkit.getDefaultToolkit().getScreenSize().getWidth()/1366, heightSize = Toolkit.getDefaultToolkit().getScreenSize().getHeight()/768;
	static URL[] filer = { start.class.getResource("/Bilder/startMenu.jpg"), start.class.getResource("/Bilder/tabMenu.jpg"), start.class.getResource("/Bilder/flashcardMenu.jpg"), start.class.getResource("/Bilder/flashcardGame.jpg"), start.class.getResource("/Bilder/readingMenu.jpg"), start.class.getResource("/Bilder/flashcardList.jpg"), start.class.getResource("/Bilder/readingGame.jpg")};
	static Formatter filskapare;
	static List<ArrayList<String>> wordList = new ArrayList<ArrayList<String>>();
	static int radnummer = -1;
	static String[] defaultWordList = {"noob", "king", "lejon", "fepoj", "growtopia", "Terraria"};//82601895623013
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
	static profileMenu profil = new profileMenu();
	static settingsMenu inst�llningar = new settingsMenu();
	
	
	public static void main(String[] Args)
	{
		/*----------------Fixar Textfil-------------------*/
		try
		{
			File fil = new File("C:\\Users\\Public\\Downloads\\wordList.txt");
			System.out.print("\nfinnns = " + fil.exists());
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
		
		
		for(int i = 0; i < textList.size(); i++)
		{
			
			if(textList.get(i).indexOf("-") != -1)
			{
				break;
			}
			
			int slut = textList.get(i).indexOf(";");
			
			if (textList.get(i).indexOf(":") != -1)
			{
				int start = textList.get(i).indexOf(":") + 1;
				wordList.get(0).add(textList.get(i).substring(start, slut));
				wordList.add(new ArrayList<String>());
				wordList.add(new ArrayList<String>());
				radnummer+=2;
			}else
			{
				int mitten = textList.get(i).indexOf("=");
				wordList.get(radnummer).add(textList.get(i).substring(0, mitten));
				wordList.get(radnummer + 1).add(textList.get(i).substring(mitten + 1, slut));
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