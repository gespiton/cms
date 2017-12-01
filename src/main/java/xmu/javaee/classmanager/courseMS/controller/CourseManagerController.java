package xmu.javaee.classmanager.courseMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xmu.javaee.classmanager.courseMS.CourseRepo;
import xmu.javaee.classmanager.courseMS.model.Course;

import java.util.List;

@RestController
@RequestMapping("api/v1/courses/")
public class CourseManagerController {
    private final CourseRepo courseRepo;

    @Autowired
    public CourseManagerController(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    @ResponseBody
    public String addCourse(@RequestParam String name) {
        Course course = new Course();
        course.setName(name);
        courseRepo.save(course);
        return "saved";
    }


    @GetMapping(value = "getAll")
    public List<Course> getAllCourses() {
        return (List<Course>) courseRepo.findAll();
    }

}
