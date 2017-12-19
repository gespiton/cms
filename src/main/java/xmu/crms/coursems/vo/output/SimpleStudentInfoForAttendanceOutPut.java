package xmu.crms.coursems.vo.output;

/**
 * Demo SimpleStudentInfoForAttendanceOutPut
 *
 * @author drafting_dreams
 * @date 2017/12/03
 */
public class SimpleStudentInfoForAttendanceOutPut {
    private Integer id;
    private String name;

    public SimpleStudentInfoForAttendanceOutPut() {}

    public SimpleStudentInfoForAttendanceOutPut(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
