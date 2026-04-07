class TimeMap {
    Map<String, List<Pair<String, Integer>>> map;

    public TimeMap() {
        map = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) {
            map.put(key, new ArrayList());
        }
        List<Pair<String, Integer>> values = map.get(key);
        values.add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) {
            return "";
        }
        List<Pair<String, Integer>> values = map.get(key);
        int low = 0;
        int high = values.size() - 1;
        String res = "";
        while(low <= high) {
            int mid = (low + high) / 2;
            Pair<String, Integer> midVal = values.get(mid);
            if(midVal.getValue() == timestamp) {
                return midVal.getKey();
            }
            else if(midVal.getValue() > timestamp) {
                high = mid - 1;
            }
            else {
                res = midVal.getKey();
                low = mid + 1;
            }
        }
        return res;
    }
}
