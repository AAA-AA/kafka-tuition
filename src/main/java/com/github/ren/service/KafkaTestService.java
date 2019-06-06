package com.github.ren.service;

import com.github.ren.config.KafkaTopicConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by renhongqiang on 2019-06-05 17:19
 */
@Service
@Slf4j
public class KafkaTestService {

    @Autowired
    private KafkaTopicConfig topicConfig;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @KafkaListener(topicPattern = "${spring.kafka.topic.topic-name}", groupId = "demo")
    public void consume(ConsumerRecord<String, String> record) {
        log.info("kafka processMessage start");
        log.info("processMessage, topic = {}, msg = {}", record.topic(), record.value());

    }

    public void sendMsg(String topic ,String data) {
        log.info("kafka sendMessage start");
        String key = UUID.randomUUID().toString();
        kafkaTemplate.send(topic,key, data);
    }
}
