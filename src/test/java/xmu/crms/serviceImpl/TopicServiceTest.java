package xmu.crms.serviceImpl;

import org.junit.Assert;
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
import xmu.crms.exception.TopicNotFoundException;
import xmu.crms.service.TopicService;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.fail;
import static org.mockito.BDDMockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ClassManagerApplication.class)
public class TopicServiceTest {
    @Autowired
    TopicService topicService;
    @Autowired
    TopicDao topicDao;


    // getTopicById
    @Test
    public void getTopicById() {

        BigInteger topicId = BigInteger.valueOf(1);
        Topic topic = null;
        try {
            topic = topicService.getTopicByTopicId(topicId);
        } catch (TopicNotFoundException e) {
            e.printStackTrace();
        }


        assertNotNull(topic);
        assertNotNull(topic.getId());
        assertNotNull(topic.getName());
        assertNotNull(topic.getDescription());
        assertNotNull(topic.getGroupNumberLimit());
        assertNotNull(topic.getGroupStudentLimit());
        assertNotNull(topic.getSeminar());
    }

    @Test
    public void getNotExistedTopic() {
        BigInteger topicId = BigInteger.valueOf(1111);
        Topic topic = null;
        Exception caughtException = null;

        try {
            topic = topicService.getTopicByTopicId(topicId);
            fail("didn't throw");
        } catch (Exception e) {
            caughtException = e;
        }

        Assert.assertTrue(caughtException instanceof TopicNotFoundException);
    }


    // updateTopic

