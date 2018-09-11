package medium;

import java.util.*;


class WordLadder {
    private static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.isEmpty())
            return 0;

        Map<String, Integer> hmap = new HashMap<>();
        hmap.put(beginWord, 1);

        Queue<String> q = new LinkedList<String>();
        q.add(beginWord);
        while(!q.isEmpty()){
            String cur = q.poll();

            if (cur.equals(endWord))
                return hmap.get(cur);

            List<String> nb = neighbors(cur, wordList);
            for(String n:nb){
                q.add(n);
                hmap.put(n, hmap.get(cur) + 1);
            }
        }

        return 0;
    }


    // compare with each word one by one
    private static List<String> neighbors(String word, List<String> wordList){
        List<String> nb = new ArrayList<String>();

        for(int i = wordList.size() - 1; i >= 0; i--){
            int diff = word.length();
            for (int j = 0; j < word.length(); j++){
                if(word.charAt(j) == wordList.get(i).charAt(j))
                    diff--;
            }

            if(diff == 1){
                nb.add(wordList.get(i));
                wordList.remove(i);
            }
        }

        return nb;
    }

    /*
    // change one letter and see if exist in wordList
    private static LIst<STring> neighbors2(String word, List<String> wordList){
        List<String> nb = new ArrayList<String>();

        for (int i=0; i < word.length(); i++){
            for (int j = 0; j < 26; j++){

            }
        }
    }
    */
}
