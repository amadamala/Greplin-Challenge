import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.amadamala.timer.BucheitTimer;


public class SubsetsOfNumbersLargestNumber {

	public static final int CHAR_BASE = 65; 	// base to convert to big case character letter
	
	public static int count = 0;				// number of subsets 
	
	// input list
	public static int[] list = {3, 4, 9, 14, 15, 19, 28, 37, 47, 50, 54, 56, 59, 61, 70, 73, 78, 81, 92, 95, 97, 99};
	
	// map the items with alphabet for ease of programming
	public static Map<Character, Integer> m = new HashMap<Character, Integer>();
	
	public static void main(String[] args) {
		String s = "";
		for(int i = 0; i < list.length; i++) {  // -1 because last number is the biggest
			char t = (char)(i + CHAR_BASE);	    // hack because I know there will be only 22 items
			m.put(t, list[i]);
			s += t;
		}
		
		BucheitTimer.recordTimeWithTag("before comb1");
		comb1(s);
		BucheitTimer.recordTimeWithTag("after comb1");
		BucheitTimer.finishAndReport();
		
		System.out.println("Number of subsets: " + count);
	}

	// TODO reduce the complexity and target to only this problem
    // print all subsets of the characters in s
    public static void comb1(String s) { comb1("", s); }

    // print all subsets of the remaining elements, with given prefix 
    private static void comb1(String prefix, String s) {
        if (s.length() > 0) {
            sumOfString(prefix + s.charAt(0));
            comb1(prefix + s.charAt(0), s.substring(1));
            comb1(prefix,               s.substring(1));
        }
    }  
    
    public static void sumOfString(String s) {

    	// avoid 1 letter combinations
    	if(s.trim().length() == 1) 
    		return;

    	char[] c = s.toCharArray();
    	int sum = 0;

    	for (char d : c) 
			sum += m.get(d);
	
		if(Arrays.binarySearch(list, sum) >=  0 )
			count++;

    }
}
