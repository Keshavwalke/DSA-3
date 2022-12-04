package queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

//		Given an array of integers A. There is a sliding window of size B, 

//		moving from the very left of the array to the very right. 
//		You can only see the B numbers in the window. Each time the sliding window 
//		moves rightwards by one position. You have to find the maximum for each window.
//		Return an array C, where C[i] is the maximum value in the array from A[i] to A[i+B-1].
//		Refer to the given example for clarity.
//		NOTE: If B > length of the array, return 1 element with the max of the array.
//				Input :									Output:
//					 A = [1, 3, -1, -3, 5, 3, 6, 7]				 [3, 3, 5, 5, 6, 7]
//					 B = 3

public class SlidingWindowMaximum {
	// Using Dequeue
	public static int[] solve(int A[], int B) {
		int N = A.length;
		int ans[] = new int[N - B + 1];
		Deque<Integer> dq = new LinkedList<>();
		for (int i = 0; i < B; i++) {
			while (dq.size() > 0 && dq.getLast() < A[i]) {
				dq.removeLast();
			}
			dq.addLast(A[i]);
		}
		ans[0] = dq.getFirst();

		int index = 1;
		for (int i = B; i < N; i++) {
			while (dq.size() > 0 && dq.getLast() < A[i]) {
				dq.removeLast();
			}
			dq.addLast(A[i]);
			if (dq.getFirst() == A[i - B]) {
				dq.removeFirst();
			}
			ans[index] = dq.getFirst();
			index++;
		}
		return ans;

	}

	// Using TreeMap
	public static int[] slidingMaximum(final int[] A, int B) {
		int N = A.length;
		int ans[] = new int[N - B + 1]; // created ans array of lenght N-B+1

		TreeMap<Integer, Integer> st = new TreeMap<>(); // created treemap and inserted first window
		for (int i = 0; i < B; i++) {
			if (st.containsKey(A[i])) {
				st.put(A[i], st.get(A[i]) + 1);
			} else {
				st.put(A[i], 1);
			}
		}
		ans[0] = st.lastKey(); // added first max to result array

		int index = 1;
		for (int i = B; i < N; i++) {
			st.put(A[i - B], st.get(A[i - B]) - 1);
			if (st.containsKey(A[i])) {
				st.put(A[i], st.get(A[i]) + 1);
			} else {
				st.put(A[i], 1);
			}
			if (st.get(A[i - B]) == 0) { // removing the frequency
				st.remove(A[i - B]);
			}
			ans[index] = st.lastKey(); // added max to ans array
			index++;
		}
		return ans;
	}

	public static void main(String[] args) {
		int A[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int B = 3;
		int[] ans = slidingMaximum(A, B);
		for (int i : ans) {
			System.out.print(i + " ");
		}
		System.out.println();
		int[] ans2 = solve(A, B);
		for (int i : ans2) {
			System.out.print(i + " ");
		}
	}

}
