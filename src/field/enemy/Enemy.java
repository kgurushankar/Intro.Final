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
		byte[] loc = this.getLoc();
		System.out.println(loc[0] + "  " + loc[1]);
		if (loc[0] >= 0 && loc[0] <= 15 && loc[1] >= 0 && loc[1] <= 10) {
			byte dir = game.getLevel().getMap().getDirAt(loc[0], loc[1]);
			if (dir == 1) { // up
				dy = (int) (Game.interval * speed / 20.0);
			} else if (dir == 2) {// left
				dx = (int) (Game.interval * speed / 20.0);
			} else if (dir == 3) {// down
				dy = (int) (Game.interval * speed / -20.0);
			} else if (dir == 4) {// right
				dx = (int) (Game.interval * speed / -20.0);
			} else if (dir == 5) {// end
				game.removeEnemy(this);
				game.loseLife();
			}
		} else {
			if (loc[0] < 0) {
				this.x = Game.interval / 2;
			} else if (loc[0] > 15) {
				this.x = Game.interval * 29 / 2;
			} else if (loc[1] < 0) {
				this.y = Game.interval / 2;
			} else if (loc[1] > 10) {
				this.y = Game.interval * 19 / 2;

		}
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