package com.shaurya.goldman;

public class PalindromeNumber {

	public static void main(String[] args) {
		int x = 101;
		isPalindromeLogn(x);
	}
    static boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        if(x!=0 && x%10==0){
            return false;
        }
        int rev = 0;
        int y = x;
        while(y>0){
            rev=(rev*10)+(y%10);
            y=y/10;
        }
        return x==rev;
    }
    static boolean isPalindromeLogn(int x) {
    	if(x<0){
    		return false;
    	}
    	if(x!=0 && x%10==0){
    		return false;
    	}
    	int rev = 0;
    	while(x>rev) {
    		rev = (rev*10)+(x%10);
    		x=x/10;
    	}
    	return x==rev || x==rev/10;
    }

}
