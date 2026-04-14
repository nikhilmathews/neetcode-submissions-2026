class RandomizedSet {
    Map<Integer, Integer> valIndex;
    List<Integer> vals;

    public RandomizedSet() {
        valIndex = new HashMap();
        vals = new ArrayList();
    }
    
    public boolean insert(int val) {
        if(!valIndex.containsKey(val)) {
            valIndex.put(val, vals.size());
            vals.add(val);
        }
        return false;
    }
    
    public boolean remove(int val) {
        if(valIndex.containsKey(val)) {
            int index = valIndex.get(val);
            int lastNum = vals.get(vals.size() - 1);
            valIndex.put(lastNum, index);
            vals.set(index, lastNum);
            vals.remove(vals.size() - 1);
            valIndex.remove(val);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        int randIndex = (int) Math.random() * (vals.size() - 1);
        return vals.get(randIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */