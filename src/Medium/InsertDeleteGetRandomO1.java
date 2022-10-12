package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class InsertDeleteGetRandomO1 {
	class RandomizedSet {
		ArrayList<Integer> nums;
		Map<Integer, Integer> pos;
		Random r;
		
	    /** Initialize your data structure here. */
	    public RandomizedSet() {
	        nums = new ArrayList<>();
	        pos = new HashMap<>();
	        r = new Random();
	    }
	    
	    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	    public boolean insert(int val) {
	        if(pos.containsKey(val))
	        	return false;
	        	        
	        nums.add(val); 
	        pos.put(val, nums.size() - 1);
	        return true;
	    }
	    
	    /** Removes a value from the set. Returns true if the set contained the specified element. */
	    public boolean remove(int val) {
	        if(!pos.containsKey(val))
	        	return false;
	        
	        int i = pos.get(val);
	        int last_num = nums.get(nums.size() - 1);
	        
	        nums.set(i, last_num);
	        pos.put(last_num, i);
	        pos.remove(val);
	        nums.remove(nums.size() - 1);
	        
	        return true;
	    }
	    
	    /** Get a random element from the set. */
	    public int getRandom() {
	    	System.out.println(nums.size());
	        int pick = r.nextInt(nums.size());
	        return nums.get(pick);
	    }
	}
}
