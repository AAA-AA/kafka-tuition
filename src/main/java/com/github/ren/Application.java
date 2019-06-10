package com.github.ren;

import com.github.ren.pipeline.DefaultPipelineRegistry;
import com.github.ren.pipeline.IKafkaPipeline;
import com.github.ren.spring.EnableSpringContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

/**
 * Created by renhongqiang on 2019-06-05 17:05
 */
@SpringBootApplication
@EnableSpringContext
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        DefaultPipelineRegistry.init();
    }
}
