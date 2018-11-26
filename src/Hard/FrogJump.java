package Hard;

import java.util.*;

public class FrogJump {

    // Method 3: DP, 21%
    private boolean canCross3(int[] stones) {

        // distance of stone, step size that can reach this stone
        HashMap<Integer, HashSet<Integer>> m = new HashMap<>();
        for(int i: stones)
            m.put(i, new HashSet<>());
        m.get(0).add(0);

        int len = stones.length;
        for(int i = 0; i < len; i++)
        {
            for(int step:m.get(stones[i]))  // for each possible step
            {
                for(int s = -1; s <= 1; s++)
                {
                    if(step + s > 0 && m.containsKey(stones[i] + step + s))
                        m.get(stones[i] + step + s).add(step + s);
                }
            }
        }

        return m.get(stones[len - 1]).size() > 0;
    }


    // Method 2: Brutal force with memorization, cur_unit vs step, 87%
    private boolean canCross2(int[] stones) {
        if(stones == null || stones.length < 2)
            return true;

        int len = stones.length;
        int[][] memo = new int[len][len];
        for(int[] row:memo)
            Arrays.fill(row, -1);

        return jump1(stones, 0, 0, memo) == 1;
    }

    private int jump1(int[] stones, int cur_unit, int step, int[][] memo){
        if(memo[cur_unit][step] != -1)
            return memo[cur_unit][step];

        if(cur_unit == stones.length - 1)
            return 1;

        for(int i = cur_unit + 1; i < stones.length; i++){
            int gap = stones[i] - stones[cur_unit];
            if(gap >= step - 1 && gap <= step + 1)
            {
                if(jump1(stones, i, gap, memo) == 1)
                {
                    memo[cur_unit][gap] = 1;
                    return 1;
                }
            }
        }

        memo[cur_unit][step] = 0;
        return 0;
    }


    // Method 1: brutal force, Time limit
    private boolean canCross1(int[] stones) {
        if(stones == null || stones.length < 2)
            return true;

        int len = stones.length;
        if(len == 2){
            if(stones[1] - stones[0] != 1)
                return false;
            else
                return true;
        }

        return jump(stones, 1, 2) || jump(stones, 1, 1);
    }


    private boolean jump(int[] stones, int cur_unit, int step){
        if(step < 1)
            return false;

        int dis = stones[cur_unit] + step;
        for(; cur_unit < stones.length; cur_unit++){
            if(stones[cur_unit] == dis)
                break;
        }

        if(cur_unit == stones.length)   // not a stone
            return false;
        if(cur_unit == stones.length - 1)   // reach the last stone
            return true;

        if(jump(stones, cur_unit, step - 1) ||
            jump(stones, cur_unit, step) ||
            jump(stones, cur_unit, step + 1))
            return true;

        return false;
    }
}
