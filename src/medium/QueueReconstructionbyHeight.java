package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructionbyHeight {
    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length < 1)
        	return people;
        
        Arrays.sort(people, (a,b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);
        
        List<int[]> res = new LinkedList<int[]>();
        
        for(int[] person : people) {
        	res.add(person[1], person);	// push the existing one to the right. Current one is short, so it has no impact after pushing the current one
        }
        
        return res.stream().toArray(int[][] ::new);
    }
}
