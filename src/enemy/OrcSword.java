package enemy;

import java.awt.Image;

public class OrcSword extends Enemy {

	public OrcSword(int x, int y) {
		super(x, y, 150, (byte) 7, (byte) 15);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Image[] getDieImg() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Image[] getWalkImg() {
		// TODO Auto-generated method stub
		return null;
	}

}