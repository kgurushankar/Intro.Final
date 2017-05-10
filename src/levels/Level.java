package levels;

/**
 * Represents a level in the Game. <br />
 * Each Level should contain data for the map being used, the enemies, and the
 * path the enemies will take.
 */
public interface Level {
	/** Returns state of the tile at (x,y) */
	byte getStateAt(int x, int y);

	/** Returns complete map data for this level */
	byte[][] getStateArr();

	// Some form of enemy sequencing so prob an array that runs off of (timing
	// in ms, enemy type) best bet would be (int/long, byte) but thats hard
}
