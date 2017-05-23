package field.tower;

import java.awt.Image;

import view.Game;

public class CatTower extends Tower {
	private Image img = super.loadImageFromFile("Cat.png");

	public CatTower(byte x, byte y, Game g) {
		super(x, y, 10, (byte) 5, 100, g);
	}

	@Override
	public Image getImage() {
		return img;

	}

}
