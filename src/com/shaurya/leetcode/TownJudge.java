package com.shaurya.leetcode;

public class TownJudge {

	public static void main(String[] args) {
		int trust[][] = {{1,3},{1,4},{2,3},{2,4},{4,3}};
//		int trust[][] = {{1,2},{2,3}};
//		int trust[][] = {{1,3},{2,3}};
//		int trust[][] = {{1,2}};
//		int trust[][] = {{1,3},{2,3},{3,1}};
		int N=4;
		System.out.println(findJudgeOn(N, trust));
	}
	static public int findJudgeOn(int N, int[][] trust) {
		int inorder[] = new int[N];
		int outoder[] = new int[N];
		for(int edge[]:trust) {
			inorder[edge[1]-1]++;
			outoder[edge[0]-1]++;
		}
		for(int i=0;i<N;i++) {
			if(inorder[i]==N-1 && outoder[i]==0) {
				return i+1;
			}
		}
		return -1;
	}
	static public int findJudge(int N, int[][] trust) {
	        int mat[][] = new int[N][N];
	        int a,b;
	        for(int i=0;i<trust.length;i++) {
	        	a=trust[i][0];
	        	b=trust[i][1];
	        	mat[a-1][b-1]++;
	        }
	        int maxInorder=-1,inorder=0,ansIndex=-1;
	        for(int col=0;col<N;col++) {
	        	inorder=0;
	        	for(int row=0;row<N;row++) {
	        		//who trust judge
	        		if(mat[row][col]!=0) {
	        			inorder++;
	        		}
	        	}
	        	if(inorder>maxInorder) {
	        		maxInorder=inorder;
	        		ansIndex=col;
	        	}
	        }//for
	        
	        //judge must not trust anyone
	        if(ansIndex!=-1) {
	        	for(int col=0;col<N;col++) {
	        		if(mat[ansIndex][col]!=0) {
	        			return -1;
	        		}
	        	}
	        }
	        if(maxInorder==N-1) {
	        	return ansIndex+1;
	        }
	        return -1;
    }

}
