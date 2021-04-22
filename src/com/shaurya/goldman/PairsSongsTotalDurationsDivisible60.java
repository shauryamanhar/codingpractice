package com.shaurya.goldman;

public class PairsSongsTotalDurationsDivisible60 {

	public static void main(String[] args) {
		int a[] = {30,20,150,100,40};
		System.out.println(numPairsDivisibleBy60(a));
	}
    static  int numPairsDivisibleBy60(int[] time) {
        int mod[] = new int[time.length];
        int hash[] = new int[60];
        for(int i=0;i<time.length;i++){
            mod[i]=time[i]% 60;
        }
        int pairFound=0;
        for(int i=0;i<time.length;i++){
            if(hash[60-mod[i]]>=0){
                pairFound++;
            }
            hash[mod[i]]++;
        }
        return pairFound;
    }
    

}
