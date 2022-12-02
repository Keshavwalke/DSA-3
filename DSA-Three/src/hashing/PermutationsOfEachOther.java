package hashing;

import java.util.HashMap;

//	You are given two strings, A and B, of size N and M, respectively.
//  check if they are permutino of each other
//	You can assume a string will have only lowercase letters.
//	Input 1:					Output:
//		 A = "abc"					true
//		 B = "bac"

public class PermutationsOfEachOther {

	//Optimized Approach TC: O(N)   SC: O(N)--due only 26 letters there
	public static boolean solve(String A, String B) {
		HashMap<Character, Integer> mapA = new HashMap<>();
		HashMap<Character, Integer> mapB = new HashMap<>();
		for (int i = 0; i < A.length(); i++) {
			if (mapA.containsKey(A.charAt(i))) {
				mapA.put(A.charAt(i), A.charAt(i) + 1);
			} else {
				mapA.put(A.charAt(i), 1);
			}
		}
		for (int i = 0; i < B.length(); i++) {
			if (mapB.containsKey(B.charAt(i))) {
				mapB.put(B.charAt(i), B.charAt(i) + 1);
			} else {
				mapB.put(B.charAt(i), 1);
			}
		}
		if (mapA.equals(mapB))
			return true;
		return false;

	}

	// Brute Force
	// sort both the strings and compare

	public static void main(String[] args) {
		String A = "hello";
		String B = "olle";
		System.out.println(solve(A, B));

	}

}
