package medium;

public class StringtoInteger {
    public int myAtoi(String str) {
        if(str == null || str.length() < 1)
            return 0;

        int sign = 1;
        int res = 0;    // result number
        int i = 0;

        /*
        while (i < len && str.charAt(i) == ' ') // skip starting whitespace
            i++;
        if(i == len)
            return 0;
        */

        str = str.trim();
        if(str.length() == 0)
            return 0;

        if(str.charAt(i) == '+' || str.charAt(i) == '-') {   // get sign
            sign = str.charAt(i)=='+'?1:-1;
            i++;
        }

        int len = str.length();
        while (i < len && str.charAt(i) >= '0' && str.charAt(i) <= '9'){    // while is an integer

            // check overflow
            if(res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && str.charAt(i) - '0' > 7))
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;

            res = 10*res + str.charAt(i) - '0';
            i++;
        }

        return res*sign;
    }
}
