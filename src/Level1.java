import com.amadamala.timer.BucheitTimer;

class Level1 {

	public static String str = "FourscoreandsevenyearsagoourfaathersbroughtforthonthiscontainentanewnationconceivedinzLibertyanddedicatedtothepropositionthatallmenarecreatedequalNowweareengagedinagreahtcivilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";

	public static void main(final String[] args) {
		BucheitTimer.recordTimeWithTag("before search");
		search();
		BucheitTimer.recordTimeWithTag("after search");
		BucheitTimer.finishAndReport();
	}

	/* search the largest sub-string which is polyndrom. */
	public static void search() {
		String t;
		int idx = 0;
		int maxLen = 0;
		int maxIdx = 0;
		String bigPoly = null;

		for (int i = 0; i < str.length() - 1; i++)
			for (int j = (i + 1); j < str.length(); j++) {
				t = str.substring(i, j + 1);
				if (isPoly(t) && t.length() > maxLen) {
					maxIdx = idx;
					maxLen = t.length();
					bigPoly = t;
				}
			}

		System.out.println("longest polyndrom: \"" + bigPoly + "\" at "	
				+ maxIdx + " with length " + maxLen);
	}

	/* Return true if the input is polyndrom */
	public static boolean isPoly(String s) {
		int l = s.length();
		for (int i = 0; i < (l / 2); i++)
			if ( s.charAt(i) != s.charAt(l - (i + 1)) )
				return false;
		return true;
	}
}
