package com.shaurya.leetcode;


public class MultiUserFileSystem {
	static class Trie{
		int permission;
		char userName[];
		char groupName[];
		
		Trie next[];
		Trie(){
			next = new Trie[28];
		}
		void add(char str[],int i) {
			if(i<str.length) {
				int ch = str[i]-'a';
				if(str[i]=='/') {
					ch=26;
				}
				if(str[i]=='.') {
					ch=27;
				}
				
				if(next[ch]==null) {
					next[ch]=new Trie();
				}
				next[ch].add(str, i+1);
			}
		}
		
		Trie get(char str[],int i) {
			if(i<str.length) {
				int ch = str[i]-'a';
				if(str[i]=='/') {
					ch=26;
				}
				if(str[i]=='.') {
					ch=27;
				}
				System.out.println("found "+str[i]);
				if(next[ch]!=null) {
					return next[ch].get(str, i+1);
				}
				return null;//fail case
			}
			return this;
		}
	}//trie
	static Trie t = new Trie();
	public static void main(String[] args) {
		char ch[] = "/".toCharArray();
		t.add(ch, 0);
		
		char path[] = "/".toCharArray();
		char dn[] = "aaa/".toCharArray();
		createDirectory("alice".toCharArray(), path, dn, 2);
		t.get("/aaa/".toCharArray(), 0);
		
		createDirectory("alice".toCharArray(), "/aaa/".toCharArray(), "bbb/".toCharArray(), 2);
		
		System.out.println(t.get("/aaa/bbb/".toCharArray(), 0).userName);
		
	}
	static boolean createDirectory(char userName[],char path[],char directoryName[],int permission) {
		Trie node = t.get(path, 0);
		
		t.add((new String(path)+new String(directoryName)).toCharArray(), 0);
		node = t.get((new String(path)+new String(directoryName)).toCharArray(), 0);
		System.out.println(node);
		node.userName=userName;
		return true;
	}
}
