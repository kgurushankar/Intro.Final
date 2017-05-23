package field.enemy;

import java.awt.Image;

import view.Game;

public class OrcAxe extends Enemy {
	private Image img;

	public OrcAxe(int x, int y, Game g) {
		super(x, y, 200, (byte) 5, (byte) 20, g);
		String fileloc = "Axe/WALK/WALK_001.png";
		img = super.loadImageFromFile(fileloc);
	}

	protected Image getImage() {
		return img;
	}

}
