package field.tower;

import java.awt.Image;

import view.Game;

public class BunnyTower extends Tower {
	private Image img = super.loadImageFromFile("Bunny.png");

	public BunnyTower(byte x, byte y, Game g) {
		super(x, y, 50, (byte) 2, 150, g);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Image getImage() {
		return img.getScaledInstance((int) (Game.interval * .9), (int) (Game.interval * .9), Image.SCALE_SMOOTH);
	}

}
