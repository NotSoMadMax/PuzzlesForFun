package Easy;

class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }

        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;

        for (int n : nums) {
            if (n > first) {
                third = second;
                second = first;
                first = n;
            } else if (n < first && n > second) {
                third = second;
                second = n;
            } else if (n < second && n > third) {
                third = n;
            }
        }

        return third == Long.MIN_VALUE ? (int) first : (int) third;
    }	
}