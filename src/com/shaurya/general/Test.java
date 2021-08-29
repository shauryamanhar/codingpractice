package com.shaurya.general;

import java.util.*;

public class Test{
	public static void main(String[] args) {
		try {
			bad();
			System.out.println("a");
		} catch (Exception e) {
			System.out.println("b");
		}finally {
			System.out.println("c");
		}
	}
	static void bad() {}
}
