import java.util.Arrays;
import java.util.Random;

public class Envelopes {
	
	private static final int SIZE = 100;
	static int[] Envelopes = new int[SIZE];

	public static void main(String[] args) {
//		shuffle();
//		System.out.println(Arrays.toString(Envelopes));
//		System.out.println(maxLoopSize());
		
		System.out.println("Fraction of wins: "+ wins(1000000));
	}
	
	/*
	 * Return the fraction of wins over the given number of tries.
	 */
	static double wins(int tries) {
		int win =0;
		for (int i = 0; i<tries; i++) {
			shuffle();
			if (maxLoopLength() <=SIZE/2) win++;
		}
		return win/(double)tries;
	}
	
	/*
	 * Shuffle the slips in the Envelopes.
	 */
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
	
	/*
	 * Return the maximum loop length.
	 */
	private static int maxLoopLength() {
		int max = 0;
		for (int i = 0; i < SIZE; i++) {
			max = Math.max(max, loopLength(i));
		}
		return max;
	}
	
	/*
	 * Measure the length of the loop staring at the given index.
	 */
	private static int loopLength(int n) {
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
