package com.example.challange_chapter_7;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ChallangeChapter7Application {

    public static void main(String[] args) {
        SpringApplication.run(ChallangeChapter7Application.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate){
//        return args -> {
//            kafkaTemplate.send("javaguides","hello");
//        };
//    }

}
