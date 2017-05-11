package levels;

import maps.Map;

public class FileLevel implements Level {
	Map map;

	public FileLevel(Map map) {
		this.map = map;
	}

	@Override
	public Map getMap() {
		return map;
	}

}
