package xmu.javaee.classmanager.coursems.vo.output;

/**
 * Demo CourseSeminarOutput
 *
 * @author drafting_dreams
 * @date 2017/12/02
 */
public class CourseSeminarOutput {
    private Integer id;
    private String name;
    private String description;
    private String groupingMethod;
    private String startTime;
    private String endTime;

    public CourseSeminarOutput() {}

    public CourseSeminarOutput(Integer id, String name, String description, String groupingMethod, String startTime, String endTime) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.groupingMethod = groupingMethod;
        this.startTime = startTime;
        this.endTime = endTime;
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

    public String getGroupingMethod() {
        return groupingMethod;
    }

    public void setGroupingMethod(String groupingMethod) {
        this.groupingMethod = groupingMethod;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
