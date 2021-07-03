package com.shaurya.gfg.dp;
import java.util.*;
public class DiagonalSort {
    public static void main(String args[] ){
    	int mat[][] = {{1,3,5,8},
    			       {5,6,1,5},
    			       {9,2,6,8}
    	};
    	diagonalSort(mat, mat.length, mat[0].length);
    	for(int r[]:mat) {
    		for(int q:r) {
    			System.out.print(q+" ");
    		}
    		System.out.println();
    	}
    }
    static void diagonalSort(int mat[][], int n, int m){
    	int row = n,col=m;
        ArrayList<Integer>[] pos = new ArrayList[col];
        ArrayList<Integer>[] neg = new ArrayList[row];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
            	if(i>=j && neg[i-j]==null) {
            		neg[i-j] = new ArrayList<Integer>();
            	}
            	if(j>=i && pos[j-i]==null) {
            		pos[j-i] = new ArrayList<Integer>();
            	}
                if(j==i){
                    pos[j-i].add(mat[i][j]);
                }else if(j>i){
                    pos[j-i].add(mat[i][j]);
                }else{
                    neg[Math.abs(j-i)].add(mat[i][j]);
                }
            }
        }
        //sort lower left
        for(int i=1;i<row;i++){
            Collections.sort(neg[i]);
        }
        //sort upper right
        for(int i=1;i<col;i++){
            Collections.sort(neg[i],Collections.reverseOrder());
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(j==i){
                    int l = pos[0].size();
                    mat[i][j] = pos[0].get(0);
                    pos[0].remove(0);
                    
                }else if(j>i){
                    int d = j-i;
                    int l = pos[d].size();
                    mat[i][j]=pos[d].get(l-1);
                    pos[d].remove(l-1);
                }else{
                    int d = i-j;
                    int l = neg[d].size();
                    mat[i][j]=neg[d].get(l-1);
                    neg[d].remove(l-1);
                    
                }
            }
        }
        
    }
}
