package xmu.javaee.classmanager.coursems.vo.output;

/**
 * Demo SimpleAttendanceOutput
 *
 * @author drafting_dreams
 * @date 2017/12/03
 */
public class SimpleAttendanceOutput {
    private Integer numPresent;
    private Integer numStudent;

    public SimpleAttendanceOutput() {
    }

    public SimpleAttendanceOutput(Integer numPresent, Integer numStudent) {
        this.numPresent = numPresent;
        this.numStudent = numStudent;
    }


    public void setNumPresent(Integer numPresent) {
        this.numPresent = numPresent;
    }

    public Integer getNumStudent() {
        return numStudent;
    }

    public void setNumStudent(Integer numStudent) {
        this.numStudent = numStudent;
    }

    public Integer getNumPresent() {
        return numPresent;
    }
}
