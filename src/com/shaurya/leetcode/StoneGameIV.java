// package com.shaurya.leetcode;

// public class StoneGameIV {
//     public static void main(String[] args) {
//         int a[] = {5,3,4,5};
//         boolean v[] = new boolean[a.length];
//         stone(a, 0, 0, 0, v, true);
//     }
//     static boolean stone(int n){
//         if(n==0){
//             return false;
//         }
//         if(n==1){
//             return true;
//         }
//         for(int i=1;i*i<=n;i++){
//             if(!stone(n-i*i)){
//                 stone(n-i*i);
//             }
//         }
//     }//stone
// }
