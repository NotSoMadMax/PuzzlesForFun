package medium;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int len = board.length;
        if (len < 1 || board == null)	return;
        
        int[][] temp = new int[board.length][];
        for (int i = 0; i < board.length; i++)
        		temp[i] = board[i].clone();
        
        for (int i = 0; i < len; i++){
        		for (int j = 0; j < board[0].length; j++){        			
        				board[i][j] = check(i, j, temp);
        		}
        }
        
        return;
    }
    
    private static int check(int r, int c, int[][] board){
    		int count_live = 0;
    		int numr = board.length;
    		int numc = board[0].length;
    		
    		for (int i = r - 1; i < r + 2; i++){
    			if (i < 0 || i > numr - 1)
    				continue;
    			for (int j = c - 1; j < c + 2; j++){
    				if (j < 0 || j > numc - 1)
    					continue;
                if (i == r && j == c)
                    continue;
    				if (board[i][j] == 1)
    					count_live++;
    			}
    		}
    		
    		if (board[r][c] == 1)    			
    			return (count_live == 2 || count_live == 3)?1:0;    			
    		 else
    			return count_live == 3?1:0;
    }
}
