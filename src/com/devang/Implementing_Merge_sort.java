package com.devang;

public class Implementing_Merge_sort {

	public static void main(String[] args) {
		int[] a = { 5, 2, 3 ,8,9};
		int[] b = { 2, 3, 4, 8, 90, 100, 120, 150 };// ,11,15};
		int[] result = divide(a, 0, 4);
}
	static int[] divide(int[] a, int l, int r) {
		System.out.println("a.lenght "+a.length);
		if (l < r) {
			System.out.println("l "+l+" r "+r);
			int mid = (r + l) / 2;
			int[] la = new int[mid + 1 - l];
			for (int i = 0; i < mid+1-l; i++) {
				la[i] = a[l + i];
			}
			// call divide on left
			int[] L = divide(la, l, mid);
			int[] ra = new int[r - mid];
			for (int i = 0; i < r - mid; i++) {
				ra[i] = a[mid + 1 + i];
			}
			// call divide on right
			int[] R = divide(ra, mid + 1, r);
			int[] result = merge(L, R);
			return result;

		} // if
		return a;
	}
	static int[] merge(int[] l, int[] r) {
		int index = 0;
		int count = 0;
		int count1 = 0;
		int[] a = new int[l.length + r.length];
		for (int i = 0; i < l.length; i++) {
			for (int j = count; j < r.length; j++) {
				if (l[i] < r[j]) {
					a[index] = l[i];
					index++;
					count1++;
					break;
				}
				if (l[i] > r[j]) {
					a[index] = r[j];
					index++;
					count++;
				}
			}
		}
		/// System.out.println(count+" count1");
		for (int z = count1; z < l.length; z++) {

			if (count1 == l.length)
				break;
			a[index] = l[z];
			index++;
		}
		for (int z = count; z < r.length; z++) {
			if (count == r.length)
				break;
			a[index] = r[z];
			index++;
		}
		return a;



	}

}