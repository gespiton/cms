package xmu.crms.coursems.vo.input;

/**
 * Demo BindInput
 *
 * @author drafting_dreams
 * @date 2017/12/02
 */
public class BindInput {
    private String name;
    private String number;
    private BindInputSchool school;
    private String type;

    public BindInput(){}

    public BindInput(String name, String number, BindInputSchool bindInputSchool, String type) {
        this.name = name;
        this.number = number;
        this.school = bindInputSchool;
        this.type = type;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BindInputSchool getSchool() {
        return school;
    }

    public void setSchool(BindInputSchool school) {
        this.school = school;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
