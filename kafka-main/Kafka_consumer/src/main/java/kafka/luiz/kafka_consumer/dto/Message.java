package kafka.luiz.kafka_consumer.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Message implements Serializable {
    String from;
    String to;
    String text;
    String subject;
}
