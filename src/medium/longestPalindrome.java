package medium;

public class longestPalindrome {
	
	// check if a string is palindromic
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
	
    // Method 1: Brutal Force
//	private static String longestPalindrome(String s) {
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
	
    
    // Method 2: Bottom-up DP, 17%
    private static String longestPalindrome1(String s){
    	if(s == null || s.isEmpty())
    		return "";
    	
		int len = s.length();
		String maxp = s.substring(0, 1);
	
    	boolean[][] lp = new boolean[len][len];
    	
    	// Initialize with one and two letter palindrome
    	for (int i = 0; i < len; i++) 
    	{ 
    		lp[i][i] = true;	// string of length 1
    		if (i < len - 1 && s.charAt(i) == s.charAt(i + 1)) // palindromic string of length 2
    		{ 
    			lp[i][i + 1] = true;
    			maxp = s.substring(i, i + 2);
    		}	
    	}
    	
    	// Finish the rest
    	for (int curlen = 3; curlen <= len; curlen++)
    	{    		
    		for (int head = 0; head < len - curlen + 1; head ++)
    		{
    			int tail = head + curlen - 1;
    			if (lp[head + 1][tail - 1] && s.charAt(head) == s.charAt(tail))
    			{
    				lp[head][tail] = true;
    				maxp = s.substring(head, tail + 1);
    			}
    		}
    	}
    	
    	return maxp;
    }
    
    
    // Method 3: Expand from center, 83%
    private static String longestPalindrome2(String s){
    	if(s == null || s.isEmpty())
    		return "";
    	
    	int len = s.length();
    	int start = 0, end = 0;
    	
    	for(int i = 0; i < len - 1; i++){
    		int len1 = expand(s, i, i);
    		int len2 = expand(s, i, i + 1);
    		
    		len1 = Math.max(len1, len2);
    		
    		if(len1 > end - start){
    			start = i - (len1 - 1)/2;
    			end = i + len1/2;
    		}
    	}
    	
    	return s.substring(start, end + 1);
    }
    
    // Longest palindrome with (l,r) as center
    private static int expand(String s, int l, int r){
    	int start = l, end = r;
    	while(0 <= start && end < s.length() && s.charAt(start) == s.charAt(end)){
    		start--;
    		end++;
    	}
    	
    	return end - start - 1;
    }
    
    
	public static void main(String args[]){
		String s = "aaaaaaaaaaabbbbb";					
		System.out.println(longestPalindrome1(s));
		return;
	}
}


