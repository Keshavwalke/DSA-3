package binarySearch1;

public class LastOccurenctOfElement {
	public static int solve(int A[], int K) {
		int N = A.length;
		int high = N - 1;
		int low = 0;
		int ans = -1;
		while (low <= high) {
			int mid = (high + low) / 2;
			if (A[mid] == K) {
				ans=mid;
				high=mid-1;
			} else if (A[mid] > K) {
				high=mid-1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int A[]= {3,3,4,5,5,6,7,8,8,9};
		int K=3;
		System.out.println(solve(A,K));
	}

}
