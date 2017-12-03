package xmu.javaee.classmanager.coursems.vo.output;

import java.util.List;

public class Group {

    private Integer id;
    private Leader leader;
    private List<GroupMember> members = null;
    private List<Topic> topics = null;
    private String report;

    /**
     * No args constructor for use in serialization
     */
    public Group() {
    }

    /**
     * @param id
     * @param topics
     * @param leader
     * @param report
     * @param GroupMembers
     */
    public Group(Integer id, Leader leader, List<GroupMember> GroupMembers, List<Topic> topics, String report) {
        super();
        this.id = id;
        this.leader = leader;
        this.members = GroupMembers;
        this.topics = topics;
        this.report = report;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Leader getLeader() {
        return leader;
    }

    public void setLeader(Leader leader) {
        this.leader = leader;
    }

    public List<GroupMember> getMembers() {
        return members;
    }

    public void setMembers(List<GroupMember> GroupMembers) {
        this.members = GroupMembers;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }
}