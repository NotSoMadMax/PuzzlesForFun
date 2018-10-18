package Easy;

public class StringCompression {
    private static int compress(char[] chars) {
        if(chars == null || chars.length < 1)
            return  0;

        int len = chars.length;
        int cur = 0;    // current pos in result array
        for(int i = 0, j = 0; i < len; i = j){
            while (j < len && chars[j] == chars[i])
                j++;
            // j is the first that doesn't equal to chars[i]

            chars[cur++] = chars[i];

            if(j - i == 1)  // no duplicates
                continue;

            for(char digit:String.valueOf(j - i).toCharArray())
                chars[cur++] = digit;
        }

        return cur;
    }
}
