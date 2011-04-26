package com.amadamala.timer;

import java.util.ArrayList;
import java.util.HashMap;

public class BucheitTimer{
	HashMap<Long,String> ongoingTimers = new HashMap<Long, String>();
	public static ArrayList<HashMap> insertOrder = new ArrayList<HashMap>();
	private static final int LINE_LENGTH = 100;

	public static void recordTimeWithTag(String tag) {
		HashMap<String, Object> timeRec = new HashMap<String, Object>();
		timeRec.put("time", new Long(System.nanoTime()));
		timeRec.put("tag", tag);
		insertOrder.add(timeRec);
	}

	public static void finishAndReport() {
		for (int i = 0; i < insertOrder.size(); i++) {
			
			if(i > 0) {
				Long start = (Long)(insertOrder.get(i - 1)).get("time") ;
				Long end = (Long)(insertOrder.get(i)).get("time") ;
				Long foo = (end - start);
				long nanos = foo.longValue();
				String viz = repeat("|", nanos/1000000); 
				System.out.println("PBTimer: Between '"+ (insertOrder.get(i-1)).get("tag") + "' and '"+ (insertOrder.get(i)).get("tag")+"':\n"+viz+"\n took "+((double)nanos/1000000000)+" s");
             }
		}
	}

	
	public static String repeat(String s, long times) {
		String result = "";
		for (long i = 1; i <= times; i++) {
			result += s;
			if( i % LINE_LENGTH == 0)
				result += "\n";
		}
		return result;		
	}	
}

