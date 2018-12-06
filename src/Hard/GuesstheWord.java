package Hard;

import java.util.*;

interface Master {
      public int guess(String word);
}

public class GuesstheWord {
    int[][] difference;

    private void findSecretWord(String[] wordlist, Master master) {
        int len = wordlist.length;
        difference = new int[len][len];
        for(int[] row:difference)
            Arrays.fill(row, -1);

        List<Integer> candidates = new ArrayList<>();
        for(int i = 0; i < len; i++)
            candidates.add(i);

        find(candidates, master, wordlist);
    }


    private void find(List<Integer> candidates, Master master, String[] wordlist){
        Random rand = new Random();
        // System.out.println(candidates.size());
        int pick = candidates.get(rand.nextInt(candidates.size()));
        int similarity = master.guess(wordlist[pick]);
        candidates.remove(Integer.valueOf(pick));

        if(similarity == 6)
            return;

        int target_diff = 6 - similarity;
        List<Integer> new_candis = candi(candidates, pick, target_diff, wordlist);

        find(new_candis, master, wordlist);
    }


    private List<Integer> candi(List<Integer> candidates, int cur_guess, int target_diff, String[] wordlist){
        List<Integer> res = new ArrayList<>();
        for(int c:candidates){
            int diff = difference[cur_guess][c];
            if(diff == -1){
                diff = diff(wordlist[cur_guess], wordlist[c]);
                difference[cur_guess][c] = diff;
                difference[c][cur_guess] = diff;
            }

            if(diff == target_diff)
                res.add(c);
        }

        return res;
    }


    private int diff(String a, String b){
        int res = 0;
        for(int i = 0; i < 6; i++){
            if(a.charAt(i) != b.charAt(i))
                res++;
        }
        return res;
    }
}
