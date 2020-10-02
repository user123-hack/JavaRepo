import java.util.Stack;

public class QueueWithStacks {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int item){
        stack1.add(item);

    }

    public int dequeue(){

        if (isEmpty())
            throw new IllegalStateException();

        iteration();
         return stack2.pop();
    }

        public int peek(){

        if (isEmpty())
            throw new IllegalStateException();

        iteration();
        return stack2.peek();
    }

    public boolean isEmpty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public void iteration(){
        if (stack2.isEmpty())
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());

    }
}


