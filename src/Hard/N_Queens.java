package Hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class N_Queens{
	
	// 69%
    private static List<List<String>> solveNQueens(int n) {
            if (n < 1)
                return Collections.emptyList();
            
            List<List<String>> res = new ArrayList<>();
            int[] location = new int[n];
            for(int i = 0; i < n; i++){
            		location[i] = -1;
            }
            
            search(n, 0, location, res);
            return res;
    }

    private static void search(int n, int cur, int[] location, List<List<String>> res){
    		if (cur == n){
    			constructAns(n, location, res);
    			return;
    		}
    		
    		for (int col = 0; col < n; col++){
    			if (!check(n, cur, col, location))
    				continue;
    			
    			location[cur] = col;    			
    			search(n, cur + 1, location, res);
    			location[cur] = -1;
    		}
    		
    		return;
    }

    private static boolean check(int n, int r, int c, int[] location){
    	
    		for (int i = 0; i < r; i++){	
    			
    			if (location[i] == c) 	// check column
    				return false;
    			
    			if (Math.abs(i - r) == Math.abs(location[i] - c))	    // check diagonal
    				return false;
    		}    		    		
    		return true;
    }
    
    private static void constructAns(Integer n, int[] location, List<List<String>> res){
    		List<String> ans = new ArrayList<>();
    		for (int i = 0; i < n; i++){
    			StringBuffer sb = new StringBuffer();
    			for (int j = 0; j < n ; j++){	// construct the i-th row
    				if (j == location[i])
    					sb.append('Q');
    				else 
					sb.append('.');	
    			}
    			ans.add(sb.toString());
    		}        		
    		res.add(ans);
    		return;
    }
        
    public static void main(String[] args) {
    		int N = 4;
    		List<List<String>> sol = solveNQueens(N);
    		for (List<String> ans:sol){
    			for (String row:ans)
    				System.out.println(row);
    			
    			System.out.println("-------------------------------\n");
    		}
    		
    		return;
    }
}
