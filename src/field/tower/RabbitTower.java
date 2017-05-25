package field.tower;

import java.awt.Image;

import view.Game;

public class RabbitTower extends Tower {
	private Image img = super.loadImageFromFile("Rabbit.png");

	public RabbitTower(byte x, byte y, Game g) {
		super(x, y, 150, (byte) 1, 200, g);
	}

	@Override
	public Image getImage() {
		return img.getScaledInstance((int) (Game.interval * .9), (int) (Game.interval * .9), Image.SCALE_SMOOTH);

	}
}
