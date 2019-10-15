package mimo;

import java.awt.Toolkit;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class start 
{
	static boolean synligaKnappar = false;
	static double widthSize = Toolkit.getDefaultToolkit().getScreenSize().getWidth()/1366, heightSize = Toolkit.getDefaultToolkit().getScreenSize().getHeight()/768;
	static File[] filer = { new File("images\\startMenu.jpg"), new File("images\\tabmenu.jpg"), new File("images\\flashcardMenu.jpg"), new File("images\\flashcardGame.jpg"), new File("images\\readingMenu.jpg"), new File("images\\flashcardList.jpg"), new File("images\\readingGame.jpg")};
	static JFrame fönster = new JFrame("Mimo");
	static startMeny meny = new startMeny();
	static tabMeny spelSidan = new tabMeny();
	static JPanel gamlaPanelen = new JPanel();
	static spelFlashkort flashkort = new spelFlashkort();
	static flashcardsGame flashkortspelen = new flashcardsGame();
	static flashcardsWordList fkOrdlista = new flashcardsWordList();
	static readingMenu readingMenyn = new readingMenu();
	static readingGame readingSpel = new readingGame();
	
	
	public static void main(String[] Args)
	{
		fönster.setUndecorated(true);
		fönster.setVisible(true);
		fönster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fönster.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
		fönster.add(meny);
		gamlaPanelen = meny;
		Byta(fkOrdlista);
		
		fönster.invalidate();
		fönster.validate();
		fönster.repaint();
		
		System.out.print(widthSize);
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

}