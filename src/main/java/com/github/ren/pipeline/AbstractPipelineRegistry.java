package com.github.ren.pipeline;

import com.github.ren.spring.SpringContext;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by renhongqiang on 2019-06-10 10:11
 */
@Slf4j
public abstract class AbstractPipelineRegistry {

    private static List<IKafkaPipeline> holder = new CopyOnWriteArrayList<>();

    protected static void register(Class<? extends IKafkaPipeline>... pipelines) {
        if (pipelines == null || pipelines.length == 0) {
            throw new IllegalArgumentException("kafkaPipeline for register can't be null");
        }
        for (Class<? extends IKafkaPipeline> pipeline : pipelines) {
            IKafkaPipeline kafkaPipeline = SpringContext.getBean(pipeline);
            if (kafkaPipeline != null) {
                log.info("-------add instance:{} to holder", kafkaPipeline);
                holder.add(kafkaPipeline);
            } else {
                log.warn("pipeline can't find instance");
            }
        }


    }

    public static List<IKafkaPipeline> getHolder() {
        return holder;
    }
}
