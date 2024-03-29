import java.util.Random;
import java.util.Scanner;

public final class Human extends Player{

	Human(int[] v) {
		super(v);
	}

	boolean _isvalue(int val) {
		for(int e: set) {
			if(e == val) {
				return true;
			}
		}
		return false;
	}

	@Override
	int[] play(Table t) {
		int l = t.get_size();
		int c;
		int d;
		int v;
		char[] s;
		String pos;
		Scanner input = new Scanner(System.in);
		boolean acc = true;
		do {
			System.out.print("Play: ");
	   		pos = input.nextLine();
			pos = pos.replace(" ", "");
			s = pos.toCharArray();
			v = (int)(s[0] - '0');
			c = l - 1 - (int)(s[1] - 'a');
			d = (int)(s[2] - '0');
			d--;
			if(!_isvalue(v)) {
				System.out.println("Not an available value");
			
			}
			acc = true;
			if( d >= l || d < 0) {
				System.out.println("Not an available line");
				acc = false;
			}
			if( c >= l || c < 0) {
				System.out.println("Not an available column");
				acc = false;

			}
			
		} while(!acc || t.is_occupied(d, c) || !_isvalue(v));

		int[] rez = new int[]{d, c, v};


		return rez;
	}	
}
