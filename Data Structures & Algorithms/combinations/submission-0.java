class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList();
        combine(n, 1, k, new ArrayList(), res);
        return res;
    }

    private void combine(int n, int index, int k, List<Integer> currCombo, List<List<Integer>> res) {
        if(currCombo.size() == k) {
            res.add(new ArrayList(currCombo));
            return;
        }
        for(int i=index; i <= n; i++) {
            currCombo.add(i);
            combine(n, i + 1, k, currCombo, res);
            currCombo.remove(currCombo.size() - 1);
        }
    }
}