package medium;

class CountingBits {
     private int[] countBits(int num) {

        int[] count = new int[num + 1];
        count[0] = 0;
        if(num == 0)
            return count;
        count[1] = 1;

        for(int i = 2; i <= num; i++){
            if(i%2 == 0)
                count[i] = count[i>>1];
            else
                count[i] = count[i>>1] + 1;
        }

        return count;
    }
}
