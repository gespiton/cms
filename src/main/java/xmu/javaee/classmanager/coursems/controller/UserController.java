package xmu.javaee.classmanager.coursems.controller;

import org.springframework.web.bind.annotation.*;
import xmu.javaee.classmanager.coursems.vo.input.BindInput;
import xmu.javaee.classmanager.coursems.vo.output.UserSignInOutput;
import xmu.javaee.classmanager.coursems.vo.input.UserSignInInput;

import javax.servlet.http.HttpServletResponse;

/**
 * Demo UserController
 *
 * @author drafting_dreams
 * @date 2017/12/01
 */
@RestController
public class UserController {

//    @PutMapping(value = "/me")
//    public void bindWX(@RequestBody UserBindingInfo userInfo, HttpServletResponse response) {
//        UserInfo user = MockDb.getUserInfo(userInfo);
//        if (user == null) {
//            System.out.println("bind fail");
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//
//        } else {
//            System.out.println("bind success");
//            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
//            response.setHeader("id", String.valueOf(user.getId()));
//        }
//    }


    @RequestMapping(value="/signin", method=RequestMethod.POST)
    public UserSignInOutput signIn(@RequestBody UserSignInInput input, HttpServletResponse response) {
        // TODO sign in service
        UserSignInOutput output = new UserSignInOutput(3486,"student","张三",
                "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjaWQiOiJPQTAwMDEiLCJpYXQiOjE0ODI2NTcyODQyMjF9.TeJpy936w610Vrrm+c3+RXouCA9k1AX0Bk8qURkYkdo=");
        return output;
    }

    @RequestMapping(value="/me", method=RequestMethod.PUT)
    public void bind(@RequestBody BindInput input, HttpServletResponse response){
        response.setStatus(204);
    }

}
