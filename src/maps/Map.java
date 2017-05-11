package maps;

public interface Map {
	/**
	 * Returns state of the tile at (x,y)
	 * 
	 * @return add appropriate values below if there is a connection to the side
	 *         <table>
	 *         <tr>
	 *         <td></td>
	 *         <td>+1</td>
	 *         <td></td>
	 *         </tr>
	 *         <tr>
	 *         <td>+8</td>
	 *         <td></td>
	 *         <td>+2</td>
	 *         </tr>
	 *         <tr>
	 *         <td></td>
	 *         <td>+4</td>
	 *         <td></td>
	 *         </tr>
	 *         </table>
	 * 
	 * @see maps.Map#getStateArr()
	 */
	byte getStateAt(int x, int y);

	/**
	 * Returns complete map data for this level
	 * 
	 * @see maps.Map#getStateAt(int x,int y)
	 */
	byte[][] getStateArr();

	/**
	 * Gets the direction to move from the cell at (x,y)
	 * 
	 * @return
	 *         <table>
	 *         <tr>
	 *         <td>0</td>
	 *         <td>not part of path</td>
	 *         </tr>
	 *         <tr>
	 *         <td>1</td>
	 *         <td>up</td>
	 *         </tr>
	 *         <tr>
	 *         <td>2</td>
	 *         <td>right</td>
	 *         </tr>
	 *         <tr>
	 *         <td>3</td>
	 *         <td>down</td>
	 *         </tr>
	 *         <tr>
	 *         <td>4</td>
	 *         <td>left</td>
	 *         </tr>
	 *         <tr>
	 *         <td valign="top">5</td>
	 *         <td>ending point <br />
	 *         This triggers a call to check if the enemy is at the ending point
	 *         </td>
	 *         </tr>
	 */
	byte getDirAt(int x, int y);

	/**
	 * Gets the starting point for the map
	 * 
	 * @return {x,y}
	 */
	byte[] getStartingLocation();

	/**
	 * Returns the ending point for the map
	 * 
	 * @return {x,y}
	 */
	byte[] getEndingLocation();
}