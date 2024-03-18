abstract public class Player {
	int[] set;

	Player(int[] s) {
		set = s;
	}

	abstract int[] play(Table t) ;

}
