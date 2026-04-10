import java.util.Arrays;
import java.util.Scanner;

public class JumpSearch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Enter the size of the array");
			int size = sc.nextInt();
			if (size == 0) {
				System.out.println("Please enter a positive integer");
			}

			int[] arr = new int[size];

			for (int i = 0; i < size; i++) {
				arr[i] = sc.nextInt();
			}

			Arrays.sort(arr);

			System.out.println("Enter the element to be found");
			int target = sc.nextInt();

			int result = jumpSearch(arr, target);

			if (result != -1) {
				System.out.println("Element found at index " + result);
			} else {
				System.out.println("Element not found in the array");
			}
		} catch (IllegalStateException ise) {
			System.err.println("Scanner might have been closed and read cannot be done");
		} finally {
			sc.close();
		}
	}

	public static int jumpSearch(int[] arr, int target) {
		int n = arr.length;

		if (n == 0)
			return -1;

		if (arr[0] == target)
			return 0;

		int step = (int) Math.floor(Math.sqrt(n));
		int prev = 0;

		while (prev < n && arr[Math.min(step, n) - 1] < target) {
			prev = step;
			step += (int) Math.floor(Math.sqrt(n));
			if (prev >= n)
				return -1;
		}

		while (prev < Math.min(step, n) && arr[prev] < target) {
			prev++;
		}

		while (prev < n && arr[prev] == target) {
			return prev;
		}
		return -1;
	}

}
