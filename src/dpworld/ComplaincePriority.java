package dpworld;

import java.util.*;

public class ComplaincePriority {
	public static void main(String[] args) {
		List<Integer> result = reassignedPriorities(Arrays.asList(1,4,8,4));
		result = reassignedPriorities(Arrays.asList(1,3,7,3));
		System.out.println(result);
	}
	static List<Integer> reassignedPriorities(List<Integer> priority){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		TreeSet<Integer> set = new TreeSet<Integer>(priority);
		int j=1;
		for(Integer key:set) {
			map.put(key, j);
			j++;
		}
		List<Integer> newPriority = new ArrayList<Integer>();
		for(int i=0;i<priority.size();i++) {
			int temp = map.get(priority.get(i));
			newPriority.add(temp);
		}
		return newPriority;
	}
}
