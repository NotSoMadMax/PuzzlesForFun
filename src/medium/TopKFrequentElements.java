package medium;

import java.util.*;

class array_comparator implements Comparator<int []>{
    public int compare(int [] a, int [] b){
        if(a[1] > b[1]) // larger frequency comes first
            return -1;
        else if(a[1] < b[1])
            return 1;
        else
            return 0;
    }
}

public class TopKFrequentElements {
    private List<Integer> topKFrequent(int[] nums, int k) {
        if(nums == null || nums.length < 1)
            return Collections.emptyList();

        Map<Integer, Integer> frequency = new HashMap<>();  // num -> count
        for(int n:nums)
            frequency.put(n, frequency.getOrDefault(n, 0) + 1);

        PriorityQueue<int []> p = new PriorityQueue<>(new array_comparator());

        for(int n:frequency.keySet()){
            p.add(new int[]{n, frequency.get(n)});
        }

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < k; i++){
            if(p.isEmpty())
                break;
            res.add(p.poll()[0]);
        }

        return res;
    }
}
