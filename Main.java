import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	Table table = new Table(4);
	int winner = 0;
	int val;
	char[] vs;
	String pos;
	do {
		table.print();
		System.out.println("Player 1 input: ");
		val = input.nextInt();
		pos = input.nextLine();
		vs = pos.toCharArray();
		winner = table.move((int)(vs[2] - '0'), vs[1], val);
		if (winner == 1) {
			System.out.println("Player 1 wins");
			break;
		} else if (winner == -1) {
			System.out.println("Player 2 wins");
			break;
		}
		table.print();
		System.out.println("Player 2 input: ");
		val = input.nextInt();
		pos = input.nextLine();
		vs = pos.toCharArray();
		winner = table.move((int)(vs[2] - '0'), vs[1], val);
		if (winner == 1) {
			System.out.println("Player 2 wins");
			break;
		} else if (winner == -1) {
			System.out.println("Player 1 wins");
			break;
		}


	}while(true);
	}
}

class Table {
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

	public int move(int l, char c, int val) {
		int sc = 15;
		int col = (int)(c - 'a');
		col = table.length - col - 1;
		l--;
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
