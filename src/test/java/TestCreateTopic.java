import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;

/**
 * Created by renhongqiang on 2019-06-05 19:40
 */
public class TestCreateTopic extends BasicTest {
    public static final String NEW_TOPIC = "topic-test2";
    private static final String brokerUrl = "10.231.50.8:23310";

    private static AdminClient adminClient;

    @BeforeClass
    public static void beforeClass(){
        Properties properties = new Properties();
        properties.put(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG, brokerUrl);
        adminClient = AdminClient.create(properties);
    }

    @AfterClass
    public static void afterClass(){
        adminClient.close();
    }

    @Test
    public void createTopics() {
        NewTopic newTopic = new NewTopic(NEW_TOPIC,4, (short) 1);
        Collection<NewTopic> newTopicList = new ArrayList<>();
        newTopicList.add(newTopic);
        adminClient.createTopics(newTopicList);
    }
}
