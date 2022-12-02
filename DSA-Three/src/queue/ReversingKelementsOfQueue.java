package queue;

import java.util.Stack;

//		Given an array of integers A and an integer B, we need to reverse the 
//		order of the first B elements of the array, leaving the other elements in the same relative order.
//		NOTE: You are required to the first insert elements into an auxiliary 
//		queue then perform Reversal of first B elements.
//		Input 1:						Output 1:
//			 A = [1, 2, 3, 4, 5]				[3, 2, 1, 4, 5]
//			 B = 3

public class ReversingKelementsOfQueue {
	public static int[] solve(int[] A, int B) {
		int N = A.length;
		Stack<Integer> st = new Stack<Integer>(); // created stack
		for (int i = 0; i < B; i++) { // pushed first B elements in stack
			st.push(A[i]);
		}
		int res[] = new int[N]; // created ans array
		for (int i = B; i < N; i++) { // kept last element as is
			res[i] = A[i];
		}
		for (int i = 0; i < B; i++) {
			res[i] = st.pop(); // pushed elements from stack to array automatically they'll be reverse
		}
		return res;
	}

	public static void main(String[] args) {
		int A[] = { 1, 2, 3, 4, 5 };
		int B = 3;
		int[] ans = solve(A, B);
		for (int i : ans) {
			System.out.print(i + " ");
		}

	}

}
