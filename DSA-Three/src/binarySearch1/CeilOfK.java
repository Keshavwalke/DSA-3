package binarySearch1;
//Given a sorted array find the ceil of given number K
//here ceil means smallest element >=K in array

public class CeilOfK {
	public static int solve(int A[], int K) {
		int N = A.length;
		int low = 0;
		int high = N - 1;
		int ans = Integer.MAX_VALUE;
		while (low <= high) {
			int mid = (high + low) / 2;
			if (A[mid] == K) {
				return A[mid];
			} else if (A[mid] > K) {
				ans = A[mid];
				high = mid - 1;
			} else {
				low = mid + 1;
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
