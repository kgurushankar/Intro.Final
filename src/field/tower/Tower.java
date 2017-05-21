package field.tower;

import java.awt.Graphics;
import java.awt.Image;

import view.Game;

public abstract class Tower {

	protected byte x;
	protected byte y;
	protected byte power;

	public Tower(byte x, byte y, byte power) {
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

	protected abstract void attack();
}
