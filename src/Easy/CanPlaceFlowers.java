package Easy;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if (n == 0) {
                return true;
            }
            if (flowerbed[i] == 0) {
                int prev = (i - 1 < 0) ? 0 : flowerbed[i - 1];
                int next = (i + 1 == flowerbed.length) ? 0 : flowerbed[i + 1];
                if (prev == 0 && next == 0) {
                    n--;
                    flowerbed[i] = 1;
                }
            }
        }
        return n == 0;
    }
}
