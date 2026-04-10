import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class BinarySearchRecursive {

	public static void main(String[] args) {
		int[] arr = { 24, 42, 51, 12, 60, 15, 54, 27, 72, 78 };
		Arrays.sort(arr);

		int low = 0, high = arr.length - 1;
		Scanner scanner = new Scanner(System.in);
		int target = 0;
		try {
			System.out.println("Enter the number to search");
			target = scanner.nextInt();
		} catch (IllegalStateException ise) {
			System.err.println("Scanner might have been closed and read cannot be done");
		} finally {
			scanner.close();
		}
		System.out.println("Sorted Array is : " + Arrays.toString(arr));
		int index = binarySearch(arr, low, high, target);

		System.out.println("Target found in the following index " + index);
	}

	public static int binarySearch(int[] arr, int low, int high, int target) {
		int mid = low + (high - low) / 2;

		if (arr[mid] == target) {
			return mid;
		}

		if (arr[mid] < target) {
			return binarySearch(arr, mid + 1, high, target);
		} else {
			return binarySearch(arr, low, mid - 1, target);
		}

	}

}
