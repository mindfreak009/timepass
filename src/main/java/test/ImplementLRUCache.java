package test;

import java.util.*;

public class ImplementLRUCache<K,V> {

    private int capacity;
    private Map<K, V> cacheMap;
    private List<K> lruList;

    public ImplementLRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        this.lruList = new LinkedList<>();
    }

    public V get(K key) {
        if(!cacheMap.containsKey(key)) {
            return null;
        }
        // Move the recently accessed key to the last (least recently used)
        lruList.remove(key);
        lruList.addLast(key);
        return cacheMap.get(key);
    }

    public void put(K key, V value) {
         if(cacheMap.containsKey(key)){
            // If the key exists, update its value and move it to the end (recently used)
             cacheMap.put(key,value);
             lruList.remove(key);
             lruList.addLast(key);
         } else {
             if(cacheMap.size() >= capacity) {
                 // If cache is full, remove the least recently used element (first in the list)
                 K lruKey = lruList.removeFirst();
                 cacheMap.remove(lruKey);
             }
         }

        cacheMap.put(key, value);
        lruList.addLast(key);
    }

    public static void main(String[] args) {
        ImplementLRUCache<Integer, String> cacheMap = new ImplementLRUCache<>(3);
        cacheMap.put(1, "One");
        cacheMap.put(2, "Two");
        cacheMap.put(3, "Three");
        System.out.println(cacheMap.get(1)); // Output: One
        System.out.println(cacheMap.get(2)); // Output: Two
        System.out.println(cacheMap.get(3)); // Output: Three

        for (Map.Entry<Integer, String> map : cacheMap.cacheMap.entrySet()) {
            System.out.println(map.getKey() + " : " + map.getValue());
        }
        cacheMap.put(4, "Four");
        for (Map.Entry<Integer, String> map : cacheMap.cacheMap.entrySet()) {
            System.out.println(map.getKey() + " : " + map.getValue());
        }
        System.out.println(cacheMap.get(1));
        System.out.println(cacheMap.get(2));
        System.out.println(cacheMap.get(3));
        System.out.println(cacheMap.get(4));
        cacheMap.put(5, "Five");
        for (Map.Entry<Integer, String> map : cacheMap.cacheMap.entrySet()) {
            System.out.println(map.getKey() + " : " + map.getValue());
        }
        System.out.println(cacheMap.get(5));
        System.out.println(cacheMap.get(1));
        System.out.println(cacheMap.get(2));
        System.out.println(cacheMap.get(3));
        System.out.println(cacheMap.get(4));


    }
}
