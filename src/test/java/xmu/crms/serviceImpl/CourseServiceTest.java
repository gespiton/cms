package xmu.crms.serviceImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xmu.crms.entity.Course;

import java.math.BigInteger;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;

/**
 * @author caistrong
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseServiceTest {
    @Autowired
    CourseServiceImpl courseService;

    @Test
    public void listCourseByUserId() throws Exception {
        BigInteger userId = new BigInteger("1");
        List<Course> courseList = courseService.listCourseByUserId(userId);
        assertNotNull(courseList);
    }

}
