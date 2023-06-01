//package com.example.challange_chapter_7.Kafka;
//
//import com.example.challange_chapter_7.Model.TransactionEntity;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.support.KafkaHeaders;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.support.MessageBuilder;
//import org.springframework.stereotype.Service;
//
//@Service
//@Slf4j
//public class JsonKafkaProducer {
//    @Autowired
//    private KafkaTemplate<String, TransactionEntity> kafkaTemplate;
//
////    public JsonKafkaProducer(KafkaTemplate<String, TransactionEntity> kafkaTemplate) {
////        this.kafkaTemplate = kafkaTemplate;
////    }
//
//    public void SendMessage(TransactionEntity data){
//        log.info(String.format("Message sent -> ", data.toString()));
//        Message<TransactionEntity> transactionEntityMessage = MessageBuilder.withPayload(data)
//                .setHeader(KafkaHeaders.TOPIC, "javaguides")
//                .build();
//
//        kafkaTemplate.send(transactionEntityMessage);
//    }
//
//}
