class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack();
        for(String token : tokens) {
            if(token.equals("+")) {
                operands.push(operands.pop() + operands.pop());
            }
            else if(token.equals("-")) {
                int right = operands.pop();
                int left = operands.pop();
                operands.push(left - right);
            }
            else if(token.equals("*")) {
                operands.push(operands.pop() * operands.pop());
            }
            else if(token.equals("/")) {
                int right = operands.pop();
                int left = operands.pop();
                operands.push(left / right);
            }
            else {
                operands.push(Integer.parseInt(token));
            }
        }
        return operands.pop();
    }
}
