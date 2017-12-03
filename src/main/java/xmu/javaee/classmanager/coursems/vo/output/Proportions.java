package xmu.javaee.classmanager.coursems.vo.output;

/**
 * Demo Proportions
 *
 * @author drafting_dreams
 * @date 2017/12/03
 */
public class Proportions {
    private Integer report;
    private Integer presentation;
    private Integer a;
    private Integer b;
    private Integer c;

    public Proportions() {}

    public Proportions(Integer report, Integer presentation, Integer a, Integer b, Integer c) {
        this.report = report;
        this.presentation = presentation;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Integer getReport() {
        return report;
    }

    public void setReport(Integer report) {
        this.report = report;
    }

    public Integer getPresentation() {
        return presentation;
    }

    public void setPresentation(Integer presentation) {
        this.presentation = presentation;
    }

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    public Integer getC() {
        return c;
    }

    public void setC(Integer c) {
        this.c = c;
    }
}
