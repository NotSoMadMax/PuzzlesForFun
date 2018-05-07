package Easy;

public class Sqrt {
    private int mySqrt(int x) {
        if (x <= 1)
            return x;
        
        int l = 0, h = x;
        int cur = 0;
        while (l < h){
        		cur = l + (h - l)>>1;
        		if (x / cur >= cur)
        			l = cur + 1;
        		else
        			h = cur;        		
        }
    		
        return h - 1;
    }
    
    public static void main(String[] args){
    		
    		
    }
}
