package xmu.javaee.classmanager.coursems.vo.output;

public class Topic {

    private Integer id;
    private String name;

    /**
     * No args constructor for use in serialization
     */
    public Topic() {
    }

    /**
     * @param id
     * @param name
     */
    public Topic(Integer id, String name) {
        super();
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
