package xmu.crms.dao;

import xmu.crms.entity.Topic;

/**
 * @author shin
 */
public interface TopicDao {
    Topic getTopicById(long id);

    Boolean updateTopic(Topic topic);
}
