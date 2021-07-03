package com.shaurya.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Codechef {

	public static void main(String[] args) {
		FastReader f = new FastReader();
		long t = f.nextLong();
		while(t-->0) {
			long D = f.nextLong();
			long d = f.nextLong();
			long p = f.nextLong();
			long q = f.nextLong();
			long sum = 0;
			long n = D/d;
			sum = (((n*p)+(n*(n-1)*q/2)))*d;
			if(D%d!=0) {
				sum+= ((D%d)*(p+n*q));
			}
			System.out.println(sum);
		}
		
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
