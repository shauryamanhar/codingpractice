package com.shaurya.goldman;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRU {
	public static void main(String[] args) {
		LRUCache l = new  LRUCache(2);
		l.put(1, 1);
		l.put(2, 2);
		l.get(1);
		l.put(3, 3);
		l.get(2);
		l.put(4, 4);
		l.get(1);
		l.get(3);
		l.get(4);
		l.get(1);
	}
}
class LRUCache {
	int capacity;
	int size=0;
	HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	Deque<Node> dq = new LinkedList<Node>();
	public LRUCache(int capacity) {
		this.capacity=capacity;
	}
	
	public int get(int key) {
		if(map.containsKey(key)==false) {
			return -1;
		}else {
			//remove from dq 
			Node temp = map.get(key);
			dq.remove(temp);
			dq.addFirst(temp);
			return temp.value;
		}
	}
	
	public void put(int key, int value) {
		if(!map.containsKey(key)) {
			//cache is full
			if(dq.size()==capacity) {
				Node last = dq.getLast();
				//pop the last
				dq.removeLast();
				//erase the last
				map.remove(last.key);
			}
		}else {
			dq.remove(map.get(key));
		}
		//add to front
		dq.addFirst(new Node(key,value));
		map.put(key, dq.peekFirst());
	}
}
class Node{
	int key,value;
	Node(int key,int value){
		this.key=key;
		this.value=value;
	}
	@Override
	public String toString() {
		return "{"+key+" "+value+"}";
	}
}
class LRUCacheRR {
    Map<Integer,Node> map;
    final int capacity;
    Node head= new Node(0,0);
    Node tail=new Node(0,0);
    public LRUCacheRR(int capacity) {
        map=new HashMap<>(capacity);
        this.capacity=capacity;
        //by doing this, it save lot of time of checking null
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key) {
        Node node=map.get(key);
        if(node==null) return -1;

        removeFromLL(node);
        insertToHead(node);
        return node.val;

    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) { //case1 update key
            node.val = value;
            removeFromLL(node);
            insertToHead(node);
        } else  //case2 insert new node , but before ,adjust capacity
        {
            if (map.size() == capacity) {
                Node lastNode = map.remove(tail.prev.key);
                removeFromLL(lastNode); //or tail.prev
            }

            Node newNode = new Node(key, value);
            insertToHead(newNode);
            map.put(key,newNode);
        }
    }

   void removeFromLL(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
//now 'node' free there is no direct connection from any stack to 'node'
//although 'node' is point to somewhere LL but GC will collect it, it is not reachable from graph tree(DFS)
    }
    
    void insertToHead(Node newNode){
        Node tmp=head.next;
        //link head
        head.next=newNode;
        newNode.prev=head;
        //link newNode
        newNode.next=tmp;
        tmp.prev=newNode;
    }

    private class Node{
        int key,val;
        Node next,prev;
        Node(int x,int y){
            key=x;
            val=y;
        }
    }
   
} //class
