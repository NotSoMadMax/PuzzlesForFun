package Easy;

class Solution {
    private static String longestCommonPrefix(String[] strs) {
        int len = strs.length;
    	if (len == 0)
            return "";
        if (len == 1)
        	return strs[0];
        
        int max_len = strs[0].length();
        for (int i = 1; i < len; i++){
            if (strs[i].length() < max_len)
            	max_len = strs[i].length();               
        }
        System.out.println("max_len: " + max_len);
        
        int index = -1;
        boolean flag = true;

        for (int i = 0; i < max_len && flag; i++){ //for each char
            char c = strs[0].charAt(i);

            for (int j = 1; j < len; j++){  // for each string, check this char
                if (strs[j].charAt(i) != c){
                    if (i == 0)
                        return "";
                    flag = false;
                    break;
                }
            }
            if (flag)
            	index = i;
        }

        if (index == -1)
            return "";
        return strs[0].substring(0, index + 1);
    }

    public static void main(String args[]){
        String[] strs = {"aa", "ab"};
        System.out.println(longestCommonPrefix(strs));
    }
}
