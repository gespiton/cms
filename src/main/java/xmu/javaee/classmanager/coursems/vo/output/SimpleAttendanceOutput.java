package xmu.javaee.classmanager.coursems.vo.output;

/**
 * Demo SimpleAttendanceOutput
 *
 * @author drafting_dreams
 * @date 2017/12/03
 */
public class SimpleAttendanceOutput {
    private Integer present;
    private Integer absent;

    public SimpleAttendanceOutput() {}

    public SimpleAttendanceOutput(Integer present, Integer absent) {
        this.present = present;
        this.absent = absent;
    }


    public Integer getPresent() {
        return present;
    }

    public void setPresent(Integer present) {
        this.present = present;
    }

    public Integer getAbsent() {
        return absent;
    }

    public void setAbsent(Integer absent) {
        this.absent = absent;
    }
}
