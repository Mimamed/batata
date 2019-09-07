package mimo;

import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class start 
{
	static JFrame fönster = new JFrame("Mimo");
	static startMeny meny = new startMeny();
	static spelMenu spelSidan = new spelMenu();
	static JPanel gamlaPanelen = new JPanel();
	
	public static void main(String[] Args)
	{
		fönster.setUndecorated(true);
		fönster.setVisible(true);
		fönster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fönster.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
		fönster.add(meny);
		gamlaPanelen = meny;
		Byta(spelSidan);
	}
	
	//Metod som byter ut panelen i fönstret
	public static void Byta(JPanel panel)
	{
		fönster.remove(gamlaPanelen);
		fönster.add(panel);
		gamlaPanelen = panel;
		fönster.validate();
	}
}