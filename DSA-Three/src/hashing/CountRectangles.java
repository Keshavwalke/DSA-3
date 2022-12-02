package hashing;

import java.util.HashSet;

//	Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) 
//	for 0 <= i < N represents a unique point (x, y) in a 2-D Cartesian plane.
//	Find and return the number of unordered quadruplet (i, j, k, l) 
//	such that (A[i], B[i]), (A[j], B[j]), (A[k], B[k]) and (A[l], B[l]) 
//	form a rectangle with the rectangle having all the sides parallel to either x-axis or y-axis.
//	Input 1:					Output: 1
//		 A = [1, 1, 2, 2]
//		 B = [1, 2, 1, 2]
public class CountRectangles {
	public  static int solve(int[] A, int[] B) {
        int N=A.length;
        int count=0;
        HashSet<String> hs=new HashSet<>();
        for(int i=0;i<N;i++){
            String P=A[i]+"@"+B[i];     //stored all pairs in hashset
            hs.add(P);
        }
       for(int i=0;i<N;i++){
           for(int j=i+1;j<N;j++){
               if(A[i]!=B[i] && A[j]!=B[j]){        //here A[i]=x1; B[i]=x2; A[j]=

                   String P1=B[i]+"@"+A[j];     //checking x2,y1 && x1,y2 are present
                   String P2=A[i]+"@"+B[j];
                   if(hs.contains(P1) && hs.contains(P2)){
                       count++;
                   }
                   
               }
           }
       }
       return count/2;
    }

	public static void main(String[] args) {
		int[] A = {1, 1, 2, 2};
		int [] B = {1, 2, 1, 2};
		System.out.println(solve(A,B));

	}

}
