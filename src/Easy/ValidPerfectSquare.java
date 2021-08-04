package Easy;

public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if(num == 1)
            return true;

        long left = 1;
        long right = num;
        // If exist, the root must be between 1 and num
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;
            if(square < num) {
                left = mid + 1;
            } else if (square > num) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
