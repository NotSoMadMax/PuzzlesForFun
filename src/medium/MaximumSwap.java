package medium;

public class MaximumSwap {

    // Try to move max number on the left to as far right as it can go
    public int maximumSwap(int num) {
        char[] digits = String.valueOf(num).toCharArray();

        int max_index = digits.length - 1;
        int left_to_swap = -1;
        int right_to_swap = -1;
        for (int i = max_index - 1; i >= 0; i--) {
            if (digits[i] > digits[max_index]) {
                max_index = i;
            } else if (digits[i] < digits[max_index]){
                left_to_swap = i;
                right_to_swap = max_index;
            }
        }
        if (left_to_swap == -1) {
            return num;
        }

        char temp = digits[left_to_swap];
        digits[left_to_swap] = digits[right_to_swap];
        digits[right_to_swap] = temp;

        return Integer.parseInt(String.valueOf(digits));
    }
}
