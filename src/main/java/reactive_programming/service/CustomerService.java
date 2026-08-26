package reactive_programming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactive_programming.dao.CustomerDao;
import reactive_programming.dto.Customer;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerDao customerDao;

    public List<Customer> loadAllCustomers() {
       long startValue =  System.currentTimeMillis();
       List<Customer> customers = customerDao.getCustomers();
       long endValue =  System.currentTimeMillis();
       System.out.println("customers " +customers);
       System.out.println("totalTime :: " +(endValue - startValue));

       return customers;
    }

    public Flux<Customer> loadAllCustomersStream() {
        long startValue =  System.currentTimeMillis();
        Flux<Customer> customers = customerDao.getCustomersStream();
        long endValue =  System.currentTimeMillis();
        System.out.println("customers " +customers);
        System.out.println("totalTime :: " +(endValue - startValue));
        return customers;
    }
}
