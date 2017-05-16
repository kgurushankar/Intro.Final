package maps;

public class Maze implements Map {

	@Override
	public byte getStateAt(int x, int y) {
		return getStateArr()[x][y];
	}

	@Override
	public byte[][] getStateArr() {
		byte temp[][] = { 
				{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
				{ 0, 6, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 5 },
				{ 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5 },
				{ 0, 3, 10, 10, 10, 10, 10, 10, 10, 10, 12, 0, 0, 5, 5 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 5, 5 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 5, 5 },
				{ 0, 0, 0, 6, 10, 10, 10, 10, 10, 10, 9, 0, 0, 5, 5 },
				{ 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5 },
				{ 0, 0, 0, 3, 10, 10, 10, 10, 12, 0, 0, 0, 0, 3, 9 } };
		return temp;
	}

	@Override
	public byte getDirAt(int x, int y) {
		return getDirArr()[x][y];
	}

	@Override
	public byte[][] getDirArr() {
		byte[][] temp = { { 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3 }, { 0, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 3 },
				{ 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 3 }, { 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 0, 0, 1, 3 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 3 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 3 },
				{ 0, 0, 0, 3, 4, 4, 4, 4, 4, 4, 4, 0, 0, 1, 3 }, { 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 2, 2, 2, 2, 2, 5, 0, 0, 0, 0, 1, 4 } };
		return temp;
	}

	@Override
	public byte[] getStartingLocation() {
		byte temp[] = { 0, 0 };
		return temp;
	}

	@Override
	public byte[] getEndingLocation() {
		byte temp[] = { 9, 10 };
		return temp;
	}

}
