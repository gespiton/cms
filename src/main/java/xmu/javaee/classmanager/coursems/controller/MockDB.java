package xmu.javaee.classmanager.coursems.controller;

import xmu.javaee.classmanager.coursems.vo.UserBindingInfo;
import xmu.javaee.classmanager.coursems.vo.UserInfo;

import java.util.HashMap;
import java.util.Map;

public class MockDB {

    private static Map<Integer, UserInfo> users;

    static {
        users = new HashMap<>();
        users.put(0, new UserInfo(0, "teacher", "", "jwt", ""));
        users.put(1, new UserInfo(1, "student", "", "jwt", ""));
        users.put(2, new UserInfo(2, "student", "", "jwt", ""));
        users.put(3, new UserInfo(3, "student", "", "jwt", ""));
    }


    public static UserInfo getUserInfo(UserBindingInfo userInfo) {
        // if user number is 0000, then this is a teacher.
        System.out.println(userInfo.number);
        UserInfo user = users.getOrDefault(userInfo.number, null);
        if (user != null) {
            user.setName(userInfo.name);
            user.setSchool(userInfo.school);
        }

        return user;
    }
}
