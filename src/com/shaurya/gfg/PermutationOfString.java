package com.shaurya.gfg;

import java.util.*;

public class PermutationOfString {
	
    public List<String> find_permutation(String s) {
    	char ch[] = s.toCharArray();
    	List<String> list = new ArrayList<String>();
    	permutation(ch, 0,list);
    	Collections.sort(list);
    	return list;
    }
    
    private void permutation(char ch[],int index,List<String> list) {
    	if(index>=ch.length) {
    		list.add(String.valueOf(ch));
    		return;
    	}
    	for(int i=index;i<ch.length;i++) {
    		swap(ch,index,i);
    		permutation(ch, index+1,list);
    		swap(ch,index,i);
    	}
    }
    void swap(char ch[],int i,int j) {
    	char temp = ch[i];
    	ch[i] = ch[j];
    	ch[j] = temp;
    }
	
	public static void main(String[] args) {
		String s = "ljr";
		PermutationOfString p = new PermutationOfString();
		List<String> ans = p.find_permutation(s);
		System.out.println(ans);
	}

}
