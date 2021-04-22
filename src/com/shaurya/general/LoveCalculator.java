package com.shaurya.general;

public class LoveCalculator {

	public static void main(String[] args) {
		String s = "suchita loves amarnath";
		love(s);
	}
	static void love(String s) {
		String ans = "";
		boolean hash[] = new boolean[26];
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			if(ch==' ') {
				continue;
			}
			int count=0;
			if(hash[ch-'a']) {
				continue;
			}
			for(int j=i+1;j<s.length();j++) {
				char temp = s.charAt(j);
				if(ch==temp) {
					count++;
				}
			}
			hash[ch-'a']=true;
			if(count==0)
				continue;
			
			ans = ans+count;
		}
		System.out.println(ans);
	}

}
