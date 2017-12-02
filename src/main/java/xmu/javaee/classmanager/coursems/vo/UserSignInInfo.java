package xmu.javaee.classmanager.coursems.vo;

import java.io.Serializable;

/**
 * Demo UserSignInInfo
 *
 * @author drafting_dreams
 * @date 2017/12/01
 */
public class UserSignInInfo implements Serializable {
    private String phone;
    private String password;

    public UserSignInInfo() {
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
}
