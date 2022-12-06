package queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//		Given a string A denoting a stream of lowercase alphabets, you have to make a new string B.
//		B is formed such that we have to find the first non-repeating character each time a character 
//		is inserted to the stream and append it at the end to B. If no non-repeating character is found, 
//		append '#' at the end of B
//		Input :					Output:
//			 A = "abadbc"			"aabbdd"

public class FirstNonRepeatingCharacter {
	public static String solve(String A) {
		Queue<Character> q = new LinkedList<>();				//created queue
		Map<Character, Integer> hashMap = new HashMap<>();		//created hashmap to store the frequency of character
		int strLen = A.length();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < strLen; i++) {
			q.add(A.charAt(i));
			hashMap.put(A.charAt(i), hashMap.getOrDefault(A.charAt(i), 0) + 1);		//put the freq

			while (!q.isEmpty() && hashMap.get(q.peek()) > 1) {			//if frequency is >1 then deleted from queue
				q.remove();
			}

			if (!q.isEmpty())
				sb.append(q.peek());			//appended the first element
			else
				sb.append("#");					//if not present appended #
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		String A = "abadbc";
		System.out.println(solve(A));

	}

}
