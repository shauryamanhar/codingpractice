package com.shaurya.leetcode;

public class ChampagneTower{
    public static void main(String[] args) {
        System.out.println(fill(25, 6, 1));
    }
    static double fill(int vol, int query_row, int query_glass){
        int n = 101;
        double mat[][] = new double[n][n];
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j <i+1 ; j++) {
                if(i==0){
                    mat[i][j]=vol;
                    continue;
                }
                if(j==0){
                    mat[i][j]=(0.5)*(mat[i-1][j]-1.0);
                }else if(j==i){
                    mat[i][j]=(0.5)*(mat[i-1][j-1]-1.0);
                }
                else{
                    mat[i][j]=(0.5)*(mat[i-1][j]-1.0) + (0.5)*(mat[i-1][j-1]-1.0);
                }
            }
        }
        print(mat);
        return Math.min(1, mat[query_row][query_glass]);
    }

    static String p(double mat[][],int i,int j){
        return "mat["+i+"]["+j+"]="+mat[i][j];
    }
    static void print(double mat[][]){
        int n = mat.length;
        for (int i = 0; i < 7 ; i++) {
            for (int j = 0; j <i+1 ; j++) {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }


}