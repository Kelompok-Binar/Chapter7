package com.example.challange_chapter_7.Kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {
    @KafkaListener(topics = "javaguides", groupId = "myGroup")
    public void consume(String message){
        log.info(String.format("Message recived -> %s", message));
    }
}
