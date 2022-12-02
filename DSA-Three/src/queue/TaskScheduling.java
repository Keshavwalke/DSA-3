package queue;

import java.util.LinkedList;
import java.util.Queue;

//		A CPU has N tasks to be performed. It is to be noted that the tasks have to be completed
//		in a specific order to avoid deadlock. In every clock cycle, the CPU can either perform a 
//		task or move it to the back of the queue. You are given the current state of the scheduler 
//		queue in array A and the required order of the tasks in array B.
//		Determine the minimum number of clock cycles to complete all the tasks.
//		Input 1:					Output 1:
//		A = [2, 3, 1, 5, 4]				10
//		B = [1, 3, 5, 4, 2]
public class TaskScheduling {
	public static int solve(int[] A, int[] B) {
		int N = A.length;
		int ans = 0;
		Queue<Integer> q = new LinkedList<>(); // created queue
		for (int i = 0; i < N; i++) { // filled array A in queue
			q.add(A[i]);
		}
		for (int i = 0; i < N; i++) {
			while (q.peek() != B[i]) { // until head element in not equal to B[i]
				int element = q.remove(); // removed head element added at back
				q.add(element);
				ans++; // increased count each time
			}
			q.remove(); // also removed first element
			ans++;
		}
		return ans;
	}

	public static void main(String[] args) {
		int A[] = { 2, 3, 1, 5, 4 };
		int B[] = { 1, 3, 5, 4, 2 };
		System.out.println(solve(A, B));

	}

}
