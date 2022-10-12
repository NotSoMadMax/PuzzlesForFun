package medium;

import java.util.*;

public class NextClosestTime {

    // Faster than 100%
    private static String nextClosestTime(String time) {
        if(time == null || time.isEmpty())
            return time;

        Set<Integer> uni_dig = new HashSet<>();
        char[] t = time.toCharArray();
        for(int i = 0; i < t.length; i++){
            if(t[i] != ':')
                uni_dig.add(t[i] - '0');
        }

        int uni = uni_dig.size();
        int[] digits = new int[uni];
        int idx = 0;
        for(int i:uni_dig){
            digits[idx++] = i;
        }
        Arrays.sort(digits);

        // last digit
        if(digits[uni - 1] > t[4] - '0'){
            int i = 0;
            while (digits[i] <= t[4] - '0')
                i++;

            t[4] = (char)(digits[i] + '0');
            return new String(t);
        }
        t[4] = (char)(digits[0] + '0');

        // third digit
        if(digits[uni - 1] > t[3] - '0'){
            int i = 0;
            while (digits[i] <= t[3] - '0')
                i++;
            if(digits[i] <= 5){
                t[3] = (char)(digits[i] + '0');
                return new String(t);
            }
        }
        t[3] = (char)(digits[0] + '0');

        // second digit
        int range = t[0]<'2'?9:3;
        if(digits[uni - 1] > t[1] - '0'){
            int i = 0;
            while (digits[i] <= t[1] - '0')
                i++;
            if(digits[i] <= range){
                t[1] = (char)(digits[i] + '0');
                return new String(t);
            }
        }
        t[1] = (char)(digits[0] + '0');

        // first digit
        if(digits[uni - 1] > t[0] - '0'){
            int i = 0;
            while (digits[i] <= t[0] - '0')
                i++;
            if(digits[i] <= 2){
                t[0] = (char)(digits[i] + '0');
                return new String(t);
            }
        }
        t[0] = (char)(digits[0] + '0');

        return new String(t);
    }

    public static void main(String[] args){
        String t = "19:34";
        System.out.println(nextClosestTime(t));
    }

}
