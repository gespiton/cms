package xmu.javaee.classmanager.coursems.controller;

import org.springframework.web.bind.annotation.*;
import xmu.javaee.classmanager.coursems.vo.input.BindInput;
import xmu.javaee.classmanager.coursems.vo.output.User;
import xmu.javaee.classmanager.coursems.vo.output.UserSignInOutput;

import javax.servlet.http.HttpServletRequest;
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
     *
     * @param response
     * @return
     */
    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public UserSignInOutput signIn(HttpServletResponse response) {
        // TODO sign in service
        UserSignInOutput output = new UserSignInOutput(3486, "student", "张三",
                "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjaWQiOiJPQTAwMDEiLCJpYXQiOjE0ODI2NTcyODQyMjF9.TeJpy936w610Vrrm+c3+RXouCA9k1AX0Bk8qURkYkdo=");
        return output;
    }

    /**
     * 修改当前用户
     *
     * @param input
     * @param response
     */
    @PutMapping(value = "/me")
    public void bind(@RequestBody BindInput input, HttpServletResponse response) {
        User user = MockDb.getUserInfo(input);
        if (user == null) {
            System.out.println("bind fail");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        } else {
            System.out.println("bind success");
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            response.setHeader("id", String.valueOf(user.getId()));
        }
    }


    /**
     * 获取当前用户
     *
     * @return
     */
    @RequestMapping(value = "me")
    public User getOwn(HttpServletRequest request) {
        User user = MockDb.getUserInfo(request.getHeader("id"));
        return user;
    }
}
