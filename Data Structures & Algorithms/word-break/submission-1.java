class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dictionary = new HashSet(wordDict);
        Map<Pair<Integer, Integer>, Boolean> memo = new HashMap();
        return wordBreak(s, 0, 0, dictionary, memo);
    }
    private boolean wordBreak(String s, int leftIndex, int rightIndex, Set<String> wordDict, Map<Pair<Integer, Integer>, Boolean> memo) {
        if(rightIndex == s.length() - 1) {
            return wordDict.contains(s.substring(leftIndex, rightIndex + 1));
        }
        Pair<Integer, Integer> pair = new Pair(leftIndex, rightIndex);
        if(memo.containsKey(pair)) {
            return memo.get(pair);
        }
        String substring = s.substring(leftIndex, rightIndex + 1);
        if(wordDict.contains(substring)) {
            memo.put(pair, wordBreak(s, rightIndex + 1, rightIndex + 1, wordDict, memo) || wordBreak(s, leftIndex, rightIndex + 1, wordDict, memo));
        } else {
            memo.put(pair, wordBreak(s, leftIndex, rightIndex + 1, wordDict, memo));
        }
        return memo.get(pair);
    }
}
