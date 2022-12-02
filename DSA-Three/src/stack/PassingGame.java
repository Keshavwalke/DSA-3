package stack;

import java.util.Stack;

//		There is a football event going on in your city. In this event, 
//		you are given A passes and players having ids between 1 and 106.
//		Initially, some player with a given id had the ball in his possession. 
//		You have to make a program to display the id of the player who possessed the ball after exactly A passes.
//		There are two kinds of passes:
//		1) ID
//		2) 0
//		For the first kind of pass, the player in possession of the ball passes 
//		the ball "forward" to the player with id = ID.
//		For the second kind of pass, the player in possession of the ball passes 
//		the ball back to the player who had forwarded the ball to him.
//		In the second kind of pass "0" just means Back Pass.
//		Return the ID of the player who currently possesses the ball.
//		Input 1:										Output:
//			 A = 10												63
//			 B = 23
//			 C = [86, 63, 60, 0, 47, 0, 99, 9, 0, 0]

public class PassingGame {
	public static int solve(int A, int B, int[] C) {
		Stack<Integer> stack = new Stack<>(); // created stack
		stack.push(B);
		int N = C.length;
		for (int i = 0; i < N; i++) {
			if (stack.isEmpty()) {
				if (C[i] == 0) { // made sure stack is not empty
					continue;
				} else {
					stack.push(C[i]);
				}
			} else {
				if (C[i] == 0) { // if C[i]=0 means he is passing the ball to previous player
					stack.pop();
				} else {
					stack.push(C[i]);
				}
			}
		}
		return stack.peek();
	}

	public static void main(String[] args) {
		int A = 10;
		int B = 23;
		int C[] = { 86, 63, 60, 0, 47, 0, 99, 9, 0, 0 };
		System.out.println(solve(A, B, C));

	}

}
