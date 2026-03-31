class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> operands = new Stack<>();
        for(String token : tokens) {
            if("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {
                Integer operandDos = Integer.parseInt(operands.pop());
                Integer operandUno = Integer.parseInt(operands.pop());
                if("+".equals(token)) {
                    operands.push(String.valueOf(operandUno + operandDos));
                }
                else if("-".equals(token)) {
                    operands.push(String.valueOf(operandUno - operandDos));
                }
                else if("*".equals(token)) {
                    operands.push(String.valueOf(operandUno * operandDos));
                }
                else {
                    operands.push(String.valueOf(operandUno / operandDos));
                }
            }
            else {
                operands.push(token);
            }
        }
        return Integer.parseInt(operands.pop());
    }
}
