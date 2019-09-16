package mimo;

import java.awt.Toolkit;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class start 
{
	static double widthSize = Toolkit.getDefaultToolkit().getScreenSize().getWidth()/1366, heightSize = Toolkit.getDefaultToolkit().getScreenSize().getHeight()/768;
	static File[] filer = { new File("images\\startMenu.jpg"), new File("images\\tabmenu.jpg"), new File("images\\flashcardMenu.jpg")};
	static JFrame fönster = new JFrame("Mimo");
	static startMeny meny = new startMeny();
	static spelMenu spelSidan = new spelMenu();
	static JPanel gamlaPanelen = new JPanel();
	static spelFlashkort flashkort = new spelFlashkort();
	
	
	public static void main(String[] Args)
	{
		fönster.setUndecorated(true);
		fönster.setVisible(true);
		fönster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fönster.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
		fönster.add(meny);
		gamlaPanelen = meny;
		start.fönster.invalidate();
		start.fönster.validate();
		start.fönster.repaint();
		
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