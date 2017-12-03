package xmu.javaee.classmanager.coursems.vo.input;

/**
 * Demo BindInputSchool
 *
 * @author drafting_dreams
 * @date 2017/12/02
 */
public class BindInputSchool {
    private Integer id;
    private String name;

    public BindInputSchool() {
    }

    public BindInputSchool(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