    @Test
    public void updateTopic() {
        BigInteger topicId = BigInteger.valueOf(1);
        Topic topic = new Topic();
        Topic newTopic = null;

        String testDescription = new Date().toString();
        topic.setDescription(testDescription);

        try {
            topicService.updateTopicByTopicId(topicId, topic);
            newTopic = topicService.getTopicByTopicId(topicId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertNotNull(newTopic);
        Assert.assertEquals(testDescription, newTopic.getDescription());
    }


    //insertTopicWithSeminarId

    @Test
    public void insertTopicWithSeminarId() {
        BigInteger seminarId = BigInteger.valueOf(1);
        Topic topic = topicDao.getTopicById(BigInteger.valueOf(1));
        String testName = "test String";

        topic.setName(testName);
        topic.setId(null);

        BigInteger insertedRow = topicService.insertTopicBySeminarId(seminarId, topic);
        Topic insertedTopic = topicDao.getTopicById(topic.getId());

        Assert.assertEquals(BigInteger.valueOf(1), insertedRow);
        Assert.assertNotNull(insertedTopic);
        Assert.assertNotNull(topic.getId());
        Assert.assertEquals(testName, insertedTopic.getName());
        Assert.assertEquals(seminarId, insertedTopic.getSeminar().getId());
    }

    //listTopicBySeminarId

    @Test
    public void listTopicBySeminarId() {
        BigInteger seminarId = BigInteger.valueOf(2);
        List<Topic> topics = topicService.listTopicBySeminarId(seminarId);

        Assert.assertNotNull(topics);
    }


    // deleteTopicByTopicId
    @Test
    @DirtiesContext
    public void deleteTopicByTopicId() {
        BigInteger topicId = BigInteger.valueOf(1);
        Topic topic = null;
        try {
            topicService.deleteTopicByTopicId(topicId);
            topic = topicService.getTopicByTopicId(topicId);
        } catch (TopicNotFoundException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(null, topic);
    }


    //deleteSeminarGroupTopicById
    @Test
    @DirtiesContext
    public void deleteSeminarGroupTopicById() {
        BigInteger topicId = BigInteger.valueOf(1);
        BigInteger groupId = BigInteger.valueOf(1);


        SeminarGroupTopic info = topicDao.getTopicInfoOfGroup(topicId, groupId);
        Assert.assertNotNull(info);

        topicService.deleteSeminarGroupTopicById(topicId, groupId);
        info = topicDao.getTopicInfoOfGroup(topicId, groupId);

        Assert.assertEquals(null, info);
    }


    // deleteSeminarGroupTopicByTopicId
    @Test
    @DirtiesContext
    public void deleteSeminarGroupTopicByTopicId() {
        BigInteger topicId = BigInteger.valueOf(1);

        topicService.deleteSeminarGroupTopicByTopicId(topicId);

        // due to flaw of design, test again
        int deletedNum = topicDao.deleteAllSeminarGroupTopicsByTopicId(topicId);
        Assert.assertEquals(0, deletedNum);
    }

    // getSeminarGroupTopicById
    @Test
    public void getSeminarGroupTopicById() {
        BigInteger topicId = BigInteger.valueOf(1);
        BigInteger groupId = BigInteger.valueOf(1);

        SeminarGroupTopic info = topicService.getSeminarGroupTopicById(topicId, groupId);
        Assert.assertEquals(4, info.getPresentationGrade().intValue());
        Assert.assertEquals(1, info.getTopic().getId().intValue());
        Assert.assertEquals(1, info.getSeminarGroup().getId().intValue());
    }

    // listSeminarGroupTopicByGroupId
    @Test
    public void listSeminarGroupTopicByGroupId() {
        BigInteger groupId = BigInteger.valueOf(1);

        List<SeminarGroupTopic> topics = topicService.listSeminarGroupTopicByGroupId(groupId);

        Assert.assertNotNull(topics);
        Assert.assertTrue(topics.size() > 0);
    }

    // deleteTopicBySeminarId
    @Test
    @DirtiesContext
    public void deleteTopicBySeminarId() {
        BigInteger seminarId = BigInteger.valueOf(1);
        List<Topic> topics = topicDao.getTopicsBySeminarId(seminarId);
        Assert.assertTrue(topics.size() > 0);


        topicService.deleteTopicBySeminarId(seminarId);


        topics = topicDao.getTopicsBySeminarId(seminarId);
        Assert.assertEquals(0, topics.size());
    }


//    @Test
//    public void updateTopic() {
//        String randomStr = new Date().toString();
//        Topic topic = null;
//        try {
//            topic = topicService.getTopicByTopicId(BigInteger.valueOf(1));
//        } catch (TopicNotFoundException e) {
//            e.printStackTrace();
//        }
//        topic.setDescription(randomStr);
//
//        Boolean result = null;
//        try {
//            topicService.updateTopicByTopicId(topic.getId(), topic);
//        } catch (TopicNotFoundException e) {
//            e.printStackTrace();
//        }
//        Topic updatedTopic = null;
//
//        try {
//            updatedTopic = topicService.getTopicByTopicId(BigInteger.valueOf(1));
//        } catch (TopicNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        assert (result);
//        assert (Objects.equals(updatedTopic.getDescription(), randomStr));
//    }
//
//
//    @Test
//    public void insertTopicWithSeminarId() {
//        Topic topic = topicService.getTopicById(BigInteger.valueOf(1));
//        String testName = "test String";
//        BigInteger seminarId = BigInteger.valueOf(2);
//        seminarId.setBit(123);
//        System.out.println("===========");
//        System.out.println(seminarId);
//
//
//        topic.setName(testName);
//        topic.setId(null);
//
//        topicService.insertWithSeminarId(seminarId, topic);
//        System.out.println(topic.getId());
//        Topic insertedTopic = topicService.getTopicById(topic.getId());
//
//        assertNotNull(insertedTopic);
//        assertNotNull(topic.getId());
//        assertEquals(testName, insertedTopic.getName());
//        assertEquals(seminarId, insertedTopic.getSeminar().getId());
//    }
//
//    @Test
//    public void deleteTopic() {
//        Topic topic = topicService.getTopicById(BigInteger.valueOf(1));
//        topic.setId(null);
//        BigInteger seminarId = BigInteger.valueOf(2);
//        topicService.insertWithSeminarId(seminarId, topic);
//
//        // after insert
//        BigInteger insertedId = topic.getId();
//        topicService.deleteById(insertedId);
//
//        Topic t = topicService.getTopicById(insertedId);
//        assertEquals(null, t);
//
//    }
//
//    @Test
//    public void getTopicsBySeminarId() {
//        BigInteger seminarId = BigInteger.valueOf(2);
//        List<Topic> topics = topicService.getTopicsBySeminarId(seminarId);
//
//        assertNotNull(topics);
//    }
//
//    @Test
//    public void seminarGroupCancelTopic() {
//
//    }
//
//    @Test
//    public void getSeminarGroupTopicInfo() {
//        SeminarGroupTopic info = topicService.getTopicInfoOfGroup(BigInteger.valueOf(1), BigInteger.valueOf(1));
//        assertEquals(4, info.getPresentationGrade().intValue());
//        assertEquals(1, info.getTopic().getId().intValue());
//        assertEquals(1, info.getSeminarGroup().getId().intValue());
//    }
//
//    @Test
//    @DirtiesContext
//    public void deleteSeminarGroupTopicById() {
//        BigInteger topicId = BigInteger.valueOf(1);
//        BigInteger groupId = BigInteger.valueOf(1);
//
//
//        SeminarGroupTopic info = topicService.getTopicInfoOfGroup(topicId, groupId);
//        assertNotNull(info);
//
//        boolean result = topicService.deleteSeminarGroupTopic(topicId, groupId);
//        info = topicService.getTopicInfoOfGroup(topicId, groupId);
//
//        assertEquals(true, result);
//        assertEquals(null, info);
//    }
//
//    @Test
//    @DirtiesContext
//    public void deleteAllSeminarGroupTopicsByTopicId() {
//        BigInteger topicId = BigInteger.valueOf(1);
//
//        // this number is correspond to schema.sql
//        int topicNum = 12;
//
//        int deletedNum = topicService.deleteAllSeminarGroupTopicsByTopicId(topicId);
//
//        assertEquals(topicNum, deletedNum);
//    }
}
