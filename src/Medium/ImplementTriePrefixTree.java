package medium;

class ImplementTriePrefixTree {
	class TrieNode{
		TrieNode[] child;
		boolean endOfWord;
		
		public TrieNode() {
			this.child = new TrieNode[26];
			this.endOfWord = false;			
		}
	}
	
	
	class Trie {
		TrieNode root;
		
	    /** Initialize your data structure here. */
	    public Trie() {
	        root = new TrieNode();
	    }
	    
	    /** Inserts a word into the trie. */
	    public void insert(String word) {
	        TrieNode cur = root;
	        
	        for(int i = 0; i < word.length(); i++){
	        	int index = word.charAt(i) - 'a';
	        	
	        	if(cur.child[index] == null)
	        		cur.child[index] = new TrieNode();
	        	
	        	cur = cur.child[index];
	        }
	        
	        cur.endOfWord = true;
	    }
	    
	    /** Returns if the word is in the trie. */
	    public boolean search(String word) {
	        TrieNode cur = root;
	        
	        for(int i = 0; i < word.length(); i++){
	        	int index = word.charAt(i) - 'a';
	        	
	        	if(cur.child[index] == null)
	        		return false;
	        	
	        	cur = cur.child[index];
	        }
	        
	        if(cur.endOfWord)
	        	return true;
	        
	        return false;
	    }
	    
	    /** Returns if there is any word in the trie that starts with the given prefix. */
	    public boolean startsWith(String prefix) {
	        TrieNode cur = root;
	        
	        for(int i = 0; i < prefix.length(); i++){
	        	int index = prefix.charAt(i) - 'a';
	        	
	        	if(cur.child[index] == null)
	        		return false;
	        	
	        	cur = cur.child[index];
	        }
	        
	        return true;
	    }
	}
}










