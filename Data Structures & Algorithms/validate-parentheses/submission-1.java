class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> lastSeen = new Stack<>();
        for(int i=0; i < s.length(); i++) {
            Character curr = s.charAt(i);
            if (curr == '(' || curr == '{' || curr == '[') {
                lastSeen.push(curr);
            } else {
                if(lastSeen.isEmpty()) {
                    return false;
                }
                Character openBracket = lastSeen.pop();
                if(!isComplement(openBracket, curr)) {
                    return false;
                }
            }
        }
        return lastSeen.isEmpty();
    }

    private boolean isComplement(Character openBracket, Character closeBracket) {
        if(openBracket == '(') {
            return closeBracket == ')';
        }
        else if(openBracket == '{') {
            return closeBracket == '}';
        }
        else if(openBracket == '[') {
            return closeBracket == ']';
        }
        return false;
    }
}
