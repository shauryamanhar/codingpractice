package com.shaurya.general;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MySolution {
    public static void main(String[] args) {
        int[] arr= 
            // {2,3,2,1,3};
         {1,3,2,4};
        Arrays.sort(arr);
        int[] outp=meanMedian(arr);
        for(int e:outp) {
            System.out.print(e+"\t");
        }
    }

    protected static int[] meanMedian(int[] arr) {
        double median=findMedian(arr);
        double mean=findMean(arr);
        double diff=median-mean;
        int MAXINDEX=0;
        int n=arr.length;
        double sets=(1<<n);
        System.out.println("sets:"+sets);
        for(int i=1;i<=sets;i++) {
            int[] subset=findSubset(i,arr);
            mean=findMean(subset);
            median=findMedian(subset);
            if(mean -median>diff) {
                diff=mean-median;MAXINDEX=i;
            }
        }
        System.out.println("mean: "+mean+"\tmedian: "+median+"\tdiff: "+diff);
        return findSubset(MAXINDEX,arr);
    }
    protected static int[] findSubset(int counter, int[] arr) {
        int n=arr.length;
        List<Integer> ls=new ArrayList<Integer>();
        for(int j=0;j<n;j++) {
            if((counter & (1<<j))>0) {
                ls.add(arr[j]);
            }
        }
        int[] output= new int[ls.size()];
        for(int j=0;j<ls.size();j++) {
            output[j]=ls.get(j);
        }
        return output;
    }

    protected static double findMean(int[] arr) {
        int n=arr.length;
        double sum=0;
        if(n==0) return 0;
        for(int i=0;i<n;i++)
            sum +=arr[i];
        return (sum/n);
    }

    protected static double findMedian(int[] arr) {
        int n=arr.length;
        if(n%2==1)
            return arr[(n/2)];
        else if(n>=2)
            return 0.5*(arr[((n-2)/2)]+arr[n/2]);
        else return 0;
    }
}