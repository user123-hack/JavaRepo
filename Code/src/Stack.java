import java.util.Arrays;

public class Stack {
    //push
    //pop
    //peek
    //isEmpty
    //int[]
    int[] array = new int[5];
    int count = 0;

    public void push(int item){
        if (count == array.length)
            throw new StackOverflowError();

        array[count] = item;
        count++;
    }

    public int pop(){
        if (count == 0)
            throw new IllegalArgumentException();
        return array[--count];
    }

    public int peek(){
        if (count == 0)
            throw new IllegalStateException();
        return array[count - 1];
    }

    public boolean isEmpty(){
        return count == 0;
    }
    @Override
    public String toString(){

        var content = Arrays.copyOfRange(array, 0, count);
        return Arrays.toString(content);
    }
}
