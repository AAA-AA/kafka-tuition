package com.github.ren.pipeline;

import com.github.ren.pipeline.impl.CenterHandlePipeline;
import com.github.ren.pipeline.impl.OrderHandlePipeline;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by renhongqiang on 2019-06-10 10:17
 */
@Slf4j
public class DefaultPipelineRegistry extends AbstractPipelineRegistry {

    static {
        register(CenterHandlePipeline.class,
                OrderHandlePipeline.class
                );
    }

    public static void init() {
        log.info("start init DefaultPipelineRegistry");
    }
}
