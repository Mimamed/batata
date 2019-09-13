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
	static JButton knapp = new JButton(), knapp2 = new JButton(), knapp3 = new JButton(), knapp4 = new JButton(), knapp5 = new JButton();
	
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
		this.add(knapp5);
		
		//sätter upp knapparna

		knapp.setBounds((int) Math.round(127 * start.widthSize), (int) Math.round(12 * start.heightSize), (int) Math.round(278 * start.widthSize), (int) Math.round(76 * start.heightSize));
		knapp.addActionListener(new knapp1());
		knapp.setContentAreaFilled(false);

		knapp2.setBounds((int) Math.round(406 * start.widthSize), (int) Math.round(12 * start.heightSize), (int) Math.round(278 * start.widthSize), (int) Math.round(76 * start.heightSize));
		knapp2.addActionListener(new knapp2());
		knapp2.setContentAreaFilled(false);
		
		knapp3.setBounds((int) Math.round(685 * start.widthSize), (int) Math.round(12 * start.heightSize), (int) Math.round(278 * start.widthSize), (int) Math.round(76 * start.heightSize));
		knapp3.addActionListener(new knapp3());
		knapp3.setContentAreaFilled(false);
		
		knapp4.setBounds((int) Math.round(963 * start.widthSize), (int) Math.round(12 * start.heightSize), (int) Math.round(278 * start.widthSize), (int) Math.round(76 * start.heightSize));
		knapp4.addActionListener(new knapp4());
		knapp4.setContentAreaFilled(false);
		
		knapp5.setBounds((int) Math.round(10 * start.widthSize), (int) Math.round(10 * start.heightSize), (int) Math.round(80 * start.widthSize), (int) Math.round(80 * start.heightSize));
		knapp5.addActionListener(new knapp5());
		knapp5.setContentAreaFilled(false);
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
	
	static class knapp3 implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			
		}
	}

	static class knapp4 implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			start.Byta(start.meny);
		}
	}

	static class knapp5 implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			start.Byta(start.meny);
		}
	}
}
