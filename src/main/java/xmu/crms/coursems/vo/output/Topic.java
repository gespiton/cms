package xmu.crms.coursems.vo.output;

public class Topic {

    private Integer id;
    private String name;
    private String description;
    private Integer groupLimit;
    private Integer groupLeft;

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

    public Topic(Integer id, String name, String description, Integer groupLimit, Integer groupLeft) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.groupLimit = groupLimit;
        this.groupLeft = groupLeft;
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

    public Integer getGroupLimit() {
        return groupLimit;
    }

    public void setGroupLimit(Integer groupLimit) {
        this.groupLimit = groupLimit;
    }

    public Integer getGroupLeft() {
        return groupLeft;
    }

    public void setGroupLeft(Integer groupLeft) {
        this.groupLeft = groupLeft;
    }
}
