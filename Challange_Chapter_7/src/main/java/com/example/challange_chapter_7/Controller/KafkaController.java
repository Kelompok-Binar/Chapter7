package com.example.challange_chapter_7.Controller;

//import com.example.challange_chapter_7.Kafka.JsonKafkaProducer;
import com.example.challange_chapter_7.Kafka.KafkaProducer;
import com.example.challange_chapter_7.Model.TransactionEntity;
import com.example.challange_chapter_7.Repository.TransactionInterface;
import com.example.challange_chapter_7.Service.TransactionService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(value ="/Kafka")
@Api(value = "Kafka")
public class KafkaController {
    @Autowired
    KafkaProducer kafkaProducer;
//    @Autowired
//    JsonKafkaProducer jsonKafkaProducer;
    @Autowired
    TransactionInterface transactionInterface;

//    @GetMapping()
//    public ResponseEntity<String> publish (String message){
//        kafkaProducer.sendMessage(message);
//        return ResponseEntity.ok("Message sent to the topic");
//    }

//    @GetMapping
//    public ResponseEntity<String> publish() {
//        List<TransactionEntity> messages = transactionInterface.findAll();
//        for (TransactionEntity message : messages) {
//            kafkaProducer.sendMessage(String.valueOf(message));
//        }
//        return ResponseEntity.ok("Messages sent to the topic");
//    }

    @PostMapping
    public ResponseEntity<String> publish(@RequestBody TransactionEntity transaction) {
        Optional<TransactionEntity> optionalUser = transactionInterface.findById(transaction.getUid_transaction());
        if (optionalUser.isPresent()) {
            TransactionEntity transactionEntity = optionalUser.get();
            String messageString = convertMessageToString(transactionEntity);
            kafkaProducer.sendMessage(messageString);
            return ResponseEntity.ok().body("Message sent to the topic");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private String convertMessageToString(TransactionEntity message) {
        // Implementasi konversi objek ke String di sini
        // Contoh:
        return message.toString();
    }

//    @PostMapping(value = "/Post")
//    public ResponseEntity<String> publishMessage(@RequestBody TransactionEntity transaction){
//        jsonKafkaProducer.SendMessage(transaction);
//        return ResponseEntity.ok("Json Message sent to kafka");
//    }
}
