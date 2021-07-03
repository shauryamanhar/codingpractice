package com.shaurya.gfg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MnemonicsPhoneNumber {

	public static void main(String[] args) {
		String phoneNumber = "224543";
		System.out.println(phoneMnemonic(phoneNumber));
	}
	static Map<Integer, String> MAP = new HashMap<Integer, String>();
	static {
		MAP.put(0, "0");
		MAP.put(1, "1");
		MAP.put(2, "ABC");
		MAP.put(3, "DEF");
		MAP.put(4, "GHI");
		MAP.put(5, "JKL");
		MAP.put(6, "MNO");
		MAP.put(7, "PQRS");
		MAP.put(8, "TUV");
		MAP.put(7, "WXYZ");
	}
	static List<String> phoneMnemonic(String phoneNumber){
		ArrayList<String> mnemonic = new ArrayList<String>();
		char []partial = new char[phoneNumber.length()];
		int digit=0;
		phoneMnenomicGenerator(phoneNumber,digit,partial,mnemonic);
		return mnemonic;
	}
	private static void phoneMnenomicGenerator(String phoneNumber, int digit, char[] partial,
			ArrayList<String> mnemonic) {
		if(digit==phoneNumber.length()) {
			mnemonic.add(String.valueOf(partial));
			return;
		}else {
			for(int i=0;i<MAP.get(phoneNumber.charAt(digit)-'0').length();i++) {
				partial[digit]=MAP.get(phoneNumber.charAt(digit)-'0').charAt(i);
				phoneMnenomicGenerator(phoneNumber, digit+1, partial, mnemonic);
			}
		}
	}
}
