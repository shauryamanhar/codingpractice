package com.shaurya.leetcode;

import java.util.LinkedHashSet;
import java.util.Set;

public class UniqueEmailAddresses {
	
    public int numUniqueEmails(String[] emails) {
    	Set<String> set = new LinkedHashSet<String>();
    	for(String email:emails) {
    		StringBuilder local = new StringBuilder();
    		StringBuilder domain = new StringBuilder();
    		boolean found = false;
    		boolean firstPlus = false;
    		for(int i=0;i<email.length();i++) {
    			if(email.charAt(i)=='@') {
    				found = true;
    				continue;
    			}
    			if(!found) {
    				if(firstPlus) {
    					continue;
    				}
    				if(email.charAt(i)=='.' || email.charAt(i)=='+') {
    					if(email.charAt(i)=='+') {
    						firstPlus = true;
    					}
    					continue;
    				}else {
    					local.append(email.charAt(i));
    				}
    			}else {
    				domain.append(email.charAt(i));
    			}
    		}
    		set.add(local+"@"+domain);
    	}
//    	System.out.println(set);
        return set.size();
    }
	
	
	public static void main(String[] args) {
		UniqueEmailAddresses o = new UniqueEmailAddresses();
//		String []emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
		String []emails = {"a@leetcode.com","b@leetcode.com","c@leetcode.com"};
		int ans = o.numUniqueEmails(emails);
		System.out.println(ans);
	}
}
