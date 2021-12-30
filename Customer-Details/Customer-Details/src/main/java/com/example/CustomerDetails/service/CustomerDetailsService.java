package com.example.CustomerDetails.service;

import com.example.CustomerDetails.pojo.Customer;
import com.example.CustomerDetails.respository.CustomerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@Slf4j
public class CustomerDetailsService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private PubSubService pubSubService;

    public Optional<Customer> getCustomerDetails(int id){
        Optional<Customer> customer = customerRepository.findById(id);
        this.publishMessageToTopic(customer);
        return customer;
    }

    private void publishMessageToTopic(Optional<Customer> customer) {
        try{
            if(customer.isPresent()){
                String json = objectMapper.writeValueAsString(customer.get());
                pubSubService.publishMessage(json);
                log.info("Json file::"+json);
            }
        }catch (JsonProcessingException jsonProcessingException){
            log.error("error :"+jsonProcessingException);
        }
    }
}
