package Easy;

public class MaximizeDistancetoClosestPerson {
    private int maxDistToClosest(int[] seats) {
        if(seats == null || seats.length < 1)
        {
            System.out.println("Why can't you stand???");
            return 0;
        }

        int len = seats.length;
        int[] left_max = new int[len];
        int[] right_max = new int[len];

        int pre_pos = -1;
        for(int i = 0; i < len; i++)
        {
            if(seats[i] == 1){
                pre_pos = i;
                left_max[i] = -1;
                continue;
            }

            if(pre_pos == -1)
                left_max[i] = Integer.MAX_VALUE;
            else
                left_max[i] = i - pre_pos;
        }

        pre_pos = -1;
        for(int i = len - 1; i >= 0; i--)
        {
            if(seats[i] == 1){
                pre_pos = i;
                right_max[i] = -1;
                continue;
            }

            if(pre_pos == -1)
                right_max[i] = Integer.MAX_VALUE;
            else
                right_max[i] = pre_pos - i;
        }

        int res = 0;
        for(int i = 0; i < len; i++)
        {
            if(left_max[i] != -1)
                res = Math.max(res, Math.min(left_max[i], right_max[i]));
        }

        return res;
    }
}
