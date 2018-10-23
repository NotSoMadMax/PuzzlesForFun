package Easy;

public class RobotReturnToOrigin {
    private boolean judgeCircle(String moves) {
        if(moves == null || moves.length() < 1)
            return true;

        int x = 0, y = 0;
        char[] m = moves.toCharArray();
        for(int i = 0; i < moves.length(); i++){
            if(m[i] == 'R')
                x += 1;
            else if(m[i] == 'L')
                x -= 1;
            else if(m[i] == 'U')
                y += 1;
            else
                y -= 1;
        }

        return (x == 0 && y == 0);
    }
}
