package mimo;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import mimo.spelMenu.knapp5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class startMeny extends JPanel
{
	static private JButton startButton = new JButton(), profileButton = new JButton(), settingsButton = new JButton(), quitButton = new JButton(), menuButton = new JButton();
	static private JPanel pan = new JPanel(); // förkortning för panel
	static private BufferedImage pic; // förkortning för picture
	static private File file = new File("images\\startMenu.jpg");
	static boolean synns = true;
	
	startMeny()
	{
		checkup();
		this.setLayout(null);
		
		this.add(startButton);
		startButton.setBounds((int) Math.round(505 * start.widthSize), (int) Math.round(250 * start.heightSize), (int) Math.round(330 * start.widthSize), (int) Math.round(105 * start.heightSize));
		startButton.addActionListener(new startButton());
		startButton.setContentAreaFilled(false);
		startButton.setBorderPainted(synns);
		
		this.add(profileButton);
		profileButton.setBounds((int) Math.round(540 * start.widthSize), (int) Math.round(370 * start.heightSize), (int) Math.round(265 * start.widthSize), (int) Math.round(80 * start.heightSize));
		
		profileButton.addActionListener(new profileButton());
		profileButton.setContentAreaFilled(false);
		profileButton.setBorderPainted(synns);
		
		this.add(settingsButton);
		settingsButton.setBounds((int) Math.round(540 * start.widthSize), (int) Math.round(466 * start.heightSize), (int) Math.round(265 * start.widthSize), (int) Math.round(85 * start.heightSize));
		settingsButton.addActionListener(new settingsButton());
		settingsButton.setContentAreaFilled(false);
		settingsButton.setBorderPainted(synns);
		
		this.add(quitButton);
		quitButton.setBounds((int) Math.round(540 * start.widthSize), (int) Math.round(564 * start.heightSize), (int) Math.round(265 * start.widthSize), (int) Math.round(82 * start.heightSize));
		quitButton.addActionListener(new quitButton());
		quitButton.setContentAreaFilled(false);
		quitButton.setBorderPainted(synns);
		
		this.add(menuButton);
		menuButton.setBounds((int) Math.round(10 * start.widthSize), (int) Math.round(10 * start.heightSize), (int) Math.round(80 * start.widthSize), (int) Math.round(80 * start.heightSize));
		menuButton.addActionListener(new MenuButton());
		menuButton.setContentAreaFilled(false);
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
	
	static class MenuButton implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			start.Byta(start.meny);
		}
	}
}