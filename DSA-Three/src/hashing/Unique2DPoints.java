package hashing;

import java.util.HashSet;

//	Given a 2D array A of integer points on a 2D plane. Find and return the number of unique points in the array.
//	The ith point in the array is (A[i][0], A[i][1])
//	A = [[5, 6],			Output: 5
//	     [2, 8],
//	     [-1, -1],
//	     [2, -3],
//	     [2, 8],
//	     [7, 7],
//	     [2, -3]]

public class Unique2DPoints {
	public static int solve(int[][] A) {
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < A.length; i++) {
			set.add(A[i][0] + "@" + A[i][1]); // simply adding separator so that points can be converted to string
		}
		return set.size();
	}

	public static void main(String[] args) {
		int A[][]= {{5,6},{2,8},{-1,-1},{2,-3},{2,8},{7,7},{2,-3}};
		System.out.println(solve(A));

	}

}
