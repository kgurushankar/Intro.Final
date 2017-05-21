package field.enemy;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

import field.Item;
import view.Game;

public abstract class Enemy extends Item{
	private int health;
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

	public Enemy(int x, int y, int health, byte speed, byte value) {
		super(x,y,speed,value);
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
		if (getLoc() == target) {
			this.needsNewGoal = true;
		}

		int dx;
		int dy;
		if (x < (target[0] * Game.interval)) { // Right
			dx = Game.interval / 20 * speed;
		} else { // Left
			dx = Game.interval / 20 * -speed;
		}

		if (y > (target[1] * Game.interval)) { // Up
			dy = Game.interval / 20 * speed;
		} else { // Down
			dy = Game.interval / 20 * -speed;

		}
		move(dx, dy);
	}

	private void move(int x, int y) {
		this.x = x;
		this.y = y;
	}

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
		return this.needsNewGoal;
	}

	public void setTarget(byte[] target) {
		this.target = target;
		this.needsNewGoal = false;
	}

	protected Image loadImageFromFile(String FileLoc) {
		return super.loadImageFromFile("Orc/"+FileLoc);

	}

}