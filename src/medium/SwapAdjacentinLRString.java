package medium;

public class SwapAdjacentinLRString {
    private boolean canTransform(String start, String end) {
        if(start == null || end == null || start.isEmpty() || end.isEmpty())
            return true;

        int ls = start.length(), le = end.length();
        char[] s = start.toCharArray();
        char[] e = end.toCharArray();

        int i = 0, j = 0;
        while (i < ls && j < le)
        {
            while(i < ls && s[i] == 'X')
                i++;
            while(j < le && e[j] == 'X')
                j++;

            if ((i < ls) ^ (j < le)) return false;  // XOR

            if(i < ls && j < le){
                if(s[i] != e[j])
                    return false;

                if(s[i] == 'L' && i < j)
                    return false;
                if(s[i] == 'R' && i > j)
                    return false;
            }

            i++;
            j++;
        }

        return true;
    }
}
