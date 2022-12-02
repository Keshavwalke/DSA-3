package stack;

import java.util.Arrays;
import java.util.Stack;

//		Given an array of integers A.
//		A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.
//		Find the area of the largest rectangle formed by the histogram.
//		Input :								Output:
//			 A = [2, 1, 5, 6, 2, 3]					10

public class LargestRectangleInHistogram {

	public static int largestRectangleArea(int[] A) {
		int N = A.length;

		int ls[] = new int[N];
		Arrays.fill(ls, -1); // created nearest left min array
		Stack<Integer> st1 = new Stack<>();

		for (int i = 0; i < N; i++) {
			while (st1.size() > 0 && A[st1.peek()] >= A[i]) {
				st1.pop(); // Filled values in nearest left array
			}
			if (st1.size() > 0) {
				ls[i] = st1.peek();
			}
			st1.push(i);
		}

		int rs[] = new int[N];
		Arrays.fill(rs, N); // Created nearest right min array initialized with last index+1
		Stack<Integer> st2 = new Stack<>();
		for (int i = N - 1; i >= 0; i--) {
			while (st2.size() > 0 && A[st2.peek()] >= A[i]) {
				st2.pop();
			} // filled values in right array
			if (st2.size() > 0) {
				rs[i] = st2.peek();
			}
			st2.push(i);
		}
		int area = 0;
		for (int i = 0; i < N; i++) {
			int height = A[i];
			int width = (rs[i] - ls[i] - 1); // width will be p2-p-1 cause we exclude both index
			area = Math.max(area, height * width); // calculated max area
		}
		return area;
	}

	public static void main(String[] args) {
		int A[]= {2, 1, 5, 6, 2, 3};
		System.out.println(largestRectangleArea(A));

	}

}
