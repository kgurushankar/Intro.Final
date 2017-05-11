package levels;

import maps.Map;

/**
 * Represents a level in the Game. <br />
 * Each Level should contain data for the map being used, the enemies, and the
 * path the enemies will take.
 */
public interface Level {
	/** Returns map for this level */
	Map getMap();

	// Some form of enemy sequencing so prob an array that runs off of (timing
	// in ms, enemy type) best bet would be (int/long, byte) but thats hard
}
