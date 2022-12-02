package hashing;

import java.util.HashMap;

//		You are given two strings, A and B, of size N and M, respectively.
//		You have to find the count of all permutations of A present in B as a substring. 
//		You can assume a string will have only lowercase letters.
//		Input 1				Output:
//			 A = "abc"				5
//			 B = "abcbacabc"
public class PermutationsOfAinB {
	public static int solve(String A, String B) {
		int count = 0;
		HashMap<Character, Integer> mapA = new HashMap<>();
		for (int i = 0; i < A.length(); i++) {
			if (mapA.containsKey(A.charAt(i))) {
				mapA.put(A.charAt(i), A.charAt(i) + 1);
			} else {
				mapA.put(A.charAt(i), 1);
			}
		}
		int N = B.length();
		int M = A.length();
		for (int j = 0; j <= N - M; j++) {
			HashMap<Character, Integer> mapB = new HashMap<>();
			for (int i = j; i < j + M; i++) {
				if (mapB.containsKey(B.charAt(i))) {
					mapB.put(B.charAt(i), mapB.get(B.charAt(i)) + 1);
				} else {
					mapB.put(B.charAt(i), 1);
				}
			}
			if (mapA.equals(mapB))
				count++;
			mapB.clear();
		}
		return count;
	}

	public static void main(String[] args) {
		String A = "abc";
		String B = "abcbacabc";
		System.out.println(solve(A, B));

	}

}
