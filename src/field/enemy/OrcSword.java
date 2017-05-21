package field.enemy;

import java.awt.Image;

public class OrcSword extends Enemy {
	private Image[] die;
	private Image[] walk;

	public OrcSword(int x, int y) {
		super(x, y, 150, (byte) 7, (byte) 15);
		String fileloc = "Sword/DIE/DIE_00";
		die = new Image[7];
		for (int i = 0; i < 7; i++) {
			die[i] = super.loadImageFromFile(fileloc + i + ".png");
		}
		fileloc = "Sword/WALK/WALK_00";
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
