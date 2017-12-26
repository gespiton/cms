package xmu.crms.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import xmu.crms.dao.SeminarDao;
import xmu.crms.entity.Course;
import xmu.crms.entity.Seminar;
import xmu.crms.exception.CourseNotFoundException;
import xmu.crms.exception.SeminarNotFoundException;
import xmu.crms.service.SeminarService;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Demo SeminarServiceImpl
 *
 * @author drafting_dreams
 * @date 2017/12/24
 */
public class SeminarServiceImpl implements SeminarService {

    // todo deleted later
    @Autowired(required = false)
    SeminarDao seminarDao;


    @Override
    public List<Seminar> listSeminarByCourseId(BigInteger courseId) throws IllegalArgumentException, CourseNotFoundException {
        if (seminarDao.getCourseById(courseId) == null) {
            throw new CourseNotFoundException();
        }
        return seminarDao.listSeminarByCourseId(courseId);
    }


    @Override
    public void deleteSeminarByCourseId(BigInteger courseId) throws IllegalArgumentException, CourseNotFoundException {
        if (seminarDao.getCourseById(courseId) == null) {
            throw new CourseNotFoundException();
        }

        List<Seminar> seminars = listSeminarByCourseId(courseId);
        for (int i = 0; i < seminars.size(); i++) {
            seminarDao.deleteTopicBySeminarId(seminars.get(i).getId());
            seminarDao.deleteSeminarGroupBySeminarId(seminars.get(i).getId());
        }

        seminarDao.deleteSeminarByCourseId(courseId);

    }


    @Override
    public Seminar getSeminarBySeminarId(BigInteger seminarId) throws IllegalArgumentException, SeminarNotFoundException {
        if (seminarDao.getSeminarBySeminarId(seminarId) == null) {
            throw new SeminarNotFoundException();
        }
        return seminarDao.getSeminarBySeminarId(seminarId);
    }

    @Override
    public void updateSeminarBySeminarId(BigInteger seminarId, Seminar seminar) throws IllegalArgumentException, SeminarNotFoundException {
        if (seminarDao.getSeminarBySeminarId(seminarId) == null) {
            throw new SeminarNotFoundException();
        }
        seminar.setId(seminarId);
        seminarDao.updateSeminarBySeminarId(seminar);
    }

    @Override
    public void deleteSeminarBySeminarId(BigInteger seminarId) throws IllegalArgumentException, SeminarNotFoundException {
        if (seminarDao.getSeminarBySeminarId(seminarId) == null) {
            throw new SeminarNotFoundException();
        }
        //删除讨论课包含的topic信息和小组信息
        seminarDao.deleteTopicBySeminarId(seminarId);
        seminarDao.deleteSeminarGroupBySeminarId(seminarId);
        //通过seminarId删除讨论课
        seminarDao.deleteSeminarBySeminarId(seminarId);
    }

    @Override
    public BigInteger insertSeminarByCourseId(BigInteger courseId, Seminar seminar) throws IllegalArgumentException, CourseNotFoundException {
        if (seminarDao.getCourseById(courseId) == null) {
            throw new CourseNotFoundException();
        }
        Course course = new Course();
        course.setId(courseId);
        seminar.setCourse(course);
        return seminarDao.insertSeminarByCourseId(seminar);
    }
}
