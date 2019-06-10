package com.github.ren.pipeline.impl;

import com.github.ren.domain.KafkaOrder;
import com.github.ren.pipeline.IKafkaPipeline;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by renhongqiang on 2019-06-10 09:48
 */
@Slf4j
@Service
public class OrderHandlePipeline implements IKafkaPipeline<KafkaOrder> {
    @Override
    public void process(KafkaOrder kafkaOrder) {
        log.info("-------Order Handler Pipeline-----{}", kafkaOrder);
    }
}
