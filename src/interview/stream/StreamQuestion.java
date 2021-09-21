package interview.stream;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class StreamQuestion {
	public static void main(String[] args) {
//		findFirstElement();
//		findLastElement();
//		findDuplicate();
//		countFrequency();
		doubleStreamInfiniteLoop();
	}

	/*
	 * Find the first element of a Stream in Java
	 * 
	 * Input: Stream = {“Geek_First”, “Geek_2”, “Geek_3”, “Geek_4”, “Geek_Last”}
	 * Output: Geek_First
	 * 
	 * Input: Stream = {1, 2, 3, 4, 5, 6, 7} Output: 1
	 * 
	 */
	static void findFirstElement() {
		Stream<String> stream = Stream.of("a", "b", "c", "d");
		String ans = stream.reduce((first, second) -> first).orElse(null);
		System.out.println("ans " + ans);
		Stream<String> stream2 = Stream.of("a", "b", "c", "d");
		ans = stream2.findFirst().orElse(null);
		System.out.println("ans " + ans);
	}

	/*
	 * 
	 * Find the last element of a Stream in Java Input: Stream={“Geek_First”,
	 * “Geek_2”, “Geek_3”, “Geek_4”, “Geek_Last”} Output: Geek_Last
	 * 
	 * Input: Stream={1, 2, 3, 4, 5, 6, 7} Output: 7
	 * 
	 */
	static void findLastElement() {
		// supplier for getting stream, to avoid illegal state exception
		Supplier<Stream<String>> supplier = () -> Stream.of("a", "b", "c", "d");

		// using reduce
		Stream<String> stream = supplier.get();
		String ans = stream.reduce((first, second) -> second).orElse(null);
		System.out.println("reduce ans " + ans);

		// using reverse
		Stream<String> stream2 = supplier.get();
		ans = stream2.sorted(Collections.reverseOrder()).findFirst().orElse(null);
		System.out.println("reverse ans  " + ans);

		// using skip method
		Stream<String> s3 = supplier.get();
		long count = supplier.get().count();
		s3.close();
		s3 = supplier.get();
		ans = s3.skip(count - 1).findFirst().orElse(null);
		System.out.println("count ans  " + ans);
	}

	/*
	 * https://www.geeksforgeeks.org/how-to-find-duplicate-elements-in-a-stream-in-
	 * java/
	 * 
	 * How to find duplicate elements in a Stream in Java Input: Stream = {5, 13, 4,
	 * 21, 13, 27, 2, 59, 59, 34} Output: [59, 13] Explanation: The only duplicate
	 * elements in the given stream are 59 and 13.
	 * 
	 * Input: Stream = {5, 13, 4, 21, 27, 2, 59, 34} Output: [] Explanation: There
	 * are no duplicate elements in the given stream, hence the output is empty.
	 */

	static void findDuplicate() {
		Supplier<Stream<String>> supplier = () -> Stream.of("a", "b", "c", "d", "a", "d");
		
		//using set
		Set<String> set = new HashSet<String>();
		
		Stream<String> stream = supplier.get();
		Set<String> duplicate = stream.filter(x -> {
			if(set.contains(x)) {
				return true;
			}else {
				set.add(x);
				return false;
			}
		}).collect(Collectors.toSet());
		System.out.println("duplicate using set " + duplicate);
		
		// using group by and frequency count

		stream = supplier.get();
		Set<String> set1 = stream.collect(
				Collectors.groupingBy(
						Function.identity(), Collectors.counting()))
				.entrySet().stream().filter(m -> m.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toSet());
		System.out.println("duplicate by groupby " + set1);
	}

	/*
	 * Count occurrence of a given character in a string using Stream API in Java
	 * 
	 * Input: str = "geeksforgeeks", c = 'e' Output: 4 'e' appears four times in
	 * str.
	 * 
	 * Input: str = "abccdefgaa", c = 'a' Output: 3 'a' appears three times in str.
	 * 
	 */
	static void countFrequency() {
		String str = "geeksforgeeks";
		char x = 'e';
		System.out.println(str);
		long count = str.chars().filter(c -> c == x).count();
		System.out.println("count of " + x + " = " + count);
	}

	/*
	 * Generate Infinite Stream of Double in Java
	 * 
	 */

	static void doubleStreamInfiniteLoop() {
		DoubleStream.iterate(0, x -> x + 1).forEach(System.out::println);
	}
}
