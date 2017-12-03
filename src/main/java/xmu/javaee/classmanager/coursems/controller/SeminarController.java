package xmu.javaee.classmanager.coursems.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xmu.javaee.classmanager.coursems.vo.output.SimpleAttendanceOutput;
import xmu.javaee.classmanager.coursems.vo.output.SimpleGroupIdOutput;
import xmu.javaee.classmanager.coursems.vo.output.SimpleStudentInfoForAttendanceOutPut;
import xmu.javaee.classmanager.coursems.vo.output.Topic;

import java.util.LinkedList;
import java.util.List;

/**
 * Demo SeminarController
 *
 * @author drafting_dreams
 * @date 2017/12/03
 */
@RestController
public class SeminarController {
    @RequestMapping(value = "/seminar/{seminarId}/class/{classId}/attendance")
    public SimpleAttendanceOutput getAttendance() {
        SimpleAttendanceOutput attendance = new SimpleAttendanceOutput(40,60);
        return attendance;
    }

    @RequestMapping(value = "/seminar/{seminarId}/class/{classId}/attendance/present")
    public List<SimpleStudentInfoForAttendanceOutPut> getPresentStudents() {
        SimpleStudentInfoForAttendanceOutPut student1 = new SimpleStudentInfoForAttendanceOutPut(2357,"张三");
        SimpleStudentInfoForAttendanceOutPut student2 = new SimpleStudentInfoForAttendanceOutPut(8232,"李四");

        List<SimpleStudentInfoForAttendanceOutPut> students = new LinkedList<SimpleStudentInfoForAttendanceOutPut>();

        students.add(student1);
        students.add(student2);

        return students;
    }

    @RequestMapping(value = "/seminar/{seminarId}/class/{classId}/attendance/late")
    public List<SimpleStudentInfoForAttendanceOutPut> getLateStudents() {
        SimpleStudentInfoForAttendanceOutPut student1 = new SimpleStudentInfoForAttendanceOutPut(3412,"王五");
        SimpleStudentInfoForAttendanceOutPut student2 = new SimpleStudentInfoForAttendanceOutPut(5234,"王七九");

        List<SimpleStudentInfoForAttendanceOutPut> students = new LinkedList<SimpleStudentInfoForAttendanceOutPut>();

        students.add(student1);
        students.add(student2);

        return students;
    }

    @RequestMapping(value = "/seminar/{seminarId}/class/{classId}/attendance/absent")
    public List<SimpleStudentInfoForAttendanceOutPut> getAbsentStudents() {
        SimpleStudentInfoForAttendanceOutPut student1 = new SimpleStudentInfoForAttendanceOutPut(34,"张六");

        List<SimpleStudentInfoForAttendanceOutPut> students = new LinkedList<SimpleStudentInfoForAttendanceOutPut>();

        students.add(student1);

        return students;
    }

    /**
     * 按照讨论课id查询讨论课列表
     * @return group contains current user only !
     */
    @RequestMapping(value = "/seminar/{seminarId}/group")
    public List<SimpleGroupIdOutput> getSeminarGroups() {
        // this id has to be one to work -- couple with MockDb
        SimpleGroupIdOutput group = new SimpleGroupIdOutput(1);
        List<SimpleGroupIdOutput> groups = new LinkedList<>();
        groups.add(group);
        return groups;
    }

    /**
     * 根据 seminar id 获取 topics
     * @return topics
     */
    @RequestMapping(value = "/seminar/{seminarID}/topic")
    public List<Topic> getTopics(){
        List<Topic> topics = MockDb.getTopics();
        return topics;
    }



}
