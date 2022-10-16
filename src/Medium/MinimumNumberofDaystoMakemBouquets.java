class Solution {
    public int minDays(int[] bloomDay, int totalBouquets, int needFlowers) {
        int min = 1;
        int max = bloomDay[0];
        for(int i = 0; i < bloomDay.length; i++){
            max = Math.max(max, bloomDay[i]);
        }
        
        while(min < max) {
            int mid = min + (max - min) / 2;
            if(canMakeBouquet(bloomDay, mid, totalBouquets, needFlowers)) {
                max = mid;    // current day could be final answer
            } else {
                min = mid + 1;
            }
        }
        
        return canMakeBouquet(bloomDay, max, totalBouquets, needFlowers) ? max : -1;
    }
    
    private boolean canMakeBouquet(int[] bloomDay, int day, int totalBouquets, int needFlowers){
        int curFlowers = 0;
        int curBouquets = 0;
        for(int i = 0; i < bloomDay.length; i++){
             if(bloomDay[i] <= day) {
                 curFlowers++;
                 if(curFlowers == needFlowers) {
                     curBouquets++;
                     curFlowers = 0;
                     
                     if(curBouquets == totalBouquets) {
                         return true;
                     }
                 }
             } else {
                 curFlowers = 0;
             }
        }
        
        return false;
    }
}