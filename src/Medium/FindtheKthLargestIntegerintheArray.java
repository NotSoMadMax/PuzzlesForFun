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
    public String kthLargestNumber2(String[] nums, int k) {
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

    // Method 3: quick sort divide and conquer, time limit exceeded
    public String kthLargestNumber2(String[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        Comparator<String> comp = new StringNumberComparator();
        while(true) {
            int pivot = partition(nums, left, right, comp);
            if(pivot < nums.length - k) {
                left = pivot + 1;
            } else if(pivot > nums.length - k) {
                right = pivot - 1;
            } else {
                return nums[pivot];
            }
        }
    }

    private int partition(String[] nums, int left, int right, Comparator<String> comp) {
        String pivot = nums[left];
        int l = left + 1;
        int r = right;
        while(l <= r) {
            if(comp.compare(pivot, nums[l]) < 0 && comp.compare(nums[r], pivot) < 0) {
                swap(nums, l++, r--);
            }
            if (!(comp.compare(nums[l], pivot) > 0)){
                l++;
            }
            if (!(comp.compare(nums[r], pivot) < 0)){
                r--;
            }
        }
        swap(nums, left, r);
        return r;
    }

    private void swap(String[] nums, int i, int j) {
        String temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return;
    }
    
}