package com.shaurya.general;

public class Palindrome {
    public static void main(String[] args) {
        nearestPalindromic(44, 5);
    }

    static public void nearestPalindromic(int num,int n) {
        int count=0;
        for (int i = 1;i<1000000; i++) {
            System.out.println("count "+count);
            if (isPalindrome(num - i)){
                count++;
                if(count==n){
                    System.out.println("ans "+(num-i));
                    return;
                }
            }
            if (isPalindrome(num + i)){
                count++;
                if(count==n){
                    System.out.println("ans "+(num+i));
                    return;
                }
            }
         }
        
    }
    static boolean isPalindrome(long x) {
        long t = x, rev = 0;
        while (t > 0) {
            rev = 10 * rev + t % 10;
            t /= 10;
        }
        return rev == x;
    }
}
