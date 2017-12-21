package xmu.crms.serviceImpl;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xmu.crms.ClassManagerApplication;
import xmu.crms.dao.TopicDao;
import xmu.crms.entity.Topic;

import java.util.Date;
import java.util.Objects;

import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ClassManagerApplication.class)
public class TopicMapperTest {
    @Autowired
    TopicDao topicDao;

    @Test
    public void getTopicById() {
        Topic topic = topicDao.getTopicById(1);
        assertNotNull(topic);
        assertNotNull(topic.getId());
        assertNotNull(topic.getName());
        assertNotNull(topic.getDescription());
        assertNotNull(topic.getGroupNumberLimit());
        assertNotNull(topic.getGroupStudentLimit());
        assertNotNull(topic.getSeminar());
    }

    @Test
    public void updateTopic() {
        String randomStr = new Date().toString();
        Topic topic = topicDao.getTopicById(1);
        topic.setDescription(randomStr);

        Boolean result = topicDao.updateTopic(topic);
        Topic updatedTopic = topicDao.getTopicById(1);

        assert (result);
        assert (Objects.equals(updatedTopic.getDescription(), randomStr));
    }

}
