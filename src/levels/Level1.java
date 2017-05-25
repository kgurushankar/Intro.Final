package levels;

import maps.Map;
import maps.*;

public class Level1 implements Level {
	Map map;

	public Level1() {
		int x = (int) (Math.random() * 2);
		x = 1;
		if (x == 0) {
			map = new Snake();
		} else if (x == 1) {
			map = new SnakeHorizontal();
		}
	}

	@Override
	public Map getMap() {
		// TODO Auto-generated method stub
		return map;
	}

	@Override
	public byte[] getEnemyatTicks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte getEnemyatTick(int tick) {
		return getEnemyatTicks()[tick];
	}

}
