package levels;

import maps.Map;
import maps.SnakeHorizontal;

public class Level1 implements Level {

	@Override
	public Map getMap() {
		// TODO Auto-generated method stub
		return new SnakeHorizontal();
	}

}