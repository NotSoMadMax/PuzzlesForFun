class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        // eating speed range
        int min = 1;
        int max = 1000000000;
        
        while(min < max) {
            int speed = min + (max - min) / 2;
            int hour = 0;
            for(int pile : piles) {
                hour += (pile + speed - 1) / speed; // round up
            }
            
            if(hour > h) {
                min = speed + 1;
            } else {
                max = speed;
            }
        }
        
        return max;
    }
}