package Hard;

import java.util.*;

class WordSearchII {
	class TrieNode{
		TrieNode[] child;
		String word;
		
		public TrieNode(){
			this.child = new TrieNode[26];
			word = "";
		}
	}
	
	TrieNode root;
	
	private void insert(String word){
		TrieNode cur = root;
		
		for(int i = 0; i < word.length(); i++){
			int index = word.charAt(i) - 'a';
			if(cur.child[index] == null)
				cur.child[index] = new TrieNode();
			cur = cur.child[index];
		}
		
		cur.word = word;
	}	
	
    private List<String> findWords(char[][] board, String[] words) {
        int row = board.length, col = board[0].length;
        
        root = new TrieNode();
        for(String s:words)
        	insert(s);
        
        List<String> res = new ArrayList<>();
        for(int i = 0; i < row; i++)
        {
        	for(int j = 0; j < col; j++)
        	{
        		boolean[][] visited = new boolean[row][col];
        		if(root.child[board[i][j] - 'a'] != null){
        			TrieNode cur = root;
        			search(i, j, cur.child[board[i][j] - 'a'], board, visited, res);
        		}        			
        	}
        }
        
        return res;
    }    
    
    
    int[] row_change = {0, -1, 0, 1};
    int[] col_change = {-1, 0, 1, 0};
    private void search(int r, int c, TrieNode cur, char[][] board, boolean[][] visited, List<String> res){
    	if(!cur.word.isEmpty()){
    		res.add(cur.word);
    		cur.word = "";	// so this word will only be added onece
    	}
    	
    	visited[r][c] = true;
    	for(int i = 0; i < 4; i++){
    		int row = r + row_change[i];
    		int col = c + col_change[i];
    		
    		if(row < 0 || row >= board.length || col < 0 || col >= board[0].length)
    			continue;
    		
    		if(visited[row][col])
    			continue;
    		
    		if(cur.child[board[row][col] - 'a'] != null)    			
    			search(row, col, cur.child[board[row][col] - 'a'], board, visited, res);
    			    		
    	}
    	visited[r][c] = false;
    	return;
    }
}










