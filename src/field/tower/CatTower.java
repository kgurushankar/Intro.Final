package field.tower;

import java.awt.Image;

import view.Game;

public class CatTower extends Tower {

	public CatTower(byte x, byte y, Game g) {
		super(x, y, (byte) 10, (byte) 5, (byte) 100, g);
	}

	@Override
	protected Image getImage() {
		return super.loadImageFromFile("Cat.png");

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
