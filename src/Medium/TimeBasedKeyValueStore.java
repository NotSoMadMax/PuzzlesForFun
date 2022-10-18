class TimeMap {
    
    private Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) {
            return "";
        }
        
        Integer target = map.get(key).floorKey(timestamp);
        if(target == null) {
            return "";
        } else {
            return map.get(key).get(target);
        }
    }
}