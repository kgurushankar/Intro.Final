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
		// if (getLoc() == target) {

		int dx = 0;
		int dy = 0;
		byte[] loc = this.getLoc();
		byte dir = game.getLevel().getMap().getDirAt(loc[0], loc[1]);
		if (dir == 1) { // up
			this.target[0] = loc[0];
			this.target[1] = (byte) (loc[1] + 1);
			System.out.println("UP");
			dy = 1;
		} else if (dir == 2) {// left
			this.target[0] = (byte) (loc[0] + 1);
			this.target[1] = loc[1];
			System.out.println("LEFT");
			dx = 1;
		} else if (dir == 3) {// down
			this.target[0] = loc[0];
			this.target[1] = (byte) (loc[1] - 1);
			System.out.println("DOWN");
			dy = -1;
		} else if (dir == 4) {// right
			this.target[0] = (byte) (loc[0] - 1);
			this.target[1] = loc[1];
			System.out.println("UP");

			dx = -1;
		} else if (dir == 5) {// end
			game.removeEnemy(this);
			game.loseLife();
		}
		System.out.println(this.x + " " + this.y);
		// }

		/*
		 * if (x < (target[0] * Game.interval))
		 * 
		 * { // Right dx = Game.interval / 20 * speed; } else { // Left dx =
		 * Game.interval / 20 * -speed; }
		 * 
		 * if (y > (target[1] * Game.interval)) { // Up dy = Game.interval / 20
		 * * speed; } else { // Down dy = Game.interval / 20 * -speed;
		 * 
		 * }
		 */

		move(dx, dy);
	}

	private void move(int x, int y) {
		this.x += x;
		this.y += y;
	}

	public void run() {
		if (this.health <= 0) {
			alive = false;
			game.removeEnemy(this);
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