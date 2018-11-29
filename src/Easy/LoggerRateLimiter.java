package Easy;

import java.util.*;

// Method 1: hashtable
class logger1{
    private Map<String, Integer> memo;

    public void logger1{
        memo = new Hashtable<>();
    }

    public boolean shouldPrintMessage1(int timestamp, String message) {
        if(!memo.containsKey(message))
        {
            memo.put(message, timestamp);
            return true;
        }
        else
        {
            int gap = timestamp - memo.get(message);
            if(gap >= 10){
                memo.put(message, timestamp);
                return true;
            }
            else
                return false;
        }
    }
}



// Method 2: rotational array
class logger2{
    private List<String>[] memo = new List[10];
    private Set<String> mssgs = new HashSet<>();
    private int start = 0;

    public void logger2{
        for(int i = 0; i < 10; i++)
            memo[i] = new ArrayList<>();
    }

    public boolean shouldPrintMessage2(int timestamp, String message) {
        // remove old messages earlier than 10s ago
        for(int i = start; i <= timestamp - 10; i++)
        {
            int pos = (i + memo.length)%memo.length;    // generic, not necessary in this question
            for(String s:memo[pos])
                mssgs.remove(s);
            memo[pos].clear();
        }

        if(mssgs.contains(message))
        {
            return false;
        }
        memo[(timestamp + memo.length)%memo.length].add(message);
        mssgs.add(message);
        start = timestamp - 9;
        return true;
    }
}


public class LoggerRateLimiter {


}
