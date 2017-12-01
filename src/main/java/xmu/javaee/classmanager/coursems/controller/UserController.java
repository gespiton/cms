package xmu.javaee.classmanager.coursems.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import xmu.javaee.classmanager.coursems.vo.UserInfo;
import xmu.javaee.classmanager.coursems.vo.UserSignInInfo;

/**
 * Demo UserController
 *
 * @author drafting_dreams
 * @date 2017/12/01
 */
@RestController
public class UserController {
    @RequestMapping(value="/signin", method = RequestMethod.POST)
    public UserInfo signIn(@RequestBody UserSignInInfo userSignIn){
        // TODO sign in service
        return new UserInfo(3486, "student", "杰克", "j23oji09.jioas9.ViaoU9o");
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public UserInfo register(@RequestBody UserSignInInfo userSignIn){
        // TODO register service
        return new UserInfo(3476, "unbined", "雷吉斯", "j2loji09.jioas9.qrP6oU9o");
    }

    @RequestMapping(value="/me", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void bind(@RequestBody UserInfo bindInfo){
        // TODO bind user info service
    }
}
