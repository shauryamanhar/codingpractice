package com.shaurya.general;

import java.util.*;
import java.util.stream.Collectors;

public class FeaturedProduct {
	public static String findMax(List<String> productList) {
		List<String> list = new ArrayList<String>();
		Map<String, Long> collect = productList.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()));
		int max = collect
				.values()
				.stream()
				.mapToInt(Math::toIntExact)
				.filter(stringLongEntry -> stringLongEntry >= 0)
				.max().orElse(0);
		collect
			.entrySet()
			.forEach(stringLongEntry -> {
				if (stringLongEntry.getValue() == max) {
					list.add(stringLongEntry.getKey());
				}
			});
		return list.stream().sorted().collect(Collectors.toList()).get(list.size() - 1);
	}
}
