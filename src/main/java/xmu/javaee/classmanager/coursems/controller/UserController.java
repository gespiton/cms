package xmu.javaee.classmanager.coursems.controller;

import org.springframework.web.bind.annotation.*;
import xmu.javaee.classmanager.coursems.vo.input.BindInput;
import xmu.javaee.classmanager.coursems.vo.input.BindInputSchool;
import xmu.javaee.classmanager.coursems.vo.output.TeacherInfoOutput;
import xmu.javaee.classmanager.coursems.vo.output.UserSignInOutput;

import javax.servlet.http.HttpServletResponse;

/**
 * Demo UserController
 *
 * @author drafting_dreams
 * @date 2017/12/01
 */
@RestController
public class UserController {


    /**
     * 微信小程序/OAuth2登录
     * @param response
     * @return
     */
    @RequestMapping(value="/signin", method=RequestMethod.GET)
    public UserSignInOutput signIn(HttpServletResponse response) {
        // TODO sign in service
        UserSignInOutput output = new UserSignInOutput(3486,"student","张三",
                "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjaWQiOiJPQTAwMDEiLCJpYXQiOjE0ODI2NTcyODQyMjF9.TeJpy936w610Vrrm+c3+RXouCA9k1AX0Bk8qURkYkdo=");
        return output;
    }

    /**
     * 修改当前用户
     * @param input
     * @param response
     */
    @RequestMapping(value="/me", method=RequestMethod.PUT)
    public void bind(@RequestBody BindInput input, HttpServletResponse response){
        response.setStatus(204);
    }


    /**
     * 获取当前用户
     * @return
     */
    @RequestMapping(value = "me", method = RequestMethod.GET)
    public TeacherInfoOutput getOwn() {
        BindInputSchool school = new BindInputSchool(32, "厦门大学");

        TeacherInfoOutput output = new TeacherInfoOutput(3486, "teacher","张三", "24321432534",
                "18159215806", "23320152202333@stu.xmu.edu.cn", "male", school, "教授",
                "/avatar/3486.png");
        return output;
    }

}
