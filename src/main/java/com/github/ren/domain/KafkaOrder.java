package com.github.ren.domain;

import lombok.Data;

import java.util.Date;

/**
 * Created by renhongqiang on 2019-06-10 09:49
 */
@Data
public class KafkaOrder {
    private String topic;
    private String key;
    private String orderId;
    private Date createdAt;
}
