package xmu.crms.controller;


import org.springframework.web.bind.annotation.*;
import xmu.crms.coursems.vo.output.ClassDetailOutput;
import xmu.crms.coursems.vo.output.Proportions;

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
    @RequestMapping(value = "/class/{classId}")
    public ClassDetailOutput getClassById(@PathVariable Integer classId) {
        Proportions proportions = new Proportions(50, 50, 20, 60, 20);
        ClassDetailOutput output = new ClassDetailOutput(1, "周三12节", 120, "周三 一二节",
                "海韵201", -1,
                "/roster/周三12班.xlsx", proportions);

        ClassDetailOutput output2 = new ClassDetailOutput(2, "周三34节", 120, "周三 三四节",
                "海韵201", -1,
                "/roster/周三12班.xlsx", proportions);

        if (classId == 1) {
            return output;
        } else {
            return output2;
        }
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
