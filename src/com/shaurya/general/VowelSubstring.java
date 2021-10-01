package com.shaurya.general;

public class VowelSubstring {
	public static String findSubstring(String s, int k) {
        int maxCount = 0;
        int count = 0;
        int start = 0;
        int end = 0;
        for(int i=0;i<k;i++){
            if(vowel(s.charAt(i))){
                count++;
            }            
        }
        end = k;
        maxCount = Math.max(maxCount, count);
        int as=0;
        int ae=k;
        while(end<s.length() && start<end){
            //remove
            if(vowel(s.charAt(start))){
                count--;
            }
            start++;
            //add
            if(vowel(s.charAt(end))){
                count++;
            }
            end++;
            //update value
            if(count==maxCount){
                
            }
            if(count>maxCount){
                maxCount = count;
                as=start;
                ae=end;
            }
            
        }
        if(maxCount==0){
            return "Not found!";
        }
        return s.substring(as,ae);
        
    }
    private static boolean vowel(char ch){
        return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u';
    }
	public static void main(String[] args) {
		String s = "qwdftr";
		int k = 2;
		System.out.println(findSubstring(s, k));

	}

}
