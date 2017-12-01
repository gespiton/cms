package xmu.javaee.classmanager.coursems.vo;

/**
 * Demo TeacherInfo
 *
 * @author drafting_dreams
 * @date 2017/12/01
 */
public class TeacherInfo {
    private int id;
    String type = "teacher";
    String name;
    String number;
    String avator;


    public TeacherInfo(int id, String type, String name, String number, String avator) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.number = number;
        this.avator = avator;
    }
}
