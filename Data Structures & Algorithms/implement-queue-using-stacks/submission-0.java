class MyQueue {
    Stack<Integer> stack;
    Stack<Integer> reverseStack;

    public MyQueue() {
        stack = new Stack<>();
        reverseStack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
    }
    
    public int pop() {
        while(!stack.isEmpty()) {
            reverseStack.push(stack.pop());
        }
        int ret = reverseStack.pop();
        while(!reverseStack.isEmpty()) {
            stack.push(reverseStack.pop());
        }
        return ret;
    }
    
    public int peek() {
        while(!stack.isEmpty()) {
            reverseStack.push(stack.pop());
        }
        int ret = reverseStack.peek();
        while(!reverseStack.isEmpty()) {
            stack.push(reverseStack.pop());
        }
        return ret;
    }
    
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */