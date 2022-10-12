package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PermutationSequence {
	
	
    private static String getPermutation(int n, int k) {
        if (k < 1)
        		return "";
        char[] ans = new char[n];
        List<Character> s =  new ArrayList<>();
        for (int i = 0; i < n; i++){
        		s.add((char) (49 + i));
        }     
        
        int[] p = new int[n];	// permutations results
        p[0] = 1;
        for (int i = 1; i < n; i++)
        		p[i] = p[i - 1]*i;        
        
        k--;
        for (int i = n; i >= 1; i--){
        		int cycle = k / p[i - 1];	// this digit the cycle'th number in the left numbers
        		k = k % p[i - 1];
        		ans[n - i] = s.get(cycle);
        		s.remove(cycle);
        }
        
        return new String(ans);
    }
    
    private static String iterative_permutation(int n, int k){
    		int count = 0;
    		
        int[] p = new int[n];	// permutations results
        p[0] = 1;
        for (int i = 1; i < n; i++)
        		p[i] = p[i - 1]*i; 
    		
    		int i = 0;
    		while (i < n){
    			Stack<Character> num = new Stack<>();
        		for (int j = n - 1; j >= 0; j--)
        			num.push((char) (49 + j));        		
        		
    			Stack<Character> c = new Stack<>();
    			c.push(num.pop());
    			
    			for (int j = 0; j < p[n -1]; j++){
    				
        			while (c.size() < n){
        				c.push(num.pop());
        			}
        			
    			}
    			    			
    		}
    		
    		return "";
    }
    
    public static void main(String[] args){
    		System.out.println(getPermutation(4, 2));    		
    		return;
    }
}





