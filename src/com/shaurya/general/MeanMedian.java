package com.shaurya.general;

import java.util.ArrayList;
import java.util.Collections;

public class MeanMedian {
    public static void main(String[] args) {
        int a[] = {1,3,2,4};
        maxmeanmedian(a.length, a);   
    }
    static void maxmeanmedian(int len,int a[]){
        int n = len;
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> max = new ArrayList<>();
        double maxmean=-999;
        for(int i=0;i<(1<<n);i++){
            double sum=0,size=0;
            list = new ArrayList<>();
            for (int j = 0; j < a.length; j++) {
                if((i&(1<<j))>0){
                    list.add(a[j]);
                    sum=sum+a[j];
                    size++;
                }
            }
            if(size==0)
                continue;
            double mean= sum/size;
            Collections.sort(list);
            double median;
            int mid = list.size()/2;
            if(size%2==0){
                median = (list.get(mid)+list.get(mid-1))/2.0;
            }else{
                median=list.get(mid);
            }
            double curr = mean - median;
            if(maxmean<curr){
                maxmean=curr;
                max=list;
            }
        }
        System.out.println(max);
        
    }
}
