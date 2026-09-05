package interview_ques.productbased.mastercard;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache1<K,V> extends LinkedHashMap<K,V> {

    private int capacity;

    public LRUCache1(int initialCapacity) {
        super(initialCapacity, 0.75f, true);
        this.capacity = initialCapacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache1<Integer, String> cache = new LRUCache1<>(2);
        cache.put(1, "One");
        cache.put(2, "Two");

        System.out.println(cache.get(1)); // Output: One
        System.out.println(cache.get(2)); // Output: Two

        cache.put(3, "Three");
        cache.put(4, "Four");

        System.out.println(cache.get(3)); // Output: Three
        System.out.println(cache.get(4)); // Output: Four

        for (Map.Entry<Integer, String> map : cache.entrySet()) {
            System.out.println(map.getKey() + " - " + map.getValue());
        }

        System.out.println("map size :: " + cache.size());

        System.out.println(cache.get(2)); // Output: null (Evicted from cache)
        System.out.println(cache.get(1)); // Output: null  (Evicted from cache)
        System.out.println(cache.get(3)); // Output: Three
        System.out.println(cache.get(4)); // Output: Four
    }
}
