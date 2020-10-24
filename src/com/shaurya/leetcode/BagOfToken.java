package com.shaurya.leetcode;
import java.util.Arrays;

//https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/562/week-4-october-22nd-october-28th/3506/
public class BagOfToken {
    static int max = -1;

    public static void main(String[] args) {
        int tokens[] = { 59, 0, 15, 33, 79, 72, 34, 62, 4, 16 };
        int size = tokens.length;
        int power = 99;
        boolean vis[] = new boolean[size];
        bt(tokens, 0, power, 0, vis, size);


        System.out.println("max score " + bagOfTokensScore(tokens, power));
    }
    //greedy approach
    //the idea to solve this problem is
    //first to know relation between score and power 
    //if we want to increase the score then we have to loss power
    //from this we try to loose less power for score and gain more power for loosing score
    static public int bagOfTokensScore(int[] tokens, int power) {
        //by soring the array will insure that we can loose less power in starting of array
        Arrays.sort(tokens);
        int maxScore=0;
        int currScore=0;
        //pointer use to know where we can loose power and again more power
        int left=0,right=tokens.length-1;
        while(left<=right){
            //in the start of array we try to increase score because we have less power to loose in the start
            if(power>=tokens[left]){
                currScore++;
                power=power-tokens[left];
                left++;
                maxScore=Math.max(maxScore,currScore);
            }else if(currScore>0){//if we have score==0 then we can't loose more score
                power=power+tokens[right];
                currScore--;
                right--;
            }else{//last condition where we can't get power or score because score<0 and power<0
                return maxScore;//just return the maxScore
            }
        }
        return maxScore;
    }
    //complexity is very high but still works on local compiler
    static public void bt(int[] tokens, int curr, int power, int score, boolean vis[], int size) {
        System.out.println("power "+power+" score "+score);
        // try {
        //     Thread.sleep(5000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        if(curr<0 || curr>=size){
            return;
        }
        if(power<0 || score<0){
            return;
        }
        if(max<score){
            max=score;
        }
        for (int i = 0; i < size; i++) {
            if(!vis[i]){
                vis[i]=true;
                //face up
                bt(tokens, i, power-tokens[i], score+1, vis, size);
                //face down
                bt(tokens, i, power+tokens[i], score-1, vis, size);
                vis[i]=false;
            }
        }
    }
}
