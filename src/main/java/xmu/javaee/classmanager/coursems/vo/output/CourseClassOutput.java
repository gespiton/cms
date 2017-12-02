package xmu.javaee.classmanager.coursems.vo.output;


/**
 * Demo CourseClassOutput
 *
 * @author drafting_dreams
 * @date 2017/12/02
 */
public class CourseClassOutput {
    private Integer id;
    private String name;

    public CourseClassOutput() {}

    public CourseClassOutput(Integer id, String name) {
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
