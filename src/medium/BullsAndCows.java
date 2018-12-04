package medium;

public class BullsAndCows {
    private String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;

        int[] digit_count = new int[10];

        for(int i = 0; i < secret.length(); i++)
        {
            if(secret.charAt(i) == guess.charAt(i))
                bulls++;
            else
            {
                digit_count[secret.charAt(i) - '0']++;
                digit_count[guess.charAt(i) - '0']--;

                if(digit_count[secret.charAt(i) - '0'] <= 0)
                    cows++;
                if(digit_count[guess.charAt(i) - '0'] >= 0)
                    cows++;
            }
        }

        return bulls + "A" + cows + "B";
    }
}
