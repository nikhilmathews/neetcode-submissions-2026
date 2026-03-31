class MinStack {
    Stack<Integer> stack;
    Stack<Integer> currMin;

    public MinStack() {
        stack = new Stack();
        currMin = new Stack();
    }
    
    public void push(int val) {
        stack.push(val);
        if(currMin.isEmpty() || currMin.peek() > val) {
            currMin.push(val);
        }
        else {
            currMin.push(currMin.peek());
        }
    }
    
    public void pop() {
        stack.pop();
        currMin.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return currMin.peek();
    }
}
