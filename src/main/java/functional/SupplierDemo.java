package functional;

import java.time.LocalDateTime;
import java.util.function.Supplier;

class SupplierImpl implements Supplier<LocalDateTime> {


    @Override
    public LocalDateTime get() {
        return LocalDateTime.now();
    }
}
public class SupplierDemo {
    public static void main(String[] args) {
        Supplier<LocalDateTime> supplier = new SupplierImpl();
        System.out.println(supplier.get());

        Supplier<LocalDateTime> supplier2 = () ->  LocalDateTime.now();
        System.out.println("supplier2 :: " +supplier2.get());


    }
}
