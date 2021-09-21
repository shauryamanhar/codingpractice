package interview.stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GroupingbyExamples {
	public static void main(String[] args) {
		//creating group of string having same length
		List<String> givenList = Arrays.asList("aaaa", "bbbb", "ccccc", "rrrrrrrrr");
		Map<Integer, Set<String>> setOfLength = givenList.stream()
				.collect(groupingBy(String::length, toSet()));
		System.out.println("set of length :" + setOfLength);
		
		System.out.println(
				givenList.stream().collect(groupingBy(String::length)));

	}

}
