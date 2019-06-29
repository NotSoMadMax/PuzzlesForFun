package Hard;

import java.util.*;

// 229ms, 94%

class TrieNode{
    Map<Character, TrieNode> children;
    boolean isLeaf;

    // store all sentences that could appear in this node. Require space, but can avoid the problem of traversal for candidates every time
    Map<String, Integer> frequency;

    public TrieNode(){
        children = new HashMap<>();
        frequency = new HashMap<>();
        isLeaf = false;
    }
}

class Count{
    String key;	// sentence
    int freq;

    public Count(String key, int fre){
        this.key = key;
        this.freq = fre;
    }
}

class count_comparator implements Comparator<Count>{
    public int compare(Count c1, Count c2){
        if(c1.freq > c2.freq)
            return 1;
        else if(c1.freq < c2.freq)
            return -1;
        else
            return -c1.key.compareTo(c2.key);
    }
}


class AutocompleteSystem {
    TrieNode root;  // store sentences in a trie
    String cur_input;
    TrieNode cur; // keep track of current input in the trie

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        cur_input = "";
        cur = root;

        // construct the trie
        for(int i = 0; i < sentences.length; i++)
            add_sentence(sentences[i], times[i]);

        System.out.println("Finished");
    }


    public List<String> input(char c) {
        if(c == '#'){
            add_sentence(cur_input, 1);
            cur_input = "";
            cur = null;
            return Collections.emptyList();
        }

        if(cur == null)
            cur = root;

        cur_input += String.valueOf(c);

        cur.children.putIfAbsent(c, new TrieNode());
        cur = cur.children.get(c);
        // System.out.println(cur_input);
        return topK(3);
    }


    public void add_sentence(String sentence, int frequency){
        if(sentence == null || sentence.isEmpty())
            return;

        TrieNode curr = root;
        for(Character c:sentence.toCharArray()){
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
            curr.frequency.put(sentence, curr.frequency.getOrDefault(sentence, 0) + frequency);
        }

        curr.isLeaf = true;
    }

    public List<String> topK(int k){
        if(cur.frequency.isEmpty())
            return Collections.emptyList();

        PriorityQueue<Count> p = new PriorityQueue<>(new count_comparator());
        for(String s:cur.frequency.keySet()){
            p.add(new Count(s, cur.frequency.get(s)));

            if(p.size() > 3)    // keep size small, faster
                p.poll();
        }

        List<String> res = new ArrayList<>();
        for(int i = 0; i < k; i++){
            if(p.isEmpty())
                break;
            res.add(p.poll().key);
        }

        Collections.reverse(res);
        return res;
    }
}

public class DesignSearchAutocompleteSystem {

}
