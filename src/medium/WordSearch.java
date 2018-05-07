package medium;

public class WordSearch {
	
    private static boolean exist(char[][] board, String word) {
        if (word == null || word.length() < 1)
            return true;
        if (board == null || board.length < 1 || board[0].length < 1 || board.length * board[0].length < word.length())
            return false;
                
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for (int i = 0 ; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (search (i, j, 0, board, word.toCharArray(), visited))
                		return true;                                    
            }
        }
        
        return false;
    }
    
    private static boolean search(int r, int c, int cur, char[][] board, char[] word, boolean[][] visited){        
    		if (cur == word.length){           
            return true;
        }
        
        if (c < 0 || r < 0 || r >= board.length || c >= board[0].length)
            return false;
        
        if (board[r][c] != word[cur] || visited[r][c])
            return false;
                
        visited[r][c] = true;
        
        if (search(r, c - 1, cur + 1, board, word, visited))
        		return true;
                
        if (search(r, c + 1, cur + 1, board, word, visited))        
            return true;
        
        if(search(r + 1, c, cur + 1, board, word, visited))
            return true;           
        
        if (search(r - 1, c, cur + 1, board, word, visited))              
            return true;
        
        visited[r][c] = false;        
        return false;
    }
    
    public static void main(String[] args){
    		String s = "abccseedas";
    		char[][] board = { {'a','b','c','e'}, 
    							{'s','f','c','s'}, 
    							{'a','d','e','e'}};
    		
    		System.out.println(exist(board, s));
    }
}
