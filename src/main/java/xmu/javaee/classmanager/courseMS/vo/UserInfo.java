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
}
