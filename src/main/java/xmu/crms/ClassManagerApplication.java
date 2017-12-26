package xmu.crms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * @author: Sher
 */
@SpringBootApplication
@MapperScan(basePackages = {"xmu.crms.mapper"})

public class ClassManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClassManagerApplication.class, args);
    }
}
