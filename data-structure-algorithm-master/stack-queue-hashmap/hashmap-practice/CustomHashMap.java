import java.util.*;

class CustomHashMap<K, V> {
    private static final int SIZE = 10; // Hash table size
    private List<Entry<K, V>>[] map;

    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public CustomHashMap() {
        map = new LinkedList[SIZE];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % SIZE);
    }

    public void put(K key, V value) {
        int index = hash(key);
        if (map[index] == null) {
            map[index] = new LinkedList<>();
        }

        for (Entry<K, V> entry : map[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        map[index].add(new Entry<>(key, value));
    }

    public V get(K key) {
        int index = hash(key);
        if (map[index] != null) {
            for (Entry<K, V> entry : map[index]) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        if (map[index] != null) {
            map[index].removeIf(entry -> entry.key.equals(key));
        }
    }

    public static void main(String[] args) {
        CustomHashMap<String, Integer> hashMap = new CustomHashMap<>();
        hashMap.put("One", 1);
        hashMap.put("Two", 2);
        System.out.println(hashMap.get("One")); // Output: 1
        hashMap.remove("One");
        System.out.println(hashMap.get("One")); // Output: null
    }
}
