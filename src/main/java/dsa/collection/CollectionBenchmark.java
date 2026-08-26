package dsa.collection;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class CollectionBenchmark {
    public static void main(String[] args) {
        int numElements = 10000;
        List<String> data = new ArrayList<>();
        for (int i = 0; i < numElements; i++) {
            data.add("Instance" + (i % 5000)); // 5000 unique, 10000 total
        }

        // --- CopyOnWriteArrayList simulation ---
        CopyOnWriteArrayList<String> cwal = new CopyOnWriteArrayList<>();
        long start = System.nanoTime();
        for (String item : data) {
            if (!cwal.contains(item)) {
                cwal.add(item);
            }
        }
        long timeCwal = System.nanoTime() - start;

        // --- CopyOnWriteArraySet simulation ---
        CopyOnWriteArraySet<String> cwas = new CopyOnWriteArraySet<>();
        start = System.nanoTime();
        for (String item : data) {
            cwas.add(item); // deduplicates automatically
        }
        long timeCwas = System.nanoTime() - start;

        // --- ConcurrentHashMap.newKeySet() simulation ---
        Set<String> chms = Collections.newSetFromMap(new java.util.concurrent.ConcurrentHashMap<>());
        start = System.nanoTime();
        for (String item : data) {
            chms.add(item); // deduplicates automatically
        }
        long timeChms = System.nanoTime() - start;

        System.out.println("CopyOnWriteArrayList: " + timeCwal/1_000_000 + " ms, size: " + cwal.size());
        System.out.println("CopyOnWriteArraySet: " + timeCwas/1_000_000 + " ms, size: " + cwas.size());
        System.out.println("ConcurrentHashMap.newKeySet(): " + timeChms/1_000_000 + " ms, size: " + chms.size());
    }
}
