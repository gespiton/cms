package xmu.crms.exception;
/**
 * @author caistrong
 */
public class CourseNotFoundException extends Exception {
    public CourseNotFoundException(){
        System.out.println("没有找到相应课程");
    }
}
