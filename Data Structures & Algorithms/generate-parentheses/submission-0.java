class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> validCombos = new ArrayList();
        generateParenthesis(n, new StringBuilder(), 0, 0, validCombos);
        return validCombos;
    }

    private void generateParenthesis(int n, StringBuilder currCombo, int openCount, int closeCount, List<String> validCombos) {
        if(closeCount > openCount) {
            return;
        }
        if(currCombo.length() == 2 * n) {
            if(openCount == closeCount) {
                validCombos.add(currCombo.toString());
            }
            return;
        }
        currCombo.append("(");
        generateParenthesis(n, currCombo, openCount + 1, closeCount, validCombos);
        currCombo.deleteCharAt(currCombo.length() - 1);

        currCombo.append(")");
        generateParenthesis(n, currCombo, openCount, closeCount + 1, validCombos);
        currCombo.deleteCharAt(currCombo.length() - 1);
    }
}
