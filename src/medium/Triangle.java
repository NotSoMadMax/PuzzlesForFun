package medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Triangle {
    private static int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0)
        	return 0;
        
        int len = triangle.size();
        int[][] results = new int[len][len];
        for (int i = 0; i < len; i++){
        	results[len-1][i] = triangle.get(len-1).get(i);
        }
        
        for (int i = len - 2; i >= 0; i--){
        	for (int j = 0; j < i + 1; j++){
        		results[i][j] = triangle.get(i).get(j) + Math.min(results[i+1][j], results[i+1][j+1]);
        	}
        }
        
        return results[0][0];
    }
    
}




