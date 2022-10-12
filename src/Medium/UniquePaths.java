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

    // 2020
    // DP
    public int uniquePaths1(int m, int n) {
        int[][] paths = new int[m][n];
        paths[0][0] = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0)
                    continue;
                int top = i == 0 ? 0 : paths[i - 1][j];
                int left = j == 0 ? 0 : paths[i][j - 1];
                paths[i][j] = top + left;
            }
        }
        return paths[m - 1][n - 1];
    }
}
