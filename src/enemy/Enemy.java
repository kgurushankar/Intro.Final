package enemy;

import java.awt.Image;

public abstract class Enemy {
	protected byte x;
	protected byte y;

	public Enemy() {
		// TODO Auto-generated constructor stub
	}

	public void draw(Graphics g, int interval) {

	}

	public abstract Image getImage();

}
