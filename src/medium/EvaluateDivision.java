package medium;

import java.util.*;

public class EvaluateDivision {
    Hashtable<String, List<String>> graph = new Hashtable<>();
    Hashtable<String, Double> equValues = new Hashtable<>();

    private double[] calcEquation(String[][] equations, double[] values, String[][] queries) {

        int i = 0;
        for(String[] e:equations)
        {
            if(!graph.containsKey(e[0]))
                graph.put(e[0], new ArrayList<>());
            if(!graph.containsKey(e[1]))
                graph.put(e[1], new ArrayList<>());

            graph.get(e[0]).add(e[1]);
            equValues.put(e[0]+"/"+e[1], values[i]);

            if(values[i] != 0.0)
            {
                graph.get(e[1]).add(e[0]);
                equValues.put(e[1]+"/"+e[0], 1.0/values[i]);
            }
            i++;
        }


        double[] res = new double[queries.length];
        i = 0;
        for(String[] q:queries)
        {
            HashSet<String> visited = new HashSet<>();
            res[i++] = search(q[0], q[1], visited);
        }

        return res;
    }

    private double search(String cur, String target, HashSet<String> visited){
        if(!graph.containsKey(cur))
            return -1.0;

        double res = -1.0;
        visited.add(cur);
        List<String> nb = graph.get(cur);
        for(String neib:nb)
        {
            if(neib.equals(target))
            {
                res = equValues.get(cur+"/"+target);
                break;
            }
            else if(!visited.contains(neib))
            {
                double temp = search(neib, target, visited);
                if(temp != -1.0)
                {
                    res = equValues.get(cur+"/"+neib) * temp;
                    break;
                }
            }
        }
        visited.remove(cur);

        return res;
    }
}
