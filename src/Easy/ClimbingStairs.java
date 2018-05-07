package Easy;

public class ClimbingStairs {
   
	public int climbStairs(int n) {
	     if (n < 1)
	       return 0;
	       if (n == 1)
	           return 1;
	       
	       int pre = 1;
	       int cur = 2;
	       int temp;
	       for (int i = 2; i < n; i++){
	    	   		temp = pre;
	    	   		pre = cur;
	    	   		cur = temp + pre;
	       }
	       
	       return cur;
	}
	
	
	
	// slow
//	public int climbStairs(int n) {
//        if (n < 1)
//            return 0;
//        if (n == 1)
//            return 1;
//        
//        int[] memo = new int[n];
//        memo[0] = 1;
//        memo[1] = 2;
//        for (int i = 2; i < n; i++){
//            memo[i] = memo[i - 1] + memo[i - 2];
//        }
//        
//        return memo[n - 1];
//    }
	
	
	// slow
//	private int recur(int n){
//        if (n < 1)
//            return 0;
//        if (n == 1)
//            return 1;
//        if (n == 2)
//            return 2;
//        
//        return climbStairs(n - 1) + climbStairs(n - 2);		
//	}
}
