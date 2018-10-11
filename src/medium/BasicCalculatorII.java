package medium;

import java.util.Stack;

class BasicCalculatorII {
    private int calculate(String s) {
        if(s == null || s.length() < 1)
            return 0;

        s = s.trim();
        int num = 0;    // current num
        char op = '+';  // operator before current number

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(cur == ' ')
                continue;

            if(cur >= '0')   // is a number
                num = num*10 + cur - '0';
            if(cur < '0' || i == s.length() - 1){     // is an operator, push current number into stack and start a new num
                if(op == '+')
                    stack.push(num);
                else if(op == '-')
                    stack.push(-num);
                else if(op == '*'){
                    int top = num*stack.pop();
                    stack.push(top);
                } else {
                    int top = stack.pop() / num;
                    stack.push(top);
                }

                op = cur;
                num = 0;
            }
        }

        int result = 0;
        while (!stack.empty())
            result += stack.pop();

        return result;
    }
}
