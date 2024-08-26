package kafka.luiz.kafka_consumer.listeners;

import kafka.luiz.kafka_consumer.dto.Message;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;

@Log4j2
@Component
public class JsonConsumer {

    @SneakyThrows
    @KafkaListener(groupId = "group-id", topics = "fila", containerFactory = "jsonContainerFactory")
    public void listener(@Payload Message message){
        log.info("Receiving message....");
        sleep(2000);

        log.info("Received message: {}", message.toString());
        sleep(2000);

    }
}
