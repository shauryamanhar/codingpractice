import java.util.Scanner; 

public class Solution { 
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			int d = sc.nextInt();
			int a[] = new int[n];
			for(int i=0;i<n;i++) {
				a[i]=sc.nextInt();
			}
			int count=0;
			int i=0;
			while(i<n) {
				if(a[i]==0) {
					count++;
				}
				i=i+d;
			}
			while(i<d) {
				count++;
				i++;
			}
			System.out.println(count);
		}
	} 
} 