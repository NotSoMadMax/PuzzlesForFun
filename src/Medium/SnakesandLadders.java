package medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class SnakesandLadders {
    private int snakesAndLadders(int[][] board) {
        if(board == null || board.length < 1 || board[0].length < 1)
            return 0;

        int len = board.length;
        Queue<Integer> pos = new LinkedList<>();    // current position, start from left bottom corner
        Map<Integer, Integer> m = new HashMap<>(); // pos -> number of moves
        pos.add(1);
        m.put(1, 0);

        while (!pos.isEmpty()){
            int cur = pos.poll();
            int cur_move = m.get(cur);

            if(cur == len*len)
                return cur_move;

            for(int next = cur + 1; next <= Math.min(cur + 6, len*len); next++){
                int[] coord = to2d(next - 1, len);
                int temp = next;

                if(board[coord[0]][coord[1]] != -1)    // is a ladder{
                    temp = board[coord[0]][coord[1]];

                if(!m.containsKey(temp)){
                    pos.add(temp);
                    m.put(temp, cur_move + 1);
                }
            }
        }

        return -1;
    }

    private int[] to2d(int i, int n){
        int[] coord = new int[2];

        coord[0] = n - 1 - i/n;
        if(coord[0] % 2 != n % 2){
            coord[1] = i % n;
        }
        else
            coord[1] = n - 1 - i % n;

        return coord;
    }
}
