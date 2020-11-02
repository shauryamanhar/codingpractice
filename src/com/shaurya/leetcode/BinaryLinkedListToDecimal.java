package com.shaurya.leetcode;

public class BinaryLinkedListToDecimal {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int v){
            this.val=v;
            next=null;
        }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next= new ListNode(0);
        head.next.next = new ListNode(1);
        System.out.println("Decimal Bitmanipulation "+
            getDecimalValueBitManipulation(head));
        System.out.println("Decimal Normal "+
            getDecimalValue(head));    
        System.out.println("Decimal Sum method "+
            getDecimalValueSumation(head));    
    }
    static public int getDecimalValue(ListNode head) {
        StringBuffer binaryString = new StringBuffer();
        while(head!=null){
            binaryString.append(head.val);
            head=head.next;
        }
        return Integer.parseInt(binaryString.toString(), 2);
    }

    //using bitmanipulation
    static public int getDecimalValueBitManipulation(ListNode head) {
        int n = head.val;
        //eg. 1->0->1-null
        //n = 1 and after (n<<1)-> n = 10 and then (n|0 or n|1) 10|1=11 or 10|0=10 
        while(head.next!=null){
            n = (n<<1) | head.next.val;
            head=head.next;
        }
        return n;
    }
    //using sum method
    static public int getDecimalValueSumation(ListNode head) {
        int n = 0;
        while(head!=null){
            n = n*2 + head.val;
            head=head.next;
        }
        return n;
    }
}
