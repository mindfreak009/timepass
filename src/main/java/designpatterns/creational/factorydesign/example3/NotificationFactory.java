package designpatterns.creational.factorydesign.example3;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.Supplier;

public class NotificationFactory {

    private static final Map<String, Supplier<Notification>> registry = new HashMap<>();

        // registration method
        public static void register(
                String type,
                Supplier<Notification> supplier) {
            registry.put(type.toUpperCase(), supplier);
        }

        // factory method
        public static Notification create(String type) {
            Supplier<Notification> supplier = registry.get(type.toUpperCase());

            if(supplier == null) {
                throw new IllegalArgumentException("Invalid type");
            }
            return supplier.get();
        }
}
