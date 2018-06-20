package problem.array;

/**
 * Find the Missing Number. You are given a list of n-1 integers and these
 * integers are in the range of 1 to n. There are no duplicates in list. One of
 * the integers is missing in the list. Write an efficient code to find the
 * missing integer.
 * 
 * @author Suraj
 *
 */
public class MissingNumber {

	public static void main(String[] args) {
		int numbers[] = { 1, 2, 4, 5, 6 };
		int missingNumberBySum = getMissingNumberBySum(numbers, 5);
		System.out.println(missingNumberBySum);

		int missingNumberByXOR = getMissingNumberByXOR(numbers, 5);
		System.out.println(missingNumberByXOR);

	}

	/**
	 * Use sum formula Algorithm: Get the sum of numbers total = n*(n+1)/2 2.
	 * Subtract all the numbers from sum and you will get the missing number.
	 * 
	 * Drawback of the approach is, if n is large then there can be integer
	 * overflow.
	 */
	private static int getMissingNumberBySum(int[] numbers, int n) {
		int total = (n + 1) * (n + 2) / 2;
		for (int i = 0; i < numbers.length; i++) {
			total -= numbers[i];
		}
		return total;
	}

	/**
	 * Use XOR)
	 * XOR all the array elements, let the result of XOR be X1.
	 * XOR all numbers from 1 to n, let XOR be X2.
	 * XOR of X1 and X2 gives the missing number.
	 */
	private static int getMissingNumberByXOR(int[] numbers, int n) {
		// XOR all array elements
		int x1 = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			x1 ^= numbers[i];
		}

		// XOR all numbers
		int x2 = 1;
		for (int i = 2; i <= n + 1; i++) {
			x2 ^= i;
		}
		int missingNumber = x1 ^ x2;
		return missingNumber;
	}

}
