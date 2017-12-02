package xmu.javaee.classmanager.coursems.vo;

/**
 * Demo UserInfo
 *
 * @author drafting_dreams
 * @date 2017/12/01
 */
public class UserInfo {
    private int id;
    private String userType;
    private String name;
    private String jwt="";
    private String school="";

    public UserInfo(int id, String userType, String name, String jwt, String school) {
        this.id = id;
        this.userType = userType;
        this.name = name;
        this.jwt = jwt;
        this.school = school;
    }

    public UserInfo(int id, String userType, String name, String jwt) {
        this.id = id;
        this.userType = userType;
        this.name = name;
        this.jwt = jwt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
