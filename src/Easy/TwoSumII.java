package Easy;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int front = 0;
        int end = numbers.length - 1;

        while(front < end) {
        	int sum = numbers[front] + numbers[end];
        	if(sum < target) {
        		front++;
        	} else if (sum > target) {
        		end--;
        	} else {
        		int[] result = new int[]{front + 1, end + 1};
        		return result;
        	}
        }

        return null;
    }
}