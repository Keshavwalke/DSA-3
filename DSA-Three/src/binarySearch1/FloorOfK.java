package binarySearch1;
// Given a sorted array find the floor of given number K
// here floor means greatest element <=K in array

public class FloorOfK {
	public static int solve(int A[], int K) {
		int N = A.length;
		int high = N - 1;
		int low = 0;
		int ans = Integer.MIN_VALUE;
		while (low <= high) {
			int mid = (high + low) / 2;
			if (A[mid] == K) {
				ans = A[mid];
				return ans;
			} else if (A[mid] < K) {
				ans = A[mid];
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int A[] = { 1, 2, 4, 6, 9, 21, 25, 30 };
		int K = 22;
		System.out.println(solve(A, K));
	}

}
