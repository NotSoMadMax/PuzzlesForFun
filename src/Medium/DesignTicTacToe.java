package medium;

class DesignTicTacToe {

    // Method 1: Naive Approach
    class TicTacToe1 {

        int[][] grid;
        int size;
        /** Initialize your data structure here. */
        public TicTacToe1(int n) {
            this.grid = new int[n][n];
            this.size = n;
        }

        /** Player {player} makes a move at ({row}, {col}).
         @param row The row of the board.
         @param col The column of the board.
         @param player The player, can be either 1 or 2.
         @return The current winning condition, can be either:
         0: No one wins.
         1: Player 1 wins.
         2: Player 2 wins. */
        public int move(int row, int col, int player) {
            grid[row][col] = player;

            // check row
            int c = 0;
            while (c < size && grid[row][c] == player)
                c++;
            if(c == size)
                return player;

            // check col
            int r = 0;
            while (r < size && grid[r][col] == player)
                r++;
            if(r == size)
                return player;

            // check diagonal 0,0 -> n,n
            if(row == col){
                int i = 0;
                while (i < size && grid[i][i] == player)
                    i++;
                if(i == size)
                    return player;
            }

            // check diagonal n,0 -> 0,n
            if(row == size - 1 - col){
                int i = 0;
                while (i < size && grid[i][size - 1 - i] == player)
                    i++;
                if(i == size)
                    return player;
            }

            return 0;
        }
    }

    // Method 2: Counting row and col
    class TicTacToe2 {
        int[] row_count;
        int[] col_count;
        int diag1;
        int diag2;

        int[] score = new int[]{0, -1, 1};
        int size;

        public TicTacToe2(int n) {
            this.row_count = new int[n];
            this.col_count = new int[n];
            this.diag1 = 0;
            this.diag2 = 0;
            this.size = n;
        }

        public int move(int row, int col, int player) {
            row_count[row] += score[player];
            col_count[col] += score[player];

            if(row == col)
                diag1 += score[player];

            if(row == size - 1 - col)
                diag2 += score[player];

            if(Math.abs(row_count[row]) == size || Math.abs(col_count[col]) == size ||
                Math.abs(diag1) == size || Math.abs(diag2) == size)
                return player;

            return 0;
        }

    }

}












