class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> resultingStrings = new ArrayList();
        String[] mapping = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        letterCombos(digits, 0, mapping, new StringBuilder(), resultingStrings);
        return resultingStrings;
    }

    private void letterCombos(String digits, int index, String[] mapping, StringBuilder currString, List<String> possibleCombos) {
        if(index >= digits.length()) {
            if(currString.length() > 0) {
                possibleCombos.add(currString.toString());
            }
            return;
        }
        String chars = mapping[digits.charAt(index) - '2'];
        for(Character c : chars.toCharArray()) {
            letterCombos(digits, index + 1, mapping, currString.append(c), possibleCombos);
            currString.deleteCharAt(currString.length()-1);
        }
    }
}
