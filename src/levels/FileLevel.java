package levels;

import maps.Map;

/**
 * <i>NOTE:</i> this class is INCOMPLETE <br />
 * <b>DO NOT USE IT</b>
 */
public class FileLevel implements Level {
	Map map;

	public FileLevel(Map map) {
		this.map = map;
	}

	@Override
	public Map getMap() {
		return map;
	}

	@Override
	public byte[] getEnemyatTicks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte getEnemyatTick(int tick) {
		// TODO Auto-generated method stub
		return 0;
	}

}
