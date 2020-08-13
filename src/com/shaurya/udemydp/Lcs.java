package com.shaurya.udemydp;

public class Lcs {
    public static void main(String[] args) {
        String a = "ACHEFMGLP";
        String b = "XYCEPQMLG";
        System.out.println("Lcs Recursion :"+lcs(a.length()-1,b.length()-1,a,b));
        //cache
        int dp[][] = new int[a.length()+1][b.length()+1];
        System.out.println("Lcs Cache :"+lcsCache(a.length()-1,b.length()-1,a,b,dp));
        //dp
        System.out.println("Lcs Dp :"+lcsDp(a,b));

    }

    //recursive solution
    static int lcs(int i,int j,String a,String b){
        if(i==-1 || j==-1){
            return 0;
        }
        if(a.charAt(i)!=b.charAt(j)){
            return Math.max(lcs(i-1,j,a,b), lcs(i,j-1,a,b));
        }else{
            return lcs(i-1,j-1,a,b)+1;
        }
    }
    //cache
    static int lcsCache(int i,int j,String a,String b,int dp[][]){
        if(i==-1 || j==-1){
            return 0;
        }
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        if(a.charAt(i)!=b.charAt(j)){
            return dp[i][j]=Math.max(lcs(i-1,j,a,b), lcs(i,j-1,a,b));
        }else{
            return dp[i][j]=lcs(i-1,j-1,a,b)+1;
        }
    }

    //dp
    static int lcsDp(String a,String b){
        int la = a.length();
        int lb = b.length();
        int dp[][] = new int[la+1][lb+1];

        for (int i = 1; i <= la; i++) {
            for (int j = 1; j <= lb; j++) {
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[la][lb];
    }
    
}