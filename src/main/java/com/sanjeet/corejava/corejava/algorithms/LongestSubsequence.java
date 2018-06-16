package com.sanjeet.corejava.corejava.algorithms;

public class LongestSubsequence {
	
public static int LCS(String X,String Y,int m,int n){
		
		int[][] L=new int[m+1][n+1];
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				if(i==0 || j==0){
					L[i][j]=0;
				}
				else{
					if(X.charAt(i-1)==Y.charAt(j-1)){
						L[i][j]=L[i-1][j-1]+1;
					}
					else{
						L[i][j]=Math.max(L[i-1][j],L[i][j-1]);
					}
				}
			}
		}
		return L[m][n];
	}
	
	public static void main(String[] args) {
		String s1="stone";
		String s2="longest";
		System.out.println(LCS(s1,s2,5,7));
	
	}

}
