package com.example.CustomerDetails.respository;

import com.example.CustomerDetails.pojo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Component
public class LoadCustomerDetailsIntoDatabase {

    @Autowired
    private CustomerRepository customerRepository;
    @PostConstruct
    private void initDb() {
        List<Customer> customers = Arrays.asList(new Customer(1,"Bhavana","470-111-1111","Duluth"),
                new Customer(2,"Preeti","470-111-2222","Alpharetta"),
                new Customer(3,"Divya","470-111-3333","JohnsCreek"),
                new Customer(4,"Amir","470-111-4444","Smyrna"),
                new Customer(5,"Kiran","470-111-5555","SandySprings"));
        customerRepository.saveAll(customers);
    }
}

