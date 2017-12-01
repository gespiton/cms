package xmu.javaee.classmanager.coursems.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import xmu.javaee.classmanager.coursems.vo.SimpleCourseInfo;
import xmu.javaee.classmanager.coursems.vo.TeacherInfo;

import java.util.LinkedList;
import java.util.List;

/**
 * Demo TeacherController
 *
 * @author drafting_dreams
 * @date 2017/12/01
 */
@RestController
public class TeacherController {

    @RequestMapping(value="/me", method = RequestMethod.GET)
    public TeacherInfo getTeacherInfo(){
        // TODO require teacher's own info
        return new TeacherInfo(2222, "teacher", "维瑟米尔",
                "4444","/avatar/2345.jpg");
    }

    @RequestMapping(value="/course", method = RequestMethod.GET)
    public List<SimpleCourseInfo> getCoursesInfo(){
        // TODO require teacher's courses
        SimpleCourseInfo course1 = new SimpleCourseInfo(1, "OOAD");
        SimpleCourseInfo course2 = new SimpleCourseInfo(2, "JAVA");
        List<SimpleCourseInfo> courses= new LinkedList<SimpleCourseInfo>();
        courses.add(course1);
        courses.add(course2);

        return courses;
    }
}
