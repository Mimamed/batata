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
	static private JButton startButton = new JButton(), profileButton = new JButton(), settingsButton = new JButton(), quitButton = new JButton();
	static private JPanel pan = new JPanel(); // förkortning för panel
	static private BufferedImage pic; // förkortning för picture
	static private File file = new File("images\\startMenu.jpg");
	
	startMeny()
	{
		checkup();
		this.setLayout(null);
		
		this.add(startButton);
		startButton.setBounds((int) (710 * start.widthSize), (int) (355 * start.heightSize), 463, 143);
		startButton.addActionListener(new startButton());
		startButton.setContentAreaFilled(true);
		startButton.setBorderPainted(false);
		
		this.add(profileButton);
		profileButton.setBounds(761, 520, 371, 115);
		
		profileButton.addActionListener(new profileButton());
		profileButton.setContentAreaFilled(false);
		profileButton.setBorderPainted(false);
		
		this.add(settingsButton);
		settingsButton.setBounds(761, 657, 371, 115);
		settingsButton.addActionListener(new settingsButton());
		settingsButton.setContentAreaFilled(false);
		settingsButton.setBorderPainted(false);
		
		this.add(quitButton);
		quitButton.setBounds(761, 794, 371, 115);
		quitButton.addActionListener(new quitButton());
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
	
	static class startButton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			start.Byta(start.spelSidan);
		}
	}
	
	static class profileButton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			start.Byta(start.flashkort);
		}
	}
	
	static class settingsButton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
		}
	}
	
	static class quitButton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			start.fönster.dispose();
		}
	}
}