package field.tower;

import java.awt.Image;

import view.Game;

public class RabbitTower extends Tower {

	public RabbitTower(byte x, byte y, Game g) {
		super(x, y, (byte) 150, (byte) 1, (byte) 200, g);
	}

	@Override
	protected Image getImage() {
		return super.loadImageFromFile("Rabbit.png");

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
