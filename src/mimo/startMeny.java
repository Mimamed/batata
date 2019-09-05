package mimo;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class startMeny extends JPanel
{
	static private JPanel pan = new JPanel(); // förkortning för panel
	static private JLabel lab = new JLabel(); // förkortning för label
	static  BufferedImage pic; // förkortning för picture
	static private File fil = new File("images\\menu.jpg"); // förkortning för file
	
	startMeny()
	{
		checkup();
	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(pic, 0, 0, this.getWidth(), this.getHeight(), null);
		g.drawRect(1, 1, 500, 500);
	}
	
	public void checkup()
	{
		try
		{
			pic = ImageIO.read(fil);
		}
		catch(Exception e)
		{
			System.out.print("Error.");
		}
	}
}