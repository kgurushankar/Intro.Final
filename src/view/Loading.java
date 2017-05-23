package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Loading extends JPanel {

	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		((Graphics2D) g).scale(getWidth() / (1600f), getHeight() / (900f));
		g.setFont(new Font("quicksand", Font.PLAIN, Game.interval * 4));
		g.setColor(Color.BLACK);
		g.drawString("Loading...", 300, 500);
	}

	public static void main(String[] args) {
		JFrame window = new JFrame("Load");
		window.setBounds(100, 100, 925, 670);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Loading canvas = new Loading();
		canvas.setBackground(Color.WHITE);
		window.getContentPane().add(canvas);
		window.setVisible(true);
	}
}
