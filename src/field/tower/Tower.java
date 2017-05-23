package field.tower;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import field.Item;
import field.enemy.Enemy;
import view.Game;

public abstract class Tower extends Item {

	protected byte x;
	protected byte y;
	protected int power;

	public Tower(byte x, byte y, int i, byte speed, int value, Game game) {
		super(x, y, speed, value, game);
		this.x = x;
		this.y = y;
		this.power = power;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void draw(Graphics g) {
		g.drawImage(
				getImage().getScaledInstance((int) (Game.interval * .9), (int) (Game.interval * .9),
						Image.SCALE_SMOOTH),
				Game.interval * x + (int) (Game.interval * .05), Game.interval * y + (int) (Game.interval * .05), null);
	}

	protected abstract Image getImage();

	protected void attack() {
		Enemy e = findNearestTarget();
		e.loseHealth(power);
	}

	protected Enemy findNearestTarget() {
		ArrayList<Enemy> enemies = game.getEnemies();
		Enemy out = enemies.get(0);
		double dist = findDist(x, y, out.getX(), out.getY());
		for (int i = 1; i < enemies.size(); i++) {
			Enemy temp = enemies.get(i);
			double a = findDist(x, y, temp.getX(), temp.getY());
			if (a < dist) {
				out = temp;
			}
		}
		if (dist <= 3.0) {
			return out;
		} else {
			return null;
		}
	}

	private double findDist(int x1, int y1, int x2, int y2) {
		return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}

	protected Image loadImageFromFile(String FileLoc) {
		return super.loadImageFromFile("Tower/" + FileLoc);

	}

	private int stage = 0;

	public void run() {
		stage++;
		if (stage % (20 / speed) == 0) {
			attack();
			System.out.println("Attack");
		}
	}
}
