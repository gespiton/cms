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
    @Autowired
    SeminarDao seminarDao;

    @Autowired
    CourseServiceImpl courseService;

    @Override
    public List<Seminar> listSeminarByCourseId (BigInteger courseId) throws IllegalArgumentException, CourseNotFoundException {
        if (courseId == null) {
            throw new IllegalArgumentException("Wrong format for courseId.");
        }
        List<Seminar> seminars = new ArrayList<>();
        try {
            Course course = courseService.getCourseByCourseId(courseId);
            if (course == null) {
                throw new CourseNotFoundException();
            }
            seminars = seminarDao.listSeminarByCourseId(courseId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return seminars;
    }


    @Override
    public Boolean deleteSeminarByCourseId(BigInteger courseId) throws IllegalArgumentException, CourseNotFoundException {
        if (courseId == null) {
            throw new IllegalArgumentException("Wrong format for courseId.");
        }

        Boolean result = false;
        try {
            Course course = courseService.getCourseByCourseId(courseId);
            if (course == null) {
                throw new CourseNotFoundException();
            }

            result = seminarDao.deleteSeminarByCourseId(courseId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Seminar getMySeminarBySeminarId(BigInteger seminarId, BigInteger userId) throws IllegalArgumentException, SeminarNotFoundException {
        return null;
    }

    @Override
    public Seminar getSeminarDetailBySeminarId(BigInteger seminarId, BigInteger userId) throws IllegalArgumentException, SeminarNotFoundException {
        return null;
    }

    @Override
    public Seminar getSeminarBySeminarId(BigInteger seminarId) throws IllegalArgumentException, SeminarNotFoundException {
        if (seminarId == null) {
            throw new IllegalArgumentException("Wrong format for seminarId.");
        }


        try {
            Seminar seminar = seminarDao.getSeminarBySeminarId(seminarId);
            if (seminar != null) {
                return seminar;
            }
            throw new SeminarNotFoundException();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Boolean updateSeminarBySeminarId(BigInteger seminarId, Seminar seminar) throws IllegalArgumentException, SeminarNotFoundException {
        if (seminarId == null) {
            throw new IllegalArgumentException("Wrong format for seminarId.");
        }

        Boolean result = false;

        try {
            result = seminarDao.updateSeminarBySeminarId(seminarId, seminar);
            if (!result) {
                throw new SeminarNotFoundException();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Boolean deleteSeminarBySeminarId(BigInteger seminarId) throws IllegalArgumentException, SeminarNotFoundException {
        if (seminarId == null) {
            throw new IllegalArgumentException("Wrong format for seminarId.");
        }

        Boolean result = false;

        try {
            result = seminarDao.deleteSeminarBySeminarId(seminarId);
            if (!result) {
                throw new SeminarNotFoundException();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public BigInteger insertSeminarByCourseId(BigInteger courseId, Seminar seminar) throws IllegalArgumentException, CourseNotFoundException {
        if (courseId == null) {
            throw new IllegalArgumentException("Wrong format for courseId.");
        }

        BigInteger seminarId = new BigInteger("-1");
        try {
            Course course = courseService.getCourseByCourseId(courseId);
            if (course == null) {
                throw new CourseNotFoundException();
            }

            seminarId = seminarDao.insertSeminarByCourseId(courseId, seminar);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return seminarId;
    }
}
