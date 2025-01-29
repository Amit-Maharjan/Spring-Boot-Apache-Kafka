package com.microservices.consumer.configs;

import com.microservices.consumer.utils.Constants;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConfig {
    @KafkaListener(topics = Constants.LOCATION_TOPIC_NAME, groupId = Constants.LOCATION_GROUP_ID)
    public void updatedLocation(String location) {
        System.out.println("location = " + location);
    }
}
