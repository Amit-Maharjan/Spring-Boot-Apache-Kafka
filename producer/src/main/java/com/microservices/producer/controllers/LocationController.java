package com.microservices.producer.controllers;

import com.microservices.producer.services.KafkaService;
import com.microservices.producer.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class LocationController {
    @Autowired
    private KafkaService kafkaService;

    @PostMapping("/update")
    public ResponseEntity<?> updateLocation() {
        String randomLocation = "( " + Math.round(Math.random() * 100) + " , " + Math.round(Math.random() * 100) + " )";
        kafkaService.updateLocation(Constants.LOCATION_TOPIC_NAME, randomLocation);
        return new ResponseEntity<>(Map.of("message", "Location Updated"), HttpStatus.OK);
    }
}
