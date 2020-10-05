package com.shaurya.leetcode;

public class FlipTheBit {
    public static void main(String[] args) {
        int n=10;
        System.out.println(bitwiseComplement(n));
    }
    static public int bitwiseComplement(int n) {
        //ex: size found 3
        int size = (int)(Math.log(n)/Math.log(2));
        System.out.println("size "+size);
        int m = 1 << size;//m 1000  
        m = m | m - 1; // m = 1000 | 0111 = 1111
        n = n ^ m;  //n = 0101 ^ 1111 => 1010
        return n;
    }
}
