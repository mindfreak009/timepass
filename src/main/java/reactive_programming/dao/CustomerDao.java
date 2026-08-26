package reactive_programming.dao;

import org.springframework.stereotype.Component;
import reactive_programming.dto.Customer;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerDao {


    private static void sleepExecution(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // throw new RuntimeException(e);
            e.printStackTrace();
        }
    }
    public List<Customer> getCustomers() {
        return IntStream.rangeClosed(1, 50)
                .peek(CustomerDao::sleepExecution)
                .peek(i -> System.out.print("processing count :: " + i))
                .mapToObj(i -> new Customer(i, "customer" + i))
                .collect(Collectors.toList());
    }

    public Flux<Customer> getCustomersStream() {
        return Flux.range(1, 50)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.print("processing count in stream flow :: " + i))
                .map(i -> new Customer(i, "customer" + i));
               // .collect(Collectors.toList());
    }

    public Flux<Customer> getCustomersList() {
        return Flux.range(1, 50)
                .doOnNext(i -> System.out.print("processing count in stream flow :: " + i))
                .map(i -> new Customer(i, "customer" + i));
    }
}

