package stack;

import java.util.Arrays;
import java.util.Stack;

//	Given an array A, find the next greater element G[i] for every element A[i] in the array.
//	The next greater element for an element A[i] is the first greater element on the right side of A[i] in the array, A.
//	More formally:
//	G[i] for an element A[i] = an element A[j] such that 
//	    j is minimum possible AND 
//	    j > i AND
//	    A[j] > A[i]
//	Elements for which no greater element exists, consider the next greater element as -1.
//	Input :						Output :
//		 A = [4, 5, 2, 10] 			 [5, 10, 10, -1] 

public class NextGreater {
	public static int[] solve(int[] A) {
		int N = A.length;
		int result[] = new int[N]; // created result array
		Arrays.fill(result, -1); // filled result array with -1
		Stack<Integer> st = new Stack<>();
		for (int i = N - 1; i >= 0; i--) {
			while (st.size() > 0 && st.peek() <= A[i]) { // popping element until we get greater element than A[i]
				st.pop();
			}
			if (st.size() > 0) {
				result[i] = st.peek(); // top element will be your result[i]
			}
			st.push(A[i]); // pushing whatever element coming
		}
		return result; // return result
	}

	public static void main(String[] args) {
		int A[]= {4, 5, 2, 10};
		int[] ans=solve(A);
		for(int i=0;i<ans.length;i++) {
			System.out.print(ans[i]+" ");
		}
	}
}
