package Hard;

import java.util.*;

class Codec {
	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val,List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	}
	
    // Encodes a tree to a single string.
    private String serialize(Node root) {
    	if(root == null)
    		return "";    	    	    	
    	
        return serialize_traversal(root);
    }
    
    private String serialize_traversal(Node cur){
    	String res = "";
    	
    	if(cur == null)
    		res += "#";    	
    	else{
        	res += (String.valueOf(cur.val) + " " + String.valueOf(cur.children.size()) + " ");        	
        	for(Node c:cur.children){    		
        		res += serialize_traversal(c);
        	}
    	}
    	
    	return res;
    }

    int cur;
    // Decodes your encoded data to tree.
    private Node deserialize(String data) {
    	if(data == null || data.isEmpty())
    		return null;
    	String[] d = data.split(" ");
    	cur = 0;
    	Node root = deserialize_traversal(d);
        
    	return root;
    }
    
    private Node deserialize_traversal(String[] d){   	    	    	    	    	
    	if(d[cur].equals("#")){
    		cur++;
    		return null;
    	}    		
    	
    	int val = Integer.valueOf(d[cur++]);
    	int n_child = Integer.valueOf(d[cur++]);
    	
    	Node cur_node = new Node(val, new ArrayList<>());
    	List<Node> children = cur_node.children;
    	
    	for(int i = 0; i < n_child; i++){
    		children.add(deserialize_traversal(d));    		
    	}
    	
    	return cur_node;
    }
}


class SerializeandDeserializeNaryTree {
	
}
