class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap();
        for(String word : strs) {
            int[] charCount = new int[26];
            for(Character c : word.toCharArray()) {
                charCount[c - 'a']++;
            }
            String counterKey = Arrays.toString(charCount);
            anagrams.putIfAbsent(counterKey, new ArrayList());
            anagrams.get(counterKey).add(word);
        }
        return new ArrayList(anagrams.values());
    }
}
