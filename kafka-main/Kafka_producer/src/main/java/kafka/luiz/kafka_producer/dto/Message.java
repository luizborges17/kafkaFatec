package kafka.luiz.kafka_producer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Message implements Serializable {
    String from;
    String to;
    String text;
    String subject;

}
