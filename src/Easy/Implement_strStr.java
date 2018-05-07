package Easy;

public class Implement_strStr {
	private static int strStr(String haystack, String needle){
		int hleng = haystack.length();
		int nleng = needle.length();
		if (hleng == 0 && nleng == 0) return 0;
		if ((hleng == 0 && nleng != 0) || hleng < nleng)	return -1;
		
		for (int i = 0; i <= hleng - nleng; i++){   
				int pos = i;
				for (int j = 0; j < nleng; j++){        			
					if (haystack.charAt(pos) == needle.charAt(j))
						pos++;
				}
				if (pos - i == nleng)
					return i;
		}		
		return -1; 
	}
	
	public static void main(String[] args){
		String a = "aa";
		String b = "aa";
		System.out.println(strStr(a, b));
	}
	
}
