package field.enemy;

import java.awt.Image;

public class OrcHammer extends Enemy {
	private Image[] die;
	private Image[] walk;

	public OrcHammer(int x, int y) {
		super(x, y, 100, (byte) 3, (byte) 10);
		String fileloc = "Hammer/DIE/DIE_00";
		die = new Image[7];
		for (int i = 0; i < 7; i++) {
			die[i] = super.loadImageFromFile(fileloc + i + ".png");
		}
		fileloc = "Hammer/WALK/WALK_00";
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
