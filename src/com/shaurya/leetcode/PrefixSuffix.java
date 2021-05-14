package com.shaurya.leetcode;

public class PrefixSuffix {
	Trie trie;
	public static void main(String[] args) {
		String word[] = {"apple"};
		PrefixSuffix p = new PrefixSuffix(word);
		System.out.println(p.f("ap", "le"));;
	}
    public PrefixSuffix(String words[]) {
    	trie = new Trie();
    	for(int index=0;index<words.length;index++) {
    		String word = words[index]+"{";
    		for(int i=0;i<word.length();i++) {
    			Trie curr = trie;
    			System.out.println("curr.index "+curr.index);
    			for(int j=i;j<2*word.length()-1;j++) {
    				int ch = word.charAt(j % word.length())-'a';
    				if(curr.children[ch]==null) {
    					curr.children[ch]=new Trie();
    				}
    				curr.index=index;
    				curr=curr.children[ch];
    			}
    		}
    	}
	}
    
    int f(String prefix, String suffix) {
    	String search=suffix+"{"+prefix;
    	Trie curr = trie;
    	for(int i=0;i<search.length();i++) {
    		int ch = search.charAt(i)-'a';
    		if(curr.children[ch]==null) {
    			return -1;
    		}
    		curr = curr.children[ch];
    	}
    	return curr.index;
    }
    
    class Trie{
    	Trie children[];
    	int index;
    	Trie(){
    		this.children=new Trie[27];
    		this.index=0;
    	}
    }
}
