package xmu.crms.coursems.vo.input;


import java.io.Serializable;

/**
 * Demo UserSignInInput
 *
 * @author drafting_dreams
 * @date 2017/12
 */
public class UserSignInInput implements Serializable{
    private String phone;
    private String password;
    public UserSignInInput(){}
    public UserSignInInput(String phone, String password) {
        this.phone = phone;
        this.password = password;
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

