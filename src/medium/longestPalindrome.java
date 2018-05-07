package medium;

public class longestPalindrome {
    private static boolean checkPalindrome(String s) {
    	int len = s.length();
    	if (len == 0)
    		return true;
    	if (len == 1)
    		return true;
    	
    	char[] cs = s.toCharArray();
    	for (int i = 0; i < len / 2; i++){
    		if (cs[i] != cs[len - 1 - i])
    			return false;
    	}
    	return true;
    }
	
//	private static String longestPalindrome(String s) {	//brutal force
//		int len = s.length();
//    	if (len == 0)
//    		return "";
//    	if (len == 1)
//    		return s;
//		
//		String ms = s.substring(0, 1);
//		for (int i  = 0; i < len; i++){
//			for (int j = i + 1; j < len; j++){
//				if (checkPalindrome(s.substring(i, j + 1)) && j - i + 1 > ms.length())
//					ms = s.substring(i, j + 1);
//			}
//		}
//        return ms;
//    }
	
    private static String longestPalindrome(String s){	//bottom-up DP
		int len = s.length();
		String maxp = s.substring(0, 1);
		
		char start = s.charAt(0);
        int count = 0;
		for (; count < len; count++){
			if (s.charAt(count) != start)
				break;
		}
		if (count >= len/2 + 1) {
            System.out.println("yes");
            return s.substring(0, count);
        }
			
		
    	boolean[][] lp = new boolean[len][len];
    	
    	for (int i = 0; i < len; i++) { 
    		lp[i][i] = true;	// string of length 1
    		if (i < len - 1 && s.charAt(i) == s.charAt(i + 1)){ // p string of length 2
    			lp[i][i + 1] = true;
    			maxp = s.substring(i, i + 2);
    		}	
    	}
    	
    	for (int curlen = 3; curlen <= len; curlen++){
    		
    		for (int head = 0; head < len - curlen + 1; head ++){
    			int tail = head + curlen - 1;
    			if (lp[head + 1][tail - 1] && s.charAt(head) == s.charAt(tail)){
    				lp[head][tail] = true;
    				maxp = s.substring(head, tail + 1);
    			}
    		}
    	}
    	
    	return maxp;
    }
    
	public static void main(String args[]){
		String s = "aaaaaaaaaaabbbbb";					
		System.out.println(longestPalindrome(s));
		return;
	}
}


