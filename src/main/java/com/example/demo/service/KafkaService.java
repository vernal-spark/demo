package com.example.demo.service;

import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
    @Autowired
    KafkaTemplate kafkaTemplate;
    String topicName="product";
    public void send(Product product){
        kafkaTemplate.send(topicName,product);
    }
}
