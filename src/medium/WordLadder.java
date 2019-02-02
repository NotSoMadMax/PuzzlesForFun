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

    // Method 2: Change one letter and see if exist in wordList
    private static int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        if(wordList == null || wordList.isEmpty())
            return 0;

        Set<String> words = new HashSet<>();
        for(String w:wordList)
            words.add(w);
        if(words.contains(beginWord))
            words.remove(beginWord);

        int level = 1;

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        while (!q.isEmpty()){

            for(int k = q.size(); k > 0; k--){
                String cur = q.poll();

                // Find neighbors
                for(int i = 0; i < cur.length(); i++)
                {
                    for(char c = 'a'; c <= 'z'; c++)
                    {
                        String nb = cur.substring(0, i) + c + cur.substring(i+1);
                        if(words.contains(nb)){
                            System.out.println(nb);
                            if(nb.equals(endWord))
                                return level + 1;

                            q.add(nb);
                            words.remove(nb);
                        }
                    }
                }
            }

            level++;
        }

        return 0;
    }
}














