package Easy;

import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int curG = 0;
        int curS = 0;
        while(curG < g.length && curS < s.length) {
            if(s[curS] >= g[curG]) {
                curG++;
            }
            curS++;
        }
        return curG;
    }
}
