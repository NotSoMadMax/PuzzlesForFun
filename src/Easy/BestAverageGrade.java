package Easy;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BestAverageGrade {

    static int bestAverageGrade(String[][] scores) {
    		int len = scores.length;
    		if (len < 1 || scores == null) return 0;
    		
    		Map<String, Integer> record = new HashMap<>();
    		Map<String, Integer> count = new HashMap<>();
    		for (String[] cur:scores){
    			String name = cur[0];
    			int grade = Integer.parseInt(cur[1]);
    			if (record.containsKey(name)){
    				record.put(name, record.get(name) + grade);
    				count.put(name, count.get(name) + 1);
    			}    				
    			else{
    				record.put(name, grade);
    				count.put(name, 1);
    			}    				
    		}
    		
    		for (String student:record.keySet()){
    			double total_grade = record.get(student); 
    			record.put(student, (int) Math.floor(total_grade/count.get(student)));
    		}
    		
    		Collection<Integer> c = record.values();
        Object[] obj = c.toArray();
        Arrays.sort(obj);
    		
        return (int) obj[obj.length - 1];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
