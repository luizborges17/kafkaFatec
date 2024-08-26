package kafka.luiz.kafka_producer.services;

import kafka.luiz.kafka_producer.dto.Message;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Log4j2
@RequiredArgsConstructor
@Service
public class JsonProducerService {

    private final  KafkaTemplate<String, Serializable> kafkaTemplate;

    @SneakyThrows
    public void sendMessage(Message message){
        log.info("Receive message {}", message.toString());
        Thread.sleep(1000);

        log.info("Sending message...");
        kafkaTemplate.send("fila", message).addCallback(
            success -> {
                log.info("Foi enviado ao offset {}" ,success.getRecordMetadata().offset());
                log.info("Esta na partição {}", success.getRecordMetadata().partition());
                log.info(success.getRecordMetadata().topic());
                log.info(success.getRecordMetadata().timestamp());
            },
                error -> log.error("Error send mensage")
        );
    }
}