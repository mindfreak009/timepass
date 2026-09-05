package interview_ques.productbased.mastercard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class CacheEntry<V>{
     V value;
     // absolute timestamp (“At what exact time should this item die?”)
     long expiryTime;

    // original ttl duration  ("How long the item should survive?")
    long ttlMillis;

    CacheEntry(V value, long ttlMillis) {
        this.value = value;
        this.ttlMillis = ttlMillis;

        // No expiry
        if (ttlMillis <= 0){
            this.expiryTime = -1;    // Infinite expiry
        } else {
            //  current time = 1000
            //  ttl = 5000
            //  expiry = 6000
            this.expiryTime = System.currentTimeMillis() + ttlMillis;
        }
    }

}
public class LRUCacheWithExpiryTime<K,V> {
    private int capacity;

    // key -> entry
    private final Map<K, CacheEntry<V>> cacheMap;

    // maintains LRU order
    // Most recently used -> end
    private final LinkedList<K> lruList;

    public LRUCacheWithExpiryTime(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        this.lruList = new LinkedList<>();
    }


    public synchronized void put(K key, V value, long ttlMillis) {
        // if key already exists
        if(cacheMap.containsKey(key)){
            cacheMap.put(key, new CacheEntry<>(value, ttlMillis));

            // Move to recently used
            lruList.remove(key);
            lruList.addLast(key);
        }

        // evict LRU if capacity reached
        if(cacheMap.size() >= capacity) {
            K lruKey = lruList.removeFirst();
            cacheMap.remove(lruKey);
        }
        /** Insert new entry in both cacheMap and lruList **/
        cacheMap.put(key, new CacheEntry<>(value, ttlMillis));
        lruList.addLast(key);
    }

    /** Put without expiry **/
    public synchronized void put(K key , V value) {
        put(key, value, -1);
    }

    /** Expiry validation helper **/
    public boolean isExpired(CacheEntry<V> entry) {
        return entry.expiryTime > 0 && System.currentTimeMillis() > entry.expiryTime;
    }

    /**
     * Returns:
     * - value if present and not expired
     * - null otherwise
     *
     * Also:
     * - moves item to MRU
     * - resets expiry timer
     */
    public synchronized V get(K key) {
        if(!cacheMap.containsKey(key)) {
            return null;
        }
        CacheEntry<V> entry  = cacheMap.get(key);

        // check expiry
        if(isExpired(entry)) {
            cacheMap.remove(key);
            lruList.remove(key);
            return null;
        }

        // Reset expiry on access
        if(entry.ttlMillis > 0) {
            entry.expiryTime = System.currentTimeMillis() + entry.ttlMillis;
        }

        // Move to recently used
        lruList.remove(key);
        lruList.addLast(key);

        return entry.value;
    }

    /** Remove key from cache **/
    public synchronized void remove(K key) {
        cacheMap.remove(key);
        lruList.remove(key);
    }

    public static void main(String[] args) throws Exception {
        LRUCacheWithExpiryTime<String, String> cache = new LRUCacheWithExpiryTime<>(2);

        // A expires in 3 seconds
        cache.put("A", "Apple", 3000);

        // B never expires
        cache.put("B", "Ball");

        System.out.println(cache.get("A"));  // Output: Apple
        Thread.sleep(2000);

        // Access resets expiry timer
        System.out.println(cache.get("A"));   // Output: Apple
        Thread.sleep(2000);

        // Still alive because timer reset
        System.out.println(cache.get("A"));  // Output: Apple

        // Insert C
        cache.put("C", "Cat");

        // B should be evicted (LRU)
        System.out.println(cache.get("B"));  // Output: null

        System.out.println(cache.get("C"));  // Output: Cat

        // Remove A manually
        cache.remove("A");

        System.out.println(cache.get("A"));  // Output: null

    }
}
