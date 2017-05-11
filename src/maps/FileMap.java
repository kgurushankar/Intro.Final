package maps;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FileMap implements Map {
	private byte[][] state;
	private byte[][] dir;
	private byte[] start;
	private byte[] end;

	/**
	 * File format 10 lines of 15 pairs of data<br />
	 * format of a line should be
	 * <table>
	 * <tr>
	 * <td>state,direction</td>
	 * <td>state,direction</td>
	 * <td>state,direction</td>
	 * <td>state,direction</td>
	 * <td>state,direction</td>
	 * <td>state,direction</td>
	 * <td>state,direction</td>
	 * <td>state,direction</td>
	 * <td>state,direction</td>
	 * <td>state,direction</td>
	 * <td>state,direction</td>
	 * <td>state,direction</td>
	 * <td>state,direction</td>
	 * <td>state,direction</td>
	 * <td>state,direction</td>
	 * </tr>
	 * </table>
	 * so 15 state,direction pairs separated by spaces
	 */
	public FileMap(String file) {
		File src = new File(file);
		BufferedReader f = null;
		try {
			f = new BufferedReader(new FileReader(src));
		} catch (FileNotFoundException e) {
			e.printStackTrace(System.err);
			return;
		}
		try {
			for (int i = 0; i < 10; i++) {
				StringTokenizer st = new StringTokenizer(f.readLine());
				for (int j = 0; j < 15; j++) {
					String[] temp = st.nextToken().split(",");
					state[i][j] = Byte.parseByte(temp[0]);
					dir[i][j] = Byte.parseByte(temp[1]);
				}
			}
		} catch (Exception e) {

		}

	}

	@Override
	public byte getStateAt(int x, int y) {
		return getStateArr()[x][y];
	}

	@Override
	public byte[][] getStateArr() {
		// TODO Auto-generated method stub
		return state;
	}

	@Override
	public byte getDirAt(int x, int y) {
		// TODO Auto-generated method stub
		return getDirArr()[x][y];
	}

	@Override
	public byte[] getStartingLocation() {
		// TODO Auto-generated method stub
		return start;
	}

	@Override
	public byte[] getEndingLocation() {
		// TODO Auto-generated method stub
		return end;
	}

	@Override
	public byte[][] getDirArr() {
		// TODO Auto-generated method stub
		return dir;
	}

}
