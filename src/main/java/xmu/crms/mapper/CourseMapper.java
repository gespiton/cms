package xmu.crms.mapper;

import org.springframework.stereotype.Component;
import xmu.crms.entity.Course;

import java.math.BigInteger;
import java.util.List;
/**
 * @author caistrong
 */
@Component
public interface CourseMapper {
    List<Course> listCourseByUserId(BigInteger userId);
    Integer insertCourseByUserId(Course course);
    Course getCourseByCourseId(BigInteger courseId);
    int updateCourseByCourseId(Course course);
    int deleteCourseByCourseId(BigInteger courseId);
    List<Course> listCourseByCourseName(String courseName);
//    List<ClassInfo> listClassByCourseName(String courseName);
//    List<ClassInfo> listClassByTeacherName(String teacherName);
//    List<ClassInfo> listClassByUserId(BigInteger userId);
}
