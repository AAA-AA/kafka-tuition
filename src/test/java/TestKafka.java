import com.github.ren.config.KafkaTopicConfig;
import com.github.ren.service.KafkaTestService;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.Properties;

/**
 * Created by renhongqiang on 2019-06-05 17:50
 */
public class TestKafka extends BasicTest {
    @Autowired
    private KafkaTestService kafkaTestService;

    @Autowired
    private KafkaTopicConfig topicConfig;

    @Value("${spring.kafka.bootstrap-servers}")
    private String brokerUrl;


    @Test
    public void testKafka() {

        String data = "test data";
        kafkaTestService.sendMsg(topicConfig.getTopicName(), data);

    }
}
