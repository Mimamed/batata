package mimo;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class start 
{
	static JFrame f�nster = new JFrame();
	static startMeny meny = new startMeny();
	static JPanel gamlaPanelen = new JPanel();
	
	public static void main(String[] Args)
	{
		f�nster.add(meny);
		gamlaPanelen = meny;
		
	}
	
	public static void Byta(JPanel panel)
	{
		f�nster.remove(gamlaPanelen);
	}
}