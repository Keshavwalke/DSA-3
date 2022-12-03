package queue;

import java.util.LinkedList;
import java.util.Queue;

//		Given an integer A, you have to find the Ath Perfect Number.

//		A Perfect Number has the following properties:
//		It comprises only 1 and 2.
//		The number of digits in a Perfect number is even.
//		It is a palindrome number.
//		For example, 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.
//		Input :				Output:
//			 A = 3				1111

public class PerfectNumbers {
	public static String solve(int A) {
		Queue<String> q = new LinkedList<String>(); // created que
		q.add("11"); // Inserted first 2 elements
		q.add("22");

		for (int i = 0; i < A - 1; i++) { // removed the first A-1 elements from queue

			String element = q.remove(); // removed element
			int len = (element.length()) / 2; // found out length of element
			String ans1 = "";
			for (int j = 0; j < len; j++) {
				ans1 = ans1 + element.charAt(j); // filled ans1 string upto middle
			}
			ans1 = ans1 + "11"; // added 11 after middle
			for (int k = len; k < (2 * len); k++) {
				ans1 = ans1 + element.charAt(k); // filled ans1 string after middle+2 to end
			}

			String ans2 = "";
			for (int j = 0; j < len; j++) {
				ans2 = ans2 + element.charAt(j); // filled ans2 string upto middle
			}
			ans2 = ans2 + "22"; // added 22 after middle
			for (int k = len; k < 2 * len; k++) {
				ans2 = ans2 + element.charAt(k); // filled ans2 string after middle+2 to end
			}

			q.add(ans1); // added ans1 and ans2 to queue
			q.add(ans2);

		}
		return q.peek(); // peek element will be our ans
	}

	public static void main(String[] args) {
		int A=5;
		System.out.println(solve(A));

	}

}
