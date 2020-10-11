package com.shaurya.leetcode;
import java.util.Stack;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        // String s = "cbacdcbc";
        String s = "abababa";
        System.out.println(removeDuplicateLetters(s));
    }

    static String removeDuplicateLetters(String s) {
        //record the last index of the character in the string
        int lastIndex[] = new int[26];
        //seen is going to be used for character is seen or not
        boolean seen[] = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        //stack is going to hold our character as int
        //stack will be used to store the large char at the top
        //The idea is -> We check the top of the stack if top>ch and top char is available in the 
        //later array then we just remove it
        //we are trying to add the small char in bottom thats why we are removing 
        //large char because they are available in later in array
        //case 2: if char is already in the stack then just do nothing
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i)-'a';//normalizing the index to [0-25]
            //if ch is already in the stack -> do nothing
            if(seen[ch]){
                continue;
            }
            //remove all the larger char from the stack if these are available in later array
            while(!stack.isEmpty() && stack.peek()>ch && i<lastIndex[stack.peek()]){
                //after moving them..change seen false beacause they are no longer available in stack
                seen[stack.pop()]=false;
            }
            //now add the current char in stack and mark as seen
            stack.push(ch);
            seen[ch]=true;
        }//for
        StringBuilder sb = new StringBuilder();
        //putting back all char in sb
        while(!stack.isEmpty()){
            sb.append((char)(stack.pop()+'a'));
        }
        //the reverse will be the answer because it is the smallest lwxicographical order
        return sb.reverse().toString();
    }

    static void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }    
}
