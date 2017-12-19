package xmu.crms.controller;

import org.springframework.web.bind.annotation.*;
import xmu.crms.coursems.vo.output.SimpleCourse;
import xmu.crms.coursems.vo.output.CourseClassOutput;
import xmu.crms.coursems.vo.output.CourseSeminarOutput;
import xmu.crms.coursems.vo.output.SeminarForTeacher;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

/**
 * Demo CourseController
 *
 * @author drafting_dreams
 * @date 2017/12/01
 */
@RestController
public class CourseController {


    /**
     * 获取与当前用户相关联的课程列表
     *
     * @return
     */

    @RequestMapping(value = "course", method = RequestMethod.GET)
    public List<SimpleCourse> getCourses(HttpServletRequest request) {

        List<SimpleCourse> courses = MockDb.getCourseByUserID(request.getHeader("id"));
        return courses;
    }


    /**
     * 按ID获取课程
     */
    @RequestMapping(value = "/course/{courseId}", method = RequestMethod.GET)
    public SimpleCourse getCourseById(@PathVariable("courseId") Integer id) {
        SimpleCourse course = new SimpleCourse(id, "OOAD");
        course.setDescription("面向对象分析与设计");
        return course;
    }


    /**
     * 按课程ID获取课程的讨论课列表
     */
    @RequestMapping(value = "/course/{courseId}/seminar", method = RequestMethod.GET)
    public List<CourseSeminarOutput> getCourseSeminars(@PathVariable("courseId") Integer courseId) {
        return MockDb.getSeminarsByCourseId(courseId);
    }

    @RequestMapping(value = "/course/{courseId}/seminar/current", method = RequestMethod.GET)
    public SeminarForTeacher getSminar(@PathVariable Integer courseId) {
        SeminarForTeacher seminar = MockDb.getSeminarForTeacher(courseId);
        return seminar;
    }

    /**
     * 按课程ID获取课程的班级列表
     *
     * @param courseId
     * @return
     */
    @RequestMapping(value = "/course/{courseId}/class", method = RequestMethod.GET)
    public List<CourseClassOutput> getCourseClasses(@PathVariable("courseId") Integer courseId) {
        CourseClassOutput class1 = new CourseClassOutput(1, "周三1-2节");
        CourseClassOutput class2 = new CourseClassOutput(2, "周三3-4节");

        List<CourseClassOutput> classes = new LinkedList<CourseClassOutput>();

        classes.add(class1);
        classes.add(class2);

        return classes;
    }

}
