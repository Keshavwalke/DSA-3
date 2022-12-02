package hashing;

import java.util.HashSet;

//		Given a string A, find the length of the longest substring without repeating characters.
//		Note: Users are expected to solve in O(N) time complexity.
//		Input 1:				Output:
//			 A = "abcabcbb"			3

public class LongestSubStringWithDistinctCharacters {
	
	//Optimized Approach TC: O(N)  SC: O(N)
	public static int optimized(String A) {
		int N = A.length();
		int ans = 0;
		int i = 0, j = 0;
		HashSet<Character> set = new HashSet<>();
		while (j < N) {
			if (set.contains(A.charAt(j)) == false) { // using 2 pointer approach
				set.add(A.charAt(j)); // checking if char there if not adding
				ans = Math.max(ans, set.size());
				j++;
			} else {
				set.remove(A.charAt(i)); // if there removing chars till that char previous occurrence
				i++;
			}
		}
		return ans;
	}
	
	//N2 Approach
	public static int LittleBetter(String A) {
		int N = A.length();
		int ans = 0;

		for (int i = 0; i < N; i++) {					//for each value we are checking next characters
			HashSet<Character> set = new HashSet<>();
			int count = 0;
			for (int j = i; j < N; j++) {
				if (set.contains(A.charAt(j)) == false) {		
					count++;
					set.add(A.charAt(j));
				}
				else {
					break;
				}
			}
			ans = Math.max(ans, count);
		}
		return ans;
	}
	
	//Brute Force
	public static int BruteForce(String A) {
		int N = A.length();
		int ans = 0;
		for (int i = 0; i < N; i++) {

			for (int j = i; j < N; j++) {
				HashSet<Character> set = new HashSet<>();
				for (int k = i; k <= j; k++) {
					set.add(A.charAt(k));
				}
				if (set.size() == j - i + 1) {
					ans = Math.max(ans, j - i + 1);
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		String A="abcabcbb";
		System.out.println(BruteForce(A));
		System.out.println(LittleBetter(A));
		System.out.println(optimized(A));
	}

}
