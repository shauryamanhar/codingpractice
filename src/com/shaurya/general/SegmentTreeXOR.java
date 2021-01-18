package com.shaurya.general;

import java.util.Scanner;

public class SegmentTreeXOR {
    static int tree[];
    static int a[];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        a = new int[n];
        tree = new int[4*n];
        int ans = 0;
        int q = scan.nextInt();
        int l,r,node=0,start=0,end=n-1;
        for(int i=0;i<q;i++){
            int op = scan.nextInt();
            l = scan.nextInt();
			r = scan.nextInt();
            if(op==0){
                //update
                update(node,start,end,l,r);
            }else{
                //query
                ans+=query(node,start,end,l,r);
            }
        }
        System.out.println("ans is "+ans);
        scan.close();
        
    }
    static void build(int node,int start,int end){
        if(start==end){
            tree[node]=a[start];
        }else{
            int mid = (start+end)/2;
            int left = 2*node+1;
            int right = left+1;
            build(left, start, mid);
            build(right, mid+1, end);
            tree[node]=tree[left]+tree[right];
        }
    }
    static void update(int node,int start,int end,int index,int val){
        if(start==end){
            //leaf node
            a[index]^=1;
            tree[node]^=val;
        }else{
            int mid = start+(end-start)/2;
            int left = 2*node+1;
            int right = left+1;
            if(index<=mid) {
				update(left,start,mid,index,val);
			}else {
				update(right,mid+1,end,index,val);
            }
            tree[node] = tree[left]+tree[right];
        }

    }
     static int query(int node, int start, int end, int l, int r) {
		//no overlapping
		if(l>end || r<start) {
			return Integer.MAX_VALUE;
		}
		
		//fully overlapping
		if(start>=l && end<=r) {
			return tree[node];
		}
		//partial overlapping
		int mid = (start+end)/2;
		int left = 2*node+1;
		int right = left+1;
		
		return query(left,start,mid,l,r)+query(right,mid+1,end,l,r);
	}
}
