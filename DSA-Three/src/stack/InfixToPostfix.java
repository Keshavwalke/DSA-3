package stack;

import java.util.Stack;

public class InfixToPostfix {
	public static String solve(String A) {
		int N=A.length();
		String res="";
		
		Stack<Character> st=new Stack<>();
		for(int i=0;i<N;i++) {
			char curr=A.charAt(i);
			
			if(!(curr=='+' ||curr=='-' ||curr=='/' ||curr=='*' ||curr=='^' || curr=='(' || curr==')')){
				res=res+curr;
			}
			
			else if(curr=='(') {
				st.push(curr);
			}
			
			else {
				if(st.isEmpty()) {
					st.push(curr);
				}
				else if(curr==')') {
					while(st.size()>0 && st.peek()!='(') {
						char bracechar=st.peek();
						res=res+bracechar;
						st.pop();
					}
					st.pop();
				}
				else {
				while(st.size()>0 && st.peek()!='(' && precedence(st.peek())>=precedence(curr)) {
					char ch=st.peek();
					res=res+ch;
					st.pop();
				}
				
				st.push(curr);				//pushing new operator in stack
				}
			}
		}
		
		while(st.size()>0) {			//once iterating on infix done pushing all from stack to postfix
			char top=st.peek();
			res=res+top;
			st.pop();
		}
		
		return res;
	}
	
	
	public static int precedence(Character c) {
		if(c=='+' || c=='-')return 1;
		else if(c=='*' || c=='/')  return 2;
		else if(c=='^') return 3;
		return 0;
	}

	public static void main(String[] args) {
		String A="A+B/C*(D+E)-F";
		String B="l-(l*q/s)/q*(u-p)";
		System.out.println(solve(A));
		System.out.println(solve(B));
	//	llq*s/q/up-*-
	//	llq*s/-qup-*/
		

	}

}
