public class Array {
    int size;
    private int[] items;
    private  int count;

    public Array(int length) {
        items = new int[length];
    }

    public void insert(int item){

        if (items.length == count){
            //creating new array with double the size
            int[] newItems = new int[count * 2];
            for (int i = 0; i < count; i++)
                newItems[i] = items[i];
            items = newItems;
        }
        items[count++] = item;
    }

    public void removeAt(int index){
        if (index < 0 || index > count)
            throw new IllegalArgumentException();

        for (int i = index; i < count; i++)
            items[i] = items[i+1];

        count--;
    }

    public int indexOf(int element){
        for (int i = 0; i < count; i++) {
            if (items[i] == element)
                return i;
        }
        return -1;
    }
    public void print(){
        for (int item : items) System.out.println(item);
    }

    public int check(){
        int a = 0;
        for (int i = 0;  i < count ; i++){
            if (items[i+1] > items[i])
                a = items[i+1] ;
        }
        return a;
    }

    public int[] rev() {
        int[] reverse = new int[count];
        for (int i = count; i > 0; i--) {
            for (int j = 0;  j < count; j++)
                reverse[j] = items[i];
        }
        return reverse;
    }
}