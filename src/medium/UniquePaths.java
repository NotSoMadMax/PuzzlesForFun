package medium;

public class UniquePaths {
	// overflow when number is large
    public static int uniquePaths(int m, int n) {
        if (m < 1 || n < 1)
        		return 0;
        if (m == 1 || n == 1)
        		return 1;
        
        int totalSteps = m + n - 2;
        int k = n - 1;
        
        double a = 1;
        double b = 1;
        for (int i = 0; i < n - 1; i++){
	        	a *= totalSteps--;
	        	b *= k--;
        }        		     		        
        	double ans = a / b;	        	
        	// loose precision when number is large
        return (int) Math.round(ans);	
    }
    
    public static void main(String[] args){
    		
    		System.out.println(uniquePaths(10,34));
    		
    }
}
