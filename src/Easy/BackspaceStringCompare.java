package Easy;

public class BackspaceStringCompare {
    private boolean backspaceCompare(String S, String T) {
        if(S == null || S.isEmpty() || T == null || T.isEmpty())
            return true;

        int i = S.length() - 1, j = T.length() - 1;
        while (i >= 0 || j >= 0){

            int s_count = 0;
            while(i >= 0)
            {
                if(S.charAt(i) == '#'){
                    s_count++;
                    i--;
                }else if(s_count > 0){
                    s_count--;
                    i--;
                }else       // skipped # and corresponding chars
                    break;
            }

            int t_count = 0;
            while (j >= 0)
            {
                if(T.charAt(j) == '#'){
                    t_count++;
                    j--;
                } else if(t_count > 0){
                    t_count--;
                    j--;
                }else
                    break;
            }

            if((i >= 0) != (j >= 0))
                return false;

            if(i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;

            i--;
            j--;
        }

        return true;
    }
}
