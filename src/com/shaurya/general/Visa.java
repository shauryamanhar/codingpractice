package com.shaurya.general;

import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Predicate;

public class Visa {
	public static void main(String[] args) {
		String a[]= {"aab","bbbaaaa","acajdlasjdjosd"};
		Function<String, CharactersCount> f = Mapper.getDistinctCharactersCount();
		for(String s:a) {
			System.out.println(f.apply(s).toString());
		}
	}
}

class Filter{
	static Predicate<String> nameStartingWithPrefix(String prefix){
		Predicate<String> checkPrefix = (s)->s.startsWith(prefix);
		return checkPrefix;
	}
}//filter
class Mapper{
	static Function<String, CharactersCount> getDistinctCharactersCount(){
		Function<String, CharactersCount> calculateUnique = (s)->{
			TreeSet<Character> set = new TreeSet<Character>();
			for(char ch:s.toCharArray()) {
				set.add(ch);
			}
			CharactersCount charCount = new CharactersCount(s, set.size());
			return charCount;
		};
		return calculateUnique;
	}
}

class CharactersCount{
	String name;
	Integer distinctCharacterCount;
	public CharactersCount(String name, Integer distinctCharacterCount) {
		super();
		this.name = name;
		this.distinctCharacterCount = distinctCharacterCount;
	}
	@Override
	public String toString() {
		return name+" "+distinctCharacterCount;
	}
}
