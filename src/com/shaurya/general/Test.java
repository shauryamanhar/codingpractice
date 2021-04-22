package com.shaurya.general;
import java.util.*;
public class Test {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int a[]=null;
        while(t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            a = new int[n+1];
            for(int i=0;i<m;i++){
                int l = sc.nextInt();
                int r = sc.nextInt();
                for(int j=l;j<=r;j++){
                    a[j]++;
                }
            }
            ArrayList<Pair> list = new ArrayList<Pair>();
            for(int i=1;i<a.length;i++){
                list.add(new Pair(i,a[i]));
            }
            Collections.sort(list);
            System.out.println(list);
            for(int i=list.size()-3;i<list.size();i++) {
            	System.out.print(list.get(i).idx+" ");
            }
            System.out.println();
        }
    }
    static class Pair implements Comparable<Pair>{
        int idx;
        int value;
        Pair(int i,int v){
            this.idx = i;
            this.value=v;
        }
		@Override
		public int compareTo(Pair b) {
			if(value>b.value){
                return 1;
            }else if(value<b.value){
                return -1;
            }else{
                if(idx>b.idx){
                    return 1;
                }else if(idx<b.idx){
                    return -1;
                }else{
                    return 0;
                }
            }
		}
		@Override
		public String toString() {
			return idx+"->"+value;
		}
    }
    
}
