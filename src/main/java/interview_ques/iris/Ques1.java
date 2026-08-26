package interview_ques.iris;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Ques1 {
    public static void main(String[] args) {

        Map<Integer, String> map = new ConcurrentHashMap<>();
        map.put(2, "A");
        map.put(4, "B");
        map.put(6, "C");
        map.put(8, "D");
        map.put(10, "E");
        map.put(12, "F");

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if(entry.getKey() == 6) {
                map.put(7, "ASX");
            }
        }
        System.out.println(map);
    }
}
