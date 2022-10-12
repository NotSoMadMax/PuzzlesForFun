class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for(char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        
        Map<Character, Integer> sortedCount = count.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        // HashMap does not maintain order
        
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character, Integer> entry : sortedCount.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
}