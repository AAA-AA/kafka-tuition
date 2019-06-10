package com.github.ren.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by renhongqiang on 2019-06-05 17:17
 */
@Configuration
@ConfigurationProperties("spring.kafka.topic")
public class KafkaTopicConfig {
    private String groupId;
    private String topicName;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }
}
