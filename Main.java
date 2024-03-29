import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	Table table = new Table(4);
	int[] set1 = new int[]{3, 5, 7};
	int[] set2 = new int[]{4, 6, 8};
	
	Human n1 = new Human(set1);
	NPC n2 = new NPC(set2);

	int[] move;
	int win;
	System.out.println("Your values are:");
	for(int e : set1) {
		System.out.print(e);
		System.out.print(" ");
	System.out.println();
	while(true) {
		//table.print();
		move = n1.play(table);
		System.out.println("Player 1 plays");
		win = table.move(move[0], (char)(move[1] + 'a'), move[2]);
		table.print();
		if(win == 1) {
			System.out.println("Player 1 wins");
			break;
		}else if(win == -1) {
			System.out.println("Player 1 loses");
			break;
		}
		System.out.println();

		move = n2.play(table);
		System.out.println("Player 2 plays");
		win = table.move(move[0], (char)(move[1] + 'a'), move[2]);
		table.print();
		if(win == 1) {
			System.out.println("Player 2 wins");
			break;
		}else if(win == -1) {
			System.out.println("Player 2 loses");
			break;
		}
		System.out.println();


	}

	}
}
}
