package enemy;

import java.awt.Image;

public class OrcAxe extends Enemy {
	private Image[] die;
	private Image[] walk;

	public OrcAxe(int x, int y) {
		super(x, y, 200, (byte) 5, (byte) 20);
		String fileloc = "Axe/DIE/DIE_00";
		die = new Image[7];
		for (int i = 0; i < 7; i++) {
			die[i] = super.loadImageFromFile(fileloc + i + ".png");
		}
		fileloc = "Axe/WALK/WALK_00";
		walk = new Image[7];
		for (int i = 0; i < 7; i++) {
			walk[i] = super.loadImageFromFile(fileloc + i + ".png");
		}
	}

	@Override
	protected Image[] getDieImg() {

		return die;
	}

	@Override
	protected Image[] getWalkImg() {

		return walk;
	}

}
