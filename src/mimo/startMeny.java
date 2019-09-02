package mimo;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class startMeny extends JPanel
{
	static private JPanel pan = new JPanel(); // förkortning för panel
	static private JButton but = new JButton(); // förkortning för button
	
	startMeny()
	{
		gui();
	}
	
	public void gui()
	{
		but.setIcon(new ImageIcon("C:\\Users\\Carlo\\Desktop\\adobe illustrator projects\\startMeny.ai"));
	}
}