package medium;

import java.util.HashMap;
import java.util.Map;

class FractiontoRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0)
            return "";
        if (numerator == 0)
            return "0";

        StringBuilder sb = new StringBuilder();
        if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0))
            sb.append('-');

        long nu = Math.abs(Long.valueOf(numerator));
        long de = Math.abs(Long.valueOf(denominator));

        sb.append(nu / de);
        long rem = nu % de;
        if(rem == 0)
            return sb.toString();
        sb.append(".");

        // reminder to position
        Map<Long, Integer> m = new HashMap<>();

        while (rem != 0){
            if(m.containsKey(rem)){ // repeat found
                sb.insert(m.get(rem), "(");
                sb.append(")");
                break;
            }

            m.put(rem, sb.length());
            rem = rem*10;
            sb.append(rem / de);
            rem = rem % de;
        }

        return sb.toString();
    }
}
