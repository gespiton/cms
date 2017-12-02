package xmu.javaee.classmanager.coursems.controller;

import org.springframework.web.bind.annotation.*;
import xmu.javaee.classmanager.coursems.vo.input.BindInputSchool;
import xmu.javaee.classmanager.coursems.vo.output.TeacherInfoOutput;

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

    @RequestMapping(value = "me", method = RequestMethod.GET)
    public TeacherInfoOutput getOwn() {
        BindInputSchool school = new BindInputSchool(32, "厦门大学");

        TeacherInfoOutput output = new TeacherInfoOutput(3486, "teacher","张三", "24321432534",
                "18159215806", "23320152202333@stu.xmu.edu.cn", "male", school, "教授",
                "/avatar/3486.png");
        return output;
    }
}
