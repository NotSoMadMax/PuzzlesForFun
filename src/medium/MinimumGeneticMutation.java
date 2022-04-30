class Solution {
    
    char[] GENE = new char[] {'A', 'C', 'G', 'T'};
    
    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>();
        bankSet.addAll(Arrays.asList(bank));
        
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        
        int depth = 0;
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            for(int x = 0; x < levelSize; x++) {
                String cur = queue.remove();
                if (cur.equals(end)) {
                    return depth;
                }

                for (int i = 0; i < cur.length(); i++) {
                    for(char c : GENE) {
                        char[] curChar = cur.toCharArray();
                        curChar[i] = c;
                        String mutation = String.valueOf(curChar);
                        if(bankSet.contains(mutation) && !visited.contains(mutation)) {
                            queue.add(mutation);
                            visited.add(mutation);
                        }
                    }
                }
            }
            depth++;
        }
        
        return -1;
    }
}