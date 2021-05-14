package com.shaurya.general;

public class LargestLexicographicalStringMostKConsecutive {

	static String getLargestString(String s, int k) {
		int[] frequency_array = new int[26];

		for (int i = 0; i < s.length(); i++) {
			frequency_array[s.charAt(i) - 'a']++;
		}
		String ans = "";
		for (int i = 25; i >= 0;) {
			if (frequency_array[i] > k) {
				int temp = k;
				String st = String.valueOf((char) (i + 'a'));
				while (temp > 0) {
					ans += st;
					temp--;
				}
				frequency_array[i] -= k;
				int j = i - 1;
				while (frequency_array[j] <= 0 && j >= 0) {
					j--;
				}
				if (frequency_array[j] > 0 && j >= 0) {
					String str = String.valueOf((char) (j + 'a'));
					ans += str;
					frequency_array[j] -= 1;
				} else {
					break;
				}
			}

			else if (frequency_array[i] > 0) {
				int temp = frequency_array[i];
				frequency_array[i] -= temp;
				String st = String.valueOf((char) (i + 'a'));

				while (temp > 0) {
					ans += st;
					temp--;
				}
			}
			else {
				i--;
			}
		}
		return ans;
	}

	// Driver code
	public static void main(String[] args) {
		String S = "zzzazz";
		int k = 2;
		System.out.print(getLargestString(S, k));
	}

}
