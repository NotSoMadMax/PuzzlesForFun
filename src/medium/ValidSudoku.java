package medium;

import java.util.Arrays;

public class ValidSudoku {

	private boolean isValidSudoku(char[][] board) {
        boolean[] test = new boolean[9];        
        
        // check row
        for (int r = 0; r < 9; r++){
        		Arrays.fill(test, true);
        		for (int c = 0; c < 9; c++){
        			if (board[r][c] == '.')
        				continue;        			
        			if (!test[Character.getNumericValue(board[r][c]) - 1])
        				return false;
        			test[Character.getNumericValue(board[r][c]) - 1] = false;
        		}
        }
        
        //	check col
        for (int c = 0; c < 9; c++){
        		Arrays.fill(test, true);
        		for (int r = 0; r < 9; r++){
        			if (board[r][c] == '.')
        				continue;        			
        			if (!test[Character.getNumericValue(board[r][c]) - 1])
        				return false;
        			test[Character.getNumericValue(board[r][c]) - 1] = false;
        		}
        }
        
        // check sub-board
        for (int x = 1; x < 9; x += 3){
        		for (int y = 1; y < 9; y += 3){
        			Arrays.fill(test, true);
        			for (int r = - 1; r < 2; r++){
        				for (int c = -1; c < 2; c++){
                			if (board[x + r][y + c] == '.')
                				continue;        			
                			if (!test[Character.getNumericValue(board[x + r][y + c]) - 1])
                				return false;
                			test[Character.getNumericValue(board[x + r][y + c]) - 1] = false;
        				}
        			}        			
        		}
        }
        
        return true;
    }
	
	public static void main(String[] args) {
		return;
	}

}
