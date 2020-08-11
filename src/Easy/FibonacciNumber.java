package Easy;

public class FibonacciNumber {
    public int fib(int N) {
        int[] f = new int[N + 2];
        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i <= N; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[N];
    }
}
