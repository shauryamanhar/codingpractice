package com.shaurya.general;

public class StringEncoding {

	public static void main(String[] args) {
		String str = "A";
		System.out.println(collapseString(str));

	}
	
	public static String collapseString(String s) {
		int count=0;
		String ans="";
		int i=0,j=0;
		int len=s.length();
		while(j<len) {
			if(s.charAt(i)==s.charAt(j)) {
				count++;
				j++;
			}else {
				ans=ans+" "+count+s.charAt(i);
				count=0;
				i=j;
			}
		}
		ans=ans+" "+count+s.charAt(i);
		return ans;
	}

}
