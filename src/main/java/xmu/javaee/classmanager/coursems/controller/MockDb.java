package xmu.javaee.classmanager.coursems.controller;

import xmu.javaee.classmanager.coursems.vo.output.Class;

import xmu.javaee.classmanager.coursems.vo.input.BindInput;
import xmu.javaee.classmanager.coursems.vo.output.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: sher
 */
public class MockDb {

    private static Map<Integer, User> users;

    private static List<Class> classes;

    static {
        users = new HashMap<>();
        users.put(0, new User(0, "teacher", "Mr.wang", "schoolxxx", "110"));
        users.put(1, new User(1, "student", "stu1", "university", "1123"));
        users.put(2, new User(2, "student", "stu2", "university", "123"));
        users.put(3, new User(3, "student", "stu3", "university", "11333"));


        classes = new ArrayList<>();
        classes.add(new Class(1, "OOAD", 2, 20, "2017-10-10", "2018-1-1"));
        classes.add(new Class(2, "JavaEE", 1, 20, "2017-10-10", "2017-10-11"));
    }


    static User getUserInfo(BindInput userInfo) {
        // if user number is 0000, then this is a teacher.
        User user = users.getOrDefault(Integer.valueOf(userInfo.getNumber()), null);
        if (user != null) {
            user.setName(userInfo.getName());
            user.setSchool(userInfo.getSchool());
        }
        return user;
    }

    static User getUserInfo(String id) {
        User user = users.get(Integer.valueOf(id));
        assert (user != null);
        return user;
    }

    public static List<Class> getClassesByUserId(String id) {
        return classes;
    }
}
