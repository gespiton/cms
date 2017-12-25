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
        // TODO Auto-generated method stub
        if(!(userId.intValue() > 0)) {
            throw new IllegalArgumentException("用户ID格式错误！");
        }
        List<Course> courseList = courseDao.listCourseByUserId(userId);
        if(courseList == null) {
            throw new CourseNotFoundException("没有找到课程！");
        }
        return courseList;
    }


    @Override
    public BigInteger insertCourseByUserId(BigInteger userId, Course course) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Course getCourseByCourseId(BigInteger courseId) throws IllegalArgumentException, CourseNotFoundException {
        return null;
    }

    @Override
    public void updateCourseByCourseId(BigInteger courseId, Course course) {

    }

    @Override
    public void deleteCourseByCourseId(BigInteger courseId) throws IllegalArgumentException, CourseNotFoundException {

    }

    @Override
    public List<Course> listCourseByCourseName(String courseName) {
        return null;
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
