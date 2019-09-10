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
	static private JButton startButton = new JButton(), profilButton = new JButton(), settingsButton = new JButton(), quitButton = new JButton();
	static private JPanel pan = new JPanel(); // förkortning för panel
	static private BufferedImage pic; // förkortning för picture
	static private File file = new File("images\\startMeny.jpg");
	
	startMeny()
	{
		checkup();
		this.setLayout(null);
		
		this.add(startButton);
		startButton.setBounds(710, 355, 463, 143);
		startButton.addActionListener(new button1());
		startButton.setContentAreaFilled(false);
		startButton.setBorderPainted(false);
		
		this.add(profilButton);
		profilButton.setBounds(761, 520, 371, 115);
		profilButton.addActionListener(new button2());
		profilButton.setContentAreaFilled(false);
		profilButton.setBorderPainted(false);
		
		this.add(settingsButton);
		settingsButton.setBounds(761, 657, 371, 115);
		settingsButton.addActionListener(new button3());
		settingsButton.setContentAreaFilled(false);
		settingsButton.setBorderPainted(false);
		
		this.add(quitButton);
		quitButton.setBounds(761, 794, 371, 115);
		quitButton.addActionListener(new button4());
		quitButton.setContentAreaFilled(false);
		quitButton.setBorderPainted(false);
		
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