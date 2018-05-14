package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GrayCode {
	
    private static List<Integer> grayCode(int n) {
        if (n < 0)
        	return Collections.emptyList();
        
        List<Integer> res = new ArrayList<>();
        res.add(0);
        
        for(int i = n - 1; i >= 0; i--) {
        	int adder = 1<<(n - 1 - i);
        	for(int j = res.size() - 1; j >= 0; j--) {
        		int cur = res.get(j) + adder;
        		System.out.println(cur);
        		res.add(cur);
        	}
        }
        
        return res;
    }
    
    public static void main(String args[]) {
    	grayCode(3);
    }
}
