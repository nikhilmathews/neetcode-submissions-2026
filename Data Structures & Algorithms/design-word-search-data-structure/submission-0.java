class WordDictionary {
    class TrieNode {
        TrieNode[] children;
        boolean isWord;

        TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(Character c : word.toCharArray()) {
            if(curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int idx, TrieNode curr) {
        if(curr == null) {
            return false;
        }
        else if(idx == word.length()) {
            return curr.isWord;
        }
        if(word.charAt(idx) != '.') {
            return search(word, idx + 1, curr.children[word.charAt(idx) - 'a']);
        } else {
            boolean found = false;
            for(TrieNode child : curr.children) {
                if(search(word, idx + 1, child)) {
                    found = true;
                }
            }
            return found;
        }
    }
}
