package xmu.javaee.classmanager.coursems.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import xmu.javaee.classmanager.coursems.vo.UserBindingInfo;
import xmu.javaee.classmanager.coursems.vo.UserInfo;
import xmu.javaee.classmanager.coursems.vo.UserSignInInfo;

import javax.servlet.http.HttpServletResponse;

/**
 * Demo UserController
 *
 * @author drafting_dreams
 * @date 2017/12/01
 */
@RestController
public class UserController {

    @PutMapping(value = "/me")
    public UserInfo bind(@RequestBody UserBindingInfo userInfo, HttpServletResponse response) {
        UserInfo user = MockDB.getUserInfo(userInfo);
        if (user == null) {
            System.out.println("bind fail");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        } else {
            System.out.println("bind success");
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            response.setHeader("id", String.valueOf(user.getId()));
            return user;
        }
    }

    @PostMapping(value = "/signin")
    public UserInfo signIn(@RequestBody UserSignInInfo userSignIn) {
        // TODO sign in service
        return new UserInfo(3486, "student", "杰克", "j23oji09.jioas9.ViaoU9o");
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public UserInfo register(@RequestBody UserSignInInfo userSignIn) {
        // TODO register service
        return new UserInfo(3476, "unbined", "雷吉斯", "j2loji09.jioas9.qrP6oU9o");
    }

}
