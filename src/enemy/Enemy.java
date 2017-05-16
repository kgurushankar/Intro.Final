package enemy;

import java.awt.Graphics;
import java.awt.Image;

import view.Game;

public abstract class Enemy {
	private byte health;
	private int x;
	private int y;
	/** Max speed is 10 */
	private byte speed;
	private byte value; // on kill
	/**
	 * this says where this is going to go on the 15*10 grid <br />
	 * format is (x,y)
	 */
	private byte[] target;

	/**
	 * Stage in the animation the enemy is at <br />
	 * Should be 0 to 6
	 */
	private byte stage = 0;
	private boolean alive = true;
	private Image img;
	private boolean needsNewDir = false;

	public Enemy(int x, int y, byte health, byte speed, byte value) {
		this.health = health;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.value = value;
	}

	public void loseHealth(double x) {
		health = ((byte) (health - x));
	}

	/** Returns absolute x!! */
	public int getX() {
		return x;
	}

	/** Returns absolute y!! */
	public int getY() {
		return y;
	}

	public double getHealth() {
		return health;
	}

	public void goTo(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void followPath() {
		if (getLoc() == target) {
			getDirections();
			return;
		}

		int dx;
		int dy;
		if (x < (target[0] * Game.interval)) { // Right
			dx = Game.interval / 10 * speed;
		} else { // Left
			dx = Game.interval / 10 * -speed;
		}

		if (y > (target[1] * Game.interval)) { // Up
			dy = Game.interval / 10 * speed;
		} else { // Down
			dy = Game.interval / 10 * -speed;

		}
		move(dx, dy);
	}

	private void move(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void draw(Graphics g) {
		g.drawImage(this.getImage(), x, y, null);
	}

	public byte[] getLoc() {
		return new byte[] { (byte) (x / Game.interval), (byte) (y / Game.interval) };
	}

	protected Image getImage() {
		return img;
	}

	/** Somehow update directions */
	public abstract int getDirections();

	public void die() {

		this.img = getDieImg()[stage];
	}

	protected abstract Image[] getDieImg();

	protected void walk() {
		this.img = getWalkImg()[stage];
	}

	protected abstract Image[] getWalkImg();

	public void run() {
		if (this.health <= 0) {
			if (alive) {
				alive = !alive;
				stage = 0;
			}
			die();
		} else {
			followPath();
			walk();
		}
		stage++;
	}

	public boolean isDead() {
		return !alive && stage >= 6;
	}

	public boolean needsNewDir() {
		return this.needsNewDir;
	}

	public void setTarget(byte[] target) {
		this.target = target;
	}

	public byte getValue() {
		return value;
	}

}