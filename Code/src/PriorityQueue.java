import java.util.Arrays;
import java.util.EmptyStackException;

public class PriorityQueue {
    int[] items = new int[5];
    int count ;
    int front;

    void insert(int item){

        if (isFull()) throw new IllegalStateException();

        var i = shiftItemsToInsert(item);
                items[i] = item;
        count++;
        }

        public int delete(){
        if (isEmpty())
            throw new EmptyStackException();

        return items[--count];
        }

  public int shiftItemsToInsert(int item) {
      int i;
      for (i = count - 1; i >= 0; i--) {
      if (isEmpty()) items[i] = item;
      else if (items[i] > item) items[i + 1] = items[i];
      else break;
    }
    return i + 1;
    }
        @Override
    public String toString(){
        return Arrays.toString(items);
        }

    boolean isEmpty(){
        return count == 0;
    }

    boolean isFull(){
        return count == items.length;
    }
}
