package Easy;

import java.util.Comparator;
import java.util.PriorityQueue;

class KClosestPointstoOrigin {

    class DistCompare implements Comparator<int[]>{
        public int compare(int[] a, int[] b){
            return (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]);
        }
    }

    private int[][] kClosest(int[][] points, int K) {
        if(points == null || points.length < 1)
            return null;

        PriorityQueue<int[]> pq = new PriorityQueue<>(new DistCompare());
        for(int[] p:points){
            pq.add(p);

            while (pq.size() > K)
                pq.poll();
        }

        int[][] res = new int[pq.size()][2];
        for(int i = pq.size(); i > 0; i--){
            int[] p = pq.poll();
            res[i - 1][0] = p[0];
            res[i - 1][1] = p[1];
        }

        return res;
    }
}
