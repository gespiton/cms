package xmu.javaee.classmanager.coursems.vo.output;

/**
 * Demo UserSignInOutput
 *
 * @author drafting_dreams
 * @date 2017/12/02
 */
public class UserSignInOutput {
    private  int id;
    private String type;
    private String name;
    private String jwt;
    public UserSignInOutput(){}
    public UserSignInOutput(int id, String type, String name, String jwt) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.jwt = jwt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
}
