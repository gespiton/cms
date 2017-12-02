package xmu.javaee.classmanager.coursems.controller;

import org.springframework.web.bind.annotation.*;
import xmu.javaee.classmanager.coursems.model.Course;
import xmu.javaee.classmanager.coursems.vo.input.BindInputSchool;
import xmu.javaee.classmanager.coursems.vo.output.CourseClassOutput;
import xmu.javaee.classmanager.coursems.vo.output.CourseSeminarOutput;
import xmu.javaee.classmanager.coursems.vo.output.TeacherInfoOutput;
import xmu.javaee.classmanager.coursems.vo.output.TeacherSimpleCourse;

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
     * @return
     */
    @RequestMapping(value = "course", method = RequestMethod.GET)
    public List<TeacherSimpleCourse> getCourses(){
        TeacherSimpleCourse course1 = new TeacherSimpleCourse(1,"J2EE");
        TeacherSimpleCourse course2 = new TeacherSimpleCourse(2,"OOAD");
        TeacherSimpleCourse course3 = new TeacherSimpleCourse(3,"操作系统");
        TeacherSimpleCourse course4 = new TeacherSimpleCourse(4,"数据仓库");
        List courses = new LinkedList<TeacherSimpleCourse>();
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        courses.add(course4);

        return courses;
    }

    /**
     * 创建课程
     * @param id
     * @return
     */
    @RequestMapping(value = "course", method = RequestMethod.POST)
    // TODO

    /**
     * 按ID获取课程
     */
    @RequestMapping(value = "/course/{courseId}", method = RequestMethod.GET)
    public TeacherSimpleCourse getCourseById(@PathVariable("courseId") Integer id){
        TeacherSimpleCourse course = new TeacherSimpleCourse(id, "OOAD");
        course.setDescription("面向对象分析与设计");
        return course;
    }

    /**
     * 按ID修改课程
     * @param courseId
     * @return
     */
    @RequestMapping(value = "/course/{courseId}", method = RequestMethod.PUT)
    // TODO

    /**
     * 按ID删除课程
     */
    @RequestMapping(value = "/course/{courseId}", method = RequestMethod.DELETE)
    //TODO

    /**
     * 按课程ID获取课程的讨论课列表
     */
    @RequestMapping(value = "/course/{courseId}/seminar", method = RequestMethod.GET)
    public List<CourseSeminarOutput> getCourseSeminars(@PathVariable("courseId") Integer courseId) {
        CourseSeminarOutput seminar1 = new CourseSeminarOutput(29,"界面原型设计",
        "界面原型设计","fixed","2017-09-25","2017-10-09");

        CourseSeminarOutput seminar2 = new CourseSeminarOutput(32,"概要设计","模型层与数据库设计",
                "fixed","2017-10-10","2017-10-24");

        List<CourseSeminarOutput> seminars = new LinkedList<CourseSeminarOutput>();
        seminars.add(seminar1);
        seminars.add(seminar2);

        return seminars;
    }

    /**
     * 在指定ID的课程创建讨论课
     * @param courseId
     * @return
     */
    @RequestMapping(value = "/course/{courseId}/seminar", method = RequestMethod.POST)

    /**
     * 按课程ID获取课程的班级列表
     * @param courseId
     * @return
     */
    @RequestMapping(value = "/course/{courseId}/class", method = RequestMethod.GET)
    public List<CourseClassOutput> getCourseClasses(@PathVariable("courseId") Integer courseId) {
        CourseClassOutput class1 = new CourseClassOutput(45,"周三1-2节");
        CourseClassOutput class2 = new CourseClassOutput(48,"周三3-4节");

        List<CourseClassOutput> classes = new LinkedList<CourseClassOutput>();

        classes.add(class1);
        classes.add(class2);

        return classes;

    }

    /**
     * 在指定ID的课程创建班级
     */
    @RequestMapping(value = "/course/{courseId}/class", method = RequestMethod.POST)
}
