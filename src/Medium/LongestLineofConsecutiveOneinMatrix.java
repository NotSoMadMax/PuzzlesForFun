package medium;

public class LongestLineofConsecutiveOneinMatrix {
    private int longestLine(int[][] M) {
        if(M == null || M.length < 1)
            return 0;

        int row = M.length;
        int col = M[0].length;
        int[][] pre = new int[col][4]; // max in previous row in each of the 4 directions
        int res = 0;

        for(int i = 0; i < row; i++)
        {
            int[][] cur_row = new int[col][4];

            for(int j = 0; j < col; j++)
            {
                if(M[i][j] == 1)
                {
                    if(j > 0){
                        cur_row[j][0] = cur_row[j-1][0] + 1;
                        cur_row[j][1] = pre[j - 1][1] + 1;
                    }
                    else {
                        cur_row[j][0] = 1;
                        cur_row[j][1] = 1;
                    }

                    cur_row[j][2] = pre[j][2] + 1;

                    if(j < col - 1)
                        cur_row[j][3] = pre[j+1][3] + 1;

                    for(int dir = 0; dir < 4; dir++)
                        res = Math.max(res, cur_row[j][dir]);
                }
            }

            pre = cur_row;
        }

        return res;
    }
}
