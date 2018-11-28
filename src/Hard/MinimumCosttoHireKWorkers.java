package Hard;

import java.util.*;



public class MinimumCosttoHireKWorkers {

    public class arrayComparator implements Comparator<double[]>{
        @Override
        public int compare(double[] a, double[] b) {
            return Double.compare(a[0], b[0]);
        }
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        if(quality == null || wage == null || quality.length < 1 || wage.length < 1)
            return 0.0;

        int len = quality.length;
        double[][] ratio = new double[len][2];    // {ratio, quality}
        for(int i = 0; i < len; i++)
            ratio[i] = new double[]{(double)wage[i]/(double)quality[i], quality[i]};
        Arrays.sort(ratio, new arrayComparator());

        double res = Double.MAX_VALUE;
        double quality_sum = 0;
        Queue<Double>  min_qualities = new PriorityQueue<>(Collections.reverseOrder());    // descending
        for(double[] r:ratio)
        {
            double cur_quality = r[1];
            min_qualities.add(cur_quality);
            quality_sum += cur_quality;

            if(min_qualities.size() > K)
                quality_sum -= min_qualities.poll();

            if(min_qualities.size() == K)
                res = Math.min(res, quality_sum * r[0]);
        }

        return res;
    }
}