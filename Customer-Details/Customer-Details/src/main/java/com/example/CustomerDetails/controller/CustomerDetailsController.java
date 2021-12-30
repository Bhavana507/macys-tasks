package com.example.CustomerDetails.controller;

import com.example.CustomerDetails.pojo.Customer;
import com.example.CustomerDetails.service.CustomerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
public class CustomerDetailsController {

    @Autowired
    private CustomerDetailsService customerService;

    @GetMapping("/customer/{id}")
    public ResponseEntity getCustomerDetails(@PathVariable Integer id){
        Optional<Customer> customer = customerService.getCustomerDetails(id);
        if (customer.isPresent()) {
            return new ResponseEntity<>(customer.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
