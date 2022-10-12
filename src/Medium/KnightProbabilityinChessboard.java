package medium;

import java.util.Arrays;

class KnightProbabilityinChessboard {		
	
	// Method 1: DP
    private double knightProbability(int N, int K, int r, int c) {
    	
    	int[][] jump = {{-1,-2},{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2}};
    	double[][] dp = new double[N][N];	// probability in previous step
    	dp[r][c] = 1;
    	
    	for(int step = 0; step < K; step++)
    	{
    		double[][] cur_step = new double[N][N];
    		for(int i = 0; i < N; i++)
    		{
    			for(int j = 0; j < N; j++)
    			{
    				for(int d = 0; d < 8; d++){
    					int x = i + jump[d][0];
    					int y = j + jump[d][1];
    					
    					if(x < 0 || x >= N || y < 0 || y >= N)
    						continue;
    					
    					cur_step[x][y] += dp[i][j]*0.125;	// jump from (i,j) to (x,y)
    				}
    			}
    		}
    		
    		dp = cur_step;
    	}
    	
    	double total = 0.0;
    	for(double[] row:dp)
    		for(double p:row)
    			total += p;
    	
    	return total;
    }
}
