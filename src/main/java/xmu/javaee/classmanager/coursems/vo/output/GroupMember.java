package xmu.javaee.classmanager.coursems.vo.output;

public class GroupMember {

    private Integer id;
    private String name;

    /**
     * No args constructor for use in serialization
     */
    public GroupMember() {
    }

    /**
     * @param id
     * @param name
     */
    public GroupMember(Integer id, String name) {
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
