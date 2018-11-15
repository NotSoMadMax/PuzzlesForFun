package medium;

public class Pow_x_n {
    private double myPow(double x, int n) {
        if(n == 0)
            return 1;

        double res = 0;
        if (n < 0)
            res = 1.0 / pow(x, -n);
        else
            res = pow(x, n);

        return res;
    }

    private static double pow(double x, int n){
        if(n == 1)
            return x;
        if(n == 0)
            return 1;

        double half = pow(x, n/2);
        if(n % 2 == 0)
            return half * half;
        else
            return half * half * x;
    }
}
