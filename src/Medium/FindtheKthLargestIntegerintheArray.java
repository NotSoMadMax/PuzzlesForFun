class Solution {
    // Method 1: priority queue, time 12.53%, space 63.42%
    public String kthLargestNumber1(String[] nums, int k) {
        PriorityQueue<String> queue = new PriorityQueue<>(new StringNumberComparator());
        for(String n : nums){
            queue.add(n);
            if(queue.size() > k){
                queue.poll();
            }
        }
        return queue.peek();
    }

    // Method 2: sort, time 81.27%, space 82.01%
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, new StringNumberComparator());
        
        return nums[nums.length - k];
    }
    
    class StringNumberComparator implements Comparator<String> {
        @Override
        public int compare(String x, String y) {
            if(x.length() < y.length()) {
                return -1;
            } else if (x.length() > y.length()) {
                return 1;
            } else {
                for(int i = 0; i < x.length(); i++) {
                    if (x.charAt(i) == y.charAt(i)) {
                        continue;
                    }
                    return x.charAt(i) - y.charAt(i);
                }
            }
            return 0;
        }
    }
}