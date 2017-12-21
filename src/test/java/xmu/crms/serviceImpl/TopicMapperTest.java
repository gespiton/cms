package xmu.crms.serviceImpl;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xmu.crms.ClassManagerApplication;
import xmu.crms.dao.TopicDao;
import xmu.crms.entity.Topic;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ClassManagerApplication.class)
public class TopicMapperTest {
    @Autowired
    TopicDao topicDao;

    @Test
    public void getTopicById() {
        Topic topic = topicDao.getTopicById(BigInteger.valueOf(1));
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
        Topic topic = topicDao.getTopicById(BigInteger.valueOf(1));
        topic.setDescription(randomStr);

        Boolean result = topicDao.updateTopic(topic);
        Topic updatedTopic = topicDao.getTopicById(BigInteger.valueOf(1));

        assert (result);
        assert (Objects.equals(updatedTopic.getDescription(), randomStr));
    }


    @Test
    public void insertTopicWithSeminarId() {
        Topic topic = topicDao.getTopicById(BigInteger.valueOf(1));
        String testName = "test String";
        BigInteger seminarId = BigInteger.valueOf(2);

        topic.setName(testName);
        topic.setId(null);

        topicDao.insertWithSeminarId(seminarId, topic);
        System.out.println(topic.getId());
        Topic insertedTopic = topicDao.getTopicById(topic.getId());

        assertNotNull(insertedTopic);
        assertNotNull(topic.getId());
        assertEquals(testName, insertedTopic.getName());
        assertEquals(seminarId, insertedTopic.getSeminar().getId());
    }

    @Test
    public void deleteTopic() {
        Topic topic = topicDao.getTopicById(BigInteger.valueOf(1));
        topic.setId(null);
        BigInteger seminarId = BigInteger.valueOf(2);
        topicDao.insertWithSeminarId(seminarId, topic);

        // after insert
        BigInteger insertedId = topic.getId();
        topicDao.deleteById(insertedId);

        Topic t = topicDao.getTopicById(insertedId);
        assertEquals(null, t);

    }

    @Test
    public void getTopicsBySeminarId() {
        BigInteger seminarId = BigInteger.valueOf(2);
        List<Topic> topics = topicDao.getTopicsBySeminarId(seminarId);

        assertNotNull(topics);
    }


}
