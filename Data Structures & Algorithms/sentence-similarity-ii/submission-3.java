class Solution {
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if(sentence1.length != sentence2.length) {
            return false;
        }
        Map<String, String> parentMap = new HashMap();

        for(List<String> similarPair : similarPairs) {
            String word1 = similarPair.get(0);
            String word2 = similarPair.get(1);
            
            String rep1 = find(parentMap, word1);
            String rep2 = find(parentMap, word2);

            union(parentMap, rep1, rep2);
        }

        for(int i=0; i < sentence1.length; i++) {
            String word1 = sentence1[i];
            String word2 = sentence2[i];

            String rep1 = find(parentMap, word1);
            String rep2 = find(parentMap, word2);

            if(!rep1.equals(rep2)) {
                return false;
            }
        }
        return true;
    }

    private String find(Map<String, String> parentMap, String word) {
        if(!parentMap.containsKey(word)) {
            parentMap.put(word, word);
            return word;
        }
        if(parentMap.get(word).equals(word)) {
            return word;
        }
        return find(parentMap, parentMap.get(word));
    }

    private void union(Map<String, String> parentMap, String word1, String word2) {
        parentMap.put(word1, word2);
    }
}
