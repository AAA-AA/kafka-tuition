package com.github.ren.service;

import com.github.ren.config.KafkaTopicConfig;
import com.github.ren.domain.KafkaOrder;
import com.github.ren.pipeline.DefaultPipelineRegistry;
import com.github.ren.pipeline.IKafkaPipeline;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by renhongqiang on 2019-06-05 17:19
 */
@Service
@Slf4j
public class KafkaTestService {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @KafkaListener(topicPattern = "${spring.kafka.topic.topicName}", groupId = "demo")
    public void consume(ConsumerRecord<String, String> record) {
        log.info("kafka processMessage start");
        log.info("processMessage, topic = {}, msg = {}", record.topic(), record.value());
        KafkaOrder kafkaOrder = new KafkaOrder();
        kafkaOrder.setCreatedAt(new Date());
        kafkaOrder.setOrderId(UUID.randomUUID().toString());
        kafkaOrder.setKey(record.key());

        List<IKafkaPipeline> holder = DefaultPipelineRegistry.getHolder();
        holder.forEach(e -> {
            e.process(kafkaOrder);
        });
    }

    public void sendMsg(String topic ,String data) {
        log.info("kafka sendMessage start");
        String key = UUID.randomUUID().toString();
        kafkaTemplate.send(topic,key, data);
    }
}
