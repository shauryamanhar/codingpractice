package com.shaurya.gfg;

public class LargestNnumberKSwaps {

	public static void main(String[] args) {
		System.out.println(findMaximumNum("61892795431", 4));
	}

	public static String findMaximumNum(String str, int k) {
		return find(str.toCharArray(), 0, k);
	}
//99876215431
//99876125431
	static String find(char ch[], int idx, int k) {
		if (idx >= ch.length) {
			return null;
		}
		if (k < 0 || idx ==ch.length) {
			return new String(ch);
		}
		int maxIdx = idx;
		int max = ch[idx] - '0';
		for (int i = ch.length-1; i>= 0 && i>idx ; i--) {
			int b = ch[i] - '0';
			if (b > max) {
				max = b;
				maxIdx = i;
			}
		}
		
		if (maxIdx != idx) {
			System.out.println("befor change "+new String(ch));
			char temp = ch[maxIdx];
			ch[maxIdx] = ch[idx];
			ch[idx] = temp;
			System.out.printf("swap a[%d]=%c and a[%d]=%c k=%d new[%s]\n",idx,ch[idx],maxIdx,ch[maxIdx],k,new String(ch));
			return find(ch, idx + 1, k - 1);
		}else {
			System.out.printf("no max found for idx=%d ch[%c]\n",idx,ch[idx]);
		}
		char temp = ch[maxIdx];
		ch[maxIdx] = ch[idx];
		ch[idx] = temp;
		return find(ch, idx+1, k);
	}
}
