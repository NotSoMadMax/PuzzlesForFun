package Easy;


/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

class GuessNumberHigherorLower {
    public int guessNumber(int n) {
        if(n < 1)
            return 0;

        int low = 1;
        int high = n;
        int cur = low + (high - low)/2;
        int result;
        for(;;){
            result = guessNumber(cur);

            if(result == 0)
                break;
            else if(result == -1)
                high = cur - 1;
            else    // result = 1
                low = cur + 1;
            cur = low + (high - low)/2;
        }

        return cur;
    }
}
