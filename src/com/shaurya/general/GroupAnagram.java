package com.shaurya.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {
	public static List<Integer> stringAnagram(List<String> dic, List<String> query) {
        int len = dic.size();
        List<String> sorted = new ArrayList<String>(dic);
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<len;i++){
            char ch[] = dic.get(i).toCharArray();
            sort(ch);
            String str = new String(ch);
            if(map.containsKey(str)){
                map.put(str, map.get(str)+1);
            }else{
                map.put(str, 1);
            }
            sorted.add(i,new String(ch));
        }
        List<String> sortedQuery = new ArrayList<>(query.size());
        for(int i=0;i<query.size();i++){
            char ch[] = query.get(i).toCharArray();
            sort(ch);
            sortedQuery.add(i,new String(ch));
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<query.size();i++){
            if(map.containsKey(sortedQuery.get(i))){
                ans.add(map.get(sortedQuery.get(i)));
            }else{
                ans.add(0);
            }
        }
        return ans;
    }
    private static void sort(char ch[]){
        int n = ch.length;
        int count[] = new int[26];
        for(char c:ch){
            count[c-'a']++;
        }
        for(int i=1;i<26;i++){
            count[i]+=count[i-1];
        }
        char out[] = new char[n];
        for(int i=n-1;i>=0;i--){
            out[count[ch[i]-'a']-1] = ch[i];
            count[ch[i]-'a']--;
        }
        for(int i=0;i<n;i++){
            ch[i] = out[i];
        }
    }
	
	public static void main(String[] args) {
		List<String> dic = new ArrayList<String>();;
		dic = Arrays.asList("abc","bca","acb","bac","rank","karn");
		List<String> query = new ArrayList<String>();;
		query = Arrays.asList("a","nark","abc");
		System.out.println(stringAnagram(dic,query));

	}

}


