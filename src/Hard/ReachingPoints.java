package Hard;

public class ReachingPoints {
    private boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if(sx > tx || sy > ty)
            return false;

        // can be thought of as decreasing tx and ty by sx/sy
        while (sx <= tx && sy <= ty){
            if(tx > ty)
            {
                if(ty == sy)    // already equal, will not change sy anymore
                    return (tx - sx)%ty == 0;
                else
                    tx %= ty;
            }
            else // ty > tx
            {
                if(tx == sx)
                    return (ty - sy)%sx == 0;
                else
                    ty %= tx;
            }
        }

        return tx == sx && ty == sy;
    }
}
