package xmu.crms.dao;

import org.apache.ibatis.annotations.Param;
import xmu.crms.entity.Topic;

import java.math.BigInteger;
import java.util.List;

/**
 * @author shin
 */
public interface TopicDao {
    Topic getTopicById(BigInteger id);

    Boolean updateTopic(Topic topic);

    /**
     * insert topic together with seminar id
     * @param seminarId seminar id
     * @param topic topic
     * @return generated id
     */
    Long insertWithSeminarId(@Param("seminarId") BigInteger seminarId, @Param("topic") Topic topic);

    Boolean deleteById(BigInteger insertedId);

    List<Topic> getTopicsBySeminarId(BigInteger seminarId);
}
