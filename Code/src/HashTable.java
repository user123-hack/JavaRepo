import java.util.LinkedList;

public class HashTable {

    private static class Entry {
        int key;
        String value;
        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

    }

    LinkedList<Entry>[] entries ;


    public HashTable(int length) {
        this.entries = new LinkedList[length];
    }

    public void put(int key, String value) {

        var entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
            return;
        }

        var bucket = getOrCreteBucket(key);
        bucket.add(new Entry(key, value));
    }

    public String get(int key){
        return (entries[hash(key)] == null) ? null : getEntry(key).value;
    }

    public void remove(int key){
        var bucket = getBucket(key);
        if (bucket !=null){
            var entry = getEntry(key);
            bucket.remove(entry);
            return;
        }
        throw new EmptyKeyException();
    }

    private LinkedList<Entry> getBucket(int key){
        return entries[hash(key)];
    }

    private Entry getEntry(int key){
        var bucket = getBucket(key);
        if(bucket != null) {
            for (var entry : bucket)
                if (entry.key == key) {
                    return entry;
                }
        }
        return null;
    }

    private LinkedList<Entry> getOrCreteBucket(int key){
        var index = hash(key);
        if (entries[index] == null){
            entries[index] = new LinkedList<Entry>();
            return entries[index];
        }
        return entries[index];
    }
    private int hash(int key){
        key = Math.abs(key);
        return key % entries.length;
    }
}