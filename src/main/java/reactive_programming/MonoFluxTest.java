package reactive_programming;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    public static void main(String[] args) {
         //   MonoFluxTest.testMono();
            MonoFluxTest.testFlux();
    }

    public static void testMono() {
        // Mono<String> monoString = Mono.just("lenovo");
        Mono<?> monoString = Mono.just("lenovo")
                .then(Mono.error(new RuntimeException("Exception occured")))
                .log();
        monoString.subscribe(System.out::print, e -> System.out.print(e.getMessage()));
    }

    public static void testFlux() {
        Flux<String> fluxString = Flux.just("Spring", "Spring Boot", "Microservices", "Hibernate")
                .concatWithValues("AWS")
                .concatWith(Flux.error(new RuntimeException("Exception occured in Flux")))  // Exception is thrown here
                .concatWithValues("cloud")
                .log();
        fluxString.subscribe(System.out::println);
    }

}
