package interview_ques.productbased.mastercard;

import java.util.*;

public class LRUCache<K, V> {
    private final int capacity;
    private final Map<K, V> cacheMap;
    private final LinkedList<K> lruList;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cacheMap = new HashMap<>();
        lruList = new LinkedList<>();
    }

    public V get(K key) {
        if (!cacheMap.containsKey(key)) {
            return null;
        }
        // Move the accessed key to the end of the list (recently used)
        lruList.remove(key);
        lruList.addLast(key);
        return cacheMap.get(key);
    }

    public void put(K key, V value) {
        if (cacheMap.containsKey(key)) {
            // If the key exists, update its value and move it to the end (recently used)
            cacheMap.put(key, value);
            lruList.remove(key);
            lruList.addLast(key);
        } else {
            if (cacheMap.size() >= capacity) {
                // If the cache is full, remove the least recently used element (first in the list)
                K lruKey = lruList.removeFirst();
                cacheMap.remove(lruKey);
            }

            // Add the new key-value pair
            cacheMap.put(key, value);
            lruList.addLast(key);
        }
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(2);

        cache.put(1, "One");
        cache.put(2, "Two");

        System.out.println(cache.get(1)); // Output: One
        System.out.println(cache.get(2)); // Output: Two

        cache.put(3, "Three");

        System.out.println(cache.get(3)); // Output: Three

        for (Map.Entry<Integer, String> map : cache.cacheMap.entrySet()) {
            System.out.println(map.getKey() + " ::: " +map.getValue());
        }

        System.out.println(cache.get(2)); // Output: Two    (Still in cache)
        System.out.println(cache.get(1)); // Output: null   (Evicted from cache)
        System.out.println(cache.get(3)); // Output: Three   (still in cache)
        System.out.println(cache.get(4)); // Output: Four   (still in cache)
    }
}

