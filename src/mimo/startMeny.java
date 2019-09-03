package mimo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class startMeny extends JPanel
{
	static private JPanel pan = new JPanel(); // förkortning för panel
	static private JLabel lab = new JLabel(); // förkortning för label
	static  BufferedImage pic; // förkortning för picture
	static private File fil = new File("images\\Bild.jpg"); // förkortning för file
	
	startMeny()
	{
		gui(); // kallar på gui metod
		try
		{
			pic = ImageIO.read(fil);
		}
		
		catch(Exception e)
		{
			System.out.print("ndmkaj");
		}
	} //lol
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(pic, 0, 0, this.getWidth(), this.getHeight(), null);
	}
	
	public void gui()
	{
		
		/*lab.setIcon(new ImageIcon(/startMeny.pdf)); // placerar bilden i min label
		pan.add(lab); // placerar min label i min panel
		add(pan); // placerar min panel i min frame
		
		validate(); // uppdaterar bilden
*/	}
}