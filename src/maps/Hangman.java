package maps;

public class Hangman implements Map {

		@Override
		public byte getStateAt(int x, int y) {
			return getStateArr()[x][y];
		}

		@Override
		public byte[][] getStateArr() {
			byte temp [][]={
					{0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
					{0, 5, 0, 0, 0, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10},
					{0, 5, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 5},
					{0, 5, 0, 0, 0, 12, 10, 10, 10, 10, 10, 10, 3, 0, 5},
					{0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 5},
					{0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 5},
					{0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 5},
					{0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 5},
					{0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 5},
					{0, 12, 10, 10, 10, 10, 10, 10, 10, 10, 10,10, 6, 0, 5}};
			return temp;
		}

		@Override
		public byte getDirAt(int x, int y) {
			return getDirArr()[x][y];
		}

		@Override
		public byte[][] getDirArr() {
			byte[][]temp = {
					{0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
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
			byte temp[] = {4,0};
			return null;
		}
}
