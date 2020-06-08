package com.shaurya.leetcode;

public class TwoCityScheduling {

	public static void main(String[] args) {
		int a[][] = {{259,770},{448,54},{926,667},{184,139},{840,118},{377,469}};
		System.out.println(twoCitySchedCost(a));
	}
	
	static public int twoCitySchedCost(int[][] costs) {
        Cost costMatrix[] = new Cost[costs.length];
        for(int i=0;i<costs.length;i++) {
//        	System.out.println(costs[i][0]+" - "+costs[i][1]+" = "+(costs[i][1]-costs[i][0]));
        	costMatrix[i]=new Cost(i, costs[i][1]-costs[i][0]);
        }
        mergeSort(costMatrix, 0, costs.length-1);
        for(int i=0;i<costs.length;i++) {
        	System.out.println("profit "+costMatrix[i].profit+" i "+costMatrix[i].index);
        }
        int cost = 0;
        int i=0;
        int a,b;
        for(i=0;i<costs.length/2;i++) {
        	a = costMatrix[i].index;
        	System.out.println("cost "+costs[a][0]);
        	cost+=costs[a][0];
        }
        for(;i<costs.length;i++) {
        	a = costMatrix[i].index;
        	cost+=costs[i][1];
        }
		return cost;
    }
	static class Cost{
		int index;
		int profit;
		Cost(int i,int p) {
			index=i;
			profit=p;
		}
	}
	
	static void mergeSort(Cost a[],int l,int r) {
		if(l<r) {
			int mid = l+(r-l)/2;
			mergeSort(a, l, mid);
			mergeSort(a, mid+1, r);
			merge(a, l, mid, r);
		}
	}
	
	static void merge(Cost a[],int l,int mid,int r) {
		int n1=mid-l+1;
		int n2=r-mid;
		Cost L[] = new Cost[n1];
		Cost R[] = new Cost[n2];
		int i,j,k;
		for(i=0;i<n1;i++) {
			L[i]=a[l+i];
		}
		for(j=0;j<n2;j++) {
			R[j]=a[mid+1+j];
		}
		
		
		i=0;
		j=0;
		k=l;
		
		while(i<n1 && j<n2) {
			if(L[i].profit>R[j].profit ) {
				a[k]=L[i];
				i++;
			}else {
				a[k]=R[j];
				j++;
			}
			k++;
		}
		while (i < n1){ 
	        a[k] = L[i]; 
	        i++; 
	        k++; 
	    } 
	  
	    while (j < n2){ 
	        a[k] = R[j]; 
	        j++; 
	        k++; 
	    }
	}

}
