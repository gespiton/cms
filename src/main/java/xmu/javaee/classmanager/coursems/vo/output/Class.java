
package xmu.javaee.classmanager.coursems.vo.output;


public class Class {

    private Integer id;
    private String name;
    private Integer numClass;
    private Integer numStudent;
    private String startTime;
    private String endTime;

    /**
     * No args constructor for use in serialization
     */
    public Class() {
    }

    /**
     * @param startTime
     * @param id
     * @param name
     * @param numClass
     * @param endTime
     * @param numStudent
     */
    public Class(Integer id, String name, Integer numClass, Integer numStudent, String startTime, String endTime) {
        super();
        this.id = id;
        this.name = name;
        this.numClass = numClass;
        this.numStudent = numStudent;
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

    public Integer getNumClass() {
        return numClass;
    }

    public void setNumClass(Integer numClass) {
        this.numClass = numClass;
    }

    public Integer getNumStudent() {
        return numStudent;
    }

    public void setNumStudent(Integer numStudent) {
        this.numStudent = numStudent;
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