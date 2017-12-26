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
import xmu.crms.entity.*;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ClassManagerApplication.class)
public class TopicMapperTest {
    @Autowired
    TopicDao topicDao;

    @Test
    public void getTopicById() {
        Topic topic = topicDao.getTopicById(BigInteger.valueOf(1));
        testTopic(topic);
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
        testTopic(updatedTopic);
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
        testTopic(insertedTopic);
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
        testTopic(oneTopic);
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
        //todo test seminar group topic
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


    void testTopic(Topic topic) {
        assertNotNull(topic);
        assertNotNull(topic.getId());
        assertNotNull(topic.getName());
        assertNotNull(topic.getDescription());
        assertNotNull(topic.getGroupNumberLimit());
        assertNotNull(topic.getGroupStudentLimit());
        assertNotNull(topic.getSeminar());
        Seminar seminar = topic.getSeminar();
        testSeminar(seminar);
    }

    void testSeminar(Seminar seminar) {
        assertNotNull(seminar.getId());
        assertNotNull(seminar.getName());
        assertNotNull(seminar.getDescription());
        assertNotNull(seminar.getStartTime());
        assertNotNull(seminar.getEndTime());
        assertNotNull(seminar.getFixed());
        assertNotNull(seminar.getCourse());

        Course course = seminar.getCourse();
        testCourse(course);
    }

    void testCourse(Course course) {
        assertNotNull(course.getId());
        assertNotNull(course.getName());
        assertNotNull(course.getStartDate());
        assertNotNull(course.getEndDate());
        assertNotNull(course.getTeacher());
        assertNotNull(course.getDescription());
        assertNotNull(course.getReportPercentage());
        assertNotNull(course.getPresentationPercentage());
        assertNotNull(course.getFivePointPercentage());
        assertNotNull(course.getFourPointPercentage());
        assertNotNull(course.getThreePointPercentage());

        User user = course.getTeacher();
        testUser(user);

    }

    void testUser(User user) {
        assertNotNull(user.getId());
        assertNotNull(user.getPhone());
        // database default to null
//        assertNotNull(user.getWechatId());
//        assertNotNull(user.getOpenid());
//        assertNotNull(user.getAvatar());
        assertNotNull(user.getPassword());
        assertNotNull(user.getName());
        assertNotNull(user.getSchool());
        assertNotNull(user.getGender());
        assertNotNull(user.getType());
        assertNotNull(user.getNumber());
        assertNotNull(user.getEducation());
        assertNotNull(user.getTitle());
        assertNotNull(user.getEmail());

        School school = user.getSchool();
        testSchool(school);
    }

    void testSchool(School school) {
        assertNotNull(school.getId());
        assertNotNull(school.getName());
        assertNotNull(school.getProvince());
        assertNotNull(school.getCity());
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
