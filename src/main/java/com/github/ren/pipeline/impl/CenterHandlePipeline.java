package com.github.ren.pipeline.impl;

import com.github.ren.domain.KafkaOrder;
import com.github.ren.pipeline.IKafkaPipeline;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by renhongqiang on 2019-06-10 09:43
 */
@Service
@Slf4j
public class CenterHandlePipeline implements IKafkaPipeline<KafkaOrder> {

    @Override
    public void process(KafkaOrder kafkaMsg) {

        log.info("------This is Center Process----------{}", kafkaMsg);
    }
}
