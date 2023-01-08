class Solution {
    public String reorganizeString(String s) {
        int[] count = new int[26];
        for(char c : s.toCharArray()) {
            count[c - 'a']++;
            if(count[c - 'a'] > (s.length() + 1) / 2) {
                return "";
            }
        }
        
        PriorityQueue<Character> queue = new PriorityQueue<>((a, b) -> count[b - 'a'] - count[a - 'a']);
        for(char alphabet = 'a'; alphabet <='z'; alphabet++) {
            if(count[alphabet - 'a'] > 0) {
                queue.add(alphabet);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(queue.size() >= 2) {
            char e1 = queue.poll();
            char e2 = queue.poll();
            sb.append(e1);
            sb.append(e2);
            
            if(count[e1 - 'a'] > 1) {
                count[e1 - 'a']--;
                queue.add(e1);
            }
            if(count[e2 - 'a'] > 1) {
                count[e2 - 'a']--;
                queue.add(e2);
            }
        }

        if(queue.size() > 0) {
            sb.append(queue.poll());
        }

        return sb.toString();
    }
}