package com.shaurya.leetcode;
//This problem is very similar to 674. 
//Longest Continuous Increasing Subsequence, and the only difference is 
//that we need a substring with the same characters instead of an increasing one. 
public class ConsecutiveCharacters {
    public static void main(String[] args) {
        String s = "aaabbbbbcc";
        System.out.println(maxPower(s));//answer is count(bbbbb)=5
    }
    static public int maxPower(String s) {
        int i=0,j=i+1;
        int c=1;
        int max=1;
        while(i<s.length() && j<s.length()){
            if(s.charAt(i)==s.charAt(j)){
                j++;
                c++;
                if(max<c){
                    max=c;
                }
            }else{
                i=i+c;
                j=i+1;
                c=1;
            }
        }
        return max;
    }
}
