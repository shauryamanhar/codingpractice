package com.shaurya.bitmanipulation;

//try to solve in o(n) using bit wise. In this try to find number with occurred once.
//find the common set bits in prev and new element. These common set bits are actually the bits that should be added to ‘twos’.
//So do bitwise OR of the common set bits with ‘twos’.
//‘twos’ also gets some extra bits that appear third time. These extra bits are removed later.
public class AppearsOnce {

	public static void main(String[] args) {
		int a[] = {4,4,4,2};
		int one=0,two=0,commonBitMask=0;
		for(int i=0;i<a.length;i++) {
			two = two|(one&a[i]);
			one = one^a[i];
			commonBitMask=~(one&two);
			one&=commonBitMask;
			two&=commonBitMask;
			System.out.println("one "+BitwiseUtil.toBinary(one));
			System.out.println("two "+BitwiseUtil.toBinary(two));
		}
		System.out.println(one);
	}

}
