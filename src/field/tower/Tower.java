package field.tower;

import java.awt.Image;

import java.util.ArrayList;

import field.Item;
import field.enemy.Enemy;
import view.Game;

public abstract class Tower extends Item {

	protected int power;

	public Tower(byte x, byte y, int power, byte speed, int value, Game game) {
		super(x * Game.interval, y * Game.interval, speed, value, game);
		this.power = power;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	protected abstract Image getImage();

	protected void attack() {
		Enemy e = findNearestTarget();
		if (e == null) {
			return;
		}
		e.loseHealth(power);
	}

	protected Enemy findNearestTarget() {
		ArrayList<Enemy> enemies = game.getEnemies();
		if (game.getEnemies().size() == 0) {
			return null;
		}
		Enemy out = enemies.get(0);
		double dist = findDist(x, y, out.getX(), out.getY());
		for (int i = 1; i < enemies.size(); i++) {
			Enemy temp = enemies.get(i);
			double a = findDist(x, y, temp.getX(), temp.getY());
			if (a < dist) {
				out = temp;
			}
		}
		if (dist <= 3.0 * Game.interval) {
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
		if (stage % (10 / speed) == 0) {
			attack();
		}
	}
}
