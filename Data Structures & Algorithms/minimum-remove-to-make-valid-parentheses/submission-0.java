class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> lastSeenParentheses = new Stack();
        for(int i=0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(c == '(') {
                lastSeenParentheses.push(i);
            }
            else if(c == ')') {
                if(!lastSeenParentheses.isEmpty() && s.charAt(lastSeenParentheses.peek()) == '(') {
                    lastSeenParentheses.pop();
                }
                else {
                    lastSeenParentheses.push(i);
                }
            }
        }
        Set<Integer> charsToDelete = new HashSet();
        while(!lastSeenParentheses.isEmpty()) {
            charsToDelete.add(lastSeenParentheses.pop());
        }
        StringBuilder res = new StringBuilder();
        for(int i=0; i < s.length(); i++) {
            if(!charsToDelete.contains(i)) {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}