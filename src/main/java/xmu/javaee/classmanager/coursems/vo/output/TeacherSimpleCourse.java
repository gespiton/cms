package xmu.javaee.classmanager.coursems.vo.output;

/**
 * Demo TeacherSimpleCourse
 *
 * @author drafting_dreams
 * @date 2017/12/02
 */
public class TeacherSimpleCourse {
    private Integer id;
    private String name;
    private String description;

    public TeacherSimpleCourse(){}
    public TeacherSimpleCourse(Integer id, String name) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
