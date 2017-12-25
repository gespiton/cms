package xmu.crms.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.crms.dao.TopicDao;
import xmu.crms.entity.SeminarGroupTopic;
import xmu.crms.entity.Topic;
import xmu.crms.exception.TopicNotFoundException;
import xmu.crms.service.GradeService;
import xmu.crms.service.TopicService;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.List;

/**
 * @author shin jim
 */
@Service
public class TopicServiceImpl implements TopicService {
    private final
    TopicDao topicDao;

    // todo delete this anotation for test only
    @Autowired(required = false)
    GradeService gradeService;

    @Autowired()
    public TopicServiceImpl(TopicDao topicDao) {
        this.topicDao = topicDao;
        this.gradeService = gradeService;
    }

    @Override
    public Topic getTopicByTopicId(BigInteger topicId) throws TopicNotFoundException, IllegalArgumentException {
        if (topicId == null) {
            throw new IllegalArgumentException("id should be null");
        }

        Topic t = topicDao.getTopicById(topicId);
        if (t == null) {
            throw new TopicNotFoundException();
        }
        return t;
    }

    @Override
    public void updateTopicByTopicId(BigInteger topicId, Topic topic) throws TopicNotFoundException, IllegalArgumentException {
        if (topicId == null || topic == null) {
            throw new IllegalArgumentException();
        }

        Topic oriTopic = getTopicByTopicId(topicId);

        if (oriTopic == null) {
            throw new TopicNotFoundException();
        }

        if (topic.getSeminar() != null) {
            oriTopic.setSeminar(topic.getSeminar());
        }

        if (topic.getName() != null) {
            oriTopic.setName(topic.getName());
        }

        if (topic.getDescription() != null) {
            oriTopic.setDescription(topic.getDescription());
        }

        if (topic.getGroupNumberLimit() != null) {
            oriTopic.setGroupNumberLimit(topic.getGroupNumberLimit());
        }

        if (topic.getGroupStudentLimit() != null) {
            oriTopic.setGroupStudentLimit(topic.getGroupStudentLimit());
        }

        try {
            topicDao.updateTopic(oriTopic);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTopicByTopicId(BigInteger topicId) throws IllegalArgumentException {
        if (topicId == null) {
            throw new IllegalArgumentException();
        }

        try {
            topicDao.deleteById(topicId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Topic> listTopicBySeminarId(BigInteger seminarId) throws IllegalArgumentException {
        if (seminarId == null) {
            throw new IllegalArgumentException();
        }

        List<Topic> topics = topicDao.getTopicsBySeminarId(seminarId);
        return topics;
    }

    @Override
    public BigInteger insertTopicBySeminarId(BigInteger seminarId, Topic topic) throws IllegalArgumentException {
        if (seminarId == null || topic == null) {
            throw new IllegalArgumentException();
        }

        long inserted = topicDao.insertWithSeminarId(seminarId, topic);
        return BigInteger.valueOf(inserted);
    }

    @Override
    @NotNull
    public void deleteSeminarGroupTopicById(BigInteger groupId, BigInteger topicId) throws IllegalArgumentException {
        if (groupId == null || topicId == null) {
            throw new IllegalArgumentException();
        }

        topicDao.deleteSeminarGroupTopic(groupId, topicId);
    }

    @Override
    public void deleteSeminarGroupTopicByTopicId(BigInteger topicId) throws IllegalArgumentException {
        if (topicId == null) {
            throw new IllegalArgumentException();
        }

        topicDao.deleteAllSeminarGroupTopicsByTopicId(topicId);
    }

    @Override
    public SeminarGroupTopic getSeminarGroupTopicById(BigInteger topicId, BigInteger groupId) throws IllegalArgumentException {
        if (groupId == null || topicId == null) {
            throw new IllegalArgumentException();
        }

        return topicDao.getTopicInfoOfGroup(topicId, groupId);
    }

    @Override
    public List<SeminarGroupTopic> listSeminarGroupTopicByGroupId(BigInteger groupId) throws IllegalArgumentException {
        if (groupId == null) {
            throw new IllegalArgumentException();
        }

        return topicDao.getChosenTopicByGroupId(groupId);
    }

    @Override
    public void deleteTopicBySeminarId(BigInteger seminarId) throws IllegalArgumentException {
        if (seminarId == null) {
            throw new IllegalArgumentException();
        }

        List<Topic> topics = topicDao.getTopicsBySeminarId(seminarId);
        topics.forEach(topic -> {
            List<SeminarGroupTopic> seminarGroupTopics = topicDao.getSeminarGroupTopicsByTopicId(topic.getId());
            seminarGroupTopics.forEach(seminarGroupTopic -> {
                gradeService.deleteStudentScoreGroupByTopicId(seminarGroupTopic.getId());
                topicDao.deleteChosenTopicByGroupId(seminarGroupTopic.getSeminarGroup().getId());
            });
        });

        topicDao.deleteTopicsBySeminarId(seminarId);
    }
}
