package Easy;

import java.util.*;

class minStack {

    // Method 1: using two stacks
    class MinStack1 {
        Stack<Integer> nums;
        Stack<Integer> mins;

        /** initialize your data structure here. */
        public MinStack1() {
            nums = new Stack<>();
            mins = new Stack<>();
        }

        public void push(int x) {
            nums.push(x);
            if(mins.isEmpty())
                mins.push(x);
            else if(x <= mins.peek())
                mins.push(x);
        }

        public void pop() {
            int x = nums.pop();
            if(mins.peek() == x)
                mins.pop();
        }

        public int top() {
            return nums.peek();
        }

        public int getMin() {
            return mins.peek();
        }
    }

    // Method 2: one stack
    class MinStack2 {
        Stack<Integer> nums;
        int min_val;

        /** initialize your data structure here. */
        public MinStack2() {
            nums = new Stack<>();
            min_val = Integer.MAX_VALUE;
        }

        public void push(int x) {
            if(x <= min_val){
                nums.push(min_val); // remember the previous min_val
                min_val = x;
            }

            nums.push(x);
        }

        public void pop() {
            int x = nums.pop();
            if(x == min_val)
                min_val = nums.pop();   // the previous min
        }

        public int top() {
            return nums.peek();
        }

        public int getMin() {
            return min_val;
        }
    }
}
