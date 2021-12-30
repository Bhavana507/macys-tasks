package com.example.CustomerDetails.service;

import com.example.CustomerDetails.CustomerDetailsApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PubSubService {

    @Autowired
    private CustomerDetailsApplication.PubsubOutboundGateway messagingGateway;

    public void publishMessage(String json){
        messagingGateway.sendToPubsub(json);
    }
}
