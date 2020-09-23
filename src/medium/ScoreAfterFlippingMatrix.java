package medium;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ScoreAfterFlippingMatrix {
    public int matrixScore(int[][] A) {
        for (int row = 0; row < A.length; row++) {    // first digit should all be 1
            if (A[row][0] != 1) {
                toggleRow(A, row);
            }
        }

        for (int col = 1; col < A[0].length; col++) {
            int oneCount = countColOnes(A, col);
            if (oneCount <= A.length / 2) {
                toggleCol(A, col);
            }
        }

        int res = 0;
        for (int row = 0; row < A.length; row++) {
            res += calculateRow(A, row);
        }
        return res;
    }

    private void toggleRow(int[][] a, int row) {
        for (int col = 0; col < a[row].length; col++) {
            a[row][col] = a[row][col] == 1 ? 0 : 1;
        }
    }

    private void toggleCol(int[][] a, int col) {
        for (int row = 0; row < a.length; row++) {
            a[row][col] = a[row][col] == 1 ? 0 : 1;
        }
    }

    private int countColOnes(int[][] a, int col) {
        return Arrays.stream(a).mapToInt(ints -> ints[col]).sum();
    }

    private int calculateRow(int[][] a, int row) {
        int res = 0;
        for (int col = 0; col < a[row].length; col++) {
            res += a[row][a[row].length - 1 - col] * Math.pow(2, col);
        }
        return res;
    }
}
