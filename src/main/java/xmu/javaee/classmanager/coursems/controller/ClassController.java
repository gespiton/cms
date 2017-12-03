package xmu.javaee.classmanager.coursems.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xmu.javaee.classmanager.coursems.vo.output.Class;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author shin
 */
@RestController
public class ClassController {
    @RequestMapping(value = "/class")
    public List<Class> getClasses(HttpServletRequest request) {
        List<Class> classes = MockDb.getClassesByUserId(request.getHeader("id"));
        return classes;
    }
}
