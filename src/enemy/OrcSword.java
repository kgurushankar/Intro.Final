package enemy;

import java.awt.Image;

public class OrcSword extends Enemy {


	public OrcSword(int x, int y) {
		super(x, y, health, speed, value);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getDirections() {
		// TODO Auto-generated method stub
		return 0;
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
