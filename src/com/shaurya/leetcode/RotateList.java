package com.shaurya.leetcode;

public class RotateList {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            next=null;
        }
    }//node

    public static void main(String[] args) {
        Node head = new Node(1);
        Node curr = head;
        for(int i=2;i<=5;i++){
            curr.next = new Node(i);
            curr = curr.next;
        }
        print(head);
        System.out.println("++++++++++");
        rotateList(head, 2);

    }
    //rotate list by k 
    static void rotateList(Node head,int k){
        if(k==0 || head==null){
            return;
        }
        int length=0;
        Node tail = head;
        while(tail.next!=null){
            tail = tail.next;
            length++;
        }
        length++;//count at the last node
        tail.next = head;//join tail to head
        int point = length - k%length;//point of join
        tail  = head;
        //go to node where end and start exists
        //tail will lead to end of new list
        //ant tail.next will be new head
        while(point-->1){
            tail = tail.next;
        }

        head = tail.next;//setting new head
        tail.next= null;//disconnecting the tail to head
        print(head);
    }//rotatelist

    static void print(Node head){
        while(head!=null){
            System.out.print(head.data+"->");
            head=head.next;
        }
        System.out.println(head);
    }

}
