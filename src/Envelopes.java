import java.util.Arrays;
import java.util.Random;

public class Envelopes {

	private static final int PRISONERS = 100;
	static int[] Envelopes = new int[PRISONERS];

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

//		shuffle();
//		System.out.println(Arrays.toString(Envelopes));
//		System.out.println(maxLoopSize());

		System.out.println("Fraction of wins: " + wins(1000000));
		chartWins(100000);

		long endTime = System.currentTimeMillis();
		System.out.println("It took " + (endTime - startTime) / 1000.0 + " seconds.");
	}
	
	private static void chartWins(int tries) {
		for (int i = 1; i <= PRISONERS; i++) {
			double val = wins(i, tries);
			System.out.println(i +", "+val);
		}
	}

	private static double wins(int tries) {
		return wins(PRISONERS / 2, tries);
	}

	/*
	 * Return the fraction of wins over the given number of tries.
	 * limit is the number of envelopes allowed to be opened.
	 */
	static double wins(int limit, int tries) {
		fill();
		int win = 0;
		for (int i = 0; i < tries; i++) {
			shuffle();
			if (maxLoopLength() <= limit)
				win++;
		}
		return win / (double) tries;
	}

	/*
	 * Shuffle the slips in the Envelopes.
	 */
	static void shuffle() {
		// Loop through each card in the deck and swap it with a random card.
		Random rand = new Random();
		for (int i = 0; i < PRISONERS; i++) {
			int swap = rand.nextInt(PRISONERS);
			int temp = Envelopes[i];
			Envelopes[i] = Envelopes[swap];
			Envelopes[swap] = temp;
		}
	}

	/*
	 * Initialize the Envelopes array.
	 */
	private static void fill() {
		for (int i = 0; i < PRISONERS; i++)
			Envelopes[i] = i;
	}

	/*
	 * Return the maximum loop length.
	 */
	private static int maxLoopLength() {
		int max = 0;
		for (int i = 0; i < PRISONERS; i++) {
			max = Math.max(max, loopLength(i));
			if (max > PRISONERS / 2)
				break;
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
		} while (n != start);
		return count;
	}

}
