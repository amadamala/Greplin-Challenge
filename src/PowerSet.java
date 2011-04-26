import java.lang.Integer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerSet {
	public static Integer[] l =  {3, 4, 9, 14, 15, 19, 28, 37, 47, 50, 54, 56, 59, 61, 70, 73, 78, 81, 92, 95, 97, 99};
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Set<Integer> s = new HashSet<Integer>();
//		{{
//			add(3);
//			add(4);
//			add(9);
//		}};
		s.addAll(Arrays.asList(l));
		
		System.out.println(Arrays.asList(powerSet(s)));
	}

public static Set<Set<Integer>> powerSet(Set<Integer> originalSet) {

        Set<Set<Integer>> sets = new HashSet<Set<Integer>>();
        if (originalSet.isEmpty()) {
            sets.add(new HashSet<Integer>());
            return sets;
        }

        List<Integer> list = new ArrayList<Integer>(originalSet);
        Integer head = list.get(0);
        Set<Integer> rest = new HashSet<Integer>(list.subList(1, list.size()));
        for (Set<Integer> set : powerSet(rest)) {
            Set<Integer> newSet = new HashSet<Integer>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }
        return sets;
  }
}