package Hard;

public class Candy {
    private int candy(int[] ratings) {
        if(ratings == null || ratings.length < 1)
            return 0;

        int len = ratings.length;
        int[] candies = new int[len];
        for(int i = 0; i < len; i++)
            candies[i] = 1;

        for(int i = 0; i < len - 1; i++){
            if(ratings[i+1] > ratings[i])
                candies[i+1] = candies[i] + 1;
        }

        for(int i = len - 1; i > 0; i--){
            if(ratings[i-1] > ratings[i])
                candies[i-1] = Math.max(candies[i-1], candies[i] + 1);
        }

        int sum = 0;
        for(int i:candies)
            sum += i;

        return sum;
    }
}
