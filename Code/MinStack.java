/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
*/
 
class MinStack {

    /** initialize your data structure here. */
    Stack<StackPair> stack;
    public MinStack() {
        stack= new Stack<>();
    }
    
    public void push(int x) {
        if(stack.isEmpty()){
            stack.push(new StackPair(x,x));
            
        }
        else {
            int currMinS = stack.peek().currMin;
            stack.push(new StackPair(x,Math.min(x,currMinS)));
        }
    }
    
    public void pop() {
        if(!stack.isEmpty())
            stack.pop();
        
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().currMin;        
    }
    class StackPair{
        int val;
        int currMin;
        public StackPair(int val,int currMin){
            this.val = val;
            this.currMin = currMin;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
