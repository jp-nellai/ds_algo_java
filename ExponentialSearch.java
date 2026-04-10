import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ExponentialSearch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Enter number of elements");
			int size = sc.nextInt();

			if (size <= 0) {
				System.out.println("Array size must be positive");
				return;
			}

			int[] arr = new int[size];
			System.out.println("Enter " + size + "sorted integers");
			for (int i = 0; i < size; i++) {
				arr[i] = sc.nextInt();
			}

			Arrays.sort(arr);

			System.out.println("Enter the target integer");
			int target = sc.nextInt();

			int result = exponentialSearch(arr, target);

			if (result != -1) {
				System.out.println("Element found at the index " + result + " of the array");
			} else {
				System.out.println("Element not found in the array");
			}
		} catch (IllegalStateException ise) {
			System.err.println("Scanner might have been closed and read cannot be done");
		} finally {
			sc.close();
		}

	}

	public static int binarySearch(int[] arr, int low, int high, int target) {
		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (arr[mid] == target)
				return mid;

			if (arr[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}

		}
		return -1;
	}

	public static int exponentialSearch(int[] arr, int target) {
		int n = arr.length;

		if (n == 0)
			return -1;
		if (arr[0] == target)
			return 0;

		int bound = 1;
		while (bound < n && arr[bound] <= target) {
			bound *= 2;
		}

		return binarySearch(arr, bound / 2, Math.min(bound, n - 1), target);
	}

}