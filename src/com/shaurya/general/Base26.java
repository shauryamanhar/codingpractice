package com.shaurya.general;

public class Base26 {
	public static void main(String[] args) {
		convert(676);
	}
	static void convert(int n) {
		int base26[] = new int[10000];
		int i=0;
		StringBuffer sb = new StringBuffer();
		while(n>0) {
			base26[i++] = n%26;
			sb.append(n%26);
			n = n/26;
		}
		System.out.println("base16 representation: "+sb.reverse());
		
		//remove 0's from base26
		for(int j=0;j<i-1;j++) {
			if(base26[j]<=0) {
				base26[j]+=26;
				base26[j+1] = base26[j+1] - 1;
			}
		}
		StringBuffer ans = new StringBuffer();
		for(int j=i;j>=0;j--) {
			if(base26[j]>0) {
				ans.append((char)('A'+base26[j]-1));
			}
		}
		System.out.println(ans.toString());
	}
	static void convertFast(int n) {
		
	}
}
