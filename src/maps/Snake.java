package maps;

public class Snake implements Map {

	@Override
	public byte getStateAt(int x, int y) {
		return getStateArr()[x][y];
	}

	@Override
	public byte[][] getStateArr() {
		byte temp[][] = { 
				{ 6, 10, 12, 0, 0, 6, 10, 12, 0, 0, 0, 0, 0, 0, 0 },
				{ 5, 0, 5, 0, 0, 5, 0, 5, 0, 0, 0, 0, 0, 0, 0 },
				{ 5, 0, 5, 0, 0, 5, 0, 5, 0, 0, 6, 12, 0, 0, 0 },
				{ 9, 0, 5, 0, 0, 5, 0, 5, 0, 6, 9, 3, 12, 0, 0 }, 
				{ 0, 0, 5, 0, 0, 5, 0, 5, 0, 5, 0, 0, 5, 0, 0 },
				{ 0, 0, 5, 0, 0, 5, 0, 5, 0, 5, 0, 0, 5, 0, 0 }, 
				{ 0, 0, 5, 0, 0, 5, 0, 5, 0, 3, 12, 0, 3, 10, 10 },
				{ 0, 0, 5, 0, 0, 5, 0, 5, 0, 0, 5, 0, 0, 0, 0 },
				{ 0, 0, 5, 0, 6, 9, 0, 3, 12, 0, 5, 0, 0, 0, 0 },
				{ 0, 0, 3, 10, 9, 0, 0, 0, 3, 10, 9, 0, 0, 0, 0 } };
		return temp;
	}

	@Override
	public byte getDirAt(int x, int y) {
		return getDirArr()[x][y];
	}

	@Override
	public byte[][] getDirArr() {
		byte[][] temp = { 
				{ 2, 2, 3, 0, 0, 2, 2, 3, 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 0, 3, 0, 0, 1, 0, 3, 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 0, 3, 0, 0, 1, 0, 3, 0, 0, 2, 3, 0, 0, 0 },
				{ 1, 0, 3, 0, 0, 1, 0, 3, 0, 2, 1, 2, 3, 0, 0 },
				{ 0, 0, 3, 0, 0, 1, 0, 3, 0, 1, 0, 0, 3, 0, 0 },
				{ 0, 0, 3, 0, 0, 1, 0, 3, 0, 1, 0, 0, 3, 0, 0 },
				{ 0, 0, 3, 0, 0, 1, 0, 3, 0, 1, 4, 0, 2, 2, 5 },
				{ 0, 0, 3, 0, 0, 1, 0, 3, 0, 0, 1, 0, 0, 0, 0 },
				{ 0, 0, 3, 0, 2, 1, 0, 2, 3, 0, 1, 0, 0, 0, 0 },
				{ 0, 0, 2, 2, 1, 0, 0, 0, 2, 2, 1, 0, 0, 0, 0 } };
		return temp;
	}

	@Override
	public byte[] getStartingLocation() {
		byte temp[] = { 0, 0 };
		return temp;
	}

	@Override
	public byte[] getEndingLocation() {
		byte temp[] = { 14, 9 };
		return temp;
	}

}
