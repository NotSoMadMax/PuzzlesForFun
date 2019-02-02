package Hard;

import java.util.*;

class WordLadderII {
    private List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> s = new HashSet<>(wordList);

        List<List<String>> res = new ArrayList<>();
        int shortest = Integer.MAX_VALUE;

        Queue<List<String>> q = new LinkedList<>();
        List<String> temp = new ArrayList<>();
        temp.add(beginWord);
        q.add(temp);

        Set<String> visited = new HashSet<>();  // words that are visited during the search of current level
        int cur_level = 1;

        while (!q.isEmpty()){
            List<String> cur_path = q.poll();
            String cur_word = cur_path.get(cur_path.size() - 1);

            if(cur_path.size() > cur_level){    // entering the next level of bfs
                for(String w:visited)
                    s.remove(w);    //next level shall not use those words that are used in previous levels

                visited.clear();
                cur_level = cur_path.size();

                if(cur_level > shortest)    // already find a valid path, and entered next level
                    break;
            }

            for(int i = 0; i < cur_word.length(); i++){
                for(char c = 'a'; c <= 'z'; c++){
                    String next = cur_word.substring(0, i) + c + cur_word.substring(i + 1);
                    if(s.contains(next))
                    {
                        visited.add(next);
                        List<String> next_path = new ArrayList<>(cur_path);
                        next_path.add(next);

                        if(next.equals(endWord)){
                            res.add(next_path);
                            shortest = cur_level;
                        }
                        else
                            q.add(next_path);
                    }
                }
            }
        }

        return res;
    }

}
