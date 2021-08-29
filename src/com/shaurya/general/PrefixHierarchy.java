package com.shaurya.general;
import java.io.IOException;
import java.util.*;
import java.util.function.*;
public class PrefixHierarchy {
	public static void main(String[] args) {
		List<String> names = new ArrayList<>(Arrays.asList("steve","stevens","danny",
				"steves","dan","john","johny","joe","alex","alexander"));
		List<String> q = new ArrayList<>(Arrays.asList("steve","alex","joe","john","dan"));
		findCompletePrefix(names, q);
	}
	static List<Integer> findCompletePrefix(List<String> names,List<String> query){
		List<Integer> ans = new ArrayList<>();
		for(String qry:query) {
			int count=0;
			for(String name:names) {
				if(name.startsWith(qry) && !name.equals(qry)) {
					count++;
				}
			}
			ans.add(count);
		}
		return ans;
	}//fun
	
	
}//end



