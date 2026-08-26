package random_coding;

import java.util.HashMap;

public class HashMapContainsValue {
    public static void main(String[] args) {
        // Creating an empty HashMap
        HashMap<Integer, String> map = new HashMap<Integer, String>();

        // Mapping string values to int keys
        map.put(10, "Geeks");
        map.put(15, "4");
        map.put(20, "Geeks");
        map.put(25, "Welcomes");
        map.put(30, "You");

        // Displaying the HashMap
        System.out.println("Initial Mappings are: " + map);

        // Checking for the Value 'Geeks'
        System.out.println("Is the value 'Geeks' present? " +
                map.containsValue("Geeks"));

        // Checking for the Value 'World'
        System.out.println("Is the value 'World' present? " + map.containsValue("World"));

    }
}
