import java.util.Queue;
import java.util.Stack;

public class QueueReverser<T> {
    Stack<T> stack = new Stack<>();

    public void reverse(Queue<T> queue, int k) {
        if (isKValid(k, queue))
            throw new IllegalArgumentException();
        if (queue.isEmpty())
            throw new IllegalStateException();

        for (int i = 0; i < k; i++)
            stack.push(queue.remove());

        while (!stack.isEmpty())
            queue.add(stack.pop());

        for (int i = 0; i < queue.size() - k; i++)
            queue.add(queue.remove());
    }

    private boolean isKValid(int k, Queue<T> queue) {
        return k > queue.size() || k < 0;
    }
}