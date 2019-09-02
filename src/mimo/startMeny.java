package mimo;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class startMeny extends JPanel
{
	static private JPanel pan = new JPanel(); // f�rkortning f�r panel
	static private JLabel lab = new JLabel(); // f�rkortning f�r label
	
	startMeny()
	{
		gui(); // kallar p� gui metod
	} //lol
	
	public void gui()
	{
		Image startMenu = new ImageIcon(this.getClass().getResource("/startMeny.pdf")).getImage(); // skapar en v�g till source folder f�r att h�mta "startMeny" bild
		lab.setIcon(new ImageIcon(startMenu)); // placerar bilden i min label
		pan.add(lab); // placerar min label i min panel
		add(pan); // placerar min panel i min frame
		
		validate(); // uppdaterar bilden
	}
}