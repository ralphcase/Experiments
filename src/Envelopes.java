import java.util.Arrays;
import java.util.Random;

public class Envelopes {
	
	private static final int SIZE = 100;
	static int[] Envelopes = new int[SIZE];

	public static void main(String[] args) {
		shuffle();
//		System.out.println(Arrays.toString(Envelopes));
//		System.out.println(maxLoopSize());
		
		System.out.println("Fraction of wins: "+ wins(1000000));
	}
	
	static double wins(int tries) {
		int win =0;
		for (int i = 0; i<tries; i++) {
			shuffle();
			if (maxLoopSize() <=SIZE/2) win++;
		}
		return win/(double)tries;
	}
	
	static void shuffle() {
		fill();
		// Loop through each card in the deck and swap it with a random card.
		Random rand = new Random();
		for (int i = 0; i < SIZE; i ++) {
			int index = rand.nextInt(SIZE);
			int temp = Envelopes[i];
			Envelopes[i] = Envelopes[index];
			Envelopes[index] = temp;
			}
		}


	private static void fill() {
		for (int i = 0; i < SIZE; i ++)
			Envelopes[i] = i;
	}
	
	private static int maxLoopSize() {
		int max = 0;
		for (int i = 0; i < SIZE; i++) {
			max = Math.max(max, loopSize(i));
		}
		return max;
	}
	
	private static int loopSize(int n) {
		int start = n;
		int count = 0;
		do {
			n = Envelopes[n];
			count++;
		} 
		while (n != start);
		return count;
	}

}
