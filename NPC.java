import java.util.Random;

public final class NPC extends Player{

	NPC(int[] v) {
		super(v);
	}

	@Override
	int[] play(Table t) {
		int l = t.get_size();
		Random rand = new Random();
		int c;
		int d;
		do {
			c = rand.nextInt(l);
			d = rand.nextInt(l);

		
		} while(t.is_occupied(d, c));

		int v = rand.nextInt(set.length);
		int[] rez = new int[]{d, c, set[v]};
		//System.out.println(d);
		//System.out.println(c);


		return rez;
	}	
}
