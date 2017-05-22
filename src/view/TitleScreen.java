package view;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TitleScreen extends JPanel {

	
	private static final long serialVersionUID = 1L;
	private Image img, background;
	int w = 100;
	int h = 100;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		 int w = 0;
		 int h = 0;
		background = getImage("assets/Title Screen.png", 1);
		g.drawImage(background, w, h, 909, 648, null);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Impact", Font.BOLD, 64)); 
		g.drawString("Tower", 600, 100);
		g.drawString("Defense", 600, 200);
		g.drawString("Game", 600, 300);
		g.setFont(new Font("Impact", Font.BOLD, 32)); 
		g.drawString("-Press Space To Start-", 200, 600);

	}
	public Image getImage(String n, int r) {
		try {
			img = ImageIO.read(new File(n));
		} catch (IOException e) {
			System.out.println("There is no image file!");
		}

		if (img != null) {

			img = img.getScaledInstance(w / r, h / r, Image.SCALE_DEFAULT);
		}
		return img;
	}

	public static void main(String[] args) {
		JFrame window = new JFrame("Tower Defense");
		window.setBounds(100, 100, 925, 670);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel canvas = new TitleScreen();
		canvas.setBackground(Color.WHITE);
		window.getContentPane().add(canvas);
		window.setVisible(true);
	}

	
}