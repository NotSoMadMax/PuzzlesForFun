package medium;

class IntegerBreak {
    int integerBreak(int n) {
        if(n == 2)
            return 1;
        if(n == 3)
            return 2;

        int remain = n % 3;
        int num3 = n / 3;
        int temp = (int)Math.pow(3, num3 - 1);

        if(remain == 0)
            return temp * 3;

        else if(remain == 1)
            return 4*temp;

        else
            return temp*3*2;


    }
}
