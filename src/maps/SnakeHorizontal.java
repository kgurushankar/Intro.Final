package maps;

public class SnakeHorizontal implements Map {

	@Override
	public byte getStateAt(int x, int y) {
		// TODO Auto-generated method stub
		return getStateArr()[x][y];
	}

	@Override
	public byte[][] getStateArr() {
		byte temp[][] = { { 3, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
				{ 6, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 9 },
				{ 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 3, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
				{ 6, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 9 },
				{ 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 3, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12 } };
		return temp;
	}

	@Override
	public byte getDirAt(int x, int y) {
		// TODO Auto-generated method stub
		return 0;
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
