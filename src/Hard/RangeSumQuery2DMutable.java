package Hard;

// Method 1: Binary Indexed Tree
class NumMatrix {
    int[][] BITree;
    int rown, coln;
    int[][] nums;   // store the original matrix

    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length < 1 || matrix[0] == null || matrix[0].length < 1)
            return;

        this.rown = matrix.length + 1;
        this.coln = matrix[0].length + 1;
        BITree = new int[rown][coln];
        nums = new int[rown][coln];

        for(int i = 0; i < rown - 1; i++){
            for(int j = 0; j < coln - 1; j++){
                update(i, j, matrix[i][j]);
            }
        }
    }

    public void update(int row, int col, int val) {
        row++;
        col++;

        int offset = val - nums[row][col];
        for(int i = row; i < rown; i += i&(-i)){    // add 1 to right-most 1
            for(int j = col; j < coln; j += j&(-j))
                BITree[i][j] += offset;
        }
        nums[row][col] = val;
    }

    public int getSum(int row, int col){
        row++;
        col++;

        int res = 0;
        for(int i = row; i > 0; i -= i&(-i)){
            for(int j = col; j > 0; j -= j&(-j))    // remove right-most 1
                res += BITree[i][j];
        }

        return res;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return getSum(row2, col2) - getSum(row1 - 1, col2) - getSum(row2, col1 - 1) + getSum(row1 - 1, col1 - 1);
    }
}


// Method 2: column prefix sum
public class RangeSumQuery2DMutable {
    int[][] colSum;
    int[][] nums;
    int rown, coln;

    public RangeSumQuery2DMutable(int[][] matrix) {
        if(matrix == null || matrix.length < 1 || matrix[0] == null || matrix[0].length < 1)
            return;

        rown = matrix.length;
        coln = matrix[0].length;
        this.colSum = new int[rown][coln];
        this.nums = new int[rown][coln];

        for(int j = 0; j < coln; j++)
        {
            colSum[0][j] = matrix[0][j];
            nums[0][j] = matrix[0][j];
            for(int i = 1; i < rown; i++){
                colSum[i][j] = colSum[i-1][j] + matrix[i][j];
                nums[i][j] = matrix[i][j];
            }
        }
    }

    public void update(int row, int col, int val) {
        int offset = val - nums[row][col];

        for(int i = row; i < rown; i++){
            colSum[i][col] += offset;
        }

        nums[row][col] = val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2){
        int res = 0;

        for(int j = col1; j <= col2; j++){
            res += colSum[row2][j] - colSum[row1][j] + nums[row1][j];
        }

        return res;
    }
}
