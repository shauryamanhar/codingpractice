package com.shaurya.leetcode;

import java.util.ArrayList;
import java.util.HashSet;

public class BuddyStrings {
    public static void main(String[] args) {
        String a="acccb";
        String b="bccca";
        System.out.println(buddyStrings(a, b));
    }
    
    static public boolean buddyStrings(String a, String b) {
        //check the length
        if(a.length()!=b.length()){
            return false;
        }

        //edge case: when a==b then we can not find the diff index-> case failed
        //for this we count the unique char in string and check 
        //if count is < length of string -> after swap it going to be the same
        //else -> after swap it going to totally differece string
        if(a.equals(b)){
            HashSet<Character> uniqueChar = new HashSet<>();
            for(char c:a.toCharArray()){
                uniqueChar.add(c);
            }
            if(uniqueChar.size()<a.length()){
                return true;
            }else{
                return false;
            }
        }
        //for two index which will going to diff (a[i]!=b[i])
        ArrayList<Integer> diff = new ArrayList<Integer>();
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)){
                diff.add(i);
            }
        }
        //diff==2 means found the two index 
        //a=aaab
        //b=aaba diff->{2,3}
        //and check if after swap they are equal or not(below code is equivalent of swap) 
        //->cross checking   
        if((
            diff.size()==2) &&  
            (a.charAt(diff.get(0))==b.charAt(diff.get(1)))
                                && 
            (a.charAt(diff.get(1))==b.charAt(diff.get(0)))
        ){
            return true;
        }

        return false;
    }
}
