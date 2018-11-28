package Hard;

import java.util.*;

interface Robot {
    public boolean move();
    public void turnLeft();
    public void turnRight();
    public void clean();
}


public class RobotRoomCleaner {
    int[][] offset = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private void cleanRoom(Robot robot) {
        if(robot == null)
            return;

        Set<String> visited = new HashSet<>();

        walkAround(0, 0, 0, visited, robot);
    }

    private void walkAround(int x, int y, int dir, Set<String> visited, Robot rob){
        rob.clean();
        visited.add(x + "," + y);

        for(int i = 0; i < 4; i++)
        {
            int cur_dir = (dir + i) % 4;
            int[] next_pos = {x + offset[cur_dir][0], y + offset[cur_dir][1]};
            if(!visited.contains(next_pos[0] + "," + next_pos[1]) && rob.move())
            {
                walkAround(next_pos[0], next_pos[1], cur_dir, visited, rob);

                // come back (the last pop() in dfs)
                rob.turnRight();
                rob.turnRight();
                rob.move();
                rob.turnRight();
                rob.turnRight();
            }
            rob.turnRight();
        }

        return;
    }
}
