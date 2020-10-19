import java.util.Arrays;

public class PriorityQueue {
    private int[] queue;
    private int count;

    public PriorityQueue(int capacity) {
        queue = new int[capacity];
        count = 0;
    }

    public void enqueue(int item) {
        if (isFull())
            throw new IllegalStateException();
        var i = shiftInsert(item);
        queue[i + 1] = item;
        count++;
    }

    private int shiftInsert(int item) {
        int i;
        for (i = count - 1; i >= 0; i--) {
            if (queue[i] > item)
                queue[i + 1] = queue[i];
            else
                break;
        }
        return i;
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();
        return queue[--count];
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();

        return queue[--count];
    }

    @Override
    public String toString() {
        return Arrays.toString(queue);
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == queue.length;
    }
}