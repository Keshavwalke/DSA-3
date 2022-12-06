package queue;

import java.util.TreeMap;

//		Given an array A of both positive and negative integers.
//		Your task is to compute the sum of minimum and maximum elements of all sub-array of size B.
//		NOTE: Since the answer can be very large, you are required to return the sum modulo 109 + 7.
//				Input :									Output:
//					 A = [2, 5, -1, 7, -3, -1, -2]				18
//					 B = 4
public class SumOfMinAndMax {
	 public static int solve(int[] A, int B) {
	        int N = A.length;
	        long sum=0;
	        long m=1000000007;
			TreeMap<Integer, Integer> tm = new TreeMap<>(); // created treemap and inserted first window
			for (int i = 0; i < B; i++) {
	            
				if (tm.containsKey(A[i])) {
					tm.put(A[i], tm.get(A[i]) + 1);     //Inserted frequency
				} else {
					tm.put(A[i], 1);
				}
			}
	        sum=((sum%m)+(tm.lastKey()+tm.firstKey())%m)%m;            //sum increased min+max
			for (int i = B; i < N; i++) {
				tm.put(A[i - B], tm.get(A[i - B]) - 1);     //removed freq of first element
				if (tm.containsKey(A[i])) {
					tm.put(A[i], tm.get(A[i]) + 1);
				} else {
					tm.put(A[i], 1);
				}
				if (tm.get(A[i - B]) == 0) { // removing element if freq is 0
					tm.remove(A[i - B]);
				}
	            sum=((sum%m)+(tm.lastKey()+tm.firstKey())%m)%m;;
			}
	        sum=(sum+m)%m;
			return (int)sum;
	        
	    }

	public static void main(String[] args) {
     int A[]= {2, 5, -1, 7, -3, -1, -2};
     int B=4;
     System.out.println(solve(A,B));
	}

}
