package queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//		Given an integer, A. Find and Return first positive A integers 
//		in ascending order containing only digits 1, 2, and 3.
//		NOTE: All the A integers will fit in 32-bit integers.
//		Input 1:			Output 1:
//			 A = 3				 [1, 2, 3]

public class NIntegersContaining1_2_3 {
	public static int[] solve(int A) {
		Queue<Integer> q = new LinkedList<>(); // created queue
		q.add(1);
		q.add(2); // Inserted 1,2,3 in queue
		q.add(3);
		ArrayList<Integer> arr = new ArrayList<>();

		for (int i = 0; i < A; i++) {
			int element = q.remove(); // added first element to ArrayList
			arr.add(element);
			q.add(element * 10 + 1); // from first element generated next numbers and added in queue
			q.add(element * 10 + 2);
			q.add(element * 10 + 3);
		}
		int ans[] = new int[arr.size()];
		for (int i = 0; i < arr.size(); i++) { // converted ArrayList to array
			ans[i] = arr.get(i);
		}
		return ans;
	}

	public static void main(String[] args) {
		int A = 3;
		int ans[] = solve(A);
		for(int i: ans) {
			System.out.print(i+" ");
		}
		

	}

}
