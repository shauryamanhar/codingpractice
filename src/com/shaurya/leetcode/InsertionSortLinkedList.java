package com.shaurya.leetcode;

public class InsertionSortLinkedList {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(){
            next=null;
        }
        ListNode head,tail;
        void insert(int v){
            ListNode node = new ListNode();
            node.val=v;
            if(head==null){
                head = node;
                tail = head;
            }else{
                tail.next = node;
                tail = tail.next;
            }
        }
        void print(){
            ListNode c= head;
            while(c!=null){
                System.out.print(c.val+"->");
                c=c.next;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode();
        int a[] = {6,5,3,1,8,7,2,4};
        for(int r:a){
            head.insert(r);
        }
        head.print();
        head = head.head;        
    }
    static ListNode insertionSort(ListNode head){
        ListNode pseudoHead = new ListNode();
        ListNode curr = head, prevNode, nextNode;

        while (curr != null) {
            // At each iteration, we insert an element into the resulting list.
            prevNode = pseudoHead;
            nextNode = pseudoHead.next;

            // find the position to insert the current node
            while (nextNode != null) {
                if (curr.val < nextNode.val)
                    break;
                prevNode = nextNode;
                nextNode = nextNode.next;
            }
            ListNode nextIter = curr.next;
            // insert the current node to the new list
            curr.next = nextNode;
            prevNode.next = curr;

            // moving on to the next iteration
            curr = nextIter;
        }

        return pseudoHead.next;
    }
}
