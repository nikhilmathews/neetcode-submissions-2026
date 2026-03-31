class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap();
        for(String word : strs) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);
            if(anagrams.containsKey(sortedString)) {
                List<String> matchingAnagrams = anagrams.get(sortedString);
                matchingAnagrams.add(word);
            }
            else {
                List<String> matchingStrings = new ArrayList();
                matchingStrings.add(word);
                anagrams.put(sortedString, matchingStrings);
            }
        }
        List<List<String>> grouped = new ArrayList();
        for(List<String> anagram : anagrams.values()) {
            grouped.add(anagram);
        }
        return grouped;
    }
}
