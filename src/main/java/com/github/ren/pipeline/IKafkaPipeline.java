package com.github.ren.pipeline;

/**
 * Created by renhongqiang on 2019-06-10 09:40
 */
public interface IKafkaPipeline<T> {

    void process(T t);
}
