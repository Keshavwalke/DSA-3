package stack;

import java.util.Stack;

//	You are given a string A.
//	An operation on the string is defined as follows:
//	Remove the first occurrence of the same consecutive characters. 
//	eg for a string "abbcd", the first occurrence of same consecutive characters is "bb".
//	Therefore the string after this operation will be "acd".
//	Keep performing this operation on the string until there are no more occurrences of 
//	the same consecutive characters and return the final string.
//			Input 1:				Output:
//				 A = abccbc				ac
				 
public class DoubleCharacterTrouble {
	public static String solve(String A) {
		int N=A.length();
		Stack<Character> stack=new Stack<Character>();
		for(int i=0;i<N;i++) {
			if(stack.isEmpty()) {
				stack.push(A.charAt(i));		//if stack empty added the element
			}
			else {
			if(stack.peek()==A.charAt(i)) {			//checked if top element equal to coming and removed from stack
				stack.pop();
			}
			else {
				stack.push(A.charAt(i));			//if not equal removed from stack
			}
			}
		}
		return stack.toString();
	}

	public static void main(String[] args) {
		String A="abccbc";
		System.out.println(solve(A));

	}

}
