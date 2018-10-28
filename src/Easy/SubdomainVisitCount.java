package Easy;

import java.util.*;

public class SubdomainVisitCount {
    private List<String> subdomainVisits(String[] cpdomains) {
        if(cpdomains == null || cpdomains.length < 1)
            return Collections.emptyList();

        List<String> res = new ArrayList<String>();
        Map<String, Integer> m = new HashMap<>();

        for(String s:cpdomains){
            String[] temp = s.split(" ");
            int count = Integer.valueOf(temp[0]);
            String[] segs = temp[1].split("\\.");

            m.put(segs[segs.length - 1], m.getOrDefault(segs[segs.length - 1], 0) + count);
            String cur = segs[segs.length - 1];

            for(int i = segs.length - 2; i >= 0; i--){
                cur = segs[i] + "." + cur;
                m.put(cur, m.getOrDefault(cur, 0) + count);
            }

        }
        for(String key:m.keySet())
            res.add(m.get(key) + " " + key);

        return res;
    }
}
