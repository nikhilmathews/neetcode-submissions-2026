class Solution {
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        Map<String, String> parent = new HashMap<>();
        for (List<String> syn : synonyms) {
            String root1 = find(parent, syn.get(0));
            String root2 = find(parent, syn.get(1));
            if (!root1.equals(root2)) parent.put(root1, root2);
        }

        Map<String, TreeSet<String>> groups = new HashMap<>();
        for (List<String> syn : synonyms) {
            for (String word : syn) {
                String root = find(parent, word);
                groups.computeIfAbsent(root, k -> new TreeSet<>()).add(word);
            }
        }

        String[] words = text.split(" ");
        List<String> results = new ArrayList<>();
        generateSentences(groups, parent, words, 0, new ArrayList<>(), results);
        Collections.sort(results);
        return results;
    }

    private String find(Map<String, String> parent, String s) {
        if (!parent.containsKey(s)) parent.put(s, s);
        if (parent.get(s).equals(s)) return s;
        parent.put(s, find(parent, parent.get(s)));
        return parent.get(s);
    }

    private void generateSentences(Map<String, TreeSet<String>> groups, Map<String, String> parent, String[] words, int index, List<String> sentenceSoFar, List<String> results) {
        if (index >= words.length) {
            results.add(String.join(" ", sentenceSoFar));
            return;
        }

        String currWord = words[index];
        if (parent.containsKey(currWord)) {
            String root = find(parent, currWord);
            for (String synonym : groups.get(root)) {
                sentenceSoFar.add(synonym);
                generateSentences(groups, parent, words, index + 1, sentenceSoFar, results);
                sentenceSoFar.remove(sentenceSoFar.size() - 1);
            }
        } else {
            sentenceSoFar.add(currWord);
            generateSentences(groups, parent, words, index + 1, sentenceSoFar, results);
            sentenceSoFar.remove(sentenceSoFar.size() - 1);
        }
    }
}