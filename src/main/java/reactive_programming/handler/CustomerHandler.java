package reactive_programming.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactive_programming.dao.CustomerDao;
import reactive_programming.dto.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerHandler {


    @Autowired
    private CustomerDao customerDao;

    public Mono<ServerResponse> loadCustomersList(ServerRequest serverRequest) {
        Flux<Customer> customersList = customerDao.getCustomersList();
        return ServerResponse
                .ok()
                .body(customersList, Customer.class);
    }


    public Mono<ServerResponse> findCustomer(ServerRequest serverRequest) {
        int customerId = Integer.valueOf(serverRequest.pathVariable("input"));
        // Mono<Customer> filter = customerDao.getCustomersList().filter(c -> c.getId() == customerId).next();
        Mono<Customer> customerMono =
                customerDao.getCustomersList().filter(c -> c.getId() == customerId).take(1).single();
        return ServerResponse.ok().body(customerMono, Customer.class);

    }

    public Mono<ServerResponse> saveCustomer(ServerRequest request) {
        Mono<Customer> customerMono = request.bodyToMono(Customer.class);
        Mono<String> saveResponse = customerMono.map(dto -> dto.getId() + ":" + dto.getName());
        return ServerResponse.ok().body(saveResponse, Customer.class);
    }}
