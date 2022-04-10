class Solution {
    public int calPoints(String[] ops) {
        if(ops == null || ops.length < 1) {
            return 0;
        }
        
        Deque<Integer> scores =  new ArrayDeque<>();
        for(String op : ops) {
            if(isScore(op)) {
                scores.push(Integer.valueOf(op));
            } else {
                switch(op) {
                    case "+":
                        int num1 = scores.pop();
                        int num2 = scores.pop();
                        scores.push(num2);
                        scores.push(num1);
                        scores.push(num1 + num2);
                        break;
                    case "D":
                        scores.push(scores.peek() * 2);
                        break;
                    case "C":
                        scores.pop();
                        break;
                }
            }
        }
        
        int result = 0;
        while(scores.size() > 0){
            result += scores.pop();
        }
        
        return result;
    }
    
    private Boolean isScore(final String s) {
        return !("+".equals(s) || "D".equals(s) || "C".equals(s));
    }
}
