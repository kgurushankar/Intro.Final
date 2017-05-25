package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Lose extends JPanel {

	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		((Graphics2D) g).scale(getWidth() / (1600f), getHeight() / (900f));
		g.setFont(new Font("quicksand", Font.PLAIN, Game.interval * 4));
		g.setColor(Color.RED);
		g.drawString("You Lose", 250, 450);
		g.setFont(new Font("quicksand", Font.PLAIN, (int) (Game.interval * 1.2)));
		g.drawString("Press space to go back to the title screen", 25, 800);
		g.drawString("Press c to see the credits", 300, 700);
	}

	public static void main(String[] args) {
		JFrame window = new JFrame("Lose");
		window.setBounds(100, 100, 925, 670);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Lose canvas = new Lose();
		canvas.setBackground(Color.WHITE);
		window.getContentPane().add(canvas);
		window.setVisible(true);
	}
}
