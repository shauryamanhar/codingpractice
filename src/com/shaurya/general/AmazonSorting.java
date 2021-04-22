package com.shaurya.general;

import java.util.*;

public class AmazonSorting {
	public static void main(String[] args) {
		String order1 = "zld 93 12";
		String order2 = "fp kindle book";
		String order3 = "10a echo show";
		String order4 = "17g 12 25 6";
		String order5 = "ab1 kindle book";
		String order6 = "125 echo dot second generation";
		List<String> orderList = new ArrayList<>();
		orderList.add(order1);
		orderList.add(order2);
		orderList.add(order3);
		orderList.add(order4);
		orderList.add(order5);
		orderList.add(order6);
		sort(orderList);
	}

	public static void sort(List<String> list) {
		List<String> prime = new ArrayList<String>();
		List<String> nonprime = new ArrayList<String>();
		List<String> ans = new ArrayList<String>();
		for (String order : list) {
			if (isPrime(order)) {
				prime.add(order);
			} else {
				nonprime.add(order);
			}
		}
		prime.sort(com);
		prime.addAll(nonprime);
		System.out.println(prime.toString());
	}

	static boolean isPrime(String s) {
		int index = s.indexOf(" ") + 1;
		while (index < s.length()) {
			if (s.charAt(index) != ' ' && Character.isAlphabetic(s.charAt(index)) == false) {
				return false;
			}
			index++;
		}
		return true;
	}

	static Comparator<String> com = new Comparator<String>() {
		@Override
		public int compare(String str1, String str2) {
			int res = String.CASE_INSENSITIVE_ORDER.compare(str1.substring(str1.indexOf(" ") + 1),
					str2.substring(str2.indexOf(" ") + 1));
			if (res == 0) {
				res = str1.substring(0, str1.indexOf(" ")).compareTo(str2.substring(0, str2.indexOf(" ")));
			}
			return res;
		}
	};
}

class Prime {

	public static void main(String[] args) {
		String order1 = "zld 93 12";
		String order2 = "fp kindle book";
		String order3 = "10a echo show";
		String order4 = "17g 12 25 6";
		String order5 = "ab1 kindle book";
		String order6 = "125 echo dot second generation";
		List<String> orderList = new ArrayList<>();
		orderList.add(order1);
		orderList.add(order2);
		orderList.add(order3);
		orderList.add(order4);
		orderList.add(order5);
		orderList.add(order6);
		System.out.println(prioritizedOrders(6, orderList));
	}

	public static List<String> prioritizedOrders(int numOrders, List<String> orderList) {
		List<String> primes = new ArrayList<>();
		List<String> nonPrimes = new ArrayList<>();
		List<String> expectedList = new ArrayList<>();

		// WRITE YOUR CODE HERE
		for (String order : orderList) {
			if (isAlphabetic(getMetadata(order))) {
				primes.add(order);
			} else {
				nonPrimes.add(order);
			}
		}

		primes.sort(ALPHABETICAL_ORDER);
		primes.addAll(nonPrimes);
		return primes;

	}

	private static String getMetadata(String order) {
		return order.substring(order.indexOf(" ") + 1);
	}
	// METHOD SIGNATURE ENDS

	public static boolean isAlphabetic(String s) {
		return s != null && s.matches("^[a-zA-Z\\s]*$");
	}

	private static Comparator<String> ALPHABETICAL_ORDER = new Comparator<String>() {
		public int compare(String str1, String str2) {
			int res = String.CASE_INSENSITIVE_ORDER.compare(str1.substring(str1.indexOf(" ") + 1),
					str2.substring(str2.indexOf(" ") + 1));
			if (res == 0) {
				res = str1.substring(0, str1.indexOf(" ")).compareTo(str2.substring(0, str2.indexOf(" ")));
			}
			return res;
		}
	};

}