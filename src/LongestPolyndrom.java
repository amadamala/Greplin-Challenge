import com.amadamala.timer.BucheitTimer;


    class LongestPolyndrom {

    public static String str = "FourscoreandsevenyearsagoourfaathersbroughtforthonthiscontainentanewnationconceivedinzLibertyanddedicatedtothepropositionthatallmenarecreatedequalNowweareengagedinagreahtcivilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
	public static String reverseStr;

	public static void main(final String[] args) {
		BucheitTimer.recordTimeWithTag("reverse str");
		reverseStr = new StringBuffer(str).reverse().toString();

//		for(int i = 1; i <= 10; i++) {
//			if(i == 1) {
//				BucheitTimer.recordTimeWithTag("search-" + i);
//			}
			search();
//			BucheitTimer.recordTimeWithTag("search-" + i);
//		}
		
		
		BucheitTimer.finishAndReport();
	}

	// search the largest sub-string which is polyndrom.
	public static void search() {
		String t;
		int idx = 0;
		int maxLen = 0;
		int maxIdx = 0;
		String bigPoly = null;

 		for (int i = 0; i < str.length()-1; i++) {
			for (int j = (i + 1); j < str.length(); j++) {
				 t = str.substring(i, j + 1);
				 
				 // alt-2
//				 if(isPoly(t) == true && t.length() > maxLen) {
//					 maxIdx = idx;
//					 maxLen = t.length();
//					 bigPoly = t;
//				 }
				 
				 //TODO: check the question whether it says polyndrom or not
				 if(t.charAt(0) != t.charAt(t.length() - 1)) {
					 continue;
				 }
				 
				 BucheitTimer.recordTimeWithTag("before index");
				 idx = reverseStr.indexOf(t);
				 BucheitTimer.recordTimeWithTag("after index");
				 if (idx > 0) {
					 if (t.length() > maxLen) {
						 maxIdx = idx;
						 maxLen = t.length();
						 bigPoly = t;
					 }
				 }
				 BucheitTimer.recordTimeWithTag("after logic");
			}
		}
		System.out.println("longest polyndrom: \"" + bigPoly  + "\" at " 
				+ maxIdx + " with length " + maxLen);
	}
	
	// return true if the input is polyndrom
	public static boolean isPoly(String s){
		int l = s.length();
		for(int i=0; i < l/2; i++) {
			if(s.charAt(i) != s.charAt(l - (i + 1)) ) {	
				return false;
			}
		}
		return true;
	}
	
	

}
