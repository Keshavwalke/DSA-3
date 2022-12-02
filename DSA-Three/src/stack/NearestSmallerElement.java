package stack;

import java.util.Arrays;
import java.util.Stack;

//		Given an array A, find the nearest smaller element G[i] for 
//		every element A[i] in the array such that the element has an index smaller than i.
//		More formally,
//		G[i] for an element A[i] = an element A[j] such that
//		j is maximum possible AND j < i AND A[j] < A[i]
//		Elements for which no smaller element exist, consider the next smaller element as -1.
//		Input:						Output:
//		 A = [4, 5, 2, 10, 8]		[-1, 4, -1, 2, 2]

public class NearestSmallerElement {
	
	 public int[] prevSmaller(int[] A) {
	        int result[]=new int[A.length];
	        Arrays.fill(result,-1);                   //used default method to fill the array with -1
	        Stack<Integer> stack=new Stack<>();            //created stack
	        for(int i=0;i<A.length;i++){
	           while(stack.size()>0 && stack.peek()>=A[i]){     //poped stacked until upper element lower than A[i]
	               stack.pop();
	           }
	           if(stack.size()>0){
	               result[i]=stack.peek();          //if some element present then top of stack is nearest to A[i]
	           }
	           stack.push(A[i]);                //each time pushing element in stack
	        } 
	        return result;
	    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
