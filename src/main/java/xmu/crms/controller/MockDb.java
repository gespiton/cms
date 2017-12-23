package xmu.crms.controller;

import xmu.crms.coursems.vo.input.BindInput;
import xmu.crms.coursems.vo.output.*;
import xmu.crms.coursems.vo.output.Class;

import java.util.*;

/**
 * @author: sher
 */
public class MockDb {

    private static Map<Integer, User> users;

    private static List<SimpleCourse> courses;

    private static Map<Integer, Group> fixedGroups;

    private static List<Topic> topics;

    private static Map<Integer, Topic> topicMap;

    private static SeminarForTeacher seminarForTeacher;

    static {
        users = new HashMap<>();
        users.put(0, new User(0, "teacher", "Mr.wang", "schoolxxx", "110"));
        users.put(1, new User(1, "student", "stu1", "university", "1123"));
        users.put(2, new User(2, "student", "stu2", "university", "123"));
        users.put(3, new User(3, "student", "stu3", "university", "11333"));


        courses = new ArrayList<>();
        courses.add(new SimpleCourse(1, "J2EE"));
        courses.add(new SimpleCourse(2, "OOAD"));
        courses.add(new SimpleCourse(3, "操作系统"));

        fixedGroups = new HashMap<>();

        // topics array
        topics = new ArrayList<>();
        topics.add(new Topic(0, "领域模型", "Domain model与模块划分", 5, 3));
        topics.add(new Topic(1, "package 划分", "用rest 风格 划分packge", 5, 3));
        topics.add(new Topic(3, "ux design", "讨论 user experience design", 5, 0));

        // topic map
        topicMap = new HashMap<>();
        topics.forEach(topic -> topicMap.put(topic.getId(), topic));


        // seminar for teacher
        seminarForTeacher = new SeminarForTeacher(1, "界面原型设计", "OOAD", "fixed", "2017-09-25", "2017-12-09");
        List<Class> classes = new ArrayList<>();
        classes.add(new Class(1, "周三 12"));
        classes.add(new Class(2, "周三 34"));
        seminarForTeacher.setClasses(classes);
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

    static List<SimpleCourse> getCourseByUserID(String id) {
        return courses;
    }

    static List<CourseSeminarOutput> getSeminarsByCourseId(Integer courseID) {

        CourseSeminarOutput seminar1 = new CourseSeminarOutput(1, "界面原型设计",
                "界面原型设计", "fixed", "2017-09-25", "2017-12-09");

        CourseSeminarOutput seminar2 = new CourseSeminarOutput(2, "概要设计", "模型层与数据库设计",
                "random", "2017-10-10", "2017-12-24");

        List<CourseSeminarOutput> seminars = new LinkedList<>();
        seminars.add(seminar1);
        seminars.add(seminar2);
        return seminars;
    }

    static Group getGroupWithID(Integer groupID, String id) {

        if (fixedGroups.get(groupID) != null) {
            return fixedGroups.get(groupID);
        }

        Group group = new Group();
        List<GroupMember> groupMembers = new ArrayList<>();
        groupMembers.add(new GroupMember(1, users.get(1).getName()));
        groupMembers.add(new GroupMember(2, users.get(2).getName()));
        groupMembers.add(new GroupMember(3, users.get(3).getName()));
        group.setId(groupID);
        group.setMembers(groupMembers);

        fixedGroups.put(groupID, group);

        return group;
    }

    static boolean modifyGroup(Integer groupID, Group group) {
        Group currentGroup = fixedGroups.get(groupID);

        Leader leader = group.getLeader();
        if (leader != null) {
            leader.setName(users.get(leader.getId()).getName());
        }

        currentGroup.setLeader(leader);
        currentGroup.setMembers(group.getMembers());
        return true;
    }

    static List<Topic> getTopics() {
        return topics;
    }

    static boolean chooseTopic(Integer groupID, Topic topic) {
        Group group = fixedGroups.get(groupID);


        List<Topic> choosenTopics = new ArrayList<>();
        if (group.getTopics() != null) {
            choosenTopics = group.getTopics();
        }

        topic = topicMap.get(topic.getId());

        topic.setGroupLeft(topic.getGroupLeft() - 1);
        choosenTopics.add(topicMap.get(topic.getId()));

        group.setTopics(choosenTopics);
        return true;
    }

    static SeminarForTeacher getSeminarForTeacher(Integer courseID) {
        if (courseID != 1) {
            seminarForTeacher.setGroupingMethod("random");
        } else {
            seminarForTeacher.setGroupingMethod("fixed");
        }
        return seminarForTeacher;
    }
}
