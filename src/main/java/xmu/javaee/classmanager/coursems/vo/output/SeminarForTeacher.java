package xmu.javaee.classmanager.coursems.vo.output;

import java.util.List;

public class SeminarForTeacher {
    private Integer id;
    private String name;
    private String courseName;
    private String startTime;
    private String groupingMethod;
    private String endTime;
    private List<Class> classes;

    public SeminarForTeacher() {
    }

    public SeminarForTeacher(Integer id, String name, String courseName,
                             String groupingMethod, String startTime, String endTime) {
        this.id = id;
        this.name = name;
        this.courseName = courseName;
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

    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
