import java.util.Scanner; 

public class Solution { 
	static int count=0;
	static void jump(int a[],int n,int d,int index) {
		if((index>=n-1)) {
			return;
		}
		if(a[index]==0) {
			count++;
			a[index]=2;
		}
		int nextJump=0;
		for(int i=index+1;i<n&&i<=index+d;i++) {
			if(a[i]==1) {
				nextJump=i;
			}
		}//for
		if(nextJump==0) {
			nextJump = index+d;
			while(!(nextJump<n)) {
				nextJump--;
			}
			jump(a,n,d,nextJump);
		}else {
			jump(a,n,d,nextJump);
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int j=1;
		while(t-->0) {
			int n = sc.nextInt();
			int d = sc.nextInt();
			int a[] = new int[n];
			for(int i=0;i<n;i++) {
				a[i]=sc.nextInt();
			}
			count=0;
			jump(a,a.length,d,0);
			if(a[a.length-1]==0) {
				count++;
			}
			System.out.println("#"+j+++" "+count);
		}
	}
} 