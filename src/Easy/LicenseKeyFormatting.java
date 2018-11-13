package Easy;

public class LicenseKeyFormatting {

    // 96%
    private String licenseKeyFormatting(String S, int K) {
        if(S == null || S.isEmpty())
            return S;

        char[] c = S.toCharArray();
        StringBuilder sb = new StringBuilder();

        int cur = 0;
        for(int i = c.length - 1; i >= 0; i--){
            if(c[i] == '-')
                continue;
            if(c[i] >= 'a' && c[i] <= 'z')
                c[i] = Character.toUpperCase(c[i]);

            if(cur == 0 && sb.length() != 0)
                sb.append("-");
            sb.append(c[i]);
            cur++;
            if(cur == K){
                cur = 0;
            }
        }

        return sb.reverse().toString();
    }
}
