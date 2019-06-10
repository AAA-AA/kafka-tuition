package com.github.ren.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by renhongqiang on 2019-06-10 09:46
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KafkaMsg {
    private String msgId;
    private String body;

}
