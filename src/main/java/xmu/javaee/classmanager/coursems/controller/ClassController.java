package xmu.javaee.classmanager.coursems.controller;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xmu.javaee.classmanager.coursems.vo.output.ClassDetailOutput;
import xmu.javaee.classmanager.coursems.vo.output.Proportions;

import javax.servlet.http.HttpServletResponse;

/**
 * Demo ClassController
 *
 * @author drafting_dreams
 * @date 2017/12/03
 */
@RestController
public class ClassController {
    /**
     * 按班级ID获取班级详情
     *
     * @return
     */
    @RequestMapping(value = "/class/{classId}", method = RequestMethod.GET)
    public ClassDetailOutput getClassById() {
        Proportions proportions = new Proportions(50, 50, 20, 60, 20);
        ClassDetailOutput output = new ClassDetailOutput(1, "周三12节", 120, "周三 一二节",
                "海韵201", -1,
                "/roster/周三12班.xlsx", proportions);
        return output;
    }

    /**
     * 按ID修改班级
     * 可以用于修改签到状态和其他班级信息
     *
     * @param input
     * @param response
     */
    @RequestMapping(value = "class/{classId}", method = RequestMethod.PUT)
    public void modifyClassById(@RequestBody ClassDetailOutput input, HttpServletResponse response) {
        response.setStatus(204);
    }
}
