package medium;

class SurroundedRegions {

    /* union find method:
        Create one extra node
        union all O on edge with this node
        For all O:
            if not connected with this node:
                flip to X

     */


    private void solve(char[][] board) {
        if(board == null || board.length < 1 || board[0].length < 1)
            return;

        int row = board.length;
        int col = board[0].length;

        // scan all edges
        for(int i = 0; i < row; i++){
            if(i == 0 || i == row - 1){ // first and last row
                for(int j = 0; j < col; j++){
                    if(board[i][j] == 'O')
                        dfs(board, i, j);
                }
            } else {
                if(board[i][0] == 'O')
                    dfs(board, i, 0);
                if(board[i][col - 1] == 'O')
                    dfs(board, i, col - 1);
            }
        }

        // scan all element
        for(int i = 0; i < row; i ++){
            for(int j = 0; j < col; j ++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }

        // change 'T' back to 'O'
        for(int i = 0; i < row; i ++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == 'T')
                    board[i][j] = 'O';
            }
        }

    }

    // dfs for 'O' on the edge
    private void dfs(char[][] board, int i, int j){
        if(board[i][j] == 'O'){
            board[i][j]  = 'T';     // temporarelly labeled

            if(i + 1 < board.length && board[i+1][j] == 'O')    // down
                dfs(board, i + 1, j);

            if(i - 1 >= 0 && board[i - 1][j] == 'O')        // up
                dfs(board, i -1, j);

            if(j + 1 < board[0].length && board[i][j + 1] == 'O')       // right
                dfs(board, i, j+ 1);

            if(j - 1 >= 0 && board[i][j - 1] == 'O')        // left
                dfs(board, i, j - 1);
        }
    }
}
