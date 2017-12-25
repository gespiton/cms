package xmu.crms.mapper;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xmu.crms.ClassManagerApplication;
import xmu.crms.dao.TopicDao;
import xmu.crms.entity.SeminarGroup;
import xmu.crms.entity.SeminarGroupTopic;
import xmu.crms.entity.Topic;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ClassManagerApplication.class)
public class TopicMapperTest {
    @Autowired
    TopicDao topicDao;

    @Test
    public void getTopicById() {
        Topic topic = topicDao.getTopicById(BigInteger.valueOf(1));
        Assert.assertNotNull(topic);
        Assert.assertNotNull(topic.getId());
        Assert.assertNotNull(topic.getName());
        Assert.assertNotNull(topic.getDescription());
        Assert.assertNotNull(topic.getGroupNumberLimit());
        Assert.assertNotNull(topic.getGroupStudentLimit());
        Assert.assertNotNull(topic.getSeminar());
    }

    @Test
    public void updateTopic() {
        String randomStr = new Date().toString();
        Topic topic = topicDao.getTopicById(BigInteger.valueOf(1));
        topic.setDescription(randomStr);

        Boolean result = topicDao.updateTopic(topic);
        Topic updatedTopic = topicDao.getTopicById(BigInteger.valueOf(1));

        Assert.assertNotNull(result);
        Assert.assertEquals(updatedTopic.getDescription(), randomStr);
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

        Assert.assertNotNull(insertedTopic);
        Assert.assertNotNull(topic.getId());
        Assert.assertEquals(testName, insertedTopic.getName());
        Assert.assertEquals(seminarId, insertedTopic.getSeminar().getId());
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
        Assert.assertEquals(null, t);

    }

    @Test
    public void getTopicsBySeminarId() {
        BigInteger seminarId = BigInteger.valueOf(2);
        List<Topic> topics = topicDao.getTopicsBySeminarId(seminarId);

        Assert.assertNotNull(topics);
        Assert.assertTrue(topics.size() > 0);

        Topic oneTopic = topics.get(0);
        Assert.assertNotNull(oneTopic.getId());
        Assert.assertNotNull(oneTopic.getDescription());
        Assert.assertNotNull(oneTopic.getName());
        Assert.assertNotNull(oneTopic.getSeminar());
        Assert.assertNotNull(oneTopic.getGroupNumberLimit());
        Assert.assertNotNull(oneTopic.getGroupStudentLimit());
    }

    @Test
    public void getSeminarGroupTopicInfo() {
        SeminarGroupTopic info = topicDao.getTopicInfoOfGroup(BigInteger.valueOf(1), BigInteger.valueOf(1));
        Assert.assertEquals(4, info.getPresentationGrade().intValue());
        Assert.assertEquals(1, info.getTopic().getId().intValue());
        Assert.assertEquals(1, info.getSeminarGroup().getId().intValue());
    }

    @Test
    @DirtiesContext
    public void deleteSeminarGroupTopicById() {
        BigInteger topicId = BigInteger.valueOf(1);
        BigInteger groupId = BigInteger.valueOf(1);


        SeminarGroupTopic info = topicDao.getTopicInfoOfGroup(topicId, groupId);
        Assert.assertNotNull(info);

        boolean result = topicDao.deleteSeminarGroupTopic(topicId, groupId);
        info = topicDao.getTopicInfoOfGroup(topicId, groupId);

        Assert.assertEquals(true, result);
        Assert.assertEquals(null, info);
    }

    @Test
    @DirtiesContext
    public void deleteAllSeminarGroupTopicsByTopicId() {
        BigInteger topicId = BigInteger.valueOf(1);

        // this number is correspond to schema.sql
        int topicNum = 12;

        int deletedNum = topicDao.deleteAllSeminarGroupTopicsByTopicId(topicId);

        Assert.assertEquals(topicNum, deletedNum);
    }


    @Test
    public void getSeminarGroupTopicsByGroupId() {
        BigInteger groupId = BigInteger.valueOf(1);

        List<SeminarGroupTopic> topics = topicDao.getChosenTopicByGroupId(groupId);

        Assert.assertNotNull(topics);
        Assert.assertTrue(topics.size() > 0);
    }

    @Test
    @DirtiesContext
    public void deleteAllChosenTopics() {
        BigInteger groupId = BigInteger.valueOf(1);
        topicDao.deleteChosenTopicByGroupId(groupId);

        List<SeminarGroupTopic> topics = topicDao.getChosenTopicByGroupId(groupId);
        Assert.assertEquals(0, topics.size());
    }
//    @Test
//    @DirtiesContext
//    public void deleteTopicBySeminarId() {
//        BigInteger seminarId = BigInteger.valueOf(1);
//
//        List<Topic> topics = topicDao.getTopicsBySeminarId(seminarId);
//        int oriSize = topics.size();
//
//        topicDao.deleteTopicEverywhere(seminarId);
//
//        List<Topic> afterDeleteTopics = topicDao.getTopicsBySeminarId(seminarId);
//        assert (oriSize > 0);
//        Assert.assertEquals(0, afterDeleteTopics.size());
//
//    }


}
