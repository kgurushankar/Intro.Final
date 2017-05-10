package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import levels.*;

public class Map extends JPanel {
	private Level level;
	private Image[] path = new Image[16];
	private int interval = 64;

	public Map() {
		level = new Level1();
		String root = System.getProperty("user.dir");
		root = root.replace('\\', '/');
		root += "/assets/Path/";
		path[0] = loadImageFromFile(root + "0.0.jpg");
		path[0] = path[0].getScaledInstance(interval, interval, Image.SCALE_SMOOTH);
		for (int i = 1; i < path.length; i++) {
			path[i] = loadImageFromFile(root + i + ".jpg");
			path[i] = path[i].getScaledInstance(interval, interval, Image.SCALE_SMOOTH);
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		((Graphics2D) g).scale(getWidth() / (interval * 30f), getHeight() / (interval * 20f));

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 30; j++) {
				g.drawImage(path[level.getStateAt(i, j)], j * interval, i * interval, this);
			}
		}
	}

	public static void main(String[] args) {
		JFrame w = new JFrame("Scenic Landscape");
		w.setBounds(100, 100, 800, 600);
		w.setDefaultCloseOperation(3);
		Map panel = new Map();
		panel.setBackground(Color.WHITE);
		w.add(panel);
		w.setResizable(true);
		w.setVisible(true);
	}

	private Image loadImageFromFile(String FileLoc) {
		try {
			Image temp = ImageIO.read(new File(FileLoc));
			return temp;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("File " + FileLoc + " not Found");
			System.exit(1);
		}
		return null;

	}
}
