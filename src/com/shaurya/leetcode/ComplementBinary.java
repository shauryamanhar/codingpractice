package com.shaurya.leetcode;

public class ComplementBinary {

	public static void main(String[] args) {
		System.out.println(findComplement(1));
//		System.out.println(firstUniqChar("leetcode"));

	}
	
	public static  int firstUniqChar(String s) {
        int hash[] = new int[26];
        for(int i=0;i<s.length();i++){
            hash[s.charAt(i)-'a']++;
        }
        
        for(int i=0;i<s.length();i++){
            if(hash[s.charAt(i)-'a']==1){
                return i;
            }
        }
        return -1;
    }
	
	
	public int findComplement3(int num) {
        if(num==0)
            return 1;
        int numberOfBit = (int)(Math.log(num)/Math.log(2))+1;
		int mask = (1<<numberOfBit)-1;
		return num^mask;
    }
	
	static int findComplement(int num) {
		int numberOfBit = (int)(Math.log(num)/Math.log(2))+1;
		for(int i=0;i<numberOfBit;i++) {
			num=num^(1<<i);
		}
		return num;
    }
	public int findComplement2(int num) {
        int bitmask = num;
        bitmask |= (bitmask >> 1);
        bitmask |= (bitmask >> 2);
        bitmask |= (bitmask >> 4);
        bitmask |= (bitmask >> 8);
        bitmask |= (bitmask >> 16);
        return bitmask ^ num;
    }

}
