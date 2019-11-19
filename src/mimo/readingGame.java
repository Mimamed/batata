package mimo;
//BARA EN BILD JUST NU
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import mimo.tabMeny.lessonButton;
import mimo.tabMeny.flashcardButton;
import mimo.tabMeny.readingButton;
import mimo.tabMeny.menyButton;

import java.util.List;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class readingGame extends JPanel {
	static BufferedImage pic;
	static JButton lessonButton = new JButton(), flashcardButton = new JButton(), readingButton = new JButton(), menyButton = new JButton();
	readingGame() {
		try
		{
			pic = ImageIO.read(start.filer[6]);
		}catch (Exception e)
		{
			System.out.print("fel men uppladning");
		}
	}
}
