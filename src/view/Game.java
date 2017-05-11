package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Timer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import enemy.Enemy;
import levels.*;
import towers.Tower;

public class Game extends JPanel implements ActionListener {
	private Level level;
	private Image[] path = new Image[16];
	private int interval = 64;
	private boolean running = false;
	private ArrayList<Tower> tower;
	private ArrayList<Enemy> enemy;
	private Timer tick;

	public Game() {
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
		Timer tick = new Timer(100, this);
		running = true;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		((Graphics2D) g).scale(getWidth() / (interval * 15f), getHeight() / (interval * 10f));

		for (int i = 0; i < 10; i++) {
			g.drawLine(0, interval * (i + 1), interval * 10, interval * (i + 1));

			for (int j = 0; j < 15; j++) {
				g.drawLine(interval * (j + 1), 0, interval * (j + 1), interval * 10);

				g.drawImage(path[level.getMap().getStateAt(i, j)], j * interval, i * interval, this);
			}
		}
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

	public void resume() {
		running = true;
	}

	public void pause() {
		running = false;
	}

	public void run() {
		while (true) {
			while (running) {

			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
