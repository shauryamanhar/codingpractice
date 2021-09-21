package interview.stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class CollectorsExample {
	public static void main(String[] args) {
		// to list
		List<String> givenList = Arrays.asList("a", "b", "c", "d","a");
		List<String> result = givenList.stream().collect(toList());
		System.out.println(result);
		
		//to set
		Set<String> resultSet = givenList.stream().collect(toSet());
		System.out.println("resultSet " + resultSet);

		// to map
		// new key mapping function and value mapping function
		givenList = Arrays.asList("Shaurya ", "manhar", "java developer");
		//create map of string and length
		// function returns same value
		Map<String, Integer> stringLengthMap = givenList.stream().collect(toMap(Function.identity(), String::length));
		System.out.println("string Length map: " + stringLengthMap);

		givenList = Arrays.asList("shaurya manhar ", "bat man", "java developer");
		// create map of first name and length
		Function<String, String> trim = (s) -> s.substring(0, s.indexOf(" "));
		stringLengthMap = givenList.stream().collect(toMap(trim, String::length));
		System.out.println(stringLengthMap);

		// illegal state exception when there is duplicate key
		givenList = Arrays.asList("shaurya manhar ", "bat man", "java developer", "java developer");
		// to avoid this need to add binary operator to compare the key
		stringLengthMap = givenList.stream()
				.collect(toMap(trim, String::length, (first, second) -> first.compareTo(second) >= 0 ? first : second));
		System.out.println(stringLengthMap);// no duplicates
	}
}
