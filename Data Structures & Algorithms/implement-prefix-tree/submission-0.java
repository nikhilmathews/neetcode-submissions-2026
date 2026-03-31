class PrefixTree {
    PrefixTree[] children;
    boolean isWord;

    public PrefixTree() {
        children = new PrefixTree[26];
        isWord = false;
    }

    public void insert(String word) {
        PrefixTree curr = this;
        for(Character c : word.toCharArray()) {
            int index = c - 'a';
            if(curr.children[index] == null) {
                curr.children[index] = new PrefixTree();
            }
            curr = curr.children[index];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        PrefixTree curr = this;
        for(Character c : word.toCharArray()) {
            int index = c - 'a';
            if(curr.children[index] == null) {
                return false;
            }
            curr = curr.children[index];
        }
        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        PrefixTree curr = this;
        for(Character c : prefix.toCharArray()) {
            int index = c - 'a';
            if(curr.children[index] == null) {
                return false;
            }
            curr = curr.children[index];
        }
        return true;
    }
}
