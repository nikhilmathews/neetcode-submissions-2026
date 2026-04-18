class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> scores = new Stack();
        for(String operation : operations) {
            if("C".equals(operation)) {
                scores.pop();
            }
            else if("D".equals(operation)) {
                scores.push(scores.peek() * 2);
            }
            else if("+".equals(operation)) {
                int lastScore = scores.pop();
                int secondLastScore = scores.peek();
                scores.push(lastScore);
                scores.push(lastScore + secondLastScore);
            }
            else {
                scores.push(Integer.valueOf(operation));
            }
        }
        int totalSum = 0;
        while(!scores.isEmpty()) {
            totalSum += scores.pop();
        }
        return totalSum;
    }
}