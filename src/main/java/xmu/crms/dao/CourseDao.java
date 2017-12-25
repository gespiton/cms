package xmu.crms.dao;

import org.springframework.stereotype.Component;
import xmu.crms.entity.Course;

import java.math.BigInteger;
import java.util.List;
/**
 * @author caistrong
 */
@Component
public interface CourseDao {
    List<Course> listCourseByUserId(BigInteger userId);
}
