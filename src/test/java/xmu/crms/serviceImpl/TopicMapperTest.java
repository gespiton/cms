package xmu.crms.serviceImpl;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xmu.crms.ClassManagerApplication;
import xmu.crms.dao.TopicDao;
import xmu.crms.entity.SeminarGroupTopic;
import xmu.crms.entity.Topic;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

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

    @Test
    public void seminarGroupCancelTopic() {

    }

    @Test
    public void getSeminarGroupTopicInfo() {
        SeminarGroupTopic info = topicDao.getTopicInfoOfGroup(BigInteger.valueOf(1), BigInteger.valueOf(1));
        assertEquals(4, info.getPresentationGrade().intValue());
        assertEquals(1, info.getTopic().getId().intValue());
        assertEquals(1, info.getSeminarGroup().getId().intValue());
    }

    @Test
    @DirtiesContext
    public void deleteSeminarGroupTopicById() {
        BigInteger topicId = BigInteger.valueOf(1);
        BigInteger groupId = BigInteger.valueOf(1);


        SeminarGroupTopic info = topicDao.getTopicInfoOfGroup(topicId, groupId);
        assertNotNull(info);

        boolean result = topicDao.deleteSeminarGroupTopic(topicId, groupId);
        info = topicDao.getTopicInfoOfGroup(topicId, groupId);

        assertEquals(true, result);
        assertEquals(null, info);
    }

    @Test
    @DirtiesContext
    public void deleteAllSeminarGroupTopicsByTopicId() {
        BigInteger topicId = BigInteger.valueOf(1);

        // this number is correspond to schema.sql
        int topicNum = 12;

        int deletedNum = topicDao.deleteAllSeminarGroupTopicsByTopicId(topicId);

        assertEquals(topicNum, deletedNum);
    }


}
