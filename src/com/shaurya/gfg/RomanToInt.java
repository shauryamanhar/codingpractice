package com.shaurya.gfg;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

	public static void main(String[] args) {
		String str = "MMMDDX";
		System.out.println(romanToDecimal(str));
	}
    static int romanToDecimal(String str) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int intValue = 0;
        int maxSoFar = 0;
        for(int i=str.length()-1;i>=0;i--){
            char c = str.charAt(i);
            maxSoFar = Math.max(maxSoFar,map.get(c));
            if(map.get(c)>=maxSoFar){
                intValue+=map.get(c);
            }else{
                intValue-=map.get(c);
            }
        }
        return intValue;
    }
}
