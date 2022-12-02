package stack;

import java.util.Stack;

//		An arithmetic expression is given by a string array A of size N. 
//		Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//		Valid operators are +, -, *, /. Each string may be an integer or an operator.
//		Input :										Output:
//		    A =   ["2", "1", "+", "3", "*"]					9


public class PostFixToAnswer {
	public static int solve(String[] A) {
		Stack<String> st = new Stack<>();
		int N = A.length;
		for (int i = 0; i < N; i++) {
			String curr = A[i];
			if (!(curr.equals("+") || curr.equals("-") || curr.equals("/") || curr.equals("*"))) { 
				st.push(curr);			// if not this means it is digit directly push
			} else {
				int number1 = Integer.parseInt(st.pop()); // took top two elements
				int number2 = Integer.parseInt(st.pop());
				int ans;
				if (curr.equals("+")) {
					ans = number1 + number2;
					st.push(Integer.toString(ans)); // performed the operation and pushed result in stack
				} else if (curr.equals("-")) {
					ans = number2 - number1;
					st.push(Integer.toString(ans));
				} else if (curr.equals("/")) {
					ans = (number2) / (number1);
					st.push(Integer.toString(ans));
				} else {
					ans = number1 * number2;
					st.push(Integer.toString(ans));
				}
			}
		}
		return Integer.parseInt(st.peek()); // returned the final result
	}

	public static void main(String[] args) {
		String A[]= {"2", "1", "+", "3", "*"};
		System.out.println(solve(A));
	}

}
