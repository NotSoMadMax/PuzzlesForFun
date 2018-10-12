package Easy;

public class BitCharacters {

    public boolean isOneBitCharacter(int[] bits) {
        if(bits == null || bits.length < 1)
            return false;

        int len = bits.length;
        if(bits[len - 1] == 1)
            return false;

        int cur = 0;
        while (cur < len - 1){
            if(bits[cur] == 0)
                cur++;
            else
                cur += 2;
        }

        return cur == len - 1;
    }
}
