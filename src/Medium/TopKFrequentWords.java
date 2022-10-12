package medium;

import java.util.*;

class TopKFrequentWords {
	Map<String, Integer> count;
	
	class WordCompare implements Comparator<String>{
		public int compare(String a, String b){
			int diff = count.get(a) - count.get(b);
			if(diff < 0 )
				return -1;
			else if(diff > 0)
				return 1;
			else
				return -a.compareTo(b);
		}
	}
	
    private List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<String> p = new PriorityQueue<>(new WordCompare());
        count = new HashMap<>();
        
        for(String w:words)
        	count.put(w, count.getOrDefault(w, 0) + 1);       
        
        for(String s:count.keySet()){
        	p.add(s);
        	
        	if(p.size() > k)
        		p.poll();
        }
        
        List<String> res = new ArrayList<>();
        while(!p.isEmpty()){
        	res.add(p.poll());
        }
        Collections.reverse(res);
        
        return res;
    }
}











