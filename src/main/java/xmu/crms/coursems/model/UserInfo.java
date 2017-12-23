package xmu.crms.coursems.model;

import xmu.crms.coursems.vo.input.BindInputSchool;

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
    private String jwt = "";
    private BindInputSchool school;
    private String phone;
    private String password;

    public UserInfo(int i, String userType, String name, String jwt, String school, String phone, String password) {
        this.id = i;
        this.userType = userType;
        this.name = name;
        this.school = new BindInputSchool(1,school);
        this.phone = phone;
        this.password = password;
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


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BindInputSchool getSchool() {
        return school;
    }

    public void setSchool(BindInputSchool school) {
        this.school = school;
    }
}
