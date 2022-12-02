package hashing;

import java.util.Arrays;
import java.util.HashSet;

//	Given an unsorted integer array A of size N.
//	Find the length of the longest set of consecutive elements from array A.
//	Input :						Output:
//	A = [100, 4, 200, 1, 3, 2]			4

public class LongestConsecutiveSequence {
	
	//Optimized Approach using hashset
	public  static int optimized(final int[] A) {
        int N=A.length;
        int ans=0;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<N;i++){
            set.add(A[i]);              //added array to hashset
        }
        for(int i:set){                         //used enhanced for loop for iterating over hashset
            if(set.contains(i-1)==false){       //if previous value is not there means we can start from here
                int count=0;
                int x=i;
                while(set.contains(x)){         //we can go up to value is present and reflect in count
                    count++;
                    ans=Math.max(ans,count);
                    x++;
                }
                
            }
        }
    return ans;
    }
	
	
	//Brute force
	public static int longestConsecutive(final int[] A) {
		Arrays.sort(A);			//sorted the array and checked if element equals +1 than previous
		if (A.length == 1)		// if not kept the count as 1 , compared with max
			return 1;
		int ans = 1;
		int count = 1;
		for (int i = 1; i < A.length; i++) {
			if (A[i] == A[i - 1] + 1) {
				count++;
				ans = Math.max(count, ans);
			} else if (A[i] == A[i - 1]) {
				continue;
			} else {
				count = 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int A[]= {100, 4, 200, 1, 3, 2};
		System.out.println(longestConsecutive(A));
		System.out.println(optimized(A));

	}

}
