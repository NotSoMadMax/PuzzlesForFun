package medium;

import java.util.LinkedList;

class UbglyNumberII {
    private int nthUglyNumber(int n) {
        if (n < 1)
            return 0;

        if (n == 1)
            return 1;

        LinkedList<Integer> numbers = new LinkedList<Integer>();
        numbers.add(1);
        int l2, l3, l5;
        l2 = 0;
        l3 = 0;
        l5 = 0;
        for(int i = 2; i <= n; i++){
            int next_ugly = Math.min(Math.min(numbers.get(l2)*2, numbers.get(l3)*3), numbers.get(l5)*5);
            if(next_ugly == numbers.get(l2)*2)
                l2++;
            if(next_ugly == numbers.get(l3)*3)
                l3++;
            if(next_ugly == numbers.get(l5)*5)
                l5++;
            numbers.add(next_ugly);
        }

        return numbers.peekLast();
    }
}
