package kafka.luiz.kafka_producer.services;

import kafka.luiz.kafka_producer.dto.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    JsonProducerService jsonProducerService;

    @GetMapping(value = "/message")
    public void enviaMensagem() {
        for (Integer i = 1; i <= 10; i++) {
            jsonProducerService.sendMessage(new Message("Luiz", "Giuliano", "texto", i.toString()));
        }
    }
}
