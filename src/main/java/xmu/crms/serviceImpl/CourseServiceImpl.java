package xmu.crms.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xmu.crms.dao.CourseDao;
import xmu.crms.entity.ClassInfo;
import xmu.crms.entity.Course;
import xmu.crms.exception.CourseNotFoundException;
import xmu.crms.service.CourseService;

import java.math.BigInteger;
import java.util.List;
/**
 * @author caistrong
 */
@Component
public class CourseServiceImpl implements CourseService{
    @Autowired
    CourseDao courseDao;

    @Override
    public List<Course> listCourseByUserId(BigInteger userId) throws IllegalArgumentException, CourseNotFoundException {
        if(!(userId.intValue() > 0)) {
            throw new IllegalArgumentException("用户ID格式错误！");
        }
        List<Course> courseList = courseDao.listCourseByUserId(userId);
        if(courseList == null) {
            throw new CourseNotFoundException();
        }
        return courseList;
    }


    @Override
    public BigInteger insertCourseByUserId(BigInteger userId,Course course) throws IllegalArgumentException {
        if(!(userId.intValue() > 0)) {
            throw new IllegalArgumentException("用户ID格式错误！");
        }
        course.getTeacher().setId(userId);
        Integer courseId = courseDao.insertCourseByUserId(course);
        return BigInteger.valueOf(courseId);
}

    @Override
    public Course getCourseByCourseId(BigInteger courseId) throws IllegalArgumentException, CourseNotFoundException {
        if(!(courseId.intValue() > 0)) {
            throw new IllegalArgumentException("课程ID格式错误！");
        }
        Course course = courseDao.getCourseByCourseId(courseId);
//        if(course == null) {
//            throw new CourseNotFoundException();
//        }
        return course;
    }

    @Override
    public void updateCourseByCourseId(BigInteger courseId, Course course) {
        course.setId(courseId);
        courseDao.updateCourseByCourseId(course);
    }

    @Override
    public void deleteCourseByCourseId(BigInteger courseId) throws IllegalArgumentException, CourseNotFoundException {
        if(!(courseId.intValue() > 0)) {
            throw new IllegalArgumentException("用户ID格式错误！");
        }
        int matchDeleteLines = courseDao.deleteCourseByCourseId(courseId);
		if(matchDeleteLines == 0)
			throw new CourseNotFoundException();
    }

    @Override
    public List<Course> listCourseByCourseName(String courseName) {
        List<Course> courseList = courseDao.listCourseByCourseName(courseName);
        return courseList;
    }

    @Override
    public List<ClassInfo> listClassByCourseName(String courseName) {
        return null;
    }

    @Override
    public List<ClassInfo> listClassByTeacherName(String teacherName) {
        return null;
    }

    @Override
    public List<ClassInfo> listClassByUserId(BigInteger userId) throws IllegalArgumentException, CourseNotFoundException, ClassNotFoundException {
        return null;
    }
}
