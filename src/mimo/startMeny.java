package mimo;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class startMeny extends JPanel
{
	static private JPanel pan = new JPanel(); // förkortning för panel
	static private JLabel lab = new JLabel(); // förkortning för label
	
	startMeny()
	{
		gui();
	}
	
	void gui()
	{
		Image startMenu = new ImageIcon(this.getClass().getResource("/startMeny.pdf")).getImage();
		lab.setIcon(new ImageIcon(startMenu));
		pan.add(lab);
		add(pan);
		
		validate();
	}
}