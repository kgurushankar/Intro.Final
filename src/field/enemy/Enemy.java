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
	private byte stage = 0;
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
		if (getLoc() == target) {
			byte[] loc = this.getLoc();
			byte dir = Game.getLevel().getMap().getDirAt(loc[0], loc[1]);
			if (dir == 1) { // up
				this.setTarget(new byte[] { loc[0], (byte) (loc[1] + 1) });
			} else if (dir == 2) {// left
				this.setTarget(new byte[] { (byte) (loc[0] + 1), loc[1] });
			} else if (dir == 3) {// down
				this.setTarget(new byte[] { loc[0], (byte) (loc[1] - 1) });
			} else if (dir == 4) {// right
				this.setTarget(new byte[] { (byte) (loc[0] - 1), loc[1] });
			} else if (dir == 5) {// end
				game.removeEnemy(this);
				game.loseLife();
			}
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
		game.balance(this.value);
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
		return super.loadImageFromFile("Orc/" + FileLoc);

	}

	/* Remove this to re enable animation */
	public Image getImage() {
		return getWalkImg()[0];
	}

}