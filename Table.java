public class Table {
	int[][] table;
	int[] columns;
	int[] lines;
	public Table(int dim) {
		table = new int[dim][dim];
		lines = new int[dim];
		columns = new int[dim];
	}

	public void print() {
		int c = 'a' + table.length - 1;
		for(int[] n1: table) {
			System.out.print("  ");

			for(int i = 0; i < n1.length; i++) {
				System.out.print(" -");

			}
			System.out.println();
			System.out.print((char)c);
			System.out.print(' ');

			c --;

			System.out.print('|');
			for(int n2: n1) {
				System.out.print(n2);
				System.out.print('|');

			}
			System.out.println();
		}
		System.out.print("  ");
		for(int i = 0; i < table.length; i++) {
			System.out.print(' ');

			System.out.print(i+1);

		}
		System.out.println();

	}

	public int get_size() {
		return table.length;
	}
	public boolean is_occupied(int l, int c) {
		if( l < 0 || c < 0) {
			return false;
		}
		if (table[c][l] == 0) 
			return false;
		return true;
	}

	public int move(int l, char c, int val) {
		int sc = 21;
		int col = (int)(c - 'a');
		col = table.length - col - 1;
		//l--;
		table[col][l] = val;
		columns[col] += val;
		lines[l] += val;
		if(columns[col] > sc || lines[l] > sc) {
			return -1;
		}else if(columns[col] == sc || lines[l] == sc) {
			return 1;
		}

		return 0;
	}
}

