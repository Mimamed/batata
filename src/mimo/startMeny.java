package mimo;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class startMeny extends JPanel
{
	static private JButton button1 = new JButton(), button2 = new JButton(), button3 = new JButton(), button4 = new JButton();
	static private JPanel pan = new JPanel(); // förkortning för panel
	static private BufferedImage pic; // förkortning för picture
	static private File file = new File("images\\startMeny.jpg");
	
	startMeny()
	{
		checkup();
		this.setLayout(null);
		
		this.add(button1);
		button1.setBounds(710, 355, 463, 143);
		button1.addActionListener(new button1());
		button1.setContentAreaFilled(false);
		button1.setBorderPainted(false);
		
		this.add(button2);
		button2.setBounds(761, 520, 371, 115);
		button2.addActionListener(new button2());
		button2.setContentAreaFilled(false);
		button2.setBorderPainted(false);
		
		this.add(button3);
		button3.setBounds(761, 657, 371, 115);
		button3.addActionListener(new button3());
		button3.setContentAreaFilled(false);
		button3.setBorderPainted(false);
		
		this.add(button4);
		button4.setBounds(761, 794, 371, 115);
		button4.addActionListener(new button4());
		button4.setContentAreaFilled(false);
		button4.setBorderPainted(false);
		
		this.repaint();
	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(pic, 0, 0, this.getWidth(), this.getHeight(), null);
	}
	
	public void checkup()
	{
		try
		{
			pic = ImageIO.read(file);
		}
		catch(Exception e)
		{
			System.out.print("Error.");
		}
	}
	
	static class button1 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			start.Byta(start.spelSidan);
		}
	}
	
	static class button2 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
		}
	}
	
	static class button3 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
		}
	}
	
	static class button4 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
		}
	}
}