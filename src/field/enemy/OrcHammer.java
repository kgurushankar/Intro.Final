package field.enemy;

import java.awt.Image;

import view.Game;

public class OrcHammer extends Enemy {
	private Image img;

	public OrcHammer(int x, int y, Game g) {
		super(x, y, 100, (byte) 3, (byte) 10, g);
		String fileloc = "Hammer/WALK/WALK_000.png";
		img = super.loadImageFromFile(fileloc);
	}

	protected Image getImage() {
		return img;
	}

}
