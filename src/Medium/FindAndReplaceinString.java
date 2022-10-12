package medium;

import java.util.*;

public class FindAndReplaceinString {
    private String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        int len = S.length();
        Map<Integer, String[]> m = new HashMap<>();

        for(int i = 0; i < indexes.length; i++){
            m.put(indexes[i], new String[]{sources[i], targets[i]});
        }

        StringBuilder res = new StringBuilder();
        for(int i = 0; i < len; i++){
            if(m.containsKey(i)){
                String scr = m.get(i)[0], tar = m.get(i)[1];

                if(i + scr.length() <= len && S.substring(i, i + scr.length()).equals(scr)){
                    res.append(tar);
                    i += scr.length() - 1;
                    m.remove(i);
                    continue;
                }
            }

            res.append(S.charAt(i));
        }

        return res.toString();
    }

}
