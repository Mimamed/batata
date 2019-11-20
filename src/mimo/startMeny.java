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
	static private JButton startButton = new JButton(), settingsButton = new JButton(), quitButton = new JButton(), menuButton = new JButton();
	static private JPanel pan = new JPanel(); // förkortning för panel
	static private BufferedImage pic; // förkortning för picture
	startMeny()
	{
		checkup();
		this.setLayout(null);
		
		this.add(startButton);
		startButton.setBounds((int) Math.round(478 * start.widthSize), (int) Math.round(228 * start.heightSize), (int) Math.round(410 * start.widthSize), (int) Math.round(126 * start.heightSize));
		startButton.addActionListener(new startButton());
		startButton.setContentAreaFilled(start.synligaKnappar);
		startButton.setFocusPainted(start.synligaKnappar);
		startButton.setBorderPainted(start.synligaKnappar);
		startButton.setFont(new Font("comic sans ms", Font.BOLD, 50));
		startButton.setText("Start");
		
		this.add(settingsButton);
		settingsButton.setBounds((int) Math.round(520 * start.widthSize), (int) Math.round(384 * start.heightSize), (int) Math.round(327 * start.widthSize), (int) Math.round(104 * start.heightSize));
		settingsButton.addActionListener(new settingsButton());
		settingsButton.setContentAreaFilled(start.synligaKnappar);
		settingsButton.setFocusPainted(start.synligaKnappar);
		settingsButton.setBorderPainted(start.synligaKnappar);
		settingsButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		settingsButton.setText("Settings");
		
		this.add(quitButton);
		quitButton.setBounds((int) Math.round(520 * start.widthSize), (int) Math.round(521 * start.heightSize), (int) Math.round(327 * start.widthSize), (int) Math.round(103 * start.heightSize));
		quitButton.addActionListener(new quitButton());
		quitButton.setContentAreaFilled(start.synligaKnappar);
		quitButton.setFocusPainted(start.synligaKnappar);
		quitButton.setBorderPainted(start.synligaKnappar);
		quitButton.setFont(new Font("comic sans ms", Font.BOLD, 30));
		quitButton.setText("Quit");
		
		this.add(menuButton);
		menuButton.setBounds((int) Math.round(10 * start.widthSize), (int) Math.round(10 * start.heightSize), (int) Math.round(80 * start.widthSize), (int) Math.round(80 * start.heightSize));
		menuButton.addActionListener(new MenuButton());
		menuButton.setContentAreaFilled(start.synligaKnappar);
		menuButton.setBorderPainted(start.synligaKnappar);
		menuButton.setFocusPainted(start.synligaKnappar);
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
	
	static class settingsButton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			start.Byta(start.inställningar);
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