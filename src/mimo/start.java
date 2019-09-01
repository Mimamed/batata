package mimo;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class start 
{
	static JFrame fönster = new JFrame();
	static startMeny meny = new startMeny();
	static JPanel gamlaPanelen = new JPanel();
	
	public static void main(String[] Args)
	{
		fönster.add(meny);
		gamlaPanelen = meny;
		
	}
	
	public static void Byta(JPanel panel)
	{
		fönster.remove(gamlaPanelen);
	}
}