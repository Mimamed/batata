package mimo;

import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class start 
{
	static JFrame f�nster = new JFrame();
	static startMeny meny = new startMeny();
	static JPanel gamlaPanelen = new JPanel();
	
	public static void main(String[] Args)
	{
		f�nster.setUndecorated(true);
		f�nster.setVisible(true);
		f�nster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f�nster.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
		f�nster.add(meny);
		gamlaPanelen = meny;
	}
	
	public static void Byta(JPanel panel)
	{
		f�nster.remove(gamlaPanelen);
	}
}