package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.Timer;

import field.enemy.*;
import field.tower.*;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import levels.*;

public class Game extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1;
	public static final int interval = 64;

	private Level level;
	private Image[] path = new Image[16];
	private boolean running = false;
	private ArrayList<Tower> tower = new ArrayList<Tower>();
	private ArrayList<Enemy> enemy = new ArrayList<Enemy>();
	private Timer tick;
	private int balance;
	private byte lives;
	private int score;

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
		lives = 50;
		balance = 450;
		tick = new Timer(50, this);
		tick.start();
		enemy.add(new OrcSword(level.getMap().getStartingLocation()[0] * interval,
				level.getMap().getStartingLocation()[1] * interval, this));
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		((Graphics2D) g).scale(getWidth() / (interval * (15f + 2.5f)), getHeight() / (interval * (10f + 1)));

		// path
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 15; j++) {
				g.drawImage(path[level.getMap().getStateAt(i, j)], j * interval, i * interval, this);
			}
		}

		// Bottom Scores
		g.setColor(new Color(95, 123, 36));
		g.fillRect(0, interval * 10, interval * 15, interval);
		g.setColor(Color.BLACK);
		g.setFont(new Font("quicksand", Font.PLAIN, interval / 2));
		g.drawString("Balance: " + balance, interval / 2, (int) (interval * (10.75)));
		g.drawString("Score: " + score, interval * 13 / 2, (int) (interval * (10.75)));
		g.drawString("Lives: " + lives, interval * 12, (int) (interval * (10.75)));

		// Draw enemies/towers
		for (int i = 0; i < tower.size(); i++) {
			tower.get(i).draw(g);
		}
		for (int i = 0; i < enemy.size(); i++) {
			enemy.get(i).draw(g);
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
		tick.start();
		this.running = true;
	}

	public void pause() {
		tick.stop();
		this.running = false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		perTick();
	}

	private void perTick() {
		// Enemy code
		for (int i = 0; i < enemy.size(); i++) {
			Enemy e = enemy.get(i);
			if (e.isDead()) {
				this.balance += e.getValue();
				enemy.remove(i);
			} else {
			}
			e.followPath();
		}
	}

	public boolean isPaused() {
		return this.running;
	}

	public Level getLevel() {
		return level;
	}

	public void removeEnemy(Enemy e) {
		enemy.remove(e);
	}

	public void loseLife() {
		lives--;
	}

	public void balance(byte value) {
		if (value > 0) {
			score += value;
		}
		this.balance += value;
	}
}
