package field.tower;

import java.awt.Image;

import view.Game;

public class BunnyTower extends Tower {

	public BunnyTower(byte x, byte y, Game g) {
		super(x, y, (byte) 50, (byte) 2, (byte) 150, g);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Image getImage() {
		return super.loadImageFromFile("Bunny.png");
	}

	@Override
	protected void attack() {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
