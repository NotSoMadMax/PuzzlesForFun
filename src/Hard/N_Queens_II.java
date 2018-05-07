package Hard;

public class N_Queens_II {
	// 59%
    private static int totalNQueens(int n) {
        if (n <= 1)
        		return n;
        
        int total = 0;
        int[] location = new int[n];
        for (int i = 0; i < n; i++)
        		location[i] = -1;
        
        total = search(n, location, 0);
        return total;
    }
    
    private static int search(int n, int[] location, int cur){
    		if(cur == n){    			    			
    			return 1;
    		}
    		
    		int total = 0;
    		for (int col = 0; col < n; col++){
    			if (!check(n, location, cur, col))
    				continue;
    			
    			location[cur] = col;
    			total += search(n, location, cur + 1);
    			location[cur] = -1;
    		}
    		
    		return total;
    }
    
    private static boolean check(int n, int[] location, int r, int c){
    		for (int i = 0; i < r; i++){
    			if (location[i] == c)
    				return false;
    			if (Math.abs(i - r) == Math.abs(location[i] - c))
    				return false;
    		}
    		
    		return true;
    }
    
    public static void  main(String[] args) {
		System.out.println(totalNQueens(5));
	}
}




