package com.shaurya.gfg;


public class ReverseWord {
	public static void main(String[] args) {
		ReverseWord r = new ReverseWord();
		String s = "i.like.this.program.very.much";
//		s= "prq.mno.abc";
		String ans = r.reverseWords(s);
		System.out.println(ans);
	}
	
	String reverseWords(String s) {
		char a[] = s.toCharArray();
		int start = 0;
		for(int end=0;end<s.length();end++) {
			if(a[end]=='.') {
				reverse(a, start, end-1);
				start = end+1;
			}
		}
		System.out.println(String.valueOf(a));
		reverse(a, start, s.length()-1);
		reverse(a, 0, s.length()-1);
		return String.valueOf(a);
	}
	
	
	void reverse(char a[],int l,int r) {
		while(l<r) {
			char temp = a[l];
			a[l] = a[r];
			a[r] = temp;
			l++;
			r--;
		}
	}
	
}
