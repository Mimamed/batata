package mimo;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import mimo.tabMeny.menyButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class startMeny extends JPanel
{
	static private JButton startButton = new JButton(), profileButton = new JButton(), settingsButton = new JButton(), quitButton = new JButton(), menuButton = new JButton();
	static private JPanel pan = new JPanel(); // förkortning för panel
	static private BufferedImage pic; // förkortning för picture
	static boolean syns = false;
	
	startMeny()
	{
		checkup();
		this.setLayout(null);
		
		this.add(startButton);
		startButton.setBounds((int) Math.round(505 * start.widthSize), (int) Math.round(250 * start.heightSize), (int) Math.round(330 * start.widthSize), (int) Math.round(105 * start.heightSize));
		startButton.addActionListener(new startButton());
		startButton.setContentAreaFilled(syns);
		startButton.setFocusPainted(syns);
		startButton.setBorderPainted(syns);
		startButton.setFont(new Font("comic sans ms", Font.BOLD, 50));
		startButton.setText("Start");
		
		this.add(profileButton);
		profileButton.setBounds((int) Math.round(540 * start.widthSize), (int) Math.round(370 * start.heightSize), (int) Math.round(265 * start.widthSize), (int) Math.round(80 * start.heightSize));
		profileButton.addActionListener(new profileButton());
		profileButton.setContentAreaFilled(syns);
		profileButton.setFocusPainted(syns);
		profileButton.setBorderPainted(syns);
		profileButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		profileButton.setText("Profile");
		
		this.add(settingsButton);
		settingsButton.setBounds((int) Math.round(540 * start.widthSize), (int) Math.round(466 * start.heightSize), (int) Math.round(265 * start.widthSize), (int) Math.round(85 * start.heightSize));
		settingsButton.addActionListener(new settingsButton());
		settingsButton.setContentAreaFilled(syns);
		settingsButton.setFocusPainted(syns);
		settingsButton.setBorderPainted(syns);
		settingsButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		settingsButton.setText("Settings");
		
		this.add(quitButton);
		quitButton.setBounds((int) Math.round(540 * start.widthSize), (int) Math.round(564 * start.heightSize), (int) Math.round(265 * start.widthSize), (int) Math.round(82 * start.heightSize));
		quitButton.addActionListener(new quitButton());
		quitButton.setContentAreaFilled(syns);
		quitButton.setFocusPainted(syns);
		quitButton.setBorderPainted(syns);
		quitButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		quitButton.setText("Quit");
		
		this.add(menuButton);
		menuButton.setBounds((int) Math.round(10 * start.widthSize), (int) Math.round(10 * start.heightSize), (int) Math.round(80 * start.widthSize), (int) Math.round(80 * start.heightSize));
		menuButton.addActionListener(new MenuButton());
		menuButton.setContentAreaFilled(syns);
		menuButton.setBorderPainted(syns);
		menuButton.setFocusPainted(syns);
	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(pic, 0, 0, this.getWidth(), this.getHeight(), null);
	}
	
	public void checkup()
	{
		try
		{
			pic = ImageIO.read(start.filer[0]);
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
			//start.Byta(start.flashkort);
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