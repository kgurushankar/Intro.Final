package field.enemy;

import java.awt.Image;
import field.Item;
import view.Game;

public abstract class Enemy extends Item {
	private int health;
	/**
	 * this says where this is going to go on the 15*10 grid <br />
	 * format is (x,y)
	 */
	private byte[] target = { 0, 0 };

	/**
	 * Stage in the animation the enemy is at <br />
	 * Should be 0 to 6
	 */
	private boolean alive = true;

	public Enemy(int x, int y, int health, byte speed, byte value, Game game) {
		super(x, y, speed, value, game);
		this.health = health;
	}

	public void loseHealth(double x) {
		health = ((byte) (health - x));
	}

	public double getHealth() {
		return health;
	}

	public void goTo(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void followPath() {
		int dx = 0;
		int dy = 0;
		int dir = game.getLevel().getMap().getDirAt(this.x / Game.interval, this.y / Game.interval);
		System.out.println(dir);
		if (dir == 1) {
			this.y += this.speed / 20.0 * Game.interval * -1;
		} else if (dir == 2) {
			this.x += this.speed / 20.0 * Game.interval;
		} else if (dir == 3) {
			this.y += this.speed / 20.0 * Game.interval;
		} else if (dir == 4) {
			this.x += this.speed / 20.0 * Game.interval * -1;
		} else if (dir == 5) {
			game.loseLife();
			game.removeEnemy(this);
		}

		System.out.println(dx + "  " + dy);
		move(dx, dy);
	}

	private void move(int x, int y) {
		this.x += x;
		this.y += y;
	}

	public void run() {
		if (this.health <= 0) {
			alive = false;
		} else {
			followPath();
		}
	}

	public boolean isDead() {
		return !alive;
	}

	protected Image loadImageFromFile(String FileLoc) {
		return super.loadImageFromFile("Orc/" + FileLoc);

	}

}