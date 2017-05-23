package field.enemy;

import java.awt.Image;

import view.Game;

public class OrcSword extends Enemy {
	private Image img;

	public OrcSword(int x, int y, Game g) {
		super(x, y, 150, (byte) 7, (byte) 15, g);
		String fileloc = "Sword/WALK/WALK_001.png";
		img = super.loadImageFromFile(fileloc);
	}

	protected Image getImage() {
		return img;
	}

}
