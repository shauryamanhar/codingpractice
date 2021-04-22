package com.shaurya.goldman;

import java.util.Arrays;

public class StringCompression {
	public static void main(String[] args) {
		String s = "aaabbaa";
		System.out.println(compress(s.toCharArray()));
	}
    static public int compress(char[] c) {
        int read=0,start=0;
        int write=0;
        int count=0;
        while(read<c.length){
            if(c[start]==c[read]){
                count++;
            }else{
               String cstr = new String(count+"");
               c[write++]=c[start];
               for(char ch:cstr.toCharArray()) {
            	   c[write++]=(char)(ch+'0');
               }
               count=1;
               start=read;
            }
            read++;
        }
        System.out.println(Arrays.toString(c));
        return write;
    }
}
