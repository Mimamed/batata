package mimo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;


public class spelMenu extends JPanel
{
	
	static File bakgrundFil = new File("images\\tabmenu.jpg");
	static BufferedImage bakgrund;
	static JButton knapp = new JButton(), knapp2 = new JButton(), knapp3 = new JButton(), knapp4 = new JButton();
	
	spelMenu()
	{
		try
		{
			bakgrund = ImageIO.read(bakgrundFil);
		}catch(Exception e)
		{
			System.out.print("fel men uppladning");
		}
		
		this.setLayout(null);
		
		//addar grejer
		this.add(knapp);
		this.add(knapp2);
		this.add(knapp3);
		this.add(knapp4);
		
		//sätter upp knapparna
		knapp.setBounds(127 * start.widthSize / 2, 12 * start.heightSize/2, 278 * start.widthSize/2, 76 * start.heightSize/2);
		knapp.addActionListener(new knapp1());
		knapp.setContentAreaFilled(false);

		knapp2.setBounds(406, 12, 278, 76);
		knapp2.addActionListener(new knapp2());
		knapp2.setContentAreaFilled(false);
		this.repaint();
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(bakgrund, 0, 0, this.getWidth(), this.getHeight(), null);
	}
	
	static class knapp1 implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			start.fönster.dispose();
		}
	}
	
	static class knapp2 implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			start.Byta(start.meny);
		}
	}
}
