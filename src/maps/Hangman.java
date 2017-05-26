package maps;

public class Hangman implements Map {

	@Override
	public byte getStateAt(int x, int y) {
		return getStateArr()[y][x];
	}

	@Override
	public byte[][] getStateArr() {
		byte temp[][] = { { 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 5, 0, 0, 0, 6, 10, 10, 10, 10, 10, 10, 10, 10, 12 },
				{ 0, 5, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 5 }, { 0, 5, 0, 0, 0, 3, 10, 10, 10, 10, 10, 10, 12, 0, 5 },
				{ 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 5 }, { 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 5 },
				{ 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 5 }, { 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 5 },
				{ 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 5 },
				{ 0, 3, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 9, 0, 5 } };
		return temp;
	}

	@Override
	public byte getDirAt(int x, int y) {
		return getDirArr()[y][x];
	}

	@Override
	public byte[][] getDirArr() {
		byte[][] temp = { { 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 3, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3 }, { 0, 3, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3 },
				{ 0, 3, 0, 0, 0, 4, 4, 4, 4, 4, 4, 4, 4, 0, 3 }, { 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 3 },
				{ 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 3 }, { 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 3 },
				{ 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 3 }, { 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 3 },
				{ 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 5 },

		};
		return temp;
	}

	@Override
	public byte[] getStartingLocation() {
		byte temp[] = { 1, 0 };
		return temp;
	}

	@Override
	public byte[] getEndingLocation() {
		byte temp[] = { 4, 0 };
		return temp;
	}
}
