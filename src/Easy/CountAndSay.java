package Easy;

public class CountAndSay {
    static public String countAndSay(int n) {
        if (n == 0)	return "";
        if (n == 1)	return "1";
        
        StringBuffer sb = new StringBuffer();
        int duplicate = 1;
        String result = "1";        
        
        for (int i = 1; i < n; i++){
        		int cur_len = result.length();        		
        		sb.setLength(0);
        		duplicate = 1;
        		
        		for (int j = 1; j < cur_len; j++){
        			if (result.charAt(j) == result.charAt(j - 1))
        				duplicate++;
        			else {
					sb.append(duplicate);
					sb.append(result.charAt(j - 1));
					duplicate = 1;
				}
        		}
        		sb.append(duplicate);
        		sb.append(result.charAt(cur_len - 1));
        		result = sb.toString();
        }
        
        return result;
    }
    
   public static void main(String[] args){
	   System.out.println(countAndSay(4));
	   return;
   }
}
