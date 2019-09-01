package mimo;

import javax.swing.JFrame;

public class start 
{
	static JFrame fönster = new JFrame();
	static startMeny meny = new startMeny();
	
	public static void main(String[] Args)
	{
		fönster.add(meny);
		
	}
}