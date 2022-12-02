package binarySearch1;

public class SearchTargetElement {
	public static boolean solve(int A[], int target) {
		int N = A.length;
		int low = 0;
		int high = N - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (A[mid] == target)
				return true;
			else if (A[mid] < target)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return false;
	}

	public static void main(String[] args) {
		int A[] = { 1, 4, 6, 8, 20, 22, 25, 27 };
		int target = 20;
		System.out.println(solve(A, target));

	}

}
