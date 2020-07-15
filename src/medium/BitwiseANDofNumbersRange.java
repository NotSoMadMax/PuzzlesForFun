package medium;

// Only the common 1s from the left will remain
public class BitwiseANDofNumbersRange {

    // Method 1: Mask them out
    public int rangeBitwiseAnd(int m, int n) {
        int mask = Integer.MAX_VALUE;
        while ((m & mask) != (n & mask)) {  // the parts covered by 1s in mask are still not common
            mask <<= 1;    // move 1s to left
        }

        return m & mask;
    }

    //Method 2: cover the right part by moving right
    public int rangeBitwiseAnd2(int m, int n) {
        int count = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            count++;
        }

        return m << count;
    }
}
