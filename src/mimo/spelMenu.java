package mimo;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JPanel;

public class spelMenu extends JPanel
{
	
	static JButton knapp = new JButton();
	
	spelMenu()
	{
		this.repaint();
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.drawRect(100, 100, 100, 100);
	}
}
