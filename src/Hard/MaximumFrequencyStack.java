package Hard;

import java.util.*;

class MaximumFrequencyStack {

    class FreqStack {

        Map<Integer, Integer> freq; // num -> frequency
        TreeMap<Integer, Stack<Integer>> nums;   // frequency -> nums

        public FreqStack() {
            this.freq = new HashMap<>();
            this.nums = new TreeMap<>();
        }

        public void push(int x) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
            int cur_freq = freq.get(x);

            nums.putIfAbsent(cur_freq, new Stack<>());
            nums.get(cur_freq).push(x);
        }

        public int pop() {
            int res = nums.lastEntry().getValue().pop();
            freq.put(res, freq.get(res) - 1);

            if(nums.lastEntry().getValue().isEmpty())
                nums.remove(nums.lastKey());

            return res;
        }
    }

}
