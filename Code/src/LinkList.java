import java.util.NoSuchElementException;

class Linklist {
    private Node first;
    private Node last;
    private int size;

    private static class Node {
        private int value;
        private Node next;

        public Node( int value){
            this.value = value;
        }
    }

    public void addFirst(int element){
        Node node = new Node(element);
        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }
        size++;
    }

    public void addLast(int element){
        Node node = new Node(element);
        if (isEmpty())
            first = last = node;
        else {
            last.next=node;
            last = node;
        }
        size++;
    }

    public void deleteFirst(){
        if (isEmpty())
            throw new NoSuchElementException();
        if(first==last)
            first = last =null;
        else {
            Node second = first.next;
            first.next = null;
            first = second;
        }
        size--;
    }

    public void deleteLast(){
        if  (isEmpty())
            throw new NoSuchElementException();
        if (first == last)
            first = last = null;
        else{
            Node previousNode = getPrevious(last);
            previousNode.next = null;
            last = previousNode;
        }
        size--;
    }

    private Node getPrevious(Node node) {
        Node current = first;
        while (current.next != node)
            current = current.next;
        return current;
    }

    public int indexOf(int element){
        int index=0;
        Node current =first;

        if (isEmpty())
            throw new NoSuchElementException();

        while (current != null){

            if(element == current.value)
                return index;

            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int element){
        return indexOf(element) != -1;
    }

    @Override
    public String toString() {
        Node temp =first;
        System.out.print("[");
        while(temp != null) {
            System.out.print(temp.value);
            if(temp != last)
                System.out.print(",");
            temp = temp.next;
        }
        return "]";
    }

    public int[] toArray(){
        Node current = first;
        int index = 0;
        var array = new int[size];

        while (current != null){
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return size;
    }

    public void reverse(){
        if (isEmpty())
            return;

        Node current = first.next;
        Node previous =first;
        while(current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        last = first;
        last.next = null;
        first = previous;
    }

    public int  getKthFromTheEnd(int k) {
        if (isEmpty()) throw new IllegalStateException();

        var slow = first;
        var fast = first;

        for (int i =0;i<(k-1);i++){
            fast = fast.next;
            if(fast == null)
                throw new IllegalArgumentException();
        }
        while(fast != last){
            fast = fast.next;
            slow = slow.next;
        }
        return slow.value;
    }

    public void printMiddle(){
        var slow = first;
        var fast = first;
        while(fast != last && fast.next!=last){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast == last)
            System.out.println(slow.value);
        else
            System.out.println(slow.value+" "+slow.next.value);
    }
}