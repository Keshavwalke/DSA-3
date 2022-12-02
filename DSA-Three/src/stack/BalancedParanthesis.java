package stack;

import java.util.Stack;

//		Given an expression string A, examine whether the pairs and 
//		the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.
//		Input 1:			Output 1:			Input 2:			Output 2:
//			 A = {([])}				1				A = (){				0

public class BalancedParanthesis {
	public static int solve(String A) {
		int N=A.length();
			Stack<Character> stack=new Stack<Character>();
			for(int i=0;i<N;i++) {
				if(stack.isEmpty()) {
					stack.push(A.charAt(i));		//if stack empty added the element
				}
				else {
				if(stack.peek()=='[' && A.charAt(i)==']' ||stack.peek()=='{' && A.charAt(i)=='}' 
	            ||stack.peek()=='(' && A.charAt(i)==')') {			
					stack.pop();					//popping if braces match with top
				}
				else {
					stack.push(A.charAt(i));			//if not equal added to  stack
				}
				}
			}
	        if(stack.isEmpty()){        //if stack size is 0 means it is balanced
	            return 1;
	        }
	        return 0;
	    }

	public static void main(String[] args) {
		String A="{([])}";
		System.out.println(solve(A));


	}

}
