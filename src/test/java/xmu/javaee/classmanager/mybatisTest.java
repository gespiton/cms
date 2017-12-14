package xmu.javaee.classmanager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xmu.javaee.classmanager.coursems.dao.CourseDao;
import xmu.javaee.classmanager.coursems.model.Course;

import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ClassManagerApplication.class)
public class mybatisTest {
    @Autowired
    private CourseDao courseDao;

    @Test
    public void getAllCourse() {
        List<Course> courses = courseDao.getAllCourse();
        assertNotNull(courses);
    }


}
