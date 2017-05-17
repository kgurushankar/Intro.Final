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

	/**
	 * Index represents the tick<br />
	 * The value is the enemy that comes at the tick <br />
	 * Ticks are 50ms each <br />
	 * <br />
	 * <table>
	 * <tr>
	 * <th>ID</th>
	 * <th>Enemy</th>
	 * </tr>
	 * <tr>
	 * <td>0</td>
	 * <td>Orc with Hammer</td>
	 * </tr>
	 * <tr>
	 * <td>1</td>
	 * <td>Orc with Sword</td>
	 * </tr>
	 * <tr>
	 * <td>2</td>
	 * <td>Orc with Axe</td>
	 * </tr>
	 * </table>
	 * 
	 * @see levels.Level#getEnemyatTick(int)
	 */
	byte[] getEnemyatTicks();

	/**
	 * The value is the enemy that comes at the tick<br />
	 * Ticks are 50ms each <br />
	 * <br />
	 * 
	 * <table>
	 * <tr>
	 * <th>ID</th>
	 * <th>Enemy</th>
	 * </tr>
	 * <tr>
	 * <td>0</td>
	 * <td>Orc with Hammer</td>
	 * </tr>
	 * <tr>
	 * <td>1</td>
	 * <td>Orc with Sword</td>
	 * </tr>
	 * <tr>
	 * <td>2</td>
	 * <td>Orc with Axe</td>
	 * </tr>
	 * </table>
	 * 
	 * @see levels.Level#getEnemyatTicks()
	 */
	byte getEnemyatTick(int tick);

}
