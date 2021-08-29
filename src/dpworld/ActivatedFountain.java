package dpworld;

public class ActivatedFountain {

	public static void main(String[] args) {
		int arr[] = {2,0,0,0};
		int n = arr.length;
		System.out.println(findMinActivatedFountain(arr, n));
	}
	static int findMinActivatedFountain(int[] arr, int n) {
		int count = 1;
        int[] interval = new int[n];
        for (int i = 1; i <= n; i++) {
            int right = Math.min(i + arr[i - 1], n);
            int left = Math.max(i - arr[i - 1], 1);
            interval[left - 1] = right;
        }
        int right = interval[0];
        int currMax = right;
        for (int i = 1; i < n; i++) {
            currMax = Math.max(currMax, interval[i]);
            if (i == right) {
                count++;
                right = currMax;
            }
        }
        return count;
    }
}

