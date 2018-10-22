package medium;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(s == null || s.length() < 1 || numRows < 2)
        	return s;
        
        StringBuilder sb = new StringBuilder();
        char[] sa = s.toCharArray();
        int gap = 2*numRows - 2;
        
        for(int i = 0; i < numRows; i++){
        	for(int j = i; j < s.length(); j += gap){
        		sb.append(sa[j]);
        		
        		if(i != 0 && i != numRows - 1){	// if not first or last line, there's elements in between periods
        			int pos = j + 2*(numRows - i - 1);
        			if(pos < s.length())
        				sb.append(sa[pos]);
        		}
        		
        	}
        }
        
    	return sb.toString();
    }
}
