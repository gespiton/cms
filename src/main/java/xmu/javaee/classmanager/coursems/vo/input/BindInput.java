package xmu.javaee.classmanager.coursems.vo.input;

/**
 * Demo BindInput
 *
 * @author drafting_dreams
 * @date 2017/12/02
 */
public class BindInput {
    private String name;
    private String number;
    private BindInputSchool inputSchool;
    private String type;

    public BindInput(){}

    public BindInput(String name, String number, BindInputSchool bindInputSchool, String type) {
        this.name = name;
        this.number = number;
        this.inputSchool = bindInputSchool;
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

    public BindInputSchool getInputSchool() {
        return inputSchool;
    }

    public void setInputSchool(BindInputSchool inputSchool) {
        this.inputSchool = inputSchool;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
