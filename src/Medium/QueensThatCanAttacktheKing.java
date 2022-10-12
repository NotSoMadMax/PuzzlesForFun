package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QueensThatCanAttacktheKing {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        if (king == null || king.length < 1) {
            return Collections.emptyList();
        }

        boolean[][] hasQueen = new boolean[8][8];
        for (int[] pos: queens) {
            hasQueen[pos[0]][pos[1]] = true;
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                int row = king[0] + i;
                int col = king[1] + j;
                while (row >= 0 && row < 8 && col >= 0 && col < 8) {
                    if (hasQueen[row][col]) {   // find the first queen in this direction
                        res.add(Arrays.asList(row, col));
                        break;
                    }
                    row += i;
                    col += j;
                }
            }
        }

        return res;
    }
}
