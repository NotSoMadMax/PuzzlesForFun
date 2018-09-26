package medium;

class CountNumberswithUniqueDigits {
    private int countNumbersWithUniqueDigits(int n) {
        if (n < 1)
            return 1;
        if (n == 1)
            return 10;

        int prev = 9, result = 10;
        for(int i = 1; i < n; i++){
            prev *= 9 - i + 1;
            result += prev;
        }

        return result;
    }
}
