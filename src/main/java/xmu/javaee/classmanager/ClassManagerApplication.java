package xmu.javaee.classmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: Sher
 */
@SpringBootApplication
@MapperScan("xmu.javaee.classmanager.coursems.dao")
public class ClassManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClassManagerApplication.class, args);
    }
}
