package mimo;

import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class start 
{
	static JFrame f�nster = new JFrame("Mimo");
	static startMeny meny = new startMeny();
	static spelMenu spelSidan = new spelMenu();
	static JPanel gamlaPanelen = new JPanel();
	static int widthSize = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth()/1366), heightSize = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight()/768;
	
	public static void main(String[] Args)
	{
		f�nster.setUndecorated(true);
		f�nster.setVisible(true);
		f�nster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f�nster.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
		f�nster.add(meny);
		gamlaPanelen = meny;
		
		System.out.print(Toolkit.getDefaultToolkit().getScreenSize().getWidth() + "  -  " + Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		
	}
	
	//Metod som byter ut panelen i f�nstret
	public static void Byta(JPanel panel)
	{
		f�nster.remove(gamlaPanelen);
		f�nster.add(panel);
		gamlaPanelen = panel;
		f�nster.validate();
	}
}