package medium;

import java.util.ArrayList;
import java.util.List;

class FractionAdditionandSubtraction {
    public String fractionAddition(String expression) {
        if(expression == null || expression.length() < 1)
            return "";

        int len = expression.length();

        List<Character> sign = new ArrayList<>();
        if(expression.charAt(0) == '-')
            sign.add('-');
        else
            sign.add('+');

        for(int i = 1; i < len; i++){
            if(expression.charAt(i) == '-' || expression.charAt(i) == '+')
                sign.add(expression.charAt(i));
        }

        int pre_deno = 1;
        int pre_num = 0;
        int i = 0; // for sign
        String[] nums = expression.split("[+-]");
        for(String piece:nums){
            if(piece.length() > 0){
                String[] temp = piece.split("/");
                int num = Integer.valueOf(temp[0]);
                int deno = Integer.valueOf(temp[1]);

                int g = cd(num, deno);
                if(sign.get(i++) == '+')
                    pre_num = (pre_num*deno + num*pre_deno)/g;
                else
                    pre_num = (pre_num*deno - num*pre_deno)/g;
                pre_deno = deno*pre_deno/g;

                g = Math.abs(cd(pre_num, pre_deno));
                pre_deno /= g;
                pre_num /= g;
            }
        }

        return pre_num + "/" + pre_deno;
    }

    private static int cd(int a, int b){        // largest common divider
        return (b == 0)? a : cd(b, a%b);
    }

}
