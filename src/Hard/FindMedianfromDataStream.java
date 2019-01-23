package Hard;

import java.util.*;

class FindMedianfromDataStream {

    class MedianFinder {
        PriorityQueue<Integer> first;
        PriorityQueue<Integer> second;

        /** initialize your data structure here. */
        public MedianFinder() {
            this.first = new PriorityQueue<>(Collections.reverseOrder());
            this.second = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if(!first.isEmpty() && num < first.peek())
                first.add(num);
            else
                second.add(num);

            while (first.size() > second.size())
                second.add(first.poll());

            while (first.size() < second.size() - 1)
                first.add(second.poll());
        }

        public double findMedian() {
            if(first.size() == second.size())
                return (double)(first.peek() + second.peek())/2.0;
            else
                return (double)second.peek();
        }
    }

}
