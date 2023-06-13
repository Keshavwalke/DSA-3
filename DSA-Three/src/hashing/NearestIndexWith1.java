package hashing;

import java.util.ArrayList;
import java.util.TreeSet;

public class NearestIndexWith1 {
	
	public static ArrayList<Integer> solve(int A[],int B[][]) {
		int N=B.length;
		TreeSet<Integer> ts=new TreeSet<>();
		
		ArrayList<Integer>arr=new ArrayList<>();
		
		for(int i=0;i<B.length;i++) {
			if(B[i][0]==1) {
				if(ts.contains(B[i][1])) {
					ts.remove(B[i][1]);
				}
				else {
					ts.add(B[i][1]);
				}
			}
			else {
				if(ts.contains(B[i][1])) {
					arr.add(B[i][1]);
				}
				else {
				int l=B[i][1]-ts.floor(i);
				int r=ts.ceiling(i)-B[i][1];
			//	if(l!= )ans[i]=r;
				
				
				if(r<l) arr.add(ts.floor(B[i][1]));
				else arr.add(ts.ceiling(B[i][1]));
				}
				
			}
		}
		return arr;
		
	}
	public static void main(String[] args) {
		int A[]= {0,0,0,0,0};
		int B[][]= {{1,2},{1,4},{2,4},{2,3},{2,0},{2,4}};
		// {0,0,1,0,1}
		
		ArrayList<Integer> ans=solve(A,B);
		for(int i:ans) {
			System.out.print(i+" ");
		}
	}

}
