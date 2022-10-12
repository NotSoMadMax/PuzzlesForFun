package medium;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaystoAddParentheses {
    Map<String, List<Integer>> values = new HashMap<>();
    // Assume input expression is a valid function
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new LinkedList<>();

        if(values.containsKey(expression)) {
            return values.get(expression);
        }

        if(isNumeric(expression)) {
            result.add(Integer.valueOf(expression));
            return result;
        }
        for(int i = 0; i < expression.length() - 1; i++) {
            if (isOperator(expression.charAt(i))) {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));

                for(Integer num1 : left) {
                    for(Integer num2 : right) {
                        result.add(calculate(num1, num2, expression.charAt(i)));
                    }
                }
            }
        }
        values.put(expression, result);
        return result;
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*';
    }

    private boolean isNumeric(String s) {
        return s.chars().allMatch(Character::isDigit);
    }

    private int calculate(int num1, int num2, char operator) {
        if (operator == '+') {
            return num1 + num2;
        } else if (operator == '*') {
            return num1 * num2;
        } else {
            return num1 - num2;
        }
    }
}
