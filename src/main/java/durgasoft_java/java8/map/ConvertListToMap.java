package durgasoft_java.java8.map;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

record Product (
        int id,
        String name,
        double price) {}

public class ConvertListToMap {
    public static void main(String[] args) {
        List<Product> productList = Arrays.asList(
                new Product(101, "Laptop", 1500.00),
                new Product(102, "Smartphone", 800.00),
                new Product(103, "Tablet", 300.00),
                new Product(103, "SSD", 200.00)
        );

        // Converting List to Map
        Map<Integer, Product> result = productList.stream()
                .collect(Collectors.toMap(
                        Product::id,
                        Function.identity(),
                        (existing, replacement) -> existing
                ));

        System.out.println(result);

    }
}
